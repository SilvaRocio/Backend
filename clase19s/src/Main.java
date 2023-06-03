import java.io.*;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Contacto c1= new Contacto("rocio","rocio@gmail.com",45456);
        Contacto c2= new Contacto("rodolfo","rodolfo@gmail.com",45456);
        Contacto c3= new Contacto("ricardo","ricardo@gmail.com",45456);
        Contacto c4= new Contacto("marcos","marcos@gmail.com",45456);

        ArrayList<Contacto> lista1 = new ArrayList<>();

        lista1.add(c1);
        lista1.add(c2);
        lista1.add(c3);
        lista1.add(c4);

        try {
            FileOutputStream file = new FileOutputStream("cont.dat");
            ObjectOutputStream archivo= new ObjectOutputStream(file);
            archivo.writeObject(lista1);

            archivo.close();

            FileInputStream abrir= new FileInputStream("cont.dat");
            ObjectInputStream archivoA= new ObjectInputStream(abrir);

            ArrayList<Contacto> coleccion;

                coleccion= (ArrayList<Contacto>) archivoA.readObject();
                System.out.println("La primera lista de contactos es : ");
                System.out.println("-------------------------------------");
                for (Contacto x:coleccion) {
                    System.out.println(x);
                }

            archivoA.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}