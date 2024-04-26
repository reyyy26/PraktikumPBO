public abstract class Pupuk {
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

    // Abstract method to be implemented by subclasses
    public abstract void display();

}