package mx.com.sajiro.vo;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;
import mx.com.sajiro.annotation.Order;

@Getter
@Setter
public class StatusChangesVO extends AbstractVO {

    /** The instrument status. */
    @Order(1)
    @SerializedName("Instrument Status")
    private char instrumentStatus;

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString().
     */
    @Override
    public String toString() {
        return super.toString(this, this.getClass());
    }

}
