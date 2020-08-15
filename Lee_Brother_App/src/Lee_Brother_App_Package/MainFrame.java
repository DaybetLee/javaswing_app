package Lee_Brother_App_Package;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
    
    private TextPanel textPanel;
    private FormPanel formPanel;
    
    public MainFrame(){
        
        super("Lee Brother Japan Booking Calculator");
        
        setLayout(new BorderLayout());
        setResizable(false);
        setSize(700, 625);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setVisible(true);
        setLocationRelativeTo(null);
        
        textPanel = new TextPanel();
        formPanel = new FormPanel();
        
        add(textPanel, BorderLayout.SOUTH);
        add(formPanel, BorderLayout.CENTER);
        
        formPanel.getRootPane().setDefaultButton(formPanel.getTotalBtn());        
        
        formPanel.setResetFormListener(new ResetFormListener() {
            public void resetForm() {
                textPanel.setIntroductionText();
            }
        });        
        
        formPanel.setWarningError(new WarningErrorListener() {
            public void textEmitted(String text) {
                textPanel.setWarningText(text);
            }
        });
        
        formPanel.setFormListener(new FormListener() {
            public void formEventOccurred(FormEvent ev) {
                int pax = ev.getPax();
                int day = ev.getDay();
                String destinationPrice = String.format("%.2f",ev.getDestinationPrice());
                String destination = ev.getDestination();
                double destinationRate = ev.getFlightRate(ev.getMonth());
                String monthName = ev.getMonthName();                
                double hotelRate = ev.getHotelRate(ev.getMonth());
                String flightTotal = String.format("%.2f",ev.getFlightTotal());             
                String oneRmRate = String.format("%.2f",ev.getOneRmRate());
                String twoRmRate = String.format("%.2f",ev.getTwoRmRate());
                String threeRmRate = String.format("%.2f",ev.getThreeRmRate());                
                int oneRm = ev.getOneRm();
                int twoRm = ev.getTwoRm();
                int threeRm = ev.getThreeRm();
                int premiumMeal = ev.getPremiumMeal();
                int averageMeal = ev.getAverageMeal();
                String premiumMealCost = String.format("%.2f",ev.getPremiumMealCost());
                String averageMealCost = String.format("%.2f",ev.getAverageMealCost());
                String individualPremiumMeal = String.format("%.2f",ev.getIndividualPremiumMeal());
                String individualAverageMeal = String.format("%.2f",ev.getIndividualMeal()); 
                int smallTour = ev.getSmallTour();
                String smallTourCost = String.format("%.2f",ev.getSmallTourCost());
                int bigTour = ev.getBigTour();
                String bigTourCost = String.format("%.2f",ev.getBigTourCost());
                String individualTour = String.format("%.2f",ev.getIndividualTour());
                String totalCost = String.format("%.2f",ev.getTotalCost());
                int tourDays = ev.getTourDays();
                String individualFlight = String.format("%.2f",ev.getIndividualFlight());                
                String individualOneRmHotel = String.format("%.2f",ev.getIndividualOneRmHotel());
                String individualTwoRmHotel = String.format("%.2f",ev.getIndividualTwoRmHotel());
                String individualThreeRmHotel = String.format("%.2f",ev.getIndividualThreeRmHotel());                   
                String individualOneRmAverageMealTotal = String.format("%.2f",ev.getIndividualOneRmAverageMealTotal());                
                String individualOneRmPremiumMealTotal = String.format("%.2f",ev.getIndividualOneRmPremiumMealTotal());
                String individualTwoRmAverageMealTotal = String.format("%.2f",ev.getIndividualTwoRmAverageMealTotal());                
                String individualTwoRmPremiumMealTotal = String.format("%.2f",ev.getIndividualTwoRmPremiumMealTotal());
                String individualThreeRmAverageMealTotal = String.format("%.2f",ev.getIndividualThreeRmAverageMealTotal());                
                String individualThreeRmPremiumMealTotal = String.format("%.2f",ev.getIndividualThreeRmPremiumMealTotal());                 
                 
                String output  = ("\n You have entered " + pax + " Pax destine for " + destination + " in " + monthName + " for " + day + " day."
                        + "\n\n Following are the overall cost and breakdown of the package:\n\n "
                                         + "Flight (" + destinationPrice + " x " + destinationRate + " x " + pax + " Pax)\t\t\t$" + flightTotal + "\n ");
                if(day > 0) {
                    if (oneRm >= 1) {
                    output = output + "Hotel (" + destinationPrice + " x " + oneRm + " Single x " + hotelRate + " x " + day + " day)\t\t$" + oneRmRate + "\n ";                        
                    }
                    if (twoRm >= 1) {
                    output = output + "Hotel (" + destinationPrice + " x " + twoRm  + " Double x " + hotelRate + " x " + day + " day)/2               \t$" + twoRmRate + "\n ";                        
                    }
                    if (threeRm >= 1) {
                    output = output + "Hotel (" + destinationPrice + " x " + threeRm + " Triple x " + hotelRate + " x " + day + " day)/2\t\t$" + threeRmRate + "\n ";                        
                    }                    
                    if(averageMeal >= 1) {
                        output = output + "Meal (40.00 x " + averageMeal + " Normal Meal x " + day + " day)   \t\t$" + averageMealCost + "\n ";                    
                    }
                    if(premiumMeal >= 1) {
                        output = output + "Meal (140.00 x " + premiumMeal + " Upgde Meal x " + day + " day)\t\t$" + premiumMealCost + "\n ";                 
                    }
                    if(smallTour >= 1) {
                        output = output + "Tour (120.00 x " + smallTour + " Samll Group Tour x " + tourDays + " day)\t$" + smallTourCost + "\n ";                 
                    }
                    if(bigTour >= 1) {
                        output = output + "Tour (200.00 x " + bigTour + " Big Group Tour x " + tourDays + " day)\t\t$" + bigTourCost + "\n ";                 
                    }                       
                }
                output = output + "----------------------------------------------------------------------------------------\n "
                        + "Total\t\t\t\t\t$" + totalCost + "\n\n--Individual Prices Breakdown--\n\n"
                        + "Flight\t|   Hotel\t\t|   Meal\t\t|   Tour\t|   Total\n"
                        + "------------------------------------------------------------------------------------------------------\n";                        
                if(oneRm >= 1) {
                    if(averageMeal >=1) {
                        output = output + individualFlight + "\t+  " + individualOneRmHotel + " (Single)\t+  " + individualAverageMeal 
                                + " (Normal)\t+  " + individualTour + "\t|   $" + individualOneRmAverageMealTotal + "\n";                       
                    }
                    if(premiumMeal >= 1) {
                        output = output + individualFlight + "\t+  " + individualOneRmHotel + " (Single)\t+  " + individualPremiumMeal 
                                + " (Upgde)\t+  " + individualTour + "\t|   $" + individualOneRmPremiumMealTotal+ "\n";                      
                    }                    
                }
                if(twoRm >= 1) {
                    if(averageMeal >=1) {
                        output = output + individualFlight + "\t+  " + individualTwoRmHotel + " (Double)\t+  " + individualAverageMeal 
                                + " (Normal)\t+  " + individualTour + "\t|   $" + individualTwoRmAverageMealTotal+ "\n";                       
                    }
                    if(premiumMeal >= 1) {
                        output = output + individualFlight + "\t+  " + individualTwoRmHotel + " (Double)\t+  " + individualPremiumMeal 
                                + " (Upgde)\t+  " + individualTour + "\t|   $" + individualTwoRmPremiumMealTotal+ "\n";                       
                    }  
                if(threeRm >= 1) {
                    if(averageMeal >=1) {
                        output = output + individualFlight + "\t+  " + individualThreeRmHotel + " (Triple)\t+  " + individualAverageMeal 
                                + " (Normal)\t+  " + individualTour + "\t|   $" + individualThreeRmAverageMealTotal+ "\n";                       
                    }
                    if(premiumMeal >= 1) {
                        output = output + individualFlight + "\t+  " + individualThreeRmHotel + " (Triple)\t+  " + individualPremiumMeal 
                                + " (Upgde)\t+  " + individualTour + "\t|   $" + individualThreeRmPremiumMealTotal+ "\n";                       
                    }                     
                }                
                }
            textPanel.setText(output);    
            }
        });
    }
}

