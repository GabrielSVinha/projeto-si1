package br.edu.ufcg.computacao.si1.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static junit.framework.TestCase.*;

/**
 * Created by Marcus Oliveira on 28/12/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AnuncioServiceTest {

    @Test
    public void teste() {
        assertTrue(true);
    }

    // @Autowired
    // private AnuncioService anuncioService;

    // @Autowired
    // private AnuncioRepository anuncioRepository;

    // @Autowired
    // private UsuarioService usuarioService;

    // private Anuncio anuncio1, anuncio2, anuncio3;

    // private AnuncioForm form1, form2, form3;

    // private UsuarioForm userForm;

    // private Usuario owner;

    // @Before
    // public void setUp() {
    //     userForm = new UsuarioForm("Tester", "test@ad-extreme.com", "1234", 1);

    //     owner = usuarioService.create(userForm);

    //     anuncio1 = new Ad("Anuncio de Movel", new Date(), 100, Notas.notas[2], "MOVEL", owner);
    //     anuncio2 = new Ad("Anuncio de Imovel", new Date(), 100000, Notas.notas[3], "IMOVEL", owner);
    //     anuncio3 = new Ad("Anuncio de Emprego", new Date(), 0, Notas.notas[1], "EMPREGO", owner);

    //     form1 = new AnuncioForm(anuncio1);
    //     form2 = new AnuncioForm(anuncio2);
    //     form3 = new AnuncioForm(anuncio3);
    // }

    // @After
    // public void tearDown() {
    //     anuncioRepository.deleteAll();
    // }

    // @Test
    // public void testInicializacao() {
    //     assertNotNull("AnuncioService não foi instânciado corretamente", anuncioService);
    //     assertTrue("AnuncioService não deveria conter nenhum item", anuncioService.getAll().isEmpty());
    // }


    // @Test
    // public void testCreateAd() {
    //     Anuncio anuncio1FromDB = anuncioService.create(form1);
    //     Anuncio anuncio2FromDB = anuncioService.create(form2);
    //     Anuncio anuncio3FromDB = anuncioService.create(form3);

    //     assertNotNull(anuncio1FromDB);
    //     assertNotNull(anuncio2FromDB);
    //     assertNotNull(anuncio3FromDB);

    //     assertTrue(anuncioRepository.exists(anuncio1FromDB.getUser_id()));
    //     assertTrue(anuncioRepository.exists(anuncio2FromDB.getUser_id()));
    //     assertTrue(anuncioRepository.exists(anuncio3FromDB.getUser_id()));

    //     // assertEquals(anuncio1FromDB, anuncio1);
    //     // assertEquals(anuncio2FromDB, anuncio2);
    //     // assertEquals(anuncio3FromDB, anuncio3);

    //     assertEquals(anuncio1FromDB, anuncioService.getById(anuncio1FromDB.getUser_id()));
    //     assertEquals(anuncio2FromDB, anuncioService.getById(anuncio2FromDB.getUser_id()));
    //     assertEquals(anuncio3FromDB, anuncioService.getById(anuncio3FromDB.getUser_id()));
    // }

    // @Test
    // public void testGetPorTipo() {

    //     int QTDE_ANUNCIOS_ESPERADA = 1;

    //     Anuncio anuncioMovel = anuncioService.create(form1);
    //     Anuncio anuncioImovel = anuncioService.create(form2);
    //     Anuncio anuncioEmprego = anuncioService.create(form3);

    //     assertNotNull(anuncioMovel);
    //     assertNotNull(anuncioImovel);
    //     assertNotNull(anuncioEmprego);

    //     assertEquals(anuncioMovel.getType(), "movel");
    //     assertEquals(anuncioImovel.getType(), "imovel");
    //     assertEquals(anuncioEmprego.getType(), "emprego");

    //     assertEquals(QTDE_ANUNCIOS_ESPERADA, anuncioService.getByType("movel").size());
    //     assertEquals(QTDE_ANUNCIOS_ESPERADA, anuncioService.getByType("imovel").size());
    //     assertEquals(QTDE_ANUNCIOS_ESPERADA, anuncioService.getByType("emprego").size());

    //     assertTrue(anuncioService.getByType("movel").contains(anuncioMovel));
    //     assertTrue(anuncioService.getByType("imovel").contains(anuncioImovel));
    //     assertTrue(anuncioService.getByType("emprego").contains(anuncioEmprego));
    // }

    // @Test
    // public void testGetAll() {
    //     int QTDE_ANUNCIOS_ESPERADA = 3;
    //     Anuncio anuncioMovel = anuncioService.create(form1);
    //     Anuncio anuncioImovel = anuncioService.create(form2);
    //     Anuncio anuncioEmprego = anuncioService.create(form3);

    //     assertNotNull(anuncioMovel);
    //     assertNotNull(anuncioImovel);
    //     assertNotNull(anuncioEmprego);

    //     assertEquals(QTDE_ANUNCIOS_ESPERADA, anuncioService.getAll().size());

    //     assertTrue(anuncioService.getAll().contains(anuncioMovel));
    //     assertTrue(anuncioService.getAll().contains(anuncioImovel));
    //     assertTrue(anuncioService.getAll().contains(anuncioEmprego));

    // }

    // @Test
    // public void testDelete() {
    //     int QTDE_ANUNCIOS_ESPERADA = 3;

    //     Anuncio anuncioMovel = anuncioService.create(form1);
    //     Anuncio anuncioImovel = anuncioService.create(form2);
    //     Anuncio anuncioEmprego = anuncioService.create(form3);

    //     assertEquals(QTDE_ANUNCIOS_ESPERADA, anuncioService.getAll().size());
    //     assertTrue(anuncioService.getAll().contains(anuncioMovel));
    //     assertTrue(anuncioService.getAll().contains(anuncioImovel));
    //     assertTrue(anuncioService.getAll().contains(anuncioEmprego));

    //     assertTrue(anuncioService.delete(anuncioMovel.getUser_id()));
    //     QTDE_ANUNCIOS_ESPERADA-=1;
    //     assertEquals(QTDE_ANUNCIOS_ESPERADA, anuncioService.getAll().size());
    //     assertFalse(anuncioService.getAll().contains(anuncioMovel));
    //     assertTrue(anuncioService.getAll().contains(anuncioImovel));
    //     assertTrue(anuncioService.getAll().contains(anuncioEmprego));

    //     assertTrue(anuncioService.delete(anuncioImovel.getUser_id()));
    //     QTDE_ANUNCIOS_ESPERADA-=1;
    //     assertEquals(QTDE_ANUNCIOS_ESPERADA, anuncioService.getAll().size());
    //     assertFalse(anuncioService.getAll().contains(anuncioMovel));
    //     assertFalse(anuncioService.getAll().contains(anuncioImovel));
    //     assertTrue(anuncioService.getAll().contains(anuncioEmprego));

    //     assertTrue(anuncioService.delete(anuncioEmprego.getUser_id()));
    //     QTDE_ANUNCIOS_ESPERADA-=1;
    //     assertEquals(QTDE_ANUNCIOS_ESPERADA, anuncioService.getAll().size());
    //     assertFalse(anuncioService.getAll().contains(anuncioMovel));
    //     assertFalse(anuncioService.getAll().contains(anuncioImovel));
    //     assertFalse(anuncioService.getAll().contains(anuncioEmprego));

    //     assertEquals(0, QTDE_ANUNCIOS_ESPERADA);

    //     assertFalse(anuncioService.delete(anuncioMovel.getUser_id()));
    //     assertFalse(anuncioService.delete(anuncioImovel.getUser_id()));
    //     assertFalse(anuncioService.delete(anuncioEmprego.getUser_id()));
    // }

    // @Test
    // public void testUpdate() {

    //     String SUFIXO = " editado";

    //     Anuncio anuncioMovel = anuncioService.create(form1);
    //     Anuncio anuncioImovel = anuncioService.create(form2);
    //     Anuncio anuncioEmprego = anuncioService.create(form3);

    //     assertEquals(anuncioMovel, anuncio1);
    //     assertEquals(anuncioImovel, anuncio2);
    //     assertEquals(anuncioEmprego, anuncio3);

    //     //Update Titulo
    //     anuncioMovel.setTitle(anuncioMovel.getTitle()+SUFIXO);
    //     anuncioImovel.setTitle(anuncioImovel.getTitle()+SUFIXO);
    //     anuncioEmprego.setTitle(anuncioEmprego.getTitle()+SUFIXO);

    //     assertTrue(anuncioService.update(anuncioMovel));
    //     assertTrue(anuncioService.update(anuncioImovel));
    //     assertTrue(anuncioService.update(anuncioEmprego));

    //     assertEquals(anuncioMovel.getTitle(), anuncioService.getById(anuncioMovel.getUser_id()).getTitle());
    //     assertEquals(anuncioImovel.getTitle(), anuncioService.getById(anuncioImovel.getUser_id()).getTitle());
    //     assertEquals(anuncioEmprego.getTitle(), anuncioService.getById(anuncioEmprego.getUser_id()).getTitle());

    //     //Update preço
    //     anuncioMovel.setPrice(anuncioMovel.getPrice()*2);
    //     anuncioImovel.setPrice(anuncioImovel.getPrice()*2);
    //     anuncioEmprego.setPrice(anuncioEmprego.getPrice()*2);

    //     assertTrue(anuncioService.update(anuncioMovel));
    //     assertTrue(anuncioService.update(anuncioImovel));
    //     assertTrue(anuncioService.update(anuncioEmprego));

    //     assertEquals(anuncioMovel.getPrice(), anuncioService.getById(anuncioMovel.getUser_id()).getPrice());
    //     assertEquals(anuncioImovel.getPrice(), anuncioService.getById(anuncioImovel.getUser_id()).getPrice());
    //     assertEquals(anuncioEmprego.getPrice(), anuncioService.getById(anuncioEmprego.getUser_id()).getPrice());

    //     //Update nota
    //     anuncioMovel.setNote(Notas.notas[4]);
    //     anuncioImovel.setNote(Notas.notas[4]);
    //     anuncioEmprego.setNote(Notas.notas[4]);

    //     assertTrue(anuncioService.update(anuncioMovel));
    //     assertTrue(anuncioService.update(anuncioImovel));
    //     assertTrue(anuncioService.update(anuncioEmprego));

    //     assertEquals(Notas.notas[4], anuncioService.getById(anuncioMovel.getUser_id()).getNote());
    //     assertEquals(Notas.notas[4], anuncioService.getById(anuncioImovel.getUser_id()).getNote());
    //     assertEquals(Notas.notas[4], anuncioService.getById(anuncioEmprego.getUser_id()).getNote());
    // }

}
