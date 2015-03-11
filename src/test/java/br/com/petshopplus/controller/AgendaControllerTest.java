package br.com.petshopplus.controller;

import static org.hamcrest.Matchers.empty;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.util.test.MockResult;
import br.com.caelum.vraptor.util.test.MockValidator;
import br.com.caelum.vraptor.validator.Message;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.ValidationException;
import br.com.caelum.vraptor.validator.Validator;
import br.com.petshopplus.dao.ConsultaDao;
import br.com.petshopplus.dao.AnimalDao;
import br.com.petshopplus.dao.ClienteDao;
import br.com.petshopplus.dao.FuncionarioDao;
import br.com.petshopplus.dao.ServicoDao;
import br.com.petshopplus.model.Consulta;
import br.com.petshopplus.model.Animal;
import br.com.petshopplus.model.Servico;
import br.com.petshopplus.util.model.AgendaBuilder;
import br.com.petshopplus.util.model.AnimalBuilder;

public class AgendaControllerTest {
	private MockResult result;
	private MockValidator validator;
	private ConsultaController controller;
	@Mock
	private AnimalDao animalDao;
	@Mock
	private FuncionarioDao funcionarioDao;
	@Mock
	private ClienteDao clienteDao;
	@Mock
	private ConsultaDao agendaDao;
	@Mock
	private ServicoDao servicoDao;
	private Consulta agenda;
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		result = new MockResult();
		validator = new MockValidator();
		controller = new ConsultaController(agendaDao,result,validator,clienteDao,animalDao,funcionarioDao,servicoDao);
		
		agenda = new AgendaBuilder().withDescricao("Banho").withHora("13:00").build();
	}

	@Test
	public void shouldAgendaIsAdd() {
		controller.adiciona(agenda);
		assertTrue(result.included().containsKey("success"));
		assertThat(validator.getErrors(), empty());
	}
	
	@Test
	public void shouldAgendaIsNotAddHoraIsNull() {
		agenda.setHora(null);
		try {
	        controller.adiciona(agenda);	
	        fail("Não deve passar pelo metodo acima");
	    } catch (ValidationException e) {
	        List<Message> errors = e.getErrors();
	        assertTrue(errors.contains(new SimpleMessage("hora", "A hora deve ser preenchida")));
	        assertEquals(1, errors.size());
	    }
	}
}
