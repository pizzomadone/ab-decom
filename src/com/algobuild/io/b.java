/*
 * Decompiled with CFR 0.152.
 */
package com.algobuild.io;

import java.io.FileOutputStream;

public final class b
extends FileOutputStream {
    private String a = "AlgoBuild01.00\n";
    private int b = 0;

    public b(String string) {
        super(string);
    }

    @Override
    public final void write(byte[] byArray, int n2, int n3) {
        if (this.b == 0) {
            byte[] byArray2 = this.a.getBytes();
            super.write(byArray2, 0, byArray2.length);
        }
        super.write(byArray, n2, n3);
        this.b += n3;
    }

    @Override
    public final void write(byte[] byArray) {
        if (this.b == 0) {
            byte[] byArray2 = this.a.getBytes();
            super.write(byArray2, 0, byArray2.length);
        }
        super.write(byArray);
        this.b += byArray.length;
    }

    @Override
    public final void write(int n2) {
        if (this.b == 0) {
            byte[] byArray = this.a.getBytes();
            super.write(byArray, 0, byArray.length);
        }
        super.write(n2);
        ++this.b;
    }
}

