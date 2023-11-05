package pl.javasenior.preview;

import org.junit.jupiter.api.Test;

import java.util.List;

class UnnamedPatternsAndVariablesTest {

    @Test
    void unnamedVariable() {
        try {
            Integer.parseInt("123a");
        } catch (NumberFormatException _) {
            System.out.println("To nie jest prawidłowa liczba całkowita");
        }
    }

    @Test
    void unnamedVariableLambda() {
        List<String> names = List.of("Marek", "Bogdan", "Grześ");
        names.forEach(_ -> System.out.println("Moge tak, to robie"));
    }

    @Test
    void unnamedVariableSwitch() {
        Object obj = "Coś tam";
        String output = switch (obj) {
            case Integer _ -> "Jestem numerkiem";
            case String _ -> "Jestem tekstem";
            default -> "Nie wiem kim jestem";
        };
        System.out.println(output);
    }

    @Test
    void unnamedVariableRecord() {
        record Discount(String type, int percent) {
        }
        record Reward(String type, String name) {
        }

        Object benefit = new Discount("Kupon rabatowy", 10);

        String opis = switch (benefit) {
            case Discount(String type, int _) -> String.format("Wygrałeś zniżkę typu: %s", type);
            case Reward(String type, String _) -> String.format("Wygrałeś nagrodę typu: %s", type);
            default -> "Nieznany benefit";
        };
        System.out.println(opis);
    }


}
