package com.luis.marketapp.services.market

import android.content.ClipData.Item
import com.luis.marketapp.model.Product
import com.luis.marketapp.model.User
import com.luis.marketapp.services.ConstantServices

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.*


interface IMarketService {

    @POST("User/Create")
    fun CreateUser(@Body user : User) : Call<Boolean>
    @POST("User/Delete")
    fun DeleteUser(@Query("userId") userId : UUID) : Call<Boolean>
    @POST("User/Login")
    fun LoginUser(@Header("email") email : String, @Header("password") password : String) : Call<User>

    @POST("Product/Create")
    fun CreateProduct(@Body product: Product) : Call<Boolean>
    @POST("Product/Delete")
    fun  DeleteProduct(@Query("productId") productId : UUID) : Call<Boolean>
    @POST("Product/Update")
    fun UpdateProduct(@Body product: Product) : Call<Boolean>
    @GET("Product")
    fun GetProductById(@Query("productId") productId: UUID) : Call<Product>
    @GET("Product/Store")
    fun GetProductsByStore(@Query("storeId") storeId : UUID) : Call<List<Product>>
    @GET("Product")
    fun GetAllProducts() : Call<List<Product>>

    companion object{
        fun Create() : IMarketService{

            var retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ConstantServices.BASE_ADRESS_API_MARKET)
                .build()

            return retrofit.create(IMarketService::class.java)
        }
    }
}