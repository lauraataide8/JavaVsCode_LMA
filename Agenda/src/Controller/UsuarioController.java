package Controller;

import DAO.UsuarioDAO;
import DAO.ContatoDAO;
import DAO.EnderecoDAO;
import Model.Usuario;
import Model.UsuarioCompleto;
import Model.Contato;
import Model.Endereco;
import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;

public class UsuarioController {

    // Instanciação dos DAOs (dependências)
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private ContatoDAO contatoDAO = new ContatoDAO();
    private EnderecoDAO enderecoDAO = new EnderecoDAO();


    // 1. MÉTODOS DE LEITURA E ATUALIZAÇÃO BÁSICA  //

    /** Busca um único usuário pelo ID. */
    public Usuario buscarUsuarioPorId(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido para busca.");
        }

        return usuarioDAO.buscarUsuarioPorId(id);
    }

    /**
     * Atualiza um usuário existente, com validações.
     */
    public boolean atualizarUsuario(Integer id, String nome, String genero, LocalDate dataNascimento, String nacionalidade) {

        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido");
        }

        // Busca do Usuário (Corrigindo a capitalização do método)
        Usuario usuarioExistente = usuarioDAO.buscarUsuarioPorId(id);

        if (usuarioExistente == null) {
            throw new IllegalArgumentException("Usuário não encontrado");
        }

        // Atualização Condicional
        if (nome != null && !nome.trim().isEmpty()) {
            usuarioExistente.setNome(nome.trim());
        }

        if (genero != null && !genero.trim().isEmpty()) {
            usuarioExistente.setGenero(genero.trim());
        }

        if (dataNascimento != null) {
            if (dataNascimento.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("A data de nascimento não pode ser futura.");
            }
            usuarioExistente.setDataNascimento(dataNascimento);
        }

        if (nacionalidade != null && !nacionalidade.trim().isEmpty()) {
            usuarioExistente.setNacionalidade(nacionalidade.trim());
        }

        return usuarioDAO.atualizar(usuarioExistente);
    }

    // ----------------------------------------------------------------------
    // --- 2. MÉTODOS DE ENDEREÇO E RELACIONAMENTO ----------------------------
    // ----------------------------------------------------------------------

    /**
     * Adiciona um novo endereço para um ID de Usuário existente.
     */
    public boolean adicionarEnderecoUsuario(Integer idUsuario, String logradouro, String numero,
                                            String complemento, String bairro, String cidade,
                                            String uf, String cep) {

        if (idUsuario == null || idUsuario <= 0) {
            throw new IllegalArgumentException("ID do usuário inválido");
        }

        // Validações de campos obrigatórios
        if (logradouro == null || logradouro.trim().isEmpty()) {
            throw new IllegalArgumentException("Logradouro é obrigatório");
        }
        if (numero == null || numero.trim().isEmpty()) {
            throw new IllegalArgumentException("Número é obrigatório");
        }
        if (bairro == null || bairro.trim().isEmpty()) {
            throw new IllegalArgumentException("Bairro é obrigatório");
        }
        if (cidade == null || cidade.trim().isEmpty()) {
            throw new IllegalArgumentException("Cidade é obrigatória");
        }

        // Validações Específicas de Formato
        String ufFormatado = uf.trim().toUpperCase();
        if (uf == null || uf.trim().length() != 2) {
            throw new IllegalArgumentException("UF deve ter 2 caracteres");
        }

        if (cep == null || !Pattern.matches("\\d{5}-\\d{3}", cep.trim())) {
            throw new IllegalArgumentException("CEP deve estar no formato 00000-000");
        }

        // Verifica se o usuário existe
        Usuario usuario = usuarioDAO.buscarUsuarioPorId(idUsuario);
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não encontrado");
        }

        // Verifica se já existe endereço para este usuário
        // O método EnderecoDAO.buscarEnderecoPorUsuario DEVE EXISTIR
        Endereco enderecoExistente = enderecoDAO.buscarEnderecoPorUsuario(idUsuario);
        if (enderecoExistente != null) {
            throw new IllegalArgumentException("Usuário já possui um endereço cadastrado");
        }

        // Criação do objeto Modelo
        Endereco novoEndereco = new Endereco();
        novoEndereco.setIdUsuario(idUsuario);
        novoEndereco.setLogradouro(logradouro.trim());
        novoEndereco.setNumero(numero.trim());
        novoEndereco.setComplemento(complemento != null ? complemento.trim() : null);
        novoEndereco.setBairro(bairro.trim());
        novoEndereco.setCidade(cidade.trim());
        novoEndereco.setUf(ufFormatado);
        novoEndereco.setCep(cep.trim());

        return enderecoDAO.criar(novoEndereco);
    }

    /**
     * Busca o endereço de um usuário.
     */
    public Endereco buscarEnderecoPorUsuario(Integer idUsuario) {
        if (idUsuario == null || idUsuario <= 0) {
            throw new IllegalArgumentException("ID do usuário inválido");
        }
        // O método EnderecoDAO.buscarEnderecoPorUsuario DEVE EXISTIR (correção do erro 'cannot find symbol')
        return enderecoDAO.buscarEnderecoPorUsuario(idUsuario);
    }

    /**
     * Lista todos os contatos associados a um ID de Usuário.
     */
    public List<Contato> listarContatosUsuario(Integer idUsuario) {
        if (idUsuario == null || idUsuario <= 0) {
            throw new IllegalArgumentException("ID do usuario inválido");
        }
        // O método ContatoDAO.buscarContatosPorUsuario DEVE EXISTIR (correção do erro de argumentos)
        return contatoDAO.buscarContatosPorUsuario(idUsuario);
    }


    // ----------------------------------------------------------------------
    // --- 3. MÉTODO DE OBTENÇÃO COMPLETA (Modelagem Complexa) ---------------
    // ----------------------------------------------------------------------

    /**
     * Método para obter dados completos do usuário.
     */
    public UsuarioCompleto obterUsuarioCompleto(Integer idUsuario) {

        // 1. Busca o usuário base
        Usuario usuario = buscarUsuarioPorId(idUsuario);
        if (usuario == null) {
            return null;
        }

        // 2. Busca os contatos (CORRIGIDO: Chamando o método auxiliar listarContatosUsuario)
        // Isso resolve o erro 'actual and formal argument lists differ in length'
        List<Contato> contatos = listarContatosUsuario(idUsuario);

        // 3. Busca o endereço
        Endereco endereco = buscarEnderecoPorUsuario(idUsuario);

        // 4. Cria e retorna o Modelo Composto
        return new UsuarioCompleto(usuario, contatos, endereco);
    }
}