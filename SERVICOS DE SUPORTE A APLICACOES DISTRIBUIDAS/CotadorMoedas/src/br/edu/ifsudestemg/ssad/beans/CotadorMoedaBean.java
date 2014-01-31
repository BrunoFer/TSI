package br.edu.ifsudestemg.ssad.beans;

import java.util.Random;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

import br.edu.ifsudestemg.ssad.session.CotadorMoeda;

@Stateless
@Remote(CotadorMoeda.class)
public class CotadorMoedaBean implements CotadorMoeda{

	private double fatorDeCotacao=1.71;
	
	@Resource
	private TimerService timerService;
	
	@PostConstruct
	public void inicializa(){
		timerService.createTimer(3000L,"timeout");
	}
	
	@Override
	public double fazCotacao(String moedaorigem, String moedadestino,
			double quantia) {
		if("dollar".equals(moedaorigem) && "real".equals(moedadestino))
			return quantia*this.fatorDeCotacao;
		return 0;
	}
	
	@Timeout
	public void atualizaFatorConversao(Timer time){
		this.fatorDeCotacao+=(new Random().nextDouble()-0.5)/100;
		System.out.printf("Atualizando o fator de cotação para: %.f",this.fatorDeCotacao);
	}

}
