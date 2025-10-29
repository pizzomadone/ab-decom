/*
 * Decompiled with CFR 0.152.
 */
package b.a;

import b.a.a;
import b.a.b;
import b.a.d;
import b.a.e;
import b.a.f;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class c {
    private final Map b = new HashMap();
    public static final Object a = new d(0);

    public c() {
    }

    public c(f f2) {
        this();
        if (f2.b() != '{') {
            throw f2.a("A JSONObject text must begin with '{'");
        }
        block8: while (true) {
            char c2 = f2.b();
            switch (c2) {
                case '\u0000': {
                    throw f2.a("A JSONObject text must end with '}'");
                }
                case '}': {
                    return;
                }
            }
            f2.a();
            String string = f2.c().toString();
            c2 = f2.b();
            if (c2 != ':') {
                throw f2.a("Expected a ':' after a key");
            }
            this.c(string, f2.c());
            switch (f2.b()) {
                case ',': 
                case ';': {
                    if (f2.b() == '}') {
                        return;
                    }
                    f2.a();
                    continue block8;
                }
                case '}': {
                    return;
                }
            }
            break;
        }
        throw f2.a("Expected a ',' or '}'");
    }

    private c(Map object) {
        if (object != null) {
            for (Map.Entry entry : object.entrySet()) {
                Object v2 = entry.getValue();
                if (v2 == null) continue;
                this.b.put((String)entry.getKey(), c.b(v2));
            }
        }
    }

    private c(Object object) {
        this();
        Object object2 = object;
        object = this;
        Method[] methodArray = object2.getClass();
        int n2 = methodArray.getClassLoader() != null ? 1 : 0;
        methodArray = n2 != 0 ? methodArray.getMethods() : methodArray.getDeclaredMethods();
        n2 = 0;
        while (n2 < methodArray.length) {
            try {
                Object object3 = methodArray[n2];
                if (Modifier.isPublic(((Method)object3).getModifiers())) {
                    String string = ((Method)object3).getName();
                    String string2 = "";
                    if (string.startsWith("get")) {
                        string2 = "getClass".equals(string) || "getDeclaringClass".equals(string) ? "" : string.substring(3);
                    } else if (string.startsWith("is")) {
                        string2 = string.substring(2);
                    }
                    if (string2.length() > 0 && Character.isUpperCase(string2.charAt(0)) && ((Method)object3).getParameterTypes().length == 0) {
                        if (string2.length() == 1) {
                            string2 = string2.toLowerCase();
                        } else if (!Character.isUpperCase(string2.charAt(1))) {
                            string2 = String.valueOf(string2.substring(0, 1).toLowerCase()) + string2.substring(1);
                        }
                        object3 = ((Method)object3).invoke(object2, null);
                        if (object3 != null) {
                            ((c)object).b.put(string2, c.b(object3));
                        }
                    }
                }
            }
            catch (Exception exception) {}
            ++n2;
        }
    }

    public final c a(String string, Object object) {
        c.c(object);
        Object object2 = this.c(string);
        if (object2 == null) {
            this.b(string, new a().a(object));
        } else if (object2 instanceof a) {
            this.b(string, ((a)object2).a(object));
        } else {
            throw new b("JSONObject[" + string + "] is not a JSONArray.");
        }
        return this;
    }

    private Object i(String string) {
        if (string == null) {
            throw new b("Null key.");
        }
        Object object = this.c(string);
        if (object == null) {
            throw new b("JSONObject[" + c.g(string) + "] not found.");
        }
        return object;
    }

    public final int a(String string) {
        Object object = this.i(string);
        try {
            if (object instanceof Number) {
                return ((Number)object).intValue();
            }
            return Integer.parseInt((String)object);
        }
        catch (Exception exception) {
            throw new b("JSONObject[" + c.g(string) + "] is not an int.");
        }
    }

    public final a b(String string) {
        Object object = this.i(string);
        if (object instanceof a) {
            return (a)object;
        }
        throw new b("JSONObject[" + c.g(string) + "] is not a JSONArray.");
    }

    private long j(String string) {
        Object object = this.i(string);
        try {
            if (object instanceof Number) {
                return ((Number)object).longValue();
            }
            return Long.parseLong((String)object);
        }
        catch (Exception exception) {
            throw new b("JSONObject[" + c.g(string) + "] is not a long.");
        }
    }

    public final Set a() {
        return this.b.keySet();
    }

    private static String a(Number object) {
        if (object == null) {
            throw new b("Null pointer");
        }
        c.c(object);
        object = object.toString();
        if (((String)object).indexOf(46) > 0 && ((String)object).indexOf(101) < 0 && ((String)object).indexOf(69) < 0) {
            while (((String)object).endsWith("0")) {
                object = ((String)object).substring(0, ((String)object).length() - 1);
            }
            if (((String)object).endsWith(".")) {
                object = ((String)object).substring(0, ((String)object).length() - 1);
            }
        }
        return object;
    }

    public final Object c(String string) {
        if (string == null) {
            return null;
        }
        return this.b.get(string);
    }

    public final a d(String object) {
        if ((object = this.c((String)object)) instanceof a) {
            return (a)object;
        }
        return null;
    }

    public final c e(String object) {
        if ((object = this.c((String)object)) instanceof c) {
            return (c)object;
        }
        return null;
    }

    public final long a(String string, long l2) {
        try {
            return this.j(string);
        }
        catch (Exception exception) {
            return 0L;
        }
    }

    public final String f(String string) {
        return this.a(string, "");
    }

    public final String a(String object, String string) {
        if (a.equals(object = this.c((String)object))) {
            return string;
        }
        return object.toString();
    }

    public final c b(String object, Object object2) {
        if (object == null) {
            throw new NullPointerException("Null key.");
        }
        if (object2 != null) {
            c.c(object2);
            this.b.put(object, object2);
        } else {
            object2 = object;
            object = this;
            ((c)object).b.remove(object2);
        }
        return this;
    }

    public final c c(String string, Object object) {
        if (string != null && object != null) {
            if (this.c(string) != null) {
                throw new b("Duplicate key \"" + string + "\"");
            }
            this.b(string, object);
        }
        return this;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static String g(String string) {
        StringWriter stringWriter = new StringWriter();
        StringBuffer stringBuffer = stringWriter.getBuffer();
        synchronized (stringBuffer) {
            try {
                return c.a(string, stringWriter).toString();
            }
            catch (IOException iOException) {
                return "";
            }
        }
    }

    private static Writer a(String string, Writer writer) {
        if (string == null || string.length() == 0) {
            writer.write("\"\"");
            return writer;
        }
        char c2 = '\u0000';
        int n2 = string.length();
        writer.write(34);
        int n3 = 0;
        while (n3 < n2) {
            block12: {
                char c3 = c2;
                c2 = string.charAt(n3);
                switch (c2) {
                    case '\"': 
                    case '\\': {
                        writer.write(92);
                        break;
                    }
                    case '/': {
                        if (c3 == '<') {
                            writer.write(92);
                        }
                        writer.write(c2);
                        break block12;
                    }
                    case '\b': {
                        writer.write("\\b");
                        break block12;
                    }
                    case '\t': {
                        writer.write("\\t");
                        break block12;
                    }
                    case '\n': {
                        writer.write("\\n");
                        break block12;
                    }
                    case '\f': {
                        writer.write("\\f");
                        break block12;
                    }
                    case '\r': {
                        writer.write("\\r");
                        break block12;
                    }
                    default: {
                        if (c2 >= ' ' && (c2 < '\u0080' || c2 >= '\u00a0') && (c2 < '\u2000' || c2 >= '\u2100')) break;
                        writer.write("\\u");
                        String string2 = Integer.toHexString(c2);
                        writer.write("0000", 0, 4 - string2.length());
                        writer.write(string2);
                        break block12;
                    }
                }
                writer.write(c2);
            }
            ++n3;
        }
        writer.write(34);
        return writer;
    }

    public static Object h(String string) {
        if (string.equals("")) {
            return string;
        }
        if (string.equalsIgnoreCase("true")) {
            return Boolean.TRUE;
        }
        if (string.equalsIgnoreCase("false")) {
            return Boolean.FALSE;
        }
        if (string.equalsIgnoreCase("null")) {
            return a;
        }
        char c2 = string.charAt(0);
        if (c2 >= '0' && c2 <= '9' || c2 == '-') {
            try {
                if (string.indexOf(46) >= 0 || string.indexOf(101) >= 0 || string.indexOf(69) >= 0) {
                    Double d2 = Double.valueOf(string);
                    if (!d2.isInfinite() && !d2.isNaN()) {
                        return d2;
                    }
                } else {
                    Long l2 = new Long(string);
                    if (string.equals(l2.toString())) {
                        if (l2 == (long)l2.intValue()) {
                            return l2.intValue();
                        }
                        return l2;
                    }
                }
            }
            catch (Exception exception) {}
        }
        return string;
    }

    private static void c(Object object) {
        if (object != null && (object instanceof Double ? ((Double)object).isInfinite() || ((Double)object).isNaN() : object instanceof Float && (((Float)object).isInfinite() || ((Float)object).isNaN()))) {
            throw new b("JSON does not allow non-finite numbers.");
        }
    }

    public final String toString() {
        try {
            return this.a(0);
        }
        catch (Exception exception) {
            return null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private String a(int n2) {
        StringWriter stringWriter = new StringWriter();
        StringBuffer stringBuffer = stringWriter.getBuffer();
        synchronized (stringBuffer) {
            return this.a(stringWriter, 0, 0).toString();
        }
    }

    public static String a(Object object) {
        if (object == null || object.equals(null)) {
            return "null";
        }
        if (object instanceof e) {
            try {
                object = ((e)object).a();
            }
            catch (Exception exception) {
                throw new b(exception);
            }
            if (object instanceof String) {
                return (String)object;
            }
            throw new b("Bad value from toJSONString: " + object);
        }
        if (object instanceof Number) {
            return c.a((Number)object);
        }
        if (object instanceof Boolean || object instanceof c || object instanceof a) {
            return object.toString();
        }
        if (object instanceof Map) {
            object = (Map)object;
            return new c((Map)object).toString();
        }
        if (object instanceof Collection) {
            object = (Collection)object;
            return new a((Collection)object).toString();
        }
        if (object.getClass().isArray()) {
            return new a(object).toString();
        }
        return c.g(object.toString());
    }

    public static Object b(Object object) {
        try {
            if (object == null) {
                return a;
            }
            if (object instanceof c || object instanceof a || a.equals(object) || object instanceof e || object instanceof Byte || object instanceof Character || object instanceof Short || object instanceof Integer || object instanceof Long || object instanceof Boolean || object instanceof Float || object instanceof Double || object instanceof String || object instanceof BigInteger || object instanceof BigDecimal) {
                return object;
            }
            if (object instanceof Collection) {
                Collection collection = (Collection)object;
                return new a(collection);
            }
            if (object.getClass().isArray()) {
                return new a(object);
            }
            if (object instanceof Map) {
                Map map = (Map)object;
                return new c(map);
            }
            Object object2 = object.getClass().getPackage();
            object2 = object2 != null ? ((Package)object2).getName() : "";
            if (((String)object2).startsWith("java.") || ((String)object2).startsWith("javax.") || object.getClass().getClassLoader() == null) {
                return object.toString();
            }
            return new c(object);
        }
        catch (Exception exception) {
            return null;
        }
    }

    static final Writer a(Writer writer, Object object, int n2, int n3) {
        if (object == null || object.equals(null)) {
            writer.write("null");
        } else if (object instanceof c) {
            ((c)object).a(writer, n2, n3);
        } else if (object instanceof a) {
            ((a)object).a(writer, n2, n3);
        } else if (object instanceof Map) {
            Map map = (Map)object;
            new c(map).a(writer, n2, n3);
        } else if (object instanceof Collection) {
            Collection collection = (Collection)object;
            new a(collection).a(writer, n2, n3);
        } else if (object.getClass().isArray()) {
            new a(object).a(writer, n2, n3);
        } else if (object instanceof Number) {
            writer.write(c.a((Number)object));
        } else if (object instanceof Boolean) {
            writer.write(object.toString());
        } else if (object instanceof e) {
            String string;
            try {
                string = ((e)object).a();
            }
            catch (Exception exception) {
                throw new b(exception);
            }
            writer.write(string != null ? string.toString() : c.g(object.toString()));
        } else {
            c.a(object.toString(), writer);
        }
        return writer;
    }

    static final void a(Writer writer, int n2) {
        int n3 = 0;
        while (n3 < n2) {
            writer.write(32);
            ++n3;
        }
    }

    private Writer a(Writer writer, int n2, int n3) {
        try {
            boolean bl = false;
            Object object = this;
            int n4 = ((c)object).b.size();
            object = this;
            object = ((c)object).a().iterator();
            writer.write(123);
            if (n4 == 1) {
                Object e2 = object.next();
                writer.write(c.g(e2.toString()));
                writer.write(58);
                if (n2 > 0) {
                    writer.write(32);
                }
                c.a(writer, this.b.get(e2), n2, n3);
            } else if (n4 != 0) {
                n4 = n3 + n2;
                while (object.hasNext()) {
                    Object e3 = object.next();
                    if (bl) {
                        writer.write(44);
                    }
                    if (n2 > 0) {
                        writer.write(10);
                    }
                    c.a(writer, n4);
                    writer.write(c.g(e3.toString()));
                    writer.write(58);
                    if (n2 > 0) {
                        writer.write(32);
                    }
                    c.a(writer, this.b.get(e3), n2, n4);
                    bl = true;
                }
                if (n2 > 0) {
                    writer.write(10);
                }
                c.a(writer, n3);
            }
            writer.write(125);
            return writer;
        }
        catch (IOException iOException) {
            throw new b(iOException);
        }
    }
}

