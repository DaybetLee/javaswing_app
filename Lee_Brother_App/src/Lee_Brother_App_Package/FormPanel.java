package Lee_Brother_App_Package;

import com.sun.glass.events.KeyEvent;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.text.PlainDocument;

public class FormPanel extends JPanel implements ActionListener {
    
    private JLabel paxLabel;
    private JLabel dayLabel;    
    private JLabel destinationLabel;
    private JLabel seasonLabel;
    private JLabel hotelLabel;
    private JLabel oneRmLabel;
    private JLabel twoRmLabel;
    private JLabel threeRmLabel;
    private JLabel mealLabel;
    private JLabel tourLabel;
    private JTextField paxField;
    private JTextField dayField;
    private JComboBox destinationCombo;
    private JComboBox seasonCombo;
    private JTextField oneRmField;
    private JTextField twoRmField;
    private JTextField threeRmField;
    private JTextField mealField;
    private JTextField tourField;
    private JButton totalBtn;
    private JButton resetBtn;
    
    private FormListener formListener;
    private WarningErrorListener warningErrorListener;
    private ResetFormListener resetFormListener;

    public FormPanel() {
        
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);
        
        paxLabel = new JLabel("Number of Pax :");
        dayLabel = new JLabel("Days of Travel :");
        destinationLabel = new JLabel("Destination Bound :");
        seasonLabel = new JLabel("Season of Travel :");
        hotelLabel = new JLabel("Hotel Rooms :");
        oneRmLabel = new JLabel("Single");
        twoRmLabel = new JLabel("Double");
        threeRmLabel = new JLabel("Triple");
        mealLabel = new JLabel("Meal Upgrade :");
        tourLabel = new JLabel("Days of Tour :");
        paxField = new JTextField("0",10);
        dayField = new JTextField("0",10);
        oneRmField = new JTextField("0",3);
        twoRmField = new JTextField("0",3);
        threeRmField = new JTextField("0",3);
        mealField = new JTextField("0",10);
        tourField = new JTextField("0",10);
        destinationCombo = new JComboBox();
        seasonCombo = new JComboBox();
        totalBtn = new JButton("Calculate");
        resetBtn = new JButton("Reset");
        
        Border innerBorder = BorderFactory.createTitledBorder("");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder (BorderFactory.createCompoundBorder(outerBorder, innerBorder));        
        
        paxLabel.setFont(new Font("Verdana", Font.BOLD, 12));
        dayLabel.setFont(new Font("Verdana", Font.BOLD, 12));
        destinationLabel.setFont(new Font("Verdana", Font.BOLD, 12));
        seasonLabel.setFont(new Font("Verdana", Font.BOLD, 12));
        hotelLabel.setFont(new Font("Verdana", Font.BOLD, 12));
        oneRmLabel.setFont(new Font("Verdana", Font.BOLD, 12));
        twoRmLabel.setFont(new Font("Verdana", Font.BOLD, 12));
        threeRmLabel.setFont(new Font("Verdana", Font.BOLD, 12));
        mealLabel.setFont(new Font("Verdana", Font.BOLD, 12));
        tourLabel.setFont(new Font("Verdana", Font.BOLD, 12));
        paxField.setFont(new Font("Verdana", Font.PLAIN, 12));
        dayField.setFont(new Font("Verdana", Font.PLAIN, 12));
        oneRmField.setFont(new Font("Verdana", Font.PLAIN, 12));
        twoRmField.setFont(new Font("Verdana", Font.PLAIN, 12));
        threeRmField.setFont(new Font("Verdana", Font.PLAIN, 12));
        mealField.setFont(new Font("Verdana", Font.PLAIN, 12));
        tourField.setFont(new Font("Verdana", Font.PLAIN, 12));
        destinationCombo.setFont(new Font("Verdana", Font.BOLD, 12));
        seasonCombo.setFont(new Font("Verdana", Font.BOLD, 12));
        totalBtn.setFont(new Font("Verdana", Font.BOLD, 12));
        resetBtn.setFont(new Font("Verdana", Font.BOLD, 12));
        
        paxField.setHorizontalAlignment(JTextField.CENTER);
        tabSelectable(paxField);
        intFilter(paxField);
        
        dayField.setHorizontalAlignment(JTextField.CENTER);
        tabSelectable(dayField);
        intFilter(dayField);
        
        oneRmField.setHorizontalAlignment(JTextField.CENTER);
        tabSelectable(oneRmField);
        intFilter(oneRmField);
        
        twoRmField.setHorizontalAlignment(JTextField.CENTER);
        tabSelectable(twoRmField);
        intFilter(twoRmField);     

        threeRmField.setHorizontalAlignment(JTextField.CENTER);
        tabSelectable(threeRmField);
        intFilter(threeRmField);
        
        mealField.setHorizontalAlignment(JTextField.CENTER);
        tabSelectable(mealField);
        intFilter(mealField);
        
        tourField.setHorizontalAlignment(JTextField.CENTER);
        tabSelectable(tourField);
        intFilter(tourField);
        
        DefaultComboBoxModel destModel = new DefaultComboBoxModel();
        destModel.addElement(new DestinationPrice("Tokyo",400));
        destModel.addElement(new DestinationPrice("Osaka",450));
        destModel.addElement(new DestinationPrice("Fukuoka",500));
        destModel.addElement(new DestinationPrice("Okinawa",550));
        destModel.addElement(new DestinationPrice("Hokkaido",600));
        destinationCombo.setModel(destModel);
        
        DefaultComboBoxModel seaModel = new DefaultComboBoxModel();
        seaModel.addElement(new SeasonMonth("Spring",1));
        seaModel.addElement(new SeasonMonth("Summer",2));
        seaModel.addElement(new SeasonMonth("Autumn",3));
        seaModel.addElement(new SeasonMonth("Winter",4));
        seasonCombo.setModel(seaModel);
        
        totalBtn.setPreferredSize(new Dimension(100, 25));
        totalBtn.addActionListener(this);       
        
        resetBtn.setPreferredSize(new Dimension(100, 25));
        resetBtn.addActionListener(this);
        resetBtn.setMnemonic(KeyEvent.VK_R);
        
        layoutComponents();
    }
    private void layoutComponents() {
        setLayout (new GridBagLayout());
        
        GridBagConstraints gc = new GridBagConstraints();
        Insets WithSpace = new Insets(0, 0, 0, 10);
        Insets MinSpace = new Insets(0, 0, 0, 5);
        
        //Row 1
        
        gc.weightx = 0;
        gc.weighty = 0.2;
        
        gc.gridy = 0;
        
        gc.gridx = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = WithSpace;
        add(paxLabel, gc);
        
        gc.gridwidth = 3;
        gc.gridx = 1;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.LINE_END;
        add(paxField, gc);
        
        gc.gridwidth = 3;
        gc.gridx = 4;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        add(dayLabel, gc);
        
        gc.gridwidth = 3;
        gc.gridx = 7;
        gc.anchor = GridBagConstraints.LINE_END;
        add(dayField, gc);
        
       //Row 2

        gc.gridy++;       
       
        gc.gridwidth = 1;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        add(destinationLabel, gc);
        
        gc.gridwidth = 3;
        gc.gridx = 1;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.LINE_END;
        add(destinationCombo, gc);
        
        gc.gridwidth = 3;
        gc.gridx = 4;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        add(seasonLabel, gc);
        
        gc.gridwidth = 1;
        gc.gridx = 7;
        gc.fill = GridBagConstraints.HORIZONTAL;        
        gc.anchor = GridBagConstraints.LINE_END;
        add(seasonCombo, gc);
        
        //Row 3 
        
        gc.gridy++;        
        
        gc.gridwidth = 1;
        gc.gridx = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        add(hotelLabel, gc);
        
        gc.gridx = 1;
        gc.insets = MinSpace;
        gc.anchor = GridBagConstraints.LINE_END;
        add(oneRmField, gc);
        
        gc.gridx = 2;
        gc.insets = MinSpace;
        gc.anchor = GridBagConstraints.LINE_START;
        add(oneRmLabel, gc);
        
        gc.gridx = 3;
        gc.insets = MinSpace;
        gc.anchor = GridBagConstraints.LINE_START;
        add(twoRmField, gc);
        
        gc.gridx = 4;
        gc.insets = MinSpace;
        gc.anchor = GridBagConstraints.LINE_START;
        add(twoRmLabel, gc);
        
        gc.gridx = 5;
        gc.insets = MinSpace;
        gc.anchor = GridBagConstraints.LINE_START;
        add(threeRmField, gc);
        
        gc.gridx = 6;
        gc.insets = MinSpace;
        gc.anchor = GridBagConstraints.LINE_START;
        add(threeRmLabel, gc);
        
       //Row 4

        gc.gridy++;
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = WithSpace;
        add(mealLabel, gc);
        
        gc.gridwidth = 3;
        gc.gridx = 1;
        gc.fill = GridBagConstraints.HORIZONTAL;        
        gc.anchor = GridBagConstraints.LINE_END;
        add(mealField, gc);
              
        gc.gridwidth = 3;
        gc.gridx = 4;
        gc.fill = GridBagConstraints.NONE;  
        gc.anchor = GridBagConstraints.LINE_END;
        add(tourLabel, gc);
        
        gc.gridwidth = 1;
        gc.gridx = 7;
        gc.anchor = GridBagConstraints.LINE_END;
        add(tourField, gc);
        
        //Row 7
        
        gc.gridy++;
                
        gc.gridwidth = 3;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.CENTER;
        add(resetBtn, gc);      
        
        gc.gridwidth = 3;
        gc.gridx = 4;
        gc.anchor = GridBagConstraints.CENTER;
        add(totalBtn, gc);
    }
    public JButton getTotalBtn() {
        return totalBtn;
    }
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton)e.getSource();
        if(clicked == totalBtn) {
            try{
                int pax = Integer.parseInt(paxField.getText());
                int day = Integer.parseInt(dayField.getText());                
                DestinationPrice destination = (DestinationPrice)destinationCombo.getSelectedItem();
                SeasonMonth season = (SeasonMonth)seasonCombo.getSelectedItem();
                int oneRm = Integer.parseInt(oneRmField.getText());
                int twoRm = Integer.parseInt(twoRmField.getText());
                int threeRm = Integer.parseInt(threeRmField.getText());
                int meal = Integer.parseInt(mealField.getText());
                int tour = Integer.parseInt(tourField.getText());


                if (pax > 0 ) {
                    if (day > 0) {
                        if (pax == (oneRm+(twoRm*2)+(threeRm*3))) {
                            if (meal <= pax) {
                                if (tour <= day) {
                                    FormEvent ev = new FormEvent(this, pax, day, destination, season, oneRm, twoRm, threeRm, meal, tour);                        
                                     
                                    if(formListener != null)
                                        formListener.formEventOccurred(ev);   
                                }
                                else
                                    if(warningErrorListener != null) {
                                    warningErrorListener.textEmitted("\n Sorry! Something went wrong X.X\n\n"
                                            + " It seems that the entered Tour days exceed the days of Travel. \n\n Please reenter the number of Tour days and try again.");
                                    }
                            }
                            else
                                if(warningErrorListener != null) {
                                warningErrorListener.textEmitted("\n Sorry! Something went wrong X.X\n\n"
                                        + " It seems that you have entered more meal upgrade than the Pax number. \n\n Please reenter the accurate number of meal upgrade.");
                            }
                        }
                        else
                            if(warningErrorListener != null) {
                            warningErrorListener.textEmitted("\n Sorry! Something went wrong X.X\n\n It seems you have either entered too little rooms or too many rooms."
                                    + "\n\n The total number of Pax entered to the total number of rooms booked are as follows: \n\n " + pax + " Pax / " + (oneRm+(twoRm*2)+(threeRm*3) + " Rooms" + 
                                                    "\n\n Please enter the right amount of room."));
                        }
                    }
                    else
                    if(warningErrorListener != null) {
                        warningErrorListener.textEmitted("\n Sorry! Something went wrong X.X\n\n"
                                + " It seems that you have entered 0 for Days of Travel. \n\n Please enter 1 or more Pax and try again.");
                    }                                    
                }
            else
                if(warningErrorListener != null) {
                    warningErrorListener.textEmitted("\n Sorry! Something went wrong X.X\n\n"
                            + " It seems that you have entered 0 Pax. \n\n Please enter 1 or more Pax and try again.");
                }                
            }    
            catch (Exception ex) {
                if(warningErrorListener != null) {
                    warningErrorListener.textEmitted("\n Sorry! Something went wrong X.X \n\n Please ensure the inputs are not left empty.\n\n Enter '0' if it is not valid.");
                }
            }
        }
        if(clicked == resetBtn) {
            resetJTextField();
            resetFormListener.resetForm();
        }
    }    
    public void setFormListener (FormListener listener){
        this.formListener = listener;
   }
    public void setWarningError(WarningErrorListener listener) {
        this.warningErrorListener = listener;
    }
    public void setResetFormListener(ResetFormListener listener) {
        this.resetFormListener = listener;
    }
    private void resetJTextField() {
        paxField.setText("0");
        dayField.setText("0");
        oneRmField.setText("0");
        twoRmField.setText("0");
        threeRmField.setText("0");
        destinationCombo.setSelectedIndex(0);
        seasonCombo.setSelectedIndex(0);
        mealField.setText("0");
        tourField.setText("0");
    }
    public void intFilter(JTextField textField) {
        PlainDocument doc = (PlainDocument) textField.getDocument();
        doc.setDocumentFilter(new IntFilter());
    }
    public void tabSelectable(JTextField textField) {
        textField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    textField.selectAll();
                }
            });
            }
        }); 
    }
}
class DestinationPrice {
    private String dest;
    private float price;
    
   public DestinationPrice(String dest, int price) {
       this.dest = dest;
       this.price = price;
   }
   public String toString() {
       return dest;
   }
   public float getPrice() {
       return price;
   }
}
class SeasonMonth {
    private String season;
    private int seasonOption;
    
   public SeasonMonth(String season, int seasonOption) {
       this.season = season;
       this.seasonOption = seasonOption;
   }
   public String toString() {
       return season;
   }
   public int getSeasonOption() {
       return seasonOption;
   }
}