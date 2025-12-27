# Uzay Savaşı Oyunu

Java Swing kullanılarak geliştirilmiş 2D uzay temalı atış oyunu.

[![Java](https://img.shields.io/badge/Java-ED8B00?style=flat&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

## Genel Bakış

Klasik uzay shooter tarzında geliştirilmiş bir oyun. Oyuncu uzay gemisini kontrol ederek gelen düşmanları yok etmeye çalışır.

## Özellikler

- 2D grafik arayüzü (Java Swing)
- Karakterler ve düşman tipleri
- Lazer atış sistemi
- Skor takibi
- Çoklu karakter seçeneği
- Oyun kayıt sistemi

## Oynanış

### Kontroller
- **Hareket**: Klavye ok tuşları veya mouse
- **Ateş**: Space tuşu
- **Karakter Değiştirme**: 1, 2, 3 tuşları

### Karakterler
- **Karakter 1**: Standart uzay gemisi
- **Karakter 2**: Hızlı uzay gemisi
- **Karakter 3**: Güçlü uzay gemisi

### Hedefler
Farklı tipte düşman hedefleri:
- Hedef 1: Temel düşman
- Hedef 2: Hızlı düşman
- Hedef 3: Güçlü düşman

## Kurulum ve Çalıştırma

### Gereksinimler
- Java Development Kit (JDK) 8 veya üzeri
- Java Runtime Environment (JRE)

### Derlenmiş JAR ile Çalıştırma
```bash
java -jar Oyun.jar
```

### Kaynak Koddan Derleme
```bash
# Derleme
javac src/*.java

# Çalıştırma
java -cp . Oyun
```

## Proje Yapısı
```
oyun/
├── src/                    # Kaynak kodlar
│   ├── Oyun.java          # Ana oyun sınıfı
│   ├── Karakter.java      # Karakter sınıfı
│   ├── Hedef.java         # Düşman hedef sınıfı
│   └── Laser.java         # Lazer atış sınıfı
├── bg.png                  # Arka plan görselleri
├── bg2.png
├── bg3.png
├── karakter1.png          # Karakter sprite'ları
├── karakter2.png
├── karakter3.png
├── hedef1.png             # Düşman sprite'ları
├── hedef2.png
├── hedef3.png
├── laser1.png             # Lazer görselleri
├── laser2.png
├── laser3.png
├── Oyun.jar               # Derlenmiş oyun
├── sonuclar.txt           # Skor kayıtları
└── README.md              # Bu dosya
```

## Oyun Mekanikleri

### Skor Sistemi
- Her düşman yok etme: +10 puan
- Combo sistemi mevcut
- En yüksek skorlar kaydedilir

### Zorluk Seviyeleri
Oyun ilerledikçe:
- Düşman hızı artar
- Daha fazla düşman ortaya çıkar
- Farklı düşman tipleri belirir

## Ekran Görüntüleri

_Oyun içi görüntüler eklenecek_

## Geliştirme

### Kullanılan Teknolojiler
- **Java Swing**: GUI framework
- **Java AWT**: Grafik rendering
- **Java Event Handling**: Kullanıcı girdileri

### Kod Yapısı
- Nesne yönelimli programlama prensipleri
- MVC (Model-View-Controller) benzeri yapı
- Event-driven programming

## Gelecek Geliştirmeler

- [ ] Ses efektleri ekleme
- [ ] Farklı seviyeler
- [ ] Power-up'lar
- [ ] Online skor tablosu
- [ ] Çoklu oyuncu modu

