/*
 * Decompiled with CFR 0.152.
 */
package a.f;

import a.d.a;
import a.d.f;
import a.d.g;
import a.f.e;
import a.f.h;
import a.f.j;
import a.h.b;
import a.i.c;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.UUID;

public final class k {
    private static k a = null;
    private char[] b;
    private String c = null;
    private int d = 0;
    private UUID e;
    private UUID f;
    private String g = null;
    private String h = "https://algobuild.com/abkg/ab0080keygen.php";

    public static k a() {
        if (a == null) {
            a = new k();
        }
        return a;
    }

    private k() {
        Object object = this;
        Object object2 = new File(j.e(), new String(new g().b()));
        try {
            object2 = new DataInputStream(new FileInputStream((File)object2));
            byte by = ((DataInputStream)object2).readByte();
            byte by2 = ((DataInputStream)object2).readByte();
            byte by3 = ((DataInputStream)object2).readByte();
            byte by4 = ((DataInputStream)object2).readByte();
            long l2 = ((DataInputStream)object2).readLong();
            long l3 = ((DataInputStream)object2).readLong();
            ((k)object).e = new UUID(l2, l3);
            l2 = ((DataInputStream)object2).readLong();
            l3 = ((DataInputStream)object2).readLong();
            ((k)object).f = new UUID(l2, l3);
            object2 = System.getProperties().getProperty(new String(new b().b()));
            object2 = UUID.nameUUIDFromBytes(((String)object2).getBytes("UTF-8"));
            if (by != -85) {
                throw new e(String.valueOf(a.i.c.a("abpErrorConfigFile")) + " b1 " + by);
            }
            if (by2 != -49) {
                throw new e(String.valueOf(a.i.c.a("abpErrorConfigFile")) + " b2 " + by2);
            }
            if (by3 != 1) {
                throw new e(String.valueOf(a.i.c.a("abpErrorConfigFile")) + " b3 " + by3);
            }
            if (by4 != 3) {
                throw new e(String.valueOf(a.i.c.a("abpErrorConfigFile")) + " b4 " + by4);
            }
            if (!((k)object).f.equals(object2)) {
                throw new e(String.valueOf(a.i.c.a("abpErrorConfigFile")) + " UUID2");
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
        this.g();
        object = System.getProperties().getProperty(new String(new b().b()));
        this.b = new char[((String)object).length()];
        int n2 = 0;
        while (n2 < ((String)object).length()) {
            this.b[n2] = ((String)object).charAt(n2);
            ++n2;
        }
        n2 = this.h();
        object = this.b("AB0080");
        if (n2 <= 0 && object == null) {
            try {
                this.d(this.h, "AB0080");
            }
            catch (h h2) {}
        }
        if (n2 > 0 && object == null) {
            try {
                object = k.a(this.h, n2, "AB0080");
                if (object != null) {
                    this.c((String)object, "AB0080");
                } else {
                    object = k.a(n2, "AB0080");
                }
            }
            catch (h h3) {
                h h4 = h3;
                h3.printStackTrace();
            }
        }
        if (n2 <= 0 && object != null) {
            n2 = k.a((String)object);
            this.a(n2);
        }
        if (this.c == null) {
            this.c = object;
        }
        if (this.d == 0) {
            this.d = n2;
        }
    }

    private void g() {
        Object object = new File(j.e(), new String(new a().b()));
        try {
            object = new DataInputStream(new FileInputStream((File)object));
            int n2 = ((DataInputStream)object).readByte();
            byte by = ((DataInputStream)object).readByte();
            int n3 = ((DataInputStream)object).readByte();
            int n4 = ((DataInputStream)object).readByte();
            long l2 = ((DataInputStream)object).readLong();
            long l3 = ((DataInputStream)object).readLong();
            this.e = new UUID(l2, l3);
            l2 = ((DataInputStream)object).readLong();
            l3 = ((DataInputStream)object).readLong();
            this.f = new UUID(l2, l3);
            Object object2 = System.getProperties().getProperty(new String(new b().b()));
            object2 = UUID.nameUUIDFromBytes(((String)object2).getBytes("UTF-8"));
            if (n2 != -85) {
                throw new e(String.valueOf(a.i.c.a("abpErrorConfigFile")) + " b1 " + n2);
            }
            if (by != -49) {
                throw new e(String.valueOf(a.i.c.a("abpErrorConfigFile")) + " b2 " + by);
            }
            if (n3 != 1) {
                throw new e(String.valueOf(a.i.c.a("abpErrorConfigFile")) + " b3 " + n3);
            }
            if (n4 != 4) {
                throw new e(String.valueOf(a.i.c.a("abpErrorConfigFile")) + " b4 " + n4);
            }
            if (!this.f.equals(object2)) {
                throw new e(String.valueOf(a.i.c.a("abpErrorConfigFile")) + " UUID2");
            }
            n2 = ((DataInputStream)object).readInt();
            if (n2 > 0) {
                byte[] byArray = new byte[n2];
                n3 = 0;
                while (n3 < n2) {
                    n4 = ((DataInputStream)object).readInt();
                    n4 = n4 + 2 * n3 - 143;
                    byArray[n3] = (byte)n4;
                    ++n3;
                }
                this.g = new String(byArray, "UTF-8");
                n3 = ((DataInputStream)object).readInt();
                if (n3 > 0) {
                    byte[] byArray2 = new byte[n3];
                    n2 = 0;
                    while (n2 < n3) {
                        int n5 = ((DataInputStream)object).readInt();
                        n5 = n5 + 2 * n2 - 143;
                        byArray2[n2] = (byte)n5;
                        ++n2;
                    }
                    new String(byArray2, "UTF-8");
                    return;
                }
            }
        }
        catch (FileNotFoundException fileNotFoundException) {
            return;
        }
        catch (IOException iOException) {}
    }

    public final void a(String string, String string2) {
        if (this.b(string, string2)) {
            this.g = string;
        }
    }

    private boolean b(String object, String string) {
        boolean bl = false;
        Object object2 = new File(j.e(), new String(new a().b()));
        try {
            object2 = new DataOutputStream(new FileOutputStream((File)object2));
            ((DataOutputStream)object2).write(171);
            ((DataOutputStream)object2).write(207);
            ((DataOutputStream)object2).write(1);
            ((DataOutputStream)object2).write(4);
            ((DataOutputStream)object2).writeLong(this.e.getMostSignificantBits());
            ((DataOutputStream)object2).writeLong(this.e.getLeastSignificantBits());
            ((DataOutputStream)object2).writeLong(this.f.getMostSignificantBits());
            ((DataOutputStream)object2).writeLong(this.f.getLeastSignificantBits());
            object = ((String)object).getBytes("UTF-8");
            ((DataOutputStream)object2).writeInt(((Object)object).length);
            int n2 = 0;
            while (n2 < ((Object)object).length) {
                ((DataOutputStream)object2).writeInt((int)(object[n2] + 143 - 2 * n2));
                ++n2;
            }
            object = string.getBytes("UTF-8");
            ((DataOutputStream)object2).writeInt(((Object)object).length);
            n2 = 0;
            while (n2 < ((Object)object).length) {
                ((DataOutputStream)object2).writeInt((int)(object[n2] + 143 - 2 * n2));
                ++n2;
            }
            n2 = 0;
            while (n2 < 123) {
                ((DataOutputStream)object2).write((byte)(Math.random() * 256.0));
                ++n2;
            }
            ((FilterOutputStream)object2).close();
            bl = true;
        }
        catch (FileNotFoundException fileNotFoundException) {
            object = fileNotFoundException;
            fileNotFoundException.printStackTrace();
        }
        catch (IOException iOException) {
            object = iOException;
            iOException.printStackTrace();
        }
        return bl;
    }

    private boolean a(int n2) {
        boolean bl = false;
        Object object = new File(j.e(), new String(new f().b()));
        try {
            object = new DataOutputStream(new FileOutputStream((File)object));
            ((DataOutputStream)object).write(171);
            ((DataOutputStream)object).write(207);
            ((DataOutputStream)object).write(1);
            ((DataOutputStream)object).write(5);
            ((DataOutputStream)object).writeLong(this.e.getMostSignificantBits());
            ((DataOutputStream)object).writeLong(this.e.getLeastSignificantBits());
            ((DataOutputStream)object).writeLong(this.f.getMostSignificantBits());
            ((DataOutputStream)object).writeLong(this.f.getLeastSignificantBits());
            int n3 = 0;
            while (n3 < 7) {
                ((DataOutputStream)object).writeInt((int)(Math.random() * 2.147483647E9));
                ++n3;
            }
            ((DataOutputStream)object).writeInt(n2);
            n3 = 0;
            while (n3 < 11) {
                ((DataOutputStream)object).writeInt((int)(Math.random() * 2.147483647E9));
                ++n3;
            }
            ((FilterOutputStream)object).close();
            bl = true;
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

    private int h() {
        Object object = new File(j.e(), new String(new f().b()));
        int n2 = 0;
        try {
            object = new DataInputStream(new FileInputStream((File)object));
            int n3 = ((DataInputStream)object).readByte();
            byte by = ((DataInputStream)object).readByte();
            byte by2 = ((DataInputStream)object).readByte();
            byte by3 = ((DataInputStream)object).readByte();
            long l2 = ((DataInputStream)object).readLong();
            long l3 = ((DataInputStream)object).readLong();
            this.e = new UUID(l2, l3);
            l2 = ((DataInputStream)object).readLong();
            l3 = ((DataInputStream)object).readLong();
            this.f = new UUID(l2, l3);
            Object object2 = System.getProperties().getProperty(new String(new b().b()));
            object2 = UUID.nameUUIDFromBytes(((String)object2).getBytes("UTF-8"));
            if (n3 != -85) {
                throw new e(String.valueOf(a.i.c.a("abpErrorConfigFile")) + " b1 " + n3);
            }
            if (by != -49) {
                throw new e(String.valueOf(a.i.c.a("abpErrorConfigFile")) + " b2 " + by);
            }
            if (by2 != 1) {
                throw new e(String.valueOf(a.i.c.a("abpErrorConfigFile")) + " b3 " + by2);
            }
            if (by3 != 5) {
                throw new e(String.valueOf(a.i.c.a("abpErrorConfigFile")) + " b4 " + by3);
            }
            if (!this.f.equals(object2)) {
                throw new e(String.valueOf(a.i.c.a("abpErrorConfigFile")) + " UUID2");
            }
            n3 = 0;
            while (n3 < 7) {
                ((DataInputStream)object).readInt();
                ++n3;
            }
            n2 = ((DataInputStream)object).readInt();
            n3 = 0;
            while (n3 < 11) {
                ((DataInputStream)object).readInt();
                ++n3;
            }
        }
        catch (FileNotFoundException fileNotFoundException) {
        }
        catch (IOException iOException) {}
        return n2;
    }

    public final String b() {
        return this.c;
    }

    public final int c() {
        return this.d;
    }

    public final String d() {
        return this.g;
    }

    public final UUID e() {
        return this.e;
    }

    public final UUID f() {
        return this.f;
    }

    private static String a(String string, int n2, String string2) {
        Serializable serializable;
        String string3 = null;
        String string4 = null;
        string4 = null;
        int n3 = -1;
        int n4 = -1;
        long l2 = -1L;
        boolean bl = false;
        try {
            serializable = new URL(string);
            serializable = InetAddress.getByName(serializable.getHost());
            bl = ((InetAddress)serializable).isReachable(10000);
        }
        catch (MalformedURLException malformedURLException) {
        }
        catch (UnknownHostException unknownHostException) {
        }
        catch (IOException iOException) {}
        if (bl) {
            System.out.println("REACHABLE   ");
            try {
                int n5;
                int n6;
                Object object;
                serializable = new URL(string);
                Object object2 = serializable.openConnection();
                ((URLConnection)object2).setReadTimeout(10000);
                ((URLConnection)object2).setRequestProperty("Cookie", "abver=" + string2 + "; pass=1");
                ((URLConnection)object2).connect();
                int n7 = 1;
                while ((object = ((URLConnection)object2).getHeaderFieldKey(n7)) != null) {
                    if (((String)object).equals("Set-Cookie")) {
                        String string5 = ((URLConnection)object2).getHeaderField(n7);
                        if (string5.startsWith("PHPSESSID=")) {
                            string4 = string5.substring(10, string5.indexOf(";"));
                        }
                        if (string5.startsWith("x=")) {
                            n3 = n6 = Integer.parseInt(string5.substring(2, string5.indexOf(";")));
                        }
                        if (string5.startsWith("y=")) {
                            n4 = n6 = Integer.parseInt(string5.substring(2, string5.indexOf(";")));
                        }
                        if (string5.startsWith("k=")) {
                            n6 = Integer.parseInt(string5.substring(2, string5.indexOf(";")));
                            l2 = n6;
                        }
                    }
                    ++n7;
                }
                InputStream inputStream = ((URLConnection)object2).getInputStream();
                while ((n5 = inputStream.read()) != -1) {
                    if (n5 == 10 || n5 >= 32 && n5 < 128) {
                        System.out.print((char)n5);
                        continue;
                    }
                    System.out.println("[" + n5 + "]");
                }
                inputStream.close();
                int n8 = n3 + n4 * 10000 ^ 0x313C578;
                if (n3 > 0 && n4 > 0 && l2 == -1L && string4 != null) {
                    int n9;
                    String string6;
                    object2 = new URL(string);
                    object = ((URL)object2).openConnection();
                    String string7 = "PHPSESSID=" + string4 + "; abver=" + string2 + "; abexistingserialnum=" + n2 + "; pass=4; k=" + n8 + ";";
                    ((URLConnection)object).setRequestProperty("Cookie", string7);
                    ((URLConnection)object).connect();
                    n6 = 1;
                    while ((string6 = ((URLConnection)object).getHeaderFieldKey(n6)) != null) {
                        if (string6.equals("Set-Cookie")) {
                            string = ((URLConnection)object).getHeaderField(n6);
                            if (string.startsWith("PHPSESSID=")) {
                                string.substring(10, string.indexOf(";"));
                            }
                            if (string.startsWith("x=")) {
                                Integer.parseInt(string.substring(2, string.indexOf(";")));
                            }
                            if (string.startsWith("y=")) {
                                Integer.parseInt(string.substring(2, string.indexOf(";")));
                            }
                            if (string.startsWith("kk=") && (n2 = string.indexOf(";")) > 3) {
                                string3 = string.substring(3, string.indexOf(";"));
                            }
                        }
                        ++n6;
                    }
                    InputStream inputStream2 = ((URLConnection)object).getInputStream();
                    while ((n9 = inputStream2.read()) != -1) {
                        if (n9 == 10 || n9 >= 32 && n9 < 128) {
                            System.out.print((char)n9);
                            continue;
                        }
                        System.out.print('.');
                    }
                    inputStream2.close();
                }
            }
            catch (MalformedURLException malformedURLException) {
                throw new h(a.i.c.a("abpErrorConfigFile"), malformedURLException);
            }
            catch (ConnectException connectException) {
            }
            catch (IOException iOException) {
                throw new h(a.i.c.a("abpErrorConfigFile"), iOException);
            }
        }
        return string3;
    }

    private void c(String string, String object) {
        File file = j.d();
        if (file.exists()) {
            try {
                object = new File(file, String.valueOf(object) + ".sn");
                object = new PrintStream((File)object);
                if (!((PrintStream)object).checkError() && string != null) {
                    long l2 = 0L;
                    int n2 = 0;
                    while (n2 < this.b.length) {
                        l2 += (long)this.b[n2];
                        ++n2;
                    }
                    n2 = 0;
                    while (n2 < string.length()) {
                        l2 += (long)string.charAt(n2);
                        ++n2;
                    }
                    ((PrintStream)object).print(string);
                    ((PrintStream)object).print(' ');
                    ((PrintStream)object).println(l2);
                }
                ((PrintStream)object).close();
                return;
            }
            catch (FileNotFoundException fileNotFoundException) {
                throw new h(a.i.c.a("abpErrorConfigFile"), fileNotFoundException);
            }
        }
    }

    private void d(String string, String string2) {
        Object object = j.d();
        if (((File)object).exists()) {
            try {
                object = new File((File)object, String.valueOf(string2) + ".sn");
                object = new PrintStream((File)object);
                if (!((PrintStream)object).checkError() && (string = k.e(string, string2)) != null) {
                    long l2 = 0L;
                    int n2 = 0;
                    while (n2 < this.b.length) {
                        l2 += (long)this.b[n2];
                        ++n2;
                    }
                    n2 = 0;
                    while (n2 < string.length()) {
                        l2 += (long)string.charAt(n2);
                        ++n2;
                    }
                    ((PrintStream)object).print(string);
                    ((PrintStream)object).print(' ');
                    ((PrintStream)object).println(l2);
                    this.c = string;
                    this.d = k.a(string);
                    this.a(this.d);
                }
                ((PrintStream)object).close();
                return;
            }
            catch (FileNotFoundException fileNotFoundException) {
                throw new h(a.i.c.a("abpErrorConfigFile"), fileNotFoundException);
            }
        }
    }

    private static String e(String string, String string2) {
        String string3 = null;
        String string4 = null;
        int n2 = -1;
        int n3 = -1;
        long l2 = -1L;
        try {
            int n4;
            Object object;
            URL uRL = new URL(string);
            Object object2 = uRL.openConnection();
            ((URLConnection)object2).setRequestProperty("Cookie", "abver=" + string2 + "; pass=1");
            ((URLConnection)object2).connect();
            int n5 = 1;
            while ((object = ((URLConnection)object2).getHeaderFieldKey(n5)) != null) {
                if (((String)object).equals("Set-Cookie")) {
                    int n6;
                    String string5 = ((URLConnection)object2).getHeaderField(n5);
                    if (string5.startsWith("PHPSESSID=")) {
                        string4 = string5.substring(10, string5.indexOf(";"));
                    }
                    if (string5.startsWith("x=")) {
                        n2 = n6 = Integer.parseInt(string5.substring(2, string5.indexOf(";")));
                    }
                    if (string5.startsWith("y=")) {
                        n3 = n6 = Integer.parseInt(string5.substring(2, string5.indexOf(";")));
                    }
                    if (string5.startsWith("k=")) {
                        n6 = Integer.parseInt(string5.substring(2, string5.indexOf(";")));
                        l2 = n6;
                    }
                }
                ++n5;
            }
            InputStream inputStream = ((URLConnection)object2).getInputStream();
            while ((n4 = inputStream.read()) != -1) {
                if (n4 == 10 || n4 >= 32 && n4 < 128) {
                    System.out.print((char)n4);
                    continue;
                }
                System.out.print('.');
            }
            inputStream.close();
            int n7 = n2 + n3 * 10000 ^ 0x313C578;
            if (n2 > 0 && n3 > 0 && l2 == -1L && string4 != null) {
                int n8;
                String string6;
                object2 = new URL(string);
                object = ((URL)object2).openConnection();
                ((URLConnection)object).setRequestProperty("Cookie", "PHPSESSID=" + string4 + "; abver=" + string2 + "; pass=2; k=" + n7 + ";");
                ((URLConnection)object).connect();
                n4 = 1;
                while ((string6 = ((URLConnection)object).getHeaderFieldKey(n4)) != null) {
                    if (string6.equals("Set-Cookie")) {
                        int n9;
                        String string7 = ((URLConnection)object).getHeaderField(n4);
                        if (string7.startsWith("PHPSESSID=")) {
                            string7.substring(10, string7.indexOf(";"));
                        }
                        if (string7.startsWith("x=")) {
                            Integer.parseInt(string7.substring(2, string7.indexOf(";")));
                        }
                        if (string7.startsWith("y=")) {
                            Integer.parseInt(string7.substring(2, string7.indexOf(";")));
                        }
                        if (string7.startsWith("k=") && (n9 = string7.indexOf(";")) > 2) {
                            string3 = string7.substring(2, string7.indexOf(";"));
                        }
                    }
                    ++n4;
                }
                InputStream inputStream2 = ((URLConnection)object).getInputStream();
                while ((n8 = inputStream2.read()) != -1) {
                    if (n8 == 10 || n8 >= 32 && n8 < 128) {
                        System.out.print((char)n8);
                        continue;
                    }
                    System.out.print('.');
                }
                inputStream2.close();
            }
        }
        catch (MalformedURLException malformedURLException) {
            throw new h(a.i.c.a("abpErrorConfigFile"), malformedURLException);
        }
        catch (IOException iOException) {
            throw new h(a.i.c.a("abpErrorConfigFile"), iOException);
        }
        return string3;
    }

    private String b(String object) {
        String string;
        block7: {
            string = null;
            object = new File(j.d(), String.valueOf(object) + ".sn");
            try {
                object = new FileInputStream((File)object);
                Scanner scanner = new Scanner((InputStream)object);
                String string2 = scanner.next();
                long l2 = 0L;
                int n2 = 0;
                while (n2 < this.b.length) {
                    l2 += (long)this.b[n2];
                    ++n2;
                }
                n2 = 0;
                while (n2 < string2.length()) {
                    l2 += (long)string2.charAt(n2);
                    ++n2;
                }
                long l3 = scanner.nextLong();
                scanner.close();
                ((FileInputStream)object).close();
                if (l2 == l3) {
                    string = string2;
                    break block7;
                }
                throw new h(a.i.c.a("abpErrorConfigFile"));
            }
            catch (FileNotFoundException fileNotFoundException) {
            }
            catch (IOException iOException) {
                object = iOException;
                iOException.printStackTrace();
            }
            catch (Exception exception) {}
        }
        return string;
    }

    public static int a(String string) {
        int n2 = 0;
        boolean bl = false;
        int n3 = string.length() - 1;
        while (n3 >= 0 && !bl) {
            char c2 = string.charAt(n3);
            if (c2 >= 'F' && c2 <= 'O') {
                n2 = n2 * 10 + c2 - 70;
            } else {
                bl = true;
            }
            --n3;
        }
        return n2;
    }

    private static String a(int n2, String string) {
        String string2 = null;
        if (string.length() == 6) {
            int n3 = 0;
            while (n3 < 10) {
                char c2 = (char)(70 + n2 % 10);
                n2 /= 10;
                string = String.valueOf(string) + c2;
                ++n3;
            }
            string2 = string;
        }
        return string2;
    }
}

