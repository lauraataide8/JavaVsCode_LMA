package Animalia;

// O 'main' é o ponto de partida.
public class CriarAnimal {

    public static void main(String[] args) {

        // --- Criando os animais em linhas únicas ---
        AnimalTerrestre lagarto = new AnimalTerrestre("Lagarto", "Lagarto-de-parede", "Jardins e muros", "Corpo coberto de escamas", "Podarcis muralis", "Répil, sangue-frio", 1, 20, "Pequeno", false, 4);

        AnimalTerrestre Anta = new AnimalTerrestre("Anta", "antinha", "Jardins e muros", "Corpo coberto de escamas", "Podarcis muralis", "Répil, sangue-frio", 1, 20, "Pequeno", true, 4);

        AnimalTerrestre boi = new AnimalTerrestre("Boi", "Boi doméstico", "Pastagens", "Corpo robusto, chifres", "Bos taurus", "Mamífero, herbívoro", 800, 150, "Grande", true, 4);

        AnimaisMarinhos tubarao = new AnimaisMarinhos("Tubarão", "Tubarão-branco", "Oceanos (costeiro)", "Corpo fusiforme, dentes serrilhados", "Carcharodon carcharias", "Peixe cartilaginoso", 1000, 500, "Muito Grande", "Branquial", "Nadadeiras");

        AnimaisVoadores corvo = new AnimaisVoadores("Corvo", "Corvo-comum", "Florestas e cidades", "Penas pretas", "Corvus corax", "Onívoro, inteligente", 2, 60, "Médio", "Ave", "Asas com penas");


        // --- Resultados
        System.out.println("--- ANIMAL 1 (Terrestre) ---");
        lagarto.exibirInfo();
        System.out.println("Patas: " + lagarto.getNumeroPatas());

        System.out.println("\n--- ANIMAL 2 (Terrestre) ---");
        System.out.println("Tem pelo? " + boi.isPossuiPelo());

        System.out.println("\n--- ANIMAL 3 (Marinho) ---");
        tubarao.exibirInfo();
        System.out.println("Locomoção: " +tubarao.getLocomocao());
        System.out.println("Respiração: " + tubarao.getRespiracao());

        System.out.println("\n--- ANIMAL 4 (Voador) ---");
        System.out.println("Taxonomia: " + corvo.getTaxonomia());
    }
}