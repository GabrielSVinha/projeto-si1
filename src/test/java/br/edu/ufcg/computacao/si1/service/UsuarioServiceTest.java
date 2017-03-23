package br.edu.ufcg.computacao.si1.service;

import br.edu.ufcg.computacao.si1.model.form.UsuarioForm;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
* Created by gabriel on 09/03/17.
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioServiceTest {

    @Test
    public void teste() {
        assertTrue(true);
    }

//    @Autowired
//    private UsuarioRepository userRepository;

//    @Autowired
//    private UsuarioService userService;

//    private UsuarioForm userForm;

//    @Before
//    public void setUp() {
//        userForm = new UsuarioForm("Massoni", "massoni@professor.com", "condingdojo", 1);

//        userRepository.save(new UsuarioEmpresa(userForm.getName(), userForm.getEmail(), userForm.getPassword()));

//        userService.create(userForm);
//    }

//    @After
//    public void tearDown() {
//        userRepository.deleteAll();
//    }

//    @Test
//    public void testInicializacao() {
//        assertNotNull(userService);
//    }

//    @Test
//    public void testFactory() {
//        userService.create(userForm);
//        assertEquals(userRepository.count(), 2);
//        assertEquals(userRepository.findByEmail("massoni@professor.com").getRole(), 1);
//    }

//    @Test
//    public void testTypes() {
//        assertEquals(UsuarioPessoa.class, userService.create(userForm));
//    }

//    @Test
//    public void testDeletion() {
//        userService.delete(1L);
//        assertEquals(0L, userRepository.count());
//    }

}
