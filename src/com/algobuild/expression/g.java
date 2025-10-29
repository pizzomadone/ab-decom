/*
 * Decompiled with CFR 0.152.
 */
package com.algobuild.expression;

public final class g
extends Exception {
    private int a;
    private String b;

    public g(int n2, String string) {
        this.a = n2;
        this.b = String.format(g.a(this.a), string);
    }

    public g(int n2) {
        this.a = 450;
        this.b = g.a(this.a);
    }

    public g(int n2, int n3, int n4, String string) {
        this.a = n4;
        String string2 = g.a(this.a);
        this.b = String.format(string2, string);
    }

    public g(int n2, int n3, int n4) {
        this.a = n4;
        this.b = g.a(this.a);
    }

    private static String a(int n2) {
        switch (n2) {
            case 1: {
                return "Syntax error in part \"%1s\"";
            }
            case 2: {
                return "Syntax error";
            }
            case 3: {
                return "Parentesis ) missing";
            }
            case 4: {
                return "Empty expression";
            }
            case 5: {
                return "Unexpected part \"%1s\"";
            }
            case 6: {
                return "Unexpected end of expression";
            }
            case 7: {
                return "Value expected";
            }
            case 10: {
                return "Wrong value in part \"%1s\"";
            }
            case 101: {
                return "Unknown operator %1s";
            }
            case 102: {
                return "Unknown function %1s";
            }
            case 103: {
                return "Unknown variable %1s";
            }
            case 104: {
                return "Unknown operator";
            }
            case 105: {
                return "Mismatch type %1s";
            }
            case 106: {
                return "Unknown array %1s";
            }
            case 107: {
                return "Unknown array index %1s";
            }
            case 108: {
                return "Mismatch type in expression";
            }
            case 110: {
                return "Missing parameter/s";
            }
            case 111: {
                return "Unexpected function parameter %1s";
            }
            case 200: {
                return "Too long expression, maximum number of characters exceeded";
            }
            case 220: {
                return "Defining reserved name  %1s  failed";
            }
            case 400: {
                return "Integer value expected in function %1s";
            }
            case 500: {
                return "%1s";
            }
            case 450: {
                return "Array index out of range";
            }
        }
        return "Unknown error";
    }

    @Override
    public final String toString() {
        return this.b;
    }
}

