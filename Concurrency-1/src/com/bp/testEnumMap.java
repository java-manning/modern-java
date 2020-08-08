package com.bp;

import java.util.EnumMap;

public class testEnumMap {

    public enum GFG
    {
        CODE, CONTRIBUTE, QUIZ, MCQ;
    }

    public static void main(String args[])
    {
        // Java EnumMap
        // Creating EnumMap in java with key
        // as enum type STATE
        EnumMap<GFG, String> gfgMap = new
                EnumMap<GFG, String>(GFG.class);

        // Java EnumMap Example 2:
        // Putting values inside EnumMap in Java
        // Inserting Enum keys different from
        // their natural order
        gfgMap.put(GFG.CODE, "Start Coding with gfg");
        gfgMap.put(GFG.CONTRIBUTE, "Contribute for others");
        gfgMap.put(GFG.QUIZ, "Practice Quizes");
        gfgMap.put(GFG.MCQ, "Test Speed with Mcqs");

        // Printing size of EnumMap in java
        System.out.println("Size of EnumMap in java: " +
                gfgMap.size());

        // Printing Java EnumMap
        // Print EnumMap in natural order
        // of enum keys (order on which they are declared)
        System.out.println("EnumMap: " + gfgMap);

        // Retrieving value from EnumMap in java
        System.out.println("Key : " + GFG.CODE +" Value: "
                + gfgMap.get(GFG.CODE));

        // Checking if EnumMap contains a particular key
        System.out.println("Does gfgMap has "+GFG.CONTRIBUTE+": "
                + gfgMap.containsKey(GFG.CONTRIBUTE));

        // Checking if EnumMap contains a particular value
        System.out.println("Does gfgMap has :" + GFG.QUIZ + " : "
                + gfgMap.containsValue("Practice Quizes"));
        System.out.println("Does gfgMap has :" + GFG.QUIZ + " : "
                + gfgMap.containsValue(null));
    }


}
