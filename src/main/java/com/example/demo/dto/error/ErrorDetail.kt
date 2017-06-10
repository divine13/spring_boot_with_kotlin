package com.example.demo.dto.error

/**
 * Created by divine on 2017/06/04.
 */
data class ErrorDetail( var timeStamp: Long,
                        var status: Int,
                        var title: String,
                        var detail: String,
                        var developerMessage: String)