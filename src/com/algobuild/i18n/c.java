/*
 * Decompiled with CFR 0.152.
 */
package com.algobuild.i18n;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public final class c {
    private static ResourceBundle a = null;
    private static ResourceBundle b = null;
    private static ResourceBundle c = null;
    private static Locale d;

    public static Locale a() {
        if (d == null) {
            d = Locale.getDefault();
        }
        return d;
    }

    public static void a(Locale locale) {
        if (locale != null && !locale.equals(d)) {
            d = locale;
            if (c != null) {
                c = null;
            }
        }
    }

    public static String a(String string) {
        Object object;
        try {
            if (b == null) {
                b = ResourceBundle.getBundle("AlgoBuildMsg", Locale.ENGLISH);
                b.getString("mnuFileExit");
            }
            if (a == null) {
                a = ResourceBundle.getBundle("AlgoBuildMsg", Locale.ITALIAN);
                a.getString("mnuFileExit");
            }
            if (c == null) {
                object = a.i.c.a();
                c = ((Locale)object).getLanguage().equals(Locale.ITALIAN.getLanguage()) ? a : b;
            }
            object = c.getString(string);
        }
        catch (MissingResourceException missingResourceException) {
            object = String.valueOf(string) + " TO TRANSLATE";
            System.err.println((String)object);
        }
        catch (NullPointerException nullPointerException) {
            object = "null given TO TRANSLATE";
        }
        catch (ClassCastException classCastException) {
            object = "improper type TO TRANSLATE";
        }
        return object;
    }
}

