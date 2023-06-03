package main.repository.impl.impl;

import main.model.Odontologo;
import main.repository.impl.InterfaceDao;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

public class OdontologoDaoH2 implements InterfaceDao<Odontologo> {

    private static final Logger logger = Logger.getLogger(OdontologoDaoH2.class);
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/db_clinicaOdontologica;INIT=RUNSCRIPT FROM 'create.sql'";
    private final static String DB_USER ="sa";
    private final static String DB_PASSWORD = "";


    @Override
    public Odontologo registrar(Odontologo odontologo) {
        Connection connection = null;
       // PreparedStatement preparedStatement = null;

        try {

            logger.info("Registrando odontologo...");

            Class.forName(DB_JDBC_DRIVER).newInstance();
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

           PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ODONTOLOGOS (NOMBRE, APELLIDO, MATRICULA) VALUES (?,?,?)");

            preparedStatement.setString(1, odontologo.getNombre());
            preparedStatement.setString(2, odontologo.getApellido());
            preparedStatement.setInt(3, odontologo.getMatricula());

            preparedStatement.executeUpdate();
        //traemos el ID que genero la BD y lo seteamos en odontologo
            ResultSet keys = preparedStatement.getGeneratedKeys();
            if(keys.next())
                odontologo.setId(keys.getInt(1));

            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("No se pudo registrar el odontologo", e);
        }


        logger.info("Odontologo " + odontologo.getNombre() + " " + odontologo.getApellido() + " registrado con exito.");

        return odontologo;

    }

    @Override
    public ArrayList<Odontologo> listarTodos() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Odontologo> odontologos = new ArrayList<>();
        Odontologo odontologo = null;

        try {

            logger.info("Listando los odontologos...");

            Class.forName(DB_JDBC_DRIVER).newInstance();
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("SELECT * FROM ODONTOLOGOS");

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int idOdont = rs.getInt("ID");
                String nombreOdont = rs.getString("NOMBRE");
                String apellidoOdont = rs.getString("APELLIDO");
                int matriculaOdont = rs.getInt("MATRICULA");

                odontologo = new Odontologo();
                odontologo.setId(idOdont);
                odontologo.setNombre(nombreOdont);
                odontologo.setApellido(apellidoOdont);
                odontologo.setMatricula(matriculaOdont);

                odontologos.add(odontologo);

            }

            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("No se pudieron listar los odontologos", e);
        }

        logger.info("Se han listado exitosamente todos los odontologos.");

        return odontologos;
    }
}
