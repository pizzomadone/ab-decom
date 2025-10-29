/*
 * Decompiled with CFR 0.152.
 */
package com.algobuild.core.application;

import a.c.a.g;
import b.a.c;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class h {
    private String a;
    private String b;
    private long c;
    private String d;
    private String e;

    public h(g g2) {
        this.a = null;
        this.b = null;
        this.c = 0L;
        this.d = null;
        this.e = null;
    }

    public h(g g2, String string, String string2, long l2, String string3, String string4) {
        this.a = string;
        this.b = string2;
        this.c = l2;
        this.d = string3;
        this.e = string4;
    }

    public final c a() {
        c c2 = new c();
        c2.b("s", this.a);
        c2.b("a", this.b);
        long l2 = this.c;
        String string = "t";
        c c3 = c2;
        c3.b(string, new Long(l2));
        c2.b("f", this.d);
        c2.b("z", this.e);
        return c2;
    }

    public final void a(c c2) {
        this.a = c2.f("s");
        this.b = c2.f("a");
        String string = "t";
        c c3 = c2;
        this.c = c3.a(string, 0L);
        this.d = c2.f("f");
        this.e = c2.f("z");
    }

    public final String toString() {
        return "SaveHistoryEntry [serial=" + this.a + ", authorName=" + this.b + ", saveTime=" + this.c + ", fileName=" + this.d + ", sizeDescription=" + this.e + "]";
    }

    public final String b() {
        String string = "";
        Object object = new SimpleDateFormat();
        ((SimpleDateFormat)object).applyPattern("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(this.c);
        object = ((DateFormat)object).format(date);
        if (this.b != null && this.b.length() > 0) {
            string = String.valueOf(string) + "u:" + this.b;
        }
        if (this.a != null && this.a.length() > 0) {
            string = String.valueOf(string) + "  /  s:" + this.a;
        }
        if (object != null && ((String)object).length() > 0) {
            string = String.valueOf(string) + "  /  d:" + (String)object;
        }
        if (this.d != null && this.d.length() > 0) {
            string = String.valueOf(string) + " fn:" + this.d;
        }
        if (this.e != null && this.e.length() > 0) {
            string = String.valueOf(string) + " fs:" + this.e;
        }
        return string;
    }
}

