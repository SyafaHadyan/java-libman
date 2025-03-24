package app.perpustakaan;

import java.util.UUID;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

import library.Pager;
import app.buku.Buku;
import app.anggota.Anggota;

public class Perpustakaan {
    static private ArrayList<Buku> daftarBuku = new ArrayList<>();
    static private HashMap<String, ArrayList<String>> daftarAnggota = new HashMap<>();
    Pager pager = new Pager();

    public void tambahBuku(Buku buku) {
        daftarBuku.add(buku);
    }

    public void daftarBuku() {
        pager.info(String.valueOf("Total Jumlah Buku: " + daftarBuku.size()));

        if (daftarBuku.isEmpty()) {
            pager.info("Perpustakaan masih belum memiliki buku");
        } else {
            int count = 1;
            for (Buku i : daftarBuku) {
                pager.info(new String[] { "Buku ke-" + count++, "", "Judul: " + i.getJudul(),
                        "Penulis: " + i.getPenulis(), "Username Peminjam: " + i.getUsernamePeminjam(),
                        "Nama Peminjam: " + i.getNamaPeminjam(), "Tersedia: " + i.getStatus(),
                        "ID Buku: " + i.getIDBuku(), "Cover Buku: " + i.getCoverBuku(),
                        "Tanggal Terbit: " + i.getTanggalTerbit(), "" });
            }
        }
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
