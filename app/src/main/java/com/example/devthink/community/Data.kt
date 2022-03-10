package com.example.devthink.community

data class Content(
    var title: String? = "",
    var date: String? = "",
    var nickname: String? = "",
    var like: Int? = null
)

data class Project(
    var title: String? = "",
    var num: Int? = null,
    var job: String?= "",
    var date: String?= "",
    var nickname: String?
)
