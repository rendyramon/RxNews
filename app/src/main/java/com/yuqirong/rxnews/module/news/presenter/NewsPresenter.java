package com.yuqirong.rxnews.module.news.presenter;

import com.yuqirong.rxnews.event.NewsEvent;
import com.yuqirong.rxnews.module.news.model.NewsInteractor;
import com.yuqirong.rxnews.module.news.model.impl.NewsInteractorImpl;
import com.yuqirong.rxnews.module.news.view.INewsView;

/**
 * Created by Anyway on 2016/3/9.
 */
public class NewsPresenter {

    private NewsInteractor mNewsInteractor;
    private INewsView mINewsView;

    public NewsPresenter(INewsView mINewsView) {
        this.mINewsView = mINewsView;
        mNewsInteractor = new NewsInteractorImpl();
    }

    public void initViews(int taskId, String id) {
        showLoading();
        mNewsInteractor.initNews(taskId, id);
    }

    public void getNews(int taskId, String type, String id, int startPage) {
        mNewsInteractor.getNews(taskId, type, id, startPage);
    }

    public void showSuccess(NewsEvent newsEvent) {
        mINewsView.showSuccess(newsEvent);
        clearLoading();
    }

    public void showError() {
        mINewsView.showError();
        //        clearLoading();
    }

    public void showLoading() {
        mINewsView.showLoading();
    }

    public void clearLoading() {
        mINewsView.clearLoading();
    }

}
