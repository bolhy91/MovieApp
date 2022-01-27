package com.bcoding.movieapp.repository

sealed class Result<T>(
    val data: T? = null,
    val message: String? = null
) {

    class Success<T>(data: T?) : Result<T>(data)

    class Error<T>(message: String?, data: T? = null) : Result<T>(data, message)

    class Loading<T>(data: T? = null) : Result<T>(data)

    override fun toString(): String {
        return "Result(data=$data, message=$message)"
    }
}