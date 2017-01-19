package com.oblivion.day_account.ui.fragment.Base;

import com.oblivion.day_account.ui.fragment.AccountFragment;
import com.oblivion.day_account.ui.fragment.ChartFragment;
import com.oblivion.day_account.ui.fragment.ConductFragment;
import com.oblivion.day_account.ui.fragment.MoreFragment;
import com.oblivion.day_account.ui.fragment.WalletFragment;

import java.util.HashMap;
import java.util.Map;

/**
 * author:Created by Oblivion on 2017/1/19.
 * 功能描述:
 */

public class FragmentFactory {
    private static Map<Integer, BaseFragment> fragmentMap = new HashMap<>();

    public static BaseFragment createFragment(int position) {
        if (fragmentMap.containsKey(position)) {
            return fragmentMap.get(position);
        }
        BaseFragment fragment = null;
        switch (position) {
            case BaseFragmentType.ACCOUNT_FRAGMENT_TYPE:
                fragment = new AccountFragment();
                break;
            case BaseFragmentType.WALLET_FRAGMENT_TYPE:
                fragment = new WalletFragment();
                break;
            case BaseFragmentType.CHART_FRAGMENT_TYPE:
                fragment = new ChartFragment();
                break;
            case BaseFragmentType.CONDUCT_FRAGMENT_TYPE:
                fragment = new ConductFragment();
                break;
            case BaseFragmentType.MORE_FRAGMENT_TYPE:
                fragment = new MoreFragment();
                break;
        }
        fragmentMap.put(position, fragment);
        return fragment;
    }
}
