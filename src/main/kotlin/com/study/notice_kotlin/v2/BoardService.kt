package com.study.notice_kotlin.v2

import com.study.notice_kotlin.v2.dto.BoardAddDto
import com.study.notice_kotlin.v2.dto.BoardResponse
import com.study.notice_kotlin.v2.entity.Board
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest

class BoardService(
    private val boardRepository: BoardRepository
) {

    fun getBoards(keyword: String, pageRequest: PageRequest): Page<Board> {
        return if (keyword.isBlank()) {
            // 키워드가 없으면 전체 조회
            boardRepository.findAll(pageRequest)
        } else {
            // 키워드가 있으면 제목이나 내용에서 검색
            boardRepository.findByTitleContainingOrContentContaining(
                keyword,
                keyword,
                pageRequest
            )
        }
    }

    fun addBoard(boardAddDto: BoardAddDto): Long? {
        val board = boardRepository.save(Board.create(boardAddDto))
        return board.id
    }

    fun findById(id: Long): BoardResponse {
        return boardRepository.findById(id).map { it.toResponse() }.orElseThrow {
            throw BoardNotFoundException("게시글을 찾을 수 없습니다.")
        }
    }
}

class BoardNotFoundException(msg: String) : RuntimeException(msg)