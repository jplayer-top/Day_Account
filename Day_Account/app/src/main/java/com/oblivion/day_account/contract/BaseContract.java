package com.oblivion.day_account.contract;

/**
 * author:Created by Oblivion on 2017/2/10.
 * 功能描述:
 */

public interface BaseContract {

    interface BaseView<T> {
        void showEmpty();

        void showErrow();

        void showLoadding();

    }

    interface BasePersenter {

    }
}
