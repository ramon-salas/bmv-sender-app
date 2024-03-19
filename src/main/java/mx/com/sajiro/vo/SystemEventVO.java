package mx.com.sajiro.vo;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;
import mx.com.sajiro.annotation.Order;

@Getter
@Setter
public class SystemEventVO extends AbstractVO {

    /** The event code. */
    @Order(1)
    @SerializedName("Event Code")
    private char eventCode;
    /** The market. */
    @Order(2)
    @SerializedName("Market")
    private char market;
    /** The sending time. */
    @Order(3)
    @SerializedName("Sending Time")
    private long sendingTime;
    /** The ending time. */
    @Order(4)
    @SerializedName("Ending Time")
    private long endingTime;

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString().
     */
    @Override
    public String toString() {
        return super.toString(this, this.getClass());
    }

}
