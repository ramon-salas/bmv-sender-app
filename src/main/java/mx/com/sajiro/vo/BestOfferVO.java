package mx.com.sajiro.vo;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;
import mx.com.sajiro.annotation.Order;

@Getter
@Setter
public class BestOfferVO extends AbstractVO {

    /** Volume. */
    @Order(1)
    @SerializedName("Volume")
    private int volume;
    /** Price. */
    @Order(2)
    @SerializedName("Price/Rate")
    private long price;
    /** Side. */
    @Order(3)
    @SerializedName("Offer Direction")
    private char side;
    /** Operation type. */
    @Order(4)
    @SerializedName("Operation Type")
    private char operationType;

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString().
     */
    @Override
    public String toString() {
        return super.toString(this, this.getClass());
    }
}
