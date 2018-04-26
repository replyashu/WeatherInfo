package ashu.gojekdemo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import ashu.gojekdemo.main.MainPresenter;
import ashu.gojekdemo.main.MainActivity;
import ashu.gojekdemo.main.MainView;

/**
 * Created by apple on 15/04/18.
 */


@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

    @Mock
    MainActivity activity;

    @Mock
    private MainView mainView;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void fetchValidDataShouldLoadIntoView() {
        MainPresenter mainPresenter = new MainPresenter(activity, mainView);

        String city = "Bangalore";

        mainPresenter.requestNetworkCall(city);

    }
}
