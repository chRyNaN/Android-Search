package com.chrynan.androidsearch.repository

import com.chrynan.androidsearch.model.Contact

interface ContactRepository {

    suspend fun getBy(query: String): Sequence<Contact>
}