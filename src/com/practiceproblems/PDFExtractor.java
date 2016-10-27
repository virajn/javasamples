/**
 * 
 */
package com.practiceproblems;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.common.PDMetadata;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.encoding.WinAnsiEncoding;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.tools.ExtractText;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;
import org.apache.commons.lang3.StringEscapeUtils;

//import org.bytedeco.javacpp.*;


//import static org.bytedeco.javacpp.lept.*;
//import static org.bytedeco.javacpp.tesseract.*;
/**
 * @author VIRAJ
 *
 */
public class PDFExtractor {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		try
		{
			long startTime = new Date().getTime();
			System.out.println("start");
			//readPDF("E:\\ElectionCommission.pdf");
			//extractTextUse("E:\\ElectionCommission.pdf");
			pdftoImage("C:\\Users\\VIRAJ\\Desktop\\docs\\skill.pdf");
			System.out.println("end "+(new Date().getTime()-startTime));
			
		}
		catch(Exception exp)
		{
			System.out.println(exp);
		}
	}
	private static void extractTextUse(String pdfFile) throws IOException
	{
		ExtractText.main(new String[]{pdfFile, "E:\\try-1.txt"}); 
	}
	
	private static String readPDF(String filePath) throws Exception
	{
		String hindia = "बहुप्रतिक्षीत";
		System.out.println(hindia);	
		File pathToFile =new File(filePath);
		System.out.println("File size = ");
		PDDocument document = PDDocument.load(pathToFile);
		System.out.println("File loaded");
		PDFTextStripper s = new PDFTextStripper();
		//s.setStartPage(10);
		//s.setEndPage(11);
		String text = s.getText(document);//prints garbage values
		String hindiStr = StringEscapeUtils.unescapeJava( text );
		BufferedWriter writer = null;
		try
		{
		    writer = new BufferedWriter( new FileWriter( "E:\\try-1.txt"));
		    writer.write( "बहुप्रतिक्षीत");

		}
		catch ( IOException e)
		{
		}
		finally
		{
		    try
		    {
		        if ( writer != null)
		        writer.close( );
		    }
		    catch ( IOException e)
		    {
		    }
		}
		//System.out.println(document.getNumberOfPages());//right o/p
		PDPageTree pages = document.getPages();
		System.out.println(pages.get(0).getResources().getFontNames());
		return "";
	}
	
	public static void pdftoImage(String pdfFilename) throws Exception
	{
		PDDocument document = PDDocument.load(new File(pdfFilename));
		PDFRenderer pdfRenderer = new PDFRenderer(document);
		for (int page = 0; page < document.getNumberOfPages(); ++page)
		{ 
		    BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 300, ImageType.RGB);

		    // suffix in filename will be used as the file format
		    ImageIOUtil.writeImage(bim, pdfFilename + "-" + (page+1) + ".png", 300);
		}
		document.close();
	}
	
	/*public void givenTessBaseApi_whenImageOcrd_thenTextDisplayed() throws Exception {
        BytePointer outText;

        TessBaseAPI api = new TessBaseAPI();
        // Initialize tesseract-ocr with English, without specifying tessdata path
        if (api.Init(".", "ENG") != 0) {
            System.err.println("Could not initialize tesseract.");
            System.exit(1);
        }

        // Open input image with leptonica library
        PIX image = pixRead("test.png");
        api.SetImage(image);
        // Get OCR result
        outText = api.GetUTF8Text();
        String string = outText.getString();
        //assertTrue(!string.isEmpty());
        System.out.println("OCR output:\n" + string);

        // Destroy used object and release memory
        api.End();
        outText.deallocate();
        pixDestroy(image);
    }*/

}
