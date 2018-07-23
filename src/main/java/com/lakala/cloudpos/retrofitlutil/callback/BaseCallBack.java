package com.lakala.cloudpos.retrofitlutil.callback;

import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * BaseCallBack
 * Created by dingqq on 2018/7/13.
 */

public abstract class BaseCallBack<T> {

    abstract public void onSuccess(T response);

    abstract public void onFail(int code, String msg, Throwable e);

    abstract public T parseResponse(Response<ResponseBody> response);

    abstract public void progress(float progress, long total);
}
