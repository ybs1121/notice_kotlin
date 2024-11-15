package com.study.notice_kotlin.v2.dto

import jakarta.persistence.Column
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime

class BoardResponse(
    val id: Long,
    val title: String,
    val content: String,
    val author: String,
    val createdAt: LocalDateTime,
    var updatedAt: LocalDateTime
) {
}