package com.study.notice_kotlin.v1

import com.study.notice_kotlin.v1.dto.NoticeAdd
import com.study.notice_kotlin.v1.dto.NoticeMod
import com.study.notice_kotlin.v1.dto.NoticeRes
import com.study.notice_kotlin.v1.dto.NoticeRes.Companion.convertToNoticeRes
import com.study.notice_kotlin.v1.entity.Notice
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class NoticeService(
    private val noticeRepository: NoticeRepository
) {

    fun save(noticeAdd: NoticeAdd): Long {
        val notice = Notice.create(noticeAdd)
        noticeRepository.save(notice)
        return notice.id;
    }

    fun findAll(): NoticeRes.NoticeMainResponse {
        val noticeList = noticeRepository.findAll()
        val noticeResList = noticeList.map { n -> convertToNoticeRes(n) }
            .toList()
        return NoticeRes.NoticeMainResponse(
            noticeResList = noticeResList,
            cnt = noticeList.size
        )
    }

    fun findById(id: Long): NoticeRes {
        val notice = noticeRepository.findById(id)
        if (notice.isPresent) {
            return notice.get().toNoticeRes()
        }

        throw NoticeNotFoundException(id)
    }

    fun deleteById(id: Long): String {
        noticeRepository.deleteById(id)
        return "OK"
    }

    fun updateNoticeById(id: Long, noticeMod: NoticeMod): Long {
        val notice = noticeRepository.findById(id)
        if (notice.isPresent) {
            notice.get().update(noticeMod)
            return id
        }
        throw IllegalArgumentException("Not found notice")
    }

    private fun Notice.toNoticeRes() = NoticeRes( // 확장함수
        id = id,
        title = title,
        content = content,
        register = register
    )

}

class NoticeNotFoundException(id: Long) : RuntimeException("Notice not found with id: $id")