package com.filkom.javalibman;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.UUID;
import java.util.Scanner;
import java.util.ArrayList;

import com.filkom.javalibman.library.Pager;
import com.filkom.javalibman.app.buku.Buku;
import com.filkom.javalibman.app.anggota.Anggota;
import com.filkom.javalibman.app.perpustakaan.Perpustakaan;

public class AppRun {

    public static void main(String[] args) {
        final String VERSION = "v1.0.0";

        Scanner scanner = new Scanner(System.in);
        Pager pager = new Pager();
        Anggota anggota = new Anggota();
        Perpustakaan perpustakaan = new Perpustakaan();
        String username = "";
        boolean loggedIn = false;

        while (true) {
            loggedIn = !username.isEmpty();
            pager.header("Java libMan " + VERSION);

            if (!loggedIn) {
                pager.message("Anda belum login");
            } else {
                pager.message("Anda login sebagai: " + username);
            }
            pager.spacer();

            if (!loggedIn) {
                pager.message("(0) Register");
                pager.message("(1) Login");
            }

            pager.message("(2) Pinjam Buku");
            pager.message("(3) Kembalikan Buku");
            pager.message("(4) Tambah Buku");
            pager.message("(5) Lihat Daftar Buku");
            pager.message("(6) Lihat Info Buku");
            pager.message("(7) Cari Buku");

            if (loggedIn) {
                pager.message("(8) Lihat Info User");
                pager.message("(9) Log Out");
            }

            pager.message("(10) Keluar");
            pager.spacer();
            String userInputOption = pager.input();
            pager.footer();

            if (!loggedIn && userInputOption.equals("0")) {
                pager.header("Register User Baru");
                boolean registerConfirm = anggota.register(pager.customInput("Nama", true),
                        pager.customInput("Username", true),
                        pager.customInput("Password", true));
                perpustakaan.tambahAnggota(anggota);
                pager.footer();

                username = anggota.getUsername();

                if (!registerConfirm) {
                    pager.info("silahkan gunakan username lain");
                }
            } else if (!loggedIn && userInputOption.equals("1")) {
                pager.header("Login");
                boolean loginConfirm = anggota.login(pager.customInput("Username", true),
                        pager.customInput("Password", true));
                pager.footer();

                username = anggota.getUsername();

                if (!loginConfirm) {
                    pager.info("username atau password salah");
                }
            } else if (userInputOption.equals("2")) {
                pager.header("Pinjam Buku");
                try {
                    UUID IDBuku = UUID.fromString(pager.customInput("ID Buku", true));
                    pager.footer();
                    Anggota.pinjamBuku(username, IDBuku);
                } catch (IllegalArgumentException e) {
                    pager.footer();
                    pager.info("ID buku tidak valid");
                }
            } else if (userInputOption.equals("3")) {
                pager.header("Kembalikan Buku");
                try {
                    UUID IDBuku = UUID.fromString(pager.customInput("ID Buku", true));
                    pager.footer();
                    Anggota.kembaliBuku(username, IDBuku);
                } catch (IllegalArgumentException e) {
                    pager.footer();
                    pager.info("ID buku tidak valid");
                }
            } else if (userInputOption.equals("4")) {
                pager.header("Tambah Buku");

                String judul = pager.customInput("Judul", true);
                String penulis = pager.customInput("Penulis", true);
                URL coverBuku;

                while (true) {
                    try {
                        coverBuku = new URI(pager.customInput("Cover Buku (url)", true)).toURL();
                        break;
                    } catch (URISyntaxException e) {
                        pager.message("invalid url");
                    } catch (MalformedURLException f) {
                        pager.message("invalid url");
                    } catch (IllegalArgumentException g) {
                        pager.message("invalid url");
                    }
                }

                int tahun;
                int bulan;
                int hari;
                LocalDate tanggalTerbit;

                while (true) {
                    try {
                        tahun = Integer.parseUnsignedInt(pager.customInput("Tahun terbit", true));
                        bulan = Integer.parseUnsignedInt(pager.customInput("Bulan terbit", true));
                        hari = Integer.parseUnsignedInt(pager.customInput("Hari terbit", true));
                        tanggalTerbit = LocalDate.of(tahun, bulan, hari);
                        break;
                    } catch (NumberFormatException e) {
                        pager.message("invalid input");
                    } catch (DateTimeException f) {
                        pager.message("invalid date");
                    }

                }

                perpustakaan.tambahBuku(new Buku(judul, penulis, coverBuku, tanggalTerbit));
                pager.footer();
            } else if (userInputOption.equals("5")) {
                perpustakaan.daftarBuku();
            } else if (userInputOption.equals("6")) {
                pager.header("Info Buku");
                try {
                    UUID IDBuku = UUID.fromString(pager.customInput("ID Buku", true));
                    pager.footer();
                    Buku buku = perpustakaan.infoBuku(IDBuku);
                    Buku.displayInfoBuku(buku);
                } catch (IllegalArgumentException e) {
                    pager.footer();
                    pager.info("ID buku tidak valid");
                }
            } else if (userInputOption.equals("7")) {
                while (true) {
                    pager.header("Cari Buku");
                    pager.message("(0) Cari berdasarkan ID buku");
                    pager.message("(1) Cari berdasarkan judul buku");
                    pager.message("(2) Cari berdasarkan penulis buku");
                    pager.message("(3) Kembali ke menu utama");
                    pager.spacer();

                    userInputOption = null;
                    userInputOption = pager.input();
                    if (userInputOption.equals("0")) {
                        Buku buku;
                        while (true) {
                            try {
                                UUID IDBuku = UUID.fromString(pager.customInput("ID buku", true));
                                pager.footer();
                                buku = Perpustakaan.cariIDBuku(IDBuku);
                                break;
                            } catch (IllegalArgumentException e) {
                                pager.message("ID buku tidak valid");
                            }
                        }
                        if (buku == null) {
                            break;
                        }
                        Buku.displayInfoBuku(buku);
                        break;
                    } else if (userInputOption.equals("1")) {
                        String judulBuku = pager.customInput("Judul buku", true);
                        pager.footer();
                        ArrayList<Buku> buku = Perpustakaan.cariJudulBuku(judulBuku);
                        if (buku != null) {
                            Buku.displayInfoBuku(buku);
                        }
                    } else if (userInputOption.equals("2")) {
                        String penulis = pager.customInput("Penulis buku", true);
                        pager.footer();
                        ArrayList<Buku> buku = Perpustakaan.cariPenulis(penulis);
                        if (buku != null) {
                            Buku.displayInfoBuku(buku);
                        }
                    } else if (userInputOption.equals("3")) {
                        pager.footer();
                        break;
                    } else {
                        pager.footer();
                        pager.info("invalid input");
                    }
                }
            } else if (loggedIn && userInputOption.equals("8")) {
                pager.info(new String[] { "Nama: " + anggota.getNama(), "Username: " + anggota.getUsername(),
                        "Password: " + anggota.getPassword() });
            } else if (loggedIn && userInputOption.equals("9")) {
                username = "";

                pager.header("Info");
                pager.message("Anda telah log out");
                pager.footer();
            } else if (userInputOption.equals("10")) {
                break;
            } else {
                pager.info("invalid input");
            }
        }

        scanner.close();
    }
}
