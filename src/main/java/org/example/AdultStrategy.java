package org.example;

public class AdultStrategy {
    static final double ADULT_PRICE_BASE = 100;

    static double calculateFee(TicketType ticketType) {
        // calculate price for children
        if (TicketType.HALF_DAY == ticketType) {
            return ADULT_PRICE_BASE * 0.6;
        } else if (TicketType.FULL_DAY == ticketType) {
            return ADULT_PRICE_BASE * 1.2;
        } else {
            throw new IllegalArgumentException("TicketType not supported");
        }
    }
}