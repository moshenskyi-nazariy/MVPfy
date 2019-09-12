package com.moshenskyi.mvpfy.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.moshenskyi.mvpfy.presenter.BaseMvpPresenter;

public abstract class BaseActivity<T extends BaseMvpPresenter<E>, E extends BaseMvpView>
        extends AppCompatActivity implements BaseMvpView {
    protected T presenter;

    protected abstract T createPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (presenter == null) {
            if ((presenter = createPresenter()) == null) {
                throw new NullPointerException("Presenter shouldn't be null");
            }
        }
        presenter.attachView((E) this);
    }

    public T getPresenter() {
        return presenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
        }
    }
}
