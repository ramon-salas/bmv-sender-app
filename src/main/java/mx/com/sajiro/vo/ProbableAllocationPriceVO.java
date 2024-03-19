package mx.com.sajiro.vo;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;
import mx.com.sajiro.annotation.Order;

/**
 * VO del mensaje '2'.
 */
@Getter
@Setter
public class ProbableAllocationPriceVO extends AbstractVO {

    /** The probable price. */
    @Order(1)
    @SerializedName("Probable Allocation Price")
    private long probablePrice;
    /** The volume. */
    @Order(2)
    @SerializedName("Volume")
    private int volume;

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString().
     */
    @Override
    public String toString() {
        return super.toString(this, this.getClass());
    }
}
