/*
 * Decompiled with CFR 0.152.
 */
package a.e;

public class a {
    protected int a() {
        return 0;
    }

    protected char a(int n2) {
        return '\u0000';
    }

    public final char[] b() {
        char[] cArray = null;
        if (this.a() > 0) {
            int n2 = this.a();
            cArray = new char[n2];
            int n3 = 0;
            while (n3 < n2) {
                cArray[n3] = this.a(n3);
                ++n3;
            }
        }
        return cArray;
    }
}

