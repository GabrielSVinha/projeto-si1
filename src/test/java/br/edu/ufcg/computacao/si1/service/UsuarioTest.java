package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import br.edu.ufcg.computacao.si1.model.usuario.UsuarioEmpresa;
import br.edu.ufcg.computacao.si1.model.usuario.UsuarioPessoa;
import br.edu.ufcg.computacao.si1.repository.UsuarioRepository;
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

/**
 * Created by gabriel on 08/03/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioTest {

    @Autowired
    private UsuarioRepository repo;

    private Usuario user1, user2;

    @Before
    public void setUp() {
        this.user1 = new UsuarioEmpresa("Belzebu", "sata@hell.com", "fire");
        this.user2 = new UsuarioPessoa("Gretchen", "gretchen@conga.com", "calabok");
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
