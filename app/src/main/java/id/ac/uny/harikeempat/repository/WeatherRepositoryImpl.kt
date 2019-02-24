package id.ac.uny.harikeempat.repository

import id.ac.uny.harikeempat.response_model.Main
import retrofit2.Call

class WeatherRepositoryImpl : WeatherRepository {
    override fun getWeathers(): Call<Main> {
        return MyAppService.create().getWeathers()
    }

}