package com.example.devthink.Data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserTable")
data class User(
    var email: String,
    var password: String,
    var phone: String,
    var name: String,
    var nickname: String,
    var job: String,
    var stack: String, // list
    var blog: String,
    var github: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
