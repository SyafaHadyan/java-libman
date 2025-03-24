package app.anggota;

import java.util.UUID;
import java.util.ArrayList;

import library.Pager;
import app.perpustakaan.Perpustakaan;

public class Anggota {
    private String nama;
    private String username;
    private String password;

    Pager pager = new Pager();

    public boolean register(String nama, String username, String password) {
        if (Perpustakaan.cekAnggota(username)) {
            this.nama = "";
            this.username = "";
            this.password = "";
            return false;
        } else {
            this.nama = nama;
            this.username = username;
            this.password = password;
            return true;
        }
    }

    public boolean login(String username, String password) {
        if (Perpustakaan.cekAnggota(username) && Perpustakaan.cekPassword(username, password)) {
            this.nama = "";
            this.username = username;
            this.password = password;
            return true;
        } else {
            this.nama = "";
            this.username = "";
            this.password = "";
            return false;
        }
    }

    public static void pinjamBuku(String username, UUID IDBuku) {
        Perpustakaan.pinjamBuku(username, IDBuku);
    }

    public static void kembaliBuku(String username, UUID IDBuku) {
        Perpustakaan.kembaliBuku(username, IDBuku);
    }

    public String getNama() {
        return this.nama;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}
