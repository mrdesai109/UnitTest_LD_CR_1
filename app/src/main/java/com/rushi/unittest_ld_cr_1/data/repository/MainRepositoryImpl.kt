package com.rushi.unittest_ld_cr_1.data.repository

import com.rushi.unittest_ld_cr_1.data.dto.PostsDTO
import com.rushi.unittest_ld_cr_1.data.mappers.toPost
import com.rushi.unittest_ld_cr_1.data.network.PostsAPI
import com.rushi.unittest_ld_cr_1.data.utils.Resource
import com.rushi.unittest_ld_cr_1.domain.model.PostItem
import com.rushi.unittest_ld_cr_1.domain.repository.MainRepository
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(val api: PostsAPI) : MainRepository {

    override suspend fun getPosts(): Resource<List<PostItem>> {
        try {
            val responseData = api.getPosts().map {
                it.toPost()
            }
            return Resource.Success(responseData)
        } catch (ex: Exception) {
            return Resource.Error(msg = ex.localizedMessage ?: "Unknown error")
        }
    }
}