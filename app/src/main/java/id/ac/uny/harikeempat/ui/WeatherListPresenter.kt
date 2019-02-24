package id.ac.uny.harikeempat.ui

import android.util.Log
import id.ac.uny.harikeempat.repository.WeatherRepository
import id.ac.uny.harikeempat.response_model.Main
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherListPresenter(val view: WeatherListView,
                           val weatherRepository: WeatherRepository) {

    fun ambilWeathers(){
        view.showLoading()

        weatherRepository.getWeathers().enqueue(object : Callback<Main> {
            override fun onResponse(call: Call<Main>, response: Response<Main>) {
                if (response.isSuccessful){
                    val result = response.body()
                    if (result != null) {
                        view.showData(result)
                    }
                }else{
                    Log.e("error response", "gak sukses di response ${response.message()}")
                }
            }
            override fun onFailure(call: Call<Main>, t: Throwable) {
                view.hideLoading()
                Log.e("error failed", "gak sukses di response ${t.message}")
            }

        })
    }
}