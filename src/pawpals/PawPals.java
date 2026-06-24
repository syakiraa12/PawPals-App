/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pawpals;

/**
 *
 * @author Syakira
 */
public class PawPals {
    public static void main(String[] args) {
        java.sql.Connection c = Koneksi.getKoneksi();
        if (c != null) {
            System.out.println("Koneksi sukses dan siap digunakan!"); 
           new LoginUser().setVisible(true); 
        }
    }
}
