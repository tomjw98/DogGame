package dog;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Dog {

    private String name;
    private String furColour;
    private DogBreeds breed;
    private int age;
    private int hungerLevel;
    private int thirstLevel;
    private boolean hungry;
    private boolean thirsty;
    private boolean needsToBeBrushed;
    private boolean wantsToPlay;
    private boolean needsAWalk;
    private Random rand = new Random();

    public Dog() {
        this.name = getRandomName();
        this.age = rand.nextInt(16);
        this.breed = getRandomDogBreed();
        this.furColour = getRandomFurColour();
        this.hungry = rand.nextBoolean();
        this.thirsty = rand.nextBoolean();
        this.needsToBeBrushed = rand.nextBoolean();
        this.wantsToPlay = rand.nextBoolean();
        this.needsAWalk = rand.nextBoolean();
    }

    public Dog(DogBreeds breed) {
        this.breed = breed;
        this.furColour = getRandomFurColour();
    }

    public DogBreeds getRandomDogBreed() {
        DogBreeds[] dogBreeds = DogBreeds.values();
        return dogBreeds[rand.nextInt(4)];
    }

    public String getRandomName() {
        List<String> names = new ArrayList<>(Arrays.asList(
                "Ava", "Barley", "Basil", "Bean", "Bear", "Bella", "Biscuit", "Blossom", "Boots", "Buddy",
                "Buster", "Buttons", "Cinnamon", "Clover", "Cookie", "Cooper", "Dudley", "Ginger", "Harper",
                "Hazel", "Jada", "Java", "Leia", "Lucky", "Max", "Muffin", "Nelson", "Oreo", "Peaches",
                "Peanut", "Poppy", "Pumpkin", "Summer", "Teddy", "Waffles"
        ));
        return names.get(rand.nextInt(34));
    }

    public String printAgeText() {
        if (this.getAge() <= 3) {
            return getName() + " is very young!";
        }
        else if(this.getAge() >= 10) {
            return getName() + " is very old!";
        }
        else {
            return "Cute!";
        }
    }

    public String getRandomFurColour() {
        List<String> furColours;
        switch (breed) {
            case GOLDEN_RETRIEVER -> furColours = new ArrayList<>(Arrays.asList(
                    "Gold", "Cream", "Beige"));

            case GERMAN_SHEPHERD -> furColours = new ArrayList<>(Arrays.asList(
                    "Black and brown", "Black and red", "Black", "White"));

            case SIBERIAN_HUSKY -> furColours = new ArrayList<>(Arrays.asList(
                    "Black and white", "Gray", "White", "Brown and white"));

            case LABRADOR -> furColours = new ArrayList<>(Arrays.asList(
                    "Gold", "Black", "Brown"));

            default -> furColours = new ArrayList<>();
        }
        return furColours.get(rand.nextInt(furColours.size()));
    }

    public boolean checkPooch() {
        if (isHungry()) {
            System.out.println(getName() + " is hungry!");
        }
        if (isThirsty()) {
            System.out.println(getName() + " is thirsty!");
        }
        if (isNeedsToBeBrushed()) {
            System.out.println(getName() + " needs to be brushed!");
        }
        if (isWantsToPlay()) {
            System.out.println(getName() + " wants to play!");
        }
        if (isNeedsAWalk()) {
            System.out.println(getName() + " needs to go for a walk!");
        }
        if (!isHungry() && !isThirsty() && !isNeedsToBeBrushed() && !isWantsToPlay() && !isNeedsAWalk()) {
            System.out.println(getName() + " is super happy, no need to look after them :)");
            System.out.println();
            return false;
        }
        return true;
    }

    public void feed() {
        if (!isHungry()) {
            System.out.println(getName() + " isn't hungry!");
            return;
        }
        setHungry(false);
        System.out.println("You give " + getName() + " some tasty biscuits! So yum!");
        System.out.println();
    }

    public void water() {
        if (!isThirsty()) {
            System.out.println(getName() + " isn't thirsty!");
            return;
        }
        setThirsty(false);
        System.out.println("You fill up " + getName() + "'s water bowl! So refreshing!");
        System.out.println();
    }

    public void brush() {
        if (!isNeedsToBeBrushed()) {
            System.out.println(getName() + " doesn't need to be brushed!");
            return;
        }
        setNeedsToBeBrushed(false);
        System.out.println("You brush " + getName() + "'s lovely soft fur! " + getName() + " closes their eyes" +
                " to relax and enjoy the pampering!");
        System.out.println();
    }

    public void play() {
        if (!(isHungry() && isThirsty())) {
            if (isWantsToPlay()) {
                setWantsToPlay(false);
                System.out.println("You throw " + getName() + "'s favourite tennis ball as they jolt after it! Such a" +
                        " happy pooch!!");
                System.out.println();
                setHungry(true);
                setThirsty(true);
                setNeedsToBeBrushed(true);
            }
            else {
                System.out.println(getName() + " doesn't feel like playing right now, too cosy!");
                System.out.println();
            }
        }
        else {
            System.out.println("Make sure that " + getName() + " has had enough to eat and drink first!");
            System.out.println();
        }
    }

    public void goForWalk() {
        if (!isHungry() && !isThirsty()) {
            if (isNeedsAWalk()) {
                if (this.getBreed().WALK_LENGTH <= 5) {
                    System.out.println("You take " + this.getName() + " for a short " + this.getBreed().WALK_LENGTH
                            + "km walk.");
                    System.out.println(this.getName() + " is a lazy pooch!");
                    System.out.println();
                }
                else if (this.getBreed().WALK_LENGTH <= 7) {
                    System.out.println("You take " + this.getName() + " for a medium " + this.getBreed().WALK_LENGTH
                            + "km walk.");
                    System.out.println(this.getName() + " is excited to see what's going on outside!");
                    System.out.println();
                }
                else  {
                    System.out.println("You take " + this.getName() + " for a long " + this.getBreed().WALK_LENGTH
                            + "km walk.");
                    System.out.println("What an energetic pooch!");
                    System.out.println();
                }
                setNeedsAWalk(false);
                setHungry(true);
                setThirsty(true);
                setNeedsToBeBrushed(true);
            }
            else {
                System.out.println(getName() + " doesn't feel like going for a walk right now, soooo lazy!");
                System.out.println();
            }
        }
        else {
            System.out.println("Make sure that " + getName() + " has had enough to eat and drink first!");
            System.out.println();
        }
    }
}
