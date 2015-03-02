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
import br.com.petshopplus.dao.ProdutoDao;
import br.com.petshopplus.model.Produto;
import br.com.petshopplus.util.model.ProdutoBuilder;

public class ProdutoControllerTest {
	private MockResult result;
	private MockValidator validator;
	private ProdutoController controller;
	@Mock
	private ProdutoDao dao;
	
	private Produto produto;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		result = new MockResult();
		validator = new MockValidator();
		controller = new ProdutoController(dao, result, validator);
		produto = new ProdutoBuilder().withNome("Shampoo").withDescricao("Só para cachorros").withPreco(10.0).build();
	}

	@Test
	public void shouldProdutoIsAdd() {
		controller.adiciona(produto);
		assertTrue(result.included().containsKey("success"));
		assertThat(validator.getErrors(), empty());
	}

	@Test
	public void shouldClientIsNotAddTelefoneIsNull() {
		produto.setPreco(0.0);
		try {
	        controller.adiciona(produto);
	        fail("Não deve passar pelo metodo acima");
	    } catch (ValidationException e) {
	        List<Message> errors = e.getErrors();
	        assertTrue(errors.contains(new SimpleMessage("valor", "O preço deve ser preenchido")));
	        assertEquals(1, errors.size());
	    }
	}
	
}
