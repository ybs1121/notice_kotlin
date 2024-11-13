package com.study.notice_kotlin.dto

import java.time.LocalDateTime

data class NoticeMod(
    val title: String,
    val content: String,
    val register: String,
    val updatedAt: LocalDateTime = LocalDateTime.now()
) {

}