package main.service;

import main.model.Odontologo;
import main.repository.impl.InterfaceDao;

import java.util.ArrayList;

public class OdontologoService {

    private InterfaceDao<Odontologo> odontologoInterfaceDao;


    // constructor

    public OdontologoService(InterfaceDao<Odontologo> odontologoInterfaceDao) {
        this.odontologoInterfaceDao = odontologoInterfaceDao;
    }


    // metodos

    public Odontologo registrarOdontologo(Odontologo odontologo) {
        return odontologoInterfaceDao.registrar(odontologo);
    }

    public ArrayList<Odontologo> listarOdontologos() {
        return odontologoInterfaceDao.listarTodos();
    }


    // getter

    public InterfaceDao<Odontologo> getOdontologoInterfaceDao() {
        return odontologoInterfaceDao;
    }


    // setter

    public void setOdontologoInterfaceDao(InterfaceDao<Odontologo> odontologoInterfaceDao) {
        this.odontologoInterfaceDao = odontologoInterfaceDao;
    }
}

