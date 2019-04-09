package Projeto;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OpcaoTest {
	@Test
	public void testComparador() {
		Opcao op = new Opcao("A", "ssssss");
		
		assertFalse(op.comparador("B"));
		assertTrue(op.comparador("A"));
		
	}
}
