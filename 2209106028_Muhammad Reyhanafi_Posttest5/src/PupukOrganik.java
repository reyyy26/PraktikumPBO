final class PupukOrganik extends Pupuk {
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
        System.out.println("ID Petani: " + getIdPetani());
        System.out.println("Jenis Pupuk: " + getJenisPupuk());
        System.out.println("Nama Pupuk: " + getNamaPupuk());
        System.out.println("Harga: " + getHarga());
        System.out.println("Kandungan: " + kandungan);
    }
}