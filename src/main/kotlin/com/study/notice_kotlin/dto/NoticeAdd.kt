package com.study.notice_kotlin.dto

import java.time.LocalDateTime

data class NoticeAdd(
    val title: String,
    val content: String,
    val register: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now()
) {

}