package mx.com.sajiro.vo;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;
import mx.com.sajiro.annotation.Order;

@Getter
@Setter
public class WeightedAveragePriceVO extends AbstractVO {

    /** The wighted average price. */
    @Order(1)
    @SerializedName("Weighted Average Price")
    private long ppp;
    /** The volatility. */
    @Order(2)
    @SerializedName("Volatility")
    private long volatility;

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString().
     */
    @Override
    public String toString() {
        return super.toString(this, this.getClass());
    }

}
