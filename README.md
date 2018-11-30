# Soket-Programlama-Java

1.Adım: 
  Zip klasörünü indiriniz.
2.Adım
  İndirdiğiniz Soket-Programlama-Java Klasör içerisindeki ServerData klasörünü masaüstüne atınız.
3.Adım
  Kodları java ortamında açtıktan sonra Serverd java dosyası içerisinde bulunan   
  //File ff = new File("C:\\Users\\Belgelerim\\Desktop\\ServerData\\" + dir);
  kod satırı masaüstüne attığınız ServerData klasörünün yolunu göstermektedir.
  SoketProgramlama ile bağlantı kurulduktan sonra bu klasör üzerinden veri alışverisi sağlanır.
4.Adım
  Java ortamında açılan Serverd klasörü içerisindeki Client2 java kod sayfasına giriniz.
  Clint2 kod sayfasında bulunan aşşağıdaki kod satırı bağlantı kuracağınız kişinin ipv4 ünü yazmanız gereken kısımdır.
    istemci = new Socket("192.168.1.1", 8080);
    Not:192.168.1.1 Örnek ipdir karşı bilgisayarın ipv4 adresini giriniz.
5.Adım
  Serverd klasöründe bulunan Serverd, Client, Client2 java kodlarını sırasıyla java ortamında(Örn NetBeans) çalıştırınız.

6.Adım
  Serverd içerisinde bulunan connect.java java dosyasına sağ tıklayıp çalıştırınız.
  Karşınıza gelen ekranda ip kısmına bağlanmak istediğiniz bilgisayarın ipv4 ünü yazınız.
  Port kısmına ise 8080 yazınız.
  
  Not:Aynı işlemler iki bilgisayar için uygulanmalıdır. Aynı işlemleri yapan iki bilgisayarda gerekli düzeltmeler
  yapıldıktan sonra birbirlerini ipv4 ü ve port numaraları ile bağlantı kurabilirler.
  bağlantı kurulup hata almamak için iki bilgisayarında Client2,Client ve Serverd java kodları çalışıyor vaziyette olması lazımdır.
  
Bir bilgisayar hem Server hem client mantığıyla çalışmaktadır.

Muhammed Akif Bilici 
gmail: akifbilic@gmail.com
@github.com/Akifblc
