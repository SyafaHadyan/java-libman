import java.util.UUID;
import java.util.ArrayList;

public class Anggota {
    private String nama;
    private UUID IDAnggota;
    private ArrayList<String> daftarBukuDipinjam;

    public Anggota() {
        this.nama = "Full Person Name";
        this.IDAnggota = UUID.randomUUID();
        this.daftarBukuDipinjam = new ArrayList<>();
    }

    public Anggota(String nama) {
        this.nama = nama;
        this.IDAnggota = UUID.randomUUID();
        this.daftarBukuDipinjam = new ArrayList<>();
    }
}
