package com.example.demo.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * Created by divine on 2017/06/04.
 */

@Entity
class Option {

    @Id
    @GeneratedValue
    @Column(name = "OPTION_ID")
    var id: Long? = null

    @Column(name = "OPTION_VALUE")
    lateinit var value: String

}
