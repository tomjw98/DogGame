package dog;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean isGameRunning = true;
        START: while (isGameRunning) {
            System.out.println("Welcome to Pooch Daycare!");
            System.out.println("A new pooch has arrived at the daycare! Let's go meet them");
            System.out.println();
            Dog dog = new Dog();
            System.out.println("Name: " + dog.getName());
            System.out.println("Age: " + dog.getAge() + " " + dog.printAgeText());
            System.out.println("Breed: " + dog.getBreed());
            System.out.println("Fur Colour: " + dog.getFurColour());
            System.out.println();
            boolean poochNeedsCare = true;
            while (poochNeedsCare) {
                Scanner input = new Scanner(System.in);
                System.out.println("What would you like to do?\n1: Check on " + dog.getName() + "\n2: Exit");
                String option = input.nextLine();
                switch (option) {
                    case "1" -> {
                        if(!dog.checkPooch()) {
                            continue START;
                        }
                    }
                    case "2" -> {
                        System.out.println("bye byeee!");
                        System.exit(0);
                    }
                    default -> {
                        System.out.println("Not a valid option!");
                        continue;
                    }
                }
                input = new Scanner(System.in);
                System.out.println();
                System.out.println("What would you like to do with " + dog.getName() + "?");
                System.out.println("1: Feed\n2: Give Water\n3: Brush\n4: Play\n5: Walk");
                option = input.nextLine();
                switch (option) {
                    case "1" -> dog.feed();
                    case "2" -> dog.water();
                    case "3" -> dog.brush();
                    case "4" -> dog.play();
                    case "5" -> dog.goForWalk();
                    default -> System.out.println("Not a valid option!");
                }
            }
        }
    }
}
