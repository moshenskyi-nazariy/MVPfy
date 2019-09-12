package com.moshenskyi.mvpfy.presenter;

import com.moshenskyi.mvpfy.view.BaseMvpView;

public abstract class BasePresenter<T extends BaseMvpView> implements BaseMvpPresenter<T> {
    private T view;

    @Override
    public void attachView(T view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        if (view != null) {
            view = null;
        }
    }

    protected T getView() {
        return view;
    }
}
