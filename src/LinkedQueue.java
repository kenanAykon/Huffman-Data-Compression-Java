public class LinkedQueue {
    HuffmanNode head;
    public LinkedQueue() {
        head = null;
    }
    public void enque(HuffmanNode newNode){
        if(head == null || newNode.frekans < head.frekans){
            newNode.next = head;
            head = newNode;
        }else{
            HuffmanNode iterator = head;
            while(iterator.next != null && iterator.next.frekans <= newNode.frekans){
                iterator = iterator.next;
            }
            newNode.next = iterator.next;
            iterator.next = newNode;
        }
    }
    public HuffmanNode deque(){
        if(head == null){
            return null;
        }
        HuffmanNode temp = head;
        head = head.next;
        return temp;
    }
    public HuffmanNode huffmanOlustur(){
        while(head != null && head.next != null){
            HuffmanNode leftChild = deque();
            HuffmanNode rightChild = deque();
            HuffmanNode parent = new HuffmanNode(' ',0);
            parent.frekans = leftChild.frekans + rightChild.frekans;
            parent.left = leftChild;
            parent.right = rightChild;
            enque(parent);
        }
        return head;
    }
    public void kodlariYazdir(){
        kodlariYazdir(head,"");
    }
    String[] kodTablosu = new String[256];
    private void kodlariYazdir(HuffmanNode node,String code){
        if(node.left == null && node.right == null){
            kodTablosu[node.karakter] = code;
        }else{
            if(node.left != null){
                kodlariYazdir(node.left,code + "0");
            }if(node.right != null){
                kodlariYazdir(node.right,code + "1");
            }
        }
    }
    // Bu metodu LinkedQueue sınıfının içine ekle
    public void sifreCoz(String encodedDosyaYolu, String decodedDosyaYolu) {
        String okunanKodlar = DosyaIslemleri.dosyadanOku(encodedDosyaYolu);
        if (okunanKodlar != null && !okunanKodlar.isEmpty()) {
            StringBuilder cozulmusMetin = new StringBuilder();

            HuffmanNode gezgin = head;

            for (int i = 0; i < okunanKodlar.length(); i++) {
                char bit = okunanKodlar.charAt(i);

                if (bit == '0') {
                    gezgin = gezgin.left;
                } else {
                    gezgin = gezgin.right;
                }

                if (gezgin.left == null && gezgin.right == null) {
                    cozulmusMetin.append(gezgin.karakter);
                    gezgin = head;
                }
            }

            String sonuc = cozulmusMetin.toString();
            System.out.println("Çözülmüş Metin: " + sonuc);

            // 3. Dosyaya yaz
            DosyaIslemleri.dosyayaYaz(decodedDosyaYolu, sonuc);

        } else {
            System.out.println("Hata: " + encodedDosyaYolu + " okunamadı.");
        }
    }
}
