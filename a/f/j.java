/*
 * Decompiled with CFR 0.152.
 */
package a.f;

import a.b.b;
import a.b.c;
import a.d.d;
import a.d.e;
import a.d.g;
import a.h.a;
import java.io.File;

public final class j {
    private static int a = -1;
    private static String b = null;
    private static String c = null;
    private static String d = null;
    private static String e = null;
    private static String f = null;
    private static File g;
    private static File h;
    private static File i;
    private static File j;

    public static int a() {
        int n2 = 0;
        int n3 = 0;
        a = -1;
        if (-1 == -1) {
            a = 0;
            int n4 = -1;
            File file = new File(a.f.j.e(), new String(new d().b()));
            if (file.exists()) {
                if (!file.isDirectory() && file.length() > 0L) {
                    n4 = 1;
                }
            } else {
                n4 = 0;
            }
            switch (n4) {
                case 1: {
                    ++n2;
                    break;
                }
                case -1: {
                    ++n3;
                }
            }
            n4 = -1;
            file = new File(a.f.j.e(), new String(new e().b()));
            if (file.exists()) {
                if (!file.isDirectory() && file.length() > 0L) {
                    n4 = 1;
                }
            } else {
                n4 = 0;
            }
            switch (n4) {
                case 1: {
                    ++n2;
                    break;
                }
                case -1: {
                    ++n3;
                }
            }
            n4 = -1;
            file = new File(a.f.j.e(), new String(new g().b()));
            if (file.exists()) {
                if (!file.isDirectory() && file.length() > 0L) {
                    n4 = 1;
                }
            } else {
                n4 = 0;
            }
            switch (n4) {
                case 1: {
                    ++n2;
                    break;
                }
                case -1: {
                    ++n3;
                }
            }
            n4 = -1;
            file = new File(a.f.j.e(), new String(new a.d.b().b()));
            if (file.exists()) {
                if (!file.isDirectory() && file.length() > 0L) {
                    n4 = 1;
                }
            } else {
                n4 = 0;
            }
            switch (n4) {
                case 1: {
                    ++n2;
                    break;
                }
                case -1: {
                    ++n3;
                }
            }
            n4 = -1;
            file = new File(a.f.j.e(), new String(new a.d.c().b()));
            if (file.exists()) {
                if (!file.isDirectory() && file.length() > 0L) {
                    n4 = 1;
                }
            } else {
                n4 = 0;
            }
            switch (n4) {
                case 1: {
                    ++n2;
                    break;
                }
                case -1: {
                    ++n3;
                }
            }
            a = n2 == 0 && n3 == 0 ? 1 : (n2 == 5 ? 0 : 2);
        }
        return a;
    }

    private static String g() {
        if (f == null) {
            f = System.getProperties().getProperty(new String(new a().b()));
        }
        return f;
    }

    public static String b() {
        if (e == null) {
            e = new String(new a.b.a().b());
        }
        return e;
    }

    public static File c() {
        if (i == null) {
            String string = a.f.j.g();
            if (b == null) {
                b = new String(new a.b.d().b());
            }
            i = new File(string, b);
        }
        return i;
    }

    public static File d() {
        if (g == null) {
            String string = a.f.j.g();
            if (c == null) {
                c = new String(new b().b());
            }
            g = new File(string, c);
        }
        return g;
    }

    public static File e() {
        if (h == null) {
            File file = a.f.j.d();
            if (d == null) {
                d = new String(new c().b());
            }
            h = new File(file, d);
        }
        return h;
    }

    public static File f() {
        if (j == null) {
            j = new File(a.f.j.d(), a.f.j.b());
        }
        return j;
    }
}

