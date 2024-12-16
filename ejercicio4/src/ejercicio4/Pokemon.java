/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4;

/**
 *
 * @author satomoga
 */
public class Pokemon {

    protected String name;
    protected double healthPoints;
    protected double strikeForce;

    public Pokemon(String name, double healthPoints, double strikeForce) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.strikeForce = strikeForce;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;
    }

    public double getStrikeForce() {
        return strikeForce;
    }

    public void setStrikeForce(double strikeForce) {
        this.strikeForce = strikeForce;
    }

    public boolean isDead() {
        return healthPoints <= 0;
    }

    public void attack(Pokemon p) {
        if (this.isDead()) {
            System.out.println(this.name + " ESTA FUERA DE COMBATE");
        } else {
            if (p.isDead()) {
                System.out.println(p.name + " ESTA FUERA DE COMBATE");
            } else {
                p.healthPoints = p.healthPoints - strikeForce;
            }
        }
    }

    @Override
    public String toString() {
        if (!isDead()) {
            return "Pokemon{" + "name=" + name + ", healthPoints=" + healthPoints + ", strikeForce=" + strikeForce + '}';
        } else {
            return "Pokemon{" + "name=" + name + ">> DERROTADO <<";
        }

    }

}
