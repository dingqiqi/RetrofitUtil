package com.lakala.cloudpos.retrofitlutil.callback;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;

import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * BitmapBaseCallBack
 * Created by dingqq on 2018/7/13.
 */

public abstract class BitmapBaseCallBack extends BaseCallBack<Bitmap> {

    @Override
    public Bitmap parseResponse(Response response) throws IOException {
        ResponseBody body = response.body();
        if (body == null) {
            return null;
        }
        return BitmapFactory.decodeStream(body.byteStream());
    }

}
