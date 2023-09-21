package com.rushi.unittest_ld_cr_1.domain.repository

import com.rushi.unittest_ld_cr_1.data.dto.PostsDTO
import com.rushi.unittest_ld_cr_1.data.utils.Resource
import com.rushi.unittest_ld_cr_1.domain.model.PostItem

interface MainRepository {

    suspend fun getPosts(): Resource<List<PostItem>>
}