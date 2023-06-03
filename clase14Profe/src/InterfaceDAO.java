import java.sql.SQLException;
import java.util.List;

public interface InterfaceDAO <T>{

    public T guardar(T t) throws SQLException, ClassNotFoundException;
    public void eliminar (Long id);
    public T buscar (Long id);
    public List<Estudiante> buscarTodos();

}
