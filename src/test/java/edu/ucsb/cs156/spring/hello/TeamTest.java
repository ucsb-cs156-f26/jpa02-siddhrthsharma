package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test 
    public void equals_returns_true_for_same_object() {
        assertTrue(team.equals(team));
    }

    @Test
    public void equals_returns_false_for_different_class() {
        assertFalse(team.equals("test-team"));
    }


    @Test
    public void equals_returns_true_when_name_and_members_match() {
        Team a = new Team("Leo");
        a.addMember("Sid");
        Team b = new Team("Leo");
        b.addMember("Sid");
        assertTrue(a.equals(b));
    }

    @Test
    public void equals_returns_false_when_only_members_differ() {
        Team a = new Team("Roland");
        a.addMember("Sid");
        Team b = new Team("Roland");
        b.addMember("Grace");
        assertFalse(a.equals(b));
    }

    @Test
    public void equals_returns_false_when_only_name_differs() {
        Team a = new Team("Hassini");
        a.addMember("Sid");
        Team b = new Team("Chi");
        b.addMember("Sid");
        assertFalse(a.equals(b));
    }

    @Test
    public void equals_returns_false_when_name_and_members_differ() {
        Team a = new Team("Chi");
        a.addMember("Sid");
        Team b = new Team("Leo");
        b.addMember("Roland");
        assertFalse(a.equals(b));
    }

    @Test
    public void hashCode_is_same_for_equal_teams() {
        Team a = new Team("Leo");
        a.addMember("Sid");
        Team b = new Team("Leo");
        b.addMember("Sid");
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    public void hashCode_returns_expected_value() {
        Team t = new Team("Leo");        
        t.addMember("Sid");
        int result = t.hashCode();
        int expectedResult = 93695;             
        assertEquals(expectedResult, result);
    }
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
