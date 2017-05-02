package me.xiaobailong24.rxerrorhandler.core;

import android.content.Context;

import me.xiaobailong24.rxerrorhandler.handler.ErrorHandlerFactory;
import me.xiaobailong24.rxerrorhandler.handler.listener.ResponseErrorListener;

/**
 * Created by xiaobailong24 on 2017/5/2.
 * RxErrorHandler
 */

public class RxErrorHandler {

    public final String TAG = this.getClass().getSimpleName();
    private ErrorHandlerFactory mHandlerFactory;

    private RxErrorHandler(Builder builder) {
        this.mHandlerFactory = builder.errorHandlerFactory;
    }

    public static Builder builder() {
        return new Builder();
    }

    public ErrorHandlerFactory getHandlerFactory() {
        return mHandlerFactory;
    }

    public static final class Builder {
        private Context context;
        private ResponseErrorListener responseErrorListener;
        private ErrorHandlerFactory errorHandlerFactory;

        private Builder() {
        }

        public Builder with(Context context) {
            this.context = context;
            return this;
        }

        public Builder responseErrorListener(ResponseErrorListener responseErrorListener) {
            this.responseErrorListener = responseErrorListener;
            return this;
        }

        public RxErrorHandler build() {
            if (context == null)
                throw new IllegalStateException("context is required");

            if (responseErrorListener == null)
                throw new IllegalStateException("responseErrorListener is required");

            this.errorHandlerFactory = new ErrorHandlerFactory(context, responseErrorListener);

            return new RxErrorHandler(this);
        }
    }
}
