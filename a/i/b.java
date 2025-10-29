/*
 * Decompiled with CFR 0.152.
 */
package a.i;

import java.net.URL;
import javax.swing.ImageIcon;

public final class b {
    private static b a = new b();

    public static ImageIcon a(String object) {
        ImageIcon imageIcon = null;
        try {
            ClassLoader classLoader = a.getClass().getClassLoader();
            object = classLoader.getResource((String)object);
            imageIcon = new ImageIcon((URL)object);
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
        }
        return imageIcon;
    }
}

