package com.study.familychat.bean;

public class peoplebean {

    public String resultcode;

    public String reason;

    public result result;

    public static class result {
        private String area;
        private String sex;
        private String birthday;
        private String verify;
    }

    public String getArea() {
        return result.area;
    }

    public int error_code;

    //定义 输出返回数据 的方法
    public void show() {
        System.out.println(resultcode);
        System.out.print(reason);

        System.out.println(result.area);
        System.out.println(result.birthday);
        System.out.println(result.sex);
        System.out.println(result.verify);
        System.out.println(error_code);
    }

}
