package com.example.demo.dto.error

import java.util.HashMap

/**
 * Created by divine on 2017/06/05.
 */
 class ValidationErrorDetail() {

    var title: String? = null
    var detail: String? = null
    var path: String? = null
    var developerMessage: String? = null
    var status: Int = 0
    var timeStamp: Long = 0

    var errors: Map<String, List<ValidationErrorDetail>> = HashMap()
}
