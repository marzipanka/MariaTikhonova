package enums;

public enum LeftServiceDropdown {

    SUPPORT("Support"),
    DATES("Dates"),
    COMPLEX_TABLE("Complex Table"),
    SIMPLE_TABLE("Simple Table"),
    SEARCH("Search"),
    USER_TABLE("User Table"),
    TABLE_WITH_PAGES("Table with pages"),
    DIFFERENT_ELEMENTS("Different elements"),
    PERFORMANCE("Performance");

    final String name;

    LeftServiceDropdown(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}