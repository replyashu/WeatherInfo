package ashu.gojekdemo.main;

import ashu.gojekdemo.model.WeatherDTO;

/**
 * Created by apple on 12/04/18.
 */
public interface MainView {

  public void populateData(WeatherDTO weatherDTO, String city);

  public void hideErrorScreen();

  public void showErrorScreen();


}