package com.wc.kwxposed;

import android.util.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class MainHook implements IXposedHookLoadPackage {
    public static final String TAG = "MainHook";
    private static final String KW_PACKAGE_NAME = "cn.kuwo.player";
    private static final String FQ_PACKAGE_NAME = "com.dragon.read";

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (lpparam == null) {
            return;
        }
        if (lpparam.packageName.equals(KW_PACKAGE_NAME)) {
            KWHook.hookVip(lpparam);
        } else if (lpparam.packageName.equals(FQ_PACKAGE_NAME)) {
            FQHook.hookVip(lpparam);
        }
    }
}
