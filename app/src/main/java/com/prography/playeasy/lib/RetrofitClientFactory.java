package com.prography.playeasy.lib;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientFactory {
    private static Retrofit service = null;
    private static final String BASE_URL="http://api.theplayeasy.com";

    private RetrofitClientFactory() { }
//RestClient에서 기본 URL설정, okhhttp 및 데이터를 파싱하는 GsonCOnverter를 지정한다
    public static <T> T getClient(Class<T> apiInterfaceClass) {
        if (service == null) {
            service = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return apiInterfaceClass.cast(service.create(apiInterfaceClass));
    }
}
