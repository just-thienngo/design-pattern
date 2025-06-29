package creationalPatterns

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import kotlin.jvm.java

object RetrofitClient {

    private val retrofit: Retrofit

    init {
        println("Initializing RetrofitClient...")
        retrofit = Retrofit.Builder()
            .baseUrl("https://api.example.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun <T> createService(serviceClass: Class<T>): T {
        return retrofit.create(serviceClass)
    }

}
interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
}

data class User(
    val id: Int, val name: String
)

fun main ()
{
    val service = RetrofitClient.createService(ApiService::class.java)
    println("Service created: $service")
}


