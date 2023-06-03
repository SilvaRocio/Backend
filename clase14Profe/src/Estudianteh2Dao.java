import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public  class Estudianteh2Dao implements InterfaceDAO<Estudiante>{


    private final static  String driver="org.h2.Driver";
    private final static String url="jdbc:h2:~/estudiantes";
    private final static String user="sa";
    private final static String password="";
    @Override
    public Estudiante guardar(Estudiante estudiante) throws SQLException, ClassNotFoundException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        // 1 levantar el driver y conectarnos
        try{
            Class.forName(driver);
            connection= DriverManager.getConnection(url,user,password);
            // 2 crear una sentencia
           preparedStatement= connection.prepareStatement("INSERT INTO estudiantes VALUES (?,?,?)");
           preparedStatement.setLong(1,estudiante.getId());
           preparedStatement.setString(2,estudiante.getNombre());
           preparedStatement.setString(3,estudiante.getApellido());
           // 3 Ejecutar la sentencia
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (Exception e){
            System.out.println("El error es "+e);
        }
        return estudiante;
    }

    @Override
    public void eliminar(Long id) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        // 1 levantar el driver y conectarnos
        try{
            Class.forName(driver);
            connection= DriverManager.getConnection(url,user,password);
            // 2 crear una sentencia
            preparedStatement= connection.prepareStatement("DELETE FROM estudiantes where id=?");
            preparedStatement.setLong(1,id);

            // 3 Ejecutar la sentencia
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (Exception e){
            System.out.println("El error es "+e);
        }
    }

    @Override
    public Estudiante buscar(Long id) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        Estudiante estudiante=null;
        // 1 levantar el driver y conectarnos
        try{
            Class.forName(driver);
            connection= DriverManager.getConnection(url,user,password);
            // 2 crear una sentencia
            preparedStatement= connection.prepareStatement("SELECT * FROM ESTUDIANTES WHERE ID =?");
            preparedStatement.setLong(1,id);
            // 3 Ejecutar la sentencia
           ResultSet resultado= preparedStatement.executeQuery();
           //4 evaluar los resultados-recorrelos
           while(resultado.next()){
               long idEstudiante=resultado.getLong("id");
               String nombre=resultado.getString("nombre");
               String apellido=resultado.getString("apellido");

               estudiante=new Estudiante();
               estudiante.setId(id);
               estudiante.setNombre(nombre);
               estudiante.setApellido(apellido);

           }
            preparedStatement.close();
        }catch (Exception e){
            System.out.println("El error es "+e);
        }
        return estudiante;
    }

    @Override
    public List<Estudiante> buscarTodos() {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ArrayList<Estudiante> estudiantes= new ArrayList<>();
        // 1 levantar el driver y conectarnos
        try{
            Class.forName(driver);
            connection= DriverManager.getConnection(url,user,password);
            // 2 crear una sentencia
            preparedStatement= connection.prepareStatement("SELECT * FROM ESTUDIANTES");

            // 3 Ejecutar la sentencia
            ResultSet resultado= preparedStatement.executeQuery();
            //4 evaluar los resultados-recorrelos
            while(resultado.next()){
                long idEstudiante=resultado.getLong("id");
                String nombre=resultado.getString("nombre");
                String apellido=resultado.getString("apellido");

                 Estudiante estudiante=new Estudiante();
                estudiante.setId(idEstudiante);
                estudiante.setNombre(nombre);
                estudiante.setApellido(apellido);
                estudiantes.add(estudiante);

            }
            preparedStatement.close();
        }catch (Exception e){
            System.out.println("El error es "+e);
        }
        return estudiantes;

    }
}
