package com.lakala.cloudpos.retrofitlutil.inter;

import java.io.File;
import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by dingqq on 2018/7/18.
 */

public interface BaseRequestInter {

    @GET
    Call<ResponseBody> doGet(@Url String url, @HeaderMap Map<String, String> heads);

    @FormUrlEncoded
    @POST
    Call<ResponseBody> doPostForm(@Url String url, @FieldMap Map<String, String> params,
                                  @HeaderMap Map<String, String> heads);

    @POST
    Call<ResponseBody> doPost(@Url String url, @Body RequestBody body, @HeaderMap Map<String, String> heads);

    @Multipart
    @POST
    Call<ResponseBody> doFormFile(@Url String url, @QueryMap Map<String, String> params,
                                  @Part List<MultipartBody.Part> list, @HeaderMap Map<String, String> heads);

    @Multipart
    @POST
    Call<ResponseBody> doDownload(@Url String url, @FieldMap Map<String, String> params,
                                  @HeaderMap Map<String, String> heads);

}
