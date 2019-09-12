package com.moshenskyi.mvpfy.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.moshenskyi.mvpfy.presenter.BaseMvpPresenter;

public abstract class BaseFragment<T extends BaseMvpPresenter<E>, E extends BaseMvpView> extends
        Fragment implements BaseMvpView {
    protected T presenter;

    protected abstract T createPresenter();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if ((presenter = createPresenter()) == null) {
            throw new NullPointerException("Presenter shouldn't be null");
        }
        presenter.attachView((E) this);
    }

    public T getPresenter() {
        return presenter;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (presenter != null) {
            presenter.detachView();
        }
    }
}
