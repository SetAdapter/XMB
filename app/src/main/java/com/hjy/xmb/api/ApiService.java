package com.hjy.xmb.api;

import com.fy.baselibrary.retrofit.BeanModule;
import com.hjy.xmb.bean.ConfirmOrderBean;
import com.hjy.xmb.bean.ExpressageBean;
import com.hjy.xmb.bean.ImmediateBuyBean;
import com.hjy.xmb.bean.ListToAppBean;
import com.hjy.xmb.bean.OrderBean;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * 通用的 api接口 </p>
 * Created by fangs on 2017/8/28.
 */
public interface ApiService {

    /**
     * 多图片上传
     *
     * @param token
     * @return
     */
    @Multipart
    @Headers({"url_name:user"})
    @POST("http://www.wanandroid.com/file/uploadImages")
//    @POST("http://192.168.100.123/hfs/")
    Observable<BeanModule<String>> uploadPostFile(@Part("token") RequestBody token,
                                                  @Part("type") RequestBody type,
                                                  @Part List<MultipartBody.Part> files);


    /**
     * 1.商品列表
     *
     * @param options
     * @return
     */
    @Headers({"url_name:user"})
    @GET("goods/listToApp")
    Observable<BeanModule<ListToAppBean>> getlistgoods(@QueryMap Map<String, Object> options);

    /**
     * 2.查询某个商品 
     *
     * @param options
     * @return
     */
    @Headers({"url_name:user"})
    @GET("goods/info")
    Observable<BeanModule<ListToAppBean>> info(@QueryMap Map<String, Object> options);


    /**
     * 3.购物车列表
     */
    @Headers({"url_name:user"})
    @GET("cart/listToApp")
    Observable<BeanModule<ListToAppBean>> getListToApp(@QueryMap Map<String, Object> options);

    /**
     * 4.添加商品到购物车
     * params:
     * goodsNo (String) – 商品编号
     * goodBuyAmount (Int) – 购买数量
     */
    @FormUrlEncoded
    @POST("cart/save")
    Observable<BeanModule<Object>> saveCart(@FieldMap Map<String, Object> options);


    /**
     * 5.訂單列表
     */
    @FormUrlEncoded
    @Headers({"url_name:user"})
    @POST("order/listToApp")
    Observable<BeanModule<OrderBean>> order(@FieldMap Map<String, Object> options);

    /**
     * 6.批量删除购物车
     */
    @FormUrlEncoded
    @Headers({"url_name:user"})
    @POST("cart/remove")
    Observable<BeanModule<Object>> remove(@Field("cartIds") List<Integer> options);

    /**
     * 5.修改购物车数量
     */
    @FormUrlEncoded
    @Headers({"url_name:user"})
    @POST("cart/update")
    Observable<BeanModule<Object>> update(@Field("cartId") String cartId,@Field("buyCount") Integer buyCount);

    /**
     * 6.确认订单
     * goodsNos(list)  选中的商品id集合  ep: tx0001,tx0003
     */
    @Headers({"url_name:user"})
    @GET("order/confirm")
    Observable<BeanModule<ConfirmOrderBean>> confirm(@Query("goodsNos") List<String> options);


    /**
     * 7.生成订单
     * addressed(int)  -- 选中的地址id
     * transferStationId(int)  --选中的中转仓 id
     * goodsNos(list)  --选中的商品id集合  ep: tx0001,tx0003
     */
    @FormUrlEncoded
    @Headers({"url_name:user"})
    @POST("order/saveToApp")
    Observable<BeanModule<OrderBean>> saveToApp(@FieldMap Map<String, Object> options, @Field("goodsNos") List<String> goodsNos);


    /**
     * 8.物流查詢
     */
    @Headers({"url_name:user"})
    @GET("logistics/status/listToApp")
    Observable<BeanModule<ExpressageBean>> status(@QueryMap Map<String, Object> options);


    /**
     * 9.直接购买 从商品详情直接进行购买的  没有通过购物车
     */
    @Headers({"url_name:user"})
    @GET("order/immediateBuy")
    Observable<BeanModule<ConfirmOrderBean>> getImmediateBuy(@Query("goodsNo") String goodsNo);


}
