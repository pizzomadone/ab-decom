/*
 * Decompiled with CFR 0.152.
 */
package com.algobuild.ui;

import a.i.c;
import java.awt.BorderLayout;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;

public final class a
extends JDialog
implements ActionListener,
KeyListener,
DocumentListener {
    private JButton a;
    private JButton b;
    private JTextArea c = new JTextArea();
    private String d;
    private String e;
    private a.c.b.a f;
    private static a g = null;
    private static boolean h = false;

    private a(Window container, Point serializable) {
        super((Frame)container, a.i.c.a("abedDialogAssignTitle"), true);
        this.setLocation((Point)serializable);
        this.a = a.c.a.a.d(a.i.c.a("dialogButtonOK"));
        this.b = a.c.a.a.d(a.i.c.a("dialogButtonCancel"));
        container = new JTextArea(a.i.c.a("abedDialogAssignLabel"));
        ((JTextComponent)container).setEditable(false);
        ((JComponent)container).setEnabled(true);
        ((JComponent)container).setOpaque(false);
        container.setFocusable(false);
        serializable = new JPanel();
        ((JComponent)serializable).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        ((Container)serializable).setLayout(new BorderLayout(10, 10));
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(1, 2, 10, 10));
        this.c.setText("CIAOCIAOCIAOCIAOCIAO\na\nb\nc\nd\ne");
        ((Container)serializable).add(this.c);
        this.c.getDocument().addDocumentListener(this);
        this.c.addKeyListener(this);
        this.a.addActionListener(this);
        this.b.addActionListener(this);
        ((Container)serializable).add(container, "North");
        container = new JScrollPane(this.c);
        ((Container)serializable).add(container, "Center");
        jPanel.add(this.a);
        jPanel.add(this.b);
        ((Container)serializable).add(jPanel, "South");
        this.setContentPane((Container)serializable);
        this.setResizable(false);
        this.pack();
    }

    @Override
    public final void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.a) {
            this.f.a(this.c.getText().trim());
            this.setVisible(false);
            h = true;
            return;
        }
        if (actionEvent.getSource() == this.b) {
            this.f.a(this.e);
            this.setVisible(false);
            h = false;
        }
    }

    @Override
    public final void changedUpdate(DocumentEvent object) {
        object = this.c.getText();
        if (!((String)object).equals(this.d)) {
            this.f.a((String)object);
            this.d = object;
        }
    }

    @Override
    public final void insertUpdate(DocumentEvent object) {
        Object object2;
        boolean bl = false;
        boolean bl2 = false;
        if (object.getLength() == 1) {
            object2 = object.getDocument();
            int n2 = object2.getLength();
            if (n2 == 1) {
                try {
                    object = object2.getText(0, 1);
                    bl2 = ((String)object).equals("\n");
                }
                catch (BadLocationException badLocationException) {}
            } else {
                try {
                    int n3 = object.getOffset();
                    object = object2.getText(n3 - 1, n2 - n3 + 1);
                    bl = true;
                    n2 = 0;
                    while (bl && n2 < ((String)object).length()) {
                        if (((String)object).charAt(n2) != '\n') {
                            bl = false;
                        }
                        ++n2;
                    }
                }
                catch (BadLocationException badLocationException) {
                    object = badLocationException;
                    badLocationException.printStackTrace();
                }
            }
        }
        if (bl) {
            try {
                object2 = this.c.getText();
                int n4 = ((String)object2).length();
                while (n4 > 1 && ((String)object2).charAt(n4 - 1) == '\n' && ((String)object2).charAt(n4 - 2) == '\n') {
                    --n4;
                }
                this.f.a(this.c.getText(0, n4));
            }
            catch (BadLocationException badLocationException) {}
            this.setVisible(false);
            h = true;
            return;
        }
        if (bl2) {
            this.f.a(this.e);
            this.setVisible(false);
            h = false;
            return;
        }
        this.f.a(this.c.getText());
    }

    @Override
    public final void removeUpdate(DocumentEvent documentEvent) {
        this.f.a(this.c.getText());
    }

    public static boolean a(Window window, a.c.b.a object) {
        Point point = MouseInfo.getPointerInfo().getLocation();
        point.translate(15, 15);
        if (g == null) {
            g = new a(window, point);
        }
        window = g;
        g.e = ((a.c.b.a)object).b();
        ((a)window).d = ((a)window).e;
        ((a)window).f = object;
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
        ((a)window).c.setText(((a)window).e);
        ((a)window).c.requestFocusInWindow();
        ((Dialog)window).setVisible(true);
        return h;
    }

    @Override
    public final void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 27) {
            this.f.a(this.e);
            this.setVisible(false);
            h = false;
        }
    }

    @Override
    public final void keyReleased(KeyEvent keyEvent) {
    }

    @Override
    public final void keyTyped(KeyEvent keyEvent) {
    }
}

