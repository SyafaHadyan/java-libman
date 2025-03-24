package app.perpustakaan;

import java.util.UUID;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

import library.Pager;
import app.buku.Buku;
import app.anggota.Anggota;
import exception.BukuTidakDipinjamException;
import exception.BukuTidakDitemukanException;
import exception.AnggotaTidakDitemukanException;
import exception.BukuTidakTersediaException;

public class Perpustakaan {
    private static ArrayList<Buku> daftarBuku = new ArrayList<>();
    private static HashMap<String, ArrayList<String>> daftarAnggota = new HashMap<>();

    static Pager pager = new Pager();

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
                Buku.displayInfoBuku(i, count++);
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

    public static void pinjamBuku(String usernameAnggota, UUID IDBuku) {
        if (daftarBuku.isEmpty()) {
            pager.info("Perpustakaan masih belum memiliki buku");
        }

        int index = 0;
        boolean found = false;
        try {
            for (Buku i : daftarBuku) {
                if (i.getIDBuku().equals(IDBuku)) {
                    if (!i.getStatus()) {
                        throw new BukuTidakTersediaException("Buku dengan ID " + IDBuku + " tidak tersedia");
                    }

                    i.setStatus(false);
                    daftarBuku.set(index++, i);
                    return;
                }
                index++;

                if (!found) {
                    throw new BukuTidakDitemukanException("Buku dengan ID " + IDBuku + " tidak ditemukan");
                }
            }
        } catch (BukuTidakTersediaException e) {
            pager.info(e.getMessage());
        } catch (BukuTidakDitemukanException f) {
            pager.info(f.getMessage());
        }
    }

    public static void kembaliBuku(String usernameAnggota, UUID IDBuku) {
        if (daftarBuku.isEmpty()) {
            pager.info("Perpustakaan masih belum memiliki buku");
        }

        int index = 0;
        boolean found = false;

        try {
            for (Buku i : daftarBuku) {
                if (i.getIDBuku().equals(IDBuku)) {
                    if (i.getStatus()) {
                        throw new BukuTidakDipinjamException("Buku dengan ID " + IDBuku + " tidak dipinjam");
                    }

                    i.setStatus(true);
                    daftarBuku.set(index, i);
                    return;
                }
                index++;

                if (!found) {
                    throw new BukuTidakDitemukanException("Buku dengan ID " + IDBuku + " tidak ditemukan");
                }
            }
        } catch (BukuTidakDitemukanException e) {
            pager.info(e.getMessage());
        } catch (BukuTidakDipinjamException f) {
            pager.info(f.getMessage());
        }
    }

    public Buku infoBuku(UUID IDBuku) {
        if (daftarBuku.isEmpty()) {
            pager.info("Perpustakaan masih belum memiliki buku");
            return null;
        }

        int index = 0;
        boolean found = false;
        try {
            for (Buku i : daftarBuku) {
                if (i.getIDBuku().equals(IDBuku)) {
                    return i;
                }
                index++;

                if (!found) {
                    throw new BukuTidakDitemukanException("Buku dengan ID " + IDBuku + " tidak ditemukan");
                }
            }
        } catch (BukuTidakDitemukanException e) {
            pager.info(e.getMessage());
        }

        return null;
    }
}
