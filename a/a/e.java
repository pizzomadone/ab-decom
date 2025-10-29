/*
 * Decompiled with CFR 0.152.
 */
package a.a;

import a.c.a.a;
import a.c.b.f;
import a.c.b.h;
import a.i.c;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;

public final class e
extends JDialog
implements ActionListener,
KeyListener,
DocumentListener {
    private JButton a;
    private JButton b;
    private JTextField c;
    private JTextField d;
    private JTextField e;
    private String f;
    private String g;
    private String h;
    private f i;
    private static e j = null;
    private static boolean k = false;

    private e(Window container, f object, Point serializable) {
        super((Frame)container, a.i.c.a("abedDialogCycleForTitle"), true);
        this.setLocation((Point)serializable);
        this.i = object;
        this.a = a.c.a.a.d(a.i.c.a("dialogButtonOK"));
        this.b = a.c.a.a.d(a.i.c.a("dialogButtonCancel"));
        container = new JTextArea(a.i.c.a("abedDialogCycleForLabel"));
        ((JTextComponent)container).setEditable(false);
        ((JComponent)container).setEnabled(true);
        ((JComponent)container).setOpaque(false);
        container.setFocusable(false);
        object = new JPanel();
        ((JComponent)object).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        ((Container)object).setLayout(new BorderLayout(10, 10));
        this.c = new JTextField();
        this.d = new JTextField();
        this.e = new JTextField();
        this.c.getDocument().addDocumentListener(this);
        this.d.getDocument().addDocumentListener(this);
        this.e.getDocument().addDocumentListener(this);
        this.c.addKeyListener(this);
        this.d.addKeyListener(this);
        this.e.addKeyListener(this);
        serializable = new JPanel();
        ((Container)serializable).setLayout(new GridLayout(4, 2, 10, 10));
        ((Container)serializable).add(new JLabel(a.i.c.a("abedDialogCycleForInitialization")));
        ((Container)serializable).add(this.c);
        ((Container)serializable).add(new JLabel(a.i.c.a("abedDialogCycleForCondition")));
        ((Container)serializable).add(this.d);
        ((Container)serializable).add(new JLabel(a.i.c.a("abedDialogCycleForUpdate")));
        ((Container)serializable).add(this.e);
        this.a.addActionListener(this);
        this.b.addActionListener(this);
        ((Container)serializable).add(this.a);
        ((Container)serializable).add(this.b);
        ((Container)object).add((Component)container, "North");
        ((Container)object).add((Component)serializable);
        this.setContentPane((Container)object);
        this.setResizable(false);
        this.pack();
    }

    @Override
    public final void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.a) {
            this.i.a(this.c.getText().trim());
            this.i.c(this.d.getText().trim());
            this.i.b(this.e.getText().trim());
            this.setVisible(false);
            k = true;
            return;
        }
        if (actionEvent.getSource() == this.b) {
            this.i.a(this.f);
            this.i.c(this.g);
            this.i.b(this.h);
            this.setVisible(false);
            k = false;
        }
    }

    @Override
    public final void changedUpdate(DocumentEvent object) {
        object = this.c.getText().trim();
        String string = this.d.getText().trim();
        String string2 = this.e.getText().trim();
        this.i.a((String)object);
        this.i.c(string);
        this.i.b(string2);
    }

    @Override
    public final void insertUpdate(DocumentEvent object) {
        object = this.c.getText().trim();
        String string = this.d.getText().trim();
        String string2 = this.e.getText().trim();
        this.i.a((String)object);
        this.i.c(string);
        this.i.b(string2);
    }

    @Override
    public final void removeUpdate(DocumentEvent object) {
        object = this.c.getText().trim();
        String string = this.d.getText().trim();
        String string2 = this.e.getText().trim();
        this.i.a((String)object);
        this.i.c(string);
        this.i.b(string2);
    }

    public static boolean a(Window window, f object) {
        Point point = MouseInfo.getPointerInfo().getLocation();
        point.translate(15, 15);
        if (j == null) {
            j = new e(window, (f)object, point);
        }
        window = j;
        j.i = object;
        ((e)window).f = ((f)object).j();
        ((e)window).g = ((h)object).l();
        ((e)window).h = ((f)object).k();
        ((e)window).c.setText(((e)window).f);
        ((e)window).d.setText(((e)window).g);
        ((e)window).e.setText(((e)window).h);
        object = Toolkit.getDefaultToolkit().getScreenSize();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(window.getGraphicsConfiguration());
        int n2 = (int)((Dimension)object).getWidth();
        int n3 = (int)((Dimension)object).getHeight();
        Dimension dimension = window.getSize();
        if (point.x + dimension.width > n2 - insets.right) {
            point.x -= point.x + dimension.width - n2 + insets.right + 1;
        }
        if (point.y + dimension.height > n3 - insets.bottom) {
            point.y -= point.y + dimension.height - n3 + insets.bottom + 1;
        }
        window.setLocation(point);
        ((Dialog)window).setVisible(true);
        return k;
    }

    @Override
    public final void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 27) {
            this.i.a(this.f);
            this.i.c(this.g);
            this.i.b(this.h);
            this.setVisible(false);
            k = false;
            return;
        }
        if (keyEvent.getKeyCode() == 10) {
            if (keyEvent.getSource() == this.c) {
                this.c.transferFocus();
                return;
            }
            if (keyEvent.getSource() == this.d) {
                this.d.transferFocus();
                return;
            }
            if (keyEvent.getSource() == this.e) {
                this.i.a(this.c.getText().trim());
                this.i.c(this.d.getText().trim());
                this.i.b(this.e.getText().trim());
                this.setVisible(false);
                k = true;
            }
        }
    }

    @Override
    public final void keyReleased(KeyEvent keyEvent) {
    }

    @Override
    public final void keyTyped(KeyEvent keyEvent) {
    }
}

