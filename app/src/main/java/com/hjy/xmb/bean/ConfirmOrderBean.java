package com.hjy.xmb.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by QKun on 2018/5/16.
 */
public class ConfirmOrderBean implements Serializable {


    private List<?> goodsList;
    private List<ListAddressBean> listAddress;
    private List<ListCartBean> listCart;
    private List<ListTransferStationBean> listTransferStation;

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

    public List<ListCartBean> getListCart() {
        return listCart;
    }

    public void setListCart(List<ListCartBean> listCart) {
        this.listCart = listCart;
    }

    public List<ListTransferStationBean> getListTransferStation() {
        return listTransferStation;
    }

    public void setListTransferStation(List<ListTransferStationBean> listTransferStation) {
        this.listTransferStation = listTransferStation;
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

    public static class ListCartBean implements Serializable{
        /**
         * cartId : 9
         * goodBuyAmount : 24
         * goodsName : Comotomo 可么多么婴儿全硅胶宽口径防摔奶瓶 250ml 绿色
         * goodsNo : tx0001
         * goodsPic : http://192.168.100.251:8080/wuliu/statics/images/01.jpg
         * goodsSalePrice : 159.0
         */

        private int cartId;
        private int goodBuyAmount;
        private String goodsName;
        private String goodsNo;
        private String goodsPic;
        private double goodsSalePrice;

        public int getCartId() {
            return cartId;
        }

        public void setCartId(int cartId) {
            this.cartId = cartId;
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

    public static class ListTransferStationBean implements Serializable{
        /**
         * transferStationId : 2
         * transferStationName : 美国地区
         */

        private int transferStationId;
        private String transferStationName;

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
