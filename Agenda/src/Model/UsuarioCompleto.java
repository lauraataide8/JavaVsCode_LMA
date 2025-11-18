package Model;

import java.util.List;
import java.util.Objects;

public class UsuarioCompleto {
    private Usuario usuario;
    private List<Contato> contatos;
    private Endereco endereco;

    // --- Construtores ---
    public UsuarioCompleto(Usuario usuario, List<Contato> contatos, Endereco endereco) {
        this.usuario = usuario;
        this.contatos = contatos;
        this.endereco = endereco;
    }

    // --- Getters ---
    public Usuario getUsuario() {
        return usuario;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    // --- Método de Lógica de Negócio (CORRIGIDO) ---
    /**
     * Retorna o contato principal do usuário.
     * Caso não encontre um principal, retorna o primeiro contato da lista.
     *
     */
    public Contato getContatoPrincipal() { //
        if (contatos != null) { //
            for (Contato contato : contatos) { //
                // CORREÇÃO APLICADA: Usando isPrincipal() para o padrão Java
                if (contato.isPrincipal()) { //
                    return contato; //
                }
            }
            // Retorna o primeiro contato se não houver principal
            if (!contatos.isEmpty()) { //
                return contatos.get(0); //
            }
        }
        return null; //
    }

    // --- Métodos Sobrescritos ---
    @Override
    public String toString() {
        return "UsuarioCompleto{" +
                "usuario=" + usuario +
                ", contatos=" + contatos +
                ", endereco=" + endereco +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioCompleto that = (UsuarioCompleto) o;
        return Objects.equals(usuario.getIdUsuario(), that.usuario.getIdUsuario());
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario.getIdUsuario());
    }
}