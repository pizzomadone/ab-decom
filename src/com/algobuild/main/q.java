/*
 * Decompiled with CFR 0.152.
 */
package com.algobuild.main;

import a.k.c;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.AbstractAction;

final class q
extends AbstractAction {
    q(c c2, String string) {
        super(string);
    }

    @Override
    public final void actionPerformed(ActionEvent actionEvent) {
        try {
            Desktop.getDesktop().browse(new URI(a.i.c.a("mnuHelpOnlineFuncAddr")));
            return;
        }
        catch (IOException iOException) {
            return;
        }
        catch (URISyntaxException uRISyntaxException) {
            return;
        }
    }
}

