package br.ce.lopes.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.lopes.core.BaseTest;
import br.ce.lopes.page.ContasPage;
import br.ce.lopes.page.HomePage;
import br.ce.lopes.page.MenuPage;
import br.ce.lopes.page.MovimentacaoPage;


public class SaldoTest extends BaseTest {
	HomePage homePage = new HomePage();
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	MovimentacaoPage movPage = new MovimentacaoPage();
	
	@Test
	public void testSaldoConta() {
		
		/*
		menuPage.acessarTelaAdicionarConta();
		contasPage.setNome("Conta para validar o saldo");
		contasPage.salvarConta();
		
		menuPage.acessarTelaCriarMovimentacao();
		movPage.setDataMovimentacao(obterDataFormatada(new Date()));
		movPage.setDataPagamento(obterDataFormatada(new Date()));
		movPage.setDescricao("Descrição teste");
		movPage.setInteressado("Qualquer interessado");
		movPage.setValor("1000000");
		movPage.setConta("Conta para validar o saldo");
		movPage.setSituacaoPago();
		movPage.salvar();
		*/
		
		menuPage.acessarTelaInicial();
		//System.out.println(homePage.obterSaldoDaConta(NOME_CONTA_ALTERADA));
		Assert.assertEquals("534.00",
				homePage.obterSaldoDaConta("Conta para saldo"));
		
	}
}
