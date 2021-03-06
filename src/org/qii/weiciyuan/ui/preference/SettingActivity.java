package org.qii.weiciyuan.ui.preference;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import org.qii.weiciyuan.R;
import org.qii.weiciyuan.ui.interfaces.AbstractAppActivity;
import org.qii.weiciyuan.ui.main.MainTimeLineActivity;

/**
 * User: Jiang Qi
 * Date: 12-8-6
 */
public class SettingActivity extends AbstractAppActivity {


    public static final String DISABLE_DOWNLOAD_AVATAR_PIC = "disable_download";
    public static final String CLOSE_COMMENT_AND_REPOST_AVATAR = "disable_comment_repost_list_avatar";
    public static final String THEME = "theme";
    public static final String LIST_AVATAR_MODE = "list_avatar_mode";
    public static final String LIST_PIC_MODE = "list_pic_mode";

    public static final String SOUND = "sound";
    public static final String AUTO_REFRESH = "auto_refresh";

    //notification
    public static final String FREQUENCY = "frequency";
    public static final String ENABLE_FETCH_MSG = "enable_fetch_msg";
    public static final String DISABLE_FETCH_AT_NIGHT = "disable_fetch_at_night";
    public static final String ENABLE_VIBRATE = "vibrate";
    public static final String ENABLE_LED = "led";
    public static final String ENABLE_RINGTONE = "ringtone";


    public static final String FONT_SIZE = "font_size";
    public static final String OFFICIAL_WEIBO = "official_weibo";

    public static final String SHOW_BIG_PIC = "show_big_pic";
    public static final String SHOW_BIG_AVATAR = "show_big_avatar";

    public static final String FILTER = "filter";

    public static final String SUGGEST = "suggest";

    public static final String VERSION = "version";
    public static final String RECOMMEND="recommend";

    public static final String UPLOAD_PIC_QUALITY = "upload_pic_quality";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setTitle(getString(R.string.setting));

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .replace(android.R.id.content, new SettingsFragment())
                    .commit();
        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case android.R.id.home:
                intent = new Intent(this, MainTimeLineActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                return true;
        }
        return false;
    }


}


