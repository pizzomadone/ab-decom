/*
 * AlgoBuild - Decompiled and Refactored
 *
 * Original location: b/a/J.java
 * Description: JSON library component
 *
 * NOTE: Internal method/variable names (a, b, c, etc.) are kept from decompiled code.
 *       Class names and package structure have been refactored for readability.
 */

package com.algobuild.json;

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

