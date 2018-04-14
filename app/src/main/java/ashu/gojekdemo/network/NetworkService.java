package ashu.gojekdemo.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ashu.gojekdemo.utils.Constants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by apple on 12/04/18.
 */

public class NetworkService {

    static final String BASE_URL = Constants.base_url;

    public Retrofit start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit;
    }
}
