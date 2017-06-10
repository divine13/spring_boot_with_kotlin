package com.example.demo.exception

/**
 * Created by divine on 2017/06/04.
 */
class ResourceNotFoundException : RuntimeException {

    constructor(message: String) : super(message)
    constructor(msg: String, cause: Throwable) : super(msg, cause)


    // represents all things static :
    // this is companion Singleton class to the parent class: static class to this class
    companion object {
        private val serialVersionUID = 1L
    }

}
