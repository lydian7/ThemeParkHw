import attractions.Attraction;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;
import stalls.Stall;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {

    private ArrayList<IReviewed> allAttractionsAndStalls;

    public ThemePark(ArrayList<IReviewed> allAttractionsAndStalls) {
        this.allAttractionsAndStalls = allAttractionsAndStalls;
    }

    public HashMap<String, Integer> getAllReviewed() {
        HashMap<String, Integer> reviews = new HashMap<>();
        for(IReviewed reviewed : allAttractionsAndStalls){
            reviews.put(reviewed.getName(), reviewed.getRating());
        }
        return reviews;
    }

    public void visit(Visitor visitor, Attraction attraction){
        attraction.setVisitCount(1);
        visitor.addAttraction(attraction);
    }

    public ArrayList<IReviewed> getAllAllowedFor(Visitor visitor){
        ArrayList<IReviewed> allAllowed = new ArrayList<>();
        for(IReviewed attOrStall : allAttractionsAndStalls){
            if(attOrStall instanceof ISecurity && ((ISecurity) attOrStall).isAllowedTo(visitor)){
                allAllowed.add(attOrStall);
            } else {
                allAllowed.add(attOrStall); // needs to be added for rest of atts and stalls that have no user restrictions
            }
        }
        return allAllowed;
    }

}
