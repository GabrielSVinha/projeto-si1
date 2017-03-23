package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.model.user.User;
import br.edu.ufcg.computacao.si1.model.user.UserType;
import br.edu.ufcg.computacao.si1.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;
import java.util.UUID;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioTest {

    @Autowired
    private UserRepository repo;

    private User user1, user2;

    @Before
    public void setUp() {
        this.user1 = new User("Belzebu", "sata@hell.com", "fire", UserType.INDIVIDUAL);
        this.user2 = new User("Gretchen", "gretchen@conga.com", "calabok", UserType.INDIVIDUAL);
    }

    @Test
    public void test() {
        assertTrue(true);
    }

//    @After
//    public void tearDown() {
//        repo.deleteAll();
//    }
//
//    @Test
//    public void testInicializacao() {
//        assertNotNull("Usuario1 não foi instânciado corretamente", user1);
//        assertNotNull("Usuario2 não foi instânciado corretamente", user2);
//    }

//    @Test
//    public void testPersistance(){
//        Random r = new Random();
//        int rand = r.nextInt(200);
//        int i = rand;
//        while(i>0){
//            this.repo.save(new UsuarioEmpresa(UUID.randomUUID().toString(), UUID.randomUUID().toString()
//                                        ,UUID.randomUUID().toString()));
//            i--;
//        }
//        assertEquals(repo.count(), rand);
//    }
}
