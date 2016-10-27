package com.practiceproblems;

import java.io.File;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class FileDemo {
	public static void main(String a[])
	{
		File obj = new File("C:\\Users\\VIRAJ\\Desktop\\image\\file.txt");
		System.out.println(obj.getAbsolutePath());
		System.out.println(obj.getName());
		System.out.println(obj.getParent());
		System.out.println(obj.canWrite());
		System.out.println(obj.isDirectory());
	}

}
