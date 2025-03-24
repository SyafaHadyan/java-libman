import java.net.MalformedURLException;
import java.util.UUID;
import java.util.Scanner;

import library.Pager;
import app.buku.Buku;
import app.anggota.Anggota;
import app.perpustakaan.Perpustakaan;

public class AppRun {
    static Pager pager = new Pager();

    private static void invalidInput() {
        pager.header("Info");
        pager.message("Invalid Input");
        pager.message("Press any key to continue");
        pager.spacer();
        pager.input();
        pager.footer();
    }

    public static void main(String[] args) throws MalformedURLException {
        Scanner scanner = new Scanner(System.in);
        Buku buku = new Buku();
        Anggota anggota = new Anggota();
        Perpustakaan perpustakaan = new Perpustakaan();
        UUID IDAnggota;
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

                IDAnggota = anggota.getIDAnggota();
                nama = anggota.getNama();
                username = anggota.getUsername();
                password = anggota.getPassword();
            } else if (userInputOption.equals("1")) {
                pager.header("Login");
                anggota.login(pager.customInput("Nama", true), pager.customInput("Username", true),
                        pager.customInput("Password", true));
                pager.footer();

                IDAnggota = anggota.getIDAnggota();
                nama = anggota.getNama();
                username = anggota.getUsername();
                password = anggota.getPassword();
            } else if (userInputOption.equals("2")) {
                //
            } else if (userInputOption.equals("3")) {
                //
            } else if (userInputOption.equals("4")) {
                //
            } else if (userInputOption.equals("5")) {
                //
            } else if (userInputOption.equals("6")) {
                IDAnggota = null;
                nama = "";
                username = "";
                password = "";

                pager.header("Info");
                pager.message("Anda telah log out");
                pager.footer();
            } else if (userInputOption.equals("7")) {
                break;
            } else {
                invalidInput();
            }
        }

        scanner.close();
    }
}
