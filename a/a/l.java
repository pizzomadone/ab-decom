/*
 * Decompiled with CFR 0.152.
 */
package a.a;

import a.a.k;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

final class l
implements ActionListener {
    private /* synthetic */ k a;

    l(k k2) {
        this.a = k2;
    }

    @Override
    public final void actionPerformed(ActionEvent object) {
        boolean bl = k.a(this.a);
        if (bl) {
            object = "CONNESSIONE OK!";
            JOptionPane.showMessageDialog(k.b(this.a), object, "TestInternet Connection", 1);
        } else {
            object = "IMPOSSIBILE connettersi ad Internet.";
            JOptionPane.showMessageDialog(k.b(this.a), object, "TestInternet Connection", 0);
        }
        k.c(this.a).setEnabled(bl);
        k.d(this.a).setEnabled(bl);
        k.e(this.a).setEnabled(bl);
    }
}

