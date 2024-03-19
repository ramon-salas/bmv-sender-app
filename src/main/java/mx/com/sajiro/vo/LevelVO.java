package mx.com.sajiro.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LevelVO {

    /** The price. */
    private long price;
    /** The number orders. */
    private short numberOrders;
    /** The volume. */
    private int volume;

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString().
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(price);
        builder.append(AbstractVO.PIPE);
        builder.append(numberOrders);
        builder.append(AbstractVO.PIPE);
        builder.append(volume);

        return builder.toString();
    }

}
