package com.example.vikas.NewsApp.news;

import com.example.vikas.NewsApp.pojo.Sources;

import java.util.List;

/**
 * Created by vikas on 3/15/2019.
 */

/*Create the View Interface*/
public interface NewsMvpView {
    public  void showProgress();
    public void dismissProgress();
    public void bindDataList(List<Sources> list);


}
