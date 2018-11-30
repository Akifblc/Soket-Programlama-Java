/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverd;


import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;

public class rsa {

    private BigInteger p, q;
    private BigInteger n;
    private BigInteger PhiN;
    private BigInteger e, d;

    public rsa() {
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

    public BigInteger encrypt(BigInteger plaintext) {
        return plaintext.modPow(e, n);
    }

    public BigInteger decrypt(BigInteger ciphertext) {
        return ciphertext.modPow(d, n);
    }

    public static void main(String[] args) throws IOException {
     String metin="",metin2="";
          metin=encoder("akif");
          System.out.println("şifrelnen metin : "+metin);
          metin2=decoder(metin);
          System.out.println("şifresi çözülen metin:"+metin2);
          
    }
   
    public static String decoder(String metin){
       String[]dizi=new String[1500];       
       String[]dizi2=new String[1500];
        rsa app = new rsa();
           System.out.println("");
           System.out.print("Sifre Kirildiktan Sonraki Metin : ");
           // decoder
           String sfrsz_mtn="";
        for (int i = 0; i < metin.length(); i++) {
            BigInteger a=new BigInteger(dizi[i]);
            BigInteger b=new BigInteger(dizi2[i]);
            a = app.decrypt(b);
             System.out.println(dizi[i]);
             sfrsz_mtn+=dizi[i];
        }
        return sfrsz_mtn;
    }
    public static String encoder(String metin){
      String[]dizi=new String[1500];       
         String[]dizi2=new String[1500];
        rsa app = new rsa();
        int plaintext=0;
           BigInteger bplaintext, bciphertext=null;
       //encoder
        for (int i = 0; i <metin.length(); i++) {
            byte byte_deger=(byte)metin.charAt(i);
             plaintext = byte_deger;
              bplaintext = BigInteger.valueOf((long) plaintext);
              dizi[i]=bplaintext.toString();
                bciphertext = app.encrypt(bplaintext);
                dizi2[i]=bciphertext.toString();               
        }
        System.out.print("Metin Karekterlerinin Ascci Kodları:");
        for (int i = 0; i < metin.length(); i++) {
            
            System.out.println(dizi[i]);
            
        }
        System.out.println("");
          System.out.print("Sifreli Metin :");
          String sfrli_mtn="";
          for (int i = 0; i < metin.length(); i++) {
            
            System.out.println(dizi2[i]);
            sfrli_mtn+=dizi2[i];
        }
          return sfrli_mtn;
    }
}