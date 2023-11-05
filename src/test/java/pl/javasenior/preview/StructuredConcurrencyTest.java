package pl.javasenior.preview;

import org.junit.jupiter.api.Test;

import java.util.concurrent.StructuredTaskScope;
import java.util.function.Supplier;

class StructuredConcurrencyTest {

    @Test
    void structuredConcurrency() throws InterruptedException {
            Response response = getResponse(true);
            System.out.println("Odpowiedź otrzymana: " + response);
    }

    private Response getResponse(boolean stop) throws InterruptedException {
        System.out.println("Tworzenie nowych wątków...");

        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            Supplier<FirstDto> firstDtoFuture = scope.fork(() -> firstProcess(stop));
            Supplier<SecondDto> secondDtoFuture = scope.fork(() -> secondProcess(stop));
            Supplier<ThirdDto> thirdDtoFuture = scope.fork(() -> thirdProcess(stop));

            System.out.println("Łączenie wszystkich wątków...");
            scope.join();
            scope.throwIfFailed(DejSpokojException::new);

            System.out.println("Wszystko operacje zostały przeprocesowane");

            return new Response(firstDtoFuture.get(), secondDtoFuture.get(), thirdDtoFuture.get());
        }
    }

    private FirstDto firstProcess(boolean stop) {
        System.out.println("pirweszy proces");
        if (stop) {
            throw new IllegalArgumentException();
        }
        return new FirstDto();
    }

    private SecondDto secondProcess(boolean stop) throws InterruptedException {
        Thread.sleep(2000L);
        System.out.println("drugi proces");
        return new SecondDto();
    }

    private ThirdDto thirdProcess(boolean stop) throws InterruptedException {
        Thread.sleep(2000L);
        System.out.println("trzeci proces");
        return new ThirdDto();
    }

    record Response(
            FirstDto firstDto,
            SecondDto secondDto,
            ThirdDto thirdDto) {
    }

    record FirstDto() {
    }

    record SecondDto() {
    }

    record ThirdDto() {
    }
}

class DejSpokojException extends RuntimeException {
    DejSpokojException(Throwable e) {
        super(e);
    }
}

