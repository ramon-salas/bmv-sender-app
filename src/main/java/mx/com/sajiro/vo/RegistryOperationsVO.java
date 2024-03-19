package mx.com.sajiro.vo;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;
import mx.com.sajiro.annotation.Order;

@Getter
@Setter
public class RegistryOperationsVO extends AbstractVO {

    /** The offer type. */
    @Order(1)
    @SerializedName("Offer Type")
    private char offerType;
    /** The income. */
    @Order(2)
    @SerializedName("Income")
    private char income;
    /** The value type. */
    @Order(3)
    @SerializedName("Value Type")
    private String valueType;
    /** The issuer. */
    @Order(4)
    @SerializedName("Issuer")
    private String issuer;
    /** The series. */
    @Order(5)
    @SerializedName("Series")
    private String series;
    /** The maximum value. */
    @Order(6)
    @SerializedName("Maximum Volume")
    private long maximumValue;
    /** The registered value. */
    @Order(7)
    @SerializedName("Registered Volume")
    private long registeredValue;
    /** The price rate. */
    @Order(8)
    @SerializedName("Price/Rate")
    private long priceRate;
    /** The settlement. */
    @Order(9)
    @SerializedName("Settlement Date")
    private long settlementDate;
    /** The firm. */
    @Order(10)
    @SerializedName("Firm")
    private String firm;
    /** The movement. */
    @Order(11)
    @SerializedName("Movement")
    private char movement;

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString().
     */
    @Override
    public String toString() {
        return super.toString(this, this.getClass());
    }

}
