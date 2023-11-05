package pl.javasenior;

import org.junit.jupiter.api.Test;

class VirtualThreadTest {

    @Test
    void myFirstVirtualThread() {
        Runnable runnable = () -> System.out.println("Robie coś!");

        //wykonaj w wątku tradycyjnym
        Thread.ofPlatform().start(runnable);

        //wykonaj w wątku wirtualnym
        Thread.ofVirtual().start(runnable);

        //wykonaj w wątku wirtualnym inny sposób
        Thread.startVirtualThread(runnable);
    }


}
