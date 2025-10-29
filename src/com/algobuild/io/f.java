/*
 * Decompiled with CFR 0.152.
 */
package com.algobuild.io;

import a.d.d;
import a.d.e;
import a.f.a;
import a.f.b;
import a.f.c;
import a.f.h;
import a.f.j;
import a.f.k;
import b.a.g;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.UUID;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public final class f
implements Runnable {
    private static f a = null;
    private c b = null;
    private c c = null;

    public static f a() {
        if (a == null) {
            a = new f();
        }
        return a;
    }

    private f() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public final void run() {
        System.currentTimeMillis();
        Object object = new File(j.e(), new String(new e().b()));
        File file = new File(j.e(), new String(new d().b()));
        this.c = object = new c((File)object, 1);
        this.b = object = new c(file, 0);
        System.currentTimeMillis();
    }

    public final void a(String object, b.a.c object2) {
        Object object3 = k.a();
        if (object3 == null) {
            throw new h(String.valueOf(a.i.c.a("abpErrorConfigFile")) + " system configuration NON LOADED");
        }
        if (object == null) {
            throw new h(String.valueOf(a.i.c.a("abpErrorWritingFile")) + " file name is NULL");
        }
        if (this.b == null) {
            throw new h(String.valueOf(a.i.c.a("abpErrorWritingFile")) + " ENCODER not READY");
        }
        Object object4 = new b.a.c();
        ((b.a.c)object4).b("abuid", ((k)object3).e().toString());
        String string = ((k)object3).b();
        if (string != null) {
            ((b.a.c)object4).b("abusn", string);
        }
        if ((object3 = ((k)object3).d()) != null) {
            ((b.a.c)object4).b("abuan", object3);
        }
        object3 = f.a((b.a.c)object4);
        object2 = f.a((b.a.c)object2);
        try {
            object = new b((String)object);
            object = new ZipOutputStream(new BufferedOutputStream((OutputStream)object));
            object4 = "fd";
            object4 = new ZipEntry((String)object4);
            ((ZipOutputStream)object).putNextEntry((ZipEntry)object4);
            ((FilterOutputStream)object).write((byte[])object3);
            ((DeflaterOutputStream)object).flush();
            object3 = "fc";
            object3 = new ZipEntry((String)object3);
            ((ZipOutputStream)object).putNextEntry((ZipEntry)object3);
            object2 = this.b.a((byte[])object2);
            ((ZipOutputStream)object).write((byte[])object2, 0, ((Object)object2).length);
            ((DeflaterOutputStream)object).flush();
            ((ZipOutputStream)object).close();
            return;
        }
        catch (FileNotFoundException fileNotFoundException) {
            object = fileNotFoundException;
            fileNotFoundException.printStackTrace();
            return;
        }
        catch (IOException iOException) {
            object = iOException;
            iOException.printStackTrace();
            return;
        }
    }

    public final b.a.c a(String string) {
        Object object = null;
        if (string == null) {
            throw new h(String.valueOf(a.i.c.a("abpErrorReadingFile")) + " NULL");
        }
        if (this.c == null) {
            throw new h(String.valueOf(a.i.c.a("abpErrorReadingFile")) + " DECODER not READY");
        }
        try {
            ZipEntry zipEntry;
            InputStream inputStream = new a(string);
            inputStream = new ZipInputStream(new BufferedInputStream(inputStream));
            byte[] byArray = new byte[50000];
            int n2 = 0;
            String string2 = null;
            while ((zipEntry = ((ZipInputStream)inputStream).getNextEntry()) != null) {
                int n3;
                Object object2;
                Object object3;
                Object object4;
                if (zipEntry.getName().equals("fd")) {
                    object4 = new InputStreamReader(inputStream);
                    object3 = new b.a.f((Reader)object4);
                    object4 = new b.a.c((b.a.f)object3);
                    object3 = ((b.a.c)object4).a("abuid", null);
                    object2 = ((b.a.c)object4).a("abuan", null);
                    string2 = ((b.a.c)object4).a("abusn", null);
                    if (string2 != null) {
                        n2 = k.a(string2);
                    }
                    if (object3 == null) {
                        throw new h(String.valueOf(a.i.c.a("abpErrorReadingFile")) + " ID not present");
                    }
                    object4 = UUID.fromString((String)object3);
                    object3 = k.a().e();
                    if (!((UUID)object3).equals(object4) && object2 == null) {
                        throw new h(a.i.c.a("abpCannotReadOtherUserPrivateFile"));
                    }
                }
                if (!zipEntry.getName().equals("fc")) continue;
                int n4 = 0;
                do {
                    if ((n3 = ((ZipInputStream)inputStream).read(byArray, n4, 50000 - n4)) <= 0) continue;
                    n4 += n3;
                } while (n3 > 0);
                byArray = Arrays.copyOf(byArray, n4);
                if (n2 > 0 && n2 != k.a().c()) {
                    j.b();
                    object2 = new c(j.f(), 2, string2);
                    object4 = ((c)object2).a(byArray);
                    object4 = new ByteArrayInputStream((byte[])object4, 0, ((c)object2).b());
                    object3 = new InputStreamReader((InputStream)object4, "UTF-8");
                    object = new b.a.f((Reader)object3);
                    object = new b.a.c((b.a.f)object);
                    continue;
                }
                object4 = this.c.a(byArray);
                object3 = new ByteArrayInputStream((byte[])object4, 0, this.c.b());
                object2 = new InputStreamReader((InputStream)object3, "UTF-8");
                object4 = new b.a.f((Reader)object2);
                object = new b.a.c((b.a.f)object4);
            }
            ((ZipInputStream)inputStream).close();
        }
        catch (h h2) {
            h h3 = h2;
            throw h2;
        }
        catch (Exception exception) {
            throw new h(String.valueOf(a.i.c.a("abpErrorReadingFile")) + string);
        }
        return object;
    }

    private static byte[] a(b.a.c object) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1000);
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter((OutputStream)byteArrayOutputStream, "UTF-8");
            g g2 = new g(outputStreamWriter);
            g2.b();
            Object object2 = ((b.a.c)object).a();
            Iterator iterator = object2.iterator();
            while (iterator.hasNext()) {
                object2 = (String)iterator.next();
                g2.a((String)object2);
                g2.a(((b.a.c)object).c((String)object2));
            }
            g2.a();
            outputStreamWriter.flush();
            object = byteArrayOutputStream.toByteArray();
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new h(a.i.c.a("abpErrorWritingFile"), unsupportedEncodingException);
        }
        catch (IOException iOException) {
            throw new h(a.i.c.a("abpErrorWritingFile"));
        }
        return object;
    }

    public final byte[] b() {
        return this.c.a();
    }
}

