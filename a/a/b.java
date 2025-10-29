/*
 * Decompiled with CFR 0.152.
 */
package a.a;

import a.c.a.a;
import a.c.b.c;
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
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public final class b
extends JDialog
implements ActionListener,
DocumentListener {
    private JButton a;
    private JButton b;
    private JComboBox c = new JComboBox();
    private JTextField d = new JTextField();
    private JTextArea e = new JTextArea();
    private JTextArea f = new JTextArea();
    private JTextField g = new JTextField();
    private String h;
    private String i;
    private String j;
    private String k;
    private c l;
    private a.c.a.b m;
    private static b n = null;
    private static boolean o = false;

    private b(Window serializable, c object, Point serializable2, a.c.a.b b2) {
        super((Frame)serializable, a.i.c.a("abedDialogCallFuncTitle"), true);
        this.setLocation((Point)serializable2);
        this.l = object;
        this.m = b2;
        this.a = a.c.a.a.d(a.i.c.a("dialogButtonOK"));
        this.b = a.c.a.a.d(a.i.c.a("dialogButtonCancel"));
        serializable = new JPanel();
        serializable.setLayout(new GridLayout(5, 1, 10, 10));
        object = new JLabel(a.i.c.a("abedDialogCallFuncCodename"));
        serializable.add((Component)object);
        serializable.add(this.c);
        this.c.addActionListener(this);
        object = new JLabel(a.i.c.a("abedDialogCodeCodetype"));
        serializable.add((Component)object);
        this.d.setEditable(false);
        this.d.setEnabled(true);
        this.d.setOpaque(false);
        this.d.setFocusable(false);
        serializable.add(this.d);
        object = new JLabel(a.i.c.a("abedDialogCallFuncActualParameters"));
        serializable.add((Component)object);
        object = new JPanel();
        ((JComponent)object).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        ((Container)object).setLayout(new BorderLayout(10, 10));
        ((Container)object).add((Component)serializable, "North");
        this.e.setText("CIAOCIAO\na\nb\nc\nd\ne");
        this.e.setEditable(false);
        this.e.setEnabled(true);
        this.e.setOpaque(false);
        this.e.setFocusable(false);
        this.f.setText("CIAOCIAOCIAOCIAOCIAO\na\nb\nc\nd\ne");
        this.f.getDocument().addDocumentListener(this);
        serializable = Box.createHorizontalBox();
        serializable.add(this.e);
        serializable.add(this.f);
        this.a.addActionListener(this);
        this.b.addActionListener(this);
        serializable = new JScrollPane((Component)serializable);
        ((Container)object).add((Component)serializable, "Center");
        serializable = new JPanel();
        serializable.setLayout(new GridLayout(3, 1, 10, 10));
        serializable2 = new JPanel();
        ((Container)serializable2).setLayout(new GridLayout(1, 2, 10, 10));
        serializable.add(new JLabel(a.i.c.a("abedDialogCallFuncReturnVar")));
        this.g.setText(this.k);
        serializable.add(this.g);
        this.g.getDocument().addDocumentListener(this);
        ((Container)serializable2).add(this.a);
        ((Container)serializable2).add(this.b);
        serializable.add((Component)serializable2);
        ((Container)object).add((Component)serializable, "South");
        this.setContentPane((Container)object);
        this.setResizable(false);
        this.pack();
        serializable = this.f.getPreferredSize();
        this.f.setMinimumSize((Dimension)serializable);
        ((Dimension)serializable).height *= 10;
        this.f.setMaximumSize((Dimension)serializable);
        serializable = this.e.getPreferredSize();
        this.e.setMinimumSize((Dimension)serializable);
        ((Dimension)serializable).height *= 10;
        this.e.setMaximumSize((Dimension)serializable);
    }

    @Override
    public final void actionPerformed(ActionEvent stringArray) {
        if ((stringArray = stringArray.getSource()) == this.c) {
            this.a();
            return;
        }
        if (stringArray == this.a) {
            stringArray = this.f.getText().split("\n");
            Vector vector = this.l.k();
            vector.clear();
            int n2 = 0;
            while (n2 < stringArray.length) {
                vector.add(stringArray[n2]);
                ++n2;
            }
            String string = (String)this.c.getSelectedItem();
            this.l.a(string);
            if (this.g.isEnabled()) {
                this.l.b(this.g.getText());
            } else {
                this.l.b(null);
            }
            this.setVisible(false);
            o = true;
            return;
        }
        if (stringArray == this.b) {
            stringArray = this.i.split("\n");
            Vector vector = this.l.k();
            vector.clear();
            int n3 = 0;
            while (n3 < stringArray.length) {
                vector.add(stringArray[n3]);
                ++n3;
            }
            this.l.a(this.j);
            this.l.b(this.k);
            this.setVisible(false);
            o = false;
        }
    }

    private void a() {
        System.out.println("CODE NAME CHANGED");
        Object object = (String)this.c.getSelectedItem();
        System.out.println((String)object);
        if (object != null) {
            object = this.m.a((String)object);
            String string = "";
            int n2 = 0;
            while (n2 < ((q)object).k()) {
                System.out.println("param " + n2 + " = " + ((q)object).e(n2));
                if (n2 != 0) {
                    string = String.valueOf(string) + "\n";
                }
                string = String.valueOf(string) + ((q)object).e(n2);
                ++n2;
            }
            this.e.setText(string);
            if (((q)object).m() == 3) {
                this.d.setText("Function");
                this.g.setEnabled(true);
                this.l.b(this.g.getText());
            } else {
                this.d.setText("Procedure");
                this.g.setEnabled(false);
                this.l.b(null);
            }
        }
        this.l.a((String)this.c.getSelectedItem());
        this.l.a(true);
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
        if ((object = object.getDocument()) == this.f.getDocument() && !(string = this.f.getText()).equals(this.h)) {
            String[] stringArray = string.split("\n");
            Vector vector = this.l.k();
            vector.clear();
            int n2 = 0;
            while (n2 < stringArray.length) {
                vector.add(stringArray[n2]);
                ++n2;
            }
            this.h = string;
        }
        if (object == this.g.getDocument()) {
            string = this.g.getText();
            if (string == null || string.length() == 0) {
                this.d.setText("Procedure");
                this.l.b(null);
            } else {
                this.d.setText("Function");
                this.l.b(this.g.getText());
            }
        }
        this.l.a(true);
    }

    public static boolean a(Window window, c c2, a.c.a.b object) {
        Object object2 = MouseInfo.getPointerInfo().getLocation();
        ((Point)object2).translate(15, 15);
        if (n == null) {
            n = new b(window, c2, (Point)object2, (a.c.a.b)object);
        }
        Point point = object2;
        object2 = object;
        object = point;
        window = n;
        n.l = c2;
        ((b)window).m = object2;
        ((b)window).i = "";
        int n2 = 0;
        while (n2 < ((b)window).l.k().size()) {
            ((b)window).i = n2 > 0 ? String.valueOf(((b)window).i) + "\n" + (String)((b)window).l.k().get(n2) : (String)((b)window).l.k().get(n2);
            ++n2;
        }
        ((b)window).j = ((b)window).l.j();
        ((b)window).h = ((b)window).i;
        ((b)window).k = ((b)window).l.l();
        System.out.println("add to combobox - START");
        n2 = 0;
        object2 = ((a.c.a.b)object2).h().a().iterator();
        ((b)window).c.removeAllItems();
        while (object2.hasNext()) {
            q q2 = (q)object2.next();
            if (q2.m() != 3 && q2.m() != 2) continue;
            String string = q2.j();
            System.out.println("ADD code name to combo box " + string);
            ((b)window).c.addItem(string);
            if (string.equals(((b)window).j)) {
                ((b)window).c.setSelectedIndex(n2);
            }
            ++n2;
        }
        System.out.println("add to combobox - END");
        ((b)window).f.setText(((b)window).i);
        super.a();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        object2 = Toolkit.getDefaultToolkit().getScreenInsets(window.getGraphicsConfiguration());
        int n3 = (int)dimension.getWidth();
        int n4 = (int)dimension.getHeight();
        dimension = window.getSize();
        if (((Point)object).x + dimension.width > n3 - ((Insets)object2).right) {
            ((Point)object).x -= ((Point)object).x + dimension.width - n3 + ((Insets)object2).right + 1;
        }
        if (((Point)object).y + dimension.height > n4 - ((Insets)object2).bottom) {
            ((Point)object).y -= ((Point)object).y + dimension.height - n4 + ((Insets)object2).bottom + 1;
        }
        window.setLocation((Point)object);
        ((b)window).f.requestFocusInWindow();
        ((Dialog)window).setVisible(true);
        return o;
    }
}

