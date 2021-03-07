package com.luis.marketapp.model

import java.util.*

data class Store(val storeName : String, val storeDescription : String, val latitude : Double, val longitude : Double){
    val storeId : UUID = UUID(0L,0L)
}
