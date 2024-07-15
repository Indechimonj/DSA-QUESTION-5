/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plantmanagementsystem;

import java.util.*;
/**
 *
 * @author Samuel Imonje
 */
public class PlantManager {
    private final List<Plant> plantList;//a list to store all plants
    private final Queue<Plant> wateringQueue;//a queue to manage the watering schedule
    private final Stack<Plant> historyStack;//a stack to track the history of watered plants
    private PlantBinaryTree root;//root node of the Binary search Tree

    public PlantManager() {
        plantList = new ArrayList<>();
        wateringQueue = new LinkedList<>();
        historyStack = new Stack<>();
        root = null;
    }

    // Add a plant to the list,Queue or BST
    public void addPlant(Plant plant) {
        plantList.add(plant);
        wateringQueue.offer(plant);
        root = insertIntoBST(root, plant);
    }

    // Insert a plant into BinarySearchTree based on its species
    private PlantBinaryTree insertIntoBST(PlantBinaryTree root, Plant plant) {
        if (root == null) {
            return new PlantBinaryTree(plant);
        }
        if (plant.getSpecies().compareTo(root.plant.getSpecies()) < 0) {
            root.left = insertIntoBST(root.left, plant);
        } else {
            root.right = insertIntoBST(root.right, plant);
        }
        return root;
    }

    // Water the next plant
    public Plant waterNextPlant() {
        Plant nextPlant = wateringQueue.poll();//removes the next plant from the queue and adds it to the plant
        if (nextPlant != null) {
            historyStack.push(nextPlant);
        }
        return nextPlant;
    }

    // Get plant history;retrieves the history of watered plants from the stack
    public List<Plant> getHistory() {
        return new ArrayList<>(historyStack);
    }

    // Inorder traversal of BST to get plants by species:performs an inorder traversal of the bst to get an ordered list of plants by species
    public List<Plant> getPlantsBySpecies() {
        List<Plant> plants = new ArrayList<>();
        inorderTraversal(root, plants);
        return plants;
    }

    private void inorderTraversal(PlantBinaryTree node, List<Plant> plants) {
        if (node != null) {
            inorderTraversal(node.left, plants);
            plants.add(node.plant);
            inorderTraversal(node.right, plants);
        }  
    }
    //Main method to be excuted
     public static void main(String[] args) {
        
        PlantManager manager = new PlantManager();
        
        Plant plant1 = new Plant("Moringa", "Moringa oleifera", 2);
        Plant plant2 = new Plant("Aloe", "Aloe barbadensis", 1);
        Plant plant3 = new Plant("Basil", "Basilicum", 3);
        
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

    
