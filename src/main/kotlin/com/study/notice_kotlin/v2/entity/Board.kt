package com.study.notice_kotlin.v2.entity

import com.study.notice_kotlin.v2.dto.BoardAddDto
import com.study.notice_kotlin.v2.dto.BoardResponse
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

@Entity
data class Board(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,

    @Column(nullable = false, length = 100)
    val title: String,

    @Column(nullable = false, columnDefinition = "TEXT")
    val content: String,

    @Column(nullable = false)
    val author: String,

    @CreationTimestamp
    @Column(updatable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    var updatedAt: LocalDateTime = LocalDateTime.now()
) {
    companion object {

        fun create(boardAddDto: BoardAddDto): Board {
            return Board(
                title = boardAddDto.title,
                content = boardAddDto.content,
                author = boardAddDto.author,
            )
        }
    }

    fun toResponse(): BoardResponse =
        BoardResponse(
            id = this.id!!,
            title = this.title,
            content = this.content,
            author = this.author,
            createdAt = this.createdAt,
            updatedAt = this.updatedAt
        )
}