package org.example;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class FareTest {
    @Test
    public void zeroDistanceAndZeroTimeFareIs25() {
        Fare fare = new Fare(0,0,0);
        assertEquals(25.0, fare.calculate());
    }
    @Test
    public void zeroDistanceAndTwoMinutesWaitTimeFareIs25() {
        Fare fare = new Fare(0,2,0);
        assertEquals(25.0, fare.calculate());
    }
    @Test
    public void CheckRiderTotalFareTillNow() {
        RideService rideService = new RideService();
        assertEquals(50, rideService.TotalFareForListOfRides());
    }
    @Test
    public void zeroDistanceAnd20MinutesWaitTimeFareIs40() {
        Fare fare = new Fare(0,20,0);
        assertEquals(42.0, fare.calculate());
    }
    @Test
    public void twoKmDistanceAndZeroMinutesWaitTimeFareIs26() {
        Fare fare = new Fare(2,0,0);
        assertEquals(26.0, fare.calculate());
    }
    @Test
    public void TwentyKmDistanceAnd20MinutesWaitTimeFareIs2848() {
        Fare fare = new Fare(20,20, 0);
        assertEquals(284.82,fare.calculate());
    }
    @Test
    public void NegativeDistanceAndZeroWaitTimeGivesException() {
        try {
            Fare fare = new Fare(-2,0,0);
            fare.calculate();
            Assert.fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Distance and wait time must be positive", e.getMessage());
        }
    }
    @Test
    public void NegativeDistanceAndZeroWaitTimeGivesException2() {
        try {
            Fare fare = new Fare(0,-2,0);
            fare.calculate();
            Assert.fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Distance and wait time must be positive", e.getMessage());
        }
    }

    @Test
    public void TotalRideFareForListOfRides() {
        RideService rideService = new RideService();
        rideService.addRide(2,0,0);
        rideService.addRide(0,2,0);
        assertEquals(51.0, rideService.TotalFareForListOfRides());
    }

}