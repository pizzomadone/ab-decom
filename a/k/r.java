/*
 * Decompiled with CFR 0.152.
 */
package a.k;

import a.k.c;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.AbstractAction;

final class r
extends AbstractAction {
    r(c c2, String string) {
        super(string);
    }

    @Override
    public final void actionPerformed(ActionEvent actionEvent) {
        try {
            Desktop.getDesktop().browse(new URI(a.i.c.a("mnuHelpABSiteAddr")));
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

