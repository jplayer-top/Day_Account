package com.oblivion.day_account.model.net.bean;

import java.util.List;

/**
 * author:Created by Oblivion on 2017/1/20.
 * 功能描述:
 */

public class AccountbannerBean {


    public String error;
    public List<ResultBean> result;

    public static class ResultBean {
        public String image;
    }
}
