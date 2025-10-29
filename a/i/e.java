/*
 * Decompiled with CFR 0.152.
 */
package a.i;

import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;

public final class e
implements Transferable {
    private Image a;

    public e(Image image) {
        this.a = image;
    }

    @Override
    public final DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[]{DataFlavor.imageFlavor};
    }

    @Override
    public final boolean isDataFlavorSupported(DataFlavor dataFlavor) {
        return DataFlavor.imageFlavor.equals(dataFlavor);
    }

    @Override
    public final Object getTransferData(DataFlavor dataFlavor) {
        if (!DataFlavor.imageFlavor.equals(dataFlavor)) {
            throw new UnsupportedFlavorException(dataFlavor);
        }
        return this.a;
    }
}

