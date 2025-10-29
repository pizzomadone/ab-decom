/*
 * Decompiled with CFR 0.152.
 */
package a.f;

import a.f.f;
import a.f.i;
import a.f.k;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import javax.swing.JOptionPane;

public final class d {
    private static char[] a = "0123456789ABCDEF".toCharArray();

    public static byte[] a(String string, String string2) {
        return d.a("https://algobuild.com/abkg/ab0080keyusrget.php", string, string2);
    }

    private static byte[] a(String object, String object2, String charSequence) {
        int n2;
        object = String.valueOf(object) + "?srequiring=" + (String)object2 + "&srequired=" + (String)charSequence;
        object2 = null;
        charSequence = new StringBuilder();
        InputStreamReader inputStreamReader = null;
        try {
            object = new URL((String)object);
            object = ((URL)object).openConnection();
            if (object != null) {
                ((URLConnection)object).setReadTimeout(60000);
            }
            if (object != null && ((URLConnection)object).getInputStream() != null) {
                inputStreamReader = new InputStreamReader(((URLConnection)object).getInputStream(), Charset.defaultCharset());
                object = new BufferedReader(inputStreamReader);
                while ((n2 = ((BufferedReader)object).read()) != -1) {
                    ((StringBuilder)charSequence).append((char)n2);
                }
                ((BufferedReader)object).close();
            }
            inputStreamReader.close();
        }
        catch (Exception exception) {
            throw new RuntimeException("Exception while calling URL:", exception);
        }
        if (((StringBuilder)charSequence).length() >= 2 && ((StringBuilder)charSequence).charAt(0) == '0' && (((StringBuilder)charSequence).charAt(1) == 'x' || ((StringBuilder)charSequence).charAt(1) == 'X')) {
            int n3 = (((StringBuilder)charSequence).length() - 2) / 2;
            object2 = new byte[n3];
            n3 = 0;
            n2 = 2;
            while (n2 < ((StringBuilder)charSequence).length()) {
                String string = ((StringBuilder)charSequence).substring(n2, n2 + 2);
                try {
                    int n4 = Integer.parseInt(string, 16);
                    object2[n3] = (byte)n4;
                    ++n3;
                }
                catch (NumberFormatException numberFormatException) {}
                n2 += 2;
            }
        }
        return object2;
    }

    private static String a(String object, String string, int n2, String string2, String string3, byte[] object2) {
        String string4 = null;
        try {
            int n3;
            object2 = "0x" + d.a(object2);
            object = new URL((String)object);
            object = ((URL)object).openConnection();
            if (object != null) {
                ((URLConnection)object).setReadTimeout(60000);
            }
            ((URLConnection)object).setRequestProperty("Cookie", "abver=" + string + "; ser=" + n2 + "; des=" + string2 + "; sc=" + string3 + "; uk=" + (String)object2 + ";");
            ((URLConnection)object).connect();
            n2 = 1;
            while ((string = ((URLConnection)object).getHeaderFieldKey(n2)) != null) {
                if (string.equals("Set-Cookie")) {
                    string = ((URLConnection)object).getHeaderField(n2);
                    System.out.println(string);
                    if (string.startsWith("cc=")) {
                        string4 = string.substring(3, string.indexOf(";"));
                    }
                }
                ++n2;
            }
            InputStream inputStream = ((URLConnection)object).getInputStream();
            while ((n3 = inputStream.read()) != -1) {
                if (n3 == 10 || n3 >= 32 && n3 < 128) {
                    System.out.print((char)n3);
                    continue;
                }
                System.out.println("[" + n3 + "]");
            }
            inputStream.close();
            if (string4 == null) {
                throw new i("Key Register - Null Result");
            }
        }
        catch (UnknownHostException unknownHostException) {
            throw new i("Key Register", unknownHostException);
        }
        catch (MalformedURLException malformedURLException) {
            throw new i("Key Register", malformedURLException);
        }
        catch (IOException iOException) {
            throw new i("Key Register", iOException);
        }
        return string4;
    }

    private static String a(byte[] byArray) {
        char[] cArray = new char[byArray.length << 1];
        int n2 = 0;
        while (n2 < byArray.length) {
            int n3 = byArray[n2] & 0xFF;
            cArray[n2 << 1] = a[n3 >>> 4];
            cArray[(n2 << 1) + 1] = a[n3 & 0xF];
            ++n2;
        }
        return new String(cArray);
    }

    public static String b(String string, String string2) {
        String string3 = "AB0080";
        int n2 = k.a().c();
        byte[] byArray = f.a().b();
        String string4 = null;
        try {
            string4 = d.a("https://algobuild.com/abkg/ab0080keyusrreg.php", string3, n2, string, string2, byArray);
            if (string4 != null) {
                k.a().a(string, string4);
            }
        }
        catch (i i2) {
            JOptionPane.showMessageDialog(null, "IMPOSSIBILE REGISTRARE " + string + "   " + string2);
        }
        return string4;
    }
}

