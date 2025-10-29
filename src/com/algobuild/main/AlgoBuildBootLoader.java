/*
 * Decompiled with CFR 0.152.
 */
import com.algobuild.core.Application;
import java.io.File;
package com.algobuild.main;

public class AlgoBuildBootLoader {
    public static void main(String[] stringArray) {
        File file = new File(System.getProperty("java.class.path"));
        if (file.isFile()) {
            try {
                Thread.sleep(500L);
            }
            catch (InterruptedException interruptedException) {}
        }
        a.a(stringArray);
    }
}
package com.algobuild.main;

