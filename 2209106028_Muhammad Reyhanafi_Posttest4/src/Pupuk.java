class Pupuk {
    private String idPetani;
    private String jenisPupuk;
    private String namaPupuk;
    private double harga;

    public Pupuk(String idPetani, String jenisPupuk, String namaPupuk, double harga) {
        this.idPetani = idPetani;
        this.jenisPupuk = jenisPupuk;
        this.namaPupuk = namaPupuk;
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

    public String getNamaPupuk() {
        return namaPupuk;
    }

    public void setNamaPupuk(String namaPupuk) {
        this.namaPupuk = namaPupuk;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public void display() {
        System.out.println("ID Petani: " + idPetani);
        System.out.println("Jenis Pupuk: " + jenisPupuk);
        System.out.println("Nama Pupuk: " + namaPupuk);
        System.out.println("Harga: " + harga);
    }
}

class PupukOrganik extends Pupuk {
    private String kandungan;

    public PupukOrganik(String idPetani, String jenisPupuk, String namaPupuk, double harga, String kandungan) {
        super(idPetani, jenisPupuk, namaPupuk, harga);
        this.kandungan = kandungan;
    }

    public String getKandungan() {
        return kandungan;
    }

    public void setKandungan(String kandungan) {
        this.kandungan = kandungan;
    }

    @Override
    public void display() {
        super.display(); 
        System.out.println("Kandungan: " + kandungan);
    }
}

class PupukAnorganik extends Pupuk {
    private String komposisi;

    public PupukAnorganik(String idPetani, String jenisPupuk, String namaPupuk, double harga, String komposisi) {
        super(idPetani, jenisPupuk, namaPupuk, harga); 
        this.komposisi = komposisi;
    }

    public String getKomposisi() {
        return komposisi;
    }

    public void setKomposisi(String komposisi) {
        this.komposisi = komposisi;
    }

    @Override
    public void display() {
        super.display(); 
        System.out.println("Komposisi: " + komposisi);
    }
}
