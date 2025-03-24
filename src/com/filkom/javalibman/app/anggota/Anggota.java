package app.anggota;

import java.util.UUID;
import java.util.ArrayList;

import library.Pager;
import app.perpustakaan.Perpustakaan;

public class Anggota {
    private String nama;
    private String username;
    private String password;

    public void register(String nama, String username, String password) {
        if (Perpustakaan.cekAnggota(username)) {
            this.nama = "";
            this.username = "";
            this.password = "";
        } else {
            this.nama = nama;
            this.username = username;
            this.password = password;
        }
    }

    public void login(String username, String password) {
        if (Perpustakaan.cekAnggota(username) && Perpustakaan.cekPassword(username, password)) {
            this.nama = "";
            this.username = username;
            this.password = password;
        } else {
            this.nama = "";
            this.username = "";
            this.password = "";
        }
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
