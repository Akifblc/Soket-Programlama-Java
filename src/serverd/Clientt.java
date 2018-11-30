package serverd;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Clientt {
    String ip="";
    int port=0;
public Clientt(){
    
}
public Clientt(String ip,String port){
    this.ip=ip;
    this.port=Integer.valueOf(port);
}
    String gelen="";
    public List<String> list(String gln){
        gln=this.gelen;
        ArrayList<String> liste= new ArrayList<String>();
      
        if(!gln.equals("")){
            String dizi[]=gln.split(" ");
        for(int i=0;i<dizi.length;i++){
            liste.add(dizi[i]);
            
        }
        }           
       return liste;
    }
    String path = "C:\\Users\\jir\\Desktop\\dene\\jsp.pdf";
    public static void main(String[] args) throws ClassNotFoundException, IOException {   
    }
List<String> giden_liste;
    public List<String> startClient(int dosya_sayi,String gelen_adrs,String path1) throws IOException {
        
        int dsy_sayi=dosya_sayi;
        Socket istemci = null;
        DataInputStream input = null;
        DataOutputStream output = null;
       if(path1!=null){
           path=path1;
           System.out.println(path);
        }
        try {
            istemci = new Socket(ip, port);
            input = new DataInputStream(istemci.getInputStream());
            output = new DataOutputStream(istemci.getOutputStream());
          
          //servdan gelen kısım
          if(!gelen_adrs.equals("upload")){
              try { 
                  System.out.println("serverden geleln ksısm");
                int gonder=56;               
                output.writeUTF(gelen_adrs); 
                output.writeInt(gonder);
                output.writeUTF(gelen_adrs); 
                output.writeInt(dsy_sayi);
                ObjectInputStream ois = new ObjectInputStream(istemci.getInputStream());
                byte[] buffer;
                buffer = (byte[])ois.readObject(); 
                FileOutputStream fos = new FileOutputStream(path1+gelen_adrs);       
               fos.write(buffer);
               fos.close();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Clientt.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
            
          else {
              
         
          //servera giden kısım
            try {
                System.out.println(path+"sadsad");
                output.writeUTF(new Clientt().separate(path));
                output.writeInt(dsy_sayi);
                FileInputStream fis = new FileInputStream(path);
                byte[] bufferr = new byte[fis.available()];
                fis.read(bufferr);
                ObjectOutputStream oos = new ObjectOutputStream(istemci.getOutputStream());
                oos.writeObject(bufferr);
                fis.close();
            } catch (IOException e) {
           System.out.println("Hata oluştu1 " + e.getMessage());
            }
            gelen= input.readUTF();
            
            giden_liste= list(gelen);
           }
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
        System.out.println("bitti");
      
        
       return giden_liste;
    }

    public String separate(String path) {

        String dizi[] = path.split("\\.");
        //  System.out.println(dizi[1]);
        int index = dizi[0].lastIndexOf("\\");
        String isim = dizi[0].substring(index + 1);
        //  System.out.println(isim);
        String name_path = isim + " " + dizi[1];
        System.out.println(name_path);
        return name_path;
    }   
}

