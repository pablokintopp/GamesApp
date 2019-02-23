package com.kintopp.pablo.igdbapp.di;

import com.kintopp.pablo.igdbapp.BuildConfig;
import com.kintopp.pablo.igdbapp.data.GameApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {
    public final String BASE_URL = "https://api-v3.igdb.com/";
    public final String API_KEY = BuildConfig.API_KEY;
    public final String HEADER_AUTH = BuildConfig.HEADER_AUTH;

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder();
        httpBuilder.addInterceptor(loggingInterceptor);

        httpBuilder.addInterceptor(chain -> {
            Request request = chain.request();
            Request newRequest = request.newBuilder()
                    .addHeader(HEADER_AUTH, API_KEY)
                    .build();
            return chain.proceed(newRequest);
        });

        return httpBuilder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(String baseUrl, OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    @Provides
    @Singleton
    public GameApiService provideGameApiService() {
        return provideRetrofit(BASE_URL, provideOkHttpClient()).create(GameApiService.class);
    }


}
