package com.moshenskyi.mvpfy.presenter;

import com.moshenskyi.mvpfy.view.BaseMvpView;

/**
 * Base presenter interface
 *
 * @see BasePresenter
 * @see BaseRxPresenter
 * @see BaseLoadingRxPresenter
 *
 * @param <T> view, subclass of {@link BaseMvpView}
 */
public interface BaseMvpPresenter<T extends BaseMvpView> {
    /**
     * Attach view to presenter context
     *
     * @param view - subclass of {@link BaseMvpView}
     */
    void attachView(T view);

    /**
     * Detach view from presenter context
     */
    void detachView();
}
