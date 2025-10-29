/*
 * Decompiled with CFR 0.152.
 */
package a.c.b;

import a.c.a.d;
import a.c.b.n;
import a.c.b.p;
import b.a.a;
import b.a.c;
import c.f;
import c.g;
import c.l;
import c.m;
import java.util.Vector;

public class b
extends n {
    String b;
    Vector c;

    public b(String string) {
        this.b = string;
        this.c = new Vector();
    }

    public b(String string, Vector vector) {
        this.b = string;
        this.c = vector;
    }

    public b() {
        this(null);
    }

    public final String j() {
        return this.b;
    }

    public final void a(String string) {
        this.b = string;
        this.a(true);
    }

    public final Vector k() {
        return this.c;
    }

    private void b(String string) {
        if (!this.c.contains(string)) {
            this.c.add(string);
            this.a(true);
        }
    }

    private String e(int n2) {
        return (String)this.c.get(n2);
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public int a(a.c.a.b var1_1, int var2_2) {
        block10: {
            block9: {
                if (var2_2 != 0) break block9;
                var2_3 = var1_1.a(this.b);
                if (var2_3 == null) break block10;
                var3_4 = var1_1.c();
                var1_1.f();
                var4_5 = var1_1.c();
                var5_6 = "";
                var6_7 = 0;
                if (true) ** GOTO lbl32
                do {
                    if ((var8_9 = (f)var3_4.get(var7_8 = (String)this.c.get(var6_7))) != null) {
                        var8_9 = var8_9.c();
                        if (var5_6.length() > 0) {
                            var5_6 = String.valueOf(var5_6) + ", ";
                        }
                        var5_6 = String.valueOf(var5_6) + var8_9.toString();
                        var4_5.put(var2_3.e(var6_7), var8_9);
                    } else {
                        try {
                            if (!var7_8.isEmpty()) {
                                var8_9 = var1_1.e().a((String)var7_8, var3_4);
                                if (var5_6.length() > 0) {
                                    var5_6 = String.valueOf(var5_6) + ", ";
                                }
                                var5_6 = String.valueOf(var5_6) + var8_9;
                                var4_5.put(var2_3.e(var6_7), new m((l)var8_9));
                            }
                        }
                        catch (g var8_10) {
                            var1_1.i("CALL PARAMETER " + (var6_7 + 1) + " ERROR: " + var8_10 + " IN " + (String)var7_8);
                            return -2;
                        }
                    }
                    ++var6_7;
lbl32:
                    // 2 sources

                    if (var6_7 >= this.c.size()) break;
                    var7_8 = var2_3;
                } while (var6_7 < var7_8.c.size());
                var1_1.d().push(new a.c.a.c(var2_3, var1_1));
                var7_8 = var2_3;
                var1_1.h("CALL: " + var7_8.b + "(" + var5_6 + ")");
                var1_1.l();
                return 1;
            }
            if (var2_2 == 1) {
                var1_1.m();
                var1_1.g();
                return -1;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "ABICall_Base [callName=" + this.b + ", actualParams=" + this.c + " orderInParent=" + this.n() + "]";
    }

    @Override
    protected final String g() {
        return "ABICAL";
    }

    @Override
    public a.f.g h() {
        a.f.g g2 = super.h();
        g2.a("callName", this.b);
        b b2 = this;
        int n2 = b2.c.size();
        if (n2 > 0) {
            String string = this.e(0);
            int n3 = 1;
            while (n3 < n2) {
                string = String.valueOf(string) + "\n" + this.e(n3);
                ++n3;
            }
            g2.a("actualParams", string);
        }
        return g2;
    }

    @Override
    public void a(a.f.g stringArray) {
        super.a((a.f.g)stringArray);
        String string = stringArray.a("callName");
        this.a(string);
        stringArray = stringArray.a("actualParams");
        if (stringArray != null) {
            this.c.removeAllElements();
            stringArray = stringArray.split("\\n");
            int n2 = 0;
            while (n2 < stringArray.length) {
                this.b(stringArray[n2]);
                ++n2;
            }
        }
    }

    @Override
    public c b(boolean bl) {
        c c2 = super.b(bl);
        c2.b("callName", this.b);
        b b2 = this;
        int n2 = b2.c.size();
        int n3 = 0;
        while (n3 < n2) {
            String string = this.e(n3).trim();
            if (!string.isEmpty()) {
                c2.a("actualParams", (Object)string);
            }
            ++n3;
        }
        return c2;
    }

    @Override
    public void a(c object, boolean bl) {
        super.a((c)object, bl);
        String string = ((c)object).f("callName");
        this.a(string);
        this.c.removeAllElements();
        object = ((c)object).d("actualParams");
        if (object != null) {
            int n2 = 0;
            while (n2 < ((a)object).a()) {
                this.b(((a)object).d(n2));
                ++n2;
            }
        }
    }

    @Override
    public d e() {
        b b2 = new b(this.b, (Vector)this.c.clone());
        return b2;
    }

    @Override
    public final boolean b(int n2) {
        return n2 == 0;
    }

    @Override
    public final p i() {
        p p2 = new p(1, this.b.length());
        int n2 = this.c.size();
        int n3 = 0;
        while (n3 < n2) {
            p2.a(0, ((String)this.c.get(n3)).length());
            ++n3;
        }
        return p2;
    }
}

