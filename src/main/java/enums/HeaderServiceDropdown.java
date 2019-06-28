package enums;

public enum HeaderServiceDropdown {

    SUPPORT("SUPPORT"),
    DATES("DATES"),
    SEARCH("SEARCH"),
    COMPLEX_TABLE("COMPLEX TABLE"),
    SIMPLE_TABLE("SIMPLE TABLE"),
    USER_TABLE("USER TABLE"),
    TABLE_WITH_PAGES("TABLE WITH PAGES"),
    DIFFERENT_ELEMENTS("DIFFERENT ELEMENTS"),
    PERFORMANCE("PERFORMANCE");

    final String name;

    HeaderServiceDropdown(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}