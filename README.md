# Huffman Coding Data Compression Algorithm

A complete, from-scratch Java implementation of the classic Huffman Coding algorithm for lossless data compression and decompression. This project demonstrates advanced data structure manipulation, including custom-built priority queues and binary trees, integrated with File I/O operations.

### Key Features
* **Custom Data Structures:** Implements a custom `LinkedQueue` acting as a Priority Queue to correctly order character frequencies, and a `HuffmanNode` class to build the binary tree without relying on Java's built-in collections.
* **Frequency Analysis:** Reads a source file (`letter.txt`) to dynamically calculate character frequencies and construct the optimal Huffman Tree.
* **Encoding (Compression):** Parses the input text (`source.txt`), replaces characters with their generated variable-length binary codes, and outputs the result to `encoded.txt`.
* **Decoding (Decompression):** Traverses the Huffman Tree using the binary sequence from `encoded.txt` to reconstruct the original text flawlessly into `decoded.txt`.

### Tech Stack
* **Language:** Java
* **Concepts:** Data Compression, Binary Trees, Priority Queues, Algorithms, File I/O.

## Context
This project was developed as an advanced Data Structures and Algorithms assignment during my Computer Engineering studies at Pamukkale University to practically understand how real-world file compression works under the hood.

---

# Türkçe (Turkish Version)

Bu proje, kayıpsız veri sıkıştırma ve açma işlemleri için kullanılan klasik Huffman Kodlaması (Huffman Coding) algoritmasının Java ile sıfırdan yazılmış bir uygulamasıdır. Hazır kütüphaneler yerine tamamen özel veri yapıları kullanılmıştır.

### Özellikler
* **Özel Veri Yapıları:** Frekansları sıralamak için kendi yazdığım bir Öncelikli Kuyruk (`LinkedQueue`) ve ağacı inşa etmek için `HuffmanNode` sınıfı kullanıldı.
* **Frekans Analizi ve Ağaç Kurulumu:** Harici bir dosyadan (`letter.txt`) okunan karakterlerin frekansları hesaplanarak en uygun Huffman Ağacı dinamik olarak oluşturulur.
* **Şifreleme (Encoding):** `source.txt` içindeki orijinal metin okunur, her bir karakter Huffman tablosundaki ikili (binary) karşılığı ile değiştirilerek `encoded.txt` dosyasına sıkıştırılmış olarak yazılır.
* **Şifre Çözme (Decoding):** `encoded.txt` dosyasındaki 1 ve 0'lardan oluşan dizi kullanılarak ağaç üzerinde gezinilir ve orijinal metin eksiksiz bir şekilde `decoded.txt` dosyasına geri dönüştürülür.
