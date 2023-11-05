package pl.javasenior.preview;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;

class ScopedValuesTest {

    private static final ScopedValue<String> USER_SESSION = ScopedValue.newInstance();

    @Test
    void scopedValue() {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            executor.submit(() -> processRequest("User1_Session"));
            executor.submit(() -> processRequest("User2_Session"));
        }
    }

    void processRequest(String sessionId) {
        ScopedValue.runWhere(USER_SESSION, sessionId, () -> {
            System.out.println("Start procesowania dla: " + USER_SESSION.get());
            performSomeOperation();
        });
    }

    void performSomeOperation() {
        System.out.println("Dodatkowa operacja dla:  " + USER_SESSION.get());
    }
}
