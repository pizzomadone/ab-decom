/*
 * Decompiled with CFR 0.152.
 */
package com.algobuild.io;

import a.d.a;
import a.d.d;
import a.d.e;
import a.d.g;
import a.f.c;
import a.f.j;
import a.h.b;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.UUID;

public final class l {
    private static int a = -1;

    /*
     * Unable to fully structure code
     */
    public static int a() {
        block21: {
            if (l.a != -1) break block21;
            l.a = 0;
            l.a(0);
            var0 = j.c();
            if (var0.exists() && var0.isDirectory()) {
                v0 = true;
            } else {
                var0.mkdirs();
                v0 = var0.exists() != false && var0.isDirectory() != false;
            }
            if (v0) {
                l.a(10);
            } else {
                l.a = 1;
            }
            if (l.a == 0 && l.c()) {
                l.a(20);
            } else {
                l.a = 3;
            }
            if (l.a == 0 && l.d()) {
                l.a(30);
            } else {
                l.a = 2;
            }
            if (l.a != 0) ** GOTO lbl-1000
            var0 = j.f();
            if (var0.exists() && var0.isDirectory()) {
                v1 = true;
            } else {
                var0.mkdirs();
                v1 = var0.exists() != false && var0.isDirectory() != false;
            }
            if (v1) {
                l.a(40);
            } else lbl-1000:
            // 2 sources

            {
                l.a = 4;
            }
            if (l.a != 0) ** GOTO lbl-1000
            var0 = j.e();
            if (var0.exists() && var0.isDirectory()) {
                v2 = true;
            } else {
                var0.mkdirs();
                v2 = var0.exists() != false && var0.isDirectory() != false;
            }
            if (v2) {
                l.a(50);
            } else lbl-1000:
            // 2 sources

            {
                l.a = 4;
            }
            if (l.a == 0) {
                l.b();
                l.a(100);
            } else {
                l.a = 6;
            }
            if (l.a == 0) {
                var0_1 = 200L;
                try {
                    Thread.sleep(200L);
                }
                catch (InterruptedException v3) {}
            }
            System.out.println("Config Progress Complete");
        }
        return l.a;
    }

    private static boolean b() {
        UUID uUID = UUID.randomUUID();
        Object object = System.getProperties().getProperty(new String(new b().b()));
        try {
            object = UUID.nameUUIDFromBytes(((String)object).getBytes("UTF-8"));
            File file = new File(j.e(), new String(new e().b()));
            File file2 = new File(j.e(), new String(new d().b()));
            c.a(uUID, (UUID)object, file, file2);
            l.a(50);
            file = new File(j.e(), new String(new g().b()));
            l.a(uUID, (UUID)object, file);
            l.a(60);
            file = new File(j.e(), new String(new a.d.b().b()));
            l.a(uUID, (UUID)object, file);
            l.a(70);
            file = new File(j.e(), new String(new a.d.c().b()));
            l.a(uUID, (UUID)object, file);
            l.a(80);
            file = new File(j.e(), new String(new a().b()));
            l.b(uUID, (UUID)object, file);
            l.a(100);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            UnsupportedEncodingException unsupportedEncodingException2 = unsupportedEncodingException;
            unsupportedEncodingException.printStackTrace();
        }
        return true;
    }

    private static boolean a(UUID serializable, UUID uUID, File object) {
        boolean bl = false;
        try {
            object = new DataOutputStream(new FileOutputStream((File)object));
            ((DataOutputStream)object).write(171);
            ((DataOutputStream)object).write(207);
            ((DataOutputStream)object).write(1);
            ((DataOutputStream)object).write(3);
            ((DataOutputStream)object).writeLong(((UUID)serializable).getMostSignificantBits());
            ((DataOutputStream)object).writeLong(((UUID)serializable).getLeastSignificantBits());
            ((DataOutputStream)object).writeLong(uUID.getMostSignificantBits());
            ((DataOutputStream)object).writeLong(uUID.getLeastSignificantBits());
            int n2 = 0;
            while (n2 < 123) {
                ((DataOutputStream)object).write((byte)(Math.random() * 256.0));
                ++n2;
            }
            ((FilterOutputStream)object).close();
            bl = true;
        }
        catch (FileNotFoundException fileNotFoundException) {
            serializable = fileNotFoundException;
            fileNotFoundException.printStackTrace();
        }
        catch (IOException iOException) {
            serializable = iOException;
            iOException.printStackTrace();
        }
        return bl;
    }

    private static boolean c() {
        boolean bl = false;
        File file = j.c();
        int n2 = (int)(Math.random() * 100000.0);
        file = new File(file, "tmp-test-" + n2);
        byte[] byArray = new byte[100];
        Arrays.fill(byArray, (byte)0);
        int n3 = 0;
        while (n3 < 50) {
            byArray[n3] = (byte)(Math.random() * 256.0 - 128.0);
            ++n3;
        }
        try {
            Closeable closeable = new FileOutputStream(file);
            ((FileOutputStream)closeable).write(byArray, 0, 50);
            ((FileOutputStream)closeable).close();
            closeable = new FileInputStream(file);
            ((FileInputStream)closeable).read(byArray, 50, 50);
            ((FileInputStream)closeable).close();
            System.out.println("temp write:" + file.getAbsolutePath());
            file.delete();
            bl = true;
            int n4 = 0;
            while (n4 < 50 && bl) {
                bl = byArray[n4] == byArray[n4 + 50];
                ++n4;
            }
        }
        catch (FileNotFoundException fileNotFoundException) {
            FileNotFoundException fileNotFoundException2 = fileNotFoundException;
            fileNotFoundException.printStackTrace();
        }
        catch (IOException iOException) {
            IOException iOException2 = iOException;
            iOException.printStackTrace();
        }
        return bl;
    }

    private static boolean d() {
        File file = j.d();
        if (file.exists() && file.isDirectory()) {
            return true;
        }
        file.mkdirs();
        String string = System.getProperty("os.name");
        if (string != null && string.toLowerCase().contains("win")) {
            string = "attrib +H " + file;
            try {
                Runtime.getRuntime().exec(string);
            }
            catch (IOException iOException) {}
        }
        return file.exists() && file.isDirectory();
    }

    private static void a(int n2) {
        System.out.println("Config Progress Update % " + n2);
    }

    private static boolean b(UUID serializable, UUID uUID, File object) {
        boolean bl = false;
        try {
            object = new DataOutputStream(new FileOutputStream((File)object));
            ((DataOutputStream)object).write(171);
            ((DataOutputStream)object).write(207);
            ((DataOutputStream)object).write(1);
            ((DataOutputStream)object).write(4);
            ((DataOutputStream)object).writeLong(((UUID)serializable).getMostSignificantBits());
            ((DataOutputStream)object).writeLong(((UUID)serializable).getLeastSignificantBits());
            ((DataOutputStream)object).writeLong(uUID.getMostSignificantBits());
            ((DataOutputStream)object).writeLong(uUID.getLeastSignificantBits());
            ((DataOutputStream)object).writeInt(0);
            ((DataOutputStream)object).writeInt(0);
            int n2 = 128 + (int)(Math.random() * 256.0);
            int n3 = 0;
            while (n3 < n2) {
                ((DataOutputStream)object).write((byte)(Math.random() * 256.0));
                ++n3;
            }
            ((FilterOutputStream)object).close();
            bl = true;
        }
        catch (FileNotFoundException fileNotFoundException) {
            serializable = fileNotFoundException;
            fileNotFoundException.printStackTrace();
        }
        catch (IOException iOException) {
            serializable = iOException;
            iOException.printStackTrace();
        }
        return bl;
    }
}

