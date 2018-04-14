package ashu.gojekdemo.view;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import ashu.gojekdemo.R;
import ashu.gojekdemo.adapter.ForecastAdapter;
import ashu.gojekdemo.model.WeatherDTO;
import ashu.gojekdemo.presenter.MainPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by apple on 14/04/18.
 */

public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener{

    @BindView(R.id.recyclerForecast)
    RecyclerView recyclerForecast;

    @BindView(R.id.relPositive)
    RelativeLayout relPositive;

    @BindView(R.id.relNegative)
    RelativeLayout relNegative;

    @BindView(R.id.txtCurrentTemp)
    TextView txtCurrentTemp;

    @BindView(R.id.txtCurrentCity)
    TextView txtCurrentCity;

    @BindView(R.id.btnRetry)
    Button btnRetry;

    private MainPresenter presenter;
    private ForecastAdapter adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        presenter = new MainPresenter(MainActivity.this, this);
        recyclerForecast.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        presenter.fetchCurrentLocation();
        btnRetry.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnRetry)
            presenter.fetchCurrentLocation();
    }

    @Override
    public void populateData(WeatherDTO weatherDTO, String city) {

        int[] ATTRS = new int[]{android.R.attr.listDivider};

        TypedArray a = this.obtainStyledAttributes(ATTRS);
        Drawable divider = a.getDrawable(0);
        InsetDrawable insetDivider = new InsetDrawable(divider, 50, 0, 50, 0);
        a.recycle();

        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(insetDivider);
        recyclerForecast.addItemDecoration(itemDecoration);


        txtCurrentCity.setText(city);
        recyclerForecast.setVisibility(View.VISIBLE);
        txtCurrentTemp.setText(String.valueOf(weatherDTO.getCurrent().getTempC() + " °C"));
        adapter = new ForecastAdapter(MainActivity.this, weatherDTO.getForecast());
        recyclerForecast.setAdapter(adapter);

    }

    @Override
    public void hideErrorScreen() {
        relPositive.setVisibility(View.VISIBLE);
        relNegative.setVisibility(View.GONE);
    }

    @Override
    public void showErrorScreen() {
        relPositive.setVisibility(View.GONE);
        relNegative.setVisibility(View.VISIBLE);
    }
}
