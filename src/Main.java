import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/*
 * 
 * calculate the average of fourth column if the second colume number is larger than 5 and less than 10
 * 
 * */

public class Main {

	// read from file
	// get each line
	// split by ; if line[1] >= 5 or line[1] <= 10
	// float result = 0.0;
	// then int sum = 0; sum =+ line[3]; result = sum/lines.getlength()
			
	public static void main(String[] args) {
		List<String> data = new ArrayList<String>();
		data.add("466317660;3;x448;1036667678444103731525325445567416655278232454210154743729034276553091817633");
		data.add("-753995940;6;p512;9594267114552722823770124931074142443130293941997428052606416217307317582");
		data.add("163748460;12;p256;1216055061059316207313483191520188210551203824580");
		data.add("1009604460;7;x25519;1734122214316351020231875377916696936162741704729921438027663235821795117258");
		
		BigInteger result = BigInteger.valueOf(0);
		int times = 0;
		BigInteger number1;
		BigInteger sum = BigInteger.valueOf(0);
		
		for(int i=0; i < data.size(); i++) {
			String line = data.get(i);
			System.out.println("line=" + line);
			String[] line2 = line.split(";");
			/*for (String value : line2) {
	        	System.out.println(value);
	    	}*/
			int secondValue = Integer.parseInt(line2[1]);
			if (secondValue >= 5 && secondValue <= 10) {
				System.out.println("second value=" + secondValue);
				System.out.println("fourth value=" + line2[3]);
				number1 = new BigInteger(line2[3]);
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
