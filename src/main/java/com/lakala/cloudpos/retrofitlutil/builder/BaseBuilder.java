package com.lakala.cloudpos.retrofitlutil.builder;

import com.lakala.cloudpos.retrofitlutil.call.RetrofitCall;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dingqq on 2018/7/18.
 */

public abstract class BaseBuilder<T extends BaseBuilder> {

    protected String url;

    protected Map<String, String> heads;

    protected Map<String, String> params;

    public T url(String url) {
        this.url = url;
        return (T) this;
    }

    public T heads(Map<String, String> heads) {
        this.heads = heads;
        return (T) this;
    }

    public T addHead(String key, String value) {
        if (heads == null) {
            heads = new HashMap<>();
        }
        this.heads.put(key, value);
        return (T) this;
    }

    abstract public RetrofitCall build();
}
