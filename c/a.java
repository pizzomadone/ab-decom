/*
 * Decompiled with CFR 0.152.
 */
package c;

import c.b;
import c.c;
import c.d;
import c.e;
import c.f;
import c.g;
import c.h;
import c.i;
import c.j;
import c.k;
import c.l;
import c.m;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private String a = "";
    private int b = -1;
    private char c = '\u0000';
    private String d = "";
    private int e = -1;
    private int f = -1;
    private c g = c.c.a;
    private l h;
    private Map i;
    private static /* synthetic */ int[] j;
    private static /* synthetic */ int[] k;

    private l a(String object, int n2, int n3) {
        if (this.i.containsKey(object)) {
            f f2 = (f)this.i.get(object);
            if (f2 instanceof d && n3 < 0) {
                object = ((d)f2).a(n2);
                return object;
            }
            if (f2 instanceof e) {
                object = ((e)f2).a(n2, n3);
                return object;
            }
            throw new g(-1, this.a(), 105, (String)object);
        }
        throw new g(-1, this.a(), 106, (String)object);
    }

    public final l a(String object, Map map) {
        if (map != null) {
            this.i = map;
        }
        if (this.i == null) {
            this.i = new HashMap();
        }
        this.a = object;
        this.h = null;
        object = this;
        this.b = 0;
        ((a)object).c = ((a)object).b < ((a)object).a.length() ? ((a)object).a.charAt(((a)object).b) : (char)'\u0000';
        this.d();
        if (this.g == c.c.b && this.c == '\u0000') {
            throw new g(-1, this.a(), 4);
        }
        this.h = this.e();
        if (this.g != c.c.b || this.d.length() > 0) {
            if (this.g == c.c.b) {
                throw new g(-1, this.a(), 101, this.d);
            }
            throw new g(-1, this.a(), 5, this.d);
        }
        return this.h;
    }

    private int a() {
        return this.b - this.d.length() + 1;
    }

    private static boolean a(char c2) {
        return c2 == ' ' || c2 == '\t';
    }

    private static boolean b(char c2) {
        return "&|<>=+/*%^!,()[]".indexOf(c2) != -1;
    }

    private static boolean c(char c2) {
        return "ABCDEFGHIJKLMNOPQRSTUVWXYZ_".indexOf(c2 = Character.toUpperCase(c2)) != -1;
    }

    private static boolean d(char c2) {
        return "0123456789.".indexOf(c2) != -1;
    }

    private static boolean e(char c2) {
        return "0123456789".indexOf(c2) != -1;
    }

    private static boolean a(String string) {
        if ((string = string.toUpperCase()).equals("EULER")) {
            return false;
        }
        return !string.equals("PI");
    }

    private void b() {
        ++this.b;
        if (this.b < this.a.length()) {
            this.c = this.a.charAt(this.b);
            return;
        }
        this.c = '\u0000';
    }

    private char c() {
        char c2 = '\u0000';
        if (this.b + 1 < this.a.length()) {
            c2 = this.a.charAt(this.b + 1);
        }
        return c2;
    }

    private void d() {
        this.g = c.c.a;
        this.d = "";
        while (c.a.a(this.c)) {
            this.b();
        }
        if (this.c == '\u0000') {
            this.g = c.c.b;
            return;
        }
        if (this.c == '+') {
            this.g = c.c.b;
            this.d = String.valueOf(this.d) + this.c;
            this.b();
            return;
        }
        if (this.c == '-') {
            this.g = c.c.b;
            this.d = String.valueOf(this.d) + this.c;
            this.b();
            return;
        }
        if (this.c == '*') {
            this.g = c.c.b;
            this.d = String.valueOf(this.d) + this.c;
            this.b();
            return;
        }
        if (this.c == '/') {
            this.g = c.c.b;
            this.d = String.valueOf(this.d) + this.c;
            this.b();
            return;
        }
        if (this.c == '!') {
            this.g = c.c.b;
            this.d = String.valueOf(this.d) + this.c;
            this.b();
            if (this.c == '=') {
                this.d = String.valueOf(this.d) + this.c;
                this.b();
            }
            return;
        }
        if (this.c == '=') {
            this.g = c.c.b;
            this.d = String.valueOf(this.d) + this.c;
            this.b();
            if (this.c == '=') {
                this.d = String.valueOf(this.d) + this.c;
                this.b();
            }
            return;
        }
        if (this.c == '&') {
            this.g = c.c.b;
            this.d = String.valueOf(this.d) + this.c;
            this.b();
            if (this.c == '&') {
                this.d = String.valueOf(this.d) + this.c;
                this.b();
            }
            return;
        }
        if (this.c == '|') {
            this.g = c.c.b;
            this.d = String.valueOf(this.d) + this.c;
            this.b();
            if (this.c == '|') {
                this.d = String.valueOf(this.d) + this.c;
                this.b();
            }
            return;
        }
        if (this.c == '(' || this.c == ')') {
            this.g = c.c.b;
            this.d = String.valueOf(this.d) + this.c;
            this.b();
            return;
        }
        if (this.c == '[' || this.c == ']') {
            this.g = c.c.b;
            this.d = String.valueOf(this.d) + this.c;
            this.b();
            return;
        }
        if (c.a.b(this.c)) {
            this.g = c.c.b;
            while (c.a.b(this.c)) {
                this.d = String.valueOf(this.d) + this.c;
                this.b();
            }
            return;
        }
        if (this.c == '\"') {
            this.g = c.c.h;
            this.b();
            while (this.c != '\"' && this.c != '\u0000') {
                this.d = String.valueOf(this.d) + this.c;
                this.b();
                if (this.c != '\\') continue;
                this.b();
                if (this.c == 'n') {
                    this.d = String.valueOf(this.d) + '\n';
                    this.b();
                    continue;
                }
                if (this.c == '\u0000') continue;
                this.d = String.valueOf(this.d) + this.c;
                this.b();
            }
            if (this.c == '\"') {
                this.b();
                return;
            }
            this.g = c.c.m;
            return;
        }
        if (c.a.d(this.c)) {
            char c2;
            if (c.a.e(this.c)) {
                this.g = c.c.c;
                if (this.c == '0') {
                    this.g = c.c.d;
                    this.d = String.valueOf(this.d) + this.c;
                    this.b();
                    if (this.c == 'x' || this.c == 'X') {
                        this.g = c.c.e;
                        this.d = "";
                        this.b();
                    } else if (this.c == 'b' || this.c == 'B') {
                        this.g = c.c.f;
                        this.d = "";
                        this.b();
                    }
                }
            } else {
                this.g = c.c.g;
            }
            while ((this.g == c.c.c || this.g == c.c.g) && c.a.e(this.c) || this.g == c.c.d && "01234567".indexOf(c2 = this.c) != -1 || this.g == c.c.e && "0123456789abcdefABCDEF".indexOf(c2 = this.c) != -1 || this.g == c.c.f && "01".indexOf(c2 = this.c) != -1) {
                this.d = String.valueOf(this.d) + this.c;
                this.b();
            }
            while (c.a.d(this.c)) {
                this.g = c.c.g;
                this.d = String.valueOf(this.d) + this.c;
                this.b();
            }
            if (this.c == 'e' || this.c == 'E') {
                this.g = c.c.g;
                this.d = String.valueOf(this.d) + this.c;
                this.b();
                if (this.c == '+' || this.c == '-') {
                    this.d = String.valueOf(this.d) + this.c;
                    this.b();
                }
                while (c.a.e(this.c)) {
                    this.d = String.valueOf(this.d) + this.c;
                    this.b();
                }
            }
            return;
        }
        if (c.a.c(this.c)) {
            while (c.a.c(this.c) || c.a.e(this.c)) {
                this.d = String.valueOf(this.d) + this.c;
                this.b();
            }
            while (c.a.a(this.c)) {
                this.b();
            }
            if (this.c == '(') {
                this.g = c.c.j;
                return;
            }
            if (this.c == '[') {
                this.g = c.c.k;
                return;
            }
            this.g = c.c.i;
            return;
        }
        this.g = c.c.m;
        while (this.c != '\u0000') {
            this.d = String.valueOf(this.d) + this.c;
            this.b();
        }
        throw new g(-1, this.a(), 1, this.d);
    }

    /*
     * Unable to fully structure code
     */
    private l e() {
        block18: {
            block22: {
                block24: {
                    block23: {
                        block20: {
                            block21: {
                                block19: {
                                    block17: {
                                        if (this.g != c.c.i) break block17;
                                        while (c.a.a(this.c)) {
                                            this.b();
                                        }
                                        var1_1 = this.d;
                                        if (this.c == '=' && this.c() != '=') {
                                            this.d();
                                            this.d();
                                            var2_3 = this.f();
                                            if (c.a.a((String)var1_1)) {
                                                var5_5 = var2_3;
                                                var3_7 = var1_1;
                                                var1_1 = this;
                                                if (var1_1.i.containsKey(var3_7)) {
                                                    var6_10 = (f)var1_1.i.get(var3_7);
                                                    if (var6_10 instanceof m) {
                                                        ((m)var6_10).a(var5_5);
                                                    }
                                                } else {
                                                    var1_1.i.put(var3_7, new m(var5_5));
                                                }
                                            } else {
                                                throw new g(-1, this.a(), 220, (String)var1_1);
                                            }
                                            return var2_3;
                                        }
                                        break block18;
                                    }
                                    if (this.g != c.c.k) break block18;
                                    var1_2 = this.d;
                                    var2_4 = -1;
                                    var3_8 = -1;
                                    this.d();
                                    if (this.g != c.c.b || !this.d.equals("[")) ** GOTO lbl45
                                    this.d();
                                    var3_8 = -1;
                                    var4_12 = this.f();
                                    if (this.g != c.c.b || !this.d.equals("]")) {
                                        throw new g(-1, this.a(), 3);
                                    }
                                    if (!(var4_12 instanceof j)) break block19;
                                    var4_12 = (j)var4_12;
                                    var2_4 = (int)var4_12.b;
                                    if (true) ** GOTO lbl45
                                }
                                throw new g(-1, this.a(), 3);
                                do {
                                    this.b();
lbl45:
                                    // 3 sources

                                } while (c.a.a(this.c));
                                if (this.c != '[') break block20;
                                this.d();
                                this.d();
                                var4_12 = this.f();
                                if (this.g != c.c.b || !this.d.equals("]")) {
                                    throw new g(-1, this.a(), 3);
                                }
                                if (!(var4_12 instanceof j)) break block21;
                                var4_12 = (j)var4_12;
                                var3_8 = (int)var4_12.b;
                                if (true) ** GOTO lbl60
                            }
                            throw new g(-1, this.a(), 108);
                            do {
                                this.b();
lbl60:
                                // 2 sources

                            } while (c.a.a(this.c));
                        }
                        if (this.c != '=' || this.c() == '=') break block22;
                        this.d();
                        this.d();
                        var4_12 = this.f();
                        if (!c.a.a((String)var1_2)) break block23;
                        v0 = var2_4;
                        var2_4 = var3_8;
                        var6_11 = v0;
                        var5_6 = var4_12;
                        var3_9 = var1_2;
                        var1_2 = this;
                        if (!var1_2.i.containsKey(var3_9)) ** GOTO lbl82
                        var7_13 = (f)var1_2.i.get(var3_9);
                        if (var7_13 instanceof d) {
                            ((d)var7_13).a(var5_6, var6_11);
                        } else if (var7_13 instanceof e) {
                            ((e)var7_13).a(var5_6, var6_11, var2_4);
                        } else {
                            throw new g(-1, super.a(), 105, var3_9);
lbl82:
                            // 1 sources

                            if (var2_4 == -1) {
                                var7_14 = new d();
                                var7_14.a(var5_6, var6_11);
                                var1_2.i.put(var3_9, var7_14);
                            } else {
                                var7_15 = new e();
                                var7_15.a(var5_6, var6_11, var2_4);
                                var1_2.i.put(var3_9, var7_15);
                            }
                        }
                        break block24;
                    }
                    throw new g(-1, this.a(), 220, (String)var1_2);
                }
                return var4_12;
            }
            this.d = var1_2;
            this.e = var2_4;
            this.f = var3_8;
            this.g = c.c.l;
        }
        return this.f();
    }

    private l f() {
        Object object;
        Object object2 = this.g();
        while ((object = c.a.b(this.d)) == c.b.c || object == c.b.d || object == c.b.e || object == c.b.f || object == c.b.g || object == c.b.h) {
            this.d();
            l l2 = this.g();
            if (object == c.b.c || object == c.b.d) {
                h h2;
                l l3 = l2;
                l2 = object2;
                object2 = object;
                object = this;
                switch (c.a.o()[((Enum)object2).ordinal()]) {
                    case 3: {
                        boolean bl;
                        if (l2 instanceof h) {
                            object2 = (h)l2;
                            bl = ((h)object2).a;
                            if (!bl) {
                                h2 = new h(false);
                                break;
                            }
                            if (l3 instanceof h) {
                                object2 = (h)l3;
                                boolean bl2 = ((h)object2).a;
                                h2 = new h(bl2);
                                break;
                            }
                            throw new g(108, l3.toString());
                        }
                        throw new g(108, l2.toString());
                    }
                    case 4: {
                        boolean bl;
                        if (l2 instanceof h) {
                            object2 = (h)l2;
                            bl = ((h)object2).a;
                            if (bl) {
                                h2 = new h(true);
                                break;
                            }
                            if (l3 instanceof h) {
                                object2 = (h)l3;
                                boolean bl3 = ((h)object2).a;
                                h2 = new h(bl || bl3);
                                break;
                            }
                            throw new g(108, l3.toString());
                        }
                        throw new g(108, l2.toString());
                    }
                    default: {
                        throw new g(-1, super.a(), 104);
                    }
                }
                object2 = h2;
                continue;
            }
            object2 = this.a((b)((Object)object), (l)object2, l2);
        }
        return object2;
    }

    private l g() {
        l l2 = this.h();
        b b2 = c.a.b(this.d);
        while (b2 == c.b.i || b2 == c.b.j || b2 == c.b.k || b2 == c.b.l || b2 == c.b.m || b2 == c.b.n) {
            this.d();
            l2 = this.a(b2, l2, this.h());
            b2 = c.a.b(this.d);
        }
        return l2;
    }

    private l h() {
        l l2 = this.i();
        b b2 = c.a.b(this.d);
        while (b2 == c.b.o || b2 == c.b.p) {
            this.d();
            l2 = this.a(b2, l2, this.i());
            b2 = c.a.b(this.d);
        }
        return l2;
    }

    private l i() {
        l l2 = this.j();
        b b2 = c.a.b(this.d);
        while (b2 == c.b.r || b2 == c.b.s || b2 == c.b.t || b2 == c.b.u) {
            this.d();
            l2 = this.a(b2, l2, this.j());
            b2 = c.a.b(this.d);
        }
        return l2;
    }

    private l j() {
        l l2 = this.k();
        b b2 = c.a.b(this.d);
        while (b2 == c.b.v) {
            this.d();
            l2 = this.a(b2, l2, this.k());
            b2 = c.a.b(this.d);
        }
        return l2;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private l k() {
        void var2_14;
        void var1_3;
        void var2_12;
        a a2 = this;
        b b2 = c.a.b(a2.d);
        if (a2.g == c.c.b && b2 == c.b.q) {
            a2.d();
            l l2 = a2.l();
            if (!(l2 instanceof h)) throw new g(-1, a2.a(), 108);
            h h2 = new h(!((h)l2).a);
        } else if (a2.g == c.c.b && b2 == c.b.p) {
            a2.d();
            l l3 = a2.l();
            if (l3 instanceof j) {
                j j2 = new j(-((j)l3).b);
            } else {
                if (!(l3 instanceof i)) throw new g(-1, a2.a(), 108);
                i i2 = new i(-((i)l3).a);
            }
        } else {
            l l4 = a2.l();
        }
        void var2_13 = var2_12;
        b b3 = c.a.b(this.d);
        while (var1_3 == c.b.w) {
            this.d();
            l l5 = this.a((b)var1_3, (l)var2_14, new i(0.0));
            b b4 = c.a.b(this.d);
        }
        return var2_14;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private l l() {
        Object object;
        if (this.g == c.c.j) {
            object = this.d;
            this.d();
            return this.c((String)object);
        }
        if (this.g != c.c.k) return this.m();
        object = this.d;
        int n2 = -1;
        int n3 = -1;
        this.d();
        if (this.g == c.c.b) {
            l l2;
            if (this.d.equals("[")) {
                this.d();
                n3 = -1;
                l2 = this.f();
                if (this.g != c.c.b) throw new g(-1, this.a(), 3);
                if (!this.d.equals("]")) {
                    throw new g(-1, this.a(), 3);
                }
                if (!(l2 instanceof j)) throw new g(-1, this.a(), 108);
                l2 = (j)l2;
                n2 = (int)((j)l2).b;
            }
            while (c.a.a(this.c)) {
                this.b();
            }
            if (this.c == '[') {
                this.d();
                this.d();
                l2 = this.f();
                if (this.g != c.c.b) throw new g(-1, this.a(), 3);
                if (!this.d.equals("]")) {
                    throw new g(-1, this.a(), 3);
                }
                if (!(l2 instanceof j)) throw new g(-1, this.a(), 108);
                l2 = (j)l2;
                n3 = (int)((j)l2).b;
            }
        }
        object = this.a((String)object, n2, n3);
        this.d();
        return object;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private l m() {
        if (this.g == c.c.b && this.d.equals("(")) {
            this.d();
            l l2 = this.f();
            if (this.g != c.c.b || !this.d.equals(")")) {
                throw new g(-1, this.a(), 3);
            }
            this.d();
            return l2;
        }
        a a2 = this;
        switch (c.a.n()[a2.g.ordinal()]) {
            case 7: {
                Object object2 = new i(Double.parseDouble(a2.d));
                a2.d();
                return object2;
            }
            case 3: {
                Object object2 = new j(Integer.parseInt(a2.d));
                a2.d();
                return object2;
            }
            case 4: {
                Object object2 = new j(Integer.parseInt(a2.d, 8));
                a2.d();
                return object2;
            }
            case 5: {
                Object object2 = new j(Integer.parseInt(a2.d, 16));
                a2.d();
                return object2;
            }
            case 6: {
                Object object2 = new j(Integer.parseInt(a2.d, 2));
                a2.d();
                return object2;
            }
            case 8: {
                Object object2 = new k(a2.d);
                a2.d();
                return object2;
            }
            case 9: {
                Object object;
                String string = a2.d;
                Object object2 = a2;
                if (string.equals("EULER")) {
                    object = new i(Math.E);
                } else if (string.equals("PI")) {
                    object = new i(Math.PI);
                } else if (string.equals("INFINITY")) {
                    object = new i(Double.POSITIVE_INFINITY);
                } else if (string.equals("NaN")) {
                    object = new i(Double.NaN);
                } else if (string.equals("TRUE") || string.equals("true")) {
                    object = new h(true);
                } else if (string.equals("FALSE") || string.equals("false")) {
                    object = new h(false);
                } else {
                    if (!((a)object2).i.containsKey(string)) throw new g(-1, super.a(), 103, string);
                    f f2 = (f)((a)object2).i.get(string);
                    if (!(f2 instanceof m)) throw new g(-1, super.a(), 105, string);
                    object = object2 = ((m)f2).d();
                }
                object2 = object;
                a2.d();
                return object2;
            }
            case 12: {
                Object object2 = a2.a(a2.d, a2.e, a2.f);
                a2.d();
                return object2;
            }
            default: {
                if (a2.d.length() != 0) throw new g(-1, a2.a(), 7);
                throw new g(-1, a2.a(), 6);
            }
        }
    }

    private static b b(String string) {
        if (string.equals("&&")) {
            return c.b.c;
        }
        if (string.equals("||")) {
            return c.b.d;
        }
        if (string.equals("&")) {
            return c.b.e;
        }
        if (string.equals("|")) {
            return c.b.f;
        }
        if (string.equals("<<")) {
            return c.b.g;
        }
        if (string.equals(">>")) {
            return c.b.h;
        }
        if (string.equals("=")) {
            return c.b.b;
        }
        if (string.equals("==")) {
            return c.b.i;
        }
        if (string.equals("!=")) {
            return c.b.j;
        }
        if (string.equals("<")) {
            return c.b.k;
        }
        if (string.equals(">")) {
            return c.b.l;
        }
        if (string.equals("<=")) {
            return c.b.m;
        }
        if (string.equals(">=")) {
            return c.b.n;
        }
        if (string.equals("+")) {
            return c.b.o;
        }
        if (string.equals("-")) {
            return c.b.p;
        }
        if (string.equals("*")) {
            return c.b.r;
        }
        if (string.equals("/")) {
            return c.b.s;
        }
        if (string.equals("%")) {
            return c.b.t;
        }
        if (string.equals("^")) {
            return c.b.v;
        }
        if (string.equals("!")) {
            return c.b.q;
        }
        return c.b.a;
    }

    private l a(b object, l l2, l l3) {
        switch (c.a.o()[object.ordinal()]) {
            case 5: {
                if (l2 instanceof j && l3 instanceof j) {
                    object = (j)l2;
                    long l4 = ((j)object).b;
                    object = (j)l3;
                    long l5 = ((j)object).b;
                    return new j(l4 & l5);
                }
                if (!(l2 instanceof j)) {
                    throw new g(108, l2.toString());
                }
                throw new g(108, l3.toString());
            }
            case 6: {
                if (l2 instanceof j && l3 instanceof j) {
                    object = (j)l2;
                    long l6 = ((j)object).b;
                    object = (j)l3;
                    long l7 = ((j)object).b;
                    return new j(l6 | l7);
                }
                if (!(l2 instanceof j)) {
                    throw new g(108, l2.toString());
                }
                throw new g(108, l3.toString());
            }
            case 7: {
                if (l2 instanceof j && l3 instanceof j) {
                    object = (j)l2;
                    long l8 = ((j)object).b;
                    object = (j)l3;
                    long l9 = ((j)object).b;
                    return new j(l8 << (int)l9);
                }
                if (!(l2 instanceof j)) {
                    throw new g(108, l2.toString());
                }
                throw new g(108, l3.toString());
            }
            case 8: {
                if (l2 instanceof j && l3 instanceof j) {
                    object = (j)l2;
                    long l10 = ((j)object).b;
                    object = (j)l3;
                    long l11 = ((j)object).b;
                    return new j(l10 >> (int)l11);
                }
                if (!(l2 instanceof j)) {
                    throw new g(108, l2.toString());
                }
                throw new g(108, l3.toString());
            }
            case 9: {
                return new h(l2.a(l3));
            }
            case 10: {
                return new h(!l2.a(l3));
            }
            case 11: {
                return new h(l2.b(l3));
            }
            case 12: {
                return new h(l3.b(l2));
            }
            case 13: {
                return new h(l2.b(l3) || l2.a(l3));
            }
            case 14: {
                return new h(l3.b(l2) || l2.a(l3));
            }
            case 15: {
                if (l2 instanceof j && l3 instanceof j) {
                    object = (j)l2;
                    long l12 = ((j)object).b;
                    object = (j)l3;
                    long l13 = ((j)object).b;
                    return new j(l12 + l13);
                }
                if (l2 instanceof i && l3 instanceof i) {
                    object = (i)l2;
                    double d2 = ((i)object).a;
                    object = (i)l3;
                    double d3 = ((i)object).a;
                    return new i(d2 + d3);
                }
                if (l2 instanceof k && l3 instanceof k) {
                    object = (k)l2;
                    String string = ((k)object).a;
                    object = (k)l3;
                    String string2 = ((k)object).a;
                    return new k(String.valueOf(string) + string2);
                }
                throw new g(108, String.valueOf(l2.toString()) + " OR " + l3.toString());
            }
            case 16: {
                if (l2 instanceof j && l3 instanceof j) {
                    object = (j)l2;
                    long l14 = ((j)object).b;
                    object = (j)l3;
                    long l15 = ((j)object).b;
                    return new j(l14 - l15);
                }
                if (l2 instanceof i || l3 instanceof i) {
                    object = (i)l2;
                    double d4 = ((i)object).a;
                    object = (i)l3;
                    double d5 = ((i)object).a;
                    return new i(d4 - d5);
                }
                throw new g(108, String.valueOf(l2.toString()) + " OR " + l3.toString());
            }
            case 18: {
                if (l2 instanceof j && l3 instanceof j) {
                    object = (j)l2;
                    long l16 = ((j)object).b;
                    object = (j)l3;
                    long l17 = ((j)object).b;
                    return new j(l16 * l17);
                }
                if (l2 instanceof i || l3 instanceof i) {
                    object = (i)l2;
                    double d6 = ((i)object).a;
                    object = (i)l3;
                    double d7 = ((i)object).a;
                    return new i(d6 * d7);
                }
                throw new g(108, String.valueOf(l2.toString()) + " OR " + l3.toString());
            }
            case 19: {
                if (l2 instanceof j && l3 instanceof j) {
                    object = (j)l2;
                    long l18 = ((j)object).b;
                    object = (j)l3;
                    long l19 = ((j)object).b;
                    return new j(l18 / l19);
                }
                if (l2 instanceof i || l3 instanceof i) {
                    object = (i)l2;
                    double d8 = ((i)object).a;
                    object = (i)l3;
                    double d9 = ((i)object).a;
                    return new i(d8 / d9);
                }
                throw new g(108, String.valueOf(l2.toString()) + " OR " + l3.toString());
            }
            case 20: {
                if (l2 instanceof j && l3 instanceof j) {
                    object = (j)l2;
                    long l20 = ((j)object).b;
                    object = (j)l3;
                    long l21 = ((j)object).b;
                    return new j(l20 % l21);
                }
                if (l2 instanceof i && l3 instanceof i) {
                    object = (i)l2;
                    double d10 = ((i)object).a;
                    object = (i)l3;
                    double d11 = ((i)object).a;
                    double d12 = Math.floor(d10);
                    double d13 = Math.floor(d11);
                    if (d10 == d12 && d11 == d13) {
                        return new j(Math.round(d10) % Math.round(d11));
                    }
                    throw new g(108, l3.toString());
                }
                throw new g(108, l2.toString());
            }
            case 21: {
                if (l2 instanceof j && l3 instanceof j) {
                    object = (j)l2;
                    long l22 = ((j)object).b;
                    object = (j)l3;
                    long l23 = ((j)object).b;
                    return new j(l22 ^ l23);
                }
                if (!(l2 instanceof j)) {
                    throw new g(108, l2.toString());
                }
                throw new g(108, l3.toString());
            }
            case 22: {
                if (l2 instanceof j && l3 instanceof j) {
                    object = (j)l2;
                    long l24 = ((j)object).b;
                    object = (j)l3;
                    long l25 = ((j)object).b;
                    return new j(l24 ^ l25);
                }
                if (l2 instanceof i || l3 instanceof i) {
                    object = (i)l2;
                    double d14 = ((i)object).a;
                    object = (i)l3;
                    double d15 = ((i)object).a;
                    return new i(Math.pow(d14, d15));
                }
                throw new g(108, String.valueOf(l2.toString()) + " OR " + l2.toString());
            }
            case 23: {
                if (l2 instanceof i) {
                    object = (i)l2;
                    double d16 = ((i)object).a;
                    return new i(c.a.a(d16));
                }
                throw new g(108, l2.toString());
            }
        }
        throw new g(-1, this.a(), 104);
    }

    private l c(String object) {
        l l2;
        Object object2 = object;
        if (((String)object2).equals("abs")) {
            l l3 = this.m();
            if (l3 instanceof i) {
                object2 = (i)l3;
                double d2 = ((i)object2).a;
                return new i(Math.abs(d2));
            }
            throw new g(108, l3.toString());
        }
        if (((String)object2).equals("ceil")) {
            l l4 = this.m();
            if (l4 instanceof i) {
                object2 = (i)l4;
                double d3 = ((i)object2).a;
                return new i(Math.ceil(d3));
            }
            throw new g(108, l4.toString());
        }
        if (((String)object2).equals("floor")) {
            l l5 = this.m();
            if (l5 instanceof i) {
                object2 = (i)l5;
                double d4 = ((i)object2).a;
                return new i(Math.floor(d4));
            }
            throw new g(108, l5.toString());
        }
        if (((String)object2).equals("round")) {
            l l6 = this.m();
            if (l6 instanceof i) {
                object2 = (i)l6;
                double d5 = ((i)object2).a;
                return new i(Math.round(d5));
            }
            throw new g(108, l6.toString());
        }
        if (((String)object2).equals("exp")) {
            l l7 = this.m();
            if (l7 instanceof i) {
                object2 = (i)l7;
                double d6 = ((i)object2).a;
                return new i(Math.exp(d6));
            }
            throw new g(108, l7.toString());
        }
        if (((String)object2).equals("sqrt")) {
            l l8 = this.m();
            if (l8 instanceof i) {
                object2 = (i)l8;
                double d7 = ((i)object2).a;
                return new i(Math.sqrt(d7));
            }
            throw new g(108, l8.toString());
        }
        if (((String)object2).equals("ln")) {
            l l9 = this.m();
            if (l9 instanceof i) {
                object2 = (i)l9;
                double d8 = ((i)object2).a;
                return new i(Math.log(d8));
            }
            throw new g(108, l9.toString());
        }
        if (((String)object2).equals("log10")) {
            l l10 = this.m();
            if (l10 instanceof i) {
                object2 = (i)l10;
                double d9 = ((i)object2).a;
                return new i(Math.log10(d9));
            }
            throw new g(108, l10.toString());
        }
        if (((String)object2).equals("sin")) {
            l l11 = this.m();
            if (l11 instanceof i) {
                object2 = (i)l11;
                double d10 = ((i)object2).a;
                return new i(Math.sin(d10));
            }
            throw new g(108, l11.toString());
        }
        if (((String)object2).equals("cos")) {
            l l12 = this.m();
            if (l12 instanceof i) {
                object2 = (i)l12;
                double d11 = ((i)object2).a;
                return new i(Math.cos(d11));
            }
            throw new g(108, l12.toString());
        }
        if (((String)object2).equals("tan")) {
            l l13 = this.m();
            if (l13 instanceof i) {
                object2 = (i)l13;
                double d12 = ((i)object2).a;
                return new i(Math.tan(d12));
            }
            throw new g(108, l13.toString());
        }
        if (((String)object2).equals("cotan")) {
            l l14 = this.m();
            if (l14 instanceof i) {
                object2 = (i)l14;
                double d13 = ((i)object2).a;
                return new i(1.0 / Math.tan(d13));
            }
            throw new g(108, l14.toString());
        }
        if (((String)object2).equals("asin")) {
            l l15 = this.m();
            if (l15 instanceof i) {
                object2 = (i)l15;
                double d14 = ((i)object2).a;
                return new i(Math.asin(d14));
            }
            throw new g(108, l15.toString());
        }
        if (((String)object2).equals("acos")) {
            l l16 = this.m();
            if (l16 instanceof i) {
                object2 = (i)l16;
                double d15 = ((i)object2).a;
                return new i(Math.acos(d15));
            }
            throw new g(108, l16.toString());
        }
        if (((String)object2).equals("atan")) {
            l l17 = this.m();
            if (l17 instanceof i) {
                object2 = (i)l17;
                double d16 = ((i)object2).a;
                return new i(Math.atan(d16));
            }
            throw new g(108, l17.toString());
        }
        if (((String)object2).equals("acotan")) {
            l l18 = this.m();
            if (l18 instanceof i) {
                object2 = (i)l18;
                double d17 = ((i)object2).a;
                return new i(1.5707963267948966 - Math.atan(d17));
            }
            throw new g(108, l18.toString());
        }
        if (((String)object2).equals("sinh")) {
            l l19 = this.m();
            if (l19 instanceof i) {
                object2 = (i)l19;
                double d18 = ((i)object2).a;
                return new i(Math.sinh(d18));
            }
            throw new g(108, l19.toString());
        }
        if (((String)object2).equals("cosh")) {
            l l20 = this.m();
            if (l20 instanceof i) {
                object2 = (i)l20;
                double d19 = ((i)object2).a;
                return new i(Math.cosh(d19));
            }
            throw new g(108, l20.toString());
        }
        if (((String)object2).equals("tanh")) {
            l l21 = this.m();
            if (l21 instanceof i) {
                object2 = (i)l21;
                double d20 = ((i)object2).a;
                return new i(Math.tanh(d20));
            }
            throw new g(108, l21.toString());
        }
        if (((String)object2).equals("random")) {
            object = this;
            if (((a)object).g == c.c.b && ((a)object).d.equals("(")) {
                super.d();
                if (((a)object).g != c.c.b || !((a)object).d.equals(")")) {
                    throw new g(-1, super.a(), 3);
                }
                super.d();
            }
            return new i(Math.random());
        }
        if (((String)object2).equals("strlen")) {
            l l22 = this.m();
            if (l22 instanceof k) {
                return new j(((k)l22).a.length());
            }
            throw new g(-1, this.a(), 108, l22.toString());
        }
        if (((String)object2).equals("strchar")) {
            l[] lArray = this.a(2);
            if (lArray[0] instanceof k && lArray[1] instanceof j) {
                object2 = (k)lArray[0];
                String string = ((k)object2).a;
                object2 = (j)lArray[1];
                int n2 = (int)((j)object2).b;
                return new k(string.substring(n2, n2 + 1));
            }
            if (lArray[0] != null && lArray[1] != null) {
                throw new g(-1, this.a(), 108, String.valueOf(lArray[0].toString()) + "," + lArray[1].toString());
            }
            throw new g(-1, this.a(), 110);
        }
        if (((String)object2).equals("substr")) {
            l[] lArray = this.a(3);
            if (lArray[0] instanceof k && lArray[1] instanceof j && lArray[2] instanceof j) {
                object2 = (k)lArray[0];
                String string = ((k)object2).a;
                object2 = (j)lArray[1];
                int n3 = (int)((j)object2).b;
                object2 = (j)lArray[2];
                int n4 = (int)((j)object2).b;
                return new k(string.substring(n3, n4));
            }
            if (lArray[0] != null && lArray[1] != null && lArray[2] != null) {
                throw new g(-1, this.a(), 108, String.valueOf(lArray[0].toString()) + "," + lArray[1].toString() + "," + lArray[2].toString());
            }
            throw new g(-1, this.a(), 110);
        }
        if (((String)object2).equals("strpos")) {
            l[] lArray = this.a(2);
            if (lArray[0] instanceof k && lArray[1] instanceof k) {
                object2 = (k)lArray[0];
                String string = ((k)object2).a;
                object2 = (k)lArray[1];
                String string2 = ((k)object2).a;
                return new j(string.indexOf(string2));
            }
            if (lArray[0] != null && lArray[1] != null) {
                throw new g(-1, this.a(), 108, String.valueOf(lArray[0].toString()) + "," + lArray[1].toString());
            }
            throw new g(-1, this.a(), 110);
        }
        if (((String)object2).equals("strupr")) {
            l l23 = this.m();
            if (l23 instanceof k) {
                object2 = (k)l23;
                String string = ((k)object2).a;
                return new k(string.toUpperCase());
            }
            throw new g(-1, this.a(), 108, l23.toString());
        }
        if (((String)object2).equals("strlwr")) {
            l l24 = this.m();
            if (l24 instanceof k) {
                object2 = (k)l24;
                String string = ((k)object2).a;
                return new k(string.toLowerCase());
            }
            throw new g(-1, this.a(), 108, l24.toString());
        }
        if (((String)object2).equals("trim")) {
            l l25 = this.m();
            if (l25 instanceof k) {
                object2 = (k)l25;
                String string = ((k)object2).a;
                return new k(string.trim());
            }
            throw new g(-1, this.a(), 108, l25.toString());
        }
        if (((String)object2).equals("ctoi")) {
            l l26 = this.m();
            if (l26 instanceof k) {
                object2 = (k)l26;
                String string = ((k)object2).a;
                if (string.length() > 0) {
                    return new j(string.charAt(0));
                }
                throw new g(-1, this.a(), 10);
            }
            throw new g(-1, this.a(), 108, l26.toString());
        }
        if (((String)object2).equals("itoc")) {
            l l27 = this.m();
            if (l27 instanceof j) {
                object2 = (j)l27;
                int n5 = (int)((j)object2).b;
                return new k((char)n5);
            }
            throw new g(-1, this.a(), 108, l27.toString());
        }
        if (((String)object2).equals("stoi")) {
            l l28 = this.m();
            if (l28 instanceof k) {
                object2 = (k)l28;
                String string = ((k)object2).a.trim();
                try {
                    return new j(Long.parseLong(string));
                }
                catch (NumberFormatException numberFormatException) {
                    throw new g(-1, this.a(), 108, string);
                }
            }
            throw new g(-1, this.a(), 10, l28.toString());
        }
        if (((String)object2).equals("itos")) {
            l l29 = this.m();
            if (l29 instanceof j) {
                object2 = (j)l29;
                long l30 = ((j)object2).b;
                return new k(Long.toString(l30));
            }
            throw new g(-1, this.a(), 108, l29.toString());
        }
        if (((String)object2).equals("sbasetoi")) {
            l[] lArray = this.a(2);
            if (lArray[0] instanceof k && lArray[1] instanceof j) {
                object2 = (k)lArray[0];
                String string = ((k)object2).a;
                object2 = (j)lArray[1];
                int n6 = (int)((j)object2).b;
                try {
                    return new j(Long.parseLong(string, n6));
                }
                catch (NumberFormatException numberFormatException) {
                    throw new g(-1, this.a(), 108, string);
                }
            }
            if (lArray[0] != null && lArray[1] != null) {
                throw new g(-1, this.a(), 108, String.valueOf(lArray[0].toString()) + "," + lArray[1].toString());
            }
            throw new g(-1, this.a(), 110);
        }
        if (((String)object2).equals("ibasetos")) {
            l[] lArray = this.a(2);
            if (lArray[0] instanceof j && lArray[1] instanceof j) {
                object2 = (j)lArray[0];
                long l31 = ((j)object2).b;
                object2 = (j)lArray[1];
                int n7 = (int)((j)object2).b;
                return new k(Long.toString(l31, n7));
            }
            if (lArray[0] != null && lArray[1] != null) {
                throw new g(-1, this.a(), 108, String.valueOf(lArray[0].toString()) + "," + lArray[1].toString());
            }
            throw new g(-1, this.a(), 110);
        }
        if (((String)object2).equals("iformats")) {
            l[] lArray = this.a(2);
            if (lArray[0] instanceof j && lArray[1] instanceof j) {
                object2 = (j)lArray[0];
                long l32 = ((j)object2).b;
                object2 = (j)lArray[1];
                int n8 = (int)((j)object2).b;
                object2 = Long.toString(l32);
                if (((String)object2).length() < n8) {
                    StringBuilder stringBuilder = new StringBuilder(n8);
                    int n9 = ((String)object2).length();
                    while (n9 < n8) {
                        stringBuilder.append(' ');
                        ++n9;
                    }
                    stringBuilder.append((String)object2);
                    return new k(stringBuilder.toString());
                }
                return new k((String)object2);
            }
            if (lArray[0] != null && lArray[1] != null) {
                throw new g(-1, this.a(), 108, String.valueOf(lArray[0].toString()) + "," + lArray[1].toString());
            }
            throw new g(-1, this.a(), 110);
        }
        if (((String)object2).equals("dformats")) {
            Object object3 = this.a(3);
            if (object3[0] instanceof i && object3[1] instanceof j && object3[2] instanceof j) {
                object2 = (i)object3[0];
                double d21 = ((i)object2).a;
                object2 = (j)object3[1];
                int n10 = (int)((j)object2).b;
                object2 = (j)object3[2];
                int n11 = (int)((j)object2).b;
                double d22 = Math.pow(10.0, n11);
                if (n11 <= 0) {
                    d22 = 1.0;
                }
                System.out.println("v prima " + d21);
                d21 = (double)Math.round(d21 * d22) / d22;
                System.out.println("v dopo " + d21);
                object3 = Double.toString(d21);
                int n12 = ((String)object3).indexOf(46) + 1;
                n12 = ((String)object3).length() - n12;
                StringBuilder stringBuilder = new StringBuilder(n10);
                int n13 = ((String)object3).length();
                while (n13 < n10 - n11 + n12) {
                    stringBuilder.append(' ');
                    ++n13;
                }
                stringBuilder.append((String)object3);
                while (n12 < n11) {
                    stringBuilder.append('0');
                    ++n12;
                }
                return new k(stringBuilder.toString());
            }
            if (object3[0] != null && object3[1] != null && object3[2] != null) {
                throw new g(-1, this.a(), 108, object3[0] + "," + object3[1] + "," + object3[1]);
            }
            throw new g(-1, this.a(), 110);
        }
        if (((String)object2).equals("stod") && (l2 = this.m()) instanceof k) {
            object2 = (k)l2;
            String string = ((k)object2).a;
            try {
                return new i(Double.parseDouble(string));
            }
            catch (NumberFormatException numberFormatException) {
                throw new g(-1, this.a(), 108, string);
            }
        }
        if (((String)object2).equals("dtos")) {
            l2 = this.m();
            if (l2 instanceof i) {
                object2 = (i)l2;
                double d23 = ((i)object2).a;
                return new k(Double.toString(d23));
            }
            throw new g(-1, this.a(), 108, l2.toString());
        }
        if (((String)object2).equals("dtoi")) {
            l2 = this.m();
            if (l2 instanceof i) {
                object2 = (i)l2;
                double d24 = ((i)object2).a;
                return new j((int)d24);
            }
            throw new g(-1, this.a(), 108, l2.toString());
        }
        if (((String)object2).equals("type")) {
            l2 = this.m();
            return new k(l2.b());
        }
        throw new g(-1, this.a(), 102, (String)object);
    }

    private l[] a(int n2) {
        if (this.g == c.c.b && this.d.equals("(")) {
            l[] lArray = new l[n2];
            int n3 = 0;
            boolean bl = false;
            while (!bl) {
                this.d();
                lArray[n3] = this.f();
                ++n3;
                if (this.g != c.c.b || !this.d.equals(")") && !this.d.equals(",")) {
                    throw new g(-1, this.a(), 3);
                }
                if (this.d.equals(")")) {
                    bl = true;
                }
                if (!this.d.equals(",") || n3 < n2) continue;
                throw new g(-1, this.a(), 111, "TOO MANY ARGUMENTS");
            }
            this.d();
            return lArray;
        }
        return null;
    }

    private static double a(double d2) {
        int n2 = (int)d2;
        if (d2 != (double)n2) {
            throw new g(400, "factorial");
        }
        double d3 = n2;
        --n2;
        while (n2 > 1) {
            d3 *= (double)n2;
            --n2;
        }
        if (d3 == 0.0) {
            d3 = 1.0;
        }
        return d3;
    }

    private static /* synthetic */ int[] n() {
        if (j != null) {
            return j;
        }
        int[] nArray = new int[c.c.a().length];
        try {
            nArray[c.c.k.ordinal()] = 11;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[c.c.l.ordinal()] = 12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[c.c.f.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[c.c.b.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[c.c.g.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[c.c.j.ordinal()] = 10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[c.c.e.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[c.c.c.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[c.c.a.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[c.c.d.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[c.c.h.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[c.c.m.ordinal()] = 13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[c.c.i.ordinal()] = 9;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        j = nArray;
        return nArray;
    }

    private static /* synthetic */ int[] o() {
        if (k != null) {
            return k;
        }
        int[] nArray = new int[c.b.a().length];
        try {
            nArray[c.b.c.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[c.b.b.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[c.b.e.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[c.b.f.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[c.b.g.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[c.b.h.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[c.b.s.ordinal()] = 19;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[c.b.i.ordinal()] = 9;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[c.b.w.ordinal()] = 23;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[c.b.l.ordinal()] = 12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[c.b.n.ordinal()] = 14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[c.b.p.ordinal()] = 16;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[c.b.t.ordinal()] = 20;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[c.b.r.ordinal()] = 18;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[c.b.q.ordinal()] = 17;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[c.b.d.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[c.b.o.ordinal()] = 15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[c.b.v.ordinal()] = 22;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[c.b.k.ordinal()] = 11;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[c.b.m.ordinal()] = 13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[c.b.j.ordinal()] = 10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[c.b.a.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[c.b.u.ordinal()] = 21;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        k = nArray;
        return nArray;
    }
}

