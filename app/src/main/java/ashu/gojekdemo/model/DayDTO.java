package ashu.gojekdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by apple on 14/04/18.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties
public class DayDTO {

    @SerializedName("maxtemp_c")
    @Expose
    private Double maxtempC;
    @SerializedName("mintemp_c")
    @Expose
    private Double mintempC;



    public Double getMintempC() {
        return mintempC;
    }

    public Double getMaxtempC() {
        return maxtempC;
    }

    public void setMaxtempC(Double maxtempC) {
        this.maxtempC = maxtempC;
    }

    public void setMintempC(Double mintempC) {
        this.mintempC = mintempC;
    }
}
