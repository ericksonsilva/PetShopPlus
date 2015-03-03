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
import br.com.petshopplus.model.Funcionario;
import br.com.petshopplus.util.model.FuncionarioBuilder;

public class FuncionarioControllerTest {

	private MockResult result;
	private MockValidator validator;
	private FuncionarioController controller;
	@Mock
	private FuncionarioDao funcionarioDao;
	
	private Funcionario funcionario;
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		result = new MockResult();
		validator = new MockValidator();
		controller = new FuncionarioController(funcionarioDao, result, validator);
		
		funcionario = new FuncionarioBuilder().withCPF("07680714452").withNome("Neto").withTelefone("87284395").
				withRua("Manoel Roberto").withCidade("João Pessoa").withBairro("Bancários").
				withEmail("netom.m@hotmail.com").withComplemento("B2").build();
	}

	@Test
	public void shouldFuncionarioIsAdd() {
		controller.adiciona(funcionario);
		assertTrue(result.included().containsKey("success"));
		assertThat(validator.getErrors(), empty());
	}
	
	@Test
	public void shouldFuncionarioIsNotAddNomeIsNull() {
		funcionario.setNome(null);
		try {
	        controller.adiciona(funcionario);	
	        fail("Não deve passar pelo metodo acima");
	    } catch (ValidationException e) {
	        List<Message> errors = e.getErrors();
	        assertTrue(errors.contains(new SimpleMessage("nome", "O nome deve ser preenchido")));
	        assertEquals(1, errors.size());
	    }
	}

}
