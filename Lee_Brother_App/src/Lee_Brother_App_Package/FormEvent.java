
package Lee_Brother_App_Package;

import java.util.EventObject;

public class FormEvent extends EventObject{
    
    private int pax;
    private int day;
    private double destinationPrice;
    private String destination;
    private int month;
    private String monthName;
    private int oneRm;
    private int twoRm;
    private int threeRm;
    private int premiumMeal;
    private int smallTour = 0;
    private double smallTourCost = 0;
    private int bigTour = 0;
    private double bigTourCost = 0;
    private double tourTotal;
    private int tourDays;

    public FormEvent(Object source) {
        super(source);
    }
    
    public FormEvent(Object source, int pax, int day, DestinationPrice destination, SeasonMonth month, int oneRm, int twoRm, int threeRm, int premiumMeal, int tour) {
        super(source);
        
        this.pax = pax;
        this.day = day;
        this.destinationPrice = destination.getPrice();
        this.destination = destination.toString();
        this.month = month.getSeasonOption();
        this.monthName = month.toString();
        this.oneRm = oneRm;
        this.twoRm = twoRm;
        this.threeRm = threeRm;
        this.premiumMeal = premiumMeal;
        this.tourDays = tour;
        tourCalculation();
    }
    public int getPax() {
        return pax;
    }
    public int getDay() {
        return day;
    }
    public double getDestinationPrice() {
        return destinationPrice;
    }
    public String getDestination() {
        return destination;
    }
    public double getFlightRate(int month) {
        {
            switch (month) {
                case 1:
                    return (double) 1.3;
                case 2:
                    return (double) 1.5;
                case 3:
                    return (double) 1.2;
                default:
                    return (double) 1.4;
            }
        } 
    }
    public String getMonthName() {
        return monthName;
    }
    public int getMonth() {
        return month;
    }    
    public double getHotelRate(int month) {
        switch (month) {
            case 1:
                return (double) 1.3;
            case 2:
                return (double) 1.2;
            case 3:
                return (double) 1.4;
            default:        
                return (double) 1.1;
        }
    }
    public double getFlightTotal() {
        return pax*destinationPrice*getFlightRate(month);
    }

    public double getOneRmRate() {
        return day*(destinationPrice*((oneRm*getHotelRate(month))));
    }    
    public double getTwoRmRate() {
        return day*(destinationPrice*((twoRm*getHotelRate(month))/2));
    }
    public double getThreeRmRate() {
        return day*(destinationPrice*((threeRm*getHotelRate(month))/2));
    }
    public int getOneRm() {
        return oneRm;
    }
    public int getTwoRm() {
        return twoRm;
    }
    public int getThreeRm() {
        return threeRm;
    }
    public int getPremiumMeal() {
        return premiumMeal;
    }
    public int getAverageMeal() {
        return pax-premiumMeal;
    }
    public double getPremiumMealCost() {
        return day*premiumMeal*140;
    }
    public double getAverageMealCost() {
        return day*(pax-premiumMeal)*40;
    }     
    public int getSmallTour() {
        return smallTour;
    }
    public double getSmallTourCost() {
        return tourDays*smallTourCost;
    }
    public int getBigTour() {
        return bigTour;
    }
    public double getBigTourCost() {
        return tourDays*bigTourCost;
    }
    public double getTourTotal() {
        return tourTotal;
    }
    public double getTotalCost() {
        return (getFlightTotal() + getHotelTotal() + getMealTotal() + tourTotal);
    }
    public int getTourDays() {
        return tourDays;
    }
    public void tourCalculation() {
        int pax_count = pax;
        while(pax_count > 0 && tourDays != 0) {
            if(pax_count >= 11) {
                bigTour++;
                bigTourCost += 200;
                pax_count -= 30;
            }
            if(pax_count >=1 && pax_count <=10) {
                smallTour++;
                smallTourCost += 120;
                pax_count -= 10;
            }
        }
        tourTotal = (tourDays*bigTourCost) + (tourDays*smallTourCost);
    }   
    public double getIndividualFlight() {
        return destinationPrice*getFlightRate(month);
    }
    public double getIndividualOneRmHotel() {
        return (day*(destinationPrice*getHotelRate(month)));
    }
    public double getIndividualTwoRmHotel() {
        return (day*(destinationPrice*(getHotelRate(month))/2))/2;
    }    
    public double getIndividualThreeRmHotel() {
        return (day*(destinationPrice*(getHotelRate(month))/2))/3;
    }    
    public double getIndividualPremiumMeal() {
        return day*140;
    }
    public double getIndividualMeal() {
        return day*40;
    }
    public double getIndividualTour() {
        return tourTotal/pax;
    }
    public double getIndividualOneRmAverageMealTotal() {
        return getIndividualFlight() + getIndividualOneRmHotel() + getIndividualMeal() + getIndividualTour();
    }
    public double getIndividualOneRmPremiumMealTotal() {
        return getIndividualFlight() + getIndividualOneRmHotel() + getIndividualPremiumMeal() + getIndividualTour();
    }
    public double getIndividualTwoRmAverageMealTotal() {
        return getIndividualFlight() + getIndividualTwoRmHotel() + getIndividualMeal() + getIndividualTour();
    }
    public double getIndividualTwoRmPremiumMealTotal() {
        return getIndividualFlight() + getIndividualTwoRmHotel() + getIndividualPremiumMeal() + getIndividualTour();
    } 
    public double getIndividualThreeRmAverageMealTotal() {
        return getIndividualFlight() + getIndividualThreeRmHotel() + getIndividualMeal() + getIndividualTour();
    }
    public double getIndividualThreeRmPremiumMealTotal() {
        return getIndividualFlight() + getIndividualThreeRmHotel() + getIndividualPremiumMeal() + getIndividualTour();
    }      
    public double getHotelTotal() {
        return day*(destinationPrice*((oneRm*getHotelRate(month))+(((twoRm+threeRm)*getHotelRate(month))/2)));
    }
    public double getMealTotal() {
        return day*((getPremiumMeal()*140)+((getAverageMeal())*40));
    }
}

