package com.oblivion.day_account.ui.fragment;

import com.oblivion.day_account.contract.BaseContract;
import com.oblivion.day_account.model.net.bean.AccountbannerBean;

/**
 * author:Created by Oblivion on 2017/2/10.
 * 功能描述:
 */

public interface AccountFragmentView extends BaseContract.BaseView<AccountbannerBean> {
    void showComplete(AccountbannerBean bean);
}
