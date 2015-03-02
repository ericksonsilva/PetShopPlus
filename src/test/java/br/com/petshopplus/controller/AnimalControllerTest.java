package br.com.petshopplus.controller;

import static org.hamcrest.Matchers.empty;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.caelum.vraptor.util.test.MockResult;
import br.com.caelum.vraptor.util.test.MockValidator;
import br.com.caelum.vraptor.validator.Message;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.ValidationException;
import br.com.petshopplus.dao.AnimalDao;
import br.com.petshopplus.dao.ClienteDao;
import br.com.petshopplus.model.Animal;
import br.com.petshopplus.util.model.AnimalBuilder;

public class AnimalControllerTest {
	private MockResult result;
	private MockValidator validator;
	private AnimalController controller;
	@Mock
	private AnimalDao animalDao;
	@Mock
	private ClienteDao clienteDao;
	private Animal animal;
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		result = new MockResult();
		validator = new MockValidator();
		controller = new AnimalController(animalDao, clienteDao, result, validator);
		
		animal = new AnimalBuilder().withNome("Bidu").withSexo("Macho").withRaca("Pitbull").withEspecie("Cao").
				withPorte("Grande").withIdade("10").build();
	}

	@Test
	public void shouldAnimalIsAdd() {
		controller.adiciona(animal);
		assertTrue(result.included().containsKey("success"));
		assertThat(validator.getErrors(), empty());
	}
	
	@Test
	public void shouldAnimalIsNotAddNomeIsNull() {
		animal.setNome(null);
		try {
	        controller.adiciona(animal);
	        fail("Não deve passar pelo metodo acima");
	    } catch (ValidationException e) {
	        List<Message> errors = e.getErrors();
	        assertTrue(errors.contains(new SimpleMessage("nome", "O nome deve ser preenchido")));
	        assertEquals(1, errors.size());
	    }
	}
	
	@Test
	public void shouldAnimalIsNotAddSexoIsNull() {
		animal.setSexo(null);
		try {
	        controller.adiciona(animal);
	        fail("Não deve passar pelo metodo acima");
	    } catch (ValidationException e) {
	        List<Message> errors = e.getErrors();
	        assertTrue(errors.contains(new SimpleMessage("sexo", "O sexo deve ser preenchido")));
	        assertEquals(1, errors.size());
	    }
	}
	
	@Test
	public void shouldAnimalIsNotAddRacaIsNull() {
		animal.setRaca(null);
		try {
	        controller.adiciona(animal);
	        fail("Não deve passar pelo metodo acima");
	    } catch (ValidationException e) {
	        List<Message> errors = e.getErrors();
	        assertTrue(errors.contains(new SimpleMessage("raca", "Raça deve ser preenchido")));
	        assertEquals(1, errors.size());
	    }
	}
	
	@Test
	public void shouldAnimalRemoved() {
		when(animalDao.carrega(animal.getId())).thenReturn(animal);
		controller.remove(animal.getId());
		assertThat(validator.getErrors(), empty());
		assertTrue(result.included().containsKey("success"));
	}
	
	@Test
	public void shouldClientRemovedError() {
		int idInvalido = 999;
		when(animalDao.carrega(idInvalido)).thenReturn(animal);
		try{
			controller.remove(animal.getId());	
		}catch (ValidationException e) {
	        List<Message> errors = e.getErrors();
	        assertTrue(errors.contains(new SimpleMessage("id", "Animal não encontrado ou aconteceu algum erro na busca.")));
	        assertEquals(1, errors.size());
	    }
	}
}
