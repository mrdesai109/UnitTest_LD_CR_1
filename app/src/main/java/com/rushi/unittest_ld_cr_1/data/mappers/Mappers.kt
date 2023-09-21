package com.rushi.unittest_ld_cr_1.data.mappers

import com.rushi.unittest_ld_cr_1.data.dto.PostsDTO
import com.rushi.unittest_ld_cr_1.domain.model.PostItem

fun PostsDTO.PostsDTOItem.toPost() : PostItem{
    return PostItem(body = this.body ?: "",id = this.id ?: -1,title = this.title ?: "",userId = this.userId ?: -1)
}

