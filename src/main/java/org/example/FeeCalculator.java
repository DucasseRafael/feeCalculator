package org.example;

public class FeeCalculator {

    public static double calculateFee(Visitor visitor, TicketType ticketType) {
        double fee = 0;

        // calculate price for adults
        fee = AdultStrategy.calculateFee(ticketType);

        // calculate price for children
        fee = ChildStrategy.calculateFee(ticketType);
        return fee;
    }

}
