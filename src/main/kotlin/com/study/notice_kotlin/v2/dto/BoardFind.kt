package com.study.notice_kotlin.v2.dto

data class BoardFind(
    val keyword: String,
    val page: Int,
    val size: Int
) {
}