package com.oblivion.day_account.ui.fragment;

import com.oblivion.day_account.model.net.bean.NewsBean;
import com.oblivion.day_account.contract.BaseContract;

/**
 * author:Created by Oblivion on 2017/2/10.
 * 功能描述:
 */

public interface AccountFragmentView extends BaseContract.BaseView<NewsBean> {
    void showComplete(NewsBean bean, int position);
}
