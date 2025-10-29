/*
 * Decompiled with CFR 0.152.
 */
package a.k;

import a.k.c;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Icon;

final class z
extends AbstractAction {
    private /* synthetic */ c a;

    z(c c2, String string, Icon icon) {
        this.a = c2;
        super(string, icon);
    }

    @Override
    public final void actionPerformed(ActionEvent actionEvent) {
        this.a.o();
    }
}

