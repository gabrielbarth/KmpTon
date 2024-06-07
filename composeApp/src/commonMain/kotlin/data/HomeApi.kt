package data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class HomeApi(private val httpClient: HttpClient) {

    suspend fun getHome(): HomeDTO {
        return httpClient.get("/home").body<HomeDTO>()
    }
}