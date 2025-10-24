# **Responsi 1 Praktikum Pemrograman Mobile**

**Nama:** Dyah Ghaniya Putri  
**NIM:** H1D023022  
**Shift Baru:** F  
**Shift Asal:** A  

---

## **Deskripsi Proyek**
Proyek ini merupakan hasil responsi dari praktikum mata kuliah Pemrograman Mobile, yang dikembangkan menggunakan Kotlin di Android Studio. Aplikasi ini menampilkan informasi lengkap mengenai klub sepak bola Olympique de Marseille (OM), meliputi profil singkat, sejarah klub, pelatih, dan daftar pemain. Data pelatih dan pemain diambil dari Football Data API melalui endpoint `https://api.football-data.org/v4/teams/516`. Proses integrasi API dilakukan menggunakan Retrofit dan arsitektur MVVM agar pengelolaan data lebih efisien dan terstruktur.

---

## **Demo Aplikasi**
Berikut tampilan singkat aplikasi **Responsi 1 Mobile (H1D023022)**  
![Demo Aplikasi](demo-responsi-1.gif))

---

## **Fitur Utama**
- Halaman Utama (Profil Klub) menampilkan logo klub, latar stadion, dan deskripsi singkat klub.  
- Halaman Sejarah Klub menampilkan sejarah panjang klub secara lengkap dengan teks justify.  
- Halaman Pelatih (Coach) menampilkan informasi pelatih utama (nama, negara, dan tanggal lahir) dari API.  
- Halaman Pemain (Squad) menampilkan daftar pemain dengan warna kartu berdasarkan posisi:
  - Goalkeeper → Kuning  
  - Defender → Biru  
  - Midfielder → Hijau  
  - Forward → Merah  

---

## **Penjelasan Alur Data**
Aplikasi ini menggunakan pola MVVM (Model - View - ViewModel) dengan alur data sebagai berikut:
1. **Pemanggilan Data API**
   - Pemanggilan dilakukan melalui `ApiService` dengan endpoint `https://api.football-data.org/v4/teams/516` menggunakan Retrofit.  
   - Token autentikasi ditambahkan pada header request untuk mengakses data klub, pelatih, dan pemain.
2. **Pengolahan Data di ViewModel**
   - Hasil respon API diteruskan ke `TeamViewModel` untuk diolah dan disesuaikan dengan kebutuhan UI.  
   - ViewModel menampung data dalam bentuk `LiveData`, sehingga data otomatis diperbarui di tampilan saat ada perubahan.
3. **Penyajian Data di Layar**
   - Data dari ViewModel diambil oleh Activity/Fragment menggunakan View Binding.  
   - Informasi pelatih ditampilkan pada halaman Coach, sedangkan daftar pemain disajikan dengan RecyclerView.  
   - Masing-masing item pemain ditampilkan menggunakan CardView dengan warna latar sesuai posisi.  

---

## **Arsitektur dan Teknologi**
Aplikasi ini menerapkan arsitektur Model - View - ViewModel (MVVM) dan menggunakan beberapa library modern Android, di antaranya:
- Kotlin sebagai bahasa pemrograman utama  
- Android Studio (Material Components) untuk UI  
- Retrofit & Gson Converter untuk integrasi API  
- View Binding untuk menghubungkan layout dan kode  
- RecyclerView + CardView untuk menampilkan daftar pemain  
- Material Design untuk konsistensi tampilan antar halaman  

---


