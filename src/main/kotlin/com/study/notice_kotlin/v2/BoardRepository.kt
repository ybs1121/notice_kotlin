package com.study.notice_kotlin.v2

import com.study.notice_kotlin.v2.entity.Board
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository


interface BoardRepository : JpaRepository<Board, Long> {

    fun findByTitleContainingOrContentContaining(
        title: String,
        content: String,
        pageable: Pageable
    ): Page<Board>
}