/*
 * Decompiled with CFR 0.152.
 */
package a.a;

import a.a.l;
import a.c.a.a;
import a.f.d;
import a.i.c;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.EventObject;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public final class k
extends JDialog
implements ActionListener {
    private Frame a;
    private JTextField b;
    private JTextField c;
    private JButton d;
    private JButton e;
    private JButton f;

    private k(Frame container) {
        super((Frame)container, a.i.c.a("abedAuthorRegistrationTitle"));
        this.a = container;
        container = new JPanel();
        container.setLayout(new GridBagLayout());
        this.setLocation(100, 100);
        this.setResizable(false);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        new GridBagConstraints().anchor = 13;
        this.f = new JButton("Test Internet Connection");
        this.f.addActionListener(new l(this));
        this.b = new JTextField(30);
        Serializable serializable = this.b.getPreferredSize();
        gridBagConstraints.insets.left = (int)(((Dimension)serializable).getHeight() / 2.0);
        gridBagConstraints.insets.right = (int)(((Dimension)serializable).getHeight() / 2.0);
        gridBagConstraints.insets.top = (int)(((Dimension)serializable).getHeight() / 4.0);
        gridBagConstraints.insets.bottom = (int)(((Dimension)serializable).getHeight() / 4.0);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        container.add((Component)new JLabel("Network Test"), gridBagConstraints);
        gridBagConstraints.gridx = 1;
        container.add((Component)this.f, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        container.add((Component)new JLabel(a.i.c.a("abedAuthorRegistrationName")), gridBagConstraints);
        gridBagConstraints.gridx = 1;
        container.add((Component)this.b, gridBagConstraints);
        this.c = new JTextField(30);
        gridBagConstraints.gridx = 0;
        ++gridBagConstraints.gridy;
        container.add((Component)new JLabel(a.i.c.a("abedAuthorRegistrationSubsCode")), gridBagConstraints);
        gridBagConstraints.gridx = 1;
        container.add((Component)this.c, gridBagConstraints);
        this.d = a.c.a.a.d(a.i.c.a("dialogButtonOK"));
        this.d.addActionListener(this);
        this.e = a.c.a.a.d(a.i.c.a("dialogButtonCancel"));
        this.e.addActionListener(this);
        serializable = new JPanel();
        ((Container)serializable).setLayout(new GridLayout(1, 2, 10, 10));
        ((Container)serializable).add(this.d);
        ((Container)serializable).add(this.e);
        gridBagConstraints.gridx = 1;
        ++gridBagConstraints.gridy;
        container.add((Component)serializable, gridBagConstraints);
        this.setContentPane(container);
        this.b.setEnabled(false);
        this.c.setEnabled(false);
        this.d.setEnabled(false);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public final void actionPerformed(ActionEvent object) {
        if ((object = ((EventObject)object).getSource()) == this.d) {
            object = this.b.getText();
            String string = this.c.getText();
            if (!(object == null || ((String)object).length() <= 0 || ((String)object).contains("'") || ((String)object).contains("\"") || string == null || string.length() <= 0 || string.contains("'") || string.contains("\""))) {
                String string2 = a.f.d.b((String)object, string);
                if (string2 != null) {
                    JOptionPane.showMessageDialog(null, "REGISTRATO " + (String)object + "   " + string);
                    a.k.c.a().a("mnuAuthorRegistration", false);
                }
                this.setVisible(false);
                return;
            }
        } else if (object == this.e) {
            this.setVisible(false);
        }
    }

    public static void a() {
        new k(a.k.c.a().b());
    }

    private static boolean b() {
        boolean bl = false;
        try {
            Object object = new URL("https://algobuild.com");
            object = ((URL)object).openConnection();
            ((URLConnection)object).connect();
            System.out.println("Internet is connected");
            bl = true;
        }
        catch (MalformedURLException malformedURLException) {
            System.out.println("Internet is not connected");
        }
        catch (IOException iOException) {
            System.out.println("Internet is not connected");
        }
        return bl;
    }

    static /* synthetic */ boolean a(k k2) {
        return k.b();
    }

    static /* synthetic */ Frame b(k k2) {
        return k2.a;
    }

    static /* synthetic */ JTextField c(k k2) {
        return k2.b;
    }

    static /* synthetic */ JTextField d(k k2) {
        return k2.c;
    }

    static /* synthetic */ JButton e(k k2) {
        return k2.d;
    }
}

