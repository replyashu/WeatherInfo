package ashu.gojekdemo.main;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.support.annotation.NonNull;
import android.view.Window;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import ashu.gojekdemo.R;
import ashu.gojekdemo.model.WeatherDTO;
import ashu.gojekdemo.network.NetworkInterface;
import ashu.gojekdemo.network.NetworkService;
import ashu.gojekdemo.main.MainView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by apple on 12/04/18.
 */

public class MainPresenter implements OnCompleteListener<Location>, Callback<WeatherDTO>{

    Context context;
    MainView mainView;

    private FusedLocationProviderClient mFusedLocationClient;
    private String city;

    private Dialog dialog;


    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;


    public MainPresenter(Context context, MainView mainView){
        this.context = context;
        this.mainView = mainView;
    }



    public void fetchCurrentLocation(){
        dialog = new Dialog (context);
        dialog.requestWindowFeature (Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.loader);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setCancelable(false);
        dialog.show ();

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(context);
            mFusedLocationClient.getLastLocation()
                    .addOnCompleteListener(this);

    }

    public void onResume(){

    }

    public void onPause(){
        if(dialog.isShowing())
            dialog.dismiss();
    }

    public void requestNetworkCall(String city) {
        NetworkService networkClass = new NetworkService();
        Retrofit retrofit = networkClass.start();

        NetworkInterface networkInterface = retrofit.create(NetworkInterface.class);

        Call<WeatherDTO> resultDTOCall = networkInterface.getListOfForecasts(city);
        resultDTOCall.enqueue(this);
    }

    public void onDestroy(){
        mainView = null;
    }


    @Override
    public void onComplete(@NonNull Task<Location> task) {
        try {
            city = getUserCity(task.getResult().getLatitude(), task.getResult().getLongitude());

            if(city == null){
                mainView.showErrorScreen();
            }
            else{
                requestNetworkCall(city);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUserCity(double lat, double lon) throws IOException {
        Geocoder geocoder;
        List<Address> addresses;
        geocoder = new Geocoder(context, Locale.getDefault());

        addresses = geocoder.getFromLocation(lat, lon, 1);
        String city = addresses.get(0).getLocality();

        return city;
    }

    @Override
    public void onResponse(Call<WeatherDTO> call, Response<WeatherDTO> response) {
        mainView.populateData((WeatherDTO) response.body(), city);
        mainView.hideErrorScreen();
        dialog.dismiss();
    }

    @Override
    public void onFailure(Call<WeatherDTO> call, Throwable t) {
        mainView.showErrorScreen();
        dialog.dismiss();
    }
}
