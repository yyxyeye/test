package com.imooc.pojo.kugou;

import java.util.List;

public class AbandonRiceDataResponse {
    private Integer total;

    private List<AbandonRiceDinnersData> dinners;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<AbandonRiceDinnersData> getDinners() {
        return dinners;
    }

    public void setDinners(List<AbandonRiceDinnersData> dinners) {
        this.dinners = dinners;
    }

    static class AbandonRiceDinnersData {
        private String batchId;
        private String restaurantName;
        private String dinnerName;
        private String userName;
        private String description;
        private String chineseName;

        public String getBatchId() {
            return batchId;
        }

        public void setBatchId(String batchId) {
            this.batchId = batchId;
        }

        public String getRestaurantName() {
            return restaurantName;
        }

        public void setRestaurantName(String restaurantName) {
            this.restaurantName = restaurantName;
        }

        public String getDinnerName() {
            return dinnerName;
        }

        public void setDinnerName(String dinnerName) {
            this.dinnerName = dinnerName;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getChineseName() {
            return chineseName;
        }

        public void setChineseName(String chineseName) {
            this.chineseName = chineseName;
        }
    }
}
