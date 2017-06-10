package com.example.demo.repository

import com.example.demo.model.User
import org.springframework.data.repository.CrudRepository

/**
 * Created by divine on 2017/06/08.
 */
interface UserRepo : CrudRepository<User, Long> {
    fun findByUsername(username: String): User
}