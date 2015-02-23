package com.mikes.stablemarriage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Getting matching info");
        ArrayList<Person> women = new ArrayList();
        ArrayList<Person> men = new ArrayList();


        String mary[] = {"Joe", "Bob", "Mike"};
        women.add(new Person("Mary", new LinkedList<String>(Arrays.asList(mary))));

        String jane[] = {"Mike", "Bob", "Joe"};
        women.add(new Person("Jane", new LinkedList<String>(Arrays.asList(jane))));

        String amy[] = {"Mike", "Bob", "Joe"};
        women.add(new Person("Amy", new LinkedList<String>(Arrays.asList(amy))));

        String mike[] = {"Amy", "Mary", "Jane"};
        men.add(new Person("Mike", new LinkedList<String>(Arrays.asList(mike))));

        String bob[] = {"Mary", "Jane", "Amy"};
        men.add(new Person("Bob", new LinkedList<String>(Arrays.asList(bob))));

        String joe[] = {"Mary", "Amy", "Jane"};
        men.add(new Person("Joe", new LinkedList<String>(Arrays.asList(joe))));

        Matcher matcher = new Matcher(men, women);
        matcher.matchPeople();

        for(Person w: women){
            System.out.println(w.name + " is matched to " + w.getMatchedTo().name);
        }
    }
}
