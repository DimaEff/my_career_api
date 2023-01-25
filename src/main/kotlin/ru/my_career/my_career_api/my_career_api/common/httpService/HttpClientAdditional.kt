package ru.my_career.my_career_api.my_career_api.common.httpService

import java.net.http.HttpRequest

fun HttpRequest.Builder.addHeaders(headers: Headers?): HttpRequest.Builder {
    headers?.forEach { (k, v) -> this.setHeader(k, v) }
    return this
}
