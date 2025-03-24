import java.net.MalformedURLException;
import java.util.UUID;
import java.util.Scanner;

import library.Pager;
import app.buku.Buku;
import app.anggota.Anggota;
import app.perpustakaan.Perpustakaan;

public class AppRun {

    public static void main(String[] args) throws MalformedURLException {
        Scanner scanner = new Scanner(System.in);
        Pager pager = new Pager();
        Buku buku = new Buku();
        Anggota anggota = new Anggota();
        Perpustakaan perpustakaan = new Perpustakaan();
        String nama = "";
        String username = "";
        String password = "";

        while (true) {
            pager.header("Java libMan");

            if (username.isEmpty()) {
                pager.message("Anda belum login");
            } else {
                pager.message("Anda login sebagai: " + username);
            }
            pager.spacer();

            pager.message("(0) Register");
            pager.message("(1) Login");
            pager.message("(2) Pinjam Buku");
            pager.message("(3) Lihat Daftar Buku");
            pager.message("(4) Lihat Info Buku");
            pager.message("(5) Lihat Info User");
            pager.message("(6) Log Out");
            pager.message("(7) Keluar");
            pager.spacer();
            String userInputOption = pager.input();
            pager.footer();

            if (userInputOption.equals("0")) {
                pager.header("anggota User Baru");
                anggota.register(pager.customInput("Nama", true), pager.customInput("Username", true),
                        pager.customInput("Password", true));
                perpustakaan.tambahAnggota(anggota);
                pager.footer();

                nama = anggota.getNama();
                username = anggota.getUsername();
                password = anggota.getPassword();

                if (username.isEmpty()) {
                    pager.info("silahkan gunakan username lain");
                }
            } else if (userInputOption.equals("1")) {
                pager.header("Login");
                anggota.login(pager.customInput("Username", true), pager.customInput("Password", true));
                pager.footer();

                nama = anggota.getNama();
                username = anggota.getUsername();
                password = anggota.getPassword();

                if (username.isEmpty()) {
                    pager.info("username atau password salah");
                }
            } else if (userInputOption.equals("2")) {
                //
            } else if (userInputOption.equals("3")) {
                //
            } else if (userInputOption.equals("4")) {
                //
            } else if (userInputOption.equals("5")) {
                //
            } else if (userInputOption.equals("6")) {
                nama = "";
                username = "";
                password = "";

                pager.header("Info");
                pager.message("Anda telah log out");
                pager.footer();
            } else if (userInputOption.equals("7")) {
                break;
            } else {
                pager.info("invalid input");
            }
        }

        scanner.close();
    }
}
