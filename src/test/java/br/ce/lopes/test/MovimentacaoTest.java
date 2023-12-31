package br.ce.lopes.test;


import static br.ce.lopes.utils.DataUtils.obterDataFormatada;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.ce.lopes.core.BaseTest;
import br.ce.lopes.page.MenuPage;
import br.ce.lopes.page.MovimentacaoPage;
import br.ce.lopes.utils.DataUtils;



public class MovimentacaoTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	MovimentacaoPage movPage = new MovimentacaoPage();
	
	@Test
	public void inserirMovimentacao() {
		
		menuPage.acessarTelaCriarMovimentacao();
		movPage.setDataMovimentacao(obterDataFormatada(new Date()));
		movPage.setDataPagamento(obterDataFormatada(new Date()));
		movPage.setDescricao("Descrição teste");
		movPage.setInteressado("Qualquer interessado");
		movPage.setValor("1000000");
		movPage.setConta("Conta para movimentacoes");
		movPage.setSituacaoPago();
		movPage.salvar();
		Assert.assertEquals("Movimentação adicionada com sucesso!", movPage.obterMenssagemCadastradoComSucesso());
		
	}
	
	@Test
	public void camposObrigatóriosNaMovimentação() {
		
		menuPage.acessarTelaCriarMovimentacao();
		movPage.salvar();
		
		List<String> erros = movPage.obterTextoErros();
		Assert.assertEquals(6, erros.size());
		
		Assert.assertTrue(erros.containsAll(Arrays.asList("Data da Movimentação é obrigatório", 
				"Data do pagamento é obrigatório", 
				"Descrição é obrigatório", 
				"Interessado é obrigatório", 
				"Valor é obrigatório", 
				"Valor deve ser um número")));
	}
	
	@Test
	public void movimentaçãoFutura() {
		
		menuPage.acessarTelaCriarMovimentacao();
		Date dataFutura = DataUtils.obterDataComDiferencaDias(5);
		movPage.setDataMovimentacao(obterDataFormatada(dataFutura));
		movPage.setDataPagamento(obterDataFormatada(dataFutura));
		movPage.setDescricao("Descrição teste");
		movPage.setInteressado("Qualquer interessado");
		movPage.setValor("1000000");
		movPage.setConta("Conta para movimentacoes");
		movPage.setSituacaoPago();
		movPage.salvar();
		List<String> erros = movPage.obterTextoErros();
		Assert.assertTrue(
				erros.contains("Data da Movimentação deve ser menor ou igual à data atual"));
	
		Assert.assertEquals(1, erros.size());
	}
	
}
