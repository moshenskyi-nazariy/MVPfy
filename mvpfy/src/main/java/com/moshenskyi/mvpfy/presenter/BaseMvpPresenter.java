package com.moshenskyi.mvpfy.presenter;

import com.moshenskyi.mvpfy.view.BaseMvpView;

public interface BaseMvpPresenter<T extends BaseMvpView> {
    void attachView(T view);

    void detachView();
}
