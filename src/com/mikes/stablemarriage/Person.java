package com.mikes.stablemarriage;

import java.util.LinkedList;

/**
 * Created by Mike Schendel on 2/22/15.
 * This is used for a person and contains their match prefrences
 */
public class Person {

    public String name;
    private LinkedList<String> ranking;
    private Person matchedTo = null;
    private int stability;
    /**
     *
     * @param name the name of the Person
     * @param ranking Names of the people they prefer by name
     */
    public Person(String name, LinkedList<String> ranking){
        this.name = name;
        this.ranking = ranking;
        matchedTo = null;
        stability = ranking.size()+1;
    }

    public boolean matched(){
        return matchedTo != null;
    }

    private void match(Person match){
        this.matchedTo = match;
    }

    public void propose(Person proposed){
        //First look at proposed and see if this ranks higher
        if(proposed.rankedHigher(this)){
            //means proposed likes them more and we can match them
            if(proposed.matchedTo != null && proposed.matchedTo.matchedTo != null)
                proposed.matchedTo.matchedTo = null;
            proposed.match(this);
            match(proposed);
        }
    }

    public boolean rankedHigher(Person a){
        //Returns true if a is more desireable than its current match
        if(matchedTo != null) {
            if (ranking.indexOf(a.name) < ranking.indexOf(matchedTo.name)) {
                return true;
            }else{
                return false;
            }
        }
        return true;
    }

    /**
     * Get the highest match and pop and return it
     */
    public String highestMatch(){
        return ranking.pop();
    }

    public Person getMatchedTo() {
        return matchedTo;
    }
}
