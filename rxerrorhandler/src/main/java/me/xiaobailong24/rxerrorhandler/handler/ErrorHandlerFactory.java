package me.xiaobailong24.rxerrorhandler.handler;

import android.content.Context;

import me.xiaobailong24.rxerrorhandler.handler.listener.ResponseErrorListener;


/**
 * Created by xiaobailong24 on 2017/5/2.
 * ErrorHandlerFactory
 */

public class ErrorHandlerFactory {
    private Context mContext;
    private ResponseErrorListener mResponseErrorListener;

    public ErrorHandlerFactory(Context mContext, ResponseErrorListener mResponseErrorListener) {
        this.mResponseErrorListener = mResponseErrorListener;
        this.mContext = mContext;
    }

    /**
     * 处理错误
     *
     * @param throwable 异常
     */
    public void handleError(Throwable throwable) {
        mResponseErrorListener.handleResponseError(mContext, (Exception) throwable);
    }
}
