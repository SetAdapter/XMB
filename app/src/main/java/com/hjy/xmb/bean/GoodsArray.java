package com.hjy.xmb.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 商品 列表实体类
 * Created by fangs on 2018/5/8.
 */
public class GoodsArray implements Serializable{

    private List<ListToAppBean.RowsBean> goodsList;

    public GoodsArray() {
    }

    public List<ListToAppBean.RowsBean> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<ListToAppBean.RowsBean> goodsList) {
        this.goodsList = goodsList;
    }
}
