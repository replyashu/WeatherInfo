package ashu.gojekdemo;

import android.widget.Button;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import ashu.gojekdemo.main.MainActivity;

import static org.junit.Assert.assertEquals;

/**
 * Created by apple on 15/04/18.
 */


@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, manifest = "src/main/AndroidManifest.xml")
public class MainActivityTest {

    MainActivity activity;
    TextView txtCity;
    TextView txtTemp;
    Button btnRetry;

    @Before
    public void setUp() {
        activity = Robolectric.setupActivity(MainActivity.class);
        txtCity = (TextView) activity.findViewById(R.id.txtCurrentCity);
        txtTemp = (TextView) activity.findViewById(R.id.txtCurrentTemp);
        btnRetry = (Button) activity.findViewById(R.id.btnRetry);
    }

    @Test
    public void testMainActivityAddition() {
        txtTemp.setText("21.2C");
        txtCity.setText("Bangalore");
        btnRetry.performClick();


    }




}
