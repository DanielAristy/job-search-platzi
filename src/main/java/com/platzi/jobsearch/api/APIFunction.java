package com.platzi.jobsearch.api;

import feign.Feign;
import feign.gson.GsonDecoder;

/**Generar objetos de tipo API*/
public interface APIFunction {

    /**Generar un objeto de API*/
    static <T> T buildAPI(Class<T> clazz, String url){
        return Feign.builder()
                .decoder(new GsonDecoder())
                .target(clazz, url);
    }
}
