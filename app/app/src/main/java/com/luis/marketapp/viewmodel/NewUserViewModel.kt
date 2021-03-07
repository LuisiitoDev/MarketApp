package com.luis.marketapp.viewmodel

import androidx.lifecycle.ViewModel
import com.luis.marketapp.interfaces.IResponseView
import com.luis.marketapp.model.User
import com.luis.marketapp.services.market.IMarketService
import com.luis.marketapp.utils.validations
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewUserViewModel : ViewModel() {

    // it was configure the retrofit service using lazy
    private val marketService by lazy {
        IMarketService.Create()
    }

    // Pair<Boolean,String> => Boolean = isError, String = errorMessage
    fun validateFormUser(user: User) : Pair<Boolean,String>{

        if (user.firstName.isNullOrEmpty()){
            return Pair(true,"It is required to type the first name")
        }

        if (user.lastName.isNullOrEmpty()){
            return  Pair(true,"it is required to type the last name")
        }

        if (!validations.isValidEmail(user.email)){
            return Pair(true,"The email typed, it is not correct")
        }

        if (!validations.isValidPhone(user.phone)){
            return Pair(true,"the phone typed, it nos correct")
        }

        if (user.password.isNullOrEmpty()){
            return Pair(true,"the password is required")
        }

        return  Pair(false,"")
    }

    // it allows to create a new user
    fun singUpUser(user : User, callbackView : IResponseView<Boolean>){

        marketService.CreateUser(user)
            .enqueue(object : Callback<Boolean>{
                override fun onFailure(call: Call<Boolean>, t: Throwable) {
                    callbackView.throwException(t.toString())
                }

                override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                    val created = response.body()
                    callbackView.getResponse(created ?: false)
                }

            })
    }
}