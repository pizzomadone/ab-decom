/*
 * Decompiled with CFR 0.152.
 */
package a.a;

import a.c.a.a;
import a.c.b.j;
import a.c.b.k;
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
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;

public final class h
extends JDialog
implements ActionListener,
KeyListener,
DocumentListener {
    private JButton a;
    private JButton b;
    private JTextArea c = new JTextArea();
    private JComboBox d;
    private static String[] e = new String[]{a.i.c.a("abedDialogIOOutputNLNo"), a.i.c.a("abedDialogIOOutputNLYes")};
    private String f;
    private String g;
    private j h;
    private static h i = null;
    private static boolean j = false;

    private h(Window container, j object) {
        super((Frame)container, a.i.c.a("abedDialogIOOutputTitle"), true);
        this.h = object;
        this.a = a.c.a.a.d(a.i.c.a("dialogButtonOK"));
        this.b = a.c.a.a.d(a.i.c.a("dialogButtonCancel"));
        this.setModal(true);
        container = new JTextArea(a.i.c.a("abedDialogIOOutputLabel"));
        ((JTextComponent)container).setEditable(false);
        ((JComponent)container).setEnabled(true);
        ((JComponent)container).setOpaque(false);
        container.setFocusable(false);
        object = new JPanel();
        ((JComponent)object).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        ((Container)object).setLayout(new BorderLayout(10, 10));
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(2, 2, 10, 10));
        this.c.setText("CIAOCIAOCIAOCIAOCIAO\na\nb\nc\nd\ne");
        this.d = new JComboBox<String>(e);
        this.d.addActionListener(this);
        this.d.addKeyListener(this);
        ((Container)object).add(this.c);
        this.c.getDocument().addDocumentListener(this);
        this.c.addKeyListener(this);
        this.a.addActionListener(this);
        this.b.addActionListener(this);
        ((Container)object).add((Component)container, "North");
        container = new JScrollPane(this.c);
        ((Container)object).add((Component)container, "Center");
        jPanel.add(new JLabel(a.i.c.a("abedDialogIOOutputNLLabel")));
        jPanel.add(this.d);
        jPanel.add(this.a);
        jPanel.add(this.b);
        ((Container)object).add((Component)jPanel, "South");
        this.setContentPane((Container)object);
        this.setResizable(false);
        this.pack();
    }

    @Override
    public final void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.a) {
            this.h.a(this.c.getText().trim());
            this.setVisible(false);
            j = true;
            return;
        }
        if (actionEvent.getSource() == this.b) {
            this.h.a(this.g);
            this.setVisible(false);
            j = false;
            return;
        }
        if (actionEvent.getSource() == this.d) {
            this.h.e(this.d.getSelectedIndex());
        }
    }

    @Override
    public final void changedUpdate(DocumentEvent object) {
        object = this.c.getText();
        if (!((String)object).equals(this.f)) {
            this.h.a((String)object);
            this.f = object;
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
                catch (BadLocationException badLocationException) {}
            }
        }
        if (bl) {
            try {
                object2 = this.c.getText();
                int n4 = ((String)object2).length();
                while (n4 > 1 && ((String)object2).charAt(n4 - 1) == '\n' && ((String)object2).charAt(n4 - 2) == '\n') {
                    --n4;
                }
                this.h.a(this.c.getText(0, n4));
            }
            catch (BadLocationException badLocationException) {}
            this.setVisible(false);
            j = true;
            return;
        }
        if (bl2) {
            this.h.a(this.g);
            this.setVisible(false);
            j = false;
            return;
        }
        this.h.a(this.c.getText());
    }

    @Override
    public final void removeUpdate(DocumentEvent documentEvent) {
        this.h.a(this.c.getText());
    }

    public static boolean a(Window window, j object) {
        Point point = MouseInfo.getPointerInfo().getLocation();
        point.translate(15, 15);
        if (i == null) {
            i = new h(window, (j)object);
        }
        window = i;
        i.g = ((k)object).k();
        ((h)window).f = ((h)window).g;
        int n2 = ((h)window).h.j();
        if (n2 >= e.length) {
            n2 = e.length - 1;
            ((h)window).h.e(n2);
        } else if (n2 < 0) {
            n2 = 0;
            ((h)window).h.e(0);
        }
        ((h)window).d.setSelectedIndex(n2);
        ((h)window).h = object;
        object = Toolkit.getDefaultToolkit().getScreenSize();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(window.getGraphicsConfiguration());
        int n3 = (int)((Dimension)object).getWidth();
        int n4 = (int)((Dimension)object).getHeight();
        Dimension dimension = window.getSize();
        if (point.x + dimension.width > n3 - insets.right) {
            point.x -= point.x + dimension.width - n3 + insets.right + 1;
        }
        if (point.y + dimension.height > n4 - insets.bottom) {
            point.y -= point.y + dimension.height - n4 + insets.bottom + 1;
        }
        window.setLocation(point);
        ((h)window).c.setText(((h)window).g);
        ((h)window).c.requestFocusInWindow();
        ((Dialog)window).setVisible(true);
        return j;
    }

    @Override
    public final void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 27) {
            this.h.a(this.g);
            this.setVisible(false);
            j = false;
        }
    }

    @Override
    public final void keyReleased(KeyEvent keyEvent) {
    }

    @Override
    public final void keyTyped(KeyEvent keyEvent) {
    }
}

