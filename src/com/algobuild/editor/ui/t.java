/*
 * Decompiled with CFR 0.152.
 */
package com.algobuild.editor.ui;

import a.j.b.C;
import a.j.b.d_0;
import a.j.b.e;
import a.j.b.n;
import a.j.b.p;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;

public final class t
extends C {
    public t(p p2, d_0 d_02) {
        super(d_02);
    }

    @Override
    public final void a(n n2, Graphics graphics) {
    }

    @Override
    public final void a(n serializable) {
        serializable = (e)serializable;
        Dimension dimension = new Dimension(2 * ((e)serializable).e, 0 * ((e)serializable).f);
        Component[] componentArray = ((Container)serializable).getComponents();
        int n2 = 0;
        while (n2 < componentArray.length) {
            if (componentArray[n2] instanceof n) {
                ((n)componentArray[n2]).g();
            }
            Dimension dimension2 = componentArray[n2].getMinimumSize();
            if (dimension2.width > dimension.width) {
                dimension.width = dimension2.width;
            }
            dimension.height += dimension2.height;
            ++n2;
        }
        ((n)serializable).a(dimension);
        n2 = 0;
        int n3 = 0;
        while (n3 < componentArray.length) {
            serializable = componentArray[n3].getMinimumSize();
            componentArray[n3].setLocation(0, n2);
            n2 = (int)((double)n2 + ((Dimension)serializable).getHeight());
            ++n3;
        }
    }
}

