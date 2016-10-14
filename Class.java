//Jehron Petty

import java.util.List;
import java.util.ArrayList;
import java.lang.Object;

public class Class {

   private String roomName;
   private int classSize;
   private String school;
   
   public Class(String a, int b, String c) {
      classSize = b;
      roomName = a;
      school = c;
   } 
   
   public int getSize() {
      return classSize;
   }
   
   public void setSize(int num) {
      classSize = num;
   }
   
   public String getRoom() {
      return roomName;
   }
   
   public String getSchool() {
      return school;
   }
   
   @Override
   public String toString() {
      String returnedString;
      String lol;
      lol = ": ";
      returnedString = (roomName + lol + classSize);
      return returnedString;
   }
}