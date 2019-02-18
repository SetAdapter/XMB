package com.hjy.xmb.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 初夏小溪 on 2018/5/15 0015.
 */

public class OrderBean implements Serializable {


    /**
     * first : 1
     * limit : 2147483647
     * offset : 0
     * pageNo : 1
     * pageSize : 20
     * rows : [{"createTime":"2018-05-16 09:07:52.0","customerId":1,"deliveryAddressId":1,"goodsAmountTotal":6325,"goodsList":[{"goodsCount":4,"goodsName":"SK-II R.N.A.超肌能紧致活肤面霜80g 大红瓶 修护日霜保湿补水提拉紧致淡化细纹 日本原装进口","goodsNo":"tx0002","goodsPic":"http://192.168.100.251:8080/wuliu/statics/images/02.jpg","goodsPrice":985,"orderGoodsdetailsId":12,"orderNo":"2018-05-16 09:07:52c576fb16-d1da-4213-83a6-3c667390a2ff"},{"goodsCount":15,"goodsName":"Comotomo 可么多么婴儿全硅胶宽口径防摔奶瓶 250ml 绿色","goodsNo":"tx0001","goodsPic":"http://192.168.100.251:8080/wuliu/statics/images/01.jpg","goodsPrice":159,"orderGoodsdetailsId":11,"orderNo":"2018-05-16 09:07:52c576fb16-d1da-4213-83a6-3c667390a2ff"}],"logisticsAmountTotal":8,"orderAmountTotal":6335.3,"orderId":11,"orderNo":"2018-05-16 09:07:52c576fb16-d1da-4213-83a6-3c667390a2ff","orderStatus":"订单提交成功","taxAmountTotal":2.3,"transferStation":2},{"createTime":"2018-05-15 10:48:43.0","customerId":1,"deliveryAddressId":1,"goodsList":[{"goodsCount":1,"goodsName":"富士(FUJIFILM) mini8+拍立得相机（mini8的升级版多加了自拍鏡）自拍立得 棕色 单机","goodsNo":"tx0004","goodsPic":"http://192.168.100.251:8080/wuliu/statics/images/04.jpg","goodsPrice":468,"orderGoodsdetailsId":10,"orderNo":"2018:05:15 10:48:433b696eb2-f5ad-4e50-bc96-e63380b1d35e"},{"goodsCount":6,"goodsName":"飞利浦（Philips）HS198 电动剃须刀 礼盒装 银色 充电式浮动刀头刀头水洗","goodsNo":"tx0003","goodsPic":"http://192.168.100.251:8080/wuliu/statics/images/03.jpg","goodsPrice":229,"orderGoodsdetailsId":9,"orderNo":"2018:05:15 10:48:433b696eb2-f5ad-4e50-bc96-e63380b1d35e"}],"orderId":9,"orderNo":"2018:05:15 10:48:433b696eb2-f5ad-4e50-bc96-e63380b1d35e","orderStatus":"订单提交成功","transferStation":2},{"createTime":"2018-05-15 10:46:50.0","customerId":1,"deliveryAddressId":1,"goodsList":[{"goodsCount":1,"goodsName":"富士(FUJIFILM) mini8+拍立得相机（mini8的升级版多加了自拍鏡）自拍立得 棕色 单机","goodsNo":"tx0004","goodsPic":"http://192.168.100.251:8080/wuliu/statics/images/04.jpg","goodsPrice":468,"orderGoodsdetailsId":8,"orderNo":"2018:05:15 10:46:503947de68-c25c-4617-9174-4ccbee9d04d5"},{"goodsCount":6,"goodsName":"飞利浦（Philips）HS198 电动剃须刀 礼盒装 银色 充电式浮动刀头刀头水洗","goodsNo":"tx0003","goodsPic":"http://192.168.100.251:8080/wuliu/statics/images/03.jpg","goodsPrice":229,"orderGoodsdetailsId":7,"orderNo":"2018:05:15 10:46:503947de68-c25c-4617-9174-4ccbee9d04d5"}],"orderId":8,"orderNo":"2018:05:15 10:46:503947de68-c25c-4617-9174-4ccbee9d04d5","orderStatus":"订单提交成功","transferStation":2},{"createTime":"2018-05-15 10:46:01.0","customerId":1,"deliveryAddressId":1,"goodsList":[{"goodsCount":1,"goodsName":"Comotomo 可么多么婴儿全硅胶宽口径防摔奶瓶 250ml 绿色","goodsNo":"tx0001","goodsPic":"http://192.168.100.251:8080/wuliu/statics/images/01.jpg","goodsPrice":159,"orderGoodsdetailsId":13,"orderNo":"2018:05:15 10:46:012ab3a9a0-f955-48a4-a358-58df7bd2ba64"}],"orderId":7,"orderNo":"2018:05:15 10:46:012ab3a9a0-f955-48a4-a358-58df7bd2ba64","orderStatus":"订单提交成功","transferStation":2},{"createTime":"2018-05-15 10:44:04.0","customerId":1,"deliveryAddressId":1,"goodsList":[{"goodsCount":1,"goodsName":"富士(FUJIFILM) mini8+拍立得相机（mini8的升级版多加了自拍鏡）自拍立得 棕色 单机","goodsNo":"tx0004","goodsPic":"http://192.168.100.251:8080/wuliu/statics/images/04.jpg","goodsPrice":468,"orderGoodsdetailsId":14,"orderNo":"2018:05:15 10:44:04347c0a29-d8f9-48b7-992d-ee7c66884be4"}],"orderId":6,"orderNo":"2018:05:15 10:44:04347c0a29-d8f9-48b7-992d-ee7c66884be4","orderStatus":"订单提交成功","transferStation":2},{"createTime":"2018-05-15 15:54:38.0","customerId":1,"deliveryAddressId":1,"goodsList":[{"goodsCount":1,"goodsName":"富士(FUJIFILM) mini8+拍立得相机（mini8的升级版多加了自拍鏡）自拍立得 棕色 单机","goodsNo":"tx0004","goodsPic":"http://192.168.100.251:8080/wuliu/statics/images/04.jpg","goodsPrice":468,"orderGoodsdetailsId":6,"orderNo":"2018:05:15 10:06:0453152b2f-7e15-4012-82c9-d876a0a53607"},{"goodsCount":6,"goodsName":"飞利浦（Philips）HS198 电动剃须刀 礼盒装 银色 充电式浮动刀头刀头水洗","goodsNo":"tx0003","goodsPic":"http://192.168.100.251:8080/wuliu/statics/images/03.jpg","goodsPrice":229,"orderGoodsdetailsId":5,"orderNo":"2018:05:15 10:06:0453152b2f-7e15-4012-82c9-d876a0a53607"}],"orderId":5,"orderNo":"2018:05:15 10:06:0453152b2f-7e15-4012-82c9-d876a0a53607","orderStatus":"订单提交成功"},{"createTime":"2018-05-15 15:54:37.0","customerId":1,"deliveryAddressId":1,"goodsList":[{"goodsCount":3,"goodsName":"飞利浦（Philips）HS198 电动剃须刀 礼盒装 银色 充电式浮动刀头刀头水洗","goodsNo":"tx0003","goodsPic":"http://192.168.100.251:8080/wuliu/statics/images/03.jpg","goodsPrice":229,"orderGoodsdetailsId":4,"orderNo":"2018:05:14 17:56:4220832ae1-9d86-4904-bdea-98edca086f54"},{"goodsCount":2,"goodsName":"Comotomo 可么多么婴儿全硅胶宽口径防摔奶瓶 250ml 绿色","goodsNo":"tx0001","goodsPic":"http://192.168.100.251:8080/wuliu/statics/images/01.jpg","goodsPrice":159,"orderGoodsdetailsId":3,"orderNo":"2018:05:14 17:56:4220832ae1-9d86-4904-bdea-98edca086f54"}],"orderId":4,"orderNo":"2018:05:14 17:56:4220832ae1-9d86-4904-bdea-98edca086f54","orderStatus":"订单提交成功"}]
     * total : 7
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

    public static class RowsBean implements Serializable, MultiItemEntity {
        /**
         * createTime : 2018-05-16 09:07:52.0
         * customerId : 1
         * deliveryAddressId : 1
         * goodsAmountTotal : 6325.0
         * goodsList : [{"goodsCount":4,"goodsName":"SK-II R.N.A.超肌能紧致活肤面霜80g 大红瓶 修护日霜保湿补水提拉紧致淡化细纹 日本原装进口","goodsNo":"tx0002","goodsPic":"http://192.168.100.251:8080/wuliu/statics/images/02.jpg","goodsPrice":985,"orderGoodsdetailsId":12,"orderNo":"2018-05-16 09:07:52c576fb16-d1da-4213-83a6-3c667390a2ff"},{"goodsCount":15,"goodsName":"Comotomo 可么多么婴儿全硅胶宽口径防摔奶瓶 250ml 绿色","goodsNo":"tx0001","goodsPic":"http://192.168.100.251:8080/wuliu/statics/images/01.jpg","goodsPrice":159,"orderGoodsdetailsId":11,"orderNo":"2018-05-16 09:07:52c576fb16-d1da-4213-83a6-3c667390a2ff"}]
         * logisticsAmountTotal : 8.0
         * orderAmountTotal : 6335.3
         * orderId : 11
         * orderNo : 2018-05-16 09:07:52c576fb16-d1da-4213-83a6-3c667390a2ff
         * orderStatus : 订单提交成功
         * taxAmountTotal : 2.3
         * transferStation : 2
         */
        public static final int TYPE_ONE = 1;
        public static final int TYPE_TWO = 2;
        private int itemType;

        public void setItemType(int itemType) {
            this.itemType = itemType;
        }

        @Override
        public int getItemType() {
            return itemType;
        }


        private String createTime;
        private int customerId;
        private int deliveryAddressId;
        private double goodsAmountTotal;
        private double logisticsAmountTotal;
        private double orderAmountTotal;
        private int orderId;
        private String orderNo;
        private String orderStatus;
        private double taxAmountTotal;
        private int transferStation;
        private List<GoodsListBean> goodsList;

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getCustomerId() {
            return customerId;
        }

        public void setCustomerId(int customerId) {
            this.customerId = customerId;
        }

        public int getDeliveryAddressId() {
            return deliveryAddressId;
        }

        public void setDeliveryAddressId(int deliveryAddressId) {
            this.deliveryAddressId = deliveryAddressId;
        }

        public double getGoodsAmountTotal() {
            return goodsAmountTotal;
        }

        public void setGoodsAmountTotal(double goodsAmountTotal) {
            this.goodsAmountTotal = goodsAmountTotal;
        }

        public double getLogisticsAmountTotal() {
            return logisticsAmountTotal;
        }

        public void setLogisticsAmountTotal(double logisticsAmountTotal) {
            this.logisticsAmountTotal = logisticsAmountTotal;
        }

        public double getOrderAmountTotal() {
            return orderAmountTotal;
        }

        public void setOrderAmountTotal(double orderAmountTotal) {
            this.orderAmountTotal = orderAmountTotal;
        }

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }

        public double getTaxAmountTotal() {
            return taxAmountTotal;
        }

        public void setTaxAmountTotal(double taxAmountTotal) {
            this.taxAmountTotal = taxAmountTotal;
        }

        public int getTransferStation() {
            return transferStation;
        }

        public void setTransferStation(int transferStation) {
            this.transferStation = transferStation;
        }

        public List<GoodsListBean> getGoodsList() {
            return goodsList;
        }

        public void setGoodsList(List<GoodsListBean> goodsList) {
            this.goodsList = goodsList;
        }


        public static class GoodsListBean implements Serializable{
            /**
             * goodsCount : 4
             * goodsName : SK-II R.N.A.超肌能紧致活肤面霜80g 大红瓶 修护日霜保湿补水提拉紧致淡化细纹 日本原装进口
             * goodsNo : tx0002
             * goodsPic : http://192.168.100.251:8080/wuliu/statics/images/02.jpg
             * goodsPrice : 985.0
             * orderGoodsdetailsId : 12
             * orderNo : 2018-05-16 09:07:52c576fb16-d1da-4213-83a6-3c667390a2ff
             */

            private int goodsCount;
            private String goodsName;
            private String goodsNo;
            private String goodsPic;
            private double goodsPrice;
            private int orderGoodsdetailsId;
            private String orderNo;

            public int getGoodsCount() {
                return goodsCount;
            }

            public void setGoodsCount(int goodsCount) {
                this.goodsCount = goodsCount;
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

            public double getGoodsPrice() {
                return goodsPrice;
            }

            public void setGoodsPrice(double goodsPrice) {
                this.goodsPrice = goodsPrice;
            }

            public int getOrderGoodsdetailsId() {
                return orderGoodsdetailsId;
            }

            public void setOrderGoodsdetailsId(int orderGoodsdetailsId) {
                this.orderGoodsdetailsId = orderGoodsdetailsId;
            }

            public String getOrderNo() {
                return orderNo;
            }

            public void setOrderNo(String orderNo) {
                this.orderNo = orderNo;
            }
        }
    }
}
