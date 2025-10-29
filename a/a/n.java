/*
 * Decompiled with CFR 0.152.
 */
package a.a;

import a.c.a.b;
import a.i.c;
import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public final class n
extends JDialog
implements ActionListener,
ChangeListener {
    private JCheckBox a;
    private JCheckBox b;
    private JSpinner c;
    private b d;

    public n(Frame serializable, b objectArray) {
        super((Frame)serializable, a.i.c.a("abedDialogRunOptionsTitle"));
        this.d = objectArray;
        serializable = new JPanel();
        ((JComponent)serializable).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.setContentPane((Container)serializable);
        serializable.setLayout(new GridBagLayout());
        this.setVisible(false);
        this.setLocation(100, 100);
        this.setResizable(false);
        serializable = new GridBagConstraints();
        new GridBagConstraints().anchor = 21;
        ((GridBagConstraints)serializable).weightx = 1.0;
        this.a = new JCheckBox();
        this.a.setSelected(this.d.r().a());
        this.a.addActionListener(this);
        ((GridBagConstraints)serializable).gridwidth = 1;
        ((GridBagConstraints)serializable).gridx = 0;
        ((GridBagConstraints)serializable).gridy = 0;
        this.add((Component)new JLabel(a.i.c.a("execTrace")), serializable);
        ((GridBagConstraints)serializable).gridx = 1;
        this.add((Component)this.a, serializable);
        this.b = new JCheckBox();
        this.b.setSelected(this.d.r().b());
        this.b.addActionListener(this);
        ((GridBagConstraints)serializable).gridwidth = 1;
        ((GridBagConstraints)serializable).gridx = 0;
        ((GridBagConstraints)serializable).gridy = 1;
        this.add((Component)new JLabel(a.i.c.a("execOneStep")), serializable);
        ((GridBagConstraints)serializable).gridx = 1;
        this.add((Component)this.b, serializable);
        objectArray = new Integer[]{new Integer(5), new Integer(10), new Integer(20), new Integer(50), new Integer(100), new Integer(200), new Integer(500), new Integer(1000), new Integer(2000), new Integer(5000)};
        SpinnerListModel spinnerListModel = new SpinnerListModel(objectArray);
        this.c = new JSpinner(spinnerListModel);
        this.c.setValue(objectArray[9]);
        this.c.getPreferredSize();
        this.c.setValue(objectArray[7]);
        this.c.addChangeListener(this);
        ((GridBagConstraints)serializable).gridwidth = 1;
        ((GridBagConstraints)serializable).gridx = 0;
        ((GridBagConstraints)serializable).gridy = 2;
        this.add((Component)new JLabel(a.i.c.a("execStepTime")), serializable);
        ((GridBagConstraints)serializable).gridx = 1;
        this.add((Component)this.c, serializable);
        this.c.setEnabled(!this.d.r().b());
        this.pack();
    }

    @Override
    public final void actionPerformed(ActionEvent object) {
        if ((object = ((EventObject)object).getSource()) == this.a) {
            this.d.r().a(this.a.isSelected());
            this.d.a(true);
            return;
        }
        if (object == this.b) {
            boolean bl = this.b.isSelected();
            this.c.setEnabled(!bl);
            this.d.r().b(bl);
            this.d.a(true);
        }
    }

    @Override
    public final void stateChanged(ChangeEvent object) {
        if ((object = ((EventObject)object).getSource()) == this.c) {
            object = this;
            ((n)object).d.r().a(new Integer(((n)object).c.getValue().toString()));
            ((n)object).d.a(true);
        }
    }
}

