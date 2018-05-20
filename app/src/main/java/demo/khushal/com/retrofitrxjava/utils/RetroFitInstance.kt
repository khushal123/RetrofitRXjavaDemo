package demo.khushal.com.retrofitrxjava.utils

import javax.xml.datatype.DatatypeConstants.SECONDS
import okhttp3.OkHttpClient
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import com.google.gson.GsonBuilder
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit


object RetroFitInstance {
    @JvmStatic
    fun createSimpleRequest(): Retrofit {
        val okHttpClient:OkHttpClient = OkHttpClient().newBuilder()  .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build()
        var retrofit = Retrofit.Builder().baseUrl(Api.base_url).client(okHttpClient).addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build()
        return retrofit;
    }
}