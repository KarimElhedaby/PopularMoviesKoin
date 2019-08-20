package com.hamza.soluations.popularmovieskoin

import android.support.multidex.MultiDexApplication
import com.androidnetworking.interceptors.HttpLoggingInterceptor
import com.hamza.soluations.popularmovieskoin.di.applicationModule

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.koinApplication

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import uk.co.chrisjenx.calligraphy.CalligraphyConfig

class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
 //       startKoin(androidContext = this.applicationContext, listOf(applicationModule))
//        chuckInterceptor = ChuckInterceptor(this)
//        }



        startKoin {
            androidContext(this@App)
            androidLogger()
            modules(listOf(applicationModule )
            )
        }
    }



//    companion object {
//        //lateinit var getService: Service
//        var chuckInterceptor: Interceptor? = null
//
//        internal fun createApi(service: Service) {
//
////            val clientBuilder: OkHttpClient.Builder
////            val client: OkHttpClient
////            val interceptor = HttpLoggingInterceptor()
////            interceptor.level = HttpLoggingInterceptor.Level.BASIC
////
////            clientBuilder = OkHttpClient.Builder()
////                .addInterceptor(interceptor)
////
////            apiInterceptor?.let {
////                clientBuilder.addInterceptor(
////                    apiInterceptor
////                )
////            }
////            chuckInterceptor?.let {
////                clientBuilder.addInterceptor(
////                    it
////                )
////            }
////            client = clientBuilder.build()
////
////            val retrofit = Retrofit.Builder()
////                .baseUrl(Constant.BASE_URL)
////                .client(client)
////                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
////                .addConverterFactory(GsonConverterFactory.create())
////                .build()
////
////            getService = retrofit.create(Service::class.java)
//        }
    }
//}
