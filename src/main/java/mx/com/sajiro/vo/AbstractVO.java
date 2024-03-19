package mx.com.sajiro.vo;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import mx.com.sajiro.annotation.Order;

@Getter
@Setter
public abstract class AbstractVO {

    /** the pipe separator. */
    protected static final String PIPE = "|";
    /** The type. */
    @SerializedName("Type")
    private char type;
    /** The instrumentId. */
    @SerializedName("Instrument Number")
    private int instrumentId;

    protected <E extends AbstractVO> String toString(final E instance,
            final Class<?> clazz) {
        BeanInfo beanInfo;
        try {
            beanInfo = Introspector.getBeanInfo(clazz);
        } catch (IntrospectionException e) {
            return null;
        }
        final var propertyDescriptors = beanInfo.getPropertyDescriptors();
        final var listVoProperties = Stream.of(propertyDescriptors)
                .filter(this::validateValidName).map(this::getterMethod)
                .filter(this::isGetterMethodNotNull)
                .map(getter -> convertMethodToPropertyVO(getter, instance))
                .sorted().toList();
        return toString(listVoProperties.stream().map(vo -> vo.getValue())
                .collect(Collectors.toList()).stream());
    }

    private boolean validateValidName(final PropertyDescriptor pd) {
        return !pd.getName().equalsIgnoreCase("class")
                && !pd.getName().equalsIgnoreCase("type")
                && !pd.getName().equalsIgnoreCase("instrumentId");
    }

    private ProeprtyDescriptorVO getterMethod(final PropertyDescriptor pd) {
        return new ProeprtyDescriptorVO(pd.getName(), pd.getReadMethod());
    }

    private boolean isGetterMethodNotNull(
            final ProeprtyDescriptorVO propertyDescriptorVO) {
        return propertyDescriptorVO.getGetterMethod() != null;
    }

    private <E extends AbstractVO> PropertyVO convertMethodToPropertyVO(
            final ProeprtyDescriptorVO propertyDescriptor, final E instance) {
        final var propertyVO = new PropertyVO();
        try {
            propertyVO.setOrder(getOrder(propertyDescriptor.getterMethod,
                    propertyDescriptor.getFieldName()));
            propertyVO.setValue(
                    propertyDescriptor.getGetterMethod().invoke(instance));
            return propertyVO;
        } catch (Exception e) {
            return null;
        }
    }

    private int getOrder(final Method getterMethod, final String fieldName)
            throws NoSuchFieldException, SecurityException {
        Class<?> beanClass = getterMethod.getDeclaringClass();
        Field field = beanClass.getDeclaredField(fieldName);
        field.setAccessible(Boolean.TRUE);
        for (var annotation : field.getAnnotations()) {
            if (annotation.annotationType() == Order.class) {
                return ((Order) annotation).value();
            }
        }
        return 0;
    }

    private String toString(final Stream<Object> properties) {
        final var messageBuilder = createGenericBuilder();
        properties.forEach(
                property -> messageBuilder.append(PIPE).append(property));

        return messageBuilder.toString();
    }

    private StringBuilder createGenericBuilder() {
        return new StringBuilder().append(type).append(PIPE)
                .append(instrumentId);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    class ProeprtyDescriptorVO {
        private String fieldName;
        private Method getterMethod;
    }

    @Getter
    @Setter
    @EqualsAndHashCode
    class PropertyVO implements Comparable<PropertyVO> {
        private int order;
        private Object value;

        @Override
        public int compareTo(PropertyVO other) {
            return Integer.compare(this.order, other.getOrder());
        }

    }

}
