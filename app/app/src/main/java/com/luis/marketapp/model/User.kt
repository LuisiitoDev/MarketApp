package com.luis.marketapp.model

import java.util.*

data class User(val firstName: String, val lastName : String, val phone : String, val email : String,val password : String)
{
    val userId : UUID = UUID(0L,0L)
}