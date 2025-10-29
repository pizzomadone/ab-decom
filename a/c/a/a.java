/*
 * Decompiled with CFR 0.152.
 */
package a.c.a;

import a.c.b.p;
import a.c.b.q;
import a.f.j;
import a.f.l;
import a.i.c;
import a.k.B;
import a.k.b_0;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.FontUIResource;

public class a {
    private Map a = new TreeMap();

    final q a(String object, int n2) {
        object = new q((String)object, n2);
        this.a.put(((q)object).j(), object);
        return object;
    }

    final q a(q q2) {
        this.a.put(q2.j(), q2);
        return q2;
    }

    final q a(String object) {
        object = (q)this.a.get(object);
        return object;
    }

    final void b(String string) {
        this.a.remove(string);
    }

    final void c(String object) {
        object = (q)this.a.remove(object);
        this.a.put(((q)object).j(), object);
    }

    public final Collection a() {
        return this.a.values();
    }

    public final void b() {
        if (this.a != null) {
            this.a.clear();
        }
    }

    public final int c() {
        if (this.a != null) {
            return this.a.size();
        }
        return 0;
    }

    public final p d() {
        p p2 = new p();
        Object object = this.a.values();
        Iterator iterator = object.iterator();
        while (iterator.hasNext()) {
            object = (q)iterator.next();
            p2.a(((q)object).i());
        }
        return p2;
    }

    public static void a(String[] stringArray) {
        Exception exception;
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }
        catch (ClassNotFoundException classNotFoundException) {
            exception = classNotFoundException;
            classNotFoundException.printStackTrace();
        }
        catch (InstantiationException instantiationException) {
            exception = instantiationException;
            instantiationException.printStackTrace();
        }
        catch (IllegalAccessException illegalAccessException) {
            exception = illegalAccessException;
            illegalAccessException.printStackTrace();
        }
        catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
            exception = unsupportedLookAndFeelException;
            unsupportedLookAndFeelException.printStackTrace();
        }
        double d2 = 0.0;
        int n2 = 0;
        while (n2 < stringArray.length) {
            if (stringArray[n2].toLowerCase().startsWith("fontzoom=")) {
                String string = stringArray[n2].substring(9);
                try {
                    if (string.endsWith("%")) {
                        System.out.println("ZOOM %: " + string);
                        d2 = Double.parseDouble(string.substring(0, string.length() - 1)) / 100.0;
                    } else {
                        System.out.println("ZOOM FACTOR: " + string);
                        d2 = Double.parseDouble(string);
                    }
                    System.out.println("FONT ZOOM " + d2);
                    a.c.a.a.a(d2);
                    b_0.a(d2);
                }
                catch (NumberFormatException numberFormatException) {
                    System.out.println("INVALID NUMBER FORMAT: " + string);
                }
            }
            ++n2;
        }
        if (d2 == 0.0 && (d2 = a.c.a.a.e()) != 0.0 && d2 != 1.0) {
            b_0.a(d2);
        }
        int n3 = 0;
        do {
            ++n3;
            n2 = j.a();
            if (n2 != 0) {
                if (n2 == 1) {
                    String string = c.a("abpFirstRunQuestion");
                    int n4 = JOptionPane.showConfirmDialog(null, string, "AlgoBuild", 0, 3);
                    if (n4 == 0) {
                        l.a();
                        n2 = -1;
                    } else {
                        System.exit(n2);
                    }
                }
                if (n2 != 2) continue;
                String string = c.a("abpConfigurationWrong");
                JOptionPane.showMessageDialog(null, string, "AlgoBuild", 0);
                System.exit(n2);
                continue;
            }
            SwingUtilities.invokeLater(new B());
        } while (n2 == -1 && n3 < 2);
    }

    public static void a(double d2) {
        if (d2 < 0.1 || d2 > 10.0) {
            System.out.println("INVALID ZOOM RATIO: " + d2);
        }
        UIDefaults uIDefaults = UIManager.getLookAndFeelDefaults();
        Enumeration enumeration = uIDefaults.keys();
        while (enumeration.hasMoreElements()) {
            Object k2 = enumeration.nextElement();
            Object object = uIDefaults.get(k2);
            if (!(object instanceof FontUIResource)) continue;
            object = (FontUIResource)object;
            object = new FontUIResource(((Font)object).getName(), ((Font)object).getStyle(), (int)((double)((Font)object).getSize() * d2));
            uIDefaults.put(k2, object);
        }
    }

    public static double e() {
        double d2 = 1.0;
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        double d3 = dimension.getHeight();
        int n2 = Toolkit.getDefaultToolkit().getScreenResolution();
        System.out.println("SCREEN HEIGHT = " + d3);
        System.out.println("SCREEN RESOLUTION dpi = " + n2);
        UIDefaults uIDefaults = UIManager.getLookAndFeelDefaults();
        Enumeration enumeration = uIDefaults.get("Panel.font");
        if (enumeration != null) {
            double d4;
            enumeration = (FontUIResource)((Object)enumeration);
            double d5 = 25.4 / (double)n2 * (double)((Font)((Object)enumeration)).getSize();
            if (d4 < 3.0) {
                System.out.println("ACTUAL ROW SIZE (mm) " + d5);
                d2 = d3 / 64.0 / (double)((Font)((Object)enumeration)).getSize();
                System.out.println("HIGH RESOLUTION DISPLAY - APPLY ZOOM FACTOR: " + d2);
            }
        }
        if (d2 != 1.0) {
            enumeration = uIDefaults.keys();
            while (enumeration.hasMoreElements()) {
                Object k2 = enumeration.nextElement();
                Object object = uIDefaults.get(k2);
                if (!(object instanceof FontUIResource)) continue;
                FontUIResource fontUIResource = (FontUIResource)object;
                fontUIResource = new FontUIResource(fontUIResource.getName(), fontUIResource.getStyle(), (int)((double)fontUIResource.getSize() * d2));
                uIDefaults.put(k2, fontUIResource);
            }
        }
        return d2;
    }

    public static JButton d(String object) {
        char c2 = '\u0000';
        if (((String)object).contains("&&")) {
            int n2 = ((String)object).indexOf("&&");
            if (n2 + 2 < ((String)object).length()) {
                c2 = ((String)object).charAt(n2 + 2);
            }
            object = ((String)object).replace("&&", "");
        }
        object = new JButton((String)object);
        if (c2 != '\u0000') {
            ((AbstractButton)object).setMnemonic(c2);
        }
        return object;
    }
}

