package com.moshenskyi.mvpfy.presenter;

import android.support.annotation.CallSuper;

import com.moshenskyi.mvpfy.view.BaseMvpView;

/**
 * Base presenter
 *
 * @see BaseMvpPresenter
 * @see BaseRxPresenter
 * @see BaseLoadingRxPresenter
 * @param <T>
 */
public abstract class BasePresenter<T extends BaseMvpView> implements BaseMvpPresenter<T> {
    private T view;

    @CallSuper
    @Override
    public void attachView(T view) {
        this.view = view;
    }

    @CallSuper
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
