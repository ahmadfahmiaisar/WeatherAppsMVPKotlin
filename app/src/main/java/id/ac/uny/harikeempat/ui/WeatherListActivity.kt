package id.ac.uny.harikeempat.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View.GONE
import android.view.View.VISIBLE
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import id.ac.uny.harikeempat.R
import id.ac.uny.harikeempat.repository.WeatherRepositoryImpl
import id.ac.uny.harikeempat.response_model.Main
import id.ac.uny.harikeempat.response_model.Response
import id.ac.uny.harikeempat.ui.adapter.WeatherItem
import id.ac.uny.harikeempat.ui.adapter.WeatherListener
import kotlinx.android.synthetic.main.activity_weather_list.*
import org.jetbrains.anko.toast

class WeatherListActivity : AppCompatActivity(), WeatherListView, WeatherListener {

    lateinit var presenter: WeatherListPresenter
    val weatherAdapter = GroupAdapter<ViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_list)

        val weatherRepo = WeatherRepositoryImpl()

        //set RecycleView
        rvWeatherList.apply {
            adapter = weatherAdapter
            layoutManager = LinearLayoutManager(this@WeatherListActivity)
        }

        presenter = WeatherListPresenter(this, weatherRepo)
        presenter.ambilWeathers()
    }
    override fun showLoading() {
        loading.visibility = VISIBLE
        rvWeatherList.visibility = GONE
    }

    override fun hideLoading() {
        loading.visibility = GONE
        rvWeatherList.visibility = VISIBLE
    }

    /*override fun showData(listWeather: List<Response>) {
        listWeather.map {
            weatherAdapter.add(WeatherItem(it, this))
        }
    }*/
    override fun showData(main: Main) {
        main.apply { 
            weatherAdapter.add(WeatherItem(,this@WeatherListActivity))
        }
    }
    override fun showError(errorMessage: String) {
        loading.visibility = GONE
        rvWeatherList.visibility = GONE
        tvError.visibility= VISIBLE
    }
    override fun onWeatherClick(weather: Main) {
        toast("show ${weather.temp}")
    }
}