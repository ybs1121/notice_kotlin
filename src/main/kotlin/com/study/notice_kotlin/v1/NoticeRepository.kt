package com.study.notice_kotlin.v1

import com.study.notice_kotlin.v1.entity.Notice
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NoticeRepository : JpaRepository<Notice, Long> {}
