
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    
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
    
    
    
    void testFindStopCodon () {
                //    0123456789012345678901234567
                //    V  V        V  V        V
        String dna = "ATGTTTCCCAAATAAATGAAATGTAAGG";
        int startIndex = dna.indexOf("ATG");
        String stopCodon = "TAA";
        findStopCodon (dna, startIndex, stopCodon);
        
         //    012345678901234567890123456789012
         //       V         V   V  V        V
        dna = "GGGATGTTTCCCCTAAATAAATGAAATTATAAGG";
        findStopCodon (dna, startIndex, stopCodon);
    } 
    
    
    String findGene (String dna) {
        System.out.println();
        System.out.println("Запуск метода findGene для " + dna);
        System.out.println("длина - " + dna.length());
        String geneFound = "";
        int startIndex = 0;
        if (dna.contains("ATG")) {
            startIndex = dna.indexOf("ATG");
        }
        else {
            System.out.println("Не содержит ATG");
            return "";
        }    
        
        if ( findStopCodon(dna, startIndex, "TAA") != dna.length()  
             && startIndex<findStopCodon(dna, startIndex, "TAG")
             && (findStopCodon(dna, startIndex, "TAA")-startIndex)%3 == 0)   {
            geneFound = dna.substring(startIndex, findStopCodon(dna, startIndex, "TAA")+3);    
            System.out.println("Найден ген по stopCodon TAA: " + geneFound);
        }    
        String geneFound1 = geneFound;
        System.out.println("geneFound1=" + geneFound1);
        
        if ( findStopCodon(dna, startIndex, "TAG") != dna.length() 
             && startIndex<findStopCodon(dna, startIndex, "TAG")
             && (findStopCodon(dna, startIndex, "TAG")-startIndex)%3 == 0)   {
                 geneFound = dna.substring(startIndex,findStopCodon(dna, startIndex,"TAG")+3); 
                 System.out.println("Найден ген по stopCodon TAG:"+ geneFound);
        }
        String geneFound2 = geneFound;
        System.out.println("geneFound2=" + geneFound2);
        
        if (geneFound1.length()>geneFound2.length()) {
            geneFound = geneFound2;
        }
        else
            geneFound = geneFound1;            
        System.out.println(("Shortest genefound=" + geneFound));
        return geneFound;
    } 
    
    
    void testFindGene () {
        findGene("ATGTTTTAAAAATAGATGAAATGTAGG");
        findGene("ATGTTTAAAAATAGATGAAATGTAGG");
        findGene("TTTAAAAATAGAATAGG");
        findGene("TTTAAAAATAGATGAATAGG");
    }
    
    
    void printAllGenes  (String dna) {
        boolean ifATGExists = true;
        int startIndex = 0;
        System.out.println();
        System.out.println("Запуск метода printAllGenes для " + dna);
        System.out.println("длина - " + dna.length());
        while (ifATGExists) {
            
            String geneFound = "";
            
            if (dna.contains("ATG")) {
                startIndex = dna.indexOf("ATG");
            }
            else {
                // System.out.println("Не содержит ATG"); 
                ifATGExists = false;
                break;
            }    
            
            if ( findStopCodon(dna, startIndex, "TAA") != dna.length()  
                 && startIndex<findStopCodon(dna, startIndex, "TAA")
                 && (findStopCodon(dna, startIndex, "TAA")-startIndex)%3 == 0)   {
                geneFound = dna.substring(startIndex, findStopCodon(dna, startIndex, "TAA")+3); 
                System.out.println("geneFound (TAA)=" + geneFound);                
            }        
                        
            if ( findStopCodon(dna, startIndex, "TAG") != dna.length() 
                 && startIndex<findStopCodon(dna, startIndex, "TAG")
                 && (findStopCodon(dna, startIndex, "TAG")-startIndex)%3 == 0)   {
                     geneFound = dna.substring(startIndex,findStopCodon(dna, startIndex,"TAG")+3); 
                     System.out.println("geneFound (TAG)=" + geneFound);                      
            }
            
            dna=dna.substring(startIndex+3, dna.length());         
        
        
        }
    
    }
    
     void testPrintAllGenes () {
        printAllGenes("ATGTTTTAAAAATAGATGAAATGTAGG");
        printAllGenes("ATGTTTAAAAATAGATGAAATGTAGG");
        printAllGenes("TTTAAAAATAGAATAGG");
        printAllGenes("TTTAAAAATAGATGAATAGG");
    }
    
    
    
    
    
    int countGenes (String dna) {
        int number = 0;
        boolean ifATGExists = true;
        int startIndex = 0;
        System.out.println();
        System.out.println("Запуск метода countGenes для " + dna);
        System.out.println("длина - " + dna.length());
        while (ifATGExists) {
            
            String geneFound = "";
            
            if (dna.contains("ATG")) {
                startIndex = dna.indexOf("ATG");
            }
            else {
                // System.out.println("Не содержит ATG"); 
                ifATGExists = false;
                break;
            }    
            
            if ( findStopCodon(dna, startIndex, "TAA") != dna.length()  
                 && startIndex<findStopCodon(dna, startIndex, "TAA")
                 && (findStopCodon(dna, startIndex, "TAA")-startIndex)%3 == 0)   {
                geneFound = dna.substring(startIndex, findStopCodon(dna, startIndex, "TAA")+3); 
                System.out.println("geneFound (TAA)=" + geneFound);
                number++;
            }        
                        
            if ( findStopCodon(dna, startIndex, "TAG") != dna.length() 
                 && startIndex<findStopCodon(dna, startIndex, "TAG")
                 && (findStopCodon(dna, startIndex, "TAG")-startIndex)%3 == 0)   {
                     geneFound = dna.substring(startIndex,findStopCodon(dna, startIndex,"TAG")+3); 
                     System.out.println("geneFound (TAG)=" + geneFound); 
                     number++;
            }
            
            dna=dna.substring(startIndex+3, dna.length()); 
        
        }
        
        return number;
    }
    
    void testCountGenes () {
        System.out.println(countGenes("ATGTAAGATGCCCTAGT"));
        System.out.println(countGenes("ATGTAAGATGCCCTAGTTTAAGTAGTAAAAATAA"));
        System.out.println(countGenes("AATATGTAAGATGCCCTAGTTTAAGTAGTAAATAGAATAA"));
        System.out.println(countGenes("ATGTTTAAAAATAGATGAAATGTAGG"));
        System.out.println(countGenes("TTTAAAAATAGAATAGG"));
        System.out.println(countGenes("TTTAAAAATAGATGAATAGG"));
    
    
    }

}
