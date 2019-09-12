package com.moshenskyi.mvpfy.presenter;

import com.moshenskyi.mvpfy.util.RxUtils;
import com.moshenskyi.mvpfy.view.BaseLoadingMvpView;

import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Base presenter with RxJava support and loading feature
 *
 * @see BaseLoadingMvpView
 *
 * @param <T> - view, subclass of {@link BaseLoadingMvpView}
 * @param <V> - data class to work with presenter
 */
public class BaseLoadingRxPresenter<T extends BaseLoadingMvpView, V> extends BaseRxPresenter<T, V> {

    /**
     * Shows loading bar for {@link BaseLoadingMvpView} while {@link io.reactivex.Observable#doOnSubscribe(Consumer)}
     * Hides loading bar for {@link BaseLoadingMvpView} while {@link io.reactivex.Observable#doFinally(Action)}
     *
     * @return {@link ObservableTransformer}
     */
    @Override
    protected ObservableTransformer<V, V> getProgressTransformer() {
        return RxUtils.applyProgressObservable(disposable -> {
            if (getView() != null) {
                getView().showLoadingBar();
            }
        }, () -> {
            if (getView() != null) {
                getView().hideLoadingBar();
            }
        });
    }
}
