/*
 * Decompiled with CFR 0.152.
 */
package a.k;

import a.k.c;
import java.awt.event.ActionEvent;
import java.util.Locale;
import javax.swing.AbstractAction;
import javax.swing.Icon;

final class j
extends AbstractAction {
    private /* synthetic */ c a;

    j(c c2, String string, Icon icon) {
        this.a = c2;
        super(string, icon);
    }

    @Override
    public final void actionPerformed(ActionEvent actionEvent) {
        this.a.a(Locale.ITALIAN);
    }
}

