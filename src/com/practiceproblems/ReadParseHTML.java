package com.practiceproblems;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ReadParseHTML {
	
	public static final String attrToSearch= "web-gen";
	
	public static void main(String srgs[])
	{
		File input = new File("E:/assets/Sample1.html");
		try {
			Document doc = Jsoup.parse(input, "UTF-8");
			
			Elements container = doc.getElementsByTag("html");
			for(Element html : container)
			{
				for(Element child : html.getElementsByAttribute(attrToSearch))
				{
					String attrName = child.attr(attrToSearch);					
					writeValueByTagType(child, "value");
					System.out.println(child.tagName()+" "+attrName);
				}
			}
			
			System.out.println(container.html());
			saveFile("Sample3.html",container.html());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void saveFile(String fileName,String contents)
	{
		try
		{
			File file = new File("E:/assets/"+fileName);
	
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
	
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(contents);
			bw.close();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void writeValueByTagType(Element child,String value)
	{
		
		switch (child.tagName()) {
        case "a":
        	child.attr("href",value);
            break;
        case "p":
        case "h3":
        case "title":
        case "span":
            child.text(value);
            break;
        case "img":
        	child.attr("src", value);
        	break;
        }
		
	}

}
