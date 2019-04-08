package id.ac.uny.harikeempat.ui

import id.ac.uny.harikeempat.response_model.Main

interface WeatherListView{
    fun showLoading()
    fun hideLoading()
    fun showData(main: Main?)
    fun showError(errorMessage: String)
}