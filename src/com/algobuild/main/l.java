/*
 * Decompiled with CFR 0.152.
 */
package com.algobuild.main;

import a.k.c;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

final class l
extends AbstractAction {
    private /* synthetic */ c a;

    l(c c2, String string) {
        this.a = c2;
        super(string);
    }

    @Override
    public final void actionPerformed(ActionEvent actionEvent) {
        this.a.t();
    }
}

