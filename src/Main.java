//package main.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/*
 * 
 * Read from csv file. Calculate the average of fourth column if the second colume number is larger than 5 and less than 10
 * 
 * */

public class Main {

	// read from file
	// get each line
	// split by ; if line[1] >= 5 or line[1] <= 10
	// float result = 0.0;
	// then int sum = 0; sum =+ line[3]; result = sum/lines.getlength()
			
	private File getFileFromResources(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        System.out.println("classLoader=" + classLoader);
        URL resource = classLoader.getResource(fileName);
        System.out.println("resource=" + resource);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }
    }
	
	public static void main(String[] args) {
		
		String row = null;
		List<String> dataList = new ArrayList<String>();
		Main main = new Main();
		BufferedReader csvReader = null;
		
		try {
			// read data from csv
			//File file = main.getFileFromResources("data.csv");
			InputStream in = main.getClass().getClassLoader().getResourceAsStream("data.csv"); 
			//FileReader fileReader = new FileReader(file); // absolute path
			// csvReader = new BufferedReader(fileReader);
			csvReader = new BufferedReader(new InputStreamReader(in));
			try {
				while ((row = csvReader.readLine()) != null) {
					dataList.add(row);
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		} catch (Exception fnfe) {
			fnfe.printStackTrace();
		} finally {
	        try {
	        	if (csvReader != null) {
	        		csvReader.close();
	        	}
	        } catch (IOException ioe) {
	        	ioe.printStackTrace();
	        }
	    }
		
		for (String value : dataList) {
			System.out.println(value);
		}
		
		//List<String> data = new ArrayList<String>();
		//data.add("466317660;3;x448;1036667678444103731525325445567416655278232454210154743729034276553091817633");
		//data.add("-753995940;6;p512;9594267114552722823770124931074142443130293941997428052606416217307317582");
		//data.add("163748460;12;p256;1216055061059316207313483191520188210551203824580");
		//data.add("1009604460;7;x25519;1734122214316351020231875377916696936162741704729921438027663235821795117258");
		
		int times = 0;
		BigInteger number1 = BigInteger.valueOf(0);
		BigInteger sum = BigInteger.valueOf(0);
		BigInteger result = BigInteger.valueOf(0);
		
		for(int i=0; i < dataList.size(); i++) {
			String line = dataList.get(i);
			System.out.println("line=" + line);
			String[] line2 = line.split(";");
			
			int secondValue = Integer.parseInt(line2[1]);
			if (secondValue >= 5 && secondValue <= 10) {
				System.out.println("second value=" + secondValue);
				System.out.println("fourth value=" + line2[3].substring(0, line2[3].length()-1));
				number1 = new BigInteger(line2[3].substring(0, line2[3].length()-1));
				System.out.println("num1=" + number1);
				sum = sum.add(number1);
				System.out.println("sum=" + sum);
				times++;
				System.out.println("times=" + times);
			}else {
				System.out.println("no suitable value");
			}	
		}
		result = sum.divide(BigInteger.valueOf(times));
		System.out.println("result=" + result);
	}

}
