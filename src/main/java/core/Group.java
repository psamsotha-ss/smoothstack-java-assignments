package core;

public enum Group {

    ONE("Java Basics 1"),
    TWO("Java Basics 2"),
    THREE("Java Basics 3"),
    FOUR("Java Basics 4"),
    FIVE("Java Basics 5");

    private final String name;

    Group(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
