package com.lakala.cloudpos.retrofitlutil;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

import com.lakala.cloudpos.retrofitlutil.builder.GetBuilder;
import com.lakala.cloudpos.retrofitlutil.builder.PostBuilder;
import com.lakala.cloudpos.retrofitlutil.builder.PostFormFileBuilder;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * RetrofitUtil
 * Created by dingqq on 2018/7/18.
 */

public class RetrofitUtil {
    //默认超时时间
    private static final int DEFAULT_TIME_OUT = 20;

    private static OkHttpClient mOkHttpClient;

    private Handler mHandler = new Handler(Looper.getMainLooper());

    private static Retrofit mRetrofit;

    private RetrofitUtil() {
    }

    public static RetrofitUtil getInstance() {
        return RetrofitUtilInstance.mInstance;
    }

    private static class RetrofitUtilInstance {
        private static final RetrofitUtil mInstance = new RetrofitUtil();
    }

    /**
     * 初始化okHttp
     *
     * @param timeOut          超时时间
     * @param sSlSocketFactory https验证
     * @param hostNameVerify   域名校验
     */
    public static OkHttpClient initOkHttpClient(int timeOut, SSLSocketFactory sSlSocketFactory, HostnameVerifier hostNameVerify) {
        OkHttpClient.Builder builder = (mOkHttpClient == null) ? new OkHttpClient.Builder() : mOkHttpClient.newBuilder();

        if (timeOut <= 0) {
            timeOut = DEFAULT_TIME_OUT;
        }

        builder.readTimeout(timeOut, TimeUnit.SECONDS)
                .writeTimeout(timeOut, TimeUnit.SECONDS)
                .writeTimeout(timeOut, TimeUnit.SECONDS);

        if (sSlSocketFactory != null) {
            builder.sslSocketFactory(sSlSocketFactory);
        }

        if (hostNameVerify != null) {
            builder.hostnameVerifier(hostNameVerify);
        }

        mOkHttpClient = builder.build();

        return mOkHttpClient;
    }

    /**
     * 初始化retrofit
     *
     * @param baseUrl    统一的请求前缀
     * @param httpClient okHttpClient
     */
    public static void initRetrofit(String baseUrl, OkHttpClient httpClient) {
        Retrofit.Builder builder = new Retrofit.Builder();

        if (!TextUtils.isEmpty(baseUrl)) {
            builder.baseUrl(baseUrl);
        }

        //Json 解析
        mRetrofit = builder.client(httpClient)
                //返回String
                .addConverterFactory(ScalarsConverterFactory.create())
                //返回json数据
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static GetBuilder get() {
        return new GetBuilder();
    }

    public static PostFormFileBuilder postFrom() {
        return new PostFormFileBuilder();
    }

    public static PostBuilder postString() {
        return new PostBuilder();
    }

    public static PostFormFileBuilder postFile() {
        return new PostFormFileBuilder();
    }

    public static GetBuilder download() {
        return new GetBuilder();
    }

    public Handler getHandler() {
        return mHandler;
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }
}
