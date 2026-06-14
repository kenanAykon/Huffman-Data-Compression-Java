public class Main {

    public static void main(String[] args) {
        int[] gelenFrekanslar = DosyaIslemleri.dosyadanFrekansla();

        if (gelenFrekanslar != null) {

            LinkedQueue kuyruk = new LinkedQueue();

            System.out.println("Kuyruğa ekleme yapılıyor...");

            for (int i = 0; i < 256; i++) {
                if (gelenFrekanslar[i] > 0) {
                    char karakter = (char)i;
                    int frekans = gelenFrekanslar[i];

                    HuffmanNode yeniDugum = new HuffmanNode(karakter, frekans);

                    kuyruk.enque(yeniDugum);
                }
            }

            HuffmanNode root = kuyruk.huffmanOlustur();

            if (root != null) {
                System.out.println("Huffman ağacı başarıyla oluşturuldu");
                System.out.println("Toplam karakter sayısı (Kök Frekansı): " + root.frekans);
                System.out.println("\n--- Bulunan huffman kodları ---");
                kuyruk.kodlariYazdir();
                System.out.println("-------------------------------");
                System.out.println("\n--- Kodlama (Encoding) ---");

                String kaynakMetin = DosyaIslemleri.dosyadanOku("source.txt");

                if (kaynakMetin != null && !kaynakMetin.isEmpty()) {

                    StringBuilder kodlanmisMetin = new StringBuilder();

                    // 2. Metindeki her harfi gez ve kodunu bul
                    for (int i = 0; i < kaynakMetin.length(); i++) {
                        char harf = kaynakMetin.charAt(i);

                        // Tablodan o harfin kodunu çek (Örn: 'a' için "0")
                        String kodKarsiligi = kuyruk.kodTablosu[harf];

                        if (kodKarsiligi != null) {
                            kodlanmisMetin.append(kodKarsiligi);
                        }
                    }

                    // 3. Sonucu encoded.txt dosyasına yaz
                    String sonuc = kodlanmisMetin.toString();
                    System.out.println("Kodlanmış Metin: " + sonuc);
                    DosyaIslemleri.dosyayaYaz("encoded.txt", sonuc);

                } else {
                    System.out.println("Hata: source.txt okunamadı veya boş.");
                }
            } else {
                System.out.println("Hata: Ağaç oluşturulamadı (Root null).");
            }
            System.out.println("\n--- Şifre Çözme (Decoding) ---");
            kuyruk.sifreCoz("encoded.txt", "decoded.txt");
        }

    }

}

