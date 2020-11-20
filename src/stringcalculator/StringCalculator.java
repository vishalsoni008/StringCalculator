/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringcalculator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vishal soni
 */
public class StringCalculator {

    /**
     * @param args the command line arguments
     */
    
    //
    public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else{
			String delimiter = ",";
			if(text.matches("//(.*)\n(.*)")){//
				delimiter = Character.toString(text.charAt(2));
				text = text.substring(4);
			}
			
			String numList[] = splitNumbers(text, delimiter + "|\n");
			return sum(numList);
		}
	}
    
    private static int sum(String[] numbers){
 	    int total = 0;
 	    String negString = "";

        for(String number : numbers){
        	if(toInt(number) < 0){
        		if(negString.equals(""))
        			negString = number;
        		else
        			negString += ("," + number);
        	}
        	if(toInt(number) < 1000)
		    	total += toInt(number);
		}

		if(!negString.equals("")){
			throw new IllegalArgumentException("Negatives not allowed: " + negString);
		}

		return total;
    }
    
    	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers, String divider){
	    return numbers.split(divider);
	}
    
    
   

    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private char getCustomDelimiter(String line) {  //different delimiters
        if (line == null || line.isEmpty()) {
            return ',';
        }
        if (isNumeric(line)) {
            return ',';
        }
        if (line.length() == 1) {
            return line.charAt(0);
        }
        return ',';
    }
    public static void main(String[] args) {
        // TODO code application logic here
        StringCalculator sc=new StringCalculator();
       // sc.add("");
      // sc.calculate("");
        
    }
    
}
