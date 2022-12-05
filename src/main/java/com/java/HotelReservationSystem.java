package com.java;

import java.util.*;

public class HotelReservationSystem {
    public static Scanner sc=new Scanner(System.in);
    public static Map <Integer,List>reservationSystemMap=new HashMap<Integer, List>();
    public static List reservationLakeWood=new ArrayList();
    public static List reservationBridgeWood=new ArrayList();
    public static List reservationRidgeWood=new ArrayList();

    List hotelDetails=new ArrayList();

    public HotelDetails details=new HotelDetails();

    Map <Integer,List> hotelMap=new HashMap<>();

    public static void main(String[] args) {
        System.out.println("\n\t\t\t\t Welcome to hotel reservation\n\t\t\t\t******************************\n");
        creatingList();


    }

    public static void creatingList() {
        HotelDetails lakeWood=new HotelDetails("lakeWood",110.00,80.00,90.00,80.00,3);
        addingDetails(lakeWood,reservationLakeWood);
        HotelDetails bridgewood=new HotelDetails("bridgewood",160,110,90,80,4);
        addingDetails(bridgewood,reservationBridgeWood);
        HotelDetails ridgewood=new HotelDetails("ridgewood",220,100,150,40,5);
        addingDetails(ridgewood,reservationRidgeWood);
        reservationSystemMap.put(1, reservationLakeWood);
        reservationSystemMap.put(2, reservationBridgeWood);
        reservationSystemMap.put(3, reservationRidgeWood);
        System.out.println(reservationSystemMap);
    }

    private static void addingDetails(HotelDetails hotel,List hotelList) {
        hotelList.add(hotel.getName());
        hotelList.add(hotel.getWeekEndRateNormal());
        hotelList.add(hotel.getWeekDayRateReward());
        hotelList.add(hotel.getWeekEndRateNormal());
        hotelList.add(hotel.getWeekEndRateReward());
        hotelList.add(hotel.getRating());
    }


}




