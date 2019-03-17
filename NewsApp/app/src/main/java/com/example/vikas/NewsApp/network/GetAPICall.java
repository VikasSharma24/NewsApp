package com.example.vikas.NewsApp.network;

import com.example.vikas.NewsApp.news.NewsPresenterImpl;
import com.example.vikas.NewsApp.pojo.ResponseValue;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by vikas on 3/15/2019.
 */


/*The GetAPICall Class */
public class GetAPICall {
    RetrofitInstance retrofitInstance;
    NewsPresenterImpl newsPresenter;
    public GetAPICall(NewsPresenterImpl newsPresenter) {
        this.newsPresenter=newsPresenter;
    }

    public void getBusinessApi(){

        retrofitInstance.getRetrofitInstance().create(UrlService.class)
                .getBusiness().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseValue>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(ResponseValue responseValue) {
                        System.out.println("re +++n  " + responseValue.getStatus());
                        newsPresenter.setData(responseValue);
                    }
                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
    public void getEntertainmentApi(){

        retrofitInstance.getRetrofitInstance().create(UrlService.class)
                .geteEntertainment().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseValue>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(ResponseValue responseValue) {
                        System.out.println("re +++n  " + responseValue.getStatus());
                        newsPresenter.setData(responseValue);
                    }
                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
    public void getHealthApi(){

        retrofitInstance.getRetrofitInstance().create(UrlService.class)
                .getHeath().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseValue>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(ResponseValue responseValue) {
                        System.out.println("re +++n  " + responseValue.getStatus());
                        newsPresenter.setData(responseValue);
                    }
                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
    public void getScience(){

        retrofitInstance.getRetrofitInstance().create(UrlService.class)
                .getScience().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseValue>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(ResponseValue responseValue) {
                        System.out.println("re +++n  " + responseValue.getStatus());
                        newsPresenter.setData(responseValue);
                    }
                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
    public void getSports(){

        retrofitInstance.getRetrofitInstance().create(UrlService.class)
                .getSports().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseValue>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(ResponseValue responseValue) {
                        System.out.println("re +++n  " + responseValue.getStatus());
                        newsPresenter.setData(responseValue);
                    }
                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
    public void getTechonolgy(){

        retrofitInstance.getRetrofitInstance().create(UrlService.class)
                .getTechonolgy().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseValue>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(ResponseValue responseValue) {
                        System.out.println("re +++n  " + responseValue.getStatus());
                        newsPresenter.setData(responseValue);
                    }
                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
    public interface SetData{
        public void setData(ResponseValue value);
    }



}
