/*
 * Decompiled with CFR 0.152.
 */
package a.j.b;

import a.a.e;
import a.a.g;
import a.a.h;
import a.a.i;
import a.a.j;
import a.c.a.b;
import a.c.a.c;
import a.c.a.d;
import a.c.b.l;
import a.c.b.s;
import a.j.a.a;
import a.j.b.n;
import a.j.b.o;
import a.k.b_0;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.RectangularShape;
import javax.swing.AbstractButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public final class f
extends n {
    public f(b b2, a a2) {
        super(b2, a2);
        this.a(new Dimension(6 * this.e, 2 * this.f));
        this.setLocation(10, 10);
        this.setToolTipText("clic Nuovo.../Incolla");
    }

    @Override
    public final void a(Graphics graphics) {
        Object object = null;
        c c2 = this.b.a();
        if (c2 != null) {
            object = this.b.a().d();
        }
        int n2 = this.getWidth();
        int n3 = this.getHeight();
        int n4 = (int)((double)this.b.q().h() * b_0.a());
        int n5 = (int)((double)this.b.q().m() * b_0.a());
        this.c(graphics);
        if (this.g && object == null) {
            this.b(graphics);
            graphics.fillRect(0, 0, n2 - 1, n3 - 1);
            this.c(graphics);
            graphics.drawRect(0, 0, n2 - 1, n3 - 1);
            object = "NEW";
            Object object2 = graphics.getFontMetrics();
            object2 = ((FontMetrics)object2).getStringBounds((String)object, graphics);
            n4 = (int)(((RectangularShape)object2).getWidth() / 2.0);
            int n6 = (int)Math.round(-((RectangularShape)object2).getHeight() / 2.0 - ((RectangularShape)object2).getY());
            n2 = n2 / 2 - n4;
            n6 = 1 * this.f + n6;
            graphics.drawString((String)object, n2, n6);
            return;
        }
        int n7 = n4;
        graphics.drawLine(n2 / 2, 0, n2 / 2, n3);
        graphics.drawLine(n2 / 2, n3 - n7, n2 / 2 - n5, n3 - n5 - n7);
        graphics.drawLine(n2 / 2, n3 - n7, n2 / 2 + n5, n3 - n5 - n7);
    }

    @Override
    public final int b() {
        int n2 = -1;
        Container container = this.getParent();
        int n3 = 0;
        while (n2 < 0 && n3 < container.getComponentCount()) {
            if (this == container.getComponent(n3)) {
                n2 = n3 / 2;
            }
            ++n3;
        }
        return n2;
    }

    private String d() {
        Object object = (o)this.getParent();
        object = String.valueOf(((o)object).h()) + "." + this.b();
        return object;
    }

    @Override
    public final void a(MouseEvent mouseEvent) {
        Object object = null;
        Object object2 = this.b.a();
        if (object2 != null) {
            object = this.b.a().d();
        }
        if (object != null) {
            return;
        }
        object = new JPopupMenu();
        object2 = new JLabel(a.i.c.a("instructionConnectorNewMsg"));
        ((JLabel)object2).setIcon(a.i.b.a("imgs/new_instruction.gif"));
        ((JPopupMenu)object).insert((Component)object2, 0);
        object2 = new JMenuItem(a.i.c.a("instructionConnectorNewAssign"), a.i.b.a("imgs/assign_icon.gif"));
        ((AbstractButton)object2).addActionListener(this);
        ((JPopupMenu)object).add((JMenuItem)object2);
        object2 = new JMenuItem(a.i.c.a("instructionConnectorNewInput"), a.i.b.a("imgs/input_icon.gif"));
        ((AbstractButton)object2).addActionListener(this);
        ((JPopupMenu)object).add((JMenuItem)object2);
        object2 = new JMenuItem(a.i.c.a("instructionConnectorNewOutput"), a.i.b.a("imgs/output_icon.gif"));
        ((AbstractButton)object2).addActionListener(this);
        ((JPopupMenu)object).add((JMenuItem)object2);
        object2 = new JMenuItem(a.i.c.a("instructionConnectorNewIf"), a.i.b.a("imgs/if_icon.gif"));
        ((AbstractButton)object2).addActionListener(this);
        ((JPopupMenu)object).add((JMenuItem)object2);
        object2 = new JMenuItem(a.i.c.a("instructionConnectorNewFor"), a.i.b.a("imgs/for_icon.gif"));
        ((AbstractButton)object2).addActionListener(this);
        ((JPopupMenu)object).add((JMenuItem)object2);
        object2 = new JMenuItem(a.i.c.a("instructionConnectorNewWhile"), a.i.b.a("imgs/while_icon.gif"));
        ((AbstractButton)object2).addActionListener(this);
        ((JPopupMenu)object).add((JMenuItem)object2);
        object2 = new JMenuItem(a.i.c.a("instructionConnectorNewDoWhile"), a.i.b.a("imgs/dowhile_icon.gif"));
        ((AbstractButton)object2).addActionListener(this);
        ((JPopupMenu)object).add((JMenuItem)object2);
        object2 = new JMenuItem(a.i.c.a("instructionConnectorNewComment"), a.i.b.a("imgs/comment_icon.gif"));
        ((AbstractButton)object2).addActionListener(this);
        ((JPopupMenu)object).add((JMenuItem)object2);
        object2 = new JMenuItem(a.i.c.a("instructionConnectorNewCall"), a.i.b.a("imgs/call_icon.gif"));
        ((AbstractButton)object2).addActionListener(this);
        if (this.b.h().c() <= 1) {
            ((JMenuItem)object2).setEnabled(false);
        }
        ((JPopupMenu)object).add((JMenuItem)object2);
        ((JPopupMenu)object).addSeparator();
        object2 = new JMenuItem(a.i.c.a("instructionConnectorPaste"));
        if (this.b.k() == null) {
            ((JMenuItem)object2).setEnabled(false);
        }
        ((AbstractButton)object2).addActionListener(this);
        ((JPopupMenu)object).add((JMenuItem)object2);
        ((JPopupMenu)object).show(mouseEvent.getComponent(), mouseEvent.getX(), mouseEvent.getY());
    }

    @Override
    public final void actionPerformed(ActionEvent object) {
        block40: {
            if ((object = ((ActionEvent)object).getActionCommand()) != null && ((String)object).length() > 0) {
                if (((String)object).equals(a.i.c.a("instructionConnectorPaste"))) {
                    block39: {
                        object = this;
                        Object object2 = ((f)object).d();
                        d d2 = ((f)object).b.k();
                        int n2 = ((String)object2).lastIndexOf(46);
                        try {
                            if (d2 == null || n2 <= 0) break block39;
                            int n3 = Integer.parseInt(((String)object2).substring(n2 + 1));
                            String string = ((String)object2).substring(0, n2);
                            object2 = d2.e();
                            try {
                                if (object2 != null) {
                                    ((f)object).b.a(string, n3, (a.c.b.n)object2);
                                    a.g.f f2 = new a.g.f(((f)object).b, string, n3, (a.c.b.n)object2);
                                    ((f)object).c.c().a(f2);
                                }
                                break block39;
                            }
                            catch (Exception exception) {
                                Exception exception2 = exception;
                                exception.printStackTrace();
                            }
                            break block40;
                        }
                        catch (NumberFormatException numberFormatException) {
                            NumberFormatException numberFormatException2 = numberFormatException;
                            numberFormatException.printStackTrace();
                        }
                    }
                    return;
                }
                Object object3 = object;
                object = this;
                if (object3 != null && ((String)object3).length() > 0) {
                    String string = super.d();
                    int n4 = string.lastIndexOf(46);
                    try {
                        if (n4 <= 0) break block40;
                        int n5 = Integer.parseInt(string.substring(n4 + 1));
                        String string2 = string.substring(0, n4);
                        boolean bl = ((f)object).b.p();
                        try {
                            if (((String)object3).equals(a.i.c.a("instructionConnectorNewAssign"))) {
                                object3 = new a.c.b.a("");
                                ((f)object).b.a(string2, n5, (a.c.b.n)object3);
                                ((f)object).b.a((d)object3);
                                boolean bl2 = a.a.a.a(((f)object).c.a(), (a.c.b.a)object3);
                                if (!bl2) {
                                    ((f)object).b.c(string);
                                    ((f)object).b.a(bl);
                                } else {
                                    object3 = new a.g.f(((f)object).b, string2, n5, (a.c.b.n)object3);
                                    ((f)object).c.c().a((a.g.g)object3);
                                }
                                ((f)object).b.a((d)null);
                                return;
                            }
                            if (((String)object3).equals(a.i.c.a("instructionConnectorNewInput"))) {
                                object3 = new a.c.b.i("");
                                ((f)object).b.a(string2, n5, (a.c.b.n)object3);
                                ((f)object).b.a((d)object3);
                                boolean bl3 = a.a.g.a(((f)object).c.a(), (a.c.b.i)object3);
                                if (!bl3) {
                                    ((f)object).b.c(string);
                                    ((f)object).b.a(bl);
                                } else {
                                    object3 = new a.g.f(((f)object).b, string2, n5, (a.c.b.n)object3);
                                    ((f)object).c.c().a((a.g.g)object3);
                                }
                                ((f)object).b.a((d)null);
                                return;
                            }
                            if (((String)object3).equals(a.i.c.a("instructionConnectorNewOutput"))) {
                                object3 = new a.c.b.j("");
                                ((f)object).b.a(string2, n5, (a.c.b.n)object3);
                                ((f)object).b.a((d)object3);
                                boolean bl4 = a.a.h.a(((f)object).c.a(), (a.c.b.j)object3);
                                if (!bl4 && ((a.c.b.j)object3).j() == 0) {
                                    ((f)object).b.c(string);
                                    ((f)object).b.a(bl);
                                } else {
                                    object3 = new a.g.f(((f)object).b, string2, n5, (a.c.b.n)object3);
                                    ((f)object).c.c().a((a.g.g)object3);
                                }
                                ((f)object).b.a((d)null);
                                return;
                            }
                            if (((String)object3).equals(a.i.c.a("instructionConnectorNewIf"))) {
                                object3 = new l("");
                                ((f)object).b.a(string2, n5, (a.c.b.n)object3);
                                ((f)object).b.a((d)object3);
                                boolean bl5 = i.a(((f)object).c.a(), (l)object3);
                                if (!bl5) {
                                    ((f)object).b.c(string);
                                    ((f)object).b.a(bl);
                                } else {
                                    object3 = new a.g.f(((f)object).b, string2, n5, (a.c.b.n)object3);
                                    ((f)object).c.c().a((a.g.g)object3);
                                }
                                ((f)object).b.a((d)null);
                                return;
                            }
                            if (((String)object3).equals(a.i.c.a("instructionConnectorNewFor"))) {
                                object3 = new a.c.b.f("", "", "");
                                ((f)object).b.a(string2, n5, (a.c.b.n)object3);
                                ((f)object).b.a((d)object3);
                                boolean bl6 = a.a.e.a(((f)object).c.a(), (a.c.b.f)object3);
                                if (!bl6) {
                                    ((f)object).b.c(string);
                                    ((f)object).b.a(bl);
                                } else {
                                    object3 = new a.g.f(((f)object).b, string2, n5, (a.c.b.n)object3);
                                    ((f)object).c.c().a((a.g.g)object3);
                                }
                                ((f)object).b.a((d)null);
                                return;
                            }
                            if (((String)object3).equals(a.i.c.a("instructionConnectorNewWhile"))) {
                                object3 = new a.c.b.g("");
                                ((f)object).b.a(string2, n5, (a.c.b.n)object3);
                                ((f)object).b.a((d)object3);
                                boolean bl7 = j.a(((f)object).c.a(), (a.c.b.g)object3);
                                if (!bl7) {
                                    ((f)object).b.c(string);
                                    ((f)object).b.a(bl);
                                } else {
                                    object3 = new a.g.f(((f)object).b, string2, n5, (a.c.b.n)object3);
                                    ((f)object).c.c().a((a.g.g)object3);
                                }
                                ((f)object).b.a((d)null);
                                return;
                            }
                            if (((String)object3).equals(a.i.c.a("instructionConnectorNewDoWhile"))) {
                                object3 = new a.c.b.e("");
                                ((f)object).b.a(string2, n5, (a.c.b.n)object3);
                                ((f)object).b.a((d)object3);
                                boolean bl8 = a.a.f.a(((f)object).c.a(), (a.c.b.e)object3);
                                if (!bl8) {
                                    ((f)object).b.c(string);
                                    ((f)object).b.a(bl);
                                } else {
                                    object3 = new a.g.f(((f)object).b, string2, n5, (a.c.b.n)object3);
                                    ((f)object).c.c().a((a.g.g)object3);
                                }
                                ((f)object).b.a((d)null);
                                return;
                            }
                            if (((String)object3).equals(a.i.c.a("instructionConnectorNewComment"))) {
                                object3 = new a.c.b.d("");
                                ((f)object).b.a(string2, n5, (a.c.b.n)object3);
                                ((f)object).b.a((d)object3);
                                boolean bl9 = a.a.d.a(((f)object).c.a(), (a.c.b.d)object3);
                                if (!bl9) {
                                    ((f)object).b.c(string);
                                    ((f)object).b.a(bl);
                                } else {
                                    object3 = new a.g.f(((f)object).b, string2, n5, (a.c.b.n)object3);
                                    ((f)object).c.c().a((a.g.g)object3);
                                }
                                ((f)object).b.a((d)null);
                                return;
                            }
                            if (((String)object3).equals(a.i.c.a("instructionConnectorNewCall"))) {
                                object3 = new a.c.b.c("test");
                                ((f)object).b.a(string2, n5, (a.c.b.n)object3);
                                ((f)object).b.a((d)object3);
                                boolean bl10 = a.a.b.a(((f)object).c.a(), (a.c.b.c)object3, ((f)object).b);
                                if (!bl10) {
                                    ((f)object).b.c(string);
                                    ((f)object).b.a(bl);
                                } else {
                                    object3 = new a.g.f(((f)object).b, string2, n5, (a.c.b.n)object3);
                                    ((f)object).c.c().a((a.g.g)object3);
                                }
                                ((f)object).b.a((d)null);
                                return;
                            }
                        }
                        catch (Exception exception) {
                            Exception exception3 = exception;
                            exception.printStackTrace();
                            return;
                        }
                    }
                    catch (NumberFormatException numberFormatException) {
                        NumberFormatException numberFormatException3 = numberFormatException;
                        numberFormatException.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    protected final void c() {
        String string = this.d();
        int n2 = string.lastIndexOf(46);
        try {
            if (n2 > 0) {
                int n3 = Integer.parseInt(string.substring(n2 + 1));
                string = string.substring(0, n2);
                this.b.a(string, n3, new a.c.b.j("'Added test output'"));
                return;
            }
        }
        catch (NumberFormatException numberFormatException) {
            NumberFormatException numberFormatException2 = numberFormatException;
            numberFormatException.printStackTrace();
            return;
        }
        catch (s s2) {
            s s3 = s2;
            s2.printStackTrace();
        }
    }

    @Override
    public final void a() {
        new Dimension(2 * this.e, 0 * this.f);
        this.a(new Dimension(6 * this.e, 2 * this.f));
    }
}

