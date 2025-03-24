package app.buku;

import java.net.URL;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.util.UUID;

public class Buku {
    private String judul;
    private String penulis;
    private String usernamePeminjam;
    private String namaPeminjam;
    private boolean status;
    private UUID IDBuku;
    private URL coverBuku;
    private LocalDate tanggalTerbit;

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

    public void pinjamBuku(String usernamePeminjam, String namaPeminjam) {
        if (this.status) {
            this.usernamePeminjam = usernamePeminjam;
            this.namaPeminjam = namaPeminjam;
            this.status = false;
        }
    }

    public void kembaliBuku() {
        if (!this.status) {
            this.usernamePeminjam = null;
            this.namaPeminjam = null;
            this.status = true;
        }
    }
}
