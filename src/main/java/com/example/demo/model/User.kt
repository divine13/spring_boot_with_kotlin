package com.example.demo.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.Type
import org.hibernate.validator.constraints.NotEmpty
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * Created by divine on 2017/06/08.
 */

@Entity
class User {


    @Id
    @GeneratedValue
    @Column(name = "USERS_ID")
    private val id: Long = 0

    @Column(name = "USERNAME")
    @NotEmpty // not null an empty
    lateinit var username: String

    @JsonIgnore // will be ignired when we call the toString of this class!
    @Column(name = "PASSWORD")
    @NotEmpty
    val password: String? = null

    @Column(name = "FIRST_NAME")
    @NotEmpty // not null an empty
     val firstName: String? = null

    @Column(name = "LAST_NAME")
    @NotEmpty // not null an empty
    private val lastName: String? = null

    @Column(name = "ADMIN")
    @NotEmpty // not null an empty
    @Type(type="yes_no")
    var admin: Boolean = false

}
