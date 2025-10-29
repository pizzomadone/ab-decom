/*
 * Decompiled with CFR 0.152.
 */
package com.algobuild.main;

import a.i.b;
import a.k.A;
import a.k.a_0;
import a.k.c_0;
import a.k.d;
import a.k.e;
import a.k.f;
import a.k.g;
import a.k.h;
import a.k.i;
import a.k.j;
import a.k.k;
import a.k.l;
import a.k.m;
import a.k.n;
import a.k.o;
import a.k.p;
import a.k.q;
import a.k.r;
import a.k.s;
import a.k.t;
import a.k.u;
import a.k.v;
import a.k.w;
import a.k.x;
import a.k.y;
import a.k.z;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

public final class c {
    private c_0 b = new c_0();
    protected a_0 a;
    private JFileChooser c;
    private String d;
    private static c e = null;

    private c() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.b.setSize((int)(dimension.getWidth() * 0.9), (int)(dimension.getHeight() * 0.65));
        this.b.setLocation((int)(dimension.getWidth() * 0.05), (int)(dimension.getHeight() * 0.05));
        this.a = this.u();
        this.b.setJMenuBar(this.v());
        this.b.a(this.w());
        this.b.setVisible(true);
        this.b.a(new a.j.a.g(this));
        this.a.a("mnuFileSaveAs").setEnabled(true);
        this.a.a("execInstruction").setEnabled(true);
        this.a.a("execOptions").setEnabled(true);
        this.b.a(this);
    }

    public static c a() {
        if (e == null) {
            e = new c();
        }
        return e;
    }

    public final c_0 b() {
        return this.b;
    }

    private a_0 u() {
        a_0 a_02 = new a_0();
        String string = "mnuFileNew";
        Object object = a.i.c.a("mnuFileNew");
        ImageIcon imageIcon = a.i.b.a("imgs/new_icon.gif");
        object = new d(this, (String)object, imageIcon);
        a_02.a(string, (Action)object);
        string = "mnuFileOpen";
        object = a.i.c.a("mnuFileOpen");
        imageIcon = a.i.b.a("imgs/open_icon.gif");
        object = new o(this, (String)object, imageIcon);
        a_02.a(string, (Action)object);
        string = "mnuFileSave";
        object = a.i.c.a("mnuFileSave");
        imageIcon = a.i.b.a("imgs/save_icon.gif");
        object = new u(this, (String)object, imageIcon);
        object.setEnabled(false);
        a_02.a(string, (Action)object);
        string = "mnuFileSaveAs";
        object = a.i.c.a("mnuFileSaveAs");
        imageIcon = a.i.b.a("imgs/saveas_icon.gif");
        object = new v(this, (String)object, imageIcon);
        object.setEnabled(false);
        a_02.a(string, (Action)object);
        string = "mnuFileSaveImage";
        object = a.i.c.a("mnuFileSaveImage");
        object = new w(this, (String)object);
        a_02.a(string, (Action)object);
        string = "mnuFileExit";
        object = a.i.c.a("mnuFileExit");
        imageIcon = a.i.b.a("imgs/exit_icon.gif");
        object = new x(this, (String)object, imageIcon);
        a_02.a(string, (Action)object);
        string = "mnuEditUndo";
        object = a.i.c.a("mnuEditUndo");
        imageIcon = a.i.b.a("imgs/undo_icon.gif");
        object = new y(this, (String)object, imageIcon);
        if (this.b != null && this.b.a() != null) {
            object.setEnabled(this.b.a().m());
        }
        a_02.a(string, (Action)object);
        string = "mnuEditRedo";
        object = a.i.c.a("mnuEditRedo");
        imageIcon = a.i.b.a("imgs/redo_icon.gif");
        object = new z(this, (String)object, imageIcon);
        if (this.b != null && this.b.a() != null) {
            object.setEnabled(this.b.a().n());
        }
        a_02.a(string, (Action)object);
        string = "mnuEditCopyImage";
        object = a.i.c.a("mnuEditCopyImage");
        object = new A(this, (String)object);
        a_02.a(string, (Action)object);
        string = "fontAndLineOptions";
        object = a.i.c.a("fontAndLineOptions");
        imageIcon = a.i.b.a("imgs/font_icon.gif");
        object = new e(this, (String)object, imageIcon);
        a_02.a(string, (Action)object);
        string = "execInstruction";
        object = a.i.c.a("execInstruction");
        imageIcon = a.i.b.a("imgs/run_icon.gif");
        object = new f(this, (String)object, imageIcon);
        object.setEnabled(false);
        object.putValue("AcceleratorKey", KeyStroke.getKeyStroke(120, 0));
        a_02.a(string, (Action)object);
        string = "execPause";
        object = a.i.c.a("execPause");
        imageIcon = a.i.b.a("imgs/pause_icon.gif");
        object = new g(this, (String)object, imageIcon);
        object.setEnabled(false);
        a_02.a(string, (Action)object);
        string = "execInterrupt";
        object = a.i.c.a("execInterrupt");
        imageIcon = a.i.b.a("imgs/stop_icon.gif");
        object = new h(this, (String)object, imageIcon);
        object.setEnabled(false);
        a_02.a(string, (Action)object);
        string = "execOptions";
        object = a.i.c.a("execOptions");
        imageIcon = a.i.b.a("imgs/execopt_icon.gif");
        object = new i(this, (String)object, imageIcon);
        object.setEnabled(false);
        a_02.a(string, (Action)object);
        Locale locale = a.i.c.a();
        string = "mnuLanguageItalian";
        object = a.i.c.a("mnuLanguageItalian");
        imageIcon = a.i.b.a("imgs/flag_it.gif");
        object = new j(this, (String)object, imageIcon);
        object.setEnabled(locale.getLanguage() != Locale.ITALIAN.getLanguage());
        a_02.a(string, (Action)object);
        string = "mnuLanguageEnglish";
        object = a.i.c.a("mnuLanguageEnglish");
        imageIcon = a.i.b.a("imgs/flag_gb.gif");
        object = new k(this, (String)object, imageIcon);
        object.setEnabled(locale.getLanguage() != Locale.ENGLISH.getLanguage());
        a_02.a(string, (Action)object);
        string = "mnuHistoryInfo";
        object = a.i.c.a("mnuHistoryInfo");
        object = new l(this, (String)object);
        object.setEnabled(true);
        a_02.a(string, (Action)object);
        string = "mnuAuthorInfo";
        object = a.i.c.a("mnuAuthorInfo");
        object = new m(this, (String)object);
        object.setEnabled(true);
        a_02.a(string, (Action)object);
        string = "mnuAuthorRegistration";
        object = a.i.c.a("mnuAuthorRegistration");
        object = new n(this, (String)object);
        object.setEnabled(a.f.k.a().d() == null);
        a_02.a(string, (Action)object);
        string = "mnuHelpOnline";
        object = a.i.c.a("mnuHelpOnline");
        object = new p(this, (String)object);
        a_02.a(string, (Action)object);
        string = "mnuHelpOnlineFunc";
        object = a.i.c.a("mnuHelpOnlineFunc");
        object = new q(this, (String)object);
        a_02.a(string, (Action)object);
        string = "mnuHelpABSite";
        object = a.i.c.a("mnuHelpABSite");
        object = new r(this, (String)object);
        a_02.a(string, (Action)object);
        string = "mnuHelpAbout";
        object = a.i.c.a("mnuHelpAbout");
        object = new s(this, (String)object);
        a_02.a(string, (Action)object);
        return a_02;
    }

    private static JMenu b(String object) {
        object = new JMenu(a.i.c.a((String)object));
        return object;
    }

    private JMenuItem c(String string) {
        JMenuItem jMenuItem = new JMenuItem(a.i.c.a(string));
        jMenuItem.setAction(this.a.a(string));
        return jMenuItem;
    }

    private JMenuBar v() {
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = a.k.c.b("mnuFile");
        jMenu.add(this.c("mnuFileNew"));
        jMenu.addSeparator();
        jMenu.add(this.c("mnuFileOpen"));
        jMenu.add(this.c("mnuFileSave"));
        jMenu.add(this.c("mnuFileSaveAs"));
        jMenu.addSeparator();
        jMenu.add(this.c("mnuFileSaveImage"));
        jMenu.addSeparator();
        jMenu.add(this.c("mnuFileExit"));
        jMenuBar.add(jMenu);
        jMenu = a.k.c.b("mnuEdit");
        jMenu.add(this.c("mnuEditUndo"));
        jMenu.add(this.c("mnuEditRedo"));
        jMenu.add(this.c("mnuEditCopyImage"));
        jMenu.addSeparator();
        jMenu.add(this.c("fontAndLineOptions"));
        jMenuBar.add(jMenu);
        jMenu = a.k.c.b("mnuRun");
        jMenu.add(this.c("execInstruction"));
        jMenu.add(this.c("execPause"));
        jMenu.add(this.c("execInterrupt"));
        jMenu.addSeparator();
        jMenu.add(this.c("execOptions"));
        jMenuBar.add(jMenu);
        jMenu = a.k.c.b("mnuLanguage");
        jMenu.add(this.c("mnuLanguageEnglish"));
        jMenu.add(this.c("mnuLanguageItalian"));
        jMenuBar.add(jMenu);
        jMenu = a.k.c.b("mnuAuthor");
        jMenu.add(this.c("mnuHistoryInfo"));
        jMenu.addSeparator();
        jMenu.add(this.c("mnuAuthorInfo"));
        jMenu.add(this.c("mnuAuthorRegistration"));
        jMenuBar.add(jMenu);
        jMenu = a.k.c.b("mnuHelp");
        jMenu.add(this.c("mnuHelpABSite"));
        jMenu.addSeparator();
        jMenu.add(this.c("mnuHelpOnline"));
        jMenu.add(this.c("mnuHelpOnlineFunc"));
        jMenu.addSeparator();
        jMenu.add(this.c("mnuHelpAbout"));
        jMenuBar.add(jMenu);
        return jMenuBar;
    }

    private JButton d(String string) {
        JButton jButton = new JButton();
        jButton.setAction(this.a.a(string));
        jButton.setToolTipText(jButton.getText());
        jButton.setText("");
        jButton.setMargin(new Insets(0, 0, 0, 0));
        return jButton;
    }

    private JToolBar w() {
        JToolBar jToolBar = new JToolBar(a.i.c.a("toolbarOperations"));
        jToolBar.setFloatable(false);
        jToolBar.add(this.d("mnuFileNew"));
        jToolBar.add(this.d("mnuFileOpen"));
        jToolBar.add(this.d("mnuFileSave"));
        jToolBar.add(this.d("mnuFileSaveAs"));
        jToolBar.addSeparator();
        jToolBar.add(this.d("mnuEditUndo"));
        jToolBar.add(this.d("mnuEditRedo"));
        jToolBar.addSeparator();
        jToolBar.add(this.d("fontAndLineOptions"));
        jToolBar.add(this.d("execOptions"));
        jToolBar.addSeparator();
        jToolBar.add(this.d("execInstruction"));
        jToolBar.add(this.d("execPause"));
        jToolBar.add(this.d("execInterrupt"));
        return jToolBar;
    }

    public final void a(String object, boolean bl) {
        c c2 = this;
        object = c2.a.a((String)object);
        object.setEnabled(bl);
    }

    public final void c() {
        if (!this.b.b() || this.b.a().e()) {
            this.b.a(new a.j.a.g(this));
            c c2 = this;
            c2.a.a("execInstruction").setEnabled(true);
            c2 = this;
            c2.a.a("execOptions").setEnabled(true);
            this.b.setTitle("");
        }
    }

    public final void d() {
        if (!this.b.b()) {
            this.b.a(new a.j.a.g(this));
        }
        if (this.b.b()) {
            this.b.a().c();
        }
    }

    public final String e() {
        int n2;
        String string = null;
        if (this.c == null) {
            this.d = a.f.j.c().getAbsolutePath();
            this.c = new JFileChooser(this.d);
            FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("AlgoBuild files *.algobuild", "algobuild");
            this.c.setFileFilter(fileNameExtensionFilter);
            this.c.setFileSelectionMode(0);
        }
        if ((n2 = this.c.showOpenDialog(this.b)) == 0) {
            string = this.c.getSelectedFile().getAbsolutePath();
        }
        return string;
    }

    public final String a(String string) {
        int n2;
        String string2 = null;
        if (this.c == null) {
            this.d = a.f.j.c().getAbsolutePath();
            this.c = new JFileChooser(this.d);
            FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("AlgoBuild files *.algobuild", "algobuild");
            this.c.setFileFilter(fileNameExtensionFilter);
            this.c.setFileSelectionMode(0);
        }
        if (string != null) {
            this.c.setSelectedFile(new File(string));
        }
        if ((n2 = this.c.showSaveDialog(this.b)) == 0) {
            string = this.c.getSelectedFile().getName();
            string2 = this.c.getSelectedFile().getAbsolutePath();
            Object object = this.c.getFileFilter();
            if (object != null && object instanceof FileNameExtensionFilter) {
                object = ((FileNameExtensionFilter)object).getExtensions();
                if (!string.contains(".") && ((String[])object).length > 0 && object[0] != null) {
                    string2 = String.valueOf(string2) + "." + object[0];
                }
            }
            this.d = object = this.c.getSelectedFile().getParent();
        }
        return string2;
    }

    public final void f() {
        if (this.b.b()) {
            this.b.a().f();
        }
    }

    public final void g() {
        if (this.b.b()) {
            this.b.a().g();
        }
    }

    public final void h() {
        boolean bl = true;
        if (this.b.b() && !this.b.a().e()) {
            bl = false;
            int n2 = JOptionPane.showConfirmDialog(this.b, a.i.c.a("modifiedSaveQuestion"), "AlgoBuild", 2, 3);
            if (n2 == 0) {
                bl = true;
            }
        }
        if (bl) {
            System.exit(0);
        }
    }

    public final void i() {
        if (this.b.b()) {
            this.b.a().h();
        }
    }

    public final void j() {
        if (this.b.b()) {
            this.b.a().i();
        }
    }

    public final void k() {
        if (this.b.b()) {
            this.b.a().j();
        }
    }

    public final void l() {
        if (this.b.b()) {
            this.b.a().k();
        }
    }

    public final void m() {
        if (this.b.b()) {
            this.b.a().l();
        }
    }

    public final void n() {
        if (this.b.b()) {
            this.b.a().o();
        }
    }

    public final void o() {
        if (this.b.b()) {
            this.b.a().p();
        }
    }

    public final void a(Locale locale) {
        a.i.c.a(locale);
        a.i.c.a("mnuFileExit");
        a.i.c.a("mnuEditUndo");
        SwingUtilities.invokeLater(new t(this));
    }

    public final void p() {
        String string = a.f.k.a().d();
        if (string == null) {
            string = a.i.c.a("authorNotRegistered");
        }
        string = "AlgoBuild\n" + a.i.c.a("infoVersion") + " 0" + ".85" + "\n" + a.i.c.a("infoBuild") + " 00085_20200418_1930" + "\n(C) Paolo Santi 2011-2020" + "\n\n" + a.i.c.a("authorRegisteredInfo") + "\n" + a.i.c.a("infoSerial") + ": " + a.f.k.a().b() + "\n" + a.i.c.a("authorName") + ": " + string;
        Object[] objectArray = new Object[]{"OK", a.i.c.a("infoWebSite")};
        int n2 = JOptionPane.showOptionDialog(this.b, string, a.i.c.a("infoAbout"), 0, 1, new ImageIcon(this.b.getIconImage()), objectArray, objectArray[0]);
        if (n2 == 1) {
            try {
                Desktop.getDesktop().browse(new URI(a.i.c.a("infoWebURL")));
                return;
            }
            catch (IOException iOException) {
                IOException iOException2 = iOException;
                iOException.printStackTrace();
                return;
            }
            catch (URISyntaxException uRISyntaxException) {
                URISyntaxException uRISyntaxException2 = uRISyntaxException;
                uRISyntaxException.printStackTrace();
            }
        }
    }

    public final void q() {
        a.j.a.g g2;
        if (this.b != null && (g2 = this.b.a()) != null) {
            g2.q();
        }
    }

    public final void r() {
        a.j.a.g g2;
        if (this.b != null && (g2 = this.b.a()) != null) {
            g2.r();
        }
    }

    public final void s() {
        Object object = a.f.k.a();
        if (this.b != null && object != null) {
            Object[] objectArray;
            if ((object = ((a.f.k)object).d()) == null) {
                object = a.i.c.a("authorNotRegistered");
                objectArray = a.i.c.a("authorCodeRequestToRegister");
            } else {
                objectArray = a.i.c.a("authorCodeRequestToRegisterOther");
            }
            object = String.valueOf(a.i.c.a("authorName")) + ": " + (String)object + "\n\n" + (String)objectArray;
            objectArray = new Object[]{"OK", a.i.c.a("authorCodeRequestInfo")};
            int n2 = JOptionPane.showOptionDialog(this.b, object, a.i.c.a("authorInfo"), 0, 1, new ImageIcon(this.b.getIconImage()), objectArray, objectArray[0]);
            if (n2 == 1) {
                try {
                    Desktop.getDesktop().browse(new URI(a.i.c.a("authorCodeRequestPage")));
                    return;
                }
                catch (IOException iOException) {
                    IOException iOException2 = iOException;
                    iOException.printStackTrace();
                    return;
                }
                catch (URISyntaxException uRISyntaxException) {
                    URISyntaxException uRISyntaxException2 = uRISyntaxException;
                    uRISyntaxException.printStackTrace();
                }
            }
        }
    }

    public final void t() {
        if (this.b != null) {
            this.b.a().s();
        }
    }

    static /* synthetic */ a_0 a(c c2) {
        return c2.u();
    }

    static /* synthetic */ c_0 b(c c2) {
        return c2.b;
    }

    static /* synthetic */ JMenuBar c(c c2) {
        return c2.v();
    }

    static /* synthetic */ JToolBar d(c c2) {
        return c2.w();
    }

    static /* synthetic */ a_0 e(c c2) {
        return c2.a;
    }
}

