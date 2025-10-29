/*
 * Decompiled with CFR 0.152.
 */
package a.i;

import a.j.b.n;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import javax.swing.JComponent;

public final class d
extends JComponent
implements Printable {
    private Component a;

    public d(Component component) {
        this.a = component;
    }

    @Override
    public final int print(Graphics graphics, PageFormat object, int n2) {
        boolean bl;
        double d2;
        if (n2 > 0) {
            return 1;
        }
        Graphics2D graphics2D = (Graphics2D)graphics;
        System.out.println("pageFormat.getImageableWidth=" + ((PageFormat)object).getImageableWidth());
        System.out.println("pageFormat.getImageableHeight=" + ((PageFormat)object).getImageableHeight());
        System.out.println("pageFormat.getImageableX=" + ((PageFormat)object).getImageableX());
        System.out.println("pageFormat.getImageableY=" + ((PageFormat)object).getImageableY());
        System.out.println("pageFormat.getWidth=" + ((PageFormat)object).getWidth());
        System.out.println("pageFormat.getHeight=" + ((PageFormat)object).getHeight());
        System.out.println("g2.getClipBounds=" + graphics2D.getClipBounds());
        graphics2D.translate(((PageFormat)object).getImageableX(), ((PageFormat)object).getImageableY());
        double d3 = 1.0;
        double d4 = 1.0;
        if (((PageFormat)object).getImageableWidth() < (double)this.a.getWidth()) {
            d3 = 1.0 * ((PageFormat)object).getImageableWidth() / (double)this.a.getWidth();
        }
        if (((PageFormat)object).getImageableHeight() < (double)this.a.getHeight()) {
            d4 = 1.0 * ((PageFormat)object).getImageableHeight() / (double)this.a.getHeight();
        }
        double d5 = Math.min(d3, d4);
        if (d2 < 1.0) {
            graphics2D.transform(AffineTransform.getScaleInstance(d5, d5));
        }
        if (!((object = this.a) instanceof JComponent)) {
            bl = false;
        } else {
            object = (JComponent)object;
            boolean bl2 = ((JComponent)object).isDoubleBuffered();
            ((JComponent)object).setDoubleBuffered(false);
            bl = bl2;
        }
        boolean bl3 = bl;
        this.a(graphics, (JComponent)this.a);
        boolean bl4 = bl3;
        Component component = this.a;
        if (component instanceof JComponent) {
            ((JComponent)component).setDoubleBuffered(bl4);
        }
        return 0;
    }

    public final void a(Graphics graphics, JComponent jComponent) {
        if (jComponent instanceof n) {
            ((n)jComponent).printComponent(graphics);
        }
        Graphics2D graphics2D = (Graphics2D)graphics;
        AffineTransform affineTransform = graphics2D.getTransform();
        int n2 = 0;
        while (n2 < jComponent.getComponentCount()) {
            Component component = jComponent.getComponent(n2);
            if (component instanceof JComponent) {
                graphics2D.translate(component.getX(), component.getY());
                this.a(graphics, (JComponent)component);
                graphics2D.setTransform(affineTransform);
            }
            ++n2;
        }
    }
}

