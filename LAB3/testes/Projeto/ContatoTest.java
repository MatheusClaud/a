package Projeto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class ContatoTest {
	
	private Contato contato;
	
	@BeforeEach
	public void criaContato(){
		this.contato = new Contato("nome","sobrenome", "00 00000000");
	}
	
	@Test
	public void testGetNomeCompleto(){
		contato = new Contato("nome","sobrenome", "00 00000000");
		assertEquals("nome sobrenome", contato.getNomeCompleto());
	}
	
	@Test
	public void testEquals() {
		contato = new Contato("nome","sobrenome", "00 00000000");

		Contato contato2 = new Contato("nome", "sobrenome", "11 11111111");
		assertTrue(contato2.equals(contato));
		
		contato2 = new Contato("nome1", "sobrenome", "11 11111111");
		assertFalse(contato2.equals(contato));
	}
	
	@Test
	public void testToString() {
		contato = new Contato("nome","sobrenome", "00 00000000");
		
		assertEquals("nome sobrenome - 00 00000000", contato.toString());
	}
	
	@Test
	public void testParametroNullCriarContato() {
		
		try {

		     Contato contatoInvalido = new Contato(null, "sobrenome", "00 00000000");

		     fail("Era esperado exceção ao passar nome como nulo");

		  } catch (NullPointerException n) {


		  }
		
	}
	
	@Test
	public void testIllegalStringCadastroContato() {
		
		try {

		     Contato contatoInvalido = new Contato("", "    ", "00 00000000");

		     fail("Era esperado exceção ao passar Strings inválidas");

		  } catch (IllegalArgumentException n) {


		  }
		
	}
	

}
