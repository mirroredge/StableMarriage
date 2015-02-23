package com.mikes.stablemarriage;

import java.util.ArrayList;

/**
 * Created by Mike Schendel on 2/22/15.
 */
public class Matcher {


    ArrayList<Person> persons1;
    ArrayList<Person> persons2;

    public Matcher(ArrayList<Person> persons1,ArrayList<Person> persons2){
        this.persons1 = persons1;
        this.persons2 = persons2;
    }

    public void matchPeople(){

        boolean allMatched = false;
        while(!allMatched) {
            for (Person p1 : persons1) {
                if(p1.matched() == false) {
                    String favoritePerson = p1.highestMatch();
                    for (Person p2 : persons2) {
                        if (p2.name == favoritePerson) {
                            //we match them both ways
                            p1.propose(p2);
                        }
                    }
                }

            }
            allMatched = true;
            for(Person p1: persons1){
                if(!p1.matched())
                    allMatched = false;
            }
        }
    }
}
