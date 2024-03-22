package org.example;

public class Fare {
    private double distance;
    private double waitTime;
    private static final double MinimumFare = 25;
    private static final double FarePerKilometer = 12;
    private static final double FareForEveryMinute = 2;
    private static final double BaseFare = 2;
    private static final double ServiceFee = 1;

    public Fare(double distance, double waitTime, double TotalFareForTheRide) {
        if (distance<0 || waitTime<0) {
            throw new IllegalArgumentException("Distance and wait time must be positive");
        }
        this.distance = distance;
        this.waitTime = waitTime;
    }
    public double calculate() {
        double totalFare = (distance * FarePerKilometer) + (waitTime * FareForEveryMinute) + BaseFare;
        if (totalFare > 100) {
            totalFare += (totalFare * ServiceFee)/100;
        }
        RideService rideService = new RideService();
        double result = Math.max(MinimumFare, totalFare);
        rideService.addRide(distance, waitTime, result);
        return result;
    }
}
