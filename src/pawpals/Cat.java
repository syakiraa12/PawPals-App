package pawpals;

/***
 * 
 * @author Syakira
 * Inheritance
 */
public class Cat extends Pet implements PetAction {

    private String warnaBulu;

    // Constructor
    public Cat(String nama, int umur, String jenis, String warnaBulu) {
        super(nama, umur, jenis); //super
        this.warnaBulu = warnaBulu;
    }

    public String getWarnaBulu() {
        return warnaBulu;
    }

    public void setWarnaBulu(String warnaBulu) {
        this.warnaBulu = warnaBulu;
    }

    // Overriding
    @Override
    public void tampilInfo() {
        super.tampilInfo();
        System.out.println("Warna Bulu : " + warnaBulu);
    }

    // Overloading
    public void tidur() {
        System.out.println(getNama() + " sedang tidur.");
    }

    public void tidur(int jam) {
        System.out.println(getNama() + " tidur selama " + jam + " jam.");
    }
}