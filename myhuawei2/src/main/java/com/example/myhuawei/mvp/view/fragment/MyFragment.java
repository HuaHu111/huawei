package com.example.myhuawei.mvp.view.fragment;

import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myhuawei.R;
import com.example.myhuawei.adapter.MySubAdapter;
import com.example.myhuawei.base.BaseFragment;
import com.example.myhuawei.bean.MyGvBean;
import com.example.myhuawei.utils.UIUtils;
import com.example.myhuawei.view.LoadingPager;
import com.example.myhuawei.view.widge.EnterLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

import static com.example.myhuawei.R.id.about_layout;
import static com.example.myhuawei.R.id.book_game_layout;
import static com.example.myhuawei.R.id.buy_layout;
import static com.example.myhuawei.R.id.check_update_layout;
import static com.example.myhuawei.R.id.faq_layout;
import static com.example.myhuawei.R.id.gv_title_grid;
import static com.example.myhuawei.R.id.huaban_layout;
import static com.example.myhuawei.R.id.setting_computer;

/**
 * Created by acer on 2018/10/17.
 */

public class MyFragment extends BaseFragment {


    @InjectView(R.id.account_icon)
    ImageView accountIcon;
    @InjectView(R.id.account_detail)
    ImageView accountDetail;
    @InjectView(R.id.mine_nickname)
    TextView mineNickname;
    @InjectView(R.id.mine_account_info)
    LinearLayout mineAccountInfo;
    @InjectView(R.id.myaccount_layout)
    RelativeLayout myaccountLayout;
    @InjectView(R.id.gticket_txt)
    TextView gticketTxt;
    @InjectView(R.id.gticket_num)
    TextView gticketNum;
    @InjectView(R.id.gticket_layout)
    LinearLayout gticketLayout;
    @InjectView(R.id.hcoin_txt)
    TextView hcoinTxt;
    @InjectView(R.id.hcoin_num)
    TextView hcoinNum;
    @InjectView(R.id.hcoin_layout)
    LinearLayout hcoinLayout;
    @InjectView(R.id.gticket_hcoin_layout)
    LinearLayout gticketHcoinLayout;
    @InjectView(R.id.divider_line_bottom)
    ImageView dividerLineBottom;
    @InjectView(gv_title_grid)
    GridView gvTitleGrid;
    @InjectView(book_game_layout)
    EnterLayout bookGameLayout;
    @InjectView(buy_layout)
    EnterLayout buyLayout;
    @InjectView(huaban_layout)
    EnterLayout huabanLayout;
    @InjectView(setting_computer)
    EnterLayout settingComputer;
    @InjectView(faq_layout)
    EnterLayout faqLayout;
    @InjectView(check_update_layout)
    EnterLayout checkUpdateLayout;
    @InjectView(about_layout)
    EnterLayout aboutLayout;
    private List<MyGvBean> gvBeanList = new ArrayList<>() ;
    private String[] titles = {"奖品","礼包",""};


    @Override
    protected View creatSuccessView() {
        View view = UIUtils.inflate(R.layout.fragment_my);
        ButterKnife.inject(this, view);
        initView();
        return view;
    }

    @Override
    protected void load() {
        setState(LoadingPager.LoadResult.success);
    }


    public void initView() {

        gvBeanList.clear();

        gvBeanList.add(new MyGvBean(UIUtils.getString(R.string.market_prize),R.drawable.icon_market_lucky_draw));
        gvBeanList.add(new MyGvBean(UIUtils.getString(R.string.market_gift),R.drawable.ic_mine_package_normal));
        gvBeanList.add(new MyGvBean(UIUtils.getString(R.string.appzone_comments),R.drawable.icon_market_comment));
        gvBeanList.add(new MyGvBean(UIUtils.getString(R.string.market_mine_message),R.drawable.icon_market_message));

        MySubAdapter adapter = new MySubAdapter(getContext(),gvBeanList) ;
        gvTitleGrid.setNumColumns(gvBeanList.size());
        gvTitleGrid.setAdapter(adapter);

        bookGameLayout.setTitle(UIUtils.getString(R.string.reserve_warpup_game_str));
        buyLayout.setTitle(UIUtils.getString(R.string.purchase_title));
        huabanLayout.setTitle(UIUtils.getString(R.string.mine_point_area));
        settingComputer.setTitle(UIUtils.getString(R.string.action_settings));
        faqLayout.setTitle(UIUtils.getString(R.string.menu_feedback));
        checkUpdateLayout.setTitle(UIUtils.getString(R.string.settings_check_version_update));
        aboutLayout.setTitle(UIUtils.getString(R.string.about));
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        gvBeanList.clear();
    }
}
