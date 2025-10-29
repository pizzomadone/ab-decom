/*
 * Decompiled with CFR 0.152.
 */
package a.j.a;

import a.j.a.d;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

final class e
extends AbstractAction {
    private /* synthetic */ d a;

    e(d d2) {
        this.a = d2;
    }

    @Override
    public final void actionPerformed(ActionEvent actionEvent) {
        d.a(this.a, null);
        this.a.setVisible(false);
    }
}

