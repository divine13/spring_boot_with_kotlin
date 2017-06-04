package com.example.demo.model

import javax.persistence.*

/**
 * Created by divine on 2017/06/04.
 */
@Entity
class Vote {

    @Id
    @GeneratedValue
    @Column(name = "VOTE_ID")
    var id: Long? = null


    @ManyToOne
    @JoinColumn(name = "OPTION_ID")
    lateinit var option: Option
}
