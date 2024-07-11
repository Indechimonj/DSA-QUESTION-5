/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plantmanagementsystem;

/**
 *
 * @author Samuel Imonje
 */
public class PlantSpecies {
    Plant plant;
    PlantSpecies left, right;

    public PlantSpecies(Plant plant) {
        this.plant = plant;
        left = right = null;
    }
    
}
