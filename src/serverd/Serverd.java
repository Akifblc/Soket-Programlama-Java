package serverd;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rabbım
 */
public class Serverd {

    public static void main(String[] args) throws IOException {
      

        ServerSocket serverSoket = null;

        Socket server = null;
        try {
            serverSoket = new ServerSocket(8080);

            while (true) {
                server = serverSoket.accept();

                new istemciMulti(server).start();

            }

        } catch (IOException e) {
            System.out.println("Soket acılma hatası");
        } finally {
            server.close();

        }
    }
}

class istemciMulti extends Thread {

    Socket server = null;
    DataInputStream input = null;
    DataOutputStream output = null;
    byte[] byteImage;

    String path = "C:\\Users\\Belgelerim\\Desktop\\ServerData\\";
    String video = "video\\";
    String image = "image\\";
    String rar = "rar\\";
    String pdf = "pdf\\";
    String word = "word\\";
    String auido = "audio\\";
    String powerpoint = "powerpoint\\";
    String fullpath = "";
    String gelen = "";
    String docx = "docx";
    String file_name = "";
    String file_type = "";
    String dir="";
    int control=3;

    istemciMulti(Socket soket) {   // run metodu parametre almadıgı için
        this.server = soket;         // bu yapılandırıcı kullanılır
    }

    @Override
    public void run() {
        try {
            input = new DataInputStream(server.getInputStream());
            output = new DataOutputStream(server.getOutputStream());
            // System.out.println(server.getPort());
            System.out.println(Thread.currentThread().getName() + " Yanıtlıyor...");
            int sayi=0;
            gelen = input.readUTF();
            System.out.println(gelen);
            if(gelen.equals("Message")){
                gelen=input.readUTF().toString();
                System.out.println(gelen+"*********");
                sayi=56;
        String str = "Bunu dosyaya yazdir";

        File file = new File("C:\\Users\\Belgelerim\\Desktop\\ServerData\\dosya.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fileWriter = new FileWriter(file, false);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        bWriter.write(gelen);
        bWriter.close();
                
            }
        
            sayi=input.readInt();
        if(sayi!=56){
               System.out.println("ZXXXXXXXXXXXXXXXXXXXXX"+sayi);
                 control=sayi;
             switch(control){
                  case 1 : dir="image"; break;     
                  case 2 : dir="video"; break;
                  case 3 : dir="pdf"; break;
                  case 4 : dir="rar"; break;
                  case 5 : dir="powerpoint"; break;
                  case 6 : dir="word"; break;
                  case 7 : dir="audio"; break;
                  
             }
             String list = "";
            File ff = new File("C:\\Users\\Belgelerim\\Desktop\\ServerData\\"+dir);
            File[] liste = ff.listFiles();
            for (int i = 0; i <liste.length; i++) {
                System.out.println(liste[i].getName());
                list = list + liste[i].getName() + " ";
               
            }
               System.out.println("gönderdi");
               if(sayi!=44){
                    output.writeUTF(list); 
               }
                                         
            String separate[] = gelen.split(" ");

            file_name = separate[0];
            file_type = separate[1];       
           }
          
           
          
         
            if(sayi==56){
                System.out.println("buraya girmemeli");
                String adrs=input.readUTF();
          
              if(adrs!=null){
                  sayi=input.readInt();
                
                    control=sayi;
             switch(control){
                  case 1 : dir="image"; break;     
                  case 2 : dir="video"; break;
                  case 3 : dir="pdf"; break;
                  case 4 : dir="rar"; break;
                  case 5 : dir="powerpoint"; break;
                  case 6 : dir="word"; break;
                  case 7 : dir="audio"; break;
                  
             }System.out.println("C:\\Users\\Belgelerim\\Desktop\\ServerData\\"+dir+"\\"+adrs);
            FileInputStream fis = new FileInputStream("C:\\Users\\Belgelerim\\Desktop\\ServerData\\"+dir+"\\"+adrs);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            ObjectOutputStream oos = new ObjectOutputStream(server.getOutputStream());
            oos.writeObject(buffer);
          
              }
         
            }
            
            
         
            try {
              
                ObjectInputStream ois = new ObjectInputStream(server.getInputStream());
                byte[] bufferr = (byte[]) ois.readObject();         
                 System.out.println("upload kısmına girildi");
                path_propertise();            
                FileOutputStream fos = new FileOutputStream(fullpath);
                fos.write(bufferr); 
                System.out.println(fullpath);
                fos.close();
            } catch (IOException e) {

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(istemciMulti.class.getName()).log(Level.SEVERE, null, ex);

            }

        } catch (IOException e) {

            System.out.println("Hata Oluştu" + e.getMessage());
        } finally {
            try {
                output.close();
                input.close();
                server.close();

            } catch (IOException ex) {
                System.out.println("Kapatma Hatası");
            }

        }
    }

public String path_propertise(){
     if (file_type.equals("docx") || file_type.equals("doc")) {
                    fullpath = path + word +  file_name + "." + file_type;
                    System.out.println(fullpath + "222");
                }
                if (file_type.equals("pdf")) {
                    fullpath = path + pdf + file_name + "." + file_type;
                    System.out.println(fullpath + "222");
                }
                if (file_type.equals("zip") || file_type.equals("rar")) {
                    fullpath = path + rar +  file_name + "." + file_type;
                    System.out.println(fullpath + "222");
                }
                if (file_type.equals("mp4") || file_type.equals("3gp")
                        || file_type.equals("flv") || file_type.equals("mov")
                        || file_type.equals("avi")) {
                    fullpath = path + video +  file_name + "." + file_type;
                    System.out.println(fullpath + "222");
                }
                if (file_type.equals("mp3") || file_type.equals("wav")
                        || file_type.equals("aac")) {
                    fullpath = path + auido +  file_name + "." + file_type;
                    System.out.println(fullpath + "333");
                }
                if (file_type.equals("jpg") || file_type.equals("png")
                        || file_type.equals("gif") || file_type.equals("bmp")
                        || file_type.equals("psd")) {
                    fullpath = path + image +  file_name + "." + file_type;
                    System.out.println(fullpath + "222");
                }
                return fullpath;
}
}


