
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    
    public int findStopCodon (String dna, int startIndex, String stopCodon) {
        int firstOccurrenceOfStopCodon = dna.indexOf(stopCodon);
        if ((firstOccurrenceOfStopCodon-startIndex)%3 == 0)    {        
            return firstOccurrenceOfStopCodon;
        }
        else
            {          
             return dna.length();
        }
    } 
    
    int howMany (String stringa, String stringb) {
        int number = 0;
        boolean ifStringbExists = true;
        int startIndex = 0;
        System.out.println();
        System.out.println("Запуск метода howMany для " + stringa + " и " + stringb);
        System.out.println("длина - " + stringb.length());
        while (ifStringbExists) {
            
            if (stringb.contains(stringa)) {
                startIndex = stringb.indexOf(stringa);
            }
            else {
                ifStringbExists = false;
                break;
            }    
            
            if (  (stringb.substring(startIndex, stringb.length())).contains(stringb)  ) {
                number++;
                startIndex = startIndex + stringa.length();
            }
            stringb=stringb.substring(startIndex, stringb.length());
        }
        
        return number;
    }
    
    
    void testHowMany () {
        System.out.println(howMany("GAA","ATGAACGAATTGAATC"));
        System.out.println(howMany("AA", "ATAAAA"));
    }

}
