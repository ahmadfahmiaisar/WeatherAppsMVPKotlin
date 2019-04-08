package id.ac.uny.harikeempat.ui.adapter

import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import id.ac.uny.harikeempat.R
import id.ac.uny.harikeempat.response_model.Main
import kotlinx.android.synthetic.main.item_weather_list.view.*

interface WeatherListener {
    fun onWeatherClick(weather: Main?)
}
class WeatherAdapter (
    val weather: Main?,
    val listener: WeatherListener) : Item() {
    override fun bind(viewHolder: ViewHolder, position: Int) {
        val tvTemp = viewHolder.itemView.tvWeatherTemp
        val tvPres = viewHolder.itemView.tvWeatherPresure

        tvTemp.text = "${weather!!.temp}"
        tvPres.text = "${weather.pressure}"

        viewHolder.itemView.setOnClickListener {
            listener.onWeatherClick(weather)
//            weather?.let { it1 -> listener.onWeatherClick(it1) }
        }
    }

    override fun getLayout(): Int {
        return R.layout.item_weather_list
    }

}