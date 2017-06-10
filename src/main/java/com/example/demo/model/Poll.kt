package com.example.demo.model

import org.hibernate.validator.constraints.NotEmpty
import javax.persistence.*
import javax.validation.constraints.Size

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
    @NotEmpty
    lateinit var question: String

    //this poll has one to many option makes sense year!!!
    @OneToMany(cascade = arrayOf(CascadeType.ALL))
    @JoinColumn(name = "POLL_ID")
    @OrderBy // this the order in which we get the polls
    @Size(min=2, max = 10) // min and max options
    lateinit var options: Set<Option> // lateinit??!! running away from NPEs!!!



}
