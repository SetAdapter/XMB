package com.hjy.xmb.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Stefan on 2018/5/15.
 */

public class ListToAppBean implements Serializable {

    /**
     * first : 1
     * limit : 2147483647
     * offset : 0
     * pageNo : 1
     * pageSize : 10
     * rows : [{"cartId":25,"consumerId":1,"goodBuyAmount":11,"goodsName":"Comotomo 可么多么婴儿全硅胶宽口径防摔奶瓶 250ml 绿色","goodsNo":"tx0001","goodsPic":"http://192.168.100.251:8080/wuliu/statics/images/01.jpg","goodsSalePrice":159},{"cartId":24,"consumerId":1,"goodBuyAmount":10,"goodsName":"SK-II R.N.A.超肌能紧致活肤面霜80g 大红瓶 修护日霜保湿补水提拉紧致淡化细纹 日本原装进口","goodsNo":"tx0002","goodsPic":"http://192.168.100.251:8080/wuliu/statics/images/02.jpg","goodsSalePrice":985}]
     * total : 2
     * totalPages : 1
     */

    private int first;
    private int limit;
    private int offset;
    private int pageNo;
    private int pageSize;
    private int total;
    private int totalPages;
    private List<RowsBean> rows;

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean implements Serializable{
        /**
         * cartId : 25
         * consumerId : 1
         * goodBuyAmount : 11
         * goodsName : Comotomo 可么多么婴儿全硅胶宽口径防摔奶瓶 250ml 绿色
         * goodsNo : tx0001
         * goodsPic : http://192.168.100.251:8080/wuliu/statics/images/01.jpg
         * goodsSalePrice : 159.0
         */

        private int cartId;
        private int consumerId;
        private int goodBuyAmount;
        private String goodsName;
        private String goodsNo;
        private String goodsPic;
        private double goodsSalePrice;
        private boolean isFlag;

        public boolean isFlag() {
            return isFlag;
        }

        public void setFlag(boolean flag) {
            isFlag = flag;
        }

        public int getCartId() {
            return cartId;
        }

        public void setCartId(int cartId) {
            this.cartId = cartId;
        }

        public int getConsumerId() {
            return consumerId;
        }

        public void setConsumerId(int consumerId) {
            this.consumerId = consumerId;
        }

        public int getGoodBuyAmount() {
            return goodBuyAmount;
        }

        public void setGoodBuyAmount(int goodBuyAmount) {
            this.goodBuyAmount = goodBuyAmount;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public String getGoodsNo() {
            return goodsNo;
        }

        public void setGoodsNo(String goodsNo) {
            this.goodsNo = goodsNo;
        }

        public String getGoodsPic() {
            return goodsPic;
        }

        public void setGoodsPic(String goodsPic) {
            this.goodsPic = goodsPic;
        }

        public double getGoodsSalePrice() {
            return goodsSalePrice;
        }

        public void setGoodsSalePrice(double goodsSalePrice) {
            this.goodsSalePrice = goodsSalePrice;
        }
    }
}
