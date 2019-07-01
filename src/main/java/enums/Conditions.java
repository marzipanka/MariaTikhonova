package enums;

public enum Conditions {

    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    final String name;

    Conditions(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}