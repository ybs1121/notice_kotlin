package com.study.notice_kotlin.v2.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.Length


class BoardAddDto(
    @NotNull
    @Length(min = 2, max = 100)
    val title: String,
    @NotNull
    @Length(min = 10)
    val content: String,

    @NotNull @NotEmpty
    val author: String
) {


}