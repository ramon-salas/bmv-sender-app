package mx.com.sajiro.vo;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;
import mx.com.sajiro.annotation.Order;

@Getter
@Setter
public class CapitalTradeVO extends AbstractVO {

    /** The trade time. */
    @Order(1)
    @SerializedName("Trade Time")
    private long tradeTime;
    /** The volue. */
    @Order(2)
    @SerializedName("Volume")
    private int volume;
    /** The price. */
    @Order(3)
    @SerializedName("Price")
    private long price;
    /** The conceration type. */
    @Order(4)
    @SerializedName("Concertation Type")
    private char concertationType;
    /** The trade number. */
    @Order(5)
    @SerializedName("Trade Number")
    private int tradeNumber;
    /** The price setter. */
    @Order(6)
    @SerializedName("Price Setter")
    private char priceSetter;
    /** The operation type. */
    @Order(7)
    @SerializedName("Operation Type")
    private char operationType;
    /** The amount. */
    @Order(8)
    @SerializedName("Amount")
    private long amount;
    /** The buy. */
    @Order(9)
    @SerializedName("Buy")
    private String buy;
    /** The sell. */
    @Order(10)
    @SerializedName("Sell")
    private String sell;
    /** The settlement. */
    @Order(11)
    @SerializedName("Settlement")
    private char settlement;
    /** The auction indicator. */
    @Order(12)
    @SerializedName("Auction Indicator")
    private char auctionIndicator;

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return super.toString(this, this.getClass());
    }

}
