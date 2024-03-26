
class Pupuk {
    private String idPetani;
    private String jenisPupuk;
    private String namaPupuk;
    private double harga;

    // Constructor dengan parameter
    public Pupuk(String idPetani, String jenisPupuk, String namaPupuk, double harga) {
        this.idPetani = idPetani;
        this.jenisPupuk = jenisPupuk;
        this.namaPupuk =  namaPupuk;
        this.harga = harga;
    }

    public String getIdPetani() {
        return idPetani;
    }

    public void setIdPetani(String idPetani) {
        this.idPetani = idPetani;
    }

    public String getJenisPupuk() {
        return jenisPupuk;
    }

    public void setJenisPupuk(String jenisPupuk) {
        this.jenisPupuk = jenisPupuk;
    }

    public String  getNamaPupuk() {
        return namaPupuk;
    }

    public void  setNamaPupuk(String namaPupuk) {
        this.namaPupuk = namaPupuk;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
}

// Subclass Pertama dari Pupuk untuk pupuk organik
class PupukOrganik extends Pupuk {
    private String kandungan;

    // Constructor untuk inisialisasi
    public PupukOrganik(String idPetani, String jenisPupuk, String namaPupuk, double harga, String kandungan) {
        super(idPetani, jenisPupuk, namaPupuk, harga); // Memanggil constructor kelas induk
        this.kandungan = kandungan;
    }

    public String getKandungan() {
        return kandungan;
    }

    public void setKandungan(String kandungan) {
        this.kandungan = kandungan;
    }

    // Metode tambahan untuk menampilkan informasi pupuk organik
    public void display() {
        System.out.println("ID Petani: " + getIdPetani());
        System.out.println("Jenis Pupuk: " + getJenisPupuk());
        System.out.println("Nama Pupuk: " + getNamaPupuk());
        System.out.println("Harga: " + getHarga());
        System.out.println("Kandungan: " + kandungan);
    }
}

// Subclass Kedua dari Pupuk untuk pupuk anorganik
class PupukAnorganik extends Pupuk {
    private String komposisi;

    // Constructor untuk inisialisasi
    public PupukAnorganik(String idPetani, String jenisPupuk, String namaPupuk, double harga, String komposisi) {
        super(idPetani, jenisPupuk, namaPupuk , harga); // Memanggil constructor kelas induk
        this.komposisi = komposisi;
    }

    public String getKomposisi() {
        return komposisi;
    }

    public void setKomposisi(String komposisi) {
        this.komposisi = komposisi;
    }

    // Metode tambahan untuk menampilkan informasi pupuk anorganik
    public void display() {
        System.out.println("ID Petani: " + getIdPetani());
        System.out.println("Jenis Pupuk: " + getJenisPupuk());
        System.out.println("Nama Pupuk: " + getNamaPupuk());
        System.out.println("Harga: " + getHarga());
        System.out.println("Komposisi: " + komposisi);
    }
}