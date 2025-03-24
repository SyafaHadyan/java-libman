import java.util.UUID;
import java.util.HashMap;
import java.util.ArrayList;

public class Perpustakaan {
    private ArrayList<String> daftarBuku;
    private HashMap<UUID, String> daftarAnggota;

    public Perpustakaan() {
        this.daftarBuku = new ArrayList<>();
        this.daftarAnggota = new HashMap<>();
    }

    public Perpustakaan(ArrayList<String> daftarBuku) {
        this.daftarBuku = daftarBuku;
    }

    public void tambahBuku(Buku buku) {
        //
    }

    public void tambahAnggota(Anggota anggota) {
        //
    }

    public void pinjamBuku(UUID IDAnggota, UUID IDBuku) {
        //
    }

    public void kembaliBuku(UUID IDAnggota, UUID IDBuku) {
        //
    }
}
