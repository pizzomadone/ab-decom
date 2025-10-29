/*
 * Decompiled with CFR 0.152.
 */
package c;

final class c
extends Enum {
    public static final /* enum */ c a = new c("NOTHING", 0);
    public static final /* enum */ c b = new c("DELIMETER", 1);
    public static final /* enum */ c c = new c("INTEGER", 2);
    public static final /* enum */ c d = new c("OCTINTEGER", 3);
    public static final /* enum */ c e = new c("HEXINTEGER", 4);
    public static final /* enum */ c f = new c("BININTEGER", 5);
    public static final /* enum */ c g = new c("DOUBLE", 6);
    public static final /* enum */ c h = new c("STRING", 7);
    public static final /* enum */ c i = new c("VARIABLE", 8);
    public static final /* enum */ c j = new c("FUNCTION", 9);
    public static final /* enum */ c k = new c("ARRAY", 10);
    public static final /* enum */ c l = new c("ARRAYRESOLVED", 11);
    public static final /* enum */ c m = new c("UNKNOWN", 12);
    private static final /* synthetic */ c[] n;

    static {
        n = new c[]{a, b, c, d, e, f, g, h, i, j, k, l, m};
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private c() {
        void var2_-1;
        void var1_-1;
    }

    public static c[] a() {
        c[] cArray = new c[13];
        System.arraycopy(n, 0, cArray, 0, 13);
        return cArray;
    }
}

