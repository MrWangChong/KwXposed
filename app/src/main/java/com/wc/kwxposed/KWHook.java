package com.wc.kwxposed;

import android.util.Log;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class KWHook {
    public static void hookVip(XC_LoadPackage.LoadPackageParam lpparam) {
        Log.e(MainHook.TAG, "进入酷我音乐");
        XposedHelpers.findAndHookMethod("cn.kuwo.peculiar.specialinfo.b", lpparam.classLoader, "c", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                Log.d(MainHook.TAG, "cn.kuwo.peculiar.specialinfo.b.c param.setResult(1)");
                param.setResult(1);
            }
        });
        XposedHelpers.findAndHookMethod("cn.kuwo.peculiar.specialinfo.b", lpparam.classLoader, "d", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                Log.d(MainHook.TAG, "cn.kuwo.peculiar.specialinfo.b.d param.setResult(1024L)");
                param.setResult(1024L);
            }
        });
        XposedHelpers.findAndHookMethod("cn.kuwo.base.bean.Music", lpparam.classLoader, "getSpPrivilege", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                Log.d(MainHook.TAG, "cn.kuwo.base.bean.Music.getSpPrivilege param.setResult(1)");
                param.setResult(1);
            }
        });

        XposedHelpers.findAndHookMethod("cn.kuwo.base.bean.Music", lpparam.classLoader, "isSpPrivilege", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                Log.d(MainHook.TAG, "cn.kuwo.base.bean.Music.isSpPrivilege param.setResult(true)");
                param.setResult(true);
            }
        });

        XposedHelpers.findAndHookMethod("cn.kuwo.player.screen.d", lpparam.classLoader, "a", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                Log.d(MainHook.TAG, "cn.kuwo.player.screen.d.a param.setResult(false)");
                XposedBridge.log("cn.kuwo.player.screen.d.a param.setResult(false)");
                param.setResult(false);
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
