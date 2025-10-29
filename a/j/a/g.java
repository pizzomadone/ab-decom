/*
 * Decompiled with CFR 0.152.
 */
package a.j.a;

import a.a.m;
import a.a.n;
import a.c.a.b;
import a.c.a.e;
import a.c.a.j;
import a.c.b.q;
import a.j.a.a;
import a.j.a.c;
import a.j.a.d;
import a.j.a.h;
import a.k.c_0;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.Timer;

public final class g
extends JPanel
implements j,
ActionListener {
    private a.k.c a;
    private b b;
    private e c;
    private Timer d;
    private boolean e = false;
    private JSplitPane f;
    private JSplitPane g;
    private int h = 4;
    private double i = 0.75;
    private double j = 0.75;
    private int k = -1;
    private a l;
    private c m;
    private JScrollPane n;
    private h o;
    private JScrollPane p;
    private c_0 q;
    private m r;
    private n s;
    private Stack t;
    private Stack u;

    public g(a.k.c object) {
        this.a = object;
        this.b = new b();
        this.c = new e(this.b);
        object = this;
        this.d = new Timer(1000, (ActionListener)object);
        ((g)object).d.setInitialDelay(10);
        ((Container)object).setLayout(new BorderLayout());
        ((g)object).l = new a();
        ((g)object).l.a((g)object);
        ((g)object).b.a((j)object);
        ((g)object).b.a("main", 1);
        ((g)object).b.a(false);
        ((g)object).m = new c(((g)object).b);
        ((g)object).n = new JScrollPane(((g)object).m);
        ((g)object).o = new h();
        ((g)object).p = new JScrollPane(((g)object).o);
        ((g)object).t = new Stack();
        ((g)object).u = new Stack();
        ((g)object).a.a("mnuEditUndo", false);
        ((g)object).a.a("mnuEditRedo", false);
    }

    public final void b(int n2) {
        this.getWidth();
        this.getHeight();
        if (1 != this.k) {
            this.removeAll();
            this.f = new JSplitPane(0);
            this.g = new JSplitPane(1);
            this.f.setDividerSize(this.h);
            this.g.setDividerSize(this.h);
            this.f.setTopComponent(this.l);
            this.f.setBottomComponent(this.g);
            this.g.setLeftComponent(this.n);
            this.g.setRightComponent(this.p);
            this.add((Component)this.f, "Center");
            this.f.setResizeWeight(this.i);
            this.g.setResizeWeight(this.j);
            this.k = 1;
        }
    }

    public final void a(c_0 c_02) {
        this.q = c_02;
        if (this.l != null) {
            this.l.a(c_02);
        }
    }

    public final void c() {
        String string;
        boolean bl = false;
        if (!this.b.p()) {
            bl = true;
        } else {
            int n2 = JOptionPane.showConfirmDialog(null, a.i.c.a("modifiedSaveQuestion"), "AlgoBuild", 1);
            if (n2 == 0) {
                this.f();
                if (!this.b.p()) {
                    bl = true;
                }
            } else if (n2 == 1) {
                bl = true;
            }
        }
        if (bl && (string = this.a.e()) != null && !string.isEmpty()) {
            this.b.k(string);
            if (!this.b.p() && this.a != null) {
                this.a.a("execInstruction", true);
                this.a.a("execOptions", true);
            }
            this.l.b.setSelectedIndex(0);
            this.l.repaint();
        }
    }

    public final boolean d() {
        boolean bl = this.b.p();
        this.a.a("mnuFileSave", bl);
        return bl;
    }

    public final boolean e() {
        boolean bl = false;
        if (!this.b.p()) {
            bl = true;
        } else {
            int n2 = JOptionPane.showConfirmDialog(null, a.i.c.a("modifiedSaveQuestion"), "AlgoBuild", 1);
            if (n2 == 0) {
                this.f();
                if (!this.b.p()) {
                    bl = true;
                }
            } else if (n2 == 1) {
                bl = true;
            }
        }
        return bl;
    }

    public final void f() {
        boolean bl = false;
        if (this.b.p()) {
            bl = true;
        }
        if (bl) {
            String string = this.b.o();
            if (string != null) {
                this.b.j(string);
                if (!this.b.p()) {
                    this.a.a("mnuFileSave", false);
                    return;
                }
            } else {
                this.g();
            }
        }
    }

    public final void g() {
        String string = this.a.a(this.b.o());
        if (string != null && !string.isEmpty()) {
            this.b.j(string);
            if (!this.b.p()) {
                this.a.a("mnuFileSave", false);
            }
        }
    }

    public final void h() {
        int bl = this.b.r().c();
        this.d.setDelay(bl);
        this.d.setInitialDelay(10);
        if (!this.c.b()) {
            if (this.k == 0) {
                this.b(1);
                this.doLayout();
                this.updateUI();
            }
            this.m.b();
            this.o.setText("");
            this.c.a("main");
            boolean bl2 = this.c.b();
            this.a.a("execInterrupt", bl2);
            if (!this.b.r().b()) {
                this.d.start();
                this.a.a("execInstruction", !bl2);
                this.a.a("execPause", bl2);
                this.a.a("execInterrupt", bl2);
                return;
            }
        } else {
            if (this.b.r().b()) {
                this.c.c();
                boolean bl3 = this.c.b();
                this.a.a("execInstruction", true);
                this.a.a("execPause", false);
                this.a.a("execInterrupt", bl3);
                return;
            }
            this.d.start();
            this.a.a("execInstruction", false);
            this.a.a("execPause", true);
            this.a.a("execInterrupt", true);
        }
    }

    public final void i() {
        if (this.d.isRunning()) {
            this.d.stop();
        }
        this.a.a("execInstruction", true);
        this.a.a("execPause", false);
        this.a.a("execInterrupt", this.c.b());
    }

    public final void j() {
        if (this.c.b()) {
            this.c.a();
            boolean bl = this.c.b();
            this.a.a("execInstruction", true);
            this.a.a("execPause", bl);
            this.a.a("execInterrupt", bl);
        }
    }

    @Override
    public final void a(b b2) {
        this.b = b2;
        this.l.a = b2;
    }

    @Override
    public final void a(a.c.a.d d2) {
        this.l.a(d2);
    }

    @Override
    public final void b(b b2) {
        this.d();
        try {
            this.m.setFont(this.b.q().c());
            this.m.a();
            this.o.setFont(this.b.q().c());
            int n2 = this.b.r().c();
            if (this.d.getDelay() != n2) {
                this.d.setDelay(n2);
                this.d.setInitialDelay(n2);
            }
            this.q.setTitle(b2.o());
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public final void h(String string) {
        int n2 = this.l.b.indexOfTab(string);
        if (n2 >= 0) {
            this.l.b.setSelectedIndex(n2);
        }
    }

    @Override
    public final void a() {
        this.l.b();
    }

    @Override
    public final void a(int n2) {
        this.m.a(n2);
    }

    @Override
    public final String g(String object) {
        object = new d((Window)this.q, (String)object);
        if ((object = ((d)object).a()) == null) {
            this.e = true;
            object = "execPause";
        }
        return object;
    }

    @Override
    public final void a(String string) {
        this.m.a(string, false, false, false);
    }

    @Override
    public final void b() {
        this.m.a("", true, false, false);
    }

    @Override
    public final void b(String string) {
        this.m.a(string, true, false, false);
    }

    @Override
    public final void c(String string) {
        this.m.a(string, true, true, false);
    }

    @Override
    public final void e(String string) {
        this.m.a(string, true, true, true);
    }

    @Override
    public final void d(String string) {
        this.m.a(string, false, true, false);
    }

    @Override
    public final void f(String string) {
        this.o.setText(string);
    }

    @Override
    public final void a(String string, q q2) {
        this.l.a(string, q2);
    }

    public final void k() {
        if (this.r == null) {
            this.r = new m((Frame)this.q, this.b);
        }
        if (this.r != null) {
            this.r.setVisible(!this.r.isVisible());
        }
    }

    public final void l() {
        if (this.s == null) {
            this.s = new n((Frame)this.q, this.b);
        }
        if (this.s != null) {
            this.s.setVisible(!this.s.isVisible());
        }
    }

    @Override
    public final void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.d) {
            if (this.c.b()) {
                this.c.c();
            } else {
                this.d.stop();
            }
            if (!this.e) {
                boolean bl = this.c.b();
                boolean bl2 = this.b.r().b();
                this.a.a("execInstruction", !bl || bl2);
                this.a.a("execPause", bl && !bl2);
                this.a.a("execInterrupt", bl);
                return;
            }
            this.i();
            this.e = false;
        }
    }

    public final void a(a.g.g g2) {
        this.t.push(g2);
        if (!this.u.empty()) {
            this.u.removeAllElements();
        }
        this.a.a("mnuEditUndo", true);
        this.a.a("mnuEditRedo", false);
    }

    public final boolean m() {
        return !this.t.empty();
    }

    public final boolean n() {
        return !this.u.empty();
    }

    public final void o() {
        if (this.m()) {
            a.g.g g2 = (a.g.g)this.t.pop();
            g2.b();
            this.u.push(g2);
            this.a.a("mnuEditUndo", this.m());
            this.a.a("mnuEditRedo", this.n());
        }
    }

    public final void p() {
        if (this.n()) {
            a.g.g g2 = (a.g.g)this.u.pop();
            g2.a();
            this.t.push(g2);
            this.a.a("mnuEditUndo", this.m());
            this.a.a("mnuEditRedo", this.n());
        }
    }

    @Override
    public final void b(a.c.a.d d2) {
        this.l.b(d2);
    }

    public final void q() {
        this.l.d();
    }

    public final void r() {
        this.l.e();
    }

    public final void s() {
        String string = this.b.s();
        JOptionPane.showMessageDialog(this.q, string, a.i.c.a("mnuHistoryInfo"), 1);
    }
}

