
package ejercicio4;

import java.util.Random;

/**
 *
 * @author satomoga
 */
public class Principal {

    public static void main(String[] args) throws Exception {
        Random az = new Random();
        int ale = az.nextInt(12);
        int ale2 = az.nextInt(12);

        while (ale2 == ale) {
            ale2 = az.nextInt(12);
        }

        combate(pokedex(ale), pokedex(ale2));

    }

    public static Pokemon pokedex(int n) {
        Pokemon[] p = new Pokemon[12];
        p[0] = new Pokemon("pikachu", 200, 25);
        p[1] = new PokemonFuego("charmander", 200, 25);
        p[2] = new PokemonAgua("squitle", 200, 25);
        p[3] = new PokemonPlanta("bulbasur", 200, 25);
        p[4] = new PokemonPlanta("ivysour", 200, 35);
        p[5] = new PokemonPlanta("venusaur", 200, 45);
        p[6] = new PokemonAgua("wartortle", 200, 35);
        p[7] = new PokemonAgua("blastoise", 200, 45);
        p[8] = new PokemonFuego("charmeleon",200, 35);
        p[9] = new PokemonFuego("charizard", 200, 45);
        p[10] = new Pokemon("jigglypuff", 200, 35);
        p[11] = new Pokemon("snorlax", 200, 45);

        return p[n];

    }

    public static void combate(Pokemon p1, Pokemon p2) throws Exception {
        try {
            Art art = new Art();
            int cont = 0;

            for (int i = 0; i < 200; i++) {
                System.out.println("");
            }
            System.out.println("HAZ LA PANTALLA GRANDE, TE DOY 5 SEGUNDOS");
            Thread.sleep(5 * 1000);
            for (int i = 0; i < 40; i++) {
                Thread.sleep(2000 / 40);
                System.out.println("");
            }

            art.print_pokemon(p1.getName());
            Thread.sleep(2 * 1000);
            for (int i = 0; i < 40; i++) {
                Thread.sleep(2000 / 40);
                System.out.println("");
            }

            art.print_pokemon("vs");
            Thread.sleep(1000);
            for (int i = 0; i < 30; i++) {
                Thread.sleep(1500 / 30);
                System.out.println("");
            }

            art.print_pokemon(p2.getName());
            Thread.sleep(2 * 1000);
            for (int i = 0; i < 40; i++) {
                Thread.sleep(2000 / 40);
                System.out.println("");
            }

            double barra1 = p1.getHealthPoints();
            double barra2 = p2.getHealthPoints();
            int anchoBarra = 25;
            
            while (!p1.isDead() && !p2.isDead()) {

                System.out.print(p1.getName() + ": " + p1.getHealthPoints() + " ");
                
                for (int i = 0; i < anchoBarra; i++) {
                    if (p1.getHealthPoints() > ((barra1/anchoBarra)*i)) {
                        System.out.print("█");
                    } else {
                        System.out.print("░");
                    }
                }

                System.out.print("  vs  ");

                for (int i = anchoBarra; i > 0; i--) {
                    if (p2.getHealthPoints() < ((barra2/anchoBarra)*i)) {
                        System.out.print("░");
                    } else {
                        System.out.print("█");
                    }
                }

                System.out.println(" " + p2.getHealthPoints() + " :" + p2.getName());

                System.out.println("----------------------------------------\n");
                if (cont % 2 == 0) {
                    p1.attack(p2);
                    System.out.println(p1.getName() + " ataca a " + p2.getName() + " con " + p1.getStrikeForce() + " puntos");
                    System.out.println("\n\n");
                } else {
                    p2.attack(p1);
                    System.out.println(p2.getName() + " ataca a " + p1.getName() + " con " + p2.getStrikeForce() + " puntos");
                    System.out.println("\n\n");
                }

                cont++;
                Thread.sleep(2 * 1000);
                for (int i = 0; i < 200; i++) {
                    System.out.println("");
                }
            }
            if (p1.isDead()) {
                System.out.println(p1.getName() + " Fuera de Combate");
                System.out.println(p2.getName() + " GANADOR!!!\n");
                art.print_pokemon(p2.getName());
            } else {
                System.out.println(p2.getName() + " Fuera de Combate");
                System.out.println(p1.getName() + " GANADOR!!!\n");
                art.print_pokemon(p1.getName());
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
