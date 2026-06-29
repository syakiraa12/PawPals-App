package pawpals;

public class Pet implements PetAction {

    private String nama;
    private int umur;
    private String jenis;

    // Constructor kosong
    public Pet() {

    }

    // Constructor berparameter
    public Pet(String nama, int umur, String jenis) {
        this.nama = nama;
        this.umur = umur;
        this.jenis = jenis;
    }

    // Getter
    public String getNama() {
        return nama;
    }

    public int getUmur() {
        return umur;
    }

    public String getJenis() {
        return jenis;
    }

    // Setter
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    // Method
    public void tampilInfo() {
        System.out.println("Nama Hewan : " + nama);
        System.out.println("Umur : " + umur + " bulan");
        System.out.println("Jenis : " + jenis);
    }
}