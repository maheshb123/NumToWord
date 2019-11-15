
public class NumberToWordConvert {

    private static final String[] specialNumToWordNames = {
        "",
        " thousand",
        " million",
        " billion",
        " trillion",
        " quadrillion",
        " quintillion"
    };
    
    private static final String[] numToWordTensNames = {
        "",
        " ten",
        " twenty",
        " thirty",
        " forty",
        " fifty",
        " sixty",
        " seventy",
        " eighty",
        " ninety"
    };
    
    private static final String[] numToWordNumNames = {
        "",
        " one",
        " two",
        " three",
        " four",
        " five",
        " six",
        " seven",
        " eight",
        " nine",
        " ten",
        " eleven",
        " twelve",
        " thirteen",
        " fourteen",
        " fifteen",
        " sixteen",
        " seventeen",
        " eighteen",
        " nineteen"
    };
    
    private String convertNumLessThanOneThousand(int number) {
        String current;
        
        if (number % 100 < 20){
            current = numToWordNumNames[number % 100];
            number /= 100;
        }
        else {
            current = numToWordNumNames[number % 10];
            number /= 10;
            
            current = numToWordTensNames[number % 10] + current;
            number /= 10;
        }
        if (number == 0) return current;
        return numToWordNumNames[number] + " hundred and" + current;
    }
    
    public String convertNumToWord(int number) {

        if (number == 0) { return "zero"; }
        
        String prefix = "";
        
        if (number < 0) {
            number = -number;
            prefix = "negative";
        }
        
        String current = "";
        int place = 0;
        
        do {
            int n = number % 1000;
            if (n != 0){
                String s = convertNumLessThanOneThousand(n);
                current = s + specialNumToWordNames[place] + current;
            }
            place++;
            number /= 1000;
        } while (number > 0);
        
        return (prefix + current).trim();
    }
    
public static void main( String[] args) {
	NumberToWordConvert num =new NumberToWordConvert();
	System.out.println("*** " + num.convertNumToWord(1));
	
	//Negative test
   // System.out.println("*** " + num.convertNumToWord(-23));
}
}
