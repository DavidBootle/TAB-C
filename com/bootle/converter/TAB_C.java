/*
 *  TAB_C (Text-ASCII-Binary Converter) Interface
 *  by David Bootle
 *  © 2018: David Bootle
 */

package com.bootle.converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.lang.StringBuilder;

public interface TAB_C {
  
  // Takes a character and converts it to it's ascii association
  public static int getAscii(char character) {
    int ascii = (int) character;
    return ascii;
  }
  
  // Converts an integer into binary (base 2)
  public static String getBinary(int integer) {
    String binary = Integer.toBinaryString(integer);
    return binary;
  }
  
  // Gives an integer a certain number of digits by adding zeros (takes a string)
  public static String setDigits(String string, int digits) {
    if (string.length() == digits) {
      return string;
    }
    if (string.length() < digits) {
      while (string.length() < digits) {
        string = "0" + string;
      }
      return string;
    }
    else {
      return "ERROR: Cannot reduce the number of digits.";
    }
  }
  
  // Gives an integer a certain number of digits by adding zeros (takes an integer)
  public static String setDigits(int number, int digits) {
    String string = Integer.toString(number);
    if (string.length() == digits) {
      return string;
    }
    if (string.length() < digits) {
      while (string.length() < digits) {
        string = "0" + string;
      }
      return string;
    }
    else {
      return "ERROR: Cannot reduce the number of digits.";
    }
  }
  
  // Splits a string into segments of a certain length
  public static String[] splitToLength(String string, int length) {
    int i = 0;
    ArrayList<String> strings = new ArrayList<String>();
    while (i < string.length()) {
      if (i + length > string.length()) {
        strings.add(string.substring(i, string.length()));
        i += length;
      }
      else {
        strings.add(string.substring(i, i + length));
        i += length;
      }
    }
    String[] stringsArray = strings.toArray(new String[strings.size()]);
    return stringsArray;
  }
  
  // gets an integer from a string of binary
  public static int getIntFromBinary(String binary) {
    return Integer.parseInt(binary, 2);
  }
  
  // gets a character from an ascii integer
  public static char getCharFromAscii(int ascii) {
    return (char) ascii;
  }
  
  // Gets a binary string from a character
  public static String getBinaryFromChar(char character) {
    int ascii = TAB_C.getAscii(character);
    String binary = TAB_C.getBinary(ascii);
    return binary;
  }
  
  // takes a string and returns it's binary ascii equivilent as a string
  public static String getBinaryFromString(String string, boolean spaces) {
    String space;
    if (spaces) {
      space = " ";
    } else {
      space = "";
    }
    String binaryString = "";
    ArrayList<String> binaryStrings = new ArrayList<String>();
    ArrayList<String> fixedStrings = new ArrayList<String>();
    for (int i = 0; i < string.length(); i++) {
      char character = string.charAt(i);
      binaryStrings.add(TAB_C.getBinaryFromChar(string.charAt(i)));
    }
    for (int i = 0; i < binaryStrings.size(); i++) {
      String currentString = binaryStrings.get(i);
      fixedStrings.add(TAB_C.setDigits(currentString,8));
    }
    for (int i = 0; i < fixedStrings.size(); i++) {
      String currentString = fixedStrings.get(i);
      binaryString += currentString + space;
    }
    return binaryString;
  }
   public static String getBinaryFromString(String string) {
    boolean spaces = true;
    String space;
    if (spaces) {
      space = " ";
    } else {
      space = "";
    }
    String binaryString = "";
    ArrayList<String> binaryStrings = new ArrayList<String>();
    ArrayList<String> fixedStrings = new ArrayList<String>();
    for (int i = 0; i < string.length(); i++) {
      char character = string.charAt(i);
      binaryStrings.add(TAB_C.getBinaryFromChar(character));
    }
    for (int i = 0; i < binaryStrings.size(); i++) {
      String currentString = binaryStrings.get(i);
      fixedStrings.add(TAB_C.setDigits(currentString,8));
    }
    for (int i = 0; i < fixedStrings.size(); i++) {
      String currentString = fixedStrings.get(i);
      binaryString += currentString + space;
    }
    return binaryString;
  }
  
  // gets a character from a binary string
  public static char getCharFromBinary(String binary) {
    int ascii = TAB_C.getIntFromBinary(binary);
    char character = TAB_C.getCharFromAscii(ascii);
    return character;
  }
  
  // takes a string of binary and returns it's text equivelent
  public static String getTextFromBinary(String binary) {
    String noSpaces = TAB_C.removeSpaces(binary);
    String[] binaryArray = TAB_C.splitToLength(noSpaces, 8);
    String string = "";
    for (int i = 0; i < binaryArray.length; i++) {
      string = string + TAB_C.getCharFromBinary(binaryArray[i].toString());
    }
    return string;
  }
  
  // removes the spaces from a string
  public static String removeSpaces(String string) {
    StringBuilder sb = new StringBuilder(string);
    while (sb.indexOf(" ") != -1) {
      sb.deleteCharAt(sb.indexOf(" "));
    }
    return sb.toString();
  }
}
