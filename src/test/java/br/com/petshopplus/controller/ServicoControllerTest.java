package br.com.petshopplus.controller;

import static org.hamcrest.Matchers.empty;
import static org.junit.Assert.*;

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
import br.com.petshopplus.dao.FuncionarioDao;
import br.com.petshopplus.dao.ServicoDao;
import br.com.petshopplus.model.Funcionario;
import br.com.petshopplus.model.Servico;
import br.com.petshopplus.util.model.FuncionarioBuilder;
import br.com.petshopplus.util.model.ServicoBuilder;

public class ServicoControllerTest {

	private MockResult result;
	private MockValidator validator;
	private ServicoController controller;
	@Mock
	private ServicoDao servicoDao;
	
	private Servico servico;
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		result = new MockResult();
		validator = new MockValidator();
		controller = new ServicoController(servicoDao, result, validator);
		
		servico = new ServicoBuilder().withNome("Banho").withValor(2.1).withDescricao("Banho").build();
	}

	@Test
	public void shouldServicoIsAdd() {
		controller.adiciona(servico);
		assertTrue(result.included().containsKey("success"));
		assertThat(validator.getErrors(), empty());
	}
	
	@Test
	public void shouldServicoIsNotAddNomeIsNull() {
		servico.setNome(null);
		try {
	        controller.adiciona(servico);	
	        fail("Não deve passar pelo metodo acima");
	    } catch (ValidationException e) {
	        List<Message> errors = e.getErrors();
	        assertTrue(errors.contains(new SimpleMessage("nome", "O nome deve ser preenchido")));
	        assertEquals(1, errors.size());
	    }
	}
}
