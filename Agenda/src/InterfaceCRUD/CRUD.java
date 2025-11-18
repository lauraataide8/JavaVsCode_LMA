package InterfaceCRUD;

// 1. ADICIONADO: Importação da classe 'List'
import java.util.List;

// 2. CORRIGIDO: Removido o ", t" desnecessário.
// A interface precisa saber apenas o tipo <T> (ex: Usuario, Contato)
public interface CRUD<T> {

    boolean criar (T entidade);

    List<T> buscartodos();

    boolean atualizar (T entidade);

    boolean deletar (Integer id);

    List<T> buscarPorCampo(String campo, String valor);
}