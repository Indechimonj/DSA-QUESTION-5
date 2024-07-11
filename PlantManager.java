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
    private final List<Plant> plantList;
    private final Queue<Plant> wateringQueue;
    private final Stack<Plant> historyStack;
    private PlantSpecies root;

    public PlantManager() {
        plantList = new ArrayList<>();
        wateringQueue = new LinkedList<>();
        historyStack = new Stack<>();
        root = null;
    }

    // Add a plant
    public void addPlant(Plant plant) {
        plantList.add(plant);
        wateringQueue.offer(plant);
        root = insertIntoBST(root, plant);
    }

    // Insert a plant into BinarySearchTree
    private PlantSpecies insertIntoBST(PlantSpecies root, Plant plant) {
        if (root == null) {
            return new PlantSpecies(plant);
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
        Plant nextPlant = wateringQueue.poll();
        if (nextPlant != null) {
            historyStack.push(nextPlant);
        }
        return nextPlant;
    }

    // Get plant history
    public List<Plant> getHistory() {
        return new ArrayList<>(historyStack);
    }

    // Inorder traversal of BinaryStructureTree to get plants by species
    public List<Plant> getPlantsBySpecies() {
        List<Plant> plants = new ArrayList<>();
        inorderTraversal(root, plants);
        return plants;
    }

    private void inorderTraversal(PlantSpecies node, List<Plant> plants) {
        if (node != null) {
            inorderTraversal(node.left, plants);
            plants.add(node.plant);
            inorderTraversal(node.right, plants);
        }
    }

    
}
