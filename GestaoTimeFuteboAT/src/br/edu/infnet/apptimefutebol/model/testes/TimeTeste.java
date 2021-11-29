package br.edu.infnet.apptimefutebol.model.testes;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.apptimefutebol.model.domain.Integrante;
import src.br.edu.infnet.apptimefutebol.model.domain.ComissaoTecnica;
import src.br.edu.infnet.apptimefutebol.model.domain.Confederacao;
import src.br.edu.infnet.apptimefutebol.model.domain.Jogador;
import src.br.edu.infnet.apptimefutebol.model.domain.Time;
import src.br.edu.infnet.apptimefutebol.model.model.exception.FuncaoNullException;
import src.br.edu.infnet.apptimefutebol.model.model.exception.PosicaoNullException;

public class TimeTeste {

public static void main(String[] args) {
		
		Confederacao confederacao = new Confederacao("Carioca","confcarioca@infnet.com.br", "Rio de Janeiro");
		
		Jogador jgd1 = new Jogador("Luiz", 1, true, 2000);
		try {
			
			jgd1.setPosicao("Atacante");
			jgd1.setIdade(30);
			jgd1.setValorPasse(3000);
			jgd1.setResultadoJogo(true);
			System.out.println(jgd1);
		} catch (PosicaoNullException e) {
			System.out.println(e.getMessage());
		}
	
		
		Jogador jgd2 = new Jogador("Lincoln", 2, false, 1500);
		try {
			jgd2.setIdade(25);
			jgd2.setValorPasse(2000);
			jgd2.setResultadoJogo(false);
			System.out.println(jgd2);
			jgd2.setPosicao("Zagueiro");
		} catch (PosicaoNullException e) {
			System.out.println(e.getMessage());
		}
	
		
		ComissaoTecnica  cmtc = new ComissaoTecnica("Gregory",30, true, 900);
		try {
			cmtc.setFuncao("Treinaddor");
			cmtc.setTecnico(true);
			cmtc.setQtdeTitulos(5);
			System.out.println(cmtc);
		} catch (FuncaoNullException e) {
			System.out.println(e.getMessage());
		}
		
		
		List<Integrante> listaTime = new ArrayList<Integrante>();
		listaTime.add(jgd1);
		listaTime.add(jgd2);
		
		List<Integrante> listaTime2 = new ArrayList<Integrante>();
		listaTime2.add(cmtc);
		
		Time time = new Time();
		time.setNome("Flamengo");
		time.setDivisao(true);
		time.setConfederacao(confederacao);
		time.setIntegrantes(listaTime);
		System.out.println(time);
		
		Time time2 = new Time();
		time2.setNome("Botafogo");
		time2.setDivisao(false);
		time2.setConfederacao(confederacao);
		time2.setIntegrantes(listaTime2);
		System.out.println(time2);
	}
}
