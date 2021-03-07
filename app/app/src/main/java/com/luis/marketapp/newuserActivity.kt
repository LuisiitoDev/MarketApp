package com.luis.marketapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.luis.marketapp.interfaces.IResponseView
import com.luis.marketapp.model.User
import com.luis.marketapp.viewmodel.NewUserViewModel

class newuserActivity : AppCompatActivity() {

    private lateinit var userFirstName : TextInputEditText
    private lateinit var userLastName : TextInputEditText
    private lateinit var userEmail : TextInputEditText
    private lateinit var userPhone : TextInputEditText
    private lateinit var userPassword : TextInputEditText
    private lateinit var btnSingUpUser : MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newuser)
        supportActionBar!!.hide()

        userFirstName = findViewById(R.id.userFirstName)
        userLastName = findViewById(R.id.userLastName)
        userEmail = findViewById(R.id.userEmail)
        userPassword = findViewById(R.id.userPassword)
        userPhone = findViewById(R.id.userPhone)
        btnSingUpUser = findViewById(R.id.btnCreateUser)

        var model = ViewModelProviders.of(this).get(NewUserViewModel::class.java)

        btnSingUpUser.setOnClickListener {
            val user = User(userFirstName.text.toString() ?: "",
                            userLastName.text.toString() ?: "",
                               userPhone.text.toString() ?: "",
                                userEmail.text.toString() ?: "",
                            userPassword.text.toString() ?: "")

            var(error,message) = model.validateFormUser(user)

            if (error){
                Toast.makeText(this,message,Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            model.singUpUser(user,object  : IResponseView<Boolean>{
                override fun getResponse(result: Boolean) {
                    if (!result){
                        Toast.makeText(applicationContext,"the user cannot be created, please try again",Toast.LENGTH_LONG).show()
                    }
                    else{
                        Toast.makeText(applicationContext,"the user was created successfully",Toast.LENGTH_LONG).show()
                    }
                }

                override fun throwException(ex: String) {
                    Toast.makeText(applicationContext,"Something was wrong :(, try again please",Toast.LENGTH_LONG).show()
                }

            })
        }
    }


}