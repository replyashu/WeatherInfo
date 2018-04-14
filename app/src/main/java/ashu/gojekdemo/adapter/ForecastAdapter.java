package ashu.gojekdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ashu.gojekdemo.R;
import ashu.gojekdemo.model.ForeCastDTO;
import ashu.gojekdemo.model.WeatherDTO;

/**
 * Created by apple on 14/04/18.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ViewHolder>{

    private Context context;
    private ForeCastDTO foreCastDTO;

    public ForecastAdapter(Context context, ForeCastDTO foreCastDTO){
        this.context = context;
        this.foreCastDTO = foreCastDTO;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.forecast_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Date date = new Date();
        try {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            date = format.parse(foreCastDTO.getForecastday().get(position).getDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String dayOfTheWeek = (String) DateFormat.format("EEEE", date); // Thursday

        holder.txtDay.setText(dayOfTheWeek);
        holder.txtTemperature.setText(foreCastDTO.getForecastday().get(position).getDay().getMintempC() + " C - " +
                        foreCastDTO.getForecastday().get(position).getDay().getMaxtempC() + " C");
    }

    @Override
    public int getItemCount() {
        return foreCastDTO.getForecastday().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtDay;
        TextView txtTemperature;

        ViewHolder(View itemView) {
            super(itemView);
            txtDay = (TextView) itemView.findViewById(R.id.txtDay);
            txtTemperature = (TextView) itemView.findViewById(R.id.txtTemperature);
        }

    }

}
