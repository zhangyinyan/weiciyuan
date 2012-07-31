package org.qii.weiciyuan.ui;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.Menu;
import org.qii.weiciyuan.R;
import org.qii.weiciyuan.bean.TimeLineMsgList;
import org.qii.weiciyuan.ui.timeline.*;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Jiang Qi
 * Date: 12-7-27
 * Time: 下午1:02
 */
public class MainTimeLineActivity extends AbstractMainActivity {


    private ViewPager mViewPager;


    private String token;

    private String screen_name;

    private TimeLineMsgList homeList = new TimeLineMsgList();
    private TimeLineMsgList mentionList = new TimeLineMsgList();
    private TimeLineMsgList commentList = new TimeLineMsgList();
    private TimeLineMsgList mailList = new TimeLineMsgList();

    private int homelist_position = 0;
    private int mentionList_position = 0;
    private int commentList_position = 0;
    private int mailList_position = 0;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.maintimelineactivity_viewpager_layout);

        final ActionBar actionBar = getActionBar();

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);


        Intent intent = getIntent();

        token = intent.getStringExtra("token");
        screen_name = intent.getStringExtra("screen_name");

        if (!TextUtils.isEmpty(screen_name))
            actionBar.setTitle(screen_name);


        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        TimeLinePagerAdapter timeLinePagerAdapter = new TimeLinePagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(timeLinePagerAdapter);
        mViewPager.setOnPageChangeListener(simpleOnPageChangeListener);

        actionBar.addTab(actionBar.newTab()
                .setText("首页")
                .setTabListener(tabListener));

        actionBar.addTab(actionBar.newTab()
                .setText("回复")
                .setTabListener(tabListener));

        actionBar.addTab(actionBar.newTab()
                .setText("评论")
                .setTabListener(tabListener));

        actionBar.addTab(actionBar.newTab()
                .setText("私信")
                .setTabListener(tabListener));

        actionBar.addTab(actionBar.newTab()
                .setText("资料")
                .setTabListener(tabListener));

        ((AbstractTimeLineFragment) timeLinePagerAdapter.getItem(0)).refresh();
    }



    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {


        return super.onPrepareOptionsMenu(menu);    //To change body of overridden methods use File | Settings | File Templates.
    }

    ViewPager.SimpleOnPageChangeListener simpleOnPageChangeListener = new ViewPager.SimpleOnPageChangeListener() {
        @Override
        public void onPageSelected(int position) {

            getActionBar().setSelectedNavigationItem(position);
        }
    };

    ActionBar.TabListener tabListener = new ActionBar.TabListener() {
        public void onTabSelected(ActionBar.Tab tab,
                                  FragmentTransaction ft) {

            mViewPager.setCurrentItem(tab.getPosition());
        }

        public void onTabUnselected(ActionBar.Tab tab,
                                    FragmentTransaction ft) {
        }

        public void onTabReselected(ActionBar.Tab tab,
                                    FragmentTransaction ft) {
        }
    };

    class TimeLinePagerAdapter extends
            FragmentStatePagerAdapter {

        List<Fragment> list = new ArrayList<Fragment>();

        public TimeLinePagerAdapter(FragmentManager fm) {
            super(fm);

            AbstractTimeLineFragment home = new FriendsTimeLineFragment();
            AbstractTimeLineFragment mentions = new MentionsTimeLineFragment();
            AbstractTimeLineFragment comments = new CommentsTimeLineFragment();
            AbstractTimeLineFragment mails = new MailsTimeLineFragment();
            AbstractTimeLineFragment info = new MyInfoTimeLineFragment();


            list.add(home);
            list.add(mentions);
            list.add(comments);
            list.add(mails);
            list.add(info);


        }

        @Override
        public Fragment getItem(int i) {

            return list.get(i);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }

    public int getMentionList_position() {
        return mentionList_position;
    }

    public void setMentionList_position(int mentionList_position) {
        this.mentionList_position = mentionList_position;
    }

    public int getCommentList_position() {
        return commentList_position;
    }

    public void setCommentList_position(int commentList_position) {
        this.commentList_position = commentList_position;
    }

    public int getMailList_position() {
        return mailList_position;
    }

    public void setMailList_position(int mailList_position) {
        this.mailList_position = mailList_position;
    }

    public int getHomelist_position() {
        return homelist_position;
    }

    public void setHomelist_position(int homelist_position) {
        this.homelist_position = homelist_position;
    }


    public TimeLineMsgList getMentionList() {
        return mentionList;
    }

    public void setMentionList(TimeLineMsgList mentionList) {
        this.mentionList = mentionList;
    }

    public TimeLineMsgList getCommentList() {
        return commentList;
    }

    public void setCommentList(TimeLineMsgList commentList) {
        this.commentList = commentList;
    }

    public TimeLineMsgList getMailList() {
        return mailList;
    }

    public void setMailList(TimeLineMsgList mailList) {
        this.mailList = mailList;
    }

    public String getToken() {
        return token;
    }

    public TimeLineMsgList getHomeList() {
        return homeList;
    }

    public void setHomeList(TimeLineMsgList homeList) {
        this.homeList = homeList;
    }

}