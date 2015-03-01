package br.com.petshopplus.controller;

import static org.junit.Assert.*;

import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.empty;

import org.apache.taglibs.standard.tag.common.xml.WhenTag;
import org.hamcrest.core.IsEqual;
import org.jboss.weld.annotated.EmptyAnnotated;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.caelum.vraptor.util.test.MockResult;
import br.com.caelum.vraptor.util.test.MockValidator;
import br.com.caelum.vraptor.validator.Message;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.ValidationException;
import br.com.petshopplus.dao.ClienteDao;
import br.com.petshopplus.model.Cliente;
import br.com.petshopplus.util.model.ClienteBuilder;

public class ClienteControllerTest {
	private MockResult result;
	private MockValidator validator;
	private ClienteController controller;
	@Mock
	private ClienteDao dao;

	private Cliente cliente;
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		result = new MockResult();
		validator = new MockValidator();
		controller = new ClienteController(dao, result, validator);

		cliente = new ClienteBuilder().withCPF("07680714452").withNome("Neto").withTelefone("87284395").
				withRua("Manoel Roberto").withCep("58052562").withCidade("João Pessoa").withBairro("Bancários").
				withEmail("netom.m@hotmail.com").withComplemento("B2").build();
	}

	@Test
	public void shouldClientIsAdd() {
		controller.adiciona(cliente);
		assertTrue(result.included().containsKey("success"));
	}
	
	@Test
	public void shouldClientIsNotAdd() {
		cliente.setCpf(null);
		try {
	        controller.adiciona(cliente);
	        fail();
	    } catch (ValidationException e) {
	        List<Message> errors = e.getErrors();
	        assertTrue(errors.contains(new SimpleMessage("cpf", "O cpf deve ser preenchido")));
	        assertEquals(1, errors.size());
	    }
	}
	
}
