package me.xiaobailong24.rxerrorhandler.handler;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import me.xiaobailong24.rxerrorhandler.core.RxErrorHandler;

/**
 * Created by xiaobailong24 on 2017/5/2.
 * ErrorHandleSubscriber
 */

public abstract class ErrorHandleSubscriber<T> implements Observer<T> {
    private ErrorHandlerFactory mHandlerFactory;

    public ErrorHandleSubscriber(RxErrorHandler errorHandler) {
        mHandlerFactory = errorHandler.getHandlerFactory();
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onError(Throwable t) {
        t.printStackTrace();
        mHandlerFactory.handleError(t);
    }

    @Override
    public void onComplete() {

    }

}
