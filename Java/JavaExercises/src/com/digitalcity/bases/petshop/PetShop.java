package com.digitalcity.bases.petshop;

import java.util.ArrayList;
import java.util.List;

public class PetShop {
    private ArrayList<Animal> animals;


    public PetShop(){
        this.animals = new ArrayList<>();
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void addAnimal(Animal animal){
        animals.add(animal);
    }

    public void listOutEveryAnimals() {
        ArrayList<Cat> cats = new ArrayList<>();
        ArrayList<Dog> dogs = new ArrayList<>();
        ArrayList<Bird> birds = new ArrayList<>();

        for (Animal animal : animals) {
            if (animal instanceof Cat) {
                cats.add((Cat) animal);
            } else if (animal instanceof Dog) {
                dogs.add((Dog) animal);
            } else if (animal instanceof Bird) {
                birds.add((Bird) animal);
            }
        }

        System.out.println("Animal list: ");
        System.out.println("Cats: ");
        for (Cat cat : cats) {
            System.out.println(cat);
        }
        System.out.println();
        System.out.println("Dogs: ");
        for (Dog dog : dogs) {
            System.out.println(dog);
        }
        System.out.println();
        System.out.println("Birds: ");
        for (Bird bird : birds) {
            System.out.println(bird);
        }
    }

    public void displayAnimalsCounts(){
        int catCount = 0;
        int dogCount = 0;
        int birdCount = 0;

        for (Animal animal : animals) {
            if (animal instanceof Cat) {
                catCount++;
            } else if (animal instanceof Dog) {
                dogCount++;
            } else if (animal instanceof Bird) {
                birdCount++;
            }
        }
        System.out.println(String.format("There are %s %s in the pet shop.", catCount + dogCount + birdCount, singularPlural(catCount + dogCount + birdCount, "animal", "animals")));
        System.out.println(String.format("%s %s, %s %s and %s %s.", catCount, singularPlural(catCount, "cat", "cats"), dogCount, singularPlural(dogCount, "dog", "dogs"), birdCount, singularPlural(birdCount, "bird", "birds")));
    }

    public void displayDeadAnimals(){
        int deadAnimals = 0;
        for (Animal animal : animals) {
            if (animal.diedOvernight()) {
                System.out.println(animal.getName() + " died last night :'(");
                deadAnimals++;
            }
        }
        if (deadAnimals == 0){
            System.out.println("There was no death last night :)");
        }
        disposeOfDeadAnimals();
    }

    private void disposeOfDeadAnimals(){
        List<Animal> newList = this.animals.stream().filter(animal -> !animal.isDead()).toList();
        this.animals = new ArrayList<>(newList);
    }

    public static String singularPlural(int count, String singular, String plural){
        return count == 1 || count == 0 ? singular : plural;
    }
}
