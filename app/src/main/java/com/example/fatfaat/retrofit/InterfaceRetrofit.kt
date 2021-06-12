package com.example.fatfaat.retrofit

import com.example.fatfaat.LoginData
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

//base URL : http://127.0.0.1:8000


// C  = POST-> INSERT
// R  = GET -> SELECT
// U  = PUT-> UPDATE
// D  = DELETE -> DELETE

interface InterfaceRetrofit {
    // @Field parameters can only be used with form encoding. -> 이 Annotation으로 파라미터 인코딩 에러 해결
    @FormUrlEncoded

    @POST("/app_login")
    fun loginRequest(@Field("user_email") user_email: String,
                     @Field("user_pw") user_pw : String
    ): Call<LoginData>
}

