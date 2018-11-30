/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverd;


import java.math.BigInteger;

public class deneme {

    private BigInteger p, q;
    private BigInteger n;
    private BigInteger PhiN;
    private BigInteger e, d;

    public deneme() {
        initialize();
    }

    public void initialize() {

        p = new BigInteger("53");
        q = new BigInteger("61");
        n = p.multiply(q);
        PhiN = p.subtract(BigInteger.valueOf(1));
        PhiN = PhiN.multiply(q.subtract(BigInteger.valueOf(1)));
        e = new BigInteger("17");
        d = e.modInverse(PhiN);
    }

    public String encrypt(String metin) {
        String[] dizi = new String[1500];
        String[] dizi2 = new String[1500];
        BigInteger bplaintext, bciphertext = null;
        String deger2 = "",deger="";

        int a = metin.length();
        boolean kontrol = true;

        for (int i = 0; i < metin.length(); i++) {
            byte plaintext = (byte) metin.charAt(i);
            bplaintext = BigInteger.valueOf((long) plaintext);
            dizi[i] = bplaintext.toString();

            bciphertext = bplaintext.modPow(e, n);
            dizi2[i] = bciphertext.toString();
        }
        for (int i = 0; i < metin.length(); i++) {
            if (i != metin.length() - 1) {
                deger = deger + dizi2[i] + "-";
                deger2 = deger2 + dizi[i] + "-";
            } else {
                deger = deger + dizi2[i];
                deger2 = deger2 + dizi[i];
            }

        }
        deger = deger + "//" + deger2;

        return deger;

    }

    public String decrypt(String deger) {
        BigInteger a, b;
        String degerr = "";

        String[] parcalama = new String[2];
        String[] dizi2 = new String[1500];
        String[] dizi3 = new String[1500];

        parcalama = deger.split("//");

        String ilk_parca = parcalama[0];
        String ikinci_parca = parcalama[1];
        dizi2 = ilk_parca.split("-");
        dizi3 = ikinci_parca.split("-");
        for (int i = 0; i < dizi2.length; i++) {

            b = new BigInteger(dizi2[i]);
            a = b.modPow(d, n);

            degerr = degerr + a;

        }
        deger = degerr;

        return deger;
    }

    public static void main(String[] args) {
        String metin = "jir_baba oley";
        String deger = "";
        deneme add = new deneme();
        String decoder_deger = add.encrypt(metin);
        System.out.println(add.encrypt(metin));

        System.out.println(add.decrypt(decoder_deger));
    }

}