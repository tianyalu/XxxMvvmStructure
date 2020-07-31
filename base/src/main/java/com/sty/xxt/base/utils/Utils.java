
package com.sty.xxt.base.utils;

import android.util.SparseArray;

import java.util.Collection;
import java.util.Map;

public class Utils {
    private static final String TAG = "Utils";
    private static final boolean DEBUG = false;

    public static boolean isEmpty(final String str) {
        return str == null || str.length() <= 0;
    }

    public static boolean isEmpty(final SparseArray sparseArray) {
        return sparseArray == null || sparseArray.size() <= 0;
    }

    public static boolean isEmpty(final Collection<? extends Object> collection) {
        return collection == null || collection.size() <= 0;
    }

    public static boolean isEmpty(final Map<? extends Object, ? extends Object> list) {
        return list == null || list.size() <= 0;
    }

    public static boolean isEmpty(final byte[] bytes) {
        return bytes == null || bytes.length <= 0;
    }

    public static boolean isEmpty(final String[] strArr) {
        return strArr == null || strArr.length <= 0;
    }

    public static int nullAs(final Integer obj, final int def) {
        return obj == null ? def : obj;
    }

    public static long nullAs(final Long obj, final long def) {
        return obj == null ? def : obj;
    }

    public static boolean nullAs(final Boolean obj, final boolean def) {
        return obj == null ? def : obj;
    }

    public static String nullAs(final String obj, final String def) {
        return obj == null ? def : obj;
    }

    public static String emptyAs(final String obj, final String def) {
        return isEmpty(obj) ? def : obj;
    }

    public static int nullAsNil(final Integer obj) {
        return obj == null ? 0 : obj;
    }

    public static long nullAsNil(final Long obj) {
        return obj == null ? 0L : obj;
    }

    public static String nullAsNil(final String obj) {
        return obj == null ? "" : obj;
    }


    public static boolean isEmpty(int[] si) {
        return si == null || si.length == 0;
    }
}
