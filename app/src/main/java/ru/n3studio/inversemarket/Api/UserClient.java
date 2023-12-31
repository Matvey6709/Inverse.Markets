package ru.n3studio.inversemarket.Api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface UserClient  {
    @GET("api/products/shops/")
    Call<ResponseBody> getShops(@Header("Authorization") String token);
    @GET("api/products/categories/")
    Call<ResponseBody> getCategories(@Header("Authorization") String token);
    @GET("api/products/")
    Call<ResponseBody> getProducts(@Header("Authorization") String token);


}