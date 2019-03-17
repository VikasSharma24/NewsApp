package com.example.vikas.NewsApp.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by vikas on 3/12/2019.
 */

public class ResponseValue {

    String status;

    @SerializedName("articles")
    public List<Sources> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Sources> getArticles() {
        return articles;
    }

    public void setArticles(List<Sources> articles) {
        this.articles = articles;
    }
}
