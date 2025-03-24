package app.perpustakaan;

import java.util.UUID;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

import app.buku.Buku;
import app.anggota.Anggota;

public class Perpustakaan {
    private ArrayList<String> daftarBuku;
    static private HashMap<String, ArrayList<String>> daftarAnggota;

    public Perpustakaan() {
        this.daftarBuku = new ArrayList<>();
        daftarAnggota = new HashMap<>();
    }

    public Perpustakaan(ArrayList<String> daftarBuku) {
        this.daftarBuku = daftarBuku;
    }

    public void tambahBuku(Buku buku) {
        //
    }

    public void tambahAnggota(Anggota anggota) {
        daftarAnggota.put(anggota.getUsername(),
                new ArrayList<>(Arrays.asList(anggota.getNama(), anggota.getPassword())));
    }

    public static boolean cekAnggota(String username) {
        return daftarAnggota.containsKey(username);
    }

    public static boolean cekPassword(String username, String password) {
        return daftarAnggota.get(username).get(0).equals(password);
    }

    public void pinjamBuku(UUID IDAnggota, UUID IDBuku) {
        //
    }

    public void kembaliBuku(UUID IDAnggota, UUID IDBuku) {
        //
    }
}
