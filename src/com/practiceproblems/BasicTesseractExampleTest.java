package com.practiceproblems;

import java.io.IOException;
import java.util.Date;

import org.bytedeco.javacpp.*;

import static org.bytedeco.javacpp.lept.*;
import static org.bytedeco.javacpp.tesseract.*;

public class BasicTesseractExampleTest {
    
	
	public static void main(String[] args) 
	{
		try
		{
			long startTime = new Date().getTime();
			System.out.println("start");
			//readPDF("E:\\ElectionCommission.pdf");
			//extractTextUse("E:\\ElectionCommission.pdf");
			givenTessBaseApi_whenImageOcrd_thenTextDisplayed("C:\\Users\\VIRAJ\\Desktop\\docs\\skill.png");
			//Loader.load(tesseract.class);
			System.out.println("end "+(new Date().getTime()-startTime));
		//E:\depends22_x64	
		}
		/*catch (UnsatisfiedLinkError e) {
		    try {
		    	//Process p = new ProcessBuilder("myCommand", "myArg").start();
				new ProcessBuilder("E:\\depends22_x64\\depends.exe", Loader.getTempDir() + "\\jnitesseract.dll").start().waitFor();
			} catch (Exception e1) {
			
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		}*/
		catch(Exception exp)
		{
			System.out.println(exp);
		}
	}
    //@Test
    public static void givenTessBaseApi_whenImageOcrd_thenTextDisplayed(String filePath) throws Exception {
        BytePointer outText;

        TessBaseAPI api = new TessBaseAPI();//getting the UnsatisfiedLinkError exception here.
        // Initialize tesseract-ocr with English, without specifying tessdata path
        if (api.Init(".", "ENG") != 0) {
            System.err.println("Could not initialize tesseract.");
            System.exit(1);
        }

        // Open input image with leptonica library
        PIX image = pixRead(filePath);
        api.SetImage(image);
        // Get OCR result
        outText = api.GetUTF8Text();
        String string = outText.getString();
        System.out.println("OCR output:\n" + string);

        // Destroy used object and release memory
        api.End();
        outText.deallocate();
        pixDestroy(image);
    }
}