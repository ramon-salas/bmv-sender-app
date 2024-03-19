package mx.com.sajiro.vo;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;
import mx.com.sajiro.annotation.Order;

/**
 * VO del mensaje 'E'.
 */
@Getter
@Setter
public class TradabilityVO extends AbstractVO {

    /** Number operations. */
    @Order(1)
    @SerializedName("Number of Operations")
    private int numberOperations;
    /** Volume. */
    @Order(2)
    @SerializedName("Volume")
    private long volume;
    /** Amount. */
    @Order(3)
    @SerializedName("Amount")
    private long amount;
    /** Opening price. */
    @Order(4)
    @SerializedName("Opening Price")
    private long openingPrice;
    /** Maximum. */
    @Order(5)
    @SerializedName("Maximum")
    private long maximum;
    /** Minimum. */
    @Order(6)
    @SerializedName("Minimum")
    private long minimum;
    /** Average. */
    @Order(7)
    @SerializedName("Average")
    private long average;
    /** Last. */
    @Order(8)
    @SerializedName("Last")
    private long last;

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString().
     */
    @Override
    public String toString() {
        return super.toString(this, this.getClass());
    }
}
