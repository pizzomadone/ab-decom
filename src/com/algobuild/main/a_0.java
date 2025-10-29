/*
 * Decompiled with CFR 0.152.
 */
package com.algobuild.main;

import java.util.Map;
import java.util.TreeMap;
import javax.swing.Action;

/*
 * Renamed from a.k.a
 */
public final class a_0 {
    private Map a = new TreeMap();

    public final void a(String string, Action action) {
        this.a.put(string, action);
    }

    public final Action a(String string) {
        Action action = null;
        if (string != null) {
            action = (Action)this.a.get(string);
        } else {
            System.err.println("null ACTION for key:" + string);
        }
        return action;
    }
}

