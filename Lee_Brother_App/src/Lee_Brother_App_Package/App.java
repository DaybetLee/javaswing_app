package Lee_Brother_App_Package;

import javax.swing.SwingUtilities;

public class App {
    
        public static void main(String[] args){
        
        SwingUtilities.invokeLater(new Runnable() { 
            public void run() { 
                new MainFrame(); 
            }
        });
    }
}
