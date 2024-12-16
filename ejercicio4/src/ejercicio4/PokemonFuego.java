/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4;

/**
 *
 * @author satomoga
 */
public class PokemonFuego extends Pokemon {

    public PokemonFuego(String name, double healthPoints, double strikeForce) {
        super(name, healthPoints, strikeForce);
    }

    @Override
    public void attack(Pokemon p) {
        if (this.isDead()) {
            System.out.println(this.name + " ESTA FUERA DE COMBATE");
        } else {
            if (p.isDead()) {
                System.out.println(p.name + " ESTA FUERA DE COMBATE");
            } else {
                switch (p.getClass().getSimpleName()) {
                    case "PokemonPlanta":
                        p.healthPoints = p.healthPoints - (strikeForce * 2);
                        break;
                    case "PokemonAgua":
                    case "PokemonFuego":
                        p.healthPoints = p.healthPoints - (strikeForce * 0.5);
                        break;
                    default:
                        p.healthPoints = p.healthPoints - strikeForce;
                }
            }
        }
    }
}
