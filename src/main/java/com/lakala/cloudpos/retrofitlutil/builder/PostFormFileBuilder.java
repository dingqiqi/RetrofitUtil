package com.lakala.cloudpos.retrofitlutil.builder;

import com.lakala.cloudpos.retrofitlutil.call.RetrofitCall;
import com.lakala.cloudpos.retrofitlutil.inter.ParamInter;
import com.lakala.cloudpos.retrofitlutil.request.PostFormFileRequest;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;

/**
 * PostFormFileBuilder
 * Created by dingqq on 2018/7/18.
 */

public class PostFormFileBuilder extends BaseBuilder<PostFormFileBuilder> implements ParamInter<PostFormFileBuilder> {

    private List<File> files;

    private MediaType mediaType;

    public PostFormFileBuilder addFile(File file) {
        if (files == null) {
            files = new ArrayList<>();
        }
        this.files.add(file);
        return this;
    }

    public PostFormFileBuilder files(List<File> files) {
        this.files = files;
        return this;
    }

    public PostFormFileBuilder mediaType(MediaType mediaType) {
        this.mediaType = mediaType;
        return this;
    }

    @Override
    public PostFormFileBuilder addParam(String key, String value) {
        if (params == null) {
            params = new HashMap<>();
        }
        params.put(key, value);
        return this;
    }

    @Override
    public PostFormFileBuilder params(Map<String, String> params) {
        this.params = params;
        return this;
    }

    @Override
    public RetrofitCall build() {
        return new PostFormFileRequest(url, heads, params, mediaType, files).build();
    }
}
