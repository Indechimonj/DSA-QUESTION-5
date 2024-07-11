/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plantmanagementsystem;

/**
 *
 * @author Samuel Imonje
 */
public class Plant {
    private final String name;
    private final String species;
    private final int age;
    
    
    public Plant(String name, String species, int age) {
        this.name = name;
        this.species = species;
        this.age = age;
    }
        public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }
    
}
