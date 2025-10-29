/*
 * AlgoBuild - Decompiled and Refactored
 *
 * Original location: b/a/J.java
 * Description: JSON library component
 *
 * NOTE: Internal method/variable names (a, b, c, etc.) are kept from decompiled code.
 *       Class names and package structure have been refactored for readability.
 */

package com.algobuild.json;

import b.a.a;
import b.a.b;
import b.a.c;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public final class f {
    private long a;
    private boolean b;
    private long c;
    private long d;
    private char e;
    private Reader f;
    private boolean g;

    public f(Reader reader) {
        this.f = reader.markSupported() ? reader : new BufferedReader(reader);
        this.b = false;
        this.g = false;
        this.e = '\u0000';
        this.c = 0L;
        this.a = 1L;
        this.d = 1L;
    }

    public final void a() {
        if (this.g || this.c <= 0L) {
            throw new b("Stepping back two steps is not supported");
        }
        --this.c;
        --this.a;
        this.g = true;
        this.b = false;
    }

    private char d() {
        int n2;
        if (this.g) {
            this.g = false;
            n2 = this.e;
        } else {
            try {
                n2 = this.f.read();
            }
            catch (IOException iOException) {
                throw new b(iOException);
            }
            if (n2 <= 0) {
                this.b = true;
                n2 = 0;
            }
        }
        ++this.c;
        if (this.e == '\r') {
            ++this.d;
            this.a = n2 == 10 ? 0 : 1;
        } else if (n2 == 10) {
            ++this.d;
            this.a = 0L;
        } else {
            ++this.a;
        }
        this.e = (char)n2;
        return this.e;
    }

    private String a(int n2) {
        char[] cArray = new char[4];
        int n3 = 0;
        while (n3 < 4) {
            cArray[n3] = this.d();
            f f2 = this;
            if (f2.b && !f2.g) {
                throw this.a("Substring bounds error");
            }
            ++n3;
        }
        return new String(cArray);
    }

    public final char b() {
        char c2;
        while ((c2 = this.d()) != '\u0000' && c2 <= ' ') {
        }
        return c2;
    }

    public final Object c() {
        char c2 = this.b();
        switch (c2) {
            case '\"': 
            case '\'': {
                char c3 = c2;
                f f2 = this;
                StringBuilder stringBuilder = new StringBuilder();
                block18: while (true) {
                    char c4 = f2.d();
                    switch (c4) {
                        case '\u0000': 
                        case '\n': 
                        case '\r': {
                            throw f2.a("Unterminated string");
                        }
                        case '\\': {
                            c4 = f2.d();
                            switch (c4) {
                                case 'b': {
                                    stringBuilder.append('\b');
                                    continue block18;
                                }
                                case 't': {
                                    stringBuilder.append('\t');
                                    continue block18;
                                }
                                case 'n': {
                                    stringBuilder.append('\n');
                                    continue block18;
                                }
                                case 'f': {
                                    stringBuilder.append('\f');
                                    continue block18;
                                }
                                case 'r': {
                                    stringBuilder.append('\r');
                                    continue block18;
                                }
                                case 'u': {
                                    stringBuilder.append((char)Integer.parseInt(f2.a(4), 16));
                                    continue block18;
                                }
                                case '\"': 
                                case '\'': 
                                case '/': 
                                case '\\': {
                                    stringBuilder.append(c4);
                                    continue block18;
                                }
                            }
                            throw f2.a("Illegal escape.");
                        }
                    }
                    if (c4 == c3) {
                        return stringBuilder.toString();
                    }
                    stringBuilder.append(c4);
                }
            }
            case '{': {
                this.a();
                return new c(this);
            }
            case '[': {
                this.a();
                return new a(this);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (c2 >= ' ' && ",:]}/\\\"[{;=#".indexOf(c2) < 0) {
            stringBuilder.append(c2);
            c2 = this.d();
        }
        this.a();
        String string = stringBuilder.toString().trim();
        if ("".equals(string)) {
            throw this.a("Missing value");
        }
        return b.a.c.h(string);
    }

    public final b a(String string) {
        return new b(String.valueOf(string) + this.toString());
    }

    public final String toString() {
        return " at " + this.c + " [character " + this.a + " line " + this.d + "]";
    }
}

