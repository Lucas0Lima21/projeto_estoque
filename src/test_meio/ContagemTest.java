package test_meio;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

import process.Norma;


class ContagemTest {
	
	private Norma norma = new Norma();

	
	@Test
	void processarCompraTest() {
		norma.carregaListaEstoque();
		norma.carregaListaContagem();
		norma.processarEstoque();
		assertTrue(new File("list_contada.txt").exists());
	}
	
	

}