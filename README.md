# Spring Boot Application

Dokumen ini menyediakan instruksi tentang cara menjalankan aplikasi Spring Boot secara lokal.

## Prasyarat

1. **Java Development Kit (JDK)**: Pastikan JDK 17 atau versi yang lebih baru sudah terinstal.
   - Anda dapat mengunduhnya dari [AdoptOpenJDK](https://adoptopenjdk.net/) atau [Oracle](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html).
   - Pastikan `JAVA_HOME` telah diatur dengan benar di variabel lingkungan Anda.

2. **Maven**: Pastikan Maven sudah terinstal.
   - Anda dapat mengunduhnya dari [situs resmi Maven](https://maven.apache.org/download.cgi).
   - Tambahkan `MAVEN_HOME` ke variabel lingkungan Anda dan sertakan dalam `PATH` sistem Anda.

3. **Database** (Opsional, jika aplikasi Anda menggunakan database):
   - Pastikan database yang diperlukan (contohnya, MariaDB) sudah diinstal dan berjalan.
   - Perbarui `application.properties` atau `application.yml` dengan konfigurasi database lokal Anda.

## Clone Repository

Clone repositori proyek ke mesin lokal Anda menggunakan Git:

```bash
git clone https://github.com/visivalid/api-admin
cd api-admin
#   a p i - v a l i d v i s i - s p r i n g  
 