package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.catchException;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class FeeCalculatorTest {
    @Test
    public void for_age_under_14_HALF_DAY_should_calculate_20()
    {
        //GIVEN
        Visitor child = new Visitor(10);

        //WHEN
        double actualFee = FeeCalculator.calculateFee(child, TicketType.HALF_DAY);

        //THEN
        assertThat(actualFee).isEqualTo(20.0);
    }

    @Test
    public void for_age_under_14_FULL_DAY_should_calculate_50()
    {
        //GIVEN
        Visitor child = new Visitor(10);

        //WHEN
        double actualFee = FeeCalculator.calculateFee(child, TicketType.FULL_DAY);

        //THEN
        assertThat(actualFee).isEqualTo(50.0);
    }

    @Test
    public void for_age_under_14_WEEK_should_calculate_EXCEPTION()
    {
        //GIVEN
        Visitor child = new Visitor(10);

        //WHEN
        double actualFee = FeeCalculator.calculateFee(child, TicketType.FULL_DAY);

        //THEN
        assertThat(actualFee).isEqualTo(50.0);
    }

    @Test
    public void should_throw_exception_when_ticketType_not_supported_for_age_under_14()
    {
        //GIVEN
        Visitor child = new Visitor(10);

        //WHEN
        IllegalArgumentException erreur = (IllegalArgumentException)catchException(()->FeeCalculator.calculateFee(child, TicketType.WEEK));

        //THEN
        assertThat(erreur)
                .isNotNull()
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("TicketType not supported");
    }

    @Test
    public void for_age_above_14_HALF_DAY_should_calculate_60()
    {
        //GIVEN
        Visitor adult = new Visitor(20);

        //WHEN
        double actualFee = FeeCalculator.calculateFee(adult, TicketType.HALF_DAY);

        //THEN
        assertThat(actualFee).isEqualTo(60.0);
    }

    @Test
    public void for_age_above_14_FULL_DAY_should_calculate_120()
    {
        //GIVEN
        Visitor adult = new Visitor(20);

        //WHEN
        double actualFee = FeeCalculator.calculateFee(adult, TicketType.FULL_DAY);

        //THEN
        assertThat(actualFee).isEqualTo(120);
    }

    @Test
    public void should_throw_exception_when_ticketType_not_supported_for_age_above_14()
    {
        //GIVEN
        Visitor adult = new Visitor(20);

        //WHEN
        IllegalArgumentException erreur = (IllegalArgumentException)catchException(()->FeeCalculator.calculateFee(adult, TicketType.WEEK));

        //THEN
        assertThat(erreur)
                .isNotNull()
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("TicketType not supported");
    }

}