**Dokumentasi MyFragment**

_Tugas Tambahan - LK01 - 2540096251 - Nelsen Gabriel_

![image](https://github.com/Nelsen-G/MyFragment/assets/63243521/63f8ca3c-9168-4361-b5da-e68961bb80a9)

Aplikasi MyFragment menampilkan dua bagian utama aplikasi, yaitu Home dan About Us. Kedua bagian ini dibangun menggunakan fragment yang diletakkan pada Main Activity dalam bentuk Linear Layout. Di dalam Main Activity terdapat bottom navigation bar yang mengubah Linear Layout Fragment pada Main Activity, sehingga tampilan bisa berubah antara page Home dan About Us.

![image](https://github.com/Nelsen-G/MyFragment/assets/63243521/79897314-ec13-4058-ab47-afda291ad754)
![image](https://github.com/Nelsen-G/MyFragment/assets/63243521/0bcb4a47-8e2d-4b93-962d-8467b8d49258)

Pada fragment Home, user dapat mengisi field nama, email, dan password. Lalu, user bisa klik button Save untuk melakukan penyimpanan data ke dalam SQLite database yang bernama UserData.db, dengan table yang bernama user_data. 

![image](https://github.com/Nelsen-G/MyFragment/assets/63243521/1921c009-e755-4a4c-b420-15f0407c51ef)
![image](https://github.com/Nelsen-G/MyFragment/assets/63243521/798939bf-0ce3-47ac-acef-7c58839233e8)

Tabel ini memiliki tiga columns, yaitu nama, email, dan password, sehingga sesuai dengan model Account yang memiliki atribut sama. Pada DBHelper, terdapat method untuk insert data ke dalam database menggunakan content values.

![image](https://github.com/Nelsen-G/MyFragment/assets/63243521/383e5e28-c2ed-4489-bd4e-8d558701bd2b)

Data tersebut kemudian ditampilkan menggunakan recycler view di subfragment di dalam fragment home. Hal ini bertujuan untuk memenuhi kriteria soal mengenai menampilkan data yang sudah disave menggunakan fragment dan recycler view. Recycler view mengambil semua data yang ada dari SQLite database yang sama. Pada DBHelper, terdapat method untuk mengambil setiap row dari table menggunakan cursor dan dimasukkan ke dalam List. 

![image](https://github.com/Nelsen-G/MyFragment/assets/63243521/a89e6f06-15ba-421e-8f21-c08d5d947eb3)

Kemudian, recycler view menampilkan data sesuai dengan account_list_item.xml. Recycler view akan menampilkan nama, email, dan password pada setiap itemnya. Jika tidak ada data pada table user_data, maka recycler view tidak akan menampilkan apa pun. 

![image](https://github.com/Nelsen-G/MyFragment/assets/63243521/9edc956d-2e86-430b-b874-2d2214cf2c54)

Pada fragment About Us, user dapat melihat gambar dan alamat BINUS Alam Sutera.

Primary color pada theme diubah menjadi warna hijau gelap (#023020) dan tombol save diberi warna biru gelap (#01377d). 


