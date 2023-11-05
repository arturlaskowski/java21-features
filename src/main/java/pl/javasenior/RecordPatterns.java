package pl.javasenior;

class RecordPatterns {

    public record Discount(String type, int percent) {
    }

    public record Reward(String type, String name) {
    }

    //Java 16
    public void processRewardOrDiscount16(Object obj) {
        if (obj instanceof Discount discount) {
            String type = discount.type();
            int percent = discount.percent();
            printDiscount(type, percent);
        }
        else if (obj instanceof Reward reward) {
            String type = reward.type();
            String name = reward.name();
            printReward(type, name);
        } else {
            printUnknownType();
        }
    }



    //Java 21
    public void processRewardOrDiscount21(Object obj) {
        if (obj instanceof Discount(String type, int percent)) { //od razu deklaracja pól
            printDiscount(type, percent);
        }

        else if (obj instanceof Reward(String type, String name)) {
            printReward(type, name);
        } else {
            printUnknownType();
        }
    }



    //Java 21
    public void patternMatchingWithRecordPattern(Object obj) {
        switch (obj) {
            case String s when s.length() > 7 -> System.out.println(s.toUpperCase());
            case String s -> System.out.println(s.toLowerCase());
            case Discount(String type, int percent) -> printDiscount(type, percent);
            case Reward(String type, String name) -> printReward(type, name);
            default -> printUnknownType();
        }
    }






    private static void printReward(final String type, final String name) {
        System.out.printf("This is a %s reward: %s.%n", type, name);
    }

    private static void printDiscount(final String type, final int percent) {
        System.out.printf("This is a %s discount of %d%%.%n", type, percent);
    }

    private static void printUnknownType() {
        System.out.println("This is an unknown type.");
    }
}
