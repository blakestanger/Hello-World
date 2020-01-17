public class MSUClass{

    //variables
    private String toret;
    private int NUMBERofSEATS=0;
    private String title;
    private int NUMBEROFSECTIONS = 0;
    private String WHEN;
    private String CSCInumber;

        //constructor with ablity to take in all class data
    public MSUClass(int numseats, String titlein, int numsection, String when, String CSCInumberin){
        this.NUMBERofSEATS = numseats;
        this.NUMBEROFSECTIONS = numsection;
        this.title = titlein;
        this.WHEN = when;
        this.CSCInumber = CSCInumberin;

    }

    public MSUClass(){}
    //constructor that takes no data


    public void setNumberofSeats(int a){
        this.NUMBERofSEATS = (NUMBERofSEATS + a);

    }

    public void resetNumberofSeats(){
        this.NUMBERofSEATS = 0;
    }

    public int getNUMBERofSEATS(){
        return NUMBERofSEATS;
    }

    public void increaseNUMBEROFSECTIONS(){
        NUMBEROFSECTIONS++;
    }

    public void resetNUMBEROFSECTIONS(){NUMBEROFSECTIONS =0; }

    public int getNUMBEROFSECTIONS(){
        return NUMBEROFSECTIONS;
    }

    public void setCSCINumber(String CSCInumber){
        this.CSCInumber = CSCInumber;
    }

    public String getCSCINumber(){
        return CSCInumber;
    }

    public void setWHEN(String WHENin){
        this.WHEN = WHENin;
    }

    public String getWHEN(){ return WHEN;}

    public void setTitle(String titlein){
        title = titlein;
    }

    public String getTitle(){
        return title;
    }

    public String printClass(){
        String toretII = new String();


        toret = ("CSCI NUMBER: " + CSCInumber + " Title: " + title +" Sect: " +NUMBEROFSECTIONS+ " Seats: " + NUMBERofSEATS +  " When: " + WHEN);

         return toret;

    }


}
