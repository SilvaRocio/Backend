import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.log4j.Logger;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

public class Main {
    private static  final Logger logger= Logger.getLogger(Main.class);
    public static void main(String[] args) throws Exception {
        try{
            Class.forName("org.h2.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:h2:~/Empleados","sa","");
            Statement set= connection.createStatement();

            String createSql="DROP TABLE IF EXISTS Empleado; \n"+
                    "CREATE TABLE Empleado (ID INT PRIMARY KEY, NOMBRE VARCHAR(255), APELLIDO VARCHAR(255));\n"+
                    "INSERT INTO Empleado VALUES (1, 'Rocio','Silva');\n"+
                    "INSERT INTO Empleado VALUES (2, 'Marcos','Amado');\n"+
                    "INSERT INTO Empleado VALUES (3, 'Caro','Silva');\n";

            String Eliminado="DELETE FROM Empleado WHERE ID =1";
            set.execute(createSql);
            set.execute(Eliminado);

            String sql="select * from Empleado";


            ResultSet rd= set.executeQuery(sql);

            while (rd.next()){
                System.out.println(rd.getInt(1)+" "+rd.getString(2)+" "+rd.getString(3));

            }
            set.close();
        }catch (Exception e){
            logger.error("hubo un error porque dos empleados tienen el mismo ID, cambiar");
            System.out.println(e);

        }



    }
}