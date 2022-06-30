package com.digitalcity.bases.petshop;

import com.digitalcity.bases.petshop.enums.BirdColor;
import com.digitalcity.bases.petshop.enums.CatCharacter;
import com.digitalcity.bases.petshop.enums.CollarColor;
import com.digitalcity.bases.petshop.enums.DogBreed;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    private static PetShop petShop = new PetShop();

    public static void main(String[] args) {
        Cat chichi = new Cat ("Chichi", Sex.FEMALE, 5f, 0.3f, LocalDate.of(2021, Month.APRIL, 01), LocalDate.of(2022, Month.JANUARY,25), CatCharacter.WHEEDLING, true, true);
        Dog pipo = new Dog ("Pipo" , Sex.MALE, 15f, 0.75f, LocalDate.of(2021, Month.APRIL, 01), LocalDate.of(2021, Month.AUGUST, 12), CollarColor.BLUE, false, DogBreed.LABRADOR);
        Bird koko = new Bird ("Koko", Sex.MALE, 0.8f, 0.25f, LocalDate.of(2021, Month.APRIL, 01), LocalDate.of(2022, Month.MAY, 26), BirdColor.ORANGE, false);

        petShop.addAnimal(chichi);
        petShop.addAnimal(pipo);
        petShop.addAnimal(koko);

        System.out.println("Welcome to the 'Pet Shop Manager'");

        boolean petShopping = true;
        while (petShopping){
            boolean isValidInput = false;
            while (!isValidInput){
                System.out.println();
                System.out.println("Choose an action...");
                System.out.println("1 = Record a new animal.");
                System.out.println("2 = List out all animals.");
                System.out.println("3 = Display animals count.");
                System.out.println("4 = Find all animals who died overnight.");

                int input = Integer.parseInt(scan.nextLine());

                if (input > 0 && input <= 4){
                    isValidInput = true;

                    switch (input){
                        case 1:
                            recordANewAnimal();
                            break;

                        case 2:
                            petShop.listOutEveryAnimals();
                            isValidInput = false;
                            break;

                        case 3:
                            petShop.displayAnimalsCounts();
                            isValidInput = false;
                            break;

                        case 4:
                            petShop.displayDeadAnimals();
                            isValidInput = false;
                            break;

                        default:
                            isValidInput = false;
                            break;
                    }
                }
                else {
                    System.out.println("! Invalid input !");
                }
            }
        }
    }

    private static void recordANewAnimal(){
        boolean isValidInput = false;
        while (!isValidInput)
        {
            System.out.println();
            System.out.println("Encoding a new animal...");
            System.out.println("What kind of animal do you want to encode?");
            System.out.println("1 = Cat, 2 = Dog, 3 = Bird");

            int choice = Integer.parseInt(scan.nextLine());

            if (choice > 0 && choice <= 3){
                isValidInput = true;

                switch(choice){
                    case 1:
                        encodeCat();
                        break;
                    case 2:
                        encodeDog();
                        break;
                    case 3:
                        encodeBird();
                        break;
                    default:
                        System.out.println("! Incorrect input !");
                        break;
                }
            }
            else{
                isValidInput = false;
                System.out.println("! Incorrect input !");
            }
        }
    }

    private static Animal encodeCommonData(String animalKind){
        String name;
        Sex sex = Sex.UNKNOWN;
        float weight; //kilograms
        float height; //meters
        LocalDate dateOfBirth;
        LocalDate arrivingDate;

        System.out.println();
        System.out.println(animalKind + "'s name...");
        name = scan.nextLine();

        boolean isSexInputValid = false;
        while (!isSexInputValid){
            System.out.println();
            System.out.println(animalKind + "'s sex... (M/F)");
            String sexInput = scan.nextLine();
            sexInput = sexInput.toUpperCase();

            if (sexInput.equals("M")){
                isSexInputValid = true;
                sex = Sex.MALE;
            }
            else if(sexInput.equals("F")){
                isSexInputValid = true;
                sex = Sex.FEMALE;
            }
            else{
                isSexInputValid = false;
                System.out.println("! Invalid input !");
            }
        }

        System.out.println();
        System.out.println(animalKind + "'s weight... (kilograms)");
        weight = Float.parseFloat(scan.nextLine());

        System.out.println();
        System.out.println(animalKind + "'s height... (meters)");
        height = Float.parseFloat(scan.nextLine());

        System.out.println();
        System.out.println(animalKind + "'s date of birth... (dd/mm/yyyy)");
        dateOfBirth = LocalDate.parse(scan.nextLine());

        System.out.println();
        System.out.println(animalKind + "'s arriving date...");
        System.out.println("Day...");
        int dayInput = Integer.parseInt(scan.nextLine());
        System.out.println("Month...");
        int monthInput = Integer.parseInt(scan.nextLine());
        System.out.println("Year...");
        int yearInput = Integer.parseInt(scan.nextLine());
        arrivingDate = LocalDate.of(yearInput, Month.of(monthInput), dayInput);

        Animal newAnimal = new Animal(name, sex, weight, height, dateOfBirth, arrivingDate);
        return newAnimal;
    }

    private static void encodeCat(){
        Animal baseData = encodeCommonData("Cat");
        CatCharacter character;
        boolean isClawsTrimmed;
        boolean isLongHair;

        //Cat specific data
        System.out.println();
        System.out.println("Cat's character...");
        System.out.println("1 = Energetic, 2 = Wild, 3 = Wheedling");
        int catCharacterInput = Integer.parseInt(scan.nextLine());
        if (catCharacterInput >= 1 && catCharacterInput <= 3){
            character = CatCharacter.values()[catCharacterInput - 1];
        }
        else{
            character = CatCharacter.UNKNOWN;
        }

        System.out.println();
        System.out.println("Cat's claws are trimmed? (true/false)");
        isClawsTrimmed = Boolean.parseBoolean(scan.nextLine());

        System.out.println();
        System.out.println("Cat's hair are long? (true/false)");
        isLongHair = Boolean.parseBoolean(scan.nextLine());

        Cat newCat = new Cat(baseData.getName(), baseData.getSex(), baseData.getWeight(), baseData.getHeight(), baseData.getBirthDay(), baseData.getArrivingDate(), character, isClawsTrimmed, isLongHair);
        petShop.addAnimal(newCat);

        System.out.println("New cat encoded!");
    }

    private static void encodeDog(){
        Animal baseData = encodeCommonData("Dog");
        CollarColor collar = CollarColor.UNKNOWN;
        boolean isTrained;
        DogBreed breed = DogBreed.UNKNOWN;

        //Dog specific data
        System.out.println();
        System.out.println("Dog's collar color...");
        System.out.println("1 = Blue, 2 = Red, 3 = Green");
        int collarColorInput = Integer.parseInt(scan.nextLine());
        if (collarColorInput >= 1 && collarColorInput <= 3){
            collar = CollarColor.values()[collarColorInput - 1];
        }
        else{
            collar = CollarColor.UNKNOWN;
        }

        System.out.println();
        System.out.println("Dog's trained? (true/false)");
        isTrained = Boolean.parseBoolean(scan.nextLine());

        System.out.println();
        System.out.println("Dog's breed...");
        System.out.println("1 = Bulldog, 2 = Poodle, 3 = Chihuahua, 4 = Labrador");
        int breedInput = Integer.parseInt(scan.nextLine());
        if (breedInput >= 1 && breedInput <= 4){
            breed = DogBreed.values()[breedInput - 1];
        }
        else{
            breed = DogBreed.UNKNOWN;
        }

        Dog newDog = new Dog(baseData.getName(), baseData.getSex(), baseData.getWeight(), baseData.getHeight(), baseData.getBirthDay(), baseData.getArrivingDate(), collar, isTrained, breed);
        petShop.addAnimal(newDog);

        System.out.println("New dog encoded!");
    }

    private static void encodeBird(){
        Animal baseData = encodeCommonData("Bird");
        BirdColor color = BirdColor.UNKNOWN;
        boolean isLivingInAviary;

        //Bird Specific Data
        System.out.println();
        System.out.println("Bird's color...");
        System.out.println("1 = Orange, 2 = Yellow, 3 = Magenta");
        int colorInput = Integer.parseInt(scan.nextLine());
        if (colorInput >= 1 && colorInput <= 3){
            color = BirdColor.values()[colorInput - 1];
        }
        else{
            color = BirdColor.UNKNOWN;
        }

        System.out.println();
        System.out.println("Bird's is living in an aviary? (true/false)");
        isLivingInAviary = Boolean.parseBoolean(scan.nextLine());


        Bird newBird = new Bird(baseData.getName(), baseData.getSex(), baseData.getWeight(), baseData.getHeight(), baseData.getBirthDay(), baseData.getArrivingDate(), color, isLivingInAviary);
        petShop.addAnimal(newBird);

        System.out.println("New bird encoded!");
    }
}
