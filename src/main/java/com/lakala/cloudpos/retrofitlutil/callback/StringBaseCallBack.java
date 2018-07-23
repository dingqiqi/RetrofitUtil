package com.lakala.cloudpos.retrofitlutil.callback;

import java.io.IOException;

import okhttp3.Response;
import okhttp3.ResponseBody;


/**
 * StringBaseCallBack
 * Created by dingqq on 2018/7/13.
 */

public abstract class StringBaseCallBack extends BaseCallBack<String> {

    @Override
    public String parseResponse(retrofit2.Response<ResponseBody> response) {
        ResponseBody body = response.body();
        if (body == null) {
            return null;
        }

        try {
            return body.string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
