package com.wc.kwxposed;

import android.content.Context;
import android.util.Log;

import java.util.List;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class KWHook {
    public static void hookVip(XC_LoadPackage.LoadPackageParam lpparam) {
        Log.e(MainHook.TAG, "进入酷我音乐");
        //vip
        XposedHelpers.findAndHookMethod("cn.kuwo.peculiar.specialinfo.SpecialRealInfo", lpparam.classLoader, "getState", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                //Log.d(MainHook.TAG, "cn.kuwo.peculiar.specialinfo.SpecialRealInfo.getState param.setResult(1)");
                param.setResult(1);
            }
        });
        XposedHelpers.findAndHookMethod("cn.kuwo.peculiar.specialinfo.SpecialRealInfo", lpparam.classLoader, "getLeftDays", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                //Log.d(MainHook.TAG, "cn.kuwo.peculiar.specialinfo.SpecialRealInfo.getLeftDays param.setResult(1024L)");
                param.setResult(1024L);
            }
        });
        //免费听歌
        XposedHelpers.findAndHookMethod("cn.kuwo.base.bean.Music", lpparam.classLoader, "getSpPrivilege", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                //Log.d(MainHook.TAG, "cn.kuwo.base.bean.Music.getSpPrivilege param.setResult(1)");
                param.setResult(1);
            }
        });
        XposedHelpers.findAndHookMethod("cn.kuwo.base.bean.Music", lpparam.classLoader, "isSpPrivilege", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                //Log.d(MainHook.TAG, "cn.kuwo.base.bean.Music.isSpPrivilege param.setResult(true)");
                param.setResult(true);
            }
        });
        //付费歌曲查询
        XposedHelpers.findAndHookMethod("cn.kuwo.peculiar.speciallogic.ConsumptionQueryUtil", lpparam.classLoader, "onwLimited", long.class, List.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                Log.d(MainHook.TAG, "cn.kuwo.peculiar.speciallogic.ConsumptionQueryUtil.onwLimited param.setResult(true)");
                param.setResult(true);
            }
        });
        //下载加密
        XposedHelpers.findAndHookMethod("cn.kuwo.peculiar.specialdialogconfig.VipConfigMgr", lpparam.classLoader, "isEncryptDownOpen", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                Log.d(MainHook.TAG, "cn.kuwo.peculiar.specialdialogconfig.VipConfigMgr.isEncryptDownOpen param.setResult(false)");
                param.setResult(false);
            }
        });
        //热启动广告
        XposedHelpers.findAndHookMethod("cn.kuwo.player.screen.ScreenAdUtils", lpparam.classLoader, "hotScreenSwitch", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                Log.d(MainHook.TAG, "cn.kuwo.player.screen.ScreenAdUtils.hotScreenSwitch param.setResult(false)");
                XposedBridge.log("cn.kuwo.player.screen.ScreenAdUtils.hotScreenSwitch param.setResult(false)");
                param.setResult(false);
            }
        });
        //签名校验
        XposedHelpers.findAndHookMethod("cn.kuwo.base.utils.KwLBSUtils", lpparam.classLoader, "getSignatureSha1", Context.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                Log.d(MainHook.TAG, "cn.kuwo.base.utils.KwLBSUtils.getSignatureSha1 = " + param.getResult());
            }
        });

        XposedHelpers.findAndHookMethod("cn.kuwo.base.utils.KwLBSUtils", lpparam.classLoader, "getSignatureMd5", Context.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                Log.d(MainHook.TAG, "cn.kuwo.base.utils.KwLBSUtils.getSignatureMd5 = " + param.getResult());
            }
        });
//        final Class<?> clazz = XposedHelpers.findClass("android.app.Instrumentation", null);
//        XposedHelpers.findAndHookMethod(clazz, "callApplicationOnCreate", Application.class, new XC_MethodHook() {
//            @Override
//            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                super.beforeHookedMethod(param);
//            }
//
//            @Override
//            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                super.afterHookedMethod(param);
//                Log.e(TAG, "android.app.Instrumentation callApplicationOnCreate");
//                if (param.args[0] instanceof Application) {
//                    mContext = ((Application) param.args[0]).getApplicationContext();
//                } else {
//                    Log.i(TAG, "hook callApplicationOnCreate failed");
//                }
//            }
//        });
//
//        XposedHelpers.findAndHookMethod("cn.kuwo.player.activities.MainActivity", lpparam.classLoader, "onCreate", Bundle.class,
//                new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                        super.beforeHookedMethod(param);
//                        Log.e(TAG, "cn.kuwo.player.activities.MainActivity onCreate");
//                        if (mContext != null) {
//                            Toast.makeText(mContext, "酷我音乐模块加载成功", Toast.LENGTH_LONG).show();
//                        }
//                    }
//
//                    @Override
//                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        super.afterHookedMethod(param);
//                    }
//                });
    }
}
