package com.oblivion.day_account.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.github.nukc.stateview.StateView;
import com.oblivion.day_account.MyApplication;
import com.oblivion.day_account.R;
import com.oblivion.day_account.dagger2.module.AccountFragmentModule;
import com.oblivion.day_account.model.net.BaseVar;
import com.oblivion.day_account.model.net.bean.NewsBean;
import com.oblivion.day_account.persenter.fragment.AccountFragmentPresenter;
import com.oblivion.day_account.ui.fragment.Base.BaseFragment;
import com.oblivion.day_account.ui.fragment.adapter.AccountPagerAdapter;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * author:Created by Oblivion on 2017/1/19.
 * 功能描述:
 */

public class AccountFragment extends BaseFragment implements AccountFragmentView {
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    private AccountPagerAdapter adapter;

    @Inject
    AccountFragmentPresenter presenter;

    @Override
    public View createView(ViewGroup container) {
        View view = View.inflate(mActivity, R.layout.account_fragment, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void initView() {
        ((MyApplication) mActivity.getApplication()).getAppComponent()
                .addSub(new AccountFragmentModule(this)).inject(this);
        presenter.getRawData("top", BaseVar.JH_NEWS_KEY, 0);
        adapter = new AccountPagerAdapter(getChildFragmentManager());
        viewpager.setAdapter(adapter);

        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewpager);
        initListener();
    }

    private void initListener() {
        //实现HorScroll的跳页
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
               /* if (tab.getPosition() > 4) {
                   // horScroll.pageScroll(FOCUS_RIGHT);
                } else {
                 //   horScroll.pageScroll(FOCUS_LEFT);

                }*/
                presenter.getRawData(BaseVar.arrPINYIN[tab.getPosition()], BaseVar.JH_NEWS_KEY, tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void showEmpty() {
        stateView.showEmpty();
    }

    @Override
    public void showErrow() {
        stateView.showRetry();
        stateView.setOnRetryClickListener(new StateView.OnRetryClickListener() {
            @Override
            public void onRetryClick() {
                //重新加载数据
                //  presenter.getRawData(BaseVar.arrPINYIN[tabLayout.getSelectedTabPosition()], BaseVar.JH_NEWS_KEY);
            }
        });
    }

    @Override
    public void showLoadding() {
        stateView.showLoading();
    }

    @Override
    public void showComplete(NewsBean bean, int position) {
        // ToastUtils.makeText(mActivity, bean.result.data.get(1).title + "");
        EventBus.getDefault().post(bean);
    }
}
