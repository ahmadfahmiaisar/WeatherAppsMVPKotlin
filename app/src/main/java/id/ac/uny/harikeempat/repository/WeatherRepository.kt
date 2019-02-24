package id.ac.uny.harikeempat.repository

import id.ac.uny.harikeempat.response_model.Main
import retrofit2.Call

interface WeatherRepository {
    fun getWeathers(): Call<Main>

}