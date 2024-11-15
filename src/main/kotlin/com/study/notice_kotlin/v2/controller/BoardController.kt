package com.study.notice_kotlin.v2.controller

import com.study.notice_kotlin.v2.BoardService
import com.study.notice_kotlin.v2.dto.BoardAddDto
import com.study.notice_kotlin.v2.dto.BoardFind
import com.study.notice_kotlin.v2.dto.BoardResponse
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.*

@RequestMapping("/api/v1/boards")
class BoardController(
    private val boardService: BoardService
) {

    @GetMapping
    fun getBoards(boardFind: BoardFind): Page<BoardResponse> =
        boardService.getBoards(boardFind.keyword, PageRequest.of(boardFind.page, boardFind.size))
            .map { it.toResponse() }

    @PostMapping
    fun save(@RequestBody @Valid boardAddDto: BoardAddDto):
            Long? = boardService.addBoard(boardAddDto)

    @GetMapping("/{id}")
    fun getBoardById(@PathVariable id: Long): BoardResponse {
        return boardService.findById(id)
    }
}