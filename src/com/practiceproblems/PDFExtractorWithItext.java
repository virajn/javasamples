package com.practiceproblems;

import java.io.IOException;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;



public class PDFExtractorWithItext {
	public static void main(String[] args) 
	{
		try
		{
			extractText("E:\\small_PMC_FIN_Ward_017.pdf");
		}
		catch(Exception exp)
		{
			System.out.println(exp);
		}
	}
	
	private static String extractText( String filePath ) throws IOException {
		PdfReader reader = new PdfReader(filePath);
		StringBuilder output = new StringBuilder();
		try {
			int numPages = reader.getNumberOfPages();
			System.out.println(numPages);
			int page = 1;
			while( page <= numPages ) {
				output.append( PdfTextExtractor.getTextFromPage( reader, page ) );
				page++;
			}
		} catch( Exception e ) {
			System.err.println( "PDFParser.extractText(): " + e );
		}
		return output.toString();
	}
	 
}
