package com.wc.kwxposed;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

import android.util.Log;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class KwTutorial implements IXposedHookLoadPackage {
    private static final String KW_PACKAGE_NAME = "cn.kuwo.player";

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (lpparam == null || !lpparam.packageName.equals(KW_PACKAGE_NAME))
            return;
        Log.e("KwTutorial", "进入酷我音乐");
        findAndHookMethod("cn.kuwo.peculiar.specialinfo.c", lpparam.classLoader, "c", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                param.setResult(1);
            }
        });

        findAndHookMethod("cn.kuwo.peculiar.specialinfo.c", lpparam.classLoader, "d", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                param.setResult(1024L);
            }
        });

        findAndHookMethod("cn.kuwo.peculiar.specialinfo.c", lpparam.classLoader, "d", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                param.setResult(1024L);
            }
        });

        findAndHookMethod("cn.kuwo.base.bean.Music", lpparam.classLoader, "getSpPrivilege", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                param.setResult(1);
            }
        });

        findAndHookMethod("cn.kuwo.base.bean.Music", lpparam.classLoader, "isSpPrivilege", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                param.setResult(true);
            }
        });
    }
}
