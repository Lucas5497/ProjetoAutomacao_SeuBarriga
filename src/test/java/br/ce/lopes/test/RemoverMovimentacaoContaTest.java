package br.ce.lopes.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.lopes.core.BaseTest;
import br.ce.lopes.page.ContasPage;
import br.ce.lopes.page.MenuPage;


public class RemoverMovimentacaoContaTest extends BaseTest {
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	
	@Test
	public void removerContaComMovimentação() {
	
		menuPage.acessarTelaListarConta();
		
		contasPage.pegarTextoTabela("tabelaContas");
		
		contasPage.clicarRemoverConta("Conta com movimentacao");
		
		Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMenssagemCadastradoSemSucesso());
	
	}
}
