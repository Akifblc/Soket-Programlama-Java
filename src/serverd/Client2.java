package serverd;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class Client2 {
    
    
     public static void main(String[] args) throws ClassNotFoundException {
      
    }
      public void startClient(String metin) throws ClassNotFoundException {

        Socket istemci = null;
        DataInputStream input = null;
        DataOutputStream output = null;
        
        try {
            istemci = new Socket("192.168.1.33", 8080);//karşı ip
            input = new DataInputStream(istemci.getInputStream());
            output = new DataOutputStream(istemci.getOutputStream());
            output.writeUTF("Message"); 
            output.writeUTF(metin);
       //     String gelen= input.readUTF();
         //S   System.out.println(gelen);
            // SERVERDAN GELENI ALMA
         /*   ObjectInputStream ois = new ObjectInputStream(istemci.getInputStream());
            byte[] buffer = (byte[])ois.readObject();
           */
            
            
           
         
            //  SERVERE GONDERME
         /*   try {
                output.writeUTF(new Clientt().separate(path));
                FileInputStream fis = new FileInputStream(path);
                byte[] bufferr = new byte[fis.available()];
                fis.read(bufferr);
                ObjectOutputStream oos = new ObjectOutputStream(istemci.getOutputStream());
                oos.writeObject(bufferr);
            } catch (IOException e) {

            }*/

        } catch (IOException e) {
            System.out.println("Hata oluştu " + e.getMessage());
        } finally {
            try {
                input.close();
                output.close();
                istemci.close();
            } catch (IOException e) {

            }
        }

    }
}
