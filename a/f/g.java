/*
 * Decompiled with CFR 0.152.
 */
package a.f;

import java.util.TreeMap;

public final class g {
    private TreeMap a = new TreeMap();

    public final void a(String string, String string2) {
        string2 = string2.replace("\n", "\\n");
        this.a.put(string, string2);
    }

    public final String a(String string) {
        if ((string = (String)this.a.get(string)) != null) {
            string = string.replace("\\n", "\n");
        }
        return string;
    }

    public final String toString() {
        return "ABPElement [data=" + this.a + "]";
    }
}

