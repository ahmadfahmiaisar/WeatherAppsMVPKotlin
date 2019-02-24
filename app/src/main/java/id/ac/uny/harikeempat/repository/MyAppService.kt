package id.ac.uny.harikeempat.repository

import id.ac.uny.harikeempat.response_model.Response
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface MyAppService {
    @GET("weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22")
    fun getWeathers(): Call<Response>

    companion object {
        fun create(): MyAppService {
            val okHttpClientBuilder = OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)

            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            okHttpClientBuilder.addInterceptor(logging)

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://samples.openweathermap.org/data/2.5/")
                .client(okHttpClientBuilder.build())
                .build()
            return retrofit.create(MyAppService::class.java)
        }
    }

}