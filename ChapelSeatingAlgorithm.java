/*
   This program was developed by Jehron Petty
   during the month of March, 2016.

   This program is capable of taking a list of classrooms and
   their sizes, and sort them into as many sections as needed,
   in the most efficient way.

   This program was created to efficiently create a seating
   chart for LuHi's chapels. Please read the comments to avoid
   any confusion.

   If there are any questions, comments, or concerns please
   contact Jehron at jehronp@gmail.com or Mrs. Dragos in
   schoool at christine.dragos@luhi.org

*/

//Imports all methods of the List class
import java.util.List;

//Imports all methods of the ArrayList class
import java.util.ArrayList;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Files;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;

public class ChapelSeatingAlgorithm {
   public static void main(String[] args) {
      //Declares lists to hold our class objects
      List<Class> highSchool;
      highSchool = new ArrayList<Class>();
      
      List<Class> highSchool2;
      highSchool2 = new ArrayList<Class>();
      
      List<Class> sectionOne;
      sectionOne = new ArrayList<Class>();
      
      List<Class> sectionTwo;
      sectionTwo = new ArrayList<Class>();
      
      List<Class> sectionTwoChairs;
      sectionTwoChairs = new ArrayList<Class>();
      
      List<Class> sectionThree;
      sectionThree = new ArrayList<Class>();
      int[] tres = {15, 13, 14, 13, 11, 10, 9};
      
      List<Class> sectionFour;
      sectionFour = new ArrayList<Class>();
      
      List<Class> sectionFive;
      sectionFive = new ArrayList<Class>();
      
      List<Class> sectionFiveChairs;
      sectionFiveChairs = new ArrayList<Class>();
      
      List<Class> sectionSix;
      sectionSix = new ArrayList<Class>();
   
      List<Class> midSchool;
      midSchool = new ArrayList<Class>();
      List<Class> midSchool2;
      midSchool2 = new ArrayList<Class>();
      
      int[][] chapel = new int[][]{
                              {5, 5, 7, 7, 8, 6, 7, 0, 0, 0},
                              {13, 13, 13, 13, 13, 13, 12, 0, 0, 0},
                              {15, 13, 14, 13, 11, 10, 9, 0, 0, 0},
                              {15, 15, 14, 12, 10, 10, 9, 0, 0, 0},
                              {11, 11, 14, 14, 13, 12, 12, 11, 10, 0},
                              {7, 7, 7, 7, 6, 6, 6, 0, 0, 0}};
      
      List<List<Class>> listOfC = new ArrayList<>();
      listOfC.add(sectionOne);
      listOfC.add(sectionTwo);
      listOfC.add(sectionThree);
      listOfC.add(sectionFour);
      listOfC.add(sectionFive);
      listOfC.add(sectionSix);
   
      try {
         boolean a = true;
         Scanner fileScanner = new Scanner(new File("Set3Classes.txt"));
         String c = new String();
         String e = new String();
         int d = 0;
      
         while (a == true) {
            if (fileScanner.hasNext() == false) {
               a = false;
               break;
            }
            else {
               if (fileScanner.hasNext()) {
                  c = fileScanner.next();
               }
               if (fileScanner.hasNextInt()){
                  d = fileScanner.nextInt();
               }
               if (fileScanner.hasNext()) {
                  e = fileScanner.next();
               }
               highSchool.add(new Class(c,d,e));
            }
         }
      }
      catch(IOException ioe) {
         System.out.println("Error: Could not read file.");
         System.out.println("Make sure your .txt file is in the same folder as this program.");
      }
   
      //Removes empty classes from the ArrayList
      boolean bool = true;
      while (bool) {
         int count = 0;
         for (int b = 0; b < highSchool.size(); b++) {
            if (highSchool.get(b).getSize() == 0) {
               count++;
               highSchool.remove(b);
            }
            else if (highSchool.get(b).getSchool().equals("Middle")) {
               midSchool.add(highSchool.get(b));
               highSchool.remove(b);
            }
         }
         if (count == 0) {
            bool = false;
         }
      }
   
      //Get the smallest class size
      int min = 100;
      for (int a = 0; a < highSchool.size(); a++) {
         if (highSchool.get(a).getSize() < min) {
            min = highSchool.get(a).getSize();
         }
      }
      
      highSchool2.addAll(highSchool);
      System.out.println(highSchool2);
   
      while (highSchool.size() != 0 ) {
      
         //Declares reference variables of the size
         //of each section
         int sizeOne = 45;
         int one = 0;
         int sizeTwoChairs = 23;
         int twoChairs = 0;
         int sizeTwo = 90;
         int two = 0;
         int sizeThree = 85;
         int three = 0;
         int sizeFour = 85;
         int four = 0;
         int sizeFiveChairs = 13;
         int fiveChairs = 0;
         int sizeFive = 105;
         int five = 0;
         int sizeSix = 45;
         int six = 0;
      
         //Place classes efficiently in each section
         twoChairs = sortChairs(highSchool, twoChairs, sizeTwoChairs, sectionTwoChairs);
         fiveChairs = sortChairs(highSchool, fiveChairs, sizeFiveChairs, sectionFiveChairs);
         one = sort(highSchool, one, sizeOne, min, sectionOne);
         two = sort(highSchool, two, sizeTwo, min, sectionTwo);
         three = sort(highSchool, three, sizeThree, min, sectionThree);
         four = sort(highSchool, four, sizeFour, min, sectionFour);
         five = sort(highSchool, five, sizeFive, min, sectionFive);
         six = sort(highSchool, six, sizeSix, min, sectionSix);
      
         if (highSchool.size() != 0) {
            highSchool.clear();
            highSchool.addAll(highSchool2);
            //Debugger
            System.out.println(highSchool);
            
            selectionShuffle(highSchool);
            
            //Debugger
            System.out.println(highSchool);
            highSchool2.clear();
            highSchool2.addAll(highSchool);
            sectionOne.clear();
            sectionTwo.clear();
            sectionTwoChairs.clear();
            sectionThree.clear();
            sectionFour.clear();
            sectionFive.clear();
            sectionFiveChairs.clear();
            sectionSix.clear();
            
            //Debugger
            System.out.println(highSchool);
         }
         else {
         
            descendingOrder(sectionTwoChairs);
            descendingOrder(sectionFiveChairs);
            descendingOrder(sectionOne);
            descendingOrder(sectionTwo);
            descendingOrder(sectionThree);
            descendingOrder(sectionFour);
            descendingOrder(sectionFive);
            descendingOrder(sectionSix);
            
            listRows(chapel, listOfC);
            JOptionPane.showMessageDialog(null,"Section 2 Rear Chairs: " + sectionTwoChairs.get(0).getRoom() +
                                                "\nSection 5 Rear Chairs: " + sectionFiveChairs.get(0).getRoom(), "Rear Chair Sections", JOptionPane.PLAIN_MESSAGE);
         }
      }
   }

   public static int sortChairs(List<Class> aList, int sum, int limit, List<Class> section) {
      for(int a = 0; a < aList.size(); a++) {
         for(int b = a; b < aList.size(); b++) {
            //When we locate a class in the ArrayList,
            //we add it to a running sum that will indicate
            //to the program if that class will fit in this
            //section.
            sum += aList.get(b).getSize();
            Class used = aList.get(b);
            //We want to find a class with a size give or take one beyond the amount of chairs
            //If the class we locate is not that size, we want to
            //remove it from our sum.
            //Else, we print out the room name and size, then
            //remove that class object from the ArrayList
            if(sum < (limit - 1) || sum > (limit + 1)) {
               sum -= aList.get(b).getSize();
            }
            else {
               section.add(used);
               aList.remove(used);
            }
         }
      }
      return sum;
   }

   public static int sort(List<Class> aList, int sum, int limit, int min, List<Class> section) {
      for(int a = 0; a < aList.size(); a++) {
         for(int b = a; b < aList.size(); b++) {
            //When we locate a class in the ArrayList,
            //we add it to a running sum that will indicate
            //to the program if that class will fit in this
            //section.
            sum += aList.get(b).getSize();
            Class used = aList.get(b);
            //If the sum of adding the new located class is
            //within the interval of the the section size
            //and the sectioin size minues the smallest class size,
            //we do not use that class, removing its size
            //from our sum
            if(limit - min < sum && sum < limit || sum > limit) {
               sum -= aList.get(b).getSize();
            }
            else {
               section.add(used);
               aList.remove(used);
               if (aList.size() == 1) {
                  b--;
               }
            }
         }
      }
      return sum;
   }

   public static void selectionShuffle(List<Class> aList) {
      for (int k = aList.size() - 1; k > 0; k--) {
         int pos = (int) (Math.random() * (k + 1));
         Class temp = aList.get(k);
         aList.set(k, aList.get(pos));
         aList.set(pos, temp);
      }
   }

   public static void descendingOrder(List<Class> section) {
      List<Class> temp;
      temp = new ArrayList<Class>();
      for (int a = 0; a < section.size(); a++) {
         int c = 0;
         int max = Integer.MIN_VALUE;
         for (int b = a; b < section.size(); b++) {
            if (section.get(b).getSize() > max) {
               max = section.get(b).getSize();
               c = b;
            }
         }
         section.add(a, section.get(c));
         section.remove(c+1);
      }
   }
   
   public static void listRows(int[][] Array, List<List<Class>> listOfC) {
      
      int count = 0;
      int sum = 0;
      
      String[][] chapel = new String[12][10];
      
      for (int a = 0; a < chapel.length/2; a++) {
         outerloop2:
         for (int b = 0; b < chapel[a].length; b++) {
            outerloop:
            for (int c = 0; c < listOfC.get(a).size(); c++) {
               sum = listOfC.get(a).get(c).getSize();
               if (sum > Array[a][b]) {
                  chapel[a+a][b] = listOfC.get(a).get(c).getRoom();
                  chapel[a+a+1][b] = listOfC.get(a).get(c).getRoom();
                  listOfC.get(a).get(c).setSize(sum - Array[a][b]);
                  break outerloop;
               } 
               else if (sum == Array[a][b]) {
                  chapel[a+a][b] = listOfC.get(a).get(c).getRoom();
                  chapel[a+a+1][b] = listOfC.get(a).get(c).getRoom();
                  listOfC.get(a).remove(c);
                  break outerloop;
               } 
               else if (sum < Array[a][b]) {
                  chapel[a+a][b] = listOfC.get(a).get(c).getRoom();
                  listOfC.get(a).remove(c);
                  Array[a][b] = Array[a][b] - sum;
                  if (listOfC.get(a).size() > 0) {
                     sum = listOfC.get(a).get(c).getSize();
                     if (sum >= Array[a][b]) {
                        chapel[a+a+1][b] = listOfC.get(a).get(c).getRoom();
                        if (sum > Array[a][b]) {
                           listOfC.get(a).get(c).setSize(sum - Array[a][b]);
                           break outerloop;
                        } 
                        else if (sum == Array[a][b]) {
                           listOfC.get(a).remove(c);
                           break outerloop;
                        }
                           
                     } 
                     else if (sum < Array[a][b]){
                        chapel[a+a+1][b] = listOfC.get(a).get(c).getRoom();
                        listOfC.get(a).remove(c);
                        //break outerloop;
                     }
                  } 
                  else {
                     break outerloop;
                  }
               }
            }
         }
      }
      
      EventQueue.invokeLater(
                  new Runnable() {
                  
                     @Override
                     public void run() {
                        LuHiChapel seating = new LuHiChapel(chapel);
                     }
                  });
   }
}
