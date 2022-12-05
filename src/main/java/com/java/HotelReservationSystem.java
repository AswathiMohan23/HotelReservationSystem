package com.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class HotelReservationSystem {
    public static Scanner sc=new Scanner(System.in);
    public static Map <Integer,List>reservationSystemMap=new HashMap<Integer, List>();
    public static List reservationLakeWood=new ArrayList();
    public static List reservationBridgeWood=new ArrayList();
    public static List reservationRidgeWood=new ArrayList();
    public static long noOfDays=0;

    public static HotelDetails lakeWood=new HotelDetails("lakeWood",110.00,80.00,90.00,80.00,3);
    public static HotelDetails bridgewood=new HotelDetails("bridgewood",160,110,90,80,4);
    public static HotelDetails ridgewood=new HotelDetails("ridgewood",220,100,150,40,5);



    List hotelDetails=new ArrayList();

    public HotelDetails details=new HotelDetails();

    Map <Integer,List> hotelMap=new HashMap<>();

    public static void main(String[] args) throws ParseException {
        System.out.println("\n\t\t\t\t Welcome to hotel reservation\n\t\t\t\t******************************\n");
        creatingList();
        findingCheapestHotel();


    }

    private static void findingCheapestHotel() throws ParseException {
        Date daysOfStay = calculatingTheDaysOfStay();
        if ((daysOfStay.toString().contains("Mon")) || (daysOfStay.toString().contains("Tues")) || (daysOfStay.toString().contains("Wed"))
                || (daysOfStay.toString().contains("thurs")) || (daysOfStay.toString().contains("Fri"))) {
            double lakeWoodNormal = lakeWood.getWeekDayRateNormal();
            double bridgeWoodNormal = bridgewood.getWeekDayRateNormal();
            double ridgeWoodNormal = ridgewood.getWeekDayRateNormal();
            if ((lakeWoodNormal < bridgeWoodNormal) && (lakeWoodNormal < ridgeWoodNormal))
                System.out.println("\n======================================== Cheapest is LakeWood =  " + lakeWood.getWeekDayRateNormal() + " $ ========================================");
            else if ((bridgeWoodNormal < lakeWoodNormal) && (bridgeWoodNormal < ridgeWoodNormal))
                System.out.println("\n======================================== Cheapest is BridgeWood =  " + bridgewood.getWeekDayRateNormal() + " $ ========================================");
            else
                System.out.println("\n======================================== Cheapest is RidgeWood =  " + ridgewood.getWeekDayRateNormal() + " $ ========================================");
        }
    }

    private static Date calculatingTheDaysOfStay() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
            "dd-MM-yyyy");

        String checkIn = "10-09-2020 01:10:20";
        String checkOut = "11-09-2020 06:30:50";
        Date d1 = dateFormat.parse(checkIn);
        Date d2 = dateFormat.parse(checkOut);
        long differenceInTime = d2.getTime() - d1.getTime();
        noOfDays = (differenceInTime / (1000 * 60 * 60 * 24)) % 365;
        Date dayOfStay = (new Date(2020, Calendar.SEPTEMBER, 10));
        System.out.println("no of days of stay = "+noOfDays+" day");
        System.out.println("The day is : "+dayOfStay);
        return dayOfStay;

    }

    public static void creatingList() {
        addingDetails(lakeWood,reservationLakeWood);
        addingDetails(bridgewood,reservationBridgeWood);
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




