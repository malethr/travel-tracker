package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * Created by Guest on 8/9/17.
 */
public class TravelTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void NewTravelObjectsGetsCorrectlyCreated_true() throws Exception {
        Travel travel = new Travel("Location 1: Portland");
        assertTrue(travel instanceof Travel);
    }

    @Test
    public void TravelInstantiatesWithLocation_true() throws Exception {
        Travel travel = new Travel("Location 1: Portland");
        assertEquals("Location 1: Portland", travel.getLocation());
    }

    @After
    public void tearDown() {
        Travel.clearAllPosts(); // Clear out all the  posts before each test.
    }

    @Test
    public void AllTravelsAreCorrectlyReturned_true() {
        Travel travel = new Travel("Location 1: Portland");
        Travel travel2 = new Travel ("Location 2: Vancouver");
        assertEquals(2, Travel.getAll().size());
    }

    @Test
    public void AllTravelsContainsAllTravel_true()  {
        Travel travel = new Travel("Location 1: Portland");
        Travel travel2 = new Travel ("Location 2: Vancouver");
        assertTrue(Travel.getAll().contains(travel));
        assertTrue(Travel.getAll().contains(travel2));
    }

    @Test
    public void getPublished_isFalseAfterInstantiation_false() throws Exception {
        Travel travel = new Travel("Location 1: Portland");
        assertEquals(false, travel.getPublished()); //should never start as published
    }

    @Test
    public void getCreatedAt_instantiatesWithCurrentTime_Today() throws Exception {
        Travel travel = setUpNewTravel();
        assertEquals(LocalDateTime.now().getDayOfWeek(),travel.getCreatedAt().getDayOfWeek());
    }

    public Travel setUpNewTravel(){
        return new Travel("Location 1: Portland");
    }

    @Test
    public void getId_postsInstantiatesWithAnID_1() throws Exception {
        Travel.clearAllPosts();
        Travel travel = new Travel("Location 1: Portland");
        assertEquals(1, travel.getId());
    }

    @Test
    public void findReturnsCorrectTravel() throws Exception {
        Travel travel = setUpNewTravel();
        assertEquals(1, Travel.findById(travel.getId()).getId());
    }

    @Test
    public void findReturnsCorrectPostWhenMoreThanOneTravelExists() throws Exception {
        Travel travel = setUpNewTravel();
        Travel travel2 = new Travel("How to pair successfully");
        assertEquals(2, Travel.findById(travel2.getId()).getId());
    }
}

//    @Test
//    public void updateChangesTravelLocation() throws Exception {
//        Travel travel = setupNewTravel();
//        String formerLocation = travel.getLocation();
//        LocalDateTime formerDate = travel.getCreatedAt();
//        int formerId = travel.getId();
//
//        travel.update("Location 3: Los Angeles");
//
//        assertEquals(formerId, travel.getId);
//        assertEquals(formerDate, travel.getCreatedAt());
//        assertNotEquals(formerLocation, travel.getLocation());
//