/*
 * Decompiled with CFR 0.152.
 */
package com.algobuild.core.application;

import a.c.a.a;
import a.c.a.c;
import a.c.a.d;
import a.c.a.f;
import a.c.a.g;
import a.c.a.i;
import a.c.a.j;
import a.c.b.n;
import a.c.b.p;
import a.c.b.q;
import a.f.h;
import a.f.k;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Vector;
import javax.swing.JOptionPane;

public final class b {
    private Map a = new TreeMap();
    private Stack b = new Stack();
    private c.a c = new c.a();
    private a d = new a();
    private Stack e = new Stack();
    private Vector f = null;
    private d g;
    private d h;
    private String i;
    private boolean j;
    private i k = new i();
    private f l;
    private String m = "";
    private int n = 0;
    private boolean o = false;
    private g p;

    public final c a() {
        if (this.b != null && !this.b.isEmpty()) {
            return (c)this.b.peek();
        }
        return null;
    }

    public b() {
        try {
            i i2 = this.k;
            Object object = "ViewOptions.abopt";
            Object object2 = a.f.j.c();
            object = new File((File)object2, (String)object);
            object2 = new FileReader((File)object);
            object = new b.a.f((Reader)object2);
            object = new b.a.c((b.a.f)object);
            object = ((b.a.c)object).e("opt");
            ((InputStreamReader)object2).close();
            i2.a((b.a.c)object);
        }
        catch (IOException iOException) {}
        this.l = new f();
        this.p = new g();
    }

    public final void b() {
        this.b.clear();
        this.e.clear();
        this.a.clear();
        this.m = "";
        this.n = 0;
        this.o = false;
        this.p.c();
    }

    public final Map c() {
        return (Map)this.e.peek();
    }

    public final Stack d() {
        return this.b;
    }

    public final c.a e() {
        return this.c;
    }

    public final void f() {
        TreeMap treeMap = new TreeMap();
        this.e.push(treeMap);
        this.a = treeMap;
    }

    public final void g() {
        if (!this.e.isEmpty()) {
            this.e.pop();
        }
        if (!this.e.isEmpty()) {
            this.a = (Map)this.e.firstElement();
            return;
        }
        this.a = null;
    }

    public final a h() {
        return this.d;
    }

    public final void i() {
        String string = "";
        String string2 = "VARIABLES:\n";
        Object object2 = this.c();
        if (object2 != null) {
            object2 = object2.entrySet();
            Iterator iterator = object2.iterator();
            while (iterator.hasNext()) {
                object2 = iterator.next();
                string = String.valueOf(string) + " | " + (String)object2.getKey() + "=" + ((c.f)object2.getValue()).b();
                string2 = String.valueOf(string2) + (String)object2.getKey() + "=" + ((c.f)object2.getValue()).a() + "\n";
            }
        }
        if (string.length() > 0) {
            string = "    VAR: " + string + " |";
        }
        if (this.f == null || this.f.size() == 0) {
            if (string.length() > 0) {
                this.h(string);
                return;
            }
        } else {
            for (Object object2 : this.f) {
                if (string.length() > 0) {
                    object2.d(string);
                }
                object2.f(string2);
            }
        }
    }

    public final void a(String object, int n2) {
        object = this.d.a((String)object, n2);
        if (this.f != null) {
            for (j j2 : this.f) {
                j2.a((d)object);
            }
            ((q)object).f();
        }
        this.a(true);
    }

    public final void a(q q2) {
        q2 = this.d.a(q2);
        if (this.f != null) {
            for (j j2 : this.f) {
                j2.a(q2);
            }
            q2.f();
        }
        this.a(true);
    }

    public final void a(String string, q q2) {
        System.out.println("CODE VIEW - RENAME CODE:" + string + " to " + q2.j());
        Object object2 = this.d.a(string);
        q q3 = this.d.a(q2.j());
        if (object2 != null && q3 == null) {
            this.d.c(string);
            this.a(true);
            if (this.f != null) {
                for (Object object2 : this.f) {
                    object2.a(string, q2);
                }
            }
        }
    }

    public final q a(String object) {
        object = this.d.a((String)object);
        return object;
    }

    public final void b(String object2) {
        q q2 = this.d.a((String)object2);
        this.d.b((String)object2);
        this.a(true);
        if (this.f != null) {
            for (Object object2 : this.f) {
                object2.b(q2);
            }
        }
    }

    public final void a(String object, int n2, n n3) {
        object = this.l((String)object);
        ((d)object).a(n3, n2);
        this.a(true);
    }

    public final void c(String string) {
        int n2 = string.lastIndexOf(".");
        if (n2 >= 0) {
            Object object = string.substring(0, n2);
            object = this.l((String)object);
            int n3 = Integer.parseInt(string.substring(n2 + 1));
            ((d)object).d(n3);
        } else {
            this.b(string);
        }
        this.a(true);
    }

    public final n d(String object) {
        int n2;
        if (object != null && !((String)object).isEmpty() && (n2 = ((String)object).indexOf(46)) >= 0) {
            Object object2 = ((String)object).substring(0, n2);
            object2 = this.a((String)object2);
            if ((object = ((String)object).substring(n2 + 1)) != null) {
                object = ((String)object).split("[.]");
                String[] stringArray = object;
                object = object2;
                if (stringArray.length == 1) {
                    return ((q)object).c(Integer.parseInt(stringArray[0]));
                }
                object = ((q)object).c(Integer.parseInt(stringArray[0]));
                int n3 = 1;
                while (n3 < stringArray.length - 1) {
                    object = ((d)object).c(Integer.parseInt(stringArray[n3]));
                    ++n3;
                }
                return ((d)object).c(Integer.parseInt(stringArray[stringArray.length - 1]));
            }
        }
        return null;
    }

    private d l(String string) {
        if (string != null && !string.isEmpty()) {
            int n2 = string.indexOf(46);
            if (n2 >= 0) {
                return this.d(string);
            }
            return this.a(string);
        }
        return null;
    }

    public final d j() {
        return this.g;
    }

    public final void a(d d2) {
        d d3 = this.g;
        this.g = d2;
        if (d3 != null) {
            d3.a(false);
        }
        if (this.g != null) {
            this.g.a(false);
        }
    }

    public final d k() {
        return this.h;
    }

    public final void b(d d2) {
        this.h = d2;
    }

    public final void a(j j2) {
        if (j2 != null) {
            if (this.f == null) {
                this.f = new Vector();
            }
            this.f.add(j2);
            j2.a(this);
        }
    }

    public final void l() {
        ++this.n;
        if (this.f != null) {
            for (j j2 : this.f) {
                j2.a(this.n);
            }
        }
    }

    public final void m() {
        this.m.length();
        if (this.n >= 0) {
            --this.n;
            if (this.f != null) {
                for (j j2 : this.f) {
                    j2.a(this.n);
                }
            }
        }
    }

    public final String e(String string) {
        Object object2 = null;
        if (this.f != null && this.f.size() != 0) {
            for (Object object2 : this.f) {
                if ((object2 = object2.g(string)) == null) continue;
                return object2;
            }
        }
        return object2;
    }

    public final void f(String string) {
        if (this.f == null || this.f.size() == 0) {
            if (this.o) {
                System.out.print(this.m);
            }
            this.o = string.endsWith("\n");
            System.out.print(string.replace("\n", "\n" + this.m));
            return;
        }
        for (j j2 : this.f) {
            if (this.o) {
                j2.a(this.m);
            }
            this.o = string.endsWith("\n");
            j2.a(string.replace("\n", "\n" + this.m));
        }
    }

    public final void n() {
        if (this.f == null || this.f.size() == 0) {
            System.out.println();
        } else {
            for (j j2 : this.f) {
                j2.b();
            }
        }
        this.o = true;
    }

    public final void g(String string) {
        if (this.f == null || this.f.size() == 0) {
            if (this.o) {
                System.out.print(this.m);
            }
            System.out.println(string);
        } else {
            for (j j2 : this.f) {
                if (this.o) {
                    j2.a(this.m);
                }
                j2.b(string);
            }
        }
        this.o = true;
    }

    public final void h(String string) {
        if (this.f == null || this.f.size() == 0) {
            this.g(string);
            return;
        }
        for (j j2 : this.f) {
            j2.c(string);
        }
    }

    public final void i(String string) {
        if (this.f == null || this.f.size() == 0) {
            this.g(string);
            return;
        }
        for (j j2 : this.f) {
            j2.e(string);
        }
    }

    private b.a.c t() {
        b.a.c c2 = new b.a.c();
        c2.b("abiid", "ABEENV");
        Object object = this.d.a();
        object = object.iterator();
        while (object.hasNext()) {
            Object object2 = (q)object.next();
            object2 = ((q)object2).b(true);
            c2.a("codepool", object2);
        }
        c2.b("viewOptions", this.k.n());
        c2.b("saveHistory", this.p.a());
        return c2;
    }

    public final void j(String object) {
        Object object2;
        Object object3 = a.f.f.a();
        String string = a.f.k.a().d();
        if (string != null) {
            object2 = a.f.k.a().b();
            Object object4 = this.d.d();
            String string2 = String.valueOf(((p)object4).a()) + "/" + ((p)object4).b();
            object4 = new File((String)object);
            this.p.a((String)object2, string, ((File)object4).getName(), string2);
        }
        object2 = this.t();
        try {
            ((a.f.f)object3).a((String)object, (b.a.c)object2);
            this.j = false;
            object3 = object;
            object = this;
            this.i = object3;
            for (Object object4 : this.f) {
                object4.b(this);
            }
            return;
        }
        catch (h h2) {
            JOptionPane.showMessageDialog(null, h2.getMessage());
            return;
        }
    }

    public final void k(String object4) {
        Iterator iterator = a.f.f.a();
        try {
            iterator = ((a.f.f)((Object)iterator)).a((String)object4);
            if (iterator != null) {
                Iterator iterator22;
                b b2 = this;
                if (b2.f != null) {
                    for (Iterator iterator22 : b2.f) {
                        iterator22.a();
                    }
                }
                b2.b();
                b2.d.b();
                iterator22 = iterator;
                b2 = this;
                Object object2 = ((b.a.c)((Object)iterator22)).e("saveHistory");
                b2.p.c();
                if (object2 != null) {
                    b2.p.a((b.a.c)object2);
                }
                if ((iterator = ((b.a.c)((Object)iterator22)).e("viewOptions")) != null) {
                    b2.k.a((b.a.c)((Object)iterator));
                }
                if ((iterator = ((b.a.c)((Object)iterator22)).d("codepool")) != null) {
                    int n2 = 0;
                    while (n2 < ((b.a.a)((Object)iterator)).a()) {
                        object2 = ((b.a.a)((Object)iterator)).c(n2);
                        n n3 = a.c.b.n.a((b.a.c)object2);
                        Object object3 = object2;
                        object2 = n3;
                        n3.a((b.a.c)object3, true);
                        if (n3 instanceof q) {
                            b2.a((q)n3);
                        }
                        ++n2;
                    }
                }
                this.j = false;
                iterator = object4;
                object4 = this;
                this.i = iterator;
                for (Object object4 : this.f) {
                    object4.b(this);
                }
                return;
            }
        }
        catch (h h2) {
            JOptionPane.showMessageDialog(null, h2.getMessage());
        }
    }

    public final String o() {
        return this.i;
    }

    public final boolean p() {
        return this.j;
    }

    public final void a(boolean bl) {
        this.j = bl;
        for (Object object : this.f) {
            object.b(this);
        }
        if (bl) {
            for (Object object : this.d.a()) {
                ((d)object).a(true);
            }
        }
    }

    public final i q() {
        return this.k;
    }

    public final f r() {
        return this.l;
    }

    public final String s() {
        return this.p.b();
    }
}

