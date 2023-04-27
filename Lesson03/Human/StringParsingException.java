package Lesson03.Human;

abstract class HumanException extends Exception {
    private final String name;
    private final int index;

    public String getName() {
        return this.name;
    }

    public int getIndex() {
        return this.index;
    }

    public HumanException(String massage, String name, int index) {
        super(massage);
        this.name = name;
        this.index = index;
    }
}

public class StringParsingException extends HumanException {
    public StringParsingException(String message, String name, int index) {
        super(message, name, index);
    }
}