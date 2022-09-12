package dog;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DogTest {

    @Test
    void ageShouldBeBetweenZeroAndFifteen() {
        Dog dog = new Dog();
        Assertions.assertTrue(dog.getAge() >= 0 && dog.getAge() < 16);
    }

    @Test
    void goldenRetrieverSpecificFurColours() {
        Dog dog = new Dog(DogBreeds.GOLDEN_RETRIEVER);
        Assertions.assertTrue(dog.getFurColour().equals("Gold") ||
                                        dog.getFurColour().equals("Cream") ||
                                        dog.getFurColour().equals("Beige"));
    }

    @Test
    void germanShepherdSpecificFurColours() {
        Dog dog = new Dog(DogBreeds.GERMAN_SHEPHERD);
        Assertions.assertTrue(dog.getFurColour().equals("Black and brown") ||
                dog.getFurColour().equals("Black and red") ||
                dog.getFurColour().equals("Black") ||
                dog.getFurColour().equals("White"));
    }

    @Test
    void siberianHuskySpecificFurColours() {
        Dog dog = new Dog(DogBreeds.SIBERIAN_HUSKY);
        Assertions.assertTrue(dog.getFurColour().equals("Black and white") ||
                dog.getFurColour().equals("Gray") ||
                dog.getFurColour().equals("White") ||
                dog.getFurColour().equals("Brown and white"));
    }

    @Test
    void labradorSpecificFurColours() {
        Dog dog = new Dog(DogBreeds.LABRADOR);
        Assertions.assertTrue(dog.getFurColour().equals("Gold") ||
                dog.getFurColour().equals("Black") ||
                dog.getFurColour().equals("Brown"));
    }

}