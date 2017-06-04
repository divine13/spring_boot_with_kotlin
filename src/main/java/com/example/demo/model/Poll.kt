package com.example.demo.model

import org.springframework.beans.factory.annotation.Autowired

import javax.persistence.*
import java.util.logging.Level
import java.util.logging.Logger

/**
 * Created by divine on 2017/06/04.
 */

@Entity
class Poll {

    @Id
    @GeneratedValue
    @Column(name = "POLL_ID")
    var Id: Long? = null

    @Column(name = "QUESTION")
    lateinit var question: String

    //this poll has one to many option makes sense year!!!
    @OneToMany(cascade = arrayOf(CascadeType.ALL))
    @JoinColumn(name = "POLL_ID")
    @OrderBy // this the order in which we get the polls
    lateinit var options: Set<Option> // lateinit??!! running away from NPEs!!!



}
