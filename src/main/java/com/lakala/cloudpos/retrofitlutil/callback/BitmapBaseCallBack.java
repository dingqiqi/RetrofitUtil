package com.lakala.cloudpos.retrofitlutil.callback;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * BitmapBaseCallBack
 * Created by dingqq on 2018/7/13.
 */

public abstract class BitmapBaseCallBack extends BaseCallBack<Bitmap> {

    @Override
    public Bitmap parseResponse(retrofit2.Response<ResponseBody> response){
        ResponseBody body = response.body();
        if (body == null) {
            return null;
        }
        return BitmapFactory.decodeStream(body.byteStream());
    }

}
