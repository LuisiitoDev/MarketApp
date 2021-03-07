package com.luis.marketapp.utils

class validations{
    companion object{

        fun isValidEmail(email : String): Boolean {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }

        fun isValidPhone(phone : String) : Boolean{
            return  android.util.Patterns.PHONE.matcher(phone).matches()
        }
    }
}