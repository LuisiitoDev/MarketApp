package com.luis.marketapp.model

import java.util.*

data class Product(val name : String, val quantity : Int, val price : Double, val stock : Int, val storeId : UUID)
{
    val productId : UUID = UUID(0L,0L)
}