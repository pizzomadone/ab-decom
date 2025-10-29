/*
 * Decompiled with CFR 0.152.
 */
package com.algobuild.editor.ui;

import a.c.a.b;
import a.c.a.d;
import a.j.a.a;
import a.j.b.C;
import a.j.b.f;
import a.j.b.n;
import a.j.b.o;
import java.awt.Component;
import java.awt.Dimension;

public final class e
extends o {
    public e(b object, a a2, d d2) {
        super((b)object, a2, d2);
        this.a(d2);
        this.setLayout(null);
        object = new f((b)object, a2);
        ((n)object).a(this, 0);
        this.g();
        this.a(this.d);
    }

    @Override
    public final void a(d d2, int n2) {
        o o2 = this.b(d2);
        this.a(o2, n2);
        d2.a(o2);
        this.g();
        this.d = true;
        this.a(this.d);
        this.revalidate();
    }

    @Override
    public final void a() {
        Dimension dimension = new Dimension(2 * this.e, 0 * this.f);
        Component[] componentArray = this.getComponents();
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
        this.a(dimension);
        n2 = 0;
        int n3 = 0;
        while (n3 < componentArray.length) {
            Dimension dimension3 = componentArray[n3].getMinimumSize();
            int n4 = (int)(dimension.getWidth() - dimension3.getWidth()) / 2;
            componentArray[n3].setLocation(n4, n2);
            n2 = (int)((double)n2 + dimension3.getHeight());
            ++n3;
        }
    }

    public final void a(o o2, int n2) {
        if (o2 != null) {
            f f2 = new f(this.b, this.c);
            this.add((Component)f2, n2 << 1);
            this.add((Component)o2, (n2 << 1) + 1);
            if (this.h != null) {
                C c2 = this.h.a().a(f2);
                f2.a(c2);
                c2 = this.h.a().a(o2);
                o2.a(c2);
            }
            this.g();
        }
    }

    public final void b(int n2) {
        if ((n2 << 1) + 1 < this.getComponentCount()) {
            this.remove(n2 << 1);
            this.remove(n2 << 1);
            this.g();
        }
    }

    @Override
    public final void a(int n2) {
        this.b(n2);
        this.a(true);
        this.invalidate();
    }

    @Override
    public final void a(C c2) {
        super.a(c2);
        Component[] componentArray = this.getComponents();
        int n2 = 0;
        while (n2 < componentArray.length) {
            if (componentArray[n2] instanceof n) {
                n n3 = (n)componentArray[n2];
                C c3 = c2.a().a(n3);
                n3.a(c3);
            }
            ++n2;
        }
    }
}

