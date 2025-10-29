/*
 * Decompiled with CFR 0.152.
 */
package a.f;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public final class a
extends FileInputStream {
    private String a = "AlgoBuild01.00\n";
    private int b = -1;

    public a(String string) {
        super(string);
    }

    @Override
    public final int read() {
        this.a();
        int n2 = super.read();
        ++this.b;
        return n2;
    }

    @Override
    public final int read(byte[] byArray, int n2, int n3) {
        this.a();
        int n4 = super.read(byArray, n2, n3);
        this.b += n4;
        return n4;
    }

    @Override
    public final int read(byte[] byArray) {
        this.a();
        int n2 = super.read(byArray);
        this.b += n2;
        return n2;
    }

    private void a() {
        if (this.b < 0) {
            byte[] byArray = this.a.getBytes();
            byte[] byArray2 = new byte[byArray.length];
            super.read(byArray2, 0, byArray2.length);
            if (!Arrays.equals(byArray, byArray2)) {
                throw new IOException("Invalid file format!");
            }
            this.b = 0;
        }
    }
}

