package com.rushi.unittest_ld_cr_1.data.utils

sealed class Resource<T>(val data1: T? = null, val message: String? = null) {

    class Success<T>(data: T) : Resource<T>(data1 = data)

    class Error<T>(msg: String = "") : Resource<T>(message = msg)

    class Loading<T>(isLoading: Boolean) : Resource<T>()
}