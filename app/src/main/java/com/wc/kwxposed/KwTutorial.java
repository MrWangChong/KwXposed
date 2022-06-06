package com.wc.kwxposed;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class KwTutorial implements IXposedHookLoadPackage {
    private static final String TAG = "KwTutorial";
    private static final String KW_PACKAGE_NAME = "cn.kuwo.player";
    private Context mContext = null;

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (lpparam == null || !lpparam.packageName.equals(KW_PACKAGE_NAME))
            return;
        Log.e(TAG, "进入酷我音乐");
        findAndHookMethod("cn.kuwo.peculiar.specialinfo.b", lpparam.classLoader, "c", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                Log.d(TAG, "cn.kuwo.peculiar.specialinfo.b.c param.setResult(1)");
                param.setResult(1);
            }
        });

        findAndHookMethod("cn.kuwo.peculiar.specialinfo.b", lpparam.classLoader, "d", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                Log.d(TAG, "cn.kuwo.peculiar.specialinfo.b.d param.setResult(1024L)");
                param.setResult(1024L);
            }
        });

        findAndHookMethod("cn.kuwo.base.bean.Music", lpparam.classLoader, "getSpPrivilege", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                Log.d(TAG, "cn.kuwo.base.bean.Music.getSpPrivilege param.setResult(1)");
                param.setResult(1);
            }
        });

        findAndHookMethod("cn.kuwo.base.bean.Music", lpparam.classLoader, "isSpPrivilege", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                Log.d(TAG, "cn.kuwo.base.bean.Music.isSpPrivilege param.setResult(true)");
                param.setResult(true);
            }
        });

        //无关紧要的hook
        final Class<?> clazz = XposedHelpers.findClass("android.app.Instrumentation", null);
        XposedHelpers.findAndHookMethod(clazz, "callApplicationOnCreate", Application.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                Log.e(TAG, "android.app.Instrumentation callApplicationOnCreate");
                if (param.args[0] instanceof Application) {
                    mContext = ((Application) param.args[0]).getApplicationContext();
                } else {
                    Log.i(TAG, "hook callApplicationOnCreate failed");
                }
            }
        });

        XposedHelpers.findAndHookMethod("cn.kuwo.player.activities.MainActivity", lpparam.classLoader, "onCreate", Bundle.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);
                        Log.e(TAG, "cn.kuwo.player.activities.MainActivity onCreate");
                        if (mContext != null) {
                            Toast.makeText(mContext, "酷我音乐模块加载成功", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);
                    }
                });
    }
}
