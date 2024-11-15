package com.study.notice_kotlin.v1.controller

import com.study.notice_kotlin.v1.dto.NoticeAdd
import com.study.notice_kotlin.v1.dto.NoticeMod
import com.study.notice_kotlin.v1.dto.NoticeRes
import com.study.notice_kotlin.v1.NoticeService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/notices")
class BoardController(
    private val noticeService: NoticeService
) {
    // 저장
    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun saveNotice(@RequestBody noticeAdd: NoticeAdd): Long {
        return noticeService.save(noticeAdd)
    }

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getNotices(): NoticeRes.NoticeMainResponse {
        return noticeService.findAll()
    }

    @GetMapping(value = ["/find-all-2"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getNotices2(): NoticeRes.NoticeMainResponse = noticeService.findAll()

    @GetMapping(value = ["/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getNotice(@PathVariable id: Long): NoticeRes {
        return noticeService.findById(id)
    }

    @DeleteMapping(value = ["/{id}"])
    fun deleteNotice(@PathVariable id: Long): String {
        return noticeService.deleteById(id)
    }

    @PatchMapping(value = ["/{id}"])
    fun updateNotice(@PathVariable id: Long, @RequestBody noticeMod: NoticeMod): Long {
        return noticeService.updateNoticeById(id, noticeMod)
    }
}