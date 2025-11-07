package Animalia;
public class AnimalTerrestre extends Animal {

    // 1. ATRIBUTOS (Específicos desta classe)
    private boolean possuiPelo;
    private int numeroPatas;


    // 2. CONSTRUTOR
     // (Este construtor precisa de todos os dados para construir
           public AnimalTerrestre(String nome, String especie, String habitat, String caracteristicasCorporais,
                                  String nomeCientifico, String caracteristicas, int peso, int altura, String tamanho, boolean a, int i)

    {

        // 1. CHAME O CONSTRUTOR PAI (super) PRIMEIRO
        // (Isso constrói a parte "Animal" do objeto)
        super(nome, especie, habitat, caracteristicasCorporais, nomeCientifico,
                caracteristicas, peso, altura, tamanho);

        // 2. DEPOIS, configure os atributos desta classe

        this.numeroPatas = numeroPatas;
    }

    // 3. MÉTODOS (Getters e Setters específicos)
       // (Os getters e setters de nome, peso, etc. já foram herdados!)

    // Número de Patas
    public int getNumeroPatas() {
        return numeroPatas;
    }

    public void setNumeroPatas(int numeroPatas) {
        this.numeroPatas = numeroPatas;
    }

    // Possui Pelo (métodos booleanos geralmente usam "is" no getter)
    public boolean isPossuiPelo() {
        return possuiPelo;
    }

    public void setPossuiPelo(boolean possuiPelo) {
        this.possuiPelo = possuiPelo;
    }


    // Sobrescreve o método para exibir informaçoes detalhadas.
    @Override
   public void exibirInfo() {
               super.exibirInfo();

    }


}