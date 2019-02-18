package com.hjy.xmb.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by QKun on 2018/5/17.
 */
public class ImmediateBuyBean implements Serializable{


    /**
     * count : 1
     * createTime : null
     * customerId : null
     * deliveryAddressId : null
     * goods : {"goodsFreight":"8","goodsId":1,"goodsName":"Comotomo 可么多么婴儿全硅胶宽口径防摔奶瓶 250ml 绿色","goodsNo":"tx0001","goodsOriginalPrice":188,"goodsPic":"http://192.168.100.251:8080/wuliu/statics/images/01.jpg","goodsSalePrice":159,"goodsSales":99,"goodsStyle":"001"}
     * goodsAmountTotal : null
     * goodsList : []
     * listAddress : [{"addressId":2,"area":"天河区","city":"广州市","consigneeName":"梁朝伟","country":"中国","createdTime":"2018-05-05 15:12:38","customerId":1,"isDefaultAddress":0,"province":"广东省","street":"恒大名都33栋1单元1103号","telphone":"18600000000","zipCode":4302555},{"addressId":1,"area":"硚口区","city":"武汉市","consigneeName":"王凯","country":"中国","createdTime":"2018-05-03 15:09:20","customerId":1,"isDefaultAddress":1,"province":"湖北省","street":"紫润明园北区22栋2单元2208号","telphone":"13100000000","zipCode":420300}]
     * listCart : null
     * listTransferStation : [{"transferStationCode":null,"transferStationId":2,"transferStationName":"美国地区"},{"transferStationCode":null,"transferStationId":1,"transferStationName":"香港地区"}]
     * logisticsAmountTotal : null
     * orderAmountTotal : null
     * orderId : null
     * orderNo : null
     * orderStatus : null
     * payNo : null
     * payStyle : null
     * taxAmountTotal : null
     * transferStation : null
     */

    private int count;
    private Object createTime;
    private Object customerId;
    private Object deliveryAddressId;
    private GoodsBean goods;
    private Object goodsAmountTotal;
    private Object listCart;
    private Object logisticsAmountTotal;
    private Object orderAmountTotal;
    private Object orderId;
    private Object orderNo;
    private Object orderStatus;
    private Object payNo;
    private Object payStyle;
    private Object taxAmountTotal;
    private Object transferStation;
    private List<?> goodsList;
    private List<ListAddressBean> listAddress;
    private List<ListTransferStationBean> listTransferStation;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Object createTime) {
        this.createTime = createTime;
    }

    public Object getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Object customerId) {
        this.customerId = customerId;
    }

    public Object getDeliveryAddressId() {
        return deliveryAddressId;
    }

    public void setDeliveryAddressId(Object deliveryAddressId) {
        this.deliveryAddressId = deliveryAddressId;
    }

    public GoodsBean getGoods() {
        return goods;
    }

    public void setGoods(GoodsBean goods) {
        this.goods = goods;
    }

    public Object getGoodsAmountTotal() {
        return goodsAmountTotal;
    }

    public void setGoodsAmountTotal(Object goodsAmountTotal) {
        this.goodsAmountTotal = goodsAmountTotal;
    }

    public Object getListCart() {
        return listCart;
    }

    public void setListCart(Object listCart) {
        this.listCart = listCart;
    }

    public Object getLogisticsAmountTotal() {
        return logisticsAmountTotal;
    }

    public void setLogisticsAmountTotal(Object logisticsAmountTotal) {
        this.logisticsAmountTotal = logisticsAmountTotal;
    }

    public Object getOrderAmountTotal() {
        return orderAmountTotal;
    }

    public void setOrderAmountTotal(Object orderAmountTotal) {
        this.orderAmountTotal = orderAmountTotal;
    }

    public Object getOrderId() {
        return orderId;
    }

    public void setOrderId(Object orderId) {
        this.orderId = orderId;
    }

    public Object getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Object orderNo) {
        this.orderNo = orderNo;
    }

    public Object getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Object orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Object getPayNo() {
        return payNo;
    }

    public void setPayNo(Object payNo) {
        this.payNo = payNo;
    }

    public Object getPayStyle() {
        return payStyle;
    }

    public void setPayStyle(Object payStyle) {
        this.payStyle = payStyle;
    }

    public Object getTaxAmountTotal() {
        return taxAmountTotal;
    }

    public void setTaxAmountTotal(Object taxAmountTotal) {
        this.taxAmountTotal = taxAmountTotal;
    }

    public Object getTransferStation() {
        return transferStation;
    }

    public void setTransferStation(Object transferStation) {
        this.transferStation = transferStation;
    }

    public List<?> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<?> goodsList) {
        this.goodsList = goodsList;
    }

    public List<ListAddressBean> getListAddress() {
        return listAddress;
    }

    public void setListAddress(List<ListAddressBean> listAddress) {
        this.listAddress = listAddress;
    }

    public List<ListTransferStationBean> getListTransferStation() {
        return listTransferStation;
    }

    public void setListTransferStation(List<ListTransferStationBean> listTransferStation) {
        this.listTransferStation = listTransferStation;
    }

    public static class GoodsBean implements Serializable{
        /**
         * goodsFreight : 8
         * goodsId : 1
         * goodsName : Comotomo 可么多么婴儿全硅胶宽口径防摔奶瓶 250ml 绿色
         * goodsNo : tx0001
         * goodsOriginalPrice : 188.0
         * goodsPic : http://192.168.100.251:8080/wuliu/statics/images/01.jpg
         * goodsSalePrice : 159.0
         * goodsSales : 99
         * goodsStyle : 001
         */

        private String goodsFreight;
        private int goodsId;
        private String goodsName;
        private String goodsNo;
        private double goodsOriginalPrice;
        private String goodsPic;
        private double goodsSalePrice;
        private int goodsSales;
        private String goodsStyle;

        public String getGoodsFreight() {
            return goodsFreight;
        }

        public void setGoodsFreight(String goodsFreight) {
            this.goodsFreight = goodsFreight;
        }

        public int getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(int goodsId) {
            this.goodsId = goodsId;
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

        public double getGoodsOriginalPrice() {
            return goodsOriginalPrice;
        }

        public void setGoodsOriginalPrice(double goodsOriginalPrice) {
            this.goodsOriginalPrice = goodsOriginalPrice;
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

        public int getGoodsSales() {
            return goodsSales;
        }

        public void setGoodsSales(int goodsSales) {
            this.goodsSales = goodsSales;
        }

        public String getGoodsStyle() {
            return goodsStyle;
        }

        public void setGoodsStyle(String goodsStyle) {
            this.goodsStyle = goodsStyle;
        }
    }

    public static class ListAddressBean implements Serializable{
        /**
         * addressId : 2
         * area : 天河区
         * city : 广州市
         * consigneeName : 梁朝伟
         * country : 中国
         * createdTime : 2018-05-05 15:12:38
         * customerId : 1
         * isDefaultAddress : 0
         * province : 广东省
         * street : 恒大名都33栋1单元1103号
         * telphone : 18600000000
         * zipCode : 4302555
         */

        private int addressId;
        private String area;
        private String city;
        private String consigneeName;
        private String country;
        private String createdTime;
        private int customerId;
        private int isDefaultAddress;
        private String province;
        private String street;
        private String telphone;
        private int zipCode;

        public int getAddressId() {
            return addressId;
        }

        public void setAddressId(int addressId) {
            this.addressId = addressId;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getConsigneeName() {
            return consigneeName;
        }

        public void setConsigneeName(String consigneeName) {
            this.consigneeName = consigneeName;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCreatedTime() {
            return createdTime;
        }

        public void setCreatedTime(String createdTime) {
            this.createdTime = createdTime;
        }

        public int getCustomerId() {
            return customerId;
        }

        public void setCustomerId(int customerId) {
            this.customerId = customerId;
        }

        public int getIsDefaultAddress() {
            return isDefaultAddress;
        }

        public void setIsDefaultAddress(int isDefaultAddress) {
            this.isDefaultAddress = isDefaultAddress;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getTelphone() {
            return telphone;
        }

        public void setTelphone(String telphone) {
            this.telphone = telphone;
        }

        public int getZipCode() {
            return zipCode;
        }

        public void setZipCode(int zipCode) {
            this.zipCode = zipCode;
        }
    }

    public static class ListTransferStationBean implements Serializable{
        /**
         * transferStationCode : null
         * transferStationId : 2
         * transferStationName : 美国地区
         */

        private Object transferStationCode;
        private int transferStationId;
        private String transferStationName;

        public Object getTransferStationCode() {
            return transferStationCode;
        }

        public void setTransferStationCode(Object transferStationCode) {
            this.transferStationCode = transferStationCode;
        }

        public int getTransferStationId() {
            return transferStationId;
        }

        public void setTransferStationId(int transferStationId) {
            this.transferStationId = transferStationId;
        }

        public String getTransferStationName() {
            return transferStationName;
        }

        public void setTransferStationName(String transferStationName) {
            this.transferStationName = transferStationName;
        }
    }
}
