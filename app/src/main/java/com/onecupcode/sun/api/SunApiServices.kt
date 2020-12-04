package com.onecupcode.sun.api

import com.onecupcode.sun.model.Response
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded


import retrofit2.http.POST

private const val BASE_URL = "http://mapi.sundirect.in"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

//?RID=string&Fdate=string&Tdate=string&Type=string&Mode=string HTTP/1.1
///rbuzz_mapi_tst/s@dsithuikr9584785ghdjh.asmx/Get_DealerWise_DayBook HTTP/1.1
interface SunApiServices{
    @FormUrlEncoded
    @POST("rbuzz_mapi_tst/s@dsithuikr9584785ghdjh.asmx/Get_DealerWise_DayBook")
    suspend fun getGetdetails(@Field("RID") rid: Int = 33,
    @Field("Fdate") fdate: String="2020-10-28",@Field("Tdate") tdate: String = "2020-10-28",
    @Field("Type") type: String="DEBIT",
    @Field("Mode") mode:String = ""): Response
}

object SunApi{
    val retrofitServices : SunApiServices by lazy {
        retrofit.create(SunApiServices::class.java)
    }
}