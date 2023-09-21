package com.rushi.unittest_ld_cr_1.data.dto


import com.google.gson.annotations.SerializedName

class PostsDTO : ArrayList<PostsDTO.PostsDTOItem>(){
    data class PostsDTOItem(
        @SerializedName("body")
        val body: String?,
        @SerializedName("id")
        val id: Int?,
        @SerializedName("title")
        val title: String?,
        @SerializedName("userId")
        val userId: Int?
    )
}