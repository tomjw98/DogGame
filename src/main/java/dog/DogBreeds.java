package dog;

public enum DogBreeds {

    GOLDEN_RETRIEVER(5),
    GERMAN_SHEPHERD(7),
    SIBERIAN_HUSKY(10),
    LABRADOR(6);

    final int WALK_LENGTH;

    DogBreeds(int walkLength) {
        this.WALK_LENGTH = walkLength;
    }

    public String toString() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase().replace("_", " ");
    }
}
