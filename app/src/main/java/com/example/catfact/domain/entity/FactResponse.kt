package com.example.catfact.domain.entity

sealed interface FactResponse<T> {
    data class Success<T>(val data: T) : FactResponse<T>
    class EmptyListError<T> : FactResponse<T>
    class FactError<T> : FactResponse<T>
}