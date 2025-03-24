import java.net.URL;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.util.UUID;

public class Buku {
    private String judul;
    private String penulis;
    private String namaPeminjam;
    private UUID IDPeminjam;
    private UUID IDBuku;
    private URL coverBuku;
    private LocalDate tanggalTerbit;

    public Buku() throws MalformedURLException {
        this.judul = "Operating System Concepts, 10th Edition";
        this.penulis = "Abraham Silberschatz";
        this.namaPeminjam = "Full Person Name";
        this.IDPeminjam = UUID.randomUUID();
        this.IDBuku = UUID.randomUUID();
        this.coverBuku = new URL("https://codex.cs.yale.edu/avi/os-book/OS10/images/os10-cover.jpg");
        this.tanggalTerbit = LocalDate.of(2000, 01, 01);
    }

    public Buku(String judul, String penulis, String namaPeminjam, UUID IDPeminjam, UUID IDBuku, URL coverBuku,
            LocalDate tanggalTerbit) {
        this.judul = judul;
        this.penulis = penulis;
        this.namaPeminjam = namaPeminjam;
        this.IDPeminjam = IDPeminjam;
        this.IDBuku = IDBuku;
        this.coverBuku = coverBuku;
        this.tanggalTerbit = tanggalTerbit;
    }

    public void pinjamBuku(UUID IDPeminjam, String namaPeminjam) {
        this.IDPeminjam = IDPeminjam;
        this.namaPeminjam = namaPeminjam;
    }

    public void kembaliBuku() {
        this.namaPeminjam = null;
        this.IDPeminjam = null;
    }
}
