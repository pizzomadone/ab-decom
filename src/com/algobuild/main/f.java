/*
 * Decompiled with CFR 0.152.
 */
package com.algobuild.main;

import a.k.c;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Icon;

final class f
extends AbstractAction {
    private /* synthetic */ c a;

    f(c c2, String string, Icon icon) {
        this.a = c2;
        super(string, icon);
    }

    @Override
    public final void actionPerformed(ActionEvent actionEvent) {
        this.a.i();
    }
}

