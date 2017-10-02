package com.mvpconcept.injection

import com.mvpconcept.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

@Module
class NetworkModule {

    private val CONNECTION_TIMEOUT_IN_SECONDS = 30L
    private val SOCKET_READ_TIMEOUT_IN_SECONDS = 30L

    @Provides
    fun provideOkHttpClient(): OkHttpClient =
            if (BuildConfig.DEBUG) {
                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY;
                OkHttpClient.Builder()
                        .connectTimeout(CONNECTION_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
                        .readTimeout(SOCKET_READ_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
                        .addInterceptor(logging)
                        .build()
            } else {
                OkHttpClient.Builder().build()
            }
}