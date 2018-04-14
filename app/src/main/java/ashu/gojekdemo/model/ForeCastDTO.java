package ashu.gojekdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by apple on 14/04/18.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties
public class ForeCastDTO {

    @SerializedName("forecastday")
    @Expose
    private List<ForeCastDayDTO> forecastday = null;

    public List<ForeCastDayDTO> getForecastday() {
        return forecastday;
    }

    public void setForecastday(List<ForeCastDayDTO> forecastday) {
        this.forecastday = forecastday;
    }
}
