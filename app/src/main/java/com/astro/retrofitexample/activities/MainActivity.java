package com.astro.retrofitexample.activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.astro.retrofitexample.R;
import com.astro.retrofitexample.rest.RestClient;
import com.astro.retrofitexample.model.WeatherResponse;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Sergio Mattioli on 28/03/2015.
 */
public class MainActivity extends ActionBarActivity {

    @InjectView(R.id.country) TextView mCountry;
    @InjectView(R.id.temperature_tv) TextView mTemperature;
    @InjectView(R.id.temp_min_tv) TextView mTemperatureMin;
    @InjectView(R.id.temp_max_tv) TextView mTemperatureMax;
    @InjectView(R.id.city) EditText mCity;
    @InjectView(R.id.results_layout) RelativeLayout mResultsLayout;
    @InjectView(R.id.image_layout) RelativeLayout mImageLayout;
    @InjectView(R.id.loading_layout) RelativeLayout mLoadingLayout;
    @InjectView(R.id.imageView) ImageView mCurrentWeatherImageView;
    @InjectView(R.id.current_description_tv) TextView mCurrentDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);
    }

    @OnClick(R.id.submit)
    public void submit(View view) {

        mLoadingLayout.setVisibility(View.VISIBLE);

        RestClient.get().getWeather(mCity.getText().toString(), new Callback<WeatherResponse>() {
            @Override
            public void success(WeatherResponse weatherResponse, Response response) {

                mResultsLayout.setVisibility(View.VISIBLE);
                mLoadingLayout.setVisibility(View.GONE);

                // success!
                Log.i("App", weatherResponse.toString());

                mCountry.setText(weatherResponse.getSys().getCountry());

                mTemperature.setText((int)convertToFahrenheit(weatherResponse.getMainInfos().getTemp().floatValue()) + "F");
                mTemperatureMin.setText((int)convertToFahrenheit(weatherResponse.getMainInfos().getTempMin().floatValue()) + "F");
                mTemperatureMax.setText((int)convertToFahrenheit(weatherResponse.getMainInfos().getTempMax().floatValue()) + "F");

                if (!weatherResponse.getWeather().isEmpty())
                {
                    mImageLayout.setVisibility(View.VISIBLE);
                    Picasso.with(MainActivity.this).load("http://openweathermap.org/img/w/" +
                            weatherResponse.getWeather().get(0).getStrIconName() + ".png").into(mCurrentWeatherImageView);
                    mCurrentDescription.setText(weatherResponse.getWeather().get(0).getStrDesc());
                }
                else
                    mImageLayout.setVisibility(View.INVISIBLE);



            }

            @Override
            public void failure(RetrofitError error) {

                mLoadingLayout.setVisibility(View.GONE);
                // something went wrong
                Log.i("App", error.getLocalizedMessage());
            }

            private double convertToFahrenheit(float kelvin) {
                return ((kelvin - 273.15)* 1.8000 + 32);
            }
        });

    }

    public void onDestroy() {
        super.onDestroy();
    }


}
