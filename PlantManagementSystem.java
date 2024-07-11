/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package plantmanagementsystem;

/**
 *
 * @author Samuel Imonje
 */
public class PlantManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PlantManager manager = new PlantManager();
        
        Plant plant1 = new Plant("Rose", "Rosa", 2);
        Plant plant2 = new Plant("Tulip", "Tulipa", 1);
        Plant plant3 = new Plant("Daisy", "Bellis", 3);
        
        manager.addPlant(plant1);
        manager.addPlant(plant2);
        manager.addPlant(plant3);
        
        System.out.println("Plants by species:");
        for (Plant plant : manager.getPlantsBySpecies()) {
            System.out.println(plant);
        }
        
        System.out.println("\nWatering plants:");
        Plant watered = manager.waterNextPlant();
        System.out.println("Watered: " + watered);
        watered = manager.waterNextPlant();
        System.out.println("Watered: " + watered);
        
        System.out.println("\nWatering history:");
        for (Plant plant : manager.getHistory()) {
            System.out.println(plant);
        }
    }
    
}
