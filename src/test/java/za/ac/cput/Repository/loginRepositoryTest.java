/**
 * Mziyanda Mwanda
 * 2133765
 * ADP 3
 *Assignment 1
 * Due date
 * 10 Aprile 2022
 * Repository
 * loginTest
 * **/
package za.ac.cput.Repository;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.login;
import za.ac.cput.Factory.loginFactory;

import static org.junit.jupiter.api.Assertions.*;

class loginRepositoryTest {

    private static  loginRepository loginRepo = loginRepository.getRepository();
    private static login log = loginFactory.createLogin("1", "Mzia","1234");

    @Test
    void create() {
        login create = loginRepo.create(log);
        assertEquals(log.getId(), create.getId());
        System.out.println("Create: " + create);


    }

    @Test
    void d_read() {
        login read = loginRepo.read(log.getId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void u_update() {
        login update = new login.Builder().copy(log).setUsername("Mizo")
                .setPassword("0000")
                .build();

        assertNull(loginRepo.update(update));
        System.out.println("Updated: " + update);
    }

    @Test
    void e_delete() {
        boolean deleted = loginRepo.delete(log.getId());
        assertTrue(deleted);
        System.out.println("Delete: " + deleted);
    }

    @Test
    void getAll() {
        System.out.println("Show everything: ");
        System.out.println(loginRepo.getAll() );
    }
}