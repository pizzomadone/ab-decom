/*
 * Decompiled with CFR 0.152.
 */
package com.algobuild.main;

import a.k.c;

final class t
implements Runnable {
    private /* synthetic */ c a;

    t(c c2) {
        this.a = c2;
    }

    @Override
    public final void run() {
        this.a.a = c.a(this.a);
        c.b(this.a).setJMenuBar(c.c(this.a));
        c.b(this.a).a(c.d(this.a));
        c.e(this.a).a("mnuFileSaveAs").setEnabled(true);
        c.e(this.a).a("execInstruction").setEnabled(true);
        c.e(this.a).a("execOptions").setEnabled(true);
        if (c.b(this.a) != null && c.b(this.a).a() != null) {
            c.e(this.a).a("mnuEditUndo").setEnabled(c.b(this.a).a().m());
        }
        if (c.b(this.a) != null && c.b(this.a).a() != null) {
            c.e(this.a).a("mnuEditRedo").setEnabled(c.b(this.a).a().n());
        }
        if (c.b(this.a) != null && c.b(this.a).a() != null) {
            c.b(this.a).a().d();
        }
        c.b(this.a).revalidate();
    }
}

