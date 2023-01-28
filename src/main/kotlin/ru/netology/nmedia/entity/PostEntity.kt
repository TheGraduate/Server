package ru.netology.nmedia.entity

import ru.netology.nmedia.dto.Attachment
import ru.netology.nmedia.dto.Post
import javax.persistence.*
import ru.netology.nmedia.enumeration.AttachmentType

@Entity
data class PostEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long,
    var author: String,
    var authorAvatar: String,
    @Column(columnDefinition = "TEXT")
    var content: String,
    var published: Long,
    var likedByMe: Boolean,
    var likes: Int = 0,
    var shares: Int,
    var views: Int,
    var video: String = "0",
    @Embedded
var attachment: AttachmentEmbeddable?,
) {
    fun toDto() = Post(id, author, authorAvatar, content, published, likedByMe, likes, shares, views, video, attachment?.toDto())

    companion object {
        fun fromDto(dto: Post) = PostEntity(
            dto.id,
            dto.author,
            dto.authorAvatar,
            dto.content,
            dto.published,
            dto.likedByMe,
            dto.likes,
            dto.shares,
            dto.views,
            dto.video,
            AttachmentEmbeddable.fromDto(dto.attachment),
        )
    }
}

@Embeddable
data class AttachmentEmbeddable(
    var url: String,
    @Column(columnDefinition = "TEXT")
    var description: String?,
    @Enumerated(EnumType.STRING)
    var type: AttachmentType,
) {
    fun toDto() = Attachment(url, description, type)

    companion object {
        fun fromDto(dto: Attachment?) = dto?.let {
            AttachmentEmbeddable(it.url, it.description, it.type)
        }
    }
}