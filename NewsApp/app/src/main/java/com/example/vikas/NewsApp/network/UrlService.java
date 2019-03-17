package com.example.vikas.NewsApp.network;

/**
 * Created by vikas on 3/15/2019.
 */



import com.example.vikas.NewsApp.pojo.ResponseValue;

import io.reactivex.Observable;
import retrofit2.http.GET;

/*Url Service Interface*/
public interface UrlService {

    @GET("v2/sources?language=en&apiKey=c2909f54bbd84e4d89dc34c3f282885f")
    Observable<ResponseValue> getNews();

    @GET("v2/top-headlines?country=in&category=business&apiKey=c2909f54bbd84e4d89dc34c3f282885f")
    Observable<ResponseValue> getBusiness();

    @GET("v2/top-headlines?country=in&category=entertainment&apiKey=c2909f54bbd84e4d89dc34c3f282885f")
    Observable<ResponseValue> geteEntertainment();
    @GET("v2/top-headlines?country=in&category=health&apiKey=c2909f54bbd84e4d89dc34c3f282885f")
    Observable<ResponseValue> getHeath();

    @GET("v2/top-headlines?country=in&category=science&apiKey=c2909f54bbd84e4d89dc34c3f282885f")
    Observable<ResponseValue> getScience();

    @GET("v2/top-headlines?country=in&category=sports&apiKey=c2909f54bbd84e4d89dc34c3f282885f")
    Observable<ResponseValue> getSports();

    @GET("v2/top-headlines?country=in&category=technology&apiKey=c2909f54bbd84e4d89dc34c3f282885f")
    Observable<ResponseValue> getTechonolgy();
}
