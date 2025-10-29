/*
 * Decompiled with CFR 0.152.
 */
package a.c.a;

import a.c.a.h;
import b.a.a;
import b.a.c;
import java.text.SimpleDateFormat;
import java.util.Vector;

public final class g {
    private Vector a = null;
    private h b = null;

    g() {
    }

    public final c a() {
        c c2 = new c();
        if (this.a != null) {
            for (h h2 : this.a) {
                c2.a("saveHistoryItems", h2.a());
            }
        }
        if (this.b != null) {
            c2.a("saveHistoryItems", this.b.a());
        }
        return c2;
    }

    public final void a(String string, String string2, String string3, String string4) {
        this.b = new h(this, string, string2, System.currentTimeMillis(), string3, string4);
    }

    public final void a(c object) {
        if ((object = ((c)object).d("saveHistoryItems")) != null) {
            int n2 = ((a)object).a();
            this.a = new Vector(n2);
            this.b = null;
            n2 = 0;
            while (n2 < ((a)object).a()) {
                c c2 = ((a)object).c(n2);
                h h2 = new h(this);
                h2.a(c2);
                this.a.add(h2);
                ++n2;
            }
        }
    }

    public final String toString() {
        return "ABESaveHistory [saveHistory=" + this.a + ", actualSessionSave=" + this.b + "]";
    }

    public final String b() {
        String string = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
        if (this.b != null) {
            string = String.valueOf(this.b.b()) + "\n\n";
        }
        if (this.a != null && this.a.size() > 0) {
            if (string == null) {
                string = "";
            }
            int n2 = this.a.size() - 1;
            while (n2 >= 0) {
                h h2 = (h)this.a.get(n2);
                string = String.valueOf(string) + h2.b() + "\n";
                --n2;
            }
        }
        if (string == null) {
            string = a.i.c.a("mnuHistoryIsEmpty");
        }
        return string;
    }

    public final void c() {
        this.a = null;
        this.b = null;
    }
}

