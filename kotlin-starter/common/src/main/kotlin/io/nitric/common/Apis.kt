package io.nitric.common

import io.nitric.Nitric
import io.nitric.resources.ApiResource

fun PublicApi(): ApiResource {
    return Nitric.api("public")
}