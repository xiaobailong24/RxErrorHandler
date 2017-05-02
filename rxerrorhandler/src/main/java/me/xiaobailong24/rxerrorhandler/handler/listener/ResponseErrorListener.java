package me.xiaobailong24.rxerrorhandler.handler.listener;

import android.content.Context;

/**
 * Created by xiaobailong24 on 2017/5/2.
 * ResponseErrorListener
 */

public interface ResponseErrorListener {
    void handleResponseError(Context context, Exception e);

    ResponseErrorListener EMPTY = (context, e) -> {
        
    };

}
