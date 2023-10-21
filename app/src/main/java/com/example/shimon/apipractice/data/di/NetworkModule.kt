package com.example.shimon.apipractice.data.di

import com.example.shimon.apipractice.services.AuthService
import com.example.shimon.apipractice.services.UserService
import com.example.shimon.apipractice.utils.AuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit():Retrofit.Builder{

        return Retrofit.Builder()
            .baseUrl("https://api.escuelajs.co/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())

    }
    @Provides
    @Singleton
    fun provideAuthService(retrofit: Retrofit.Builder):AuthService{
        return retrofit.build().create(AuthService::class.java)
    }

    @Provides
    @Singleton
    fun provideHttpClient(authInterceptor: AuthInterceptor):OkHttpClient{
        return OkHttpClient.Builder().addInterceptor(interceptor = authInterceptor).build()
    }

    @Provides
    @Singleton
    fun provideUserService(retrofit: Retrofit.Builder,client: OkHttpClient):UserService{
        return retrofit.client(client).build().create(UserService::class.java)
    }

}