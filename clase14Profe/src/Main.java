import java.sql.SQLException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
      Estudiante estudiante = new Estudiante();
      estudiante.setId(1l);
      estudiante.setNombre("Javier");
      estudiante.setApellido("Silva");

      EstudianteService estudianteService= new EstudianteService();
      // a estudiante lo trata como un estudianteh2DAO, estrategia de persistencia
      estudianteService.setEstudianteDao(new Estudianteh2Dao());
      estudianteService.guardarEstudiante(estudiante);



    }
}