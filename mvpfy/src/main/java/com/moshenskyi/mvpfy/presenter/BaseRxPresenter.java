package com.moshenskyi.mvpfy.presenter;

import android.support.annotation.CallSuper;

import com.moshenskyi.mvpfy.view.BaseMvpView;

import io.reactivex.ObservableTransformer;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Base presenter with RxJava support. Added {@link CompositeDisposable} and its clearing on
 * {@link #detachView()}
 *
 * @param <T> - view, subclass of {@link BaseMvpView}
 * @param <V> - data class to work with presenter
 */
public abstract class BaseRxPresenter<T extends BaseMvpView, V> extends BasePresenter<T> {
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    @CallSuper
    @Override
    public void detachView() {
        super.detachView();
        compositeDisposable.clear();
    }

    protected CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    /**
     *
     * @return {@link ObservableTransformer} for showing/hiding loading bar
     */
    protected abstract ObservableTransformer<V, V> getProgressTransformer();
}
