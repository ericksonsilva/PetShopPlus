package br.com.petshopplus.controller;

import static org.hamcrest.Matchers.empty;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
import br.com.petshopplus.dao.LoginDao;
import br.com.petshopplus.model.Funcionario;
import br.com.petshopplus.model.Login;
import br.com.petshopplus.util.model.FuncionarioBuilder;
import br.com.petshopplus.util.model.LoginBuilder;

public class FuncionarioControllerTest {

	private MockResult result;
	private MockValidator validator;
	private FuncionarioController controller;
	@Mock
	private FuncionarioDao funcionarioDao;
	private LoginDao loginDao;
	private Funcionario funcionario;
	private Login login;
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		result = new MockResult();
		validator = new MockValidator();
		controller = new FuncionarioController(funcionarioDao, loginDao, result, validator);
		
		login = new LoginBuilder().withUsuario("neto").withSenha("12345").build();
		funcionario = new FuncionarioBuilder().withCPF("07680714452").withNome("Neto").withTelefone("87284395").
				withRua("Manoel Roberto").withCidade("João Pessoa").withBairro("Bancários").
				withEmail("netom.m@hotmail.com").withComplemento("B2").build();
	}

	@Test
	public void shouldFuncionarioIsAdd() {
		controller.adiciona(funcionario, login);
		assertTrue(result.included().containsKey("success"));
		assertThat(validator.getErrors(), empty());
	}
	
	@Test
	public void shouldFuncionarioIsNotAddNomeIsNull() {
		funcionario.setNome(null);
		login.setUsuario(null);
		try {
	        controller.adiciona(funcionario, login);	
	        fail("Não deve passar pelo metodo acima");
	    } catch (ValidationException e) {
	        List<Message> errors = e.getErrors();
	        assertTrue(errors.contains(new SimpleMessage("nome", "O nome deve ser preenchido")));
	        assertEquals(1, errors.size());
	    }
	}

}
