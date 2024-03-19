package mx.com.sajiro.vo;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;
import mx.com.sajiro.annotation.Order;

@Getter
@Setter
public class MiddlePriceExistingQuotesVO extends AbstractVO {

    /** The exists postures. */
    @Order(1)
    @SerializedName("Existing Postures")
    private char existsPostures;

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString().
     */
    @Override
    public String toString() {
        return super.toString(this, this.getClass());
    }

}
