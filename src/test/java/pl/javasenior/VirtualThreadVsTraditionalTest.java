package pl.javasenior;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

class VirtualThreadVsTraditionalTest {

    private static final int THREAD_NUMBER = 20_000;

    @Test
    void traditionalThread(){
        long start = System.currentTimeMillis();

        try (var executor = Executors.newFixedThreadPool(THREAD_NUMBER)) {
            IntStream.range(0, THREAD_NUMBER).forEach(i -> executor.submit(() -> {
                Thread.sleep(Duration.ofSeconds(1));
                return i;
            }));
        }

        long end = System.currentTimeMillis();
        System.out.println("Tradycyjne wątki: " + (end - start) + "ms");
    }

    @Test
    void virtualThread(){
        long start = System.currentTimeMillis();

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, THREAD_NUMBER).forEach(i -> executor.submit(() -> {
                Thread.sleep(Duration.ofSeconds(1));
                return i;
            }));
        }

        long end = System.currentTimeMillis();
        System.out.println("Wirtualne wątki: " + (end - start) + "ms");
    }
}
