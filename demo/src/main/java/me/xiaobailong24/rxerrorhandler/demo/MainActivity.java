package me.xiaobailong24.rxerrorhandler.demo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import io.reactivex.Observable;
import me.xiaobailong24.rxerrorhandler.core.RxErrorHandler;
import me.xiaobailong24.rxerrorhandler.handler.ErrorHandleSubscriber;
import me.xiaobailong24.rxerrorhandler.handler.RetryWithDelay;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RxErrorHandler rxErrorHandler = RxErrorHandler
                .builder()
                .with(this)
                .responseErrorListener((context, e) ->
                        Log.w(TAG, "error handle"))
                .build();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
                    Snackbar.make(view, "error", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null).show();
                    Observable
                            .error(new Exception("error"))
                            .retryWhen(new RetryWithDelay(3, 2))//retry(http connect timeout)
                            .subscribe(new ErrorHandleSubscriber<Object>(rxErrorHandler) {
                                @Override
                                public void onNext(Object o) {
                                    Log.d(TAG, "onNext: ");
                                }
                            });
                }
        );
    }

}
