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
public class ForeCastDayDTO {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("day")
    @Expose
    private DayDTO day;
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public DayDTO getDay() {
        return day;
    }

    public void setDay(DayDTO day) {
        this.day = day;
    }
}
