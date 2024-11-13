package com.study.notice_kotlin.entity

import com.study.notice_kotlin.dto.NoticeAdd
import com.study.notice_kotlin.dto.NoticeMod
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class Notice(
    var title: String,
    var register: String,
    var content: String,
    val createAt: LocalDateTime,
    var updateAt: LocalDateTime,
) {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "board_id")
    val id: Long = 0


    companion object {
        fun create(noticeAdd: NoticeAdd): Notice {
            val now = LocalDateTime.now()
            return Notice(
                title = noticeAdd.title,
                register = noticeAdd.register,
                content = noticeAdd.content,
                createAt = now,
                updateAt = now

            )
        }
    }

    fun update(noticeMod: NoticeMod) {
        this.title = noticeMod.title
        this.content = noticeMod.content
        this.register = noticeMod.register
        this.updateAt = LocalDateTime.now()
    }

}