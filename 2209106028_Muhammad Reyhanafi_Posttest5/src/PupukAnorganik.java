final class PupukAnorganik extends Pupuk {
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
        System.out.println("ID Petani: " + getIdPetani());
        System.out.println("Jenis Pupuk: " + getJenisPupuk());
        System.out.println("Nama Pupuk: " + getNamaPupuk());
        System.out.println("Harga: " + getHarga());
        System.out.println("Komposisi: " + komposisi);
    }
}
