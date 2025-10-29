/*
 * Decompiled with CFR 0.152.
 */
package a.j.b;

import a.c.a.c;
import a.c.b.f;
import a.c.b.j;
import a.c.b.s;
import a.c.b.t;
import a.g.b;
import a.j.b.a;
import a.j.b.b_0;
import a.j.b.d;
import a.j.b.e;
import a.j.b.g;
import a.j.b.h;
import a.j.b.i;
import a.j.b.k;
import a.j.b.l;
import a.j.b.m;
import a.j.b.n;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

public class o
extends n
implements a.c.a.k {
    protected a.c.a.d i;
    protected Rectangle j;

    public o(a.c.a.b object, a.j.a.a object2, a.c.a.d d2) {
        super((a.c.a.b)object, (a.j.a.a)object2);
        object2 = d2;
        object = this;
        this.i = object2;
        this.setToolTipText("clic Modifica / Copia / Taglia");
    }

    @Override
    public final void a(a.c.a.d d2) {
        this.i = d2;
    }

    @Override
    public final boolean f() {
        if (this.i != null) {
            return this.i.a();
        }
        return false;
    }

    protected void b_() {
        if (this.j != null) {
            o o2 = this;
            boolean bl = false;
            a.c.a.d d2 = null;
            c c2 = o2.b.a();
            if (c2 != null) {
                d2 = o2.b.a().d();
            }
            if (d2 == null) {
                if (o2.b.j() == o2.i) {
                    bl = true;
                }
            } else if (d2 == o2.i) {
                bl = true;
            }
            if (bl) {
                this.scrollRectToVisible(this.j);
            }
        }
    }

    @Override
    protected final void b(Graphics graphics) {
        a.c.a.d d2 = null;
        c c2 = this.b.a();
        if (c2 != null) {
            d2 = this.b.a().d();
        }
        if (d2 == null) {
            if (this.g || this.b.j() == this.i) {
                graphics.setColor(this.b.q().g());
                return;
            }
            graphics.setColor(this.b.q().e());
            return;
        }
        if (d2 == this.i) {
            graphics.setColor(this.b.q().f());
            return;
        }
        graphics.setColor(this.b.q().e());
    }

    @Override
    protected final void c(Graphics graphics) {
        a.c.a.d d2 = null;
        c c2 = this.b.a();
        if (c2 != null) {
            d2 = this.b.a().d();
        }
        if (d2 == null) {
            if (this.g || this.b.j() == this.i) {
                graphics.setColor(this.b.q().k());
                return;
            }
            graphics.setColor(this.b.q().i());
            return;
        }
        if (d2 == this.i) {
            graphics.setColor(this.b.q().j());
            return;
        }
        graphics.setColor(this.b.q().i());
    }

    @Override
    protected final void a(Graphics graphics, int n2) {
        c c2 = this.b.a();
        if (c2 == null) {
            if (this.g || this.b.j() == this.i) {
                graphics.setColor(this.b.q().g());
                return;
            }
            graphics.setColor(this.b.q().e());
            return;
        }
        a.c.a.d d2 = c2.d();
        int n3 = c2.c();
        if (d2 == this.i && n3 == n2 && d2.a(n3)) {
            graphics.setColor(this.b.q().f());
            return;
        }
        graphics.setColor(this.b.q().e());
    }

    @Override
    protected final void d(Graphics graphics) {
        c c2 = this.b.a();
        if (c2 == null) {
            if (this.g || this.b.j() == this.i) {
                graphics.setColor(this.b.q().k());
                return;
            }
            graphics.setColor(this.b.q().i());
            return;
        }
        a.c.a.d d2 = c2.d();
        if (d2 == this.i && d2.a(c2.c())) {
            graphics.setColor(this.b.q().j());
            return;
        }
        graphics.setColor(this.b.q().i());
    }

    @Override
    public void a(a.c.a.d d2, boolean bl) {
        if (bl) {
            this.g();
            this.a(true);
            this.revalidate();
        }
        this.repaint();
        this.b_();
    }

    public final o b(a.c.a.d d2) {
        if (d2 instanceof a.c.b.a) {
            return new a(this.b, this.c, d2);
        }
        if (d2 instanceof j) {
            return new l(this.b, this.c, d2);
        }
        if (d2 instanceof a.c.b.i) {
            return new k(this.b, this.c, d2);
        }
        if (d2 instanceof f) {
            return new h(this.b, this.c, d2);
        }
        if (d2 instanceof a.c.b.g) {
            return new i(this.b, this.c, d2);
        }
        if (d2 instanceof a.c.b.e) {
            return new g(this.b, this.c, d2);
        }
        if (d2 instanceof a.c.b.l) {
            return new m(this.b, this.c, d2);
        }
        if (d2 instanceof a.c.b.o) {
            return new e(this.b, this.c, d2);
        }
        if (d2 instanceof a.c.b.d) {
            return new d(this.b, this.c, d2);
        }
        if (d2 instanceof a.c.b.b) {
            return new b_0(this.b, this.c, d2);
        }
        return null;
    }

    @Override
    public void a(a.c.a.d d2, int n2) {
    }

    @Override
    public void a(int n2) {
    }

    @Override
    protected final void c() {
    }

    public final String h() {
        while (o2.i == null) {
            o o2 = (o)o2.getParent();
        }
        return o2.i.c();
    }

    @Override
    public void a(MouseEvent mouseEvent) {
        JPopupMenu jPopupMenu = new JPopupMenu();
        JMenuItem jMenuItem = new JMenuItem(a.i.c.a("instructionModify"));
        jMenuItem.addActionListener(this);
        jPopupMenu.add(jMenuItem);
        jPopupMenu.addSeparator();
        jMenuItem = new JMenuItem(a.i.c.a("instructionCopy"));
        jMenuItem.addActionListener(this);
        jPopupMenu.add(jMenuItem);
        jMenuItem = new JMenuItem(a.i.c.a("instructionCut"));
        jMenuItem.addActionListener(this);
        jPopupMenu.add(jMenuItem);
        jPopupMenu.show(mouseEvent.getComponent(), mouseEvent.getX(), mouseEvent.getY());
    }

    @Override
    public void actionPerformed(ActionEvent object) {
        if ((object = ((ActionEvent)object).getActionCommand()) != null && ((String)object).length() > 0) {
            if (((String)object).equals(a.i.c.a("instructionModify"))) {
                this.b.a(this.i);
                this.a_();
                return;
            }
            if (((String)object).equals(a.i.c.a("instructionCopy"))) {
                object = this;
                ((o)object).b.b(((o)object).i);
                return;
            }
            if (((String)object).equals(a.i.c.a("instructionCut"))) {
                object = this;
                String string = ((o)object).h();
                try {
                    b b2 = new b(((o)object).b, string);
                    ((o)object).b.b(((o)object).i);
                    ((o)object).b.c(string);
                    ((o)object).c.c().a(b2);
                    return;
                }
                catch (s s2) {
                    s s3 = s2;
                    s2.printStackTrace();
                    return;
                }
                catch (NumberFormatException numberFormatException) {
                    NumberFormatException numberFormatException2 = numberFormatException;
                    numberFormatException.printStackTrace();
                    return;
                }
                catch (t t2) {
                    t t3 = t2;
                    t2.printStackTrace();
                }
            }
        }
    }

    protected void a_() {
        JOptionPane.showMessageDialog(this, "ABVFCExecutable - modifyInstruction() - NOT IMPLEMENTED");
    }

    public final void b(Rectangle rectangle) {
        this.j = rectangle;
    }

    public final a.c.a.d i() {
        return this.i;
    }
}

