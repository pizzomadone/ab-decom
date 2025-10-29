/*
 * Decompiled with CFR 0.152.
 */
package a.a;

import a.c.a.b;
import a.c.a.i;
import a.f.j;
import a.i.c;
import a.k.b_0;
import b.a.g;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.io.Writer;
import java.util.EventObject;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public final class m
extends JDialog
implements ActionListener,
ChangeListener {
    private Frame a;
    private JComboBox b;
    private Font c;
    private Font d;
    private JSpinner e;
    private JSpinner f;
    private JSpinner g;
    private JButton h;
    private JButton i;
    private JButton j;
    private JButton k;
    private JButton l;
    private b m;

    public m(Frame serializable, b b2) {
        super((Frame)serializable, a.i.c.a("fontDialogTitle"));
        Serializable serializable2;
        this.a = serializable;
        this.m = b2;
        serializable = new JPanel();
        ((JComponent)serializable).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.setContentPane((Container)serializable);
        serializable.setLayout(new GridBagLayout());
        this.setVisible(false);
        this.setLocation(100, 100);
        this.setResizable(false);
        this.c = b2.q().b();
        this.d = b2.q().c();
        this.b = new JComboBox();
        serializable = new String[]{"Dialog", "DialogInput", "Monospaced", "Serif", "SansSerif"};
        System.currentTimeMillis();
        int n2 = 0;
        while (n2 < 5) {
            serializable2 = new Font((String)((Object)serializable[n2]), 0, 1);
            if (serializable2.canDisplayUpTo("abcdefghilmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789|!\"$%&/()=?'^[]@#<>,;.:_+-*/") < 0) {
                this.b.addItem(serializable[n2]);
            }
            ++n2;
        }
        try {
            this.b.setSelectedItem(this.c.getName());
        }
        catch (Exception exception) {}
        Serializable serializable3 = this.b.getPreferredSize();
        this.b.addActionListener(this);
        this.b.setMaximumSize((Dimension)serializable3);
        this.b.setSelectedItem(this.c.getName());
        serializable2 = new GridBagConstraints();
        new GridBagConstraints().anchor = 21;
        ((GridBagConstraints)serializable2).weightx = 1.0;
        ((GridBagConstraints)serializable2).gridwidth = 3;
        ((GridBagConstraints)serializable2).gridx = 0;
        ((GridBagConstraints)serializable2).gridy = 0;
        this.add((Component)new JLabel(a.i.c.a("fontFace")), serializable2);
        ((GridBagConstraints)serializable2).gridx = 1;
        this.add((Component)this.b, serializable2);
        serializable = new SpinnerNumberModel((int)Math.round((double)this.c.getSize() / b_0.a()), 8, 50, 2);
        this.e = new JSpinner((SpinnerModel)((Object)serializable));
        serializable = this.e.getPreferredSize();
        this.e.setMaximumSize((Dimension)serializable);
        this.e.addChangeListener(this);
        ((GridBagConstraints)serializable2).gridwidth = 1;
        ((GridBagConstraints)serializable2).gridx = 0;
        ((GridBagConstraints)serializable2).gridy = 1;
        this.add((Component)new JLabel(a.i.c.a("fontSize")), serializable2);
        ((GridBagConstraints)serializable2).gridx = 1;
        this.add((Component)this.e, serializable2);
        serializable3 = new SpinnerNumberModel((int)Math.round((double)this.d.getSize() / b_0.a()), 8, 50, 2);
        this.f = new JSpinner((SpinnerModel)((Object)serializable3));
        serializable3 = this.f.getPreferredSize();
        this.f.setMaximumSize((Dimension)serializable3);
        this.f.addChangeListener(this);
        ((GridBagConstraints)serializable2).gridx = 0;
        ((GridBagConstraints)serializable2).gridy = 2;
        this.add((Component)new JLabel(a.i.c.a("fontRunSize")), serializable2);
        ((GridBagConstraints)serializable2).gridx = 1;
        this.add((Component)this.f, serializable2);
        this.h = new JButton();
        this.h.setPreferredSize((Dimension)serializable);
        this.h.setMaximumSize((Dimension)serializable);
        this.h.setBackground(this.m.q().d());
        this.h.addActionListener(this);
        ((GridBagConstraints)serializable2).gridx = 0;
        ((GridBagConstraints)serializable2).gridy = 3;
        this.add((Component)new JLabel(a.i.c.a("btnBackgroundColor")), serializable2);
        ((GridBagConstraints)serializable2).gridx = 1;
        this.add((Component)this.h, serializable2);
        this.i = new JButton();
        this.i.setPreferredSize((Dimension)serializable);
        this.i.setMaximumSize((Dimension)serializable);
        this.i.setBackground(this.m.q().e());
        this.i.addActionListener(this);
        ((GridBagConstraints)serializable2).gridx = 0;
        ((GridBagConstraints)serializable2).gridy = 4;
        this.add((Component)new JLabel(a.i.c.a("btnFillingColor")), serializable2);
        ((GridBagConstraints)serializable2).gridx = 1;
        this.add((Component)this.i, serializable2);
        this.j = new JButton("LC");
        this.j.setPreferredSize((Dimension)serializable);
        this.j.setMaximumSize((Dimension)serializable);
        this.j.setBackground(this.m.q().i());
        this.j.addActionListener(this);
        ((GridBagConstraints)serializable2).gridx = 0;
        ((GridBagConstraints)serializable2).gridy = 5;
        this.add((Component)new JLabel(a.i.c.a("btnPenColor")), serializable2);
        ((GridBagConstraints)serializable2).gridx = 1;
        this.add((Component)this.j, serializable2);
        serializable3 = new SpinnerNumberModel(1, 1, 10, 1);
        this.g = new JSpinner((SpinnerModel)((Object)serializable3));
        serializable3 = this.g.getPreferredSize();
        this.g.setMaximumSize((Dimension)serializable3);
        this.g.addChangeListener(this);
        this.g.setValue(b2.q().h());
        ((GridBagConstraints)serializable2).gridx = 0;
        ((GridBagConstraints)serializable2).gridy = 6;
        this.add((Component)new JLabel(a.i.c.a("lineSize")), serializable2);
        ((GridBagConstraints)serializable2).gridx = 1;
        this.add((Component)this.g, serializable2);
        ((GridBagConstraints)serializable2).gridx = 0;
        ((GridBagConstraints)serializable2).gridy = 7;
        this.add((Component)new JLabel(" "), serializable2);
        ((GridBagConstraints)serializable2).gridx = 1;
        this.add((Component)new JLabel(" "), serializable2);
        this.k = new JButton();
        this.k.setPreferredSize((Dimension)serializable);
        this.k.setMaximumSize((Dimension)serializable);
        this.k.addActionListener(this);
        ((GridBagConstraints)serializable2).gridx = 0;
        ((GridBagConstraints)serializable2).gridy = 8;
        this.add((Component)new JLabel(a.i.c.a("btnSaveFontAndLinePreferences")), serializable2);
        ((GridBagConstraints)serializable2).gridx = 1;
        this.add((Component)this.k, serializable2);
        this.l = new JButton();
        this.l.setPreferredSize((Dimension)serializable);
        this.l.setMaximumSize((Dimension)serializable);
        this.l.addActionListener(this);
        ((GridBagConstraints)serializable2).gridx = 0;
        ((GridBagConstraints)serializable2).gridy = 9;
        this.add((Component)new JLabel(a.i.c.a("btnRestoreFontAndLineDefaults")), serializable2);
        ((GridBagConstraints)serializable2).gridx = 1;
        this.add((Component)this.l, serializable2);
        this.pack();
    }

    @Override
    public final void actionPerformed(ActionEvent object) {
        if ((object = ((EventObject)object).getSource()) == this.b) {
            this.b();
            this.a();
            return;
        }
        if (object == this.h) {
            object = JColorChooser.showDialog(this.a, a.i.c.a("btnBackgroundColor"), this.m.q().d());
            if (object != null) {
                this.h.setBackground((Color)object);
                this.m.q().a((Color)object);
                this.m.a(true);
                return;
            }
        } else if (object == this.i) {
            object = JColorChooser.showDialog(this.a, a.i.c.a("btnFillingColor"), this.m.q().e());
            if (object != null) {
                this.i.setBackground((Color)object);
                this.m.q().b((Color)object);
                this.m.a(true);
                return;
            }
        } else if (object == this.j) {
            object = JColorChooser.showDialog(this.a, a.i.c.a("btnPenColor"), this.m.q().i());
            if (object != null) {
                this.j.setBackground((Color)object);
                this.m.q().c((Color)object);
                this.m.a(true);
                return;
            }
        } else {
            if (object == this.k) {
                try {
                    object = this.m.q();
                    Object object2 = object = ((i)object).n();
                    object = "ViewOptions.abopt";
                    Object object3 = a.f.j.c();
                    object = new File((File)object3, (String)object);
                    object = new FileWriter((File)object);
                    object3 = new g((Writer)object);
                    ((g)object3).b();
                    ((g)object3).a("opt");
                    ((g)object3).a(object2);
                    ((g)object3).a();
                    ((OutputStreamWriter)object).close();
                    return;
                }
                catch (IOException iOException) {
                    JOptionPane.showMessageDialog(this.a, a.i.c.a("abpErrorWritingFile"), a.i.c.a("abpErrorFileOperation"), 0);
                    return;
                }
            }
            if (object == this.l) {
                object = this.m.q();
                ((i)object).a();
                this.b.setSelectedItem(((i)object).b().getFontName());
                this.e.setValue((int)Math.round((double)((i)object).b().getSize() / b_0.a()));
                this.f.setValue((int)Math.round((double)((i)object).c().getSize() / b_0.a()));
                this.h.setBackground(((i)object).d());
                this.i.setBackground(((i)object).e());
                this.j.setBackground(((i)object).i());
                this.g.setValue(((i)object).h());
                this.m.a(true);
            }
        }
    }

    private void a() {
        try {
            int n2 = (int)((double)new Integer(this.f.getValue().toString()).intValue() * b_0.a());
            Font font = new Font((String)this.b.getSelectedItem(), 0, n2);
            this.m.q().b(font);
            this.m.a(true);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    private void b() {
        try {
            int n2 = (int)((double)new Integer(this.e.getValue().toString()).intValue() * b_0.a());
            Font font = new Font((String)this.b.getSelectedItem(), 0, n2);
            this.m.q().a(font);
            this.m.q().b((n2 + 1) / 2);
            this.m.a(true);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    @Override
    public final void stateChanged(ChangeEvent object) {
        if ((object = ((EventObject)object).getSource()) == this.e) {
            this.b();
            return;
        }
        if (object == this.f) {
            this.a();
            return;
        }
        if (object == this.g) {
            object = this;
            ((m)object).m.q().a(new Integer(((m)object).g.getValue().toString()));
            ((m)object).m.a(true);
        }
    }
}

