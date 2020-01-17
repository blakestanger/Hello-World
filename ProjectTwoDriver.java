import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class ProjectTwoDriver {

    public static void main(String[] args) throws FileNotFoundException {
        // Declare all variables here.
        int i = 0;

        String checkifclasschanges = new String();
        //Holds value of class from last itteration of while loop to check if class has changed.

        String checkif494 = new String();
        //Check for a class is one of the 494 lectures.

        BinarySearchTree Walrus = new BinarySearchTree();
        //data structure to hold the MSUClasses we read in and return in BFirst or DFirst order.

        String Title = new String();
        //holds class title. Eg "Programming with C"

        String classnumber = new String();

        //holds class number EG CSCI 132

        int numberofseats = 0;
        // holds number of class seats

        String when = new String();
        // holds the key value string when MWF TH etc.

        String isLABorLECTURE = new String();
        //test string to determine if class is a lab or lecture. used to discard irrelevant results.

        MSUClass VIKINGBLOOD = new MSUClass();
        // MSU class used to hold our data from each line. Data it holds is passed into BST.


        String[] holder = new String[100000];
        // holds the data from each line of the CSV file.

        File file = new File(args[0]);
        //file from args

        Scanner scanner = new Scanner(file);


        while (scanner.hasNext()) {

            //the main function of the driver is to read in the raw data from the CSV
            //and put that  data into the holders then into the MSU Class.

            String readin = scanner.nextLine();

            holder = readin.split(",");


            //debug
            // System.out.println("start");
            //  System.out.println(when);
            //  System.out.println("end");
            //System.out.println(holder[15]);

            classnumber = holder[1].split("-")[0];
          //  System.out.println(classnumber);

            //test to see if class has changed, resets seat number if true.
            if (i==0){checkifclasschanges = classnumber;}
            Title = holder[2];
            isLABorLECTURE = holder[14];


            //test to see if class has changed, resets seat number if true.

            if(classnumber.equals("CSCI 132")){
                //System.out.println("made csc132");
                VIKINGBLOOD.getNUMBEROFSECTIONS();
            }
            if (checkifclasschanges.equals(classnumber)==false){

                checkifclasschanges = classnumber;
                VIKINGBLOOD.resetNumberofSeats();
                VIKINGBLOOD.resetNUMBEROFSECTIONS();
            }



            //assigning data to variables to be sent into MSU Class.
            when = holder[15];
            when = when.concat(holder[16]);
            numberofseats = Integer.parseInt(holder[4]);

            //ugly workaround for inconsistencies in the data.
            if ((i >= 13 && i < 18) || (i >= 19 && i < 22) || (i >= 23 && i < 27)) {
                isLABorLECTURE = holder[13];
                when = holder[14];
                when = when.concat(holder[15]);
            }

            //debug System.out.println(isLABorLECTURE + " I: "+ i);


            // System.out.println("two:" +holder[2]);
            //   System.out.println("four:" +holder[4]);

            if (isLABorLECTURE.equals("Lab")|| isLABorLECTURE.equals("Recitation")) {
                i++;
                continue;
            }
            // discards data if from a LAB or a RECITATION section.


            if (isLABorLECTURE.equals("Lecture")) {
                //assigns data to MSUCLASS if data is from a lecture.

                VIKINGBLOOD.setCSCINumber(classnumber);
                VIKINGBLOOD.setNumberofSeats(numberofseats);
                VIKINGBLOOD.increaseNUMBEROFSECTIONS();
                VIKINGBLOOD.setTitle(Title);
                VIKINGBLOOD.setWHEN(when);


                i++;
                //debug System.out.println(VIKINGBLOOD.printClass());
                Walrus.put(VIKINGBLOOD.getWHEN(), VIKINGBLOOD.printClass());

            } else if (isLABorLECTURE.equals("Seminar")) {
                // test for the special seminar conditions and deals with them accordingly.

                if (Title.equals("Seminar: Industry Methods")) {

                    VIKINGBLOOD.setCSCINumber(classnumber);
                    VIKINGBLOOD.setNumberofSeats(numberofseats);
                    VIKINGBLOOD.increaseNUMBEROFSECTIONS();
                    VIKINGBLOOD.setTitle(Title);
                    VIKINGBLOOD.setWHEN(when);


                    i++;
                    // System.out.println("industry");
                    Walrus.put(VIKINGBLOOD.getWHEN(), VIKINGBLOOD.printClass());
                    VIKINGBLOOD.resetNumberofSeats();
                    VIKINGBLOOD.resetNUMBEROFSECTIONS();

                } else if (Title.equals("Sem:Impactful Careers in Tech")) {

                    VIKINGBLOOD.setCSCINumber(classnumber);
                    VIKINGBLOOD.setNumberofSeats(numberofseats);
                    VIKINGBLOOD.increaseNUMBEROFSECTIONS();
                    VIKINGBLOOD.setTitle(Title);
                    VIKINGBLOOD.setWHEN(when);


                    i++;
                    Walrus.put(VIKINGBLOOD.getWHEN(), VIKINGBLOOD.printClass());
                    VIKINGBLOOD.resetNumberofSeats();
                    VIKINGBLOOD.resetNUMBEROFSECTIONS();

                } else if (Title.equals("Sem: Computational Topology")) {
                    VIKINGBLOOD.setCSCINumber(classnumber);
                    VIKINGBLOOD.setNumberofSeats(numberofseats);
                    VIKINGBLOOD.increaseNUMBEROFSECTIONS();
                    VIKINGBLOOD.setTitle(Title);
                    VIKINGBLOOD.setWHEN(when);


                    i++;
                    Walrus.put(VIKINGBLOOD.getWHEN(), VIKINGBLOOD.printClass());
                    VIKINGBLOOD.resetNumberofSeats();
                    VIKINGBLOOD.resetNUMBEROFSECTIONS();

                } else if (Title.equals("Sem:Human Computer Interaction")) {

                    VIKINGBLOOD.setCSCINumber(classnumber);
                    VIKINGBLOOD.setNumberofSeats(numberofseats);
                    VIKINGBLOOD.increaseNUMBEROFSECTIONS();
                    VIKINGBLOOD.setTitle(Title);
                    VIKINGBLOOD.setWHEN(when);


                    i++;
                    Walrus.put(VIKINGBLOOD.getWHEN(), VIKINGBLOOD.printClass());
                    VIKINGBLOOD.resetNumberofSeats();
                    VIKINGBLOOD.resetNUMBEROFSECTIONS();



                }

            }


        }

        //calls the methods from BST to return data in selected methods.
        System.out.println("Behold Breadth First");
        Walrus.BFirst();
        System.out.println("And Now Depth First");
        Walrus.DFirst();
        System.out.println("Fin");

    }


}







//System.out.println(i + "When: " + when + " Title: " + Title + " Classnumber: " + classnumber +" Number of seats: " + numberofseats+ " LAB OR LECTURE?: " +isLABorLECTURE);
//
//            switch (classnumber) {
//                case "CSCI 107":
//
//                    if (isLABorLECTURE.equals("Lecture") || isLABorLECTURE.equals("Recitation")) {
//                        CSCI107.setWHEN(when);
//                    }
//                    CSCI107.setCSCINumber(classnumber);
//                    CSCI107.setNumberofSeats(numberofseats);
//                    CSCI107.increaseNUMBEROFSECTIONS();
//                    CSCI107.setTitle(Title);
//                    //CSCI107.printClass();
//
//                case "CSCI 112":
//
//                    if (isLABorLECTURE.equals("Lecture") || isLABorLECTURE.equals("Recitation")) {
//                        CSCI112.setWHEN(when);
//                    }
//                    CSCI112.setCSCINumber(classnumber);
//                    CSCI112.setNumberofSeats(numberofseats);
//                    CSCI112.increaseNUMBEROFSECTIONS();
//                    CSCI112.setTitle(Title);
//
//
//                case "CSCI 127":
//
//                    if (isLABorLECTURE.equals("Lecture") || isLABorLECTURE.equals("Recitation")) {
//                        CSCI127.setWHEN(when);
//                    }
//                    CSCI127.setCSCINumber(classnumber);
//                    CSCI127.setNumberofSeats(numberofseats);
//                    CSCI127.increaseNUMBEROFSECTIONS();
//                    CSCI127.setTitle(Title);
//
//                case "CSCI 132":
//
//                    if (isLABorLECTURE.equals("Lecture") || isLABorLECTURE.equals("Recitation")) {
//                        CSCI127.setWHEN(when);
//                    }
//                    CSCI132.setCSCINumber(classnumber);
//                    CSCI132.setNumberofSeats(numberofseats);
//                    CSCI132.increaseNUMBEROFSECTIONS();
//                    CSCI132.setTitle(Title);
//
//                case "CSCI 215CS":
//
//                    if (isLABorLECTURE.equals("Lecture") || isLABorLECTURE.equals("Recitation")) {
//                        CSCI215.setWHEN(when);
//                    }
//                    CSCI215.setCSCINumber(classnumber);
//                    CSCI215.setNumberofSeats(numberofseats);
//                    CSCI215.increaseNUMBEROFSECTIONS();
//                    CSCI215.setTitle(Title);
//
//                case "CSCI 232":
//
//                    if (isLABorLECTURE.equals("Lecture") || isLABorLECTURE.equals("Recitation")) {
//                        CSCI232.setWHEN(when);
//                    }
//                    CSCI232.setCSCINumber(classnumber);
//                    CSCI232.setNumberofSeats(numberofseats);
//                    CSCI232.increaseNUMBEROFSECTIONS();
//                    CSCI232.setTitle(Title);
//
//                case "CSCI 246":
//
//                    if (isLABorLECTURE.equals("Lecture") || isLABorLECTURE.equals("Recitation")) {
//                        CSCI246.setWHEN(when);
//                    }
//                    CSCI246.setCSCINumber(classnumber);
//                    CSCI246.setNumberofSeats(numberofseats);
//                    CSCI246.increaseNUMBEROFSECTIONS();
//                    CSCI246.setTitle(Title);
//
//                case "CSCI 291":
//
//                    if (isLABorLECTURE.equals("Lecture") || isLABorLECTURE.equals("Recitation")) {
//                        CSCI291.setWHEN(when);
//                    }
//                    CSCI291.setCSCINumber(classnumber);
//                    CSCI291.setNumberofSeats(numberofseats);
//                    CSCI291.increaseNUMBEROFSECTIONS();
//                    CSCI291.setTitle(Title);
//
//                case "CSCI 305":
//
//                    if (isLABorLECTURE.equals("Lecture") || isLABorLECTURE.equals("Recitation")) {
//                        CSCI305.setWHEN(when);
//                    }
//                    CSCI305.setCSCINumber(classnumber);
//                    CSCI305.setNumberofSeats(numberofseats);
//                    CSCI305.increaseNUMBEROFSECTIONS();
//                    CSCI305.setTitle(Title);
//
//                case "CSCI 338":
//
//                    if (isLABorLECTURE.equals("Lecture") || isLABorLECTURE.equals("Recitation")) {
//                        CSCI338.setWHEN(when);
//                    }
//                    CSCI338.setCSCINumber(classnumber);
//                    CSCI338.setNumberofSeats(numberofseats);
//                    CSCI338.increaseNUMBEROFSECTIONS();
//                    CSCI338.setTitle(Title);
//
//                case "CSCI 347":
//
//                    if (isLABorLECTURE.equals("Lecture") || isLABorLECTURE.equals("Recitation")) {
//                        CSCI347.setWHEN(when);
//                    }
//                    CSCI347.setCSCINumber(classnumber);
//                    CSCI347.setNumberofSeats(numberofseats);
//                    CSCI347.increaseNUMBEROFSECTIONS();
//                    CSCI347.setTitle(Title);
//
//
//                case "CSCI 351":
//
//                    if (isLABorLECTURE.equals("Lecture") || isLABorLECTURE.equals("Recitation")) {
//                        CSCI351.setWHEN(when);
//                    }
//                    CSCI351.setCSCINumber(classnumber);
//                    CSCI351.setNumberofSeats(numberofseats);
//                    CSCI351.increaseNUMBEROFSECTIONS();
//                    CSCI351.setTitle(Title);
//
//                case "CSCI 366":
//                    if (isLABorLECTURE.equals("Lecture") || isLABorLECTURE.equals("Recitation")) {
//                        CSCI366.setWHEN(when);
//                    }
//                    CSCI366.setCSCINumber(classnumber);
//                    CSCI366.setNumberofSeats(numberofseats);
//                    CSCI366.increaseNUMBEROFSECTIONS();
//                    CSCI366.setTitle(Title);
//
//                case "CSCI 441":
//
//                    if (isLABorLECTURE.equals("Lecture") || isLABorLECTURE.equals("Recitation")) {
//                        CSCI441.setWHEN(when);
//                    }
//                    CSCI441.setCSCINumber(classnumber);
//                    CSCI441.setNumberofSeats(numberofseats);
//                    CSCI441.increaseNUMBEROFSECTIONS();
//                    CSCI441.setTitle(Title);
//
//                case "CSCI 446":
//
//                    if (isLABorLECTURE.equals("Lecture") || isLABorLECTURE.equals("Recitation")) {
//                        CSCI446.setWHEN(when);
//                    }
//                    CSCI446.setCSCINumber(classnumber);
//                    CSCI446.setNumberofSeats(numberofseats);
//                    CSCI446.increaseNUMBEROFSECTIONS();
//                    CSCI446.setTitle(Title);
//
//                case "CSCI 455":
//
//                    if (isLABorLECTURE.equals("Lecture") || isLABorLECTURE.equals("Recitation")) {
//                        CSCI455.setWHEN(when);
//                    }
//                    CSCI455.setCSCINumber(classnumber);
//                    CSCI455.setNumberofSeats(numberofseats);
//                    CSCI455.increaseNUMBEROFSECTIONS();
//                    CSCI455.setTitle(Title);
//
//                case "CSCI 468":
//
//                    if (isLABorLECTURE.equals("Lecture") || isLABorLECTURE.equals("Recitation")) {
//                        CSCI468.setWHEN(when);
//                    }
//                    CSCI468.setCSCINumber(classnumber);
//                    CSCI468.setNumberofSeats(numberofseats);
//                    CSCI468.increaseNUMBEROFSECTIONS();
//                    CSCI468.setTitle(Title);
//
//                case "CSCI 476":
//
//                    if (isLABorLECTURE.equals("Lecture") || isLABorLECTURE.equals("Recitation")) {
//                        CSCI476.setWHEN(when);
//                    }
//                    CSCI476.setCSCINumber(classnumber);
//                    CSCI476.setNumberofSeats(numberofseats);
//                    CSCI476.increaseNUMBEROFSECTIONS();
//                    CSCI476.setTitle(Title);
//
//                case "CSCI 483R":
//
//                    if (isLABorLECTURE.equals("Lecture") || isLABorLECTURE.equals("Recitation")) {
//                        CSCI483.setWHEN(when);
//                    }
//                    CSCI483.setCSCINumber(classnumber);
//                    CSCI483.setNumberofSeats(numberofseats);
//                    CSCI483.increaseNUMBEROFSECTIONS();
//                    CSCI483.setTitle(Title);
//
//                case "CSCI 494":
//
//                    if (Title.equals("Industry Methods")) {
//
//                        if (isLABorLECTURE.equals("Lecture") || isLABorLECTURE.equals("Recitation") || isLABorLECTURE.equals("Seminar")) {
//                            CSCI494INDUSTRY.setWHEN(when);
//                        }
//                        CSCI494INDUSTRY.setCSCINumber(classnumber);
//                        CSCI494INDUSTRY.setNumberofSeats(numberofseats);
//                        CSCI494INDUSTRY.increaseNUMBEROFSECTIONS();
//
//
//                        if (Title.equals("Impactful Careers in Tech")) {
//
//                            if (isLABorLECTURE.equals("Lecture") || isLABorLECTURE.equals("Recitation") || isLABorLECTURE.equals("Seminar")) {
//                                CSCI494IMPACT.setWHEN(when);
//                            }
//                            CSCI494IMPACT.setCSCINumber(classnumber);
//                            CSCI494IMPACT.setNumberofSeats(numberofseats);
//                            CSCI494IMPACT.increaseNUMBEROFSECTIONS();
//                        }
//                        if (Title.equals("Computational Topology")) {
//
//                            if (isLABorLECTURE.equals("Lecture") || isLABorLECTURE.equals("Recitation") || isLABorLECTURE.equals("Seminar")) {
//                                CSCI494IMPACT.setWHEN(when);
//                            }
//                            CSCI494TOPOLOGY.setCSCINumber(classnumber);
//                            CSCI494TOPOLOGY.setNumberofSeats(numberofseats);
//                            CSCI494TOPOLOGY.increaseNUMBEROFSECTIONS();
//                        }
//
//                        if (Title.equals("Human Computer Interaction")) {
//
//                            if (isLABorLECTURE.equals("Lecture") || isLABorLECTURE.equals("Recitation") || isLABorLECTURE.equals("Seminar")) {
//                                CSCI494INTERACTION.setWHEN(when);
//                            }
//                            CSCI494INTERACTION.setCSCINumber(classnumber);
//                            CSCI494INTERACTION.setNumberofSeats(numberofseats);
//                            CSCI494INTERACTION.increaseNUMBEROFSECTIONS();
//                        }
//        Walrus.put(CSCI107.getWHEN(), CSCI107);
//        Walrus.put(CSCI112.getWHEN(), CSCI112);
//        Walrus.put(CSCI127.getWHEN(), CSCI127);
//        Walrus.put(CSCI132.getWHEN(), CSCI132);
//        list.add(CSCI107);
//        list.add(CSCI112);
//        list.add(CSCI127);
//        list.add(CSCI132);
//        list.add(CSCI132);
//        list.add(CSCI215);
//        list.add(CSCI232);
//        list.add(CSCI246);
//        list.add(CSCI291);
//        list.add(CSCI305);
//        list.add(CSCI338);
//        list.add(CSCI347);
//        list.add(CSCI351);
//        list.add(CSCI366);
//        list.add(CSCI441);
//        list.add(CSCI446);
//        list.add(CSCI455);
//        list.add(CSCI468);
//        list.add(CSCI476);
//        list.add(CSCI483);
//        list.add(CSCI494IMPACT);
//        list.add(CSCI494INDUSTRY);
//        list.add(CSCI494INTERACTION);
//        list.add(CSCI494TOPOLOGY);

        //CSCI107.printClass();

//        for (int j = 0; j <list.size() ; j++) {
//
//            Walrus.put(list.get(j), list.get(j).printClass());
//
//        }




