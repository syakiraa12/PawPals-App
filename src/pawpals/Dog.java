package pawpals;

public class Dog extends Pet implements PetAction {

    private String ras;

    // Constructor
    public Dog(String nama, int umur, String jenis, String ras) {
        super(nama, umur, jenis);
        this.ras = ras;
    }

    public String getRas() {
        return ras;
    }

    public void setRas(String ras) {
        this.ras = ras;
    }

    // Overriding dari interface
    @Override
    public void tampilInfo() {
        super.tampilInfo();
        System.out.println("Ras : " + ras);
    }

    // Overloading
    public void makan() {
        System.out.println(getNama() + " sedang makan.");
    }

    public void makan(String makanan) {
        System.out.println(getNama() + " sedang makan " + makanan);
    }
}