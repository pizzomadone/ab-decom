/*
 * Decompiled with CFR 0.152.
 */
package com.algobuild.core.blocks;

import a.c.a.b;
import a.c.a.d;
import a.c.b.k;
import c.g;

public final class i
extends k {
    public i(String string) {
        super(string);
    }

    public i() {
        super(null);
    }

    @Override
    public final int a(b b2, int n2) {
        String[] stringArray = this.l();
        int n3 = 0;
        while (stringArray != null && n3 < stringArray.length) {
            String string;
            block12: {
                string = null;
                string = b2.e("Input richiesto");
                if (!string.equals("execPause")) break block12;
                return 0;
            }
            try {
                double d2;
                Object object;
                System.out.println("DOING INPUT: ..... parts[i]=" + stringArray[n3]);
                if (stringArray[n3].toUpperCase().startsWith("DOUBLE ")) {
                    object = stringArray[n3].substring(7);
                    d2 = Double.parseDouble(string);
                    object = String.valueOf(object) + "=" + d2;
                    System.out.println("IS DOUBLE");
                } else if (stringArray[n3].toUpperCase().startsWith("INT ")) {
                    object = stringArray[n3].substring(4);
                    int n4 = Integer.parseInt(string);
                    object = String.valueOf(object) + "=" + n4;
                    System.out.println("IS INT");
                } else if (stringArray[n3].toUpperCase().startsWith("STRING ")) {
                    object = stringArray[n3].substring(7);
                    object = String.valueOf(object) + "=\"" + string + "\"";
                    System.out.println("IS STRING");
                } else {
                    object = stringArray[n3];
                    d2 = Double.parseDouble(string);
                    object = String.valueOf(object) + "=" + d2;
                    System.out.println("ELSE... IS DOUBLE");
                }
                System.out.println("INPUT TEST: assignCommand:" + (String)object);
                object = b2.e().a((String)object, b2.c());
                b2.h("INPUT: " + stringArray[n3] + "   VALUE: " + object);
                b2.g(object.toString());
            }
            catch (NullPointerException nullPointerException) {
                b2.i("INVALID INPUT !");
                return -2;
            }
            catch (NumberFormatException numberFormatException) {
                b2.i("INVALID INPUT NUMBER " + string);
                return -2;
            }
            catch (g g2) {
                b2.i("INPUT ERROR: " + g2 + " IN " + stringArray[n3]);
                return -2;
            }
            ++n3;
        }
        b2.i();
        return -1;
    }

    @Override
    public final String toString() {
        return this.n() + "- ABIIOInput: " + this.k().replace("\n", ", ") + "\n";
    }

    @Override
    public final d e() {
        i i2 = new i(this.k());
        return i2;
    }

    @Override
    protected final String g() {
        return "ABIINP";
    }
}

