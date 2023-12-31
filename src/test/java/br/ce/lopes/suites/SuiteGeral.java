package br.ce.lopes.suites;


import static br.ce.lopes.core.DriverFactory.killDriver;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.lopes.page.ContasPage;
import br.ce.lopes.page.LoginPage;
import br.ce.lopes.test.ContaTest;
import br.ce.lopes.test.MovimentacaoTest;
import br.ce.lopes.test.RemoverMovimentacaoContaTest;
import br.ce.lopes.test.ResumoTest;
import br.ce.lopes.test.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	RemoverMovimentacaoContaTest.class,
	SaldoTest.class,
	ResumoTest.class
})

public class SuiteGeral {
	private static LoginPage loginPage = new LoginPage();
	private static ContasPage contasPage = new ContasPage();
	
	@BeforeClass
	public static void inicializar() {
		loginPage.acessarTelaLogin();
		loginPage.setEmail("emailParaTeste@mail.com");
		loginPage.setSenha("123456");
		loginPage.entrar();
		loginPage.resetarMassa();
		Assert.assertEquals("Dados resetados com sucesso!", contasPage.obterMenssagemCadastradoComSucesso());
		killDriver();
	}
}

