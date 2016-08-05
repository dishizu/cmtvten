package com.example.administrator.chushoutv.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.administrator.chushoutv.callback.LoginSuccessListener;
import com.example.administrator.chushoutv.constants.SharedPreferencesString;
import com.mob.tools.utils.UIHandler;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.tencent.qq.QQ;

/**
 * Created by Administrator on 2016/7/27.
 */
public class SharedLoginUtils  {

    public static LoginSuccessListener loginSuccessListener;

    public static void setLoginSuccessListener(LoginSuccessListener loginSuccessListener1){
        loginSuccessListener = loginSuccessListener1;
    }

    //登录
    public static void login(final Context context) {
/**
 * 获取指定平台对象
 * 参数2:平台的名称
 */
            ShareSDK.initSDK(context);
            Platform platform = ShareSDK.getPlatform(context, QQ.NAME);
//            //移除账号信息(调用此方法，再次登录会弹出输入用户名密码的授权页面)
//            platform.removeAccount();
            //参数值为null获取当前登录的账号信息
            platform.showUser(null);
            //设置登录结果监听
            platform.setPlatformActionListener(new PlatformActionListener() {

                @Override
                public void onComplete(final Platform platform, final int i, final HashMap<String, Object> hashMap) {

                    //更新UI方式3；sharesdk提供的更新UI的类
                    final Message message = new Message();
                    message.what = 0;
                    message.obj = hashMap;
                    UIHandler.sendMessage(message, new Handler.Callback() {
                        @Override
                        public boolean handleMessage(Message msg) {
                            if (msg.what == 0) {
                                if (platform.getName().equals(QQ.NAME)) {
                                    HashMap<String, Object> hashMap1 = (HashMap<String, Object>) msg.obj;
                                    //遍历
                                }

                                String name = platform.getDb().getUserName();
                                String icon = platform.getDb().getUserIcon();

                                loginSuccessListener.loginSuccessListener(name,icon);

                                //把昵称和头像地址存入SharedPrefrences中
                                SharedPreferences sharedPreferencesaccount;
                                sharedPreferencesaccount = context.getSharedPreferences(SharedPreferencesString.NAME, Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferencesaccount.edit();

                                editor.putString(SharedPreferencesString.USER_NAME,name);
                                editor.putString(SharedPreferencesString.HEAD_PIC,icon);
                                editor.putBoolean(SharedPreferencesString.ISLOGIN,true);
                                editor.commit();

                            }
                            return false;
                        }
                    });
                }

                @Override
                public void onError(Platform platform, int i, Throwable throwable) {
                    Log.e("=====", "===登录失败===" + throwable.getMessage());
                }

                @Override
                public void onCancel(Platform platform, int i) {
                    Log.e("=====", "===登录取消===");
                }
            });

    }
    //分享
    public static void share(Context context){
        ShareSDK.initSDK(context);
        OnekeyShare oks = new OnekeyShare();
        //false显示编辑页面，true隐藏编辑页面，默认false
        oks.setSilent(false);
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

// 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle("分享：");
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("这件商品我很喜欢！");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("你值得拥有");
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");
        // 启动分享GUI(图形用户界面接口)
        oks.show(context);
    }

}
