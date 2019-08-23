/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author fskn
 */
public class Animal {
    
    private String type;
    private int birthyear;
    private String sound;

    public Animal(String type, int birthyear, String sound) {
        this.type = type;
        this.birthyear = birthyear;
        this.sound = sound;
    }

    public Animal() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBirthyear() {
        return birthyear;
    }

    public void setBirthyear(int birthyear) {
        this.birthyear = birthyear;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    @Override
    public String toString() {
        return "Animal{" + "type=" + type + ", birthyear=" + birthyear + ", sound=" + sound + '}';
    }
    
    
}
