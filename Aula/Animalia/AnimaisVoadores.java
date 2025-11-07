package Animalia;

// 1. ADICIONAMOS "extends Animal"
public class AnimaisVoadores extends Animal {

    // 1. ATRIBUTOS (Específicos desta classe)

    private String taxonomia; // Ex: "Ave", "Inseto", "Mamífero"
    private String mecanismoVoo; // Ex: "Asas com penas", "Asas membranosas"


    // 2. CONSTRUTOR (Corrigido)

    public AnimaisVoadores(
            // --- Parâmetros para a classe-pai (Animal) ---
            String nome, String especie, String habitat, String caracteristicasCorporais,
            String nomeCientifico, String caracteristicas, int peso, int altura, String tamanho,

            // --- Parâmetros específicos desta classe ---
            String taxonomia, String mecanismoVoo
    ) {

        // 1. CHAME O CONSTRUTOR PAI (super) PRIMEIRO
        super(nome, especie, habitat, caracteristicasCorporais, nomeCientifico,
                caracteristicas, peso, altura, tamanho);

        // 2. DEPOIS, configure os atributos desta classe
        this.taxonomia = taxonomia;
        this.mecanismoVoo = mecanismoVoo;
    }


    // 3. MÉTODOS (Getters e Setters - os seus estavam perfeitos!)


    public String getTaxonomia() {
        return taxonomia;
    }

    public void setTaxonomia(String taxonomia) {
        this.taxonomia = taxonomia;
    }

    public String getMecanismoVoo() {
        return mecanismoVoo;
    }

    public void setMecanismoVoo(String mecanismoVoo) {
        this.mecanismoVoo = mecanismoVoo;
    }
}