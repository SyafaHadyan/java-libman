package com.filkom.javalibman.app.anggota;

import java.util.UUID;
import java.util.ArrayList;

import com.filkom.javalibman.library.Pager;
import com.filkom.javalibman.app.perpustakaan.Perpustakaan;
import com.filkom.javalibman.exception.UnauthorizedException;

public class Anggota {
    private String nama;
    private String username;
    private String password;

    static Pager pager = new Pager();

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
        try {
            if (username == null || username.isEmpty()) {
                throw new UnauthorizedException("User belum melakukan login");
            }
            Perpustakaan.pinjamBuku(username, IDBuku);
        } catch (UnauthorizedException e) {
            pager.info(e.getMessage());
        }
    }

    public static void kembaliBuku(String username, UUID IDBuku) {
        try {
            if (username == null || username.isEmpty()) {
                throw new UnauthorizedException("User belum melakukan login");
            }
            Perpustakaan.kembaliBuku(username, IDBuku);
        } catch (UnauthorizedException e) {
            pager.info(e.getMessage());
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
