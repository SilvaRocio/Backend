import java.sql.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static  final String table="DROP TABLE IF EXISTS usuario; CREATE TABLE usuario"+"("+
            "ID INT PRIMARY KEY,"+
            "NOMBRE varchar(100) NOT NULL,"+
            "EMAIL varchar(100) NOT NULL,"+
            "SUELDO numeric (15,2) NOT NULL"+")";
    private static final String insert= "INSERT INTO usuario (ID, NOMBRE, EMAIL, SUELDO) VALUES(?,?,?,?)";
    private static final String update="UPDATE usuario SET SUELDO=? WHERE EMAIL=?";
    public static void main(String[] args) throws Exception{
        Usuario usuario= new Usuario("pepe", "pepe@gamil",20d);
        Connection connection= null;
        try {
            connection=getConnection();
            Statement stm= connection.createStatement();
            stm.execute(table);

            //estamos realizando el insert
            PreparedStatement pInsert=connection.prepareStatement(insert);
            //empiezo a insertar en la base de datos
            pInsert.setInt(1,1);
            pInsert.setString(2,usuario.getNombre());
            pInsert.setString(3,usuario.getEmail());
            pInsert.setDouble(4,usuario.getSueldo());
            pInsert.execute();
            //empezar la transaccion
            connection.setAutoCommit(false);
            PreparedStatement pUdDate= connection.prepareStatement(update);
            pUdDate.setDouble(1,usuario.getSueldo());
            pUdDate.setString(2,usuario.getEmail());
            pUdDate.execute();

            connection.commit();
            connection.setAutoCommit(true);

            String sql="SELECT * FROM USUARIO";
            Statement stmt = connection.createStatement();
            ResultSet rd= stmt.executeQuery(sql);
            while(rd.next()){
                System.out.println(rd.getInt(1)+rd.getString(2)+rd.getString(3)+rd.getDouble(4));
            }



        } catch (Exception e) {
           e.printStackTrace();
           //vuelve atras todos los valos que cambiamos
           connection.rollback();
        }finally {
            connection.close();
        }
    }
    private static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/Usuarioss","root","");
    }
}