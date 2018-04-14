package ashu.gojekdemo.network;

import ashu.gojekdemo.model.WeatherDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by apple on 12/04/18.
 */

public interface NetworkInterface {

    @GET("forecast.json?key=820334582a1a40efbee94119181004&days=4")
    Call<WeatherDTO> getListOfForecasts(@Query("q") String q);
}
