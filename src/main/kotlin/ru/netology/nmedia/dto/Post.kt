package ru.netology.nmedia.dto

data class Post(
        val id: Long,
        val author: String,
        val content: String,
        val published: Long,
        val likedByMe: Boolean,
        val likes: Int = 0,
        var shares: Int = 0,
        var views: Int = 0,
        var video: String = "0"
)