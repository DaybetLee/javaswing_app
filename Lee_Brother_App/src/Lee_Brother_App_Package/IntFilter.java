
package Lee_Brother_App_Package;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;


public class IntFilter extends DocumentFilter {
    private int textFieldLimit = 3;
    
   private boolean inputText(String text) {
      try {
         Integer.parseInt(text);
         return true;
      } catch (NumberFormatException e) {
         return false;
      }
   }
   public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text,
         AttributeSet attrs) throws BadLocationException {

      Document doc = fb.getDocument();
      StringBuilder sb = new StringBuilder();
      sb.append(doc.getText(0, doc.getLength()));
      sb.replace(offset, offset + length, text);

      if (inputText(sb.toString())) {
         if ((sb.length() < textFieldLimit + 1)) {
              super.replace(fb, offset, length, text, attrs);
          }
      }
   }
}  
