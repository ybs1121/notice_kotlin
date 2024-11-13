package com.study.notice_kotlin.dto

import com.study.notice_kotlin.entity.Notice

data class NoticeRes(
    val id: Long,
    val title: String,
    val content: String,
    val register: String
) {

    companion object {
        fun convertToNoticeRes(notice: Notice): NoticeRes {
            return NoticeRes(
                notice.id,
                notice.title,
                notice.content,
                notice.register
            )
        }
    }

    data class NoticeMainResponse(
        val noticeResList: List<NoticeRes>,
        val cnt: Int
    )
}