/*
 * Decompiled with CFR 0.152.
 */
package a.a;

import a.c.a.a;
import a.c.a.b;
import a.c.b.q;
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
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public final class c
extends JDialog
implements ActionListener,
DocumentListener {
    private JButton a;
    private JButton b;
    private JTextField c = new JTextField();
    private JTextField d = new JTextField();
    private JTextArea e = new JTextArea();
    private JTextField f = new JTextField();
    private String g;
    private String h;
    private String i;
    private String j;
    private b k;
    private q l;
    private static c m = null;
    private static boolean n = false;

    private c(Window container, q object, b object2) {
        super((Frame)container, a.i.c.a("abedDialogCodeTitle"), true);
        this.l = object;
        this.k = object2;
        this.g = ((q)object).j();
        this.a = a.c.a.a.d(a.i.c.a("dialogButtonOK"));
        this.b = a.c.a.a.d(a.i.c.a("dialogButtonCancel"));
        this.setModal(true);
        container = new JPanel();
        ((JComponent)container).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        container.setLayout(new BorderLayout(10, 10));
        object = new JPanel();
        ((Container)object).setLayout(new GridLayout(5, 1, 10, 10));
        object2 = new JLabel(a.i.c.a("abedDialogCodeCodename"));
        ((Container)object).add((Component)object2);
        ((Container)object).add(this.c);
        this.c.getDocument().addDocumentListener(this);
        object2 = new JLabel(a.i.c.a("abedDialogCodeCodetype"));
        ((Container)object).add((Component)object2);
        this.d.setEditable(false);
        this.d.setEnabled(true);
        this.d.setOpaque(false);
        this.d.setFocusable(false);
        ((Container)object).add(this.d);
        object2 = new JLabel(a.i.c.a("abedDialogCodeFormalParameters"));
        ((Container)object).add((Component)object2);
        container.add((Component)object, "North");
        this.e.setText("CIAOCIAOCIAOCIAOCIAO\na\nb\nc\nd\ne");
        this.e.getDocument().addDocumentListener(this);
        this.a.addActionListener(this);
        this.b.addActionListener(this);
        object = new JScrollPane(this.e);
        container.add((Component)object, "Center");
        object = new JPanel();
        ((Container)object).setLayout(new GridLayout(3, 1, 10, 10));
        object2 = new JPanel();
        ((Container)object2).setLayout(new GridLayout(1, 2, 10, 10));
        ((Container)object).add(new JLabel(a.i.c.a("abedDialogCodeReturnExpr")));
        ((Container)object).add(this.f);
        this.f.getDocument().addDocumentListener(this);
        ((Container)object2).add(this.a);
        ((Container)object2).add(this.b);
        ((Container)object).add((Component)object2);
        container.add((Component)object, "South");
        this.setContentPane(container);
        this.setResizable(false);
        this.pack();
    }

    @Override
    public final void actionPerformed(ActionEvent stringArray) {
        if (stringArray.getSource() == this.a) {
            stringArray = this.e.getText().split("\n");
            this.l.o();
            int n2 = 0;
            while (n2 < stringArray.length) {
                this.l.b(stringArray[n2]);
                ++n2;
            }
            this.l.c(this.f.getText());
            String string = this.c.getText();
            if (!this.g.equals(string)) {
                this.l.a(string);
                this.k.a(this.g, this.l);
            }
            this.l.a(true);
            this.setVisible(false);
            n = true;
            return;
        }
        if (stringArray.getSource() == this.b) {
            stringArray = this.i.split("\n");
            this.l.o();
            int n3 = 0;
            while (n3 < stringArray.length) {
                this.l.b(stringArray[n3]);
                ++n3;
            }
            this.l.c(this.j);
            this.l.a(true);
            this.setVisible(false);
            n = false;
        }
    }

    @Override
    public final void changedUpdate(DocumentEvent documentEvent) {
        this.a(documentEvent);
    }

    @Override
    public final void insertUpdate(DocumentEvent documentEvent) {
        this.a(documentEvent);
    }

    @Override
    public final void removeUpdate(DocumentEvent documentEvent) {
        this.a(documentEvent);
    }

    private void a(DocumentEvent object) {
        String string;
        if ((object = object.getDocument()) == this.e.getDocument() && !(string = this.e.getText()).equals(this.h)) {
            String[] stringArray = string.split("\n");
            this.l.o();
            int n2 = 0;
            while (n2 < stringArray.length) {
                this.l.b(stringArray[n2]);
                ++n2;
            }
            this.h = string;
        }
        if (object == this.f.getDocument()) {
            string = this.f.getText();
            if (string == null || string.length() == 0) {
                this.d.setText("Procedure");
                this.l.g(2);
            } else {
                this.d.setText("Function");
                this.l.g(3);
            }
            this.l.c(this.f.getText());
        }
        this.l.a(true);
    }

    public static boolean a(Window window, q q2, b object) {
        Cloneable cloneable = MouseInfo.getPointerInfo().getLocation();
        cloneable.translate(15, 15);
        if (m == null) {
            m = new c(window, q2, (b)object);
        }
        object = cloneable;
        window = m;
        m.l = q2;
        ((c)window).g = q2.j();
        ((c)window).i = "";
        int n2 = 0;
        while (n2 < ((c)window).l.k()) {
            ((c)window).i = n2 > 0 ? String.valueOf(((c)window).i) + "\n" + ((c)window).l.e(n2) : ((c)window).l.e(n2);
            ++n2;
        }
        ((c)window).h = ((c)window).i;
        ((c)window).j = ((c)window).l.l();
        if (((c)window).j == null || ((c)window).j.length() == 0) {
            ((c)window).d.setText("Procedure");
        } else {
            ((c)window).d.setText("Function");
        }
        ((c)window).c.setText(((c)window).g);
        ((c)window).f.setText(((c)window).j);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        cloneable = Toolkit.getDefaultToolkit().getScreenInsets(window.getGraphicsConfiguration());
        int n3 = (int)dimension.getWidth();
        int n4 = (int)dimension.getHeight();
        Dimension dimension2 = window.getSize();
        if (((Point)object).x + dimension2.width > n3 - ((Insets)cloneable).right) {
            ((Point)object).x -= ((Point)object).x + dimension2.width - n3 + ((Insets)cloneable).right + 1;
        }
        if (((Point)object).y + dimension2.height > n4 - ((Insets)cloneable).bottom) {
            ((Point)object).y -= ((Point)object).y + dimension2.height - n4 + ((Insets)cloneable).bottom + 1;
        }
        window.setLocation((Point)object);
        ((c)window).e.setText(((c)window).i);
        ((c)window).e.requestFocusInWindow();
        ((Dialog)window).setVisible(true);
        return n;
    }
}

