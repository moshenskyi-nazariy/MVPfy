package com.moshenskyi.mvpfy.view;

/**
 * Base MvpView with showing/hiding loading bar feature
 *
 * @see com.moshenskyi.mvpfy.presenter.BaseLoadingRxPresenter
 */
public interface BaseLoadingMvpView extends BaseMvpView {

    void showLoadingBar();

    void hideLoadingBar();

}