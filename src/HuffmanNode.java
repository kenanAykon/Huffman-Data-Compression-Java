public class HuffmanNode {
    char karakter;
    int frekans;
    HuffmanNode left;
    HuffmanNode right;
    HuffmanNode next;
    public HuffmanNode(char karakter,int frekans){
        this.karakter = karakter;
        this.frekans = frekans;
        this.left = null;
        this.right = null;
        this.next = null;
    }
}
