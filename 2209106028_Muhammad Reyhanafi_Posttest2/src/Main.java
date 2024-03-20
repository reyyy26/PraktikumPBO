import java.io.*;
import java.util.*;

public class Main {
    private static int batasan;
    private static InputStreamReader p = new InputStreamReader(System.in);
    private static BufferedReader input = new BufferedReader(p);

    private static ArrayList<Petani> petaniList = new ArrayList<>();
    private static ArrayList<Pupuk> pupukList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        boolean login_berhasil = false;

        while (!login_berhasil) {
            if (login.authenticate()) {
                clear();
                System.out.println("login Berhasil");
                while (true) {
                    System.out.println("========== Menu ==========");
                    System.out.println("1. Input Data Petani");
                    System.out.println("2. Input Data Pupuk");
                    System.out.println("3. Display Data");
                    System.out.println("4. Update Data");
                    System.out.println("5. Hapus Data");
                    System.out.println("6. Keluar");
                    System.out.println("==========================");
                    System.out.print("Pilih menu (1-5): ");
                    int choice = Integer.parseInt(input.readLine());

                    switch (choice) {
                        case 1:
                            inputPetani();
                            break;
                        case 2:
                            inputPupuk();
                            break;
                        case 3:
                            displayData();
                            break;
                        case 4:
                            updateData();
                            break;
                        case 5:
                            hapusData();
                            break;
                        case 6:
                            System.out.println("Terima kasih!");
                            System.exit(0);
                        default:
                            System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
                            break;
                    }
                }

            } else {
                clear();
                System.out.println("login gagal");
            }
        }
    }

    private static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void inputPetani() throws IOException {
        clear();
        System.out.println("===========================");
        System.out.print("Ingin memasukkan berapa data : ");
        batasan = Integer.parseInt(input.readLine());

        Set<String> existingIds = new HashSet<>();

        for (int i = 1; i <= batasan; i++) {
            boolean idPetaniValid = false;
            String idPetani = "";

            while (!idPetaniValid) {
                System.out.print("Masukkan ID Petani: ");
                idPetani = input.readLine();

                if (!existingIds.contains(idPetani)) {
                    idPetaniValid = true;
                    existingIds.add(idPetani);
                } else {
                    System.out.println("ID Petani sudah ada. Masukkan ID Petani yang berbeda.");
                }
            }

            System.out.print("Masukkan Nama Petani: ");
            String namaPetani = input.readLine();
            System.out.println("===========================");

            Petani petani = new Petani();
            petani.setId(idPetani);
            petani.setNama(namaPetani);
            petaniList.add(petani);
        }

        System.out.println("Data petani berhasil dimasukkan.");
    }

    private static void inputPupuk() throws IOException {
        clear();
        System.out.println("========================");
        System.out.print("Masukkan ID Petani: ");
        String idPetani = input.readLine();

        boolean idPetaniValid = false;
        for (Petani petani : petaniList) {
            if (petani.getId().equals(idPetani)) {
                idPetaniValid = true;
                break;
            }
        }

        if (!idPetaniValid) {
            System.out.println("ID Petani tidak valid. Masukkan data petani terlebih dahulu.");
            return;
        }

        System.out.println("===========================");
        System.out.print("Ingin memasukkan berapa data : ");
        batasan = Integer.parseInt(input.readLine());
        for (int i = 1; i <= batasan; i++) {
            System.out.print("Masukkan Jenis Pupuk: ");
            String jenisPupuk = input.readLine();
            System.out.print("Masukkan Harga Pupuk: ");
            double hargaPupuk = Double.parseDouble(input.readLine());
            System.out.println("===========================");

            Pupuk pupuk = new Pupuk();
            pupuk.setIdPetani(idPetani);
            pupuk.setJenisPupuk(jenisPupuk);
            pupuk.setHarga(hargaPupuk);
            pupukList.add(pupuk);
        }

        System.out.println("Data pupuk berhasil dimasukkan.");
    }

    public static void displayData() {
        clear();
        System.out.println("Data Petani:");

        if (petaniList.isEmpty()) {
            System.out.println("Data Kosong, Silahkan Melakukan Pengisian Data Terlebih Dahulu");
        } else {
            for (Petani petani : petaniList) {
                System.out.println("===========================");
                System.out.println("ID Petani: " + petani.getId());
                System.out.println("Nama Petani: " + petani.getNama());
                System.out.println("===========================");
                System.out.println("Data Pupuk: ");
                System.out.println("===========================");

                boolean foundPupuk = false;

                for (Pupuk pupuk : pupukList) {
                    if (pupuk.getIdPetani().equals(petani.getId())) {
                        System.out.println("Jenis Pupuk: " + pupuk.getJenisPupuk());
                        System.out.println("Harga Pupuk: " + pupuk.getHarga());
                        foundPupuk = true;
                    }
                }

                if (!foundPupuk) {
                    System.out.println("Data Pupuk Kosong untuk Petani ini");
                }

                System.out.println("===========================");
            }
        }
    }

    private static void updateData() throws IOException {
        clear();
        System.out.println("===== Menu Update Data =====");
        System.out.println("1. Update Data Petani");
        System.out.println("2. Update Data Pupuk");
        System.out.println("============================");
        System.out.print("Pilih menu (1-2): ");
        int menuChoice = Integer.parseInt(input.readLine());

        switch (menuChoice) {
            case 1:
                updateDataPetani();
                break;
            case 2:
                updateDataPupuk();
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    private static void updateDataPetani() throws IOException {
        System.out.println("List Petani yang tersedia:");
        for (Petani petani : petaniList) {
            System.out.println("ID Petani: " + petani.getId() + ", Nama Petani: " + petani.getNama());
        }

        System.out.print("Masukkan ID Petani yang akan diupdate: ");
        String idPetaniToUpdate = input.readLine();

        Petani petaniToUpdate = null;
        int indexToUpdate = -1;

        for (int i = 0; i < petaniList.size(); i++) {
            if (petaniList.get(i).getId().equals(idPetaniToUpdate)) {
                petaniToUpdate = petaniList.get(i);
                indexToUpdate = i;
                break;
            }
        }

        if (petaniToUpdate != null) {
            System.out.print("Masukkan Nama Petani baru: ");
            String newNamaPetani = input.readLine();

            // Perbarui nama petani menggunakan setter
            petaniToUpdate.setNama(newNamaPetani);

            // Perbarui daftar petani dengan petani yang telah diubah
            petaniList.set(indexToUpdate, petaniToUpdate);

            System.out.println("Data petani berhasil diupdate.");
        } else {
            System.out.println("ID Petani tidak ditemukan. Tidak ada data yang diupdate.");
        }
    }

    private static void updateDataPupuk() throws IOException {
        System.out.print("Masukkan ID Petani: ");
        String idPetani = input.readLine();

        System.out.println("Pilih pupuk yang akan diupdate:");

        for (Pupuk pupuk : pupukList) {
            if (pupuk.getIdPetani().equals(idPetani)) {
                System.out.println("Jenis Pupuk: " + pupuk.getJenisPupuk());
            }
        }

        System.out.print("Masukkan Jenis Pupuk yang akan diupdate: ");
        String jenisPupukToUpdate = input.readLine();

        Pupuk pupukToUpdate = null;
        int indexToUpdate = -1;

        for (int i = 0; i < pupukList.size(); i++) {
            if (pupukList.get(i).getIdPetani().equals(idPetani) && pupukList.get(i).getJenisPupuk().equals(jenisPupukToUpdate)) {
                pupukToUpdate = pupukList.get(i);
                indexToUpdate = i;
                break;
            }
        }

        if (pupukToUpdate != null) {
            System.out.print("Masukkan Jenis Pupuk baru: ");
            String newJenisPupuk = input.readLine();
            System.out.print("Masukkan Harga Yang Baru: ");
            double hargaBaru = Double.parseDouble(input.readLine());

            // update pupuk's properties using setters
            pupukToUpdate.setJenisPupuk(newJenisPupuk);
            pupukToUpdate.setHarga(hargaBaru);

            // update pupuk list with the modified pupuk
            pupukList.set(indexToUpdate, pupukToUpdate);

            System.out.println("Data pupuk berhasil diupdate.");
        } else {
            System.out.println("Data pupuk tidak ditemukan. Tidak ada data yang diupdate.");
        }
    }

    private static void hapusData() throws IOException {
        clear();
        System.out.println("===== Menu Hapus Data =====");
        System.out.println("1. Hapus Data Petani");
        System.out.println("2. Hapus Data Pupuk");
        System.out.println("===========================");
        System.out.print("Pilih menu (1-2): ");
        int menuChoice = Integer.parseInt(input.readLine());

        switch (menuChoice) {
            case 1:
                hapusDataPetani();
                break;
            case 2:
                hapusDataPupuk();
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    private static void hapusDataPetani() throws IOException {
        System.out.println("List Petani yang tersedia:");
        for (Petani petani : petaniList) {
            System.out.println("ID Petani: " + petani.getId() + ", Nama Petani: " + petani.getNama());
        }

        System.out.print("Masukkan ID Petani yang akan dihapus: ");
        String idPetani = input.readLine();

        // remove pupuk related to the petani
        pupukList.removeIf(pupuk -> pupuk.getIdPetani().equals(idPetani));

        Iterator<Petani> iterator = petaniList.iterator();

        while (iterator.hasNext()) {
            Petani petani = iterator.next();
            if (petani.getId().equals(idPetani)) {
                iterator.remove();
                System.out.println("Data petani berhasil dihapus.");
                return;
            }
        }

        System.out.println("ID Petani tidak ditemukan. Tidak ada data yang dihapus.");
    }

    private static void hapusDataPupuk() throws IOException {
        System.out.print("Masukkan ID Petani: ");
        String idPetani = input.readLine();

        System.out.println("Pilih pupuk yang akan dihapus:");

        Iterator<Pupuk> iterator = pupukList.iterator();
        while (iterator.hasNext()) {
            Pupuk pupuk = iterator.next();
            if (pupuk.getIdPetani().equals(idPetani)) {
                System.out.println("Jenis Pupuk: " + pupuk.getJenisPupuk());
                System.out.print("Apakah Anda yakin ingin menghapus pupuk ini? (y/n): ");
                String confirmation = input.readLine();
                if (confirmation.equalsIgnoreCase("y")) {
                    iterator.remove();
                    System.out.println("Data pupuk berhasil dihapus.");
                } else {
                    System.out.println("Penghapusan data pupuk dibatalkan.");
                }
            }
        }
    }
}
