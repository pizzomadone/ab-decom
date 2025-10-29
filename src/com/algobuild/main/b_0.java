/*
 * Decompiled with CFR 0.152.
 */
package com.algobuild.main;

import java.awt.Color;

/*
 * Renamed from a.k.b
 */
public final class b_0 {
    public static Color a = Color.white;
    private static double b;

    static {
        (new String[1])[0] = "AB0075";
        b = 1.0;
    }

    public static double a() {
        return b;
    }

    public static void a(double d2) {
        if (d2 < 0.1) {
            d2 = 0.1;
        } else if (d2 > 10.0) {
            d2 = 10.0;
        }
        b = d2;
    }
}

