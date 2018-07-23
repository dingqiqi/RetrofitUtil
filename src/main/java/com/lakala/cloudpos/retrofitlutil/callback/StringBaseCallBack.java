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
    public String parseResponse(Response response) throws IOException {
        ResponseBody body = response.body();
        if (body == null) {
            return null;
        }

        return body.string();
    }

}
