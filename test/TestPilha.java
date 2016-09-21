import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class TestPilha {
	
	private Pilha p;
	
	@Before
	public void inicializarPilha(){
		p = new Pilha(10);		
	}

	@Test
	public void pilhaVazia() {
		assertTrue(p.estaVazia());
		assertEquals(0, p.tamanho());
	}
	
	@Test
	public void empilharUmElemento() {
		p.empilhar("A");
		
		assertFalse(p.estaVazia());
		assertEquals(1, p.tamanho());
		assertEquals("A", p.topo());
	}
	
	@Test
	public void desempilharElemento() {
		p.empilhar("A");
		p.empilhar("B");
		
		assertEquals(2, p.tamanho());
		assertEquals("B", p.topo());		
		
		Object desempilhado = p.desempilhar();
		
		assertEquals(1, p.tamanho());
		assertEquals("A", p.topo());
		
		assertEquals("B", desempilhado);
	}
	
	@Test(expected=PilhaVaziaException.class)
	public void desempilharDaPilhaVazia() {		
		p.desempilhar();
	}
	
	@Test
	public void empilharNaPilhaCheia() {		
		for(int i=0; i<10; i++)
			p.empilhar("elemento " + i);
		
		try{
			p.empilhar("boom!");
			fail();
		}catch(PilhaCheiaException ex){
			assertEquals("boom!", ex.getElemento());
						
		}
	}

}
