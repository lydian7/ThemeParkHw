import attractions.Dodgems;
import attractions.Playground;
import attractions.RollerCoaster;
import behaviours.IReviewed;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.ParkingSpot;
import stalls.TobaccoStall;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

    Visitor visitor1;
    Visitor visitor2;
    Visitor visitor3;
    Dodgems dodgems;
    Playground playGround;
    RollerCoaster rollerCoaster;
    TobaccoStall tobaccoStall;
    ArrayList<IReviewed> allAttAndStands;
    ThemePark themePark;
    
    @Before
    public void before(){
        visitor1 = new Visitor(14, 145, 50.00);
        visitor2 = new Visitor(12, 145, 50.00);
        visitor3 = new Visitor(18, 180, 50.00);
        dodgems = new Dodgems("Crash Em Up", 4);
        playGround = new Playground("Jungle Play", 3);
        rollerCoaster = new RollerCoaster("Roller Bawler", 4);
        tobaccoStall = new TobaccoStall("It's actually healthy", "Marlboro", ParkingSpot.A1);
        ArrayList<IReviewed> allAttAndStands = new ArrayList<>();
        allAttAndStands.add(dodgems);
        allAttAndStands.add(playGround);
        allAttAndStands.add(rollerCoaster);
        allAttAndStands.add(tobaccoStall);
        themePark = new ThemePark(allAttAndStands);
    }

    @Test
    public void canGetAllReviewed() {
        assertEquals(4, themePark.getAllReviewed().size());
    }

    @Test
    public void canAddVisit() {
        themePark.visit(visitor1, dodgems);
        assertEquals(1, visitor1.getVisitedAttractions().size());
        assertEquals(1, dodgems.getVisitCount());
    }

    @Test
    public void canGetListOfAllowed() {
        assertEquals(2, themePark.getAllAllowedFor(visitor2).size());
    }

    @Test
    public void canGetListOfAllowed2() {
        assertEquals(2, themePark.getAllAllowedFor(visitor3).size());
    }
}
