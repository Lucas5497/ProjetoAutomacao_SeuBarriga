package br.ce.lopes.page;

import br.ce.lopes.core.BasePage;

public class HomePage extends BasePage {
	
	public String obterSaldoDaConta(String conta) {
		return obterCelula("Conta", conta, "Saldo", "tabelaSaldo").getText();
	}
}
