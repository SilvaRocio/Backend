
import org.example.model.Odontologo;
import org.example.repository.impl.impl.OdontologoDaoEnMemoria;
import org.example.repository.impl.impl.OdontologoDaoH2;
import org.example.service.OdontologoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class OdontologoServiceTest {

    private static OdontologoService odontologoServiceH2 = new OdontologoService(new OdontologoDaoH2());
    private static OdontologoService odontologoServiceMemoria = new OdontologoService(new OdontologoDaoEnMemoria());

    @BeforeClass

    public static void cargarOdontologos() {
        Odontologo odontologoUno = new Odontologo("Aylen", "Cormick", 1234);
        Odontologo odontologoDos = new Odontologo("Rocio", "Silva", 5678);
        Odontologo odontologoTres = new Odontologo("Pepe", "Milanesa", 1010);

        odontologoServiceH2.registrarOdontologo(odontologoUno);
        odontologoServiceH2.registrarOdontologo(odontologoDos);
        odontologoServiceH2.registrarOdontologo(odontologoTres);

        odontologoServiceMemoria.registrarOdontologo(odontologoUno);
        odontologoServiceMemoria.registrarOdontologo(odontologoDos);
        odontologoServiceMemoria.registrarOdontologo(odontologoTres);

    }


    @Test

    public void registrarOdontologosH2Test() {
        Odontologo odontologo = new Odontologo("Teo", "Tyler", 3008);

        Odontologo odont = odontologoServiceH2.registrarOdontologo(odontologo);

        Assert.assertTrue(odont != null);
//        Assert.assertTrue(odont.getId() != null);
    }

    @Test

    public void registrarOdontologosMemoriaTest() {
        Odontologo odontologo = new Odontologo("Teo", "Tyler", 3008);

        Odontologo odont = odontologoServiceMemoria.registrarOdontologo(odontologo);

        Assert.assertTrue(odont != null);
        Assert.assertTrue(odont.getId() != null);
    }

    @Test

    public void listarOdontologosH2Test() {
        ArrayList<Odontologo> odontologos = odontologoServiceH2.listarOdontologos();

        Assert.assertTrue(odontologos != null);
        Assert.assertTrue(odontologos.size() > 2);
    }

    @Test

    public void listarOdontologosMemoriaTest() {
        ArrayList<Odontologo> odontologos = odontologoServiceMemoria.listarOdontologos();

        Assert.assertTrue(odontologos != null);
        Assert.assertTrue(odontologos.size() > 2);
    }

}