package pawpals;

public interface PetAction {

    // Method abstrak
    void tampilInfo();

    // Default method
    default void salam() {
        System.out.println("Selamat datang di PawPals");
    }

    // Static method
    static void infoAplikasi() {
        System.out.println("Aplikasi PawPals");
    }
}