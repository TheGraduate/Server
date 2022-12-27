package ru.netology.nmedia.dto

data class Post(
        val id: Long,
        val author: String,
        val content: String,
        val published: Long,
        val likedByMe: Boolean,
        val likes: Int = 0,
        var shares: Int,
        var views: Int,
        var video: String = "0"
)