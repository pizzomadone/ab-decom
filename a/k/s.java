/*
 * Decompiled with CFR 0.152.
 */
package a.k;

import a.k.c;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

final class s
extends AbstractAction {
    private /* synthetic */ c a;

    s(c c2, String string) {
        this.a = c2;
        super(string);
    }

    @Override
    public final void actionPerformed(ActionEvent actionEvent) {
        this.a.p();
    }
}

