/*
 * Decompiled with CFR 0.152.
 */
package b.a;

import b.a.b;
import b.a.c;
import b.a.f;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class a
implements Iterable {
    private final ArrayList a = new ArrayList();

    public a() {
    }

    public a(f f2) {
        this();
        if (f2.b() != '[') {
            throw f2.a("A JSONArray text must start with '['");
        }
        if (f2.b() != ']') {
            f2.a();
            block4: while (true) {
                if (f2.b() == ',') {
                    f2.a();
                    this.a.add(c.a);
                } else {
                    f2.a();
                    this.a.add(f2.c());
                }
                switch (f2.b()) {
                    case ',': {
                        if (f2.b() == ']') {
                            return;
                        }
                        f2.a();
                        continue block4;
                    }
                    case ']': {
                        return;
                    }
                }
                break;
            }
            throw f2.a("Expected a ',' or ']'");
        }
    }

    public a(Collection object) {
        if (object != null) {
            object = object.iterator();
            while (object.hasNext()) {
                this.a.add(c.b(object.next()));
            }
        }
    }

    public a(Object object) {
        this();
        if (object.getClass().isArray()) {
            int n2 = Array.getLength(object);
            int n3 = 0;
            while (n3 < n2) {
                this.a(c.b(Array.get(object, n3)));
                ++n3;
            }
            return;
        }
        throw new b("JSONArray initial value should be a string or collection or array.");
    }

    public final Iterator iterator() {
        return this.a.iterator();
    }

    /*
     * Unable to fully structure code
     */
    public final Object a(int var1_1) {
        var3_2 = var1_1;
        var2_3 = this;
        if (var3_2 < 0) ** GOTO lbl-1000
        var4_4 = var2_3;
        if (var3_2 >= var4_4.a.size()) lbl-1000:
        // 2 sources

        {
            v0 = null;
        } else {
            v0 = var2_3 = (a)var2_3.a.get(var3_2);
        }
        if (v0 == null) {
            throw new b("JSONArray[" + var1_1 + "] not found.");
        }
        return var2_3;
    }

    public final int b(int n2) {
        Object object = this.a(n2);
        try {
            if (object instanceof Number) {
                return ((Number)object).intValue();
            }
            return Integer.parseInt((String)object);
        }
        catch (Exception exception) {
            throw new b("JSONArray[" + n2 + "] is not a number.");
        }
    }

    public final c c(int n2) {
        Object object = this.a(n2);
        if (object instanceof c) {
            return (c)object;
        }
        throw new b("JSONArray[" + n2 + "] is not a JSONObject.");
    }

    public final String d(int n2) {
        Object object = this.a(n2);
        if (object instanceof String) {
            return (String)object;
        }
        throw new b("JSONArray[" + n2 + "] not a string.");
    }

    public final int a() {
        return this.a.size();
    }

    public final a e(int n2) {
        this.a(new Integer(n2));
        return this;
    }

    public final a a(Object object) {
        this.a.add(object);
        return this;
    }

    public final String toString() {
        try {
            return this.f(0);
        }
        catch (Exception exception) {
            return null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private String f(int n2) {
        StringWriter stringWriter = new StringWriter();
        StringBuffer stringBuffer = stringWriter.getBuffer();
        synchronized (stringBuffer) {
            return this.a(stringWriter, 0, 0).toString();
        }
    }

    final Writer a(Writer writer, int n2, int n3) {
        try {
            boolean bl = false;
            a a2 = this;
            int n4 = a2.a.size();
            writer.write(91);
            if (n4 == 1) {
                c.a(writer, this.a.get(0), n2, n3);
            } else if (n4 != 0) {
                int n5 = n3 + n2;
                int n6 = 0;
                while (n6 < n4) {
                    if (bl) {
                        writer.write(44);
                    }
                    if (n2 > 0) {
                        writer.write(10);
                    }
                    c.a(writer, n5);
                    c.a(writer, this.a.get(n6), n2, n5);
                    bl = true;
                    ++n6;
                }
                if (n2 > 0) {
                    writer.write(10);
                }
                c.a(writer, n3);
            }
            writer.write(93);
            return writer;
        }
        catch (IOException iOException) {
            throw new b(iOException);
        }
    }
}

