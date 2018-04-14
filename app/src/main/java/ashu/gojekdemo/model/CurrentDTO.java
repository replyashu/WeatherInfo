package ashu.gojekdemo.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by apple on 14/04/18.
 */


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties
public class CurrentDTO implements Parcelable{

    @SerializedName("temp_c")
    @Expose
    private Integer tempC;

    protected CurrentDTO(Parcel in) {
        this.tempC = in.readInt();
    }

    public static final Creator<CurrentDTO> CREATOR = new Creator<CurrentDTO>() {
        @Override
        public CurrentDTO createFromParcel(Parcel in) {
            return new CurrentDTO(in);
        }

        @Override
        public CurrentDTO[] newArray(int size) {
            return new CurrentDTO[size];
        }
    };

    public Integer getTempC() {
        return tempC;
    }

    public void setTempC(Integer tempC) {
        this.tempC = tempC;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
