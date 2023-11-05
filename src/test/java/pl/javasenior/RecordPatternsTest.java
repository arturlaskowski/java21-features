package pl.javasenior;

import org.junit.jupiter.api.Test;

class RecordPatternsTest {

    @Test
    void java16vs21() {
        var recordPatterns = new RecordPatterns();
        var discount = new RecordPatterns.Discount("na pół", 50);
        recordPatterns.processRewardOrDiscount16(discount);
        recordPatterns.processRewardOrDiscount21(discount);
    }
}