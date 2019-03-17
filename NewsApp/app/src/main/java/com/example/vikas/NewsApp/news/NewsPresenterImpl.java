package com.example.vikas.NewsApp.news;

import com.example.vikas.NewsApp.network.GetAPICall;
import com.example.vikas.NewsApp.pojo.ResponseValue;

/**
 * Created by vikas on 3/15/2019.
 */

/*Create the presenter Class to with the Implements of GetAPICall and Presenter Interface*/
public class NewsPresenterImpl implements GetAPICall.SetData,NewsMvpPresenter {

  NewsMvpView viewInstance;
    GetAPICall getIpiCall;
    @Override
    public void getData(String Category) {
        viewInstance. showProgress();
        getIpiCall =new GetAPICall(this);

        if (Category.equals("business"))
            getIpiCall.getBusinessApi();
        else if (Category.equals("entertainment"))
            getIpiCall.getEntertainmentApi();
        else if (Category.equals("health"))
            getIpiCall.getHealthApi();
        else if (Category.equals("science"))
            getIpiCall.getScience();
        else if (Category.equals("sports"))
            getIpiCall.getSports();
        else if (Category.equals("technology"))
            getIpiCall.getTechonolgy();

    }

    public NewsPresenterImpl(NewsMvpView viewInstance) {
        this.viewInstance = viewInstance;
    }



    @Override
    public void setData(ResponseValue value) {
      //  viewInstance.dismissProgress();
        viewInstance.bindDataList(value.getArticles());

    }
}
