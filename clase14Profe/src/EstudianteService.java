import java.sql.SQLException;
import java.util.List;

public class EstudianteService {
    private InterfaceDAO <Estudiante> estudianteDao;

    public InterfaceDAO<Estudiante> getEstudianteDao() {
        return estudianteDao;
    }

    public void setEstudianteDao(InterfaceDAO<Estudiante> estudianteDao) {
        this.estudianteDao = estudianteDao;
    }
    public Estudiante guardarEstudiante(Estudiante e) throws SQLException, ClassNotFoundException {
        //delegarle la resposabilidad de guardar al DAO
       return  estudianteDao.guardar(e);
    }
    public void eliminarEstudiante(Long id){
        estudianteDao.eliminar(id);
    }
    public Estudiante buscarEstudiante(Long id){
       return  estudianteDao.buscar(id);
    }
    public List<Estudiante> buscarToodos(){
        return estudianteDao.buscarTodos();
    }
}
