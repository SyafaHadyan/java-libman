import java.net.URL;
import java.net.MalformedURLException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.UUID;

import java.util.Scanner;

import library.Pager;
import app.buku.Buku;
import app.anggota.Anggota;
import app.perpustakaan.Perpustakaan;

public class AppRun {

    public static void main(String[] args) throws MalformedURLException {
        final String VERSION = "v1.0.0";

        Scanner scanner = new Scanner(System.in);
        Pager pager = new Pager();
        Anggota anggota = new Anggota();
        Perpustakaan perpustakaan = new Perpustakaan();
        String nama = "";
        String username = "";
        String password = "";
        boolean loggedIn = false;

        while (true) {
            loggedIn = !username.isEmpty();
            pager.header("Java libMan " + VERSION);

            if (loggedIn) {
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
            pager.message("(3) Tambah Buku");
            pager.message("(4) Lihat Daftar Buku");
            pager.message("(5) Lihat Info Buku");

            if (loggedIn) {
                pager.message("(6) Lihat Info User");
                pager.message("(7) Log Out");
            }

            pager.message("(8) Keluar");
            pager.spacer();
            String userInputOption = pager.input();
            pager.footer();

            if (!loggedIn && userInputOption.equals("0")) {
                pager.header("anggota User Baru");
                boolean registerConfirm = anggota.register(pager.customInput("Nama", true),
                        pager.customInput("Username", true),
                        pager.customInput("Password", true));
                perpustakaan.tambahAnggota(anggota);
                pager.footer();

                nama = anggota.getNama();
                username = anggota.getUsername();
                password = anggota.getPassword();

                if (!registerConfirm) {
                    pager.info("silahkan gunakan username lain");
                }
            } else if (!loggedIn && userInputOption.equals("1")) {
                pager.header("Login");
                boolean loginConfirm = anggota.login(pager.customInput("Username", true),
                        pager.customInput("Password", true));
                pager.footer();

                nama = anggota.getNama();
                username = anggota.getUsername();
                password = anggota.getPassword();

                if (!loginConfirm) {
                    pager.info("username atau password salah");
                }
            } else if (userInputOption.equals("2")) {
                //
            } else if (userInputOption.equals("3")) {
                pager.header("Tambah Buku");

                String judul = pager.customInput("Judul", true);
                String penulis = pager.customInput("Penulis", true);
                URL coverBuku;

                while (true) {
                    try {
                        coverBuku = new URL(pager.customInput("Cover Buku (url)", true));
                        break;
                    } catch (MalformedURLException e) {
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
            } else if (userInputOption.equals("4")) {
                perpustakaan.daftarBuku();
            } else if (loggedIn && userInputOption.equals("6")) {
                pager.info(new String[] { "Nama: " + anggota.getNama(), "Username: " + anggota.getUsername(),
                        "Password: " + anggota.getPassword() });
            } else if (loggedIn && userInputOption.equals("7")) {
                nama = "";
                username = "";
                password = "";

                pager.header("Info");
                pager.message("Anda telah log out");
                pager.footer();
            } else if (userInputOption.equals("8")) {
                break;
            } else {
                pager.info("invalid input");
            }
        }

        scanner.close();
    }
}
