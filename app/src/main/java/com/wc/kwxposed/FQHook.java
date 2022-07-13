package com.wc.kwxposed;

import android.util.Log;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class FQHook {
    public static void hookVip(XC_LoadPackage.LoadPackageParam lpparam) {
        Log.e(MainHook.TAG, "进入番茄小说");
        Class<?> vipInfoModel = XposedHelpers.findClass("com.dragon.read.user.model.VipInfoModel", lpparam.classLoader);
        Class<?> vipInfo = XposedHelpers.findClass("com.dragon.read.rpc.model.VipInfo", lpparam.classLoader);
        XposedHelpers.findAndHookMethod(vipInfoModel, "parseResponse", vipInfo, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
                Log.d(MainHook.TAG, "com.dragon.read.user.model.VipInfoModel parseResponse");
                XposedHelpers.setObjectField(param.args[0], "isVip", "1");
                XposedHelpers.setObjectField(param.args[0], "expireTime", "2604379373");
            }
        });
    }
}
