package com.alugames.services

import com.google.gson.Gson
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

interface APIServiceContract {
    val baseURL: String
        get() = "htttp://localhost:8080"
    val gson: Gson
        get() = Gson()

    fun makeRequest(completeURL: String): HttpResponse<String> {
        val client = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(java.net.URI.create(completeURL))
            .build()
        return client.send(request, HttpResponse.BodyHandlers.ofString())
    }
}