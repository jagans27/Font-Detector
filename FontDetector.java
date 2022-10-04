package fontdetector;

import java.io.File;
import java.io.IOException;
import java.util.*;
import org.apache.pdfbox.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;

/*
 * @author jagan0227
*/

public class FontDetector {

    public static void main(String[] args) {

        try {

            File file = new File("/home/jagan/123Check.pdf");
            Set<String> fonts = new LinkedHashSet<String>();
            
            PDDocument pdfDocument = Loader.loadPDF(file);


            PDFTextStripper pdfStripper = new PDFTextStripper() {
                @Override
                protected void processTextPosition(TextPosition text) {
                    String f = text.getFont().getName()+"";
                    fonts.add(f.substring(f.indexOf("+")+1));
                }
            };

            pdfStripper.getText(pdfDocument);
            
            System.out.println("-----The Fonts in the PDF-----");
            
            for(String f:fonts){
                System.out.println(f);
            }
            
        } catch (IOException e) {
            System.err.println(e);
        }

    }

}