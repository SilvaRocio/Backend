package org.example.repository.impl.impl;


import org.apache.log4j.Logger;
import org.example.model.Odontologo;
import org.example.repository.impl.InterfaceDao;

import java.util.ArrayList;

public class OdontologoDaoEnMemoria implements InterfaceDao<Odontologo> {

    private static final Logger logger = Logger.getLogger(OdontologoDaoH2.class);

    ArrayList<Odontologo> odontologosRegistrados = new ArrayList<>();

    @Override
    public Odontologo registrar(Odontologo odontologo) {
        logger.info("Registrando odontologo...");
        odontologo.setId(odontologosRegistrados.size() + 1);
        odontologosRegistrados.add(odontologo);
        logger.info("Odontologo " + odontologo.getNombre() + " " + odontologo.getApellido() + " registrado con exito.");
        return odontologo;
    }

    @Override
    public ArrayList<Odontologo> listarTodos() {

        logger.info("Listando los odontologos...");

        for (Odontologo odont: odontologosRegistrados) {
            System.out.println(odont.getId() + ". Nombre: " + odont.getNombre() + ", Apellido: " + odont.getApellido() + ", Matricula: " + odont.getMatricula());
        }

        logger.info("Se han listado exitosamente todos los odontologos.");

        return odontologosRegistrados;
    }
}
