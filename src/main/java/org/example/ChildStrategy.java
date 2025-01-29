package org.example;

public class ChildStrategy {
    static final double CHILD_PRICE_BASE = 100;

    static double calculateFee(TicketType ticketType) {
        // calculate price for adults
        if (TicketType.HALF_DAY == ticketType) {
            return CHILD_PRICE_BASE * 0.2;
        } else if (TicketType.FULL_DAY == ticketType) {
            return CHILD_PRICE_BASE * 0.5;
        } else {
            throw new IllegalArgumentException("TicketType " + ticketType + " not supprted");
        }
    }
}