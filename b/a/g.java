/*
 * Decompiled with CFR 0.152.
 */
package b.a;

import b.a.b;
import b.a.c;
import java.io.IOException;
import java.io.Writer;

public final class g {
    private boolean a = false;
    private char b = (char)105;
    private final c[] c = new c[200];
    private int d = 0;
    private Writer e;

    public g(Writer writer) {
        this.e = writer;
    }

    private g b(String string) {
        if (string == null) {
            throw new b("Null pointer");
        }
        if (this.b == 'o' || this.b == 'a') {
            try {
                if (this.a && this.b == 'a') {
                    this.e.write(44);
                }
                this.e.write(string);
            }
            catch (IOException iOException) {
                throw new b(iOException);
            }
            if (this.b == 'o') {
                this.b = (char)107;
            }
            this.a = true;
            return this;
        }
        throw new b("Value out of sequence.");
    }

    private g a(char c2, char c3) {
        if (this.b != 'k') {
            throw new b("Misplaced endObject.");
        }
        c3 = (char)107;
        g g2 = this;
        if (g2.d <= 0) {
            throw new b("Nesting error.");
        }
        char c4 = g2.c[g2.d - 1] == null ? (char)'a' : 'k';
        if (c4 != c3) {
            throw new b("Nesting error.");
        }
        --g2.d;
        g2.b = (char)(g2.d == 0 ? 100 : (g2.c[g2.d - 1] == null ? 97 : 107));
        try {
            this.e.write(125);
        }
        catch (IOException iOException) {
            throw new b(iOException);
        }
        this.a = true;
        return this;
    }

    public final g a() {
        return this.a('k', '}');
    }

    public final g a(String string) {
        if (string == null) {
            throw new b("Null key.");
        }
        if (this.b == 'k') {
            try {
                this.c[this.d - 1].c(string, Boolean.TRUE);
                if (this.a) {
                    this.e.write(44);
                }
                this.e.write(b.a.c.g(string));
                this.e.write(58);
                this.a = false;
                this.b = (char)111;
                return this;
            }
            catch (IOException iOException) {
                throw new b(iOException);
            }
        }
        throw new b("Misplaced key.");
    }

    public final g b() {
        if (this.b == 'i') {
            this.b = (char)111;
        }
        if (this.b == 'o' || this.b == 'a') {
            this.b("{");
            c c2 = new c();
            g g2 = this;
            if (g2.d >= 200) {
                throw new b("Nesting too deep.");
            }
            g2.c[g2.d] = c2;
            g2.b = (char)107;
            ++g2.d;
            this.a = false;
            return this;
        }
        throw new b("Misplaced object.");
    }

    public final g a(Object object) {
        return this.b(b.a.c.a(object));
    }
}

