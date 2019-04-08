package id.ac.uny.harikeempat.ui

import android.util.Log
import id.ac.uny.harikeempat.repository.WeatherRepository
import id.ac.uny.harikeempat.response_model.Main
import retrofit2.Call
import retrofit2.Response

class WeatherListPresenter(
    val view: WeatherListView,
    val weatherRepository: WeatherRepository
) {

    fun ambilWeathers() {
        view.showLoading()
        weatherRepository.getWeathers().enqueue(object : retrofit2.Callback<Main> {
            override fun onFailure(call: Call<Main>, t: Throwable) {
                view.hideLoading()
                Log.e("error", "failed ${t.message}")
            }

            override fun onResponse(call: Call<Main>, response: Response<Main>) {
                view.hideLoading()
                if (response.isSuccessful) {
                    val result = response.body()
                    view.showError("kosong")
                    view.showData(result)

                } else
                    Log.e("error", "gak sukses responya ${response.message()}")
            }

        })
    }
}