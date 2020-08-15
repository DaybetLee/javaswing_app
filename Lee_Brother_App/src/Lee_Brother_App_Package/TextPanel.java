package Lee_Brother_App_Package;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class TextPanel extends JPanel{
    
    private JTextPane textArea;
    private SimpleAttributeSet attributeSet;
    
    public TextPanel(){
        
        Dimension dim = getPreferredSize(); 
        dim.height = 375;
        dim.width = 5;
        setPreferredSize(dim);
        
        textArea = new JTextPane();   
        textArea.setEditable(false);
        
        setLayout(new BorderLayout());
 
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        
        Border innerBorder = BorderFactory.createTitledBorder("");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder (BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        
        setIntroductionText();
    }
    public void setText(String text){
        textArea.setText(null);
        defaultColorText();
        textArea.setText(text);
        textArea.setSelectionStart(0);
        textArea.setSelectionEnd(0);
    }
    public void setWarningText(String text){
        textArea.setText(null);
        redColorText();
        textArea.setText(text);
        textArea.setSelectionStart(0);
        textArea.setSelectionEnd(0);
    }
    public void setIntroductionText() {
        textArea.setText(null);
        defaultColorText();
        textArea.setText(" This tools enables you to calculate the JAPAN booking provided by Lee Brother Travel Company.\n\n "
                          + "-- How To Use --\n "
                          + "Enter the values in the boxes above and hit 'Calculate' button to generate the booking price.\n "
                          + "Hit the 'Reset' button to reset the input value or to view the prices rate.\n\n "
                          + "-- Price Rate --\n "
                          + "Prices are calculated based on the following rate:\n\n "
                          + "Region\t|Base Price|\t|   Season\t|   Period\t\t|   Flight\t|   Hotel*\t|\n "
                          + "-----------------------------\t--------------------------------------------------------------------------\n "
                          + "Tokyo\t|   $400\t|\t|   Spring\t|   Mar - May\t|   BP x 1.3\t|   BP x 1.3\t|\n "
                          + "Osaka\t|   $450\t|\t|   Summer\t|   Jun - Aug\t|   BP x 1.5\t|   BP x 1.2\t|\n "
                          + "Fukuoka\t|   $500\t|\t|   Autumn\t|   Sep - Nov\t|   BP x 1.2\t|   BP x 1.4\t|\n "
                          + "Okinawa\t|   $550\t|\t|   Winter\t|   Dec - Feb\t|   BP x 1.4\t|   BP x 1.1\t|\n "
                          + "Hokkaido\t|   $600\t|\n\n "
                          + "Average (Default) Meal price: Lunch - $15/Pax, Dinner - $25/Pax\n "
                          + "Premium (Upgrade) Meal price: Lunch - $50/Pax, Dinner - $90/Pax\n\n " 
                          + "$120/day per tour group of 1 - 10 Pax**\n "
                          + "$200/day per tour group of 11 - 30 Pax**\n\n "
                          + "BP ~ Base Price\n "
                          + "*Hotel rate are based on Single room. For Double and Triple room, hotel cost will be halfed.\n "
                          + "*Per Pax are entitled to per room only.\n "
                          + "*Breakfast is included in the hotel booking.\n "
                          + "**Each tour guide only handle maximum of 30 Pax. If exceeded 30, 2 tour guide will be arranged.\n ");
        textArea.setSelectionStart(0);
        textArea.setSelectionEnd(0);
    }    
    private void redColorText() {
        attributeSet = new SimpleAttributeSet();
        StyleConstants.setBold(attributeSet, true);
        StyleConstants.setFontFamily(attributeSet, "Verdana");
        StyleConstants.setFontSize(attributeSet, 12);
        StyleConstants.setForeground(attributeSet, Color.red); 
        textArea.setCharacterAttributes(attributeSet, true);
    }
    private void defaultColorText() {
        attributeSet = new SimpleAttributeSet();
        StyleConstants.setBold(attributeSet, false);
        StyleConstants.setFontFamily(attributeSet, "Verdana");
        StyleConstants.setFontSize(attributeSet, 12);
        StyleConstants.setForeground(attributeSet, Color.BLACK);
        textArea.setCharacterAttributes(attributeSet, true);
    }
}
