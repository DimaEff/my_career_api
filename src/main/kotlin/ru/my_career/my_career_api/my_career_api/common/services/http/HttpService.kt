package ru.my_career.my_career_api.my_career_api.common.services.http

import kotlinx.serialization.KSerializer

typealias Body = Map<String, Any>
typealias QueryParams = Map<String, String>
typealias Headers = Map<String, String>
typealias Serializer<T> = KSerializer<T>

open class RequestParams<T: Any>(
    val url: String,
    val queryParams: QueryParams? = null,
    val headers: Headers? = null,
    val serializer: Serializer<T>? = null,
)

class RequestParamsWithBody<T: Any, Body: Map<String, Any>>(
    url: String,
    queryParams: QueryParams?,
    headers: Headers?,
    serializer: Serializer<T>?,
    val body: Body,
): RequestParams<T>(url, queryParams, headers, serializer)

interface HttpService {
    fun <T: Any>get(requestParams: RequestParams<T>): T?
    fun <T: Any, TBody: Body>post(requestParamsWithBody: RequestParamsWithBody<T, TBody>): T?
    fun <T: Any, TBody: Body>put(requestParamsWithBody: RequestParamsWithBody<T, TBody>): T?
    fun <T: Any>delete(requestParams: RequestParams<T>): T?
}