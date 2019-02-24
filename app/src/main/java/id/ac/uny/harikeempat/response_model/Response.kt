package id.ac.uny.harikeempat.response_model

import com.google.gson.annotations.SerializedName

data class Response(
	@field:SerializedName("main")
	val main: Main? = null
)