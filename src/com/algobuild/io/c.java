/*
 * Decompiled with CFR 0.152.
 */
package com.algobuild.io;

import a.f.d;
import a.f.e;
import a.f.k;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.UUID;
import javax.crypto.Cipher;

public final class c {
    private static String a = "RSA";
    private static String b = "RSA/ECB/PKCS1PADDING";
    private static int c = 1024;
    private int d = 11;
    private boolean e = false;
    private Key f = null;
    private Cipher g = null;
    private int h = -1;
    private File i;
    private int j = 0;
    private String k;
    private String l = null;

    public c(File file, int n2) {
        this.i = file;
        if (n2 == 0) {
            this.h = n2;
            this.c();
            return;
        }
        if (n2 == 1) {
            this.h = n2;
            this.c();
        }
    }

    public c(File file, int n2, String string) {
        this.i = file;
        this.h = 2;
        this.k = "tmp-" + Integer.toString(a.f.k.a(string), 9);
        this.l = string;
        this.c();
    }

    private void c() {
        Object object;
        try {
            Object object2;
            byte[] byArray;
            UUID uUID;
            UUID uUID2;
            byte by;
            byte by2;
            byte by3;
            Object object3;
            object = this;
            if (((c)object).h == 0) {
                object3 = new DataInputStream(new FileInputStream(((c)object).i));
                byte by4 = ((DataInputStream)object3).readByte();
                by3 = ((DataInputStream)object3).readByte();
                by2 = ((DataInputStream)object3).readByte();
                by = ((DataInputStream)object3).readByte();
                long l2 = ((DataInputStream)object3).readLong();
                long l3 = ((DataInputStream)object3).readLong();
                uUID2 = new UUID(l2, l3);
                l2 = ((DataInputStream)object3).readLong();
                l3 = ((DataInputStream)object3).readLong();
                UUID uUID3 = new UUID(l2, l3);
                uUID = a.f.k.a().e();
                UUID uUID4 = a.f.k.a().f();
                byArray = new byte[(int)((c)object).i.length() - 36];
                ((DataInputStream)object3).read(byArray);
                ((FilterInputStream)object3).close();
                if (by4 != -85 || by3 != -49 || by2 != 1 || by != 2 || !uUID2.equals(uUID) || !uUID3.equals(uUID4)) {
                    throw new e(a.i.c.a("abpErrorConfigFile"));
                }
                object3 = KeyFactory.getInstance(a);
                object2 = new PKCS8EncodedKeySpec(byArray);
                ((c)object).f = ((KeyFactory)object3).generatePrivate((KeySpec)object2);
                super.a(true);
            }
            if (((c)object).h == 1) {
                object3 = new DataInputStream(new FileInputStream(((c)object).i));
                byte by5 = ((DataInputStream)object3).readByte();
                by3 = ((DataInputStream)object3).readByte();
                by2 = ((DataInputStream)object3).readByte();
                by = ((DataInputStream)object3).readByte();
                long l4 = ((DataInputStream)object3).readLong();
                long l5 = ((DataInputStream)object3).readLong();
                uUID2 = new UUID(l4, l5);
                l4 = ((DataInputStream)object3).readLong();
                l5 = ((DataInputStream)object3).readLong();
                UUID uUID5 = new UUID(l4, l5);
                uUID = a.f.k.a().e();
                UUID uUID6 = a.f.k.a().f();
                byArray = new byte[(int)((c)object).i.length() - 36];
                ((DataInputStream)object3).read(byArray);
                ((FilterInputStream)object3).close();
                if (by5 != -85 || by3 != -49 || by2 != 1 || by != 1 || !uUID2.equals(uUID) || !uUID5.equals(uUID6)) {
                    throw new e(a.i.c.a("abpErrorConfigFile"));
                }
                object3 = KeyFactory.getInstance(a);
                object2 = new X509EncodedKeySpec(byArray);
                ((c)object).f = ((KeyFactory)object3).generatePublic((KeySpec)object2);
                super.a(true);
            }
            if (((c)object).h == 2) {
                object3 = new File(((c)object).i, ((c)object).k);
                if (((File)object3).exists()) {
                    FileInputStream fileInputStream = new FileInputStream((File)object3);
                    object2 = new byte[(int)((File)object3).length()];
                    fileInputStream.read((byte[])object2);
                    fileInputStream.close();
                } else {
                    object2 = a.f.d.a(a.f.k.a().b(), ((c)object).l);
                    if (object2 != null && ((byte[])object2).length > 0) {
                        FileOutputStream fileOutputStream = new FileOutputStream((File)object3);
                        fileOutputStream.write((byte[])object2);
                        fileOutputStream.close();
                    } else {
                        System.out.println("EWRROR DOWNLOADING PUBLIC_EXTERNAL_KEY key: " + ((c)object).l);
                    }
                }
                if (object2 != null && ((byte[])object2).length > 0) {
                    KeyFactory keyFactory = KeyFactory.getInstance(a);
                    X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec((byte[])object2);
                    ((c)object).f = keyFactory.generatePublic(x509EncodedKeySpec);
                    super.a(true);
                }
            }
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            object = noSuchAlgorithmException;
            noSuchAlgorithmException.printStackTrace();
        }
        catch (InvalidKeySpecException invalidKeySpecException) {
            object = invalidKeySpecException;
            invalidKeySpecException.printStackTrace();
        }
        catch (IOException iOException) {}
        if (this.d()) {
            if (this.h == 0) {
                object = new byte[]{1, 1, 1};
                this.a((byte[])object);
                return;
            }
        } else {
            System.out.println("ERROR: Key not loaded!!! " + this.i.getAbsolutePath());
        }
    }

    public final byte[] a() {
        return this.f.getEncoded();
    }

    public static void a(UUID object, UUID uUID, File comparable, File object2) {
        try {
            Object object3 = KeyPairGenerator.getInstance(a);
            ((KeyPairGenerator)object3).initialize(c);
            KeyPair keyPair = ((KeyPairGenerator)object3).genKeyPair();
            object3 = keyPair;
            object3 = object2;
            object2 = comparable;
            comparable = uUID;
            uUID = object;
            object = keyPair;
            PrivateKey privateKey = keyPair.getPrivate();
            object = ((KeyPair)object).getPublic();
            object = new X509EncodedKeySpec(object.getEncoded());
            object2 = new DataOutputStream(new FileOutputStream((File)object2));
            ((DataOutputStream)object2).write(171);
            ((DataOutputStream)object2).write(207);
            ((DataOutputStream)object2).write(1);
            ((DataOutputStream)object2).write(1);
            ((DataOutputStream)object2).writeLong(uUID.getMostSignificantBits());
            ((DataOutputStream)object2).writeLong(uUID.getLeastSignificantBits());
            ((DataOutputStream)object2).writeLong(((UUID)comparable).getMostSignificantBits());
            ((DataOutputStream)object2).writeLong(((UUID)comparable).getLeastSignificantBits());
            ((FilterOutputStream)object2).write(((X509EncodedKeySpec)object).getEncoded());
            ((FilterOutputStream)object2).close();
            object = new PKCS8EncodedKeySpec(privateKey.getEncoded());
            object2 = new DataOutputStream(new FileOutputStream((File)object3));
            ((DataOutputStream)object2).write(171);
            ((DataOutputStream)object2).write(207);
            ((DataOutputStream)object2).write(1);
            ((DataOutputStream)object2).write(2);
            ((DataOutputStream)object2).writeLong(uUID.getMostSignificantBits());
            ((DataOutputStream)object2).writeLong(uUID.getLeastSignificantBits());
            ((DataOutputStream)object2).writeLong(((UUID)comparable).getMostSignificantBits());
            ((DataOutputStream)object2).writeLong(((UUID)comparable).getLeastSignificantBits());
            ((FilterOutputStream)object2).write(((PKCS8EncodedKeySpec)object).getEncoded());
            ((FilterOutputStream)object2).close();
            return;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            NoSuchAlgorithmException noSuchAlgorithmException2 = noSuchAlgorithmException;
            noSuchAlgorithmException.printStackTrace();
            return;
        }
        catch (IOException iOException) {
            IOException iOException2 = iOException;
            iOException.printStackTrace();
            return;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean d() {
        c c2 = this;
        synchronized (c2) {
            return this.e;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void a(boolean bl) {
        c c2 = this;
        synchronized (c2) {
            this.e = true;
            return;
        }
    }

    public final byte[] a(byte[] byArray) {
        if (this.h == -1) {
            return null;
        }
        if (!this.d()) {
            return null;
        }
        int n2 = c / 8;
        int n3 = n2 - this.d;
        int n4 = this.h == 0 ? (byArray.length + n3 - 1) / n3 * n2 : (byArray.length + n2 - 1) / n2 * n2;
        byte[] byArray2 = new byte[n4];
        try {
            if (this.g == null) {
                this.g = Cipher.getInstance(b);
            }
            if (this.h == 0) {
                this.g.init(1, this.f);
                int n5 = byArray.length;
                int n6 = 0;
                int n7 = Math.min(n5, n3);
                int n8 = 0;
                while (n5 > 0) {
                    n2 = this.g.doFinal(byArray, n6, n7, byArray2, n8);
                    n6 += n3;
                    n7 = Math.min(n5 -= n3, n3);
                    n8 += n2;
                }
                this.j = n8;
            } else {
                this.g.init(2, this.f);
                int n9 = byArray.length;
                int n10 = 0;
                int n11 = Math.min(n9, n2);
                int n12 = 0;
                while (n9 > 0) {
                    n3 = this.g.doFinal(byArray, n10, n11, byArray2, n12);
                    n10 += n2;
                    n11 = Math.min(n9 -= n2, n2);
                    n12 += n3;
                }
                this.j = n12;
            }
        }
        catch (Exception exception) {
            Exception exception2 = exception;
            exception.printStackTrace();
        }
        return byArray2;
    }

    public final int b() {
        return this.j;
    }
}

