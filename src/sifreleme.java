import java.security.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.*;

public class sifreleme

{
 



  public static String enkoder(String metin) throws Exception{
    String plaintext = metin;
    String algoritma= "RSA";
    String gonder_par;


    KeyPair anahtar = KeyPairGenerator.getInstance(algoritma).generateKeyPair();

    PrivateKey hususiAnahtar = anahtar.getPrivate();

    PublicKey umumiAnahtar = anahtar.getPublic();
    System.out.println("Anahtar Bilgileri:n " + hususiAnahtar + " nn" );

    System.out.println("Orjinal metin :"  + ByteToString(plaintext.getBytes()));

    Cipher cipher = Cipher.getInstance(algoritma);

     cipher.init(Cipher.ENCRYPT_MODE, hususiAnahtar);

    byte[] sifreliMetin = cipher.doFinal(plaintext.getBytes());

    System.out.println("Sifrelenmis metin : " + ByteToString(sifreliMetin));
    gonder_par=new String(sifreliMetin);
   
    return gonder_par;
        
    }
    public static String decoder(PublicKey umumiAnahtar, byte[] sifreliMetin) throws Exception{
        String algoritma= "RSA";
      
            Cipher cipher = Cipher.getInstance(algoritma);
            cipher.init(Cipher.DECRYPT_MODE, umumiAnahtar);

            byte[] desifreliMetin = cipher.doFinal(sifreliMetin);
            String st=new String(desifreliMetin);
            System.out.println("yazılan metin "+st);
    return st;
    }

public static void main(String args[]) throws
Exception

{  
enkoder("yunus");
}
private static
String ByteToString(byte[] buffer)
{

StringBuilder s = new StringBuilder();

for (byte b: buffer)

{

String temp = Integer.toHexString(0x00FF & b);

if( temp.length() == 1)

{

s.append("0"+temp);

}

else

{

s.append(temp);

}

}

return s.toString();

}

}