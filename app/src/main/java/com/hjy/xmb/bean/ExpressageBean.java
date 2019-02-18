package com.hjy.xmb.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 初夏小溪 on 2018/5/15 0015.
 */

public class ExpressageBean implements Serializable {

    /**
     * first : 1
     * limit : 2147483647
     * offset : 0
     * pageNo : 1
     * pageSize : 10
     * rows : [{"logisticsCurrentSign":1,"logisticsNo":"","logisticsStatusCreateTime":"2018-05-17 17:04:57.0","logisticsStatusDescription":"快递已被签收：快递柜","logisticsStatusId":28,"orderNo":"2018-05-17 17:04:57d5ba71d4-b696-430b-bf4b-5646386a5cb5"},{"logisticsCurrentSign":0,"logisticsNo":"","logisticsStatusCreateTime":"2018-05-17 17:04:57.0","logisticsStatusDescription":"洪山服务部派件员：郭春兵 13522002200 正在为您派件 ","logisticsStatusId":27,"orderNo":"2018-05-17 17:04:57d5ba71d4-b696-430b-bf4b-5646386a5cb5"},{"logisticsCurrentSign":0,"logisticsNo":"","logisticsStatusCreateTime":"2018-05-17 17:04:57.0","logisticsStatusDescription":"到达武汉分拨中心，即将发往武汉洪山区服务部","logisticsStatusId":26,"orderNo":"2018-05-17 17:04:57d5ba71d4-b696-430b-bf4b-5646386a5cb5"},{"logisticsCurrentSign":0,"logisticsNo":"","logisticsStatusCreateTime":"2018-05-17 17:04:57.0","logisticsStatusDescription":"顺丰快递正在进行揽件扫描，即将发往湖北武汉网点","logisticsStatusId":25,"orderNo":"2018-05-17 17:04:57d5ba71d4-b696-430b-bf4b-5646386a5cb5"},{"logisticsCurrentSign":0,"logisticsNo":"","logisticsStatusCreateTime":"2018-05-17 17:04:57.0","logisticsStatusDescription":"清关完毕，发往上海保税仓","logisticsStatusId":24,"orderNo":"2018-05-17 17:04:57d5ba71d4-b696-430b-bf4b-5646386a5cb5"},{"logisticsCurrentSign":0,"logisticsNo":"","logisticsStatusCreateTime":"2018-05-17 17:04:57.0","logisticsStatusDescription":"到达中国上海海关，等待清关","logisticsStatusId":23,"orderNo":"2018-05-17 17:04:57d5ba71d4-b696-430b-bf4b-5646386a5cb5"},{"logisticsCurrentSign":0,"logisticsNo":"","logisticsStatusCreateTime":"2018-05-17 17:04:57.0","logisticsStatusDescription":"美国转运仓已发货：目的地：中国上海","logisticsStatusId":22,"orderNo":"2018-05-17 17:04:57d5ba71d4-b696-430b-bf4b-5646386a5cb5"},{"logisticsCurrentSign":0,"logisticsNo":"","logisticsStatusCreateTime":"2018-05-17 17:04:57.0","logisticsStatusDescription":"包裹已出库：来自美国转运仓","logisticsStatusId":21,"orderNo":"2018-05-17 17:04:57d5ba71d4-b696-430b-bf4b-5646386a5cb5"},{"logisticsCurrentSign":0,"logisticsNo":"","logisticsStatusCreateTime":"2018-05-17 17:04:57.0","logisticsStatusDescription":"订单提交成功","logisticsStatusId":20,"orderNo":"2018-05-17 17:04:57d5ba71d4-b696-430b-bf4b-5646386a5cb5"}]
     * total : 9
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

    public static class RowsBean implements Serializable {
        /**
         * logisticsCurrentSign : 1
         * logisticsNo :
         * logisticsStatusCreateTime : 2018-05-17 17:04:57.0
         * logisticsStatusDescription : 快递已被签收：快递柜
         * logisticsStatusId : 28
         * orderNo : 2018-05-17 17:04:57d5ba71d4-b696-430b-bf4b-5646386a5cb5
         */

        private int logisticsCurrentSign;
        private String logisticsNo;
        private String logisticsStatusCreateTime;
        private String logisticsStatusDescription;
        private int logisticsStatusId;
        private String orderNo;

        public int getLogisticsCurrentSign() {
            return logisticsCurrentSign;
        }

        public void setLogisticsCurrentSign(int logisticsCurrentSign) {
            this.logisticsCurrentSign = logisticsCurrentSign;
        }

        public String getLogisticsNo() {
            return logisticsNo;
        }

        public void setLogisticsNo(String logisticsNo) {
            this.logisticsNo = logisticsNo;
        }

        public String getLogisticsStatusCreateTime() {
            return logisticsStatusCreateTime;
        }

        public void setLogisticsStatusCreateTime(String logisticsStatusCreateTime) {
            this.logisticsStatusCreateTime = logisticsStatusCreateTime;
        }

        public String getLogisticsStatusDescription() {
            return logisticsStatusDescription;
        }

        public void setLogisticsStatusDescription(String logisticsStatusDescription) {
            this.logisticsStatusDescription = logisticsStatusDescription;
        }

        public int getLogisticsStatusId() {
            return logisticsStatusId;
        }

        public void setLogisticsStatusId(int logisticsStatusId) {
            this.logisticsStatusId = logisticsStatusId;
        }

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }
    }
}
