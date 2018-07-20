package com.lakala.cloudpos.retrofitlutil.inter;

import com.lakala.cloudpos.retrofitlutil.builder.BaseBuilder;

import java.util.Map;

/**
 * Created by dingqq on 2018/7/18.
 */

public interface ParamInter<T extends BaseBuilder> {

    T addParam(String key, String value);

    T params(Map<String,String> params);
}
