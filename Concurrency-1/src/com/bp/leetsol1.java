package com.bp;

public class leetsol1 {

    public int theCount = 0;
    public boolean d = false;

    public int numberOfSteps (int num) {

        d = processor(num);
        return theCount;

    }

    public boolean processor(int myNumber) {

        System.out.println("Running with number " + myNumber);
        if (myNumber == 0) {return true;}

        if (myNumber %2 == 0 ) {

            theCount++;
            System.out.println("Increasing the count to" + theCount);
            processor(myNumber/2);
        } else {
            theCount++;
            System.out.println("Increasing the count to" + theCount);
            processor(myNumber-1);
        }

        return false;
    }

}
