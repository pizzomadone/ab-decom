/*
 * Decompiled with CFR 0.152.
 */
package c;

final class b
extends Enum {
    public static final /* enum */ b a = new b("UNKNOWN", 0);
    public static final /* enum */ b b = new b("ASSIGN", 1);
    public static final /* enum */ b c = new b("AND", 2);
    public static final /* enum */ b d = new b("OR", 3);
    public static final /* enum */ b e = new b("BITAND", 4);
    public static final /* enum */ b f = new b("BITOR", 5);
    public static final /* enum */ b g = new b("BITSHIFTLEFT", 6);
    public static final /* enum */ b h = new b("BITSHIFTRIGHT", 7);
    public static final /* enum */ b i = new b("EQUAL", 8);
    public static final /* enum */ b j = new b("UNEQUAL", 9);
    public static final /* enum */ b k = new b("SMALLER", 10);
    public static final /* enum */ b l = new b("LARGER", 11);
    public static final /* enum */ b m = new b("SMALLEREQ", 12);
    public static final /* enum */ b n = new b("LARGEREQ", 13);
    public static final /* enum */ b o = new b("PLUS", 14);
    public static final /* enum */ b p = new b("MINUS", 15);
    public static final /* enum */ b q = new b("NEGATION", 16);
    public static final /* enum */ b r = new b("MULTIPLY", 17);
    public static final /* enum */ b s = new b("DIVIDE", 18);
    public static final /* enum */ b t = new b("MODULUS", 19);
    public static final /* enum */ b u = new b("XOR", 20);
    public static final /* enum */ b v = new b("POW", 21);
    public static final /* enum */ b w = new b("FACTORIAL", 22);
    private static final /* synthetic */ b[] x;

    static {
        x = new b[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w};
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private b() {
        void var2_-1;
        void var1_-1;
    }

    public static b[] a() {
        b[] bArray = new b[23];
        System.arraycopy(x, 0, bArray, 0, 23);
        return bArray;
    }
}

