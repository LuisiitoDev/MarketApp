package com.luis.marketapp.interfaces

import java.lang.Exception

interface IResponseView<Response> {

    fun getResponse(result : Response)

    fun throwException(ex : String)
}