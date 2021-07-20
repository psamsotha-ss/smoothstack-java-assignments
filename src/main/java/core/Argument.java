package core;

public class Argument {

    private final int position;
    private final String name;
    private final String description;
    private final boolean isList;

    public Argument(int position, String name, String description) {
        this(position, name, description, false);
    }

    public Argument(int position, String name, String description, boolean isList) {
        this.position = position;
        this.name = name;
        this.description = description;
        this.isList = isList;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isList() {
        return isList;
    }
}
