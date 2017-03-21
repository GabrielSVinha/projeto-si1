package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.InitialPoint;
import br.edu.ufcg.computacao.si1.model.form.UsuarioForm;
import br.edu.ufcg.computacao.si1.model.usuario.Usuario;
import br.edu.ufcg.computacao.si1.model.usuario.UsuarioEmpresa;
import br.edu.ufcg.computacao.si1.model.usuario.UsuarioPessoa;
import br.edu.ufcg.computacao.si1.repository.UsuarioRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
* Created by gabriel on 09/03/17.
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioServiceTest {

   @Autowired
   private UsuarioRepository repo;

   private UsuarioService service;

   private UsuarioForm form;

   @Before
   public void setUp(){
       this.service = new UsuarioServiceImpl();
       this.form = new UsuarioForm();
       form.setNome("Massoni");
       form.setEmail("massoni@professor.com");
       form.setSenha("condingdojo");
       form.setRole(1);
       repo.save(new UsuarioEmpresa(form.getNome(), form.getEmail(), form.getSenha()));
       //this.service.create(form);
   }
//
//    @After
//    public void tearDown() {
//        repo.deleteAll();
//    }
//
//    @Test
//    public void testInicializacao(){
//        assertNotNull(this.service);
//    }

//    @Test
//    public void testFactory(){
//        this.service.create(form);
//        assertEquals(repo.count(), 2);
//        assertEquals(repo.findByEmail("massoni@professor.com").getR(), 1);
//    }

//    @Test
//    public void testTypes(){
//        assertEquals(UsuarioPessoa.class, service.create(form));
//    }

//    @Test
//    public void testDeletion(){
//        this.service.delete(Integer.toUnsignedLong(1));
//        assertEquals(Integer.toUnsignedLong(0), repo.count());
//    }

}
