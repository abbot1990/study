package com.abbot.study.tools;

import android.content.Context;

/**
 * <pre>
 *     author : fangzheng
 *     e-mail : 185849480@qq.com
 *     time   : 2017/07/09
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class DisplayUtil {

    /**
     * dp 转换 px
     * @param context
     * @param dp
     * @return px
     */
    public static int dp2px(Context context,float dp){
        return (int)(dp*getDensity(context)+0.5f);
    }

    /**
     * px 转换 dp
     * @param context
     * @param px
     * @return
     */
    public static int px2dp(Context context,float px){
        return (int) (px/getDensity(context)+0.5f);
    }

    /**
     * sp 转换为 px
     * @param context
     * @param sp
     * @return
     */
    public static int sp2px(Context context,float sp){
        return (int) (sp*getScaledDensity(context)+0.5f);
    }

    /**
     * px 转化为 sp
     * @param context
     * @param px
     * @return
     */
    public static int px2sp(Context context,float px){
        return (int) (px/getScaledDensity(context)+0.5f);
    }

    private static float getDensity(Context context){
        return context.getResources().getDisplayMetrics().density;
    }

    private static float getScaledDensity(Context context){
        return context.getResources().getDisplayMetrics().scaledDensity;
    }

}
