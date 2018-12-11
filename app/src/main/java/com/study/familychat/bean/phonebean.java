package com.study.familychat.bean;

public class phonebean {

    public String getReason() {
        return reason;
    }

    public String getResultcode() {
        return resultcode;
    }

    public String getResult() {

        if (result.company.isEmpty()) return "empty";
        return result.company;
    }

    public int getError_code() {
        return error_code;
    }

    private String reason;
    private String resultcode;
    private result result;

    private static class result {
        public String getProvince() {
            return province;
        }

        public String getCity() {
            return city;
        }

        public String getAreacode() {
            return areacode;
        }

        public String getZip() {
            return zip;
        }

        public String getCompany() {
            return company;
        }

        public String getCard() {
            return card;
        }

        private String province;
        private String city;
        private String areacode;
        private String zip;
        private String company;
        private String card;
    }

    private int error_code;
}
