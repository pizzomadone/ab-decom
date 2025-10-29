/*
 * Decompiled with CFR 0.152.
 */
package a.j.a;

import a.i.b;
import a.i.c;
import a.j.a.e;
import a.j.a.f;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
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
import java.io.Serializable;
import javax.accessibility.Accessible;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public final class d
extends JDialog
implements ActionListener {
    private JButton a;
    private JButton b;
    private JTextField c = new JTextField();
    private String d = null;

    public d(Window serializable, String object) {
        super((Frame)serializable, a.i.c.a("abvDialogInputVariable"), true);
        serializable = MouseInfo.getPointerInfo().getLocation();
        ((Point)serializable).translate(15, 15);
        this.setLocation((Point)serializable);
        Serializable serializable2 = a.i.b.a("imgs/run_icon.gif");
        Accessible accessible = a.i.b.a("imgs/pause_icon.gif");
        ImageIcon[] imageIconArray = new ImageIcon[]{serializable2, accessible};
        this.a = new JButton((Icon)((Object)serializable2));
        this.b = new JButton((Icon)((Object)accessible));
        serializable2 = new JPanel();
        ((JComponent)serializable2).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        ((Container)serializable2).setLayout(new BorderLayout(10, 10));
        accessible = new JPanel();
        ((Container)((Object)accessible)).setLayout(new GridLayout(1, 2, 10, 10));
        this.c.setText("CIAOCIAOCIAOCIAOCIAO");
        ((Container)serializable2).add(this.c);
        this.a.addActionListener(this);
        this.b.addActionListener(this);
        Cloneable cloneable = new e(this);
        f f2 = new f(this);
        this.c.getInputMap(2).put(KeyStroke.getKeyStroke(27, 0), cloneable);
        this.c.getInputMap(2).put(KeyStroke.getKeyStroke(120, 0), f2);
        ((Container)serializable2).add(new JLabel((String)object), "North");
        ((Container)serializable2).add(this.c, "Center");
        ((Container)((Object)accessible)).add(this.a);
        ((Container)((Object)accessible)).add(this.b);
        ((Container)serializable2).add((Component)((Object)accessible), "South");
        this.setContentPane((Container)serializable2);
        this.setResizable(false);
        this.pack();
        this.c.setText("");
        object = Toolkit.getDefaultToolkit().getScreenSize();
        serializable2 = Toolkit.getDefaultToolkit().getScreenInsets(this.getGraphicsConfiguration());
        int n2 = (int)((Dimension)object).getWidth();
        int n3 = (int)((Dimension)object).getHeight();
        cloneable = this.getSize();
        if (((Point)serializable).x + ((Dimension)cloneable).width > n2 - ((Insets)serializable2).right) {
            ((Point)serializable).x -= ((Point)serializable).x + ((Dimension)cloneable).width - n2 + ((Insets)serializable2).right + 1;
        }
        if (((Point)serializable).y + ((Dimension)cloneable).height > n3 - ((Insets)serializable2).bottom) {
            ((Point)serializable).y -= ((Point)serializable).y + ((Dimension)cloneable).height - n3 + ((Insets)serializable2).bottom + 1;
        }
        this.setLocation((Point)serializable);
        this.getRootPane().setDefaultButton(this.a);
        this.setVisible(true);
    }

    @Override
    public final void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.a) {
            this.d = this.c.getText();
            this.setVisible(false);
            return;
        }
        if (actionEvent.getSource() == this.b) {
            this.d = null;
            this.setVisible(false);
        }
    }

    public final String a() {
        return this.d;
    }

    static /* synthetic */ void a(d d2, String string) {
        d2.d = string;
    }

    static /* synthetic */ JTextField a(d d2) {
        return d2.c;
    }
}

