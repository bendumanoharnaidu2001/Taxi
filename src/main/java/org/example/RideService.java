package org.example;

import java.util.ArrayList;
import java.util.List;
public class RideService {
    private double distance;
    private double waitTime;
    private double TotalFareForTheRide;
    public RideService(double distance, double waitTime, double TotalFareForTheRide) {
        this.distance = distance;
        this.waitTime = waitTime;
        this.TotalFareForTheRide = TotalFareForTheRide;
    }
    private List<RideService> RidesList = new ArrayList<>();

    private List<Fare> rides;
    public RideService(){
        this.rides = new ArrayList<>();
    }
    public void addRide(double distance, double waitTime, double TotalFareForTheRide) {
        RidesList.add(new RideService(distance, waitTime, TotalFareForTheRide));
//        Fare fare = new Fare(distance, waitTime, TotalFareForTheRide);
//        rides.add(fare);
    }
    public double TotalFareForListOfRides() {
        double totalFare = 0;
        for (int i=0; i<RidesList.size(); i++) {
            totalFare += rides.get(i).calculate();
        }
        return totalFare;
    }
}
