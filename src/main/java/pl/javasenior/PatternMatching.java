package pl.javasenior;

class PatternMatching {

    //Przed Java 21
    public String formatter(Object obj) {
        String formatted = "unknown";
        if (obj instanceof Integer i) {
            formatted = String.format("int %d", i);
        } else if (obj instanceof Long l) {
            formatted = String.format("long %d", l);
        } else if (obj instanceof Double d) {
            formatted = String.format("double %f", d);
        } else if (obj instanceof String s) {
            formatted = String.format("String %s", s);
        }
        return formatted;
    }



    //Java 21
    public String formatterPatternSwitch(Object obj) {
        return switch (obj) {
            case Integer i -> String.format("int %d", i);
            case Long l -> String.format("long %d", l);
            case Double d -> String.format("double %f", d);
            case String s -> String.format("String %s", s);
            default -> obj.toString();
        };
    }



    //Java 21
    public void conditionInSwitch21(Object obj) {
        switch (obj) {
            case Integer i -> System.out.println(i);
            case String s when s.length() > 7 -> System.out.println(s.toUpperCase());
            case String s -> System.out.println(s.toLowerCase());
            default -> System.out.println("Coś innego!");
        }
    }
}

