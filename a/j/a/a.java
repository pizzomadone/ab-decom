/*
 * Decompiled with CFR 0.152.
 */
package a.j.a;

import a.a.c;
import a.c.a.b;
import a.c.a.d;
import a.c.b.q;
import a.f.j;
import a.i.e;
import a.j.a.g;
import a.j.b.C;
import a.j.b.d_0;
import a.j.b.p;
import a.k.c_0;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.EventObject;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public final class a
extends JPanel
implements ActionListener,
ChangeListener {
    protected b a;
    private g c;
    protected JTabbedPane b;
    private int d = -1;
    private c_0 e;
    private a.i.a f;
    private a.i.a g;
    private d_0 h;
    private Vector i = new Vector();

    public a() {
        this.setLayout(new BorderLayout());
        this.h = new p();
        ImageIcon imageIcon = a.i.b.a("imgs/logo2_arancio_small.png");
        this.f = new a.i.a(imageIcon);
        imageIcon = a.i.b.a("imgs/logo2_arancio_small.png");
        this.g = new a.i.a(imageIcon);
        this.b = new JTabbedPane();
        this.add((Component)this.b, "Center");
        this.b.addTab("+", new JPanel());
        this.b.addChangeListener(this);
    }

    public final c_0 a() {
        return this.e;
    }

    public final void a(c_0 c_02) {
        this.e = c_02;
    }

    @Override
    public final void actionPerformed(ActionEvent object) {
        if (((EventObject)object).getSource() == null) {
            object = new JPopupMenu();
            JMenuItem jMenuItem = new JMenuItem(a.i.c.a("instructionConnectorNewMsg"));
            jMenuItem.setEnabled(false);
            ((JPopupMenu)object).add(jMenuItem);
            JMenuItem jMenuItem2 = new JMenuItem(a.i.c.a("abvfcAddCodePopupNewProcedure"));
            jMenuItem2.addActionListener(this);
            ((JPopupMenu)object).add(jMenuItem2);
            jMenuItem2 = new JMenuItem(a.i.c.a("abvfcAddCodePopupNewFunction"));
            jMenuItem2.addActionListener(this);
            ((JPopupMenu)object).add(jMenuItem2);
            ((JPopupMenu)object).show(this, ((JComponent)null).getX(), ((JComponent)null).getY());
            return;
        }
        if ((object = ((ActionEvent)object).getActionCommand()) != null && ((String)object).equals(a.i.c.a("abvfcAddCodePopupNewProcedure"))) {
            String string = JOptionPane.showInputDialog(this, (Object)a.i.c.a("abvfcAddCodeNewProcedureNameMsg"));
            q q2 = this.a.a(string);
            if (q2 == null) {
                this.a.a(string, 2);
                return;
            }
            JOptionPane.showMessageDialog(this, a.i.c.a("abvfcAddCodeNameAlreadyPresentMsg"), a.i.c.a("abvfcAddCodePopupNewMsg"), 0);
            return;
        }
        if (object != null && ((String)object).equals(a.i.c.a("abvfcAddCodePopupNewFunction"))) {
            String string = JOptionPane.showInputDialog(this, (Object)a.i.c.a("abvfcAddCodeNewFunctionNameMsg"));
            q q3 = this.a.a(string);
            if (q3 == null) {
                this.a.a(string, 3);
                return;
            }
            JOptionPane.showMessageDialog(this, a.i.c.a("abvfcAddCodeNameAlreadyPresentMsg"), a.i.c.a("abvfcAddCodePopupNewMsg"), 0);
        }
    }

    public final void a(d object) {
        int n2 = this.b.getTabCount();
        String string = ((d)object).b();
        a.j.b.c_0 c_02 = new a.j.b.c_0(this.a, this, (d)object);
        c_02.setBackground(Color.YELLOW);
        ((d)object).a(c_02);
        c_02.g();
        c_02.setAlignmentX(0.5f);
        JComponent jComponent = Box.createVerticalBox();
        jComponent.add(c_02);
        jComponent = new JScrollPane(jComponent);
        ((JScrollPane)jComponent).getHorizontalScrollBar().setUnitIncrement(15);
        ((JScrollPane)jComponent).getVerticalScrollBar().setUnitIncrement(15);
        a.j.b.c_0 c_03 = new a.j.b.c_0(this.a, this, (d)object);
        ((d)object).a(c_03);
        c_03.g();
        c_03.setAlignmentX(0.5f);
        object = Box.createVerticalBox();
        ((Container)object).add(c_03);
        object = new JScrollPane((Component)object);
        ((JScrollPane)jComponent).getHorizontalScrollBar().setUnitIncrement(15);
        ((JScrollPane)jComponent).getVerticalScrollBar().setUnitIncrement(15);
        C c2 = this.h.a(c_03);
        c_03.a(c2);
        object = new JSplitPane(1, jComponent, (Component)object);
        ((JSplitPane)object).setResizeWeight(0.5);
        ((JSplitPane)object).setDividerSize(4);
        if (n2 == 0) {
            this.b.addTab(string, (Component)object);
            this.i.add(c_02);
        } else {
            this.b.insertTab(string, null, (Component)object, null, n2 - 1);
            this.b.setSelectedIndex(n2 - 1);
            this.i.add(n2 - 1, c_02);
        }
        c_02.revalidate();
        this.updateUI();
    }

    public final void b() {
        this.b.removeAll();
        this.d = -1;
        this.b.addTab("+", new JPanel());
    }

    @Override
    public final void stateChanged(ChangeEvent changeEvent) {
        int n2 = this.b.getSelectedIndex();
        if (n2 >= 0) {
            String string = this.b.getTitleAt(n2);
            if (this.d >= 0 && string.equals("+")) {
                q q2;
                Object object;
                this.d = -1;
                boolean bl = false;
                String string2 = "newCode";
                int n3 = 0;
                while (n3 < 10 && !bl) {
                    if (n3 > 0) {
                        string2 = "newCode" + n3;
                    }
                    if ((object = this.a.a(string2)) == null) {
                        this.a.a(string2, 2);
                        bl = true;
                    }
                    ++n3;
                }
                if (bl && (q2 = this.a.a(string2)).m() != 1) {
                    object = this;
                    boolean bl2 = a.a.c.a(((a)object).e, q2, this.a);
                    if (!bl2) {
                        this.d = 0;
                        this.b.setSelectedIndex(0);
                        this.a.b(string2);
                    } else {
                        a.g.a a2 = new a.g.a(this.a, q2);
                        a a3 = this;
                        a3.c.a(a2);
                    }
                }
            }
            if (!string.equals("+")) {
                this.d = n2;
            }
        }
    }

    public final void a(g g2) {
        this.c = g2;
    }

    public final g c() {
        return this.c;
    }

    public final void a(String string, q q2) {
        int n2 = this.b.indexOfTab(string);
        if (n2 >= 0) {
            this.b.setTitleAt(n2, q2.j());
        }
    }

    public final void b(d object) {
        object = ((q)object).j();
        int n2 = this.b.indexOfTab((String)object);
        this.d = 0;
        this.b.setSelectedIndex(0);
        if (n2 >= 0) {
            this.b.remove(n2);
            this.i.remove(n2);
        }
    }

    public final void d() {
        int n2 = this.b.getSelectedIndex();
        Object object = (a.j.b.c_0)this.i.elementAt(n2);
        a.i.d d2 = new a.i.d((Component)object);
        int n3 = ((JComponent)object).getWidth();
        int n4 = ((JComponent)object).getHeight();
        BufferedImage bufferedImage = new BufferedImage(n3, n4, 1);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setFont(this.a.q().b());
        d2.a(graphics2D, (JComponent)object);
        graphics2D.dispose();
        object = new e(bufferedImage);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents((Transferable)object, null);
    }

    public final void e() {
        Object object = new JFileChooser(j.c().getAbsolutePath());
        FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("Immagine *.gif", "gif");
        object.addChoosableFileFilter(fileNameExtensionFilter);
        fileNameExtensionFilter = new FileNameExtensionFilter("Immagine *.jpg", "jpg");
        object.addChoosableFileFilter(fileNameExtensionFilter);
        fileNameExtensionFilter = new FileNameExtensionFilter("Immagine *.png", "png");
        object.addChoosableFileFilter(fileNameExtensionFilter);
        object.setFileSelectionMode(0);
        object.setFileFilter(fileNameExtensionFilter);
        int n2 = object.showSaveDialog(this.e);
        if (n2 == 0) {
            Object object2 = object.getSelectedFile().getAbsolutePath();
            if ((object = object.getFileFilter()) != null && object instanceof FileNameExtensionFilter) {
                object = ((FileNameExtensionFilter)object).getExtensions();
                if (!((String)object2).contains(".") && ((String[])object).length > 0 && object[0] != null) {
                    object2 = String.valueOf(object2) + "." + object[0];
                }
            }
            object = ((String)object2).substring(((String)object2).lastIndexOf(46) + 1);
            int n3 = this.b.getSelectedIndex();
            a.j.b.c_0 c_02 = (a.j.b.c_0)this.i.elementAt(n3);
            a.i.d d2 = new a.i.d(c_02);
            int n4 = c_02.getWidth();
            int n5 = c_02.getHeight();
            BufferedImage bufferedImage = new BufferedImage(n4, n5, 1);
            Graphics2D graphics2D = bufferedImage.createGraphics();
            graphics2D.setFont(this.a.q().b());
            d2.a(graphics2D, c_02);
            graphics2D.dispose();
            try {
                object2 = new File((String)object2);
                ImageIO.write((RenderedImage)bufferedImage, (String)object, (File)object2);
                return;
            }
            catch (IOException iOException) {
                object2 = iOException;
                iOException.printStackTrace();
            }
        }
    }
}

