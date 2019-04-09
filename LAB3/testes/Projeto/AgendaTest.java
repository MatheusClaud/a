package Projeto;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AgendaTest {

	@Test
	public void testCadastraContatos() {
		Agenda agenda = new Agenda();
		agenda.cadastraContato(1, "nome", "sobrenome", "00 00000000");
		assertEquals(agenda.getContatos(1).getNomeCompleto(), "nome sobrenome");
		
		agenda.cadastraContato(1, "nome1", "sobrenome1", "00 00000000");
		assertEquals(agenda.getContatos(1).getNomeCompleto(), "nome1 sobrenome1");
		
		agenda.cadastraContato(100, "nome", "sobrenome", "00 00000000");
		assertEquals(agenda.getContatos(100).getNomeCompleto(), "nome sobrenome");
		
		agenda.cadastraContato(100, "nome1", "sobrenome1", "00 00000000");
		assertEquals(agenda.getContatos(100).getNomeCompleto(), "nome1 sobrenome1");
	}
	
	@Test
	public void testGetListaContatos() {
		Agenda agenda = new Agenda();
		
		String[] listaEsperada = {""};
		assertArrayEquals(listaEsperada, agenda.getListaContatos());
		
		agenda.cadastraContato(1, "nome", "sobrenome", "00 00000000");
		String[] listaEsperada2 = {"1 - nome sobrenome"};
		assertArrayEquals(listaEsperada2, agenda.getListaContatos());
		
		agenda.cadastraContato(100, "nome2", "sobrenome2", "00 00000000");
		String[] listaEsperada3 = {"1 - nome sobrenome", "100 - nome2 sobrenome2"};
		assertArrayEquals(listaEsperada3, agenda.getListaContatos());
		
	}
	
	@Test
	public void testEquals() {
		Agenda agenda = new Agenda();
		agenda.cadastraContato(1, "nome", "sobrenome", "00 00000000");
		
		Agenda agenda2 = new Agenda();
		agenda2.cadastraContato(1, "nome", "sobrenome", "00 00000000");
		
		assertTrue(agenda.equals(agenda2));
		
		agenda.cadastraContato(100, "nome2", "sobrenome2", "00 00000000");
		assertFalse(agenda.equals(agenda2));
		
		agenda2.cadastraContato(100, "nome2", "sobrenome2", "00 00000000");
		assertTrue(agenda.equals(agenda2));
		
		agenda.cadastraContato(100, "nome3", "sobrenome3", "00 00000000");
		assertFalse(agenda.equals(agenda2));
	}
	
	@Test 
	public void testIndiceValido() {
		Agenda agenda = new Agenda();
		assertTrue(agenda.indiceValido(1));
		assertTrue(agenda.indiceValido(100));
		assertFalse(agenda.indiceValido(101));
		assertFalse(agenda.indiceValido(0));
	}
	
	@Test
	public void testGetContato() {
		Agenda agenda = new Agenda();
		agenda.cadastraContato(1, "nome", "sobrenome", "00 00000000");
		
		assertEquals("nome sobrenome - 00 00000000", agenda.getContato(1));
	}
	
}
