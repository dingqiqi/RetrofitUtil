package com.lakala.cloudpos.retrofitlutil.builder;

import com.lakala.cloudpos.retrofitlutil.call.RetrofitCall;
import com.lakala.cloudpos.retrofitlutil.request.PostRequest;

import okhttp3.MediaType;

/**
 * PostBuilder
 * Created by dingqq on 2018/7/18.
 */

public class PostBuilder extends BaseBuilder<PostBuilder> {

    private MediaType mediaType;

    private String content;

    public PostBuilder mediaType(MediaType mediaType) {
        this.mediaType = mediaType;
        return this;
    }

    public PostBuilder content(String content) {
        this.content = content;
        return this;
    }

    @Override
    public RetrofitCall build() {
        return new PostRequest(url, heads, params, mediaType, content).build();
    }
}
