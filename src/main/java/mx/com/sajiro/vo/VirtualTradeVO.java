package mx.com.sajiro.vo;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;
import mx.com.sajiro.annotation.Order;

/**
 * VO del mensaje 'V'.
 */
@Getter
@Setter
public class VirtualTradeVO extends AbstractVO {

    /** Status. */
    @Order(1)
    @SerializedName("Status")
    private char status;
    /** Operation type. */
    @Order(2)
    @SerializedName("Operation Type")
    private char operationType;
    /** Number. */
    @Order(3)
    @SerializedName("Number")
    private int number;
    /** Volume. */
    @Order(4)
    @SerializedName("Volume")
    private int volume;
    /** Concertation. */
    @Order(5)
    @SerializedName("Concertation")
    private char concertation;
    /** Buy. */
    @Order(6)
    @SerializedName("Buy")
    private String buy;
    /** Sell. */
    @Order(7)
    @SerializedName("Sell")
    private String sell;

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString().
     */
    @Override
    public String toString() {
        return super.toString(this, this.getClass());
    }
}
