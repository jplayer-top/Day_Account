package com.oblivion.day_account.ui.fragment;

import java.util.HashMap;

/**
 * author:Created by Oblivion on 2017/2/13.
 * 功能描述:
 */

public class NewsFragmentFactory {
    public static HashMap<Integer, NewsFragment> map = new HashMap<>();

    public static NewsFragment getFragment(int position) {
        NewsFragment fragment;
        if (!map.containsKey(position)) {
            fragment = new NewsFragment();
            map.put(position, fragment);
        } else {
            fragment = map.get(position);
        }
        return fragment;
    }
}
