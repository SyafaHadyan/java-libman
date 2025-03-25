package app.buku;

import java.net.URL;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.util.UUID;
import java.util.ArrayList;

import library.Pager;

public class Buku {
    private String judul;
    private String penulis;
    private String usernamePeminjam;
    private String namaPeminjam;
    private boolean status;
    private UUID IDBuku;
    private URL coverBuku;
    private LocalDate tanggalTerbit;

    static Pager pager = new Pager();

    public Buku() throws MalformedURLException {
        this.judul = "Operating System Concepts, 10th Edition";
        this.penulis = "Abraham Silberschatz";
        this.usernamePeminjam = null;
        this.namaPeminjam = "Full Person Name";
        this.status = true;
        this.IDBuku = UUID.randomUUID();
        this.coverBuku = new URL("https://codex.cs.yale.edu/avi/os-book/OS10/images/os10-cover.jpg");
        this.tanggalTerbit = LocalDate.of(2000, 01, 01);
    }

    public Buku(String judul, String penulis, URL coverBuku, LocalDate tanggalTerbit) {
        this.judul = judul;
        this.penulis = penulis;
        this.usernamePeminjam = null;
        this.namaPeminjam = null;
        this.status = true;
        this.IDBuku = UUID.randomUUID();
        this.coverBuku = coverBuku;
        this.tanggalTerbit = tanggalTerbit;
    }

    private static void parseInfoBukuToPager(Buku buku, int count) {
        pager.info(new String[] { "Buku ke-" + count, "", "Judul: " + buku.getJudul(),
                "Penulis: " + buku.getPenulis(), "Username Peminjam: " + buku.getUsernamePeminjam(),
                "Nama Peminjam: " + buku.getNamaPeminjam(), "Tersedia: " + buku.getStatus(),
                "ID Buku: " + buku.getIDBuku(), "Cover Buku: " + buku.getCoverBuku(),
                "Tanggal Terbit: " + buku.getTanggalTerbit() });
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public void setUsernamePeminjam(String usernamePeminjam) {
        this.usernamePeminjam = usernamePeminjam;
    }

    public void setNamaPeminjam(String namaPeminjam) {
        this.namaPeminjam = namaPeminjam;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setIDBuku(UUID IDBuku) {
        this.IDBuku = IDBuku;
    }

    public void setCoverBuku(URL coverBuku) {
        this.coverBuku = coverBuku;
    }

    public void setTanggalTerbit(LocalDate tanggalTerbit) {
        this.tanggalTerbit = tanggalTerbit;
    }

    public String getJudul() {
        return this.judul;
    }

    public String getPenulis() {
        return this.penulis;
    }

    public String getUsernamePeminjam() {
        return this.usernamePeminjam;
    }

    public String getNamaPeminjam() {
        return this.namaPeminjam;
    }

    public boolean getStatus() {
        return this.status;
    }

    public UUID getIDBuku() {
        return this.IDBuku;
    }

    public URL getCoverBuku() {
        return this.coverBuku;
    }

    public LocalDate getTanggalTerbit() {
        return this.tanggalTerbit;
    }

    public static void displayInfoBuku(Buku buku, int count) {
        for (int i = 0; i < count; i++) {
            parseInfoBukuToPager(buku, i);
        }
    }

    public static void displayInfoBuku(ArrayList<Buku> buku) {
        int count = 0;
        for (Buku i : buku) {
            parseInfoBukuToPager(i, count++);
        }
    }

    public static void displayInfoBuku(Buku buku) {
        parseInfoBukuToPager(buku, 0);
    }
}
