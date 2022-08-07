/**
 * Mziyanda Mwanda
 * 2133765
 * ADP 3
 *Assignment 1
 * Due date
 * 10 Aprile 2022
 * Factory
 * StaffTest
 * **/
package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.staff;

import static org.junit.jupiter.api.Assertions.*;

class  staffFactoryTest {

    @Test
    void Validate() {

        staff staf = new staff.Builder()
                .setAdminName("Ogar")
                .setDeliveryDriver("Happiness")
                .setAssistant("Xola")
                .build();

        assertEquals("Ogar", staf.getAdminName());
        assertEquals("Happiness", staf.getDeliveryDriver());
        assertEquals("Xola", staf.getAssistant());
    }

    @Test
    void fail() {

        staff staf = new staff.Builder()
                .setAdminName("Ogar")
                .setDeliveryDriver("Happiness")
                .setAssistant("Xola")
                .build();

        assertEquals("Ogar", staf.getAdminName());
        assertEquals("", staf.getDeliveryDriver());
        assertNotEquals("Xola", staf.getAssistant());
    }
}