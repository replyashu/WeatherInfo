package ashu.gojekdemo.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by apple on 12/04/18.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties
public class WeatherDTO implements Parcelable{
    @SerializedName("current")
    @Expose
    private CurrentDTO current;
    @SerializedName("forecast")
    @Expose
    private ForeCastDTO forecast;

    protected WeatherDTO(Parcel in) {
        current = in.readParcelable(CurrentDTO.class.getClassLoader());
    }

    public static final Creator<WeatherDTO> CREATOR = new Creator<WeatherDTO>() {
        @Override
        public WeatherDTO createFromParcel(Parcel in) {
            return new WeatherDTO(in);
        }

        @Override
        public WeatherDTO[] newArray(int size) {
            return new WeatherDTO[size];
        }
    };

    public CurrentDTO getCurrent() {
        return current;
    }

    public void setCurrent(CurrentDTO current) {
        this.current = current;
    }

    public ForeCastDTO getForecast() {
        return forecast;
    }

    public void setForecast(ForeCastDTO forecast) {
        this.forecast = forecast;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(current, flags);
    }
}
