package com.lakala.cloudpos.retrofitlutil.call;

import android.util.Log;

import com.lakala.cloudpos.retrofitlutil.RetrofitUtil;
import com.lakala.cloudpos.retrofitlutil.callback.BaseCallBack;
import com.lakala.cloudpos.retrofitlutil.request.BaseRequest;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * RetrofitCall
 * Created by dingqq on 2018/7/18.
 */

public class RetrofitCall {

    private BaseRequest mBaseRequest;

    private Call<ResponseBody> mCall;

    public RetrofitCall(BaseRequest baseBuilder) {
        this.mBaseRequest = baseBuilder;
    }

    public Call<ResponseBody> getCall() {
        return mCall;
    }

    /**
     * 异步执行
     *
     * @param callBack 回调
     */
    public void execute(final BaseCallBack callBack) {
        if (callBack == null) {
            return;
        }

        mCall = mBaseRequest.buildCall(mBaseRequest.buildRequest());

        if (mCall != null) {
            mCall.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, final Response<ResponseBody> response) {
                    if (!call.isCanceled()) {
                        final Object o = callBack.parseResponse(response);

                        RetrofitUtil.getInstance().getHandler().post(new Runnable() {
                            @Override
                            public void run() {
                                if (response.isSuccessful()) {
                                    callBack.onSuccess(o);
                                } else {
                                    callBack.onFail(response.code(), response.message(), new IllegalArgumentException(response.message()));
                                }
                            }
                        });
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, final Throwable t) {
                    if (!call.isCanceled()) {
                        RetrofitUtil.getInstance().getHandler().post(new Runnable() {
                            @Override
                            public void run() {
                                callBack.onFail(0, t.getMessage(), t);
                            }
                        });

                    }
                }
            });

        } else {
            throw new IllegalArgumentException("buildRequest is null");
        }

    }

    /**
     * 同步执行
     *
     * @return 返回值
     * @throws IOException 异常
     */
    public Response<ResponseBody> execute() throws IOException {
        mCall = mBaseRequest.buildCall(mBaseRequest.buildRequest());

        if (mCall != null) {
            return mCall.execute();
        } else {
            throw new IllegalArgumentException("buildRequest is null");
        }
    }

    public void cancel() {
        if (mCall != null) {
            mCall.cancel();
        }
    }
}
