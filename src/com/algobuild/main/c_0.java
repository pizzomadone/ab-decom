/*
 * Decompiled with CFR 0.152.
 */
package com.algobuild.main;

import a.i.b;
import a.j.a.g;
import a.k.b_0;
import a.k.c;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;

/*
 * Renamed from a.k.C
 */
public final class c_0
extends JFrame
implements WindowListener {
    private c a;
    private g b;
    private JToolBar c = null;

    @Override
    public final void setJMenuBar(JMenuBar jMenuBar) {
        super.setJMenuBar(jMenuBar);
    }

    public final void a(JToolBar jToolBar) {
        if (this.c != null) {
            this.remove(this.c);
        }
        this.c = jToolBar;
        if (jToolBar != null) {
            this.add((Component)jToolBar, "First");
        }
    }

    public c_0() {
        Object object;
        c_0 c_02 = this;
        c_02.addWindowListener(c_02);
        JLabel jLabel = new JLabel();
        jLabel.setBackground(b_0.a);
        jLabel.setOpaque(true);
        jLabel.setHorizontalAlignment(0);
        jLabel.setLayout(new BorderLayout());
        c_02.setContentPane(jLabel);
        c_02.setDefaultCloseOperation(0);
        try {
            object = ClassLoader.getSystemClassLoader().getResource("imgs/logo2_arancio_small.png");
            object = Toolkit.getDefaultToolkit().getImage((URL)object);
            jLabel.setIcon(new ImageIcon((Image)object));
        }
        catch (Exception exception) {}
        try {
            object = a.i.b.a("imgs/AlgoBuildIcon.png");
            c_02.setIconImage(((ImageIcon)object).getImage());
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public final void a(c c2) {
        this.a = c2;
    }

    @Override
    public final void windowActivated(WindowEvent windowEvent) {
    }

    @Override
    public final void windowClosed(WindowEvent windowEvent) {
    }

    @Override
    public final void windowClosing(WindowEvent windowEvent) {
        this.a.h();
    }

    @Override
    public final void windowDeactivated(WindowEvent windowEvent) {
    }

    @Override
    public final void windowDeiconified(WindowEvent windowEvent) {
    }

    @Override
    public final void windowIconified(WindowEvent windowEvent) {
    }

    @Override
    public final void windowOpened(WindowEvent windowEvent) {
    }

    public final void a(g g2) {
        JComponent jComponent = (JComponent)this.getContentPane();
        if (this.b != null) {
            jComponent.remove(this.b);
        }
        this.b = g2;
        jComponent.add((Component)g2, "Center");
        g2.a(this);
        jComponent.doLayout();
        jComponent.updateUI();
        g2.b(1);
    }

    public final g a() {
        return this.b;
    }

    public final boolean b() {
        return this.b != null;
    }
}

