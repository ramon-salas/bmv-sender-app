package mx.com.sajiro.vo;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;
import mx.com.sajiro.annotation.Order;

@Getter
@Setter
public class MutualFundTradeVO extends AbstractVO {

    /** Trade date. */
    @Order(1)
    @SerializedName("Trade Date")
    private long tradeDate;
    /** Price. */
    @Order(2)
    @SerializedName("Price")
    private long price;
    /** Book value. */
    @Order(3)
    @SerializedName("Block Value")
    private long bookValue;
    /** Number sales transactions. */
    @Order(4)
    @SerializedName("Number of Sales Transactions")
    private int numberSalesTransactions;
    /** Sales volume. */
    @Order(4)
    @SerializedName("Sales Volume")
    private long salesVolume;
    /** Number buy transactions. */
    @Order(5)
    @SerializedName("Number of Buy Transactions")
    private int numberBuyTransactions;
    /** Buy volume. */
    @Order(6)
    @SerializedName("Buy Volume")
    private long buyVolume;

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString().
     */
    @Override
    public String toString() {
        return super.toString(this, this.getClass());
    }
}
