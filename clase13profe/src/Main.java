import java.sql.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS CUENTA; CREATE TABLE CUENTA "
            + "("
            + " ID INT PRIMARY KEY,"
            + " NOMBRE varchar(100) NOT NULL, "
            + " NRO_CUENTA NUMERIC(10, 2) NOT NULL,"
            + " SALDO INT NOT NULL"
            + " )";
    private static final String SQL_INSERT =  "INSERT INTO CUENTA (ID, NOMBRE, NRO_CUENTA, SALDO) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE =  "UPDATE CUENTA SET SALDO=? WHERE ID=?";
    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/Cuentass", "root", "");

    }
    public static void main(String[] args) throws SQLException {
        Cuenta cuenta = new Cuenta(1234,"vip",3456);
        Connection connection= null;
        try{
            connection=getConnection();
            Statement stm= connection.createStatement();
            stm.execute(SQL_CREATE_TABLE);
            PreparedStatement pInsert = connection.prepareStatement(SQL_INSERT);
            pInsert.setInt(1,1);
            pInsert.setString(2,cuenta.getNombre());
            pInsert.setInt(3,cuenta.getNroCuenta());
            pInsert.setDouble(4,cuenta.getSaldo());
            pInsert.execute();
            //empezar la transaccion
            connection.setAutoCommit(false);
            PreparedStatement upDate= connection.prepareStatement(SQL_UPDATE);
            upDate.setDouble(1,cuenta.getSaldo());
            upDate.setInt(2,1);
            upDate.execute();
            connection.commit();
            connection.setAutoCommit(true);
            String sql ="SELECT * FROM CUENTA";
            Statement stmt =connection.createStatement();
            ResultSet rd=stmt.executeQuery(sql);
            while(rd.next()){
                System.out.println(rd.getInt(1)+rd.getString(2)+rd.getInt(3)+rd.getDouble(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
        }finally {
            connection.close();
        }
        }
    }