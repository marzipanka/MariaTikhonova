package enums;

public enum IndexPageTexts {

        TO_INCLUDE("To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project"),
        TO_BE_FLEXIBLE("To be flexible and\n" +
                "customizable"),
        TO_BE_MULTIPLATFORM("To be multiplatform"),
        ALREADY_HAVE_GOOD_BASE("Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");

        final String name;

        IndexPageTexts(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

}
