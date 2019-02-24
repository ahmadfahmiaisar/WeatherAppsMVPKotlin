package id.ac.uny.harikeempat.repository

import id.ac.uny.harikeempat.response_model.Main
import id.ac.uny.harikeempat.response_model.Response
import retrofit2.Call

class WeatherRepositoryImpl : WeatherRepository {
    override fun getWeathers(): Call<Response> {
        return MyAppService.create().getWeathers()
    }

}