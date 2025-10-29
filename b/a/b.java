/*
 * Decompiled with CFR 0.152.
 */
package b.a;

public final class b
extends RuntimeException {
    private Throwable a;

    public b(String string) {
        super(string);
    }

    public b(Throwable throwable) {
        super(throwable.getMessage());
        this.a = throwable;
    }

    @Override
    public final Throwable getCause() {
        return this.a;
    }
}

