import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DosyaIslemleri {
    public static String dosyadanOku(String dosyaYolu) {
        try {
            return new String(Files.readAllBytes(Paths.get(dosyaYolu))).trim(); //trim() kodunu satırı saymaması için yazdım bunu da AI den öğrendim
        } catch (IOException e) {
            System.err.println("Dosya okunamadı: " + e.getMessage());
            return "";
        }
    }
    public static int[] dosyadanFrekansla() {
        String metin = dosyadanOku("letter.txt");
        int[] frekanslar = new int[256];
        if (metin != "") {
            System.out.println("Dosya başarıyla okundu");
            for (int i = 0; i < metin.length(); i++) {
                char c = metin.charAt(i);
                frekanslar[c]++;
            }
        }
        return frekanslar;
    }
    public static void dosyayaYaz(String dosyaYolu, String icerik) {
        try {
            Files.write(Paths.get(dosyaYolu), icerik.getBytes());
            System.out.println(dosyaYolu + " dosyasına başarıyla yazıldı.");
        } catch (IOException e) {
            System.err.println("Dosyaya yazarken hata oluştu: " + e.getMessage());
        }
    }
}

