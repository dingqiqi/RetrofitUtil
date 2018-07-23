package com.lakala.cloudpos.retrofitlutil.request;

import android.text.TextUtils;

import com.lakala.cloudpos.retrofitlutil.RetrofitUtil;
import com.lakala.cloudpos.retrofitlutil.call.RetrofitCall;
import com.lakala.cloudpos.retrofitlutil.inter.BaseRequestInter;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * Created by dingqq on 2018/7/18.
 */
public class PostRequest extends BaseRequest {

    private MediaType DEFAULT_JSON_TYPE = MediaType.parse("application/json; charset=utf-8");

    private MediaType mediaType;

    private String content;

    public PostRequest(String url, Map<String, String> heads, Map<String, String> params,
                       MediaType mediaType, String content) {
        super(url, heads, params);
        this.mediaType = mediaType;
        this.content = content;
    }

    @Override
    public RetrofitCall build() {
        return new RetrofitCall(this);
    }

    @Override
    public BaseRequestInter buildRequest() {
        return RetrofitUtil.getInstance().getRetrofit().create(BaseRequestInter.class);
    }

    @Override
    public Call<ResponseBody> buildCall(BaseRequestInter request) {
        if (request == null) {
            return null;
        }

        //默认json提交
        if (mediaType == null) {
            mediaType = DEFAULT_JSON_TYPE;
        }

        if (TextUtils.isEmpty(content)) {
            throw new IllegalArgumentException("content is null");
        }

        if (heads == null) {
            heads = new HashMap<>();
        }

        return request.doPost(url, RequestBody.create(mediaType, content), heads);
    }
}
