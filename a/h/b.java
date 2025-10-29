/*
 * Decompiled with CFR 0.152.
 */
package a.h;

import a.e.a;

public final class b
extends a {
    @Override
    protected final int a() {
        return 9;
    }

    @Override
    protected final char a(int n2) {
        char c2 = '\u0000';
        switch (n2) {
            case 6: {
                c2 = 'a';
                break;
            }
            case 2: 
            case 8: {
                c2 = 'e';
                break;
            }
            case 0: {
                c2 = 'u';
                break;
            }
            case 1: {
                c2 = 's';
                break;
            }
            case 3: {
                c2 = 'r';
                break;
            }
            case 4: {
                c2 = '.';
                break;
            }
            case 7: {
                c2 = 'm';
                break;
            }
            case 5: {
                c2 = 'n';
            }
        }
        return c2;
    }
}

