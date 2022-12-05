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
    public static Date  dayOfStay1;
    public static Date  dayOfStay2;
    public static final int noOfDays=2;
    public static String dayOfWeek1;
    public static String dayOfWeek2;
    public static HotelDetails lakeWood=new HotelDetails("lakeWood",110.00,80.00,90.00,80.00,3);
    public static HotelDetails bridgewood=new HotelDetails("bridgewood",160,110,90,80,4);
    public static HotelDetails ridgewood=new HotelDetails("ridgewood",220,100,150,40,5);



    public static void main(String[] args) throws ParseException {
        System.out.println("\n\t\t\t\t Welcome to hotel reservation\n\t\t\t\t******************************\n");
        creatingList();
        findingCheapestHotel("10-09-2020","11-09-2020",10,11);
        findingCheapestHotel("11-09-2020","12-09-2020",11,12);


    }

    private static void findingCheapestHotel(String checkIn,String checkOut,int day1,int day2) throws ParseException {
        double totalRateLakewood=0 ,totalRateBridgeWood=0,totalRateRidgeWood=0;
        calculatingTheDaysOfStay(checkIn,checkOut,day1,day2);
        System.out.println("No of days = "+noOfDays);

        if((dayOfWeek1.equals("Sun")||(dayOfWeek1.equals("Sat")))&&(dayOfWeek2.equals("Sun")||(dayOfWeek2.equals("Sat")))){
            totalRateLakewood=lakeWood.getWeekEndRateNormal()+lakeWood.getWeekEndRateNormal();
            totalRateBridgeWood=bridgewood.getWeekEndRateNormal()+bridgewood.getWeekEndRateNormal();
            totalRateRidgeWood=ridgewood.getWeekEndRateNormal()+ridgewood.getWeekEndRateNormal();
            compareTheRate(totalRateLakewood,totalRateBridgeWood,totalRateRidgeWood);
       }
       else if((dayOfWeek1.equals("Sun")||(dayOfWeek1.equals("Sat")))&&((dayOfWeek2.toString().contains("Mon")) || (dayOfWeek2.toString().contains("Tues")) || (dayOfWeek2.toString().contains("Wed"))
                                    || (dayOfWeek2.toString().contains("thurs")) || (dayOfWeek2.toString().contains("Fri")))) {
            totalRateLakewood=lakeWood.getWeekEndRateNormal()+lakeWood.getWeekDayRateNormal();
            totalRateBridgeWood=bridgewood.getWeekEndRateNormal()+bridgewood.getWeekDayRateNormal();
            totalRateRidgeWood=ridgewood.getWeekEndRateNormal()+ridgewood.getWeekDayRateNormal();
            compareTheRate(totalRateLakewood,totalRateBridgeWood,totalRateRidgeWood);
        }
       else
        {
            totalRateLakewood=lakeWood.getWeekDayRateNormal()+lakeWood.getWeekDayRateNormal();
            totalRateBridgeWood=bridgewood.getWeekDayRateNormal()+bridgewood.getWeekDayRateNormal();
            totalRateRidgeWood=ridgewood.getWeekDayRateNormal()+ridgewood.getWeekDayRateNormal();
            compareTheRate(totalRateLakewood,totalRateBridgeWood,totalRateRidgeWood);
        }


    }

    private static void compareTheRate(double totalRateLakewood, double totalRateBridgeWood, double totalRateRidgeWood) {
        if ((totalRateLakewood < totalRateBridgeWood) && (totalRateLakewood < totalRateRidgeWood))
            System.out.println("\n======================================== Cheapest is LakeWood =  " + totalRateLakewood + " $ ========================================");
        else if ((totalRateBridgeWood < totalRateLakewood) && (totalRateBridgeWood < totalRateRidgeWood))
            System.out.println("\n======================================== Cheapest is BridgeWood =  " + totalRateBridgeWood + " $ ========================================");
        else if((totalRateRidgeWood< totalRateLakewood) && (totalRateRidgeWood<totalRateBridgeWood))
            System.out.println("\n======================================== Cheapest is RidgeWood =  " + totalRateRidgeWood + " $ ========================================");
        else if(((totalRateBridgeWood>totalRateRidgeWood)&&(totalRateBridgeWood>totalRateLakewood))&&(totalRateRidgeWood == totalRateLakewood))
            System.out.println("\n======================================== RidgeWood & LakeWood are cheaper both =  " + totalRateRidgeWood + " $ ========================================");
        else if(((totalRateLakewood>totalRateRidgeWood)&&(totalRateLakewood>totalRateBridgeWood))&&(totalRateRidgeWood == totalRateBridgeWood))
            System.out.println("\n======================================== RidgeWood & BridgeWood are cheaper both =  " + totalRateRidgeWood + " $ ========================================");
        else if(((totalRateRidgeWood>totalRateBridgeWood)&&(totalRateRidgeWood>totalRateLakewood))&&(totalRateLakewood == totalRateBridgeWood))
            System.out.println("\n======================================== LakeWood & BridgeWood are cheaper both =  " + totalRateBridgeWood + " $ ========================================");

    }


    private static String checkingTheDays(Date dayOfStay) {
        String weekDay;
        if(dayOfStay.equals("Sun"))
            weekDay="Sun";
        else if(dayOfStay.equals("Mon"))
            weekDay ="Mon";
        else if(dayOfStay.equals("Tues"))
            weekDay= "Tues";
        else if(dayOfStay.equals("Wed"))
            weekDay= "Wed";
        else if(dayOfStay.equals("Thurs"))
            weekDay= "Thurs";
        else if(dayOfStay.equals("Fri"))
            weekDay= "Fri";
        else if(dayOfStay.equals("Sat"))
            weekDay= "Sat";
        else
            weekDay="Sun";
        return weekDay;


    }


    private static void calculatingTheDaysOfStay(String checkIn, String checkOut, int day1, int day2) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
            "dd-MM-yyyy");
        Date d1 = dateFormat.parse(checkIn);
        Date d2 = dateFormat.parse(checkOut);
        long differenceInTime = d2.getTime() - d1.getTime();
       // noOfDays = (differenceInTime / (1000 * 60 * 60 * 24)) % 365;
        Date dayOfStay1 = (new Date(2020, Calendar.SEPTEMBER, day1));
        Date dayOfStay2 = (new Date(2020, Calendar.SEPTEMBER, day2));
        System.out.println("no of days of stay = "+noOfDays+" day");
        System.out.println("The day is : "+dayOfStay1);
        System.out.println("The day is : "+dayOfStay2);
        dayOfWeek1 = checkingTheDays(dayOfStay1);
        dayOfWeek2 = checkingTheDays(dayOfStay2);

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




