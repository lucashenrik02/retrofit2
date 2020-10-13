package com.example.retrofit2.bootstrap;

/*
* Passo 3 - criar classe para mapear  ENDPOINT e configurar classe para fazer o PARSER.
* Converter o JSON para objeto.
* */

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    public static final String ENDPOINT = "https://jsonplaceholder.typicode.com/";

    public static Retrofit getClient(){

        return new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
