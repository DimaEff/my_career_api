package ru.my_career.my_career_api.my_career_api._common.services.http

import com.fasterxml.jackson.databind.ObjectMapper
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import kotlinx.serialization.json.*
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class HttpServiceImpl: HttpService {
    private val logger = LoggerFactory.getLogger(javaClass)
    private val client = HttpClient.newBuilder().build();
    private val json = Json { ignoreUnknownKeys = true }

    public override fun <T: Any>get(requestParams: RequestParams<T>): T? {
        val uri = getUriWithQuery(requestParams.url, requestParams.queryParams)

        val request = HttpRequest.newBuilder()
            .addHeaders(requestParams.headers)
            .uri(uri)
            .build()

        val response = sendRequest(request)

        return formateResponse(response, requestParams.serializer)
    }

    public override fun <T : Any, TBody : Body> post(requestParamsWithBody: RequestParamsWithBody<T, TBody>): T? {
        val uri = getUriWithQuery(requestParamsWithBody.url, requestParamsWithBody.queryParams)
        val requestBody = getBodyString(requestParamsWithBody.body)

        val request = HttpRequest.newBuilder()
            .addHeaders(requestParamsWithBody.headers)
            .uri(uri)
            .POST(HttpRequest.BodyPublishers.ofString(requestBody))
            .build()

        val response = sendRequest(request)

        return formateResponse(response, requestParamsWithBody.serializer)
    }

    public override fun <T : Any, TBody : Body> put(requestParamsWithBody: RequestParamsWithBody<T, TBody>): T? {
        val uri = getUriWithQuery(requestParamsWithBody.url, requestParamsWithBody.queryParams)
        val requestBody = getBodyString(requestParamsWithBody.body)

        val request = HttpRequest.newBuilder()
            .addHeaders(requestParamsWithBody.headers)
            .uri(uri)
            .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
            .build()

        val response = sendRequest(request)

        return formateResponse(response, requestParamsWithBody.serializer)
    }

    public override fun <T : Any> delete(requestParams: RequestParams<T>): T? {
        val uri = getUriWithQuery(requestParams.url, requestParams.queryParams)

        val request = HttpRequest.newBuilder()
            .addHeaders(requestParams.headers)
            .uri(uri)
            .build()

        val response = sendRequest(request)

        return formateResponse(response, requestParams.serializer)
    }

    private fun sendRequest(request: HttpRequest): HttpResponse<String>? {
        logger.info("Send request")
        return try {
            val response = client.send(request, HttpResponse.BodyHandlers.ofString())
            logger.info("Success request")
            response
        } catch (e: java.io.IOException) {
            logger.warn("Failed request", e)
            null
        }
    }

    private fun getUriWithQuery(url: String, queryParams: QueryParams?): URI {
        var queryParamsString = ""
        if (queryParams != null) {
            queryParamsString = getUrlParams(queryParams)
        }

        val urlWithQuery = url + QUERY_PARAMS_START_SEPARATOR + queryParamsString

        return URI.create(urlWithQuery)
    }

    private fun getUrlParams(queryParams: QueryParams): String =
        queryParams.map { (k, v) -> "$k=$v" }.joinToString(separator = QUERY_PARAMS_SEPARATOR)

    private fun getBodyString(body: Body?): String? = if (body == null) null else ObjectMapper().writeValueAsString(body)

    private fun <T: Any>formateResponse(response: HttpResponse<String>?, serializer: Serializer<T>?): T? {
        val stringBody = response?.body()

        if (serializer == null || stringBody == null) {
            return null
        }

        return json.decodeFromString(serializer, stringBody)
    }
}