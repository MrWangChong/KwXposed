package com.wc.kwxposed;

import android.util.Log;

import java.lang.reflect.Field;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class Test {
    public static void hook(XC_LoadPackage.LoadPackageParam lpparam) {
        //Class<?> communityAvBean = XposedHelpers.findClass("com.wukong.comic.android.bean.v2.community.CommunityAvBean", lpparam.classLoader);
        //List<CommunityAvBean> ==> java.lang.reflect.Array.newInstance(communityAvBean, 2).getClass()
//            Class<?> videoPlayerDetailBean = XposedHelpers.findClass("com.ava.android.bean.videodetail.VideoPlayerDetailBean", lpparam.classLoader);
//            XposedHelpers.findAndHookMethod("com.ava.android.ui.VideoPlayerActivity", lpparam.classLoader, "i0", videoPlayerDetailBean, new XC_MethodHook() {
//                @Override
//                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                    Log.d(MainHook.TAG, "com.ava.android.ui.VideoPlayerActivity i0");
//                    Field[] fields = videoPlayerDetailBean.getDeclaredFields();
//                    for (Field field : fields) {
//                        String name = field.getName();//变量名
//                        Class<?> type = field.getType();//变量的类型
//                        Object o = field.get(param.args[0]);//变量的值
//                        Log.d(MainHook.TAG, type.getName() + " -- " + name + " = " + o);
//                    }
//                }
//            });

        Class<?> playUrlBean = XposedHelpers.findClass("com.ava.android.bean.PlayUrlBean", lpparam.classLoader);
        XposedHelpers.findAndHookMethod("com.ava.android.ui.VideoPlayerActivity", lpparam.classLoader, "Z1", playUrlBean, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                Log.d(MainHook.TAG, "com.ava.android.ui.VideoPlayerActivity Z1");
                Field[] fields = playUrlBean.getDeclaredFields();
                for (Field field : fields) {
                    String name = field.getName();//变量名
                    Class<?> type = field.getType();//变量的类型
                    Object o = field.get(param.args[0]);//变量的值
                    Log.d(MainHook.TAG, type.getName() + " -- " + name + " = " + o);
                }
            }
        });
        XposedHelpers.findAndHookMethod("com.ava.android.ui.VideoPlayerActivity", lpparam.classLoader, "I2", playUrlBean, int.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                Log.d(MainHook.TAG, "com.ava.android.ui.VideoPlayerActivity I2 " + param.args[1]);
                Field[] fields = playUrlBean.getDeclaredFields();
                for (Field field : fields) {
                    String name = field.getName();//变量名
                    Class<?> type = field.getType();//变量的类型
                    Object o = field.get(param.args[0]);//变量的值
                    Log.d(MainHook.TAG, type.getName() + " -- " + name + " = " + o);
                }
            }
        });

        Class<?> appStartBean = XposedHelpers.findClass("com.wukong.comic.android.bean.v2.community.AppStartBean", lpparam.classLoader);
        XposedHelpers.findAndHookMethod("com.ava.android.ui.LaunchActivity", lpparam.classLoader, "r0", appStartBean, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                Log.d(MainHook.TAG, "com.ava.android.ui.LaunchActivity r0");
                XposedHelpers.setBooleanField(param.args[0], "isVip", true);
            }
        });
        //Class<?> userInfoBean = XposedHelpers.findClass("com.ava.android.bean.UserInfoBean", lpparam.classLoader);
        Class<?> userCenterBean = XposedHelpers.findClass("com.ava.android.bean.UserCenterBean", lpparam.classLoader);
        XposedHelpers.findAndHookMethod("com.ava.android.j.e", lpparam.classLoader, "o", userCenterBean, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                Log.d(MainHook.TAG, "com.ava.android.j.e o");
                Field[] fields = userCenterBean.getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);//设置权限 可以对非public修饰的变量操作
                    String name = field.getName();//变量名
                    Class<?> type = field.getType();//变量的类型
                    Log.d(MainHook.TAG, "type = " + type.getName() + " name = " + name);
                    Object o = field.get(param.args[0]);//变量的值
                    XposedHelpers.setBooleanField(o, "isVip", true);
                    XposedHelpers.setIntField(o, "vip_level", 1);
                    XposedHelpers.setObjectField(o, "expiredAt", "2604379373");

                    XposedHelpers.setIntField(o, "canDownCount", 1000);
                    XposedHelpers.setIntField(o, "canWatchCount", 2000);
                    XposedHelpers.setObjectField(o, "coins", "100000");
                    XposedHelpers.setIntField(o, "hasDownCount", 996);
                    XposedHelpers.setIntField(o, "hasWatchCount", 1996);
                    XposedHelpers.setObjectField(o, "watchStr", "剩余次数1996/2000");
                }
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
//                    Field[] fields = userCenterBean.getDeclaredFields();
//                    for (Field field : fields) {
//                        Object o = field.get(param.args[0]);//变量的值
//                        Field[] fieldsInfo = userInfoBean.getDeclaredFields();
//                        for (Field fieldInfo : fieldsInfo) {
//                            String name = fieldInfo.getName();//变量名
//                            Class<?> type = fieldInfo.getType();//变量的类型
//                            Object oInfo = fieldInfo.get(o);//变量的值
//                            Log.d(MainHook.TAG, "type = " + type.getName() + " name = " + name + " value = " + oInfo);
//                        }
//                    }
            }
        });
    }
}
