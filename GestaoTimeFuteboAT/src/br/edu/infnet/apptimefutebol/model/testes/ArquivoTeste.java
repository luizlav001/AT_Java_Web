package br.edu.infnet.apptimefutebol.model.testes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.apptimefutebol.model.domain.Integrante;
import src.br.edu.infnet.apptimefutebol.model.domain.ComissaoTecnica;
import src.br.edu.infnet.apptimefutebol.model.domain.Confederacao;
import src.br.edu.infnet.apptimefutebol.model.domain.Gestor;
import src.br.edu.infnet.apptimefutebol.model.domain.Jogador;
import src.br.edu.infnet.apptimefutebol.model.domain.Time;
import src.br.edu.infnet.apptimefutebol.model.model.exception.CargoNullException;
import src.br.edu.infnet.apptimefutebol.model.model.exception.FuncaoNullException;
import src.br.edu.infnet.apptimefutebol.model.model.exception.PosicaoNullException;

public class ArquivoTeste {

	public static void main(String[] args) {
			
			String dir = "C:/Users/Gregory/OneDrive/Documentos/Fundamentos Java/";
			String arq = "Time.txt";
			
			try {
				
				try {
					FileReader file = new FileReader(dir+arq);				
					BufferedReader leitura = new BufferedReader(file);
					
					FileWriter fileW = new FileWriter(dir+"out_"+arq);
					BufferedWriter escrita = new BufferedWriter(fileW);
					
					String linha = null;
					String[] campos;
					
					linha = leitura.readLine();
	
					List<Integrante> integrante = new ArrayList<Integrante>();
					Time time = new Time();
					
					while(linha != null) {
						
						campos = linha.split(";");
						
						if(campos.length == 5) {
							Confederacao confederacao = new Confederacao(
									campos[2],
									campos[3],
									campos[4]
									);
							
							time.setNome(campos[0]);
							time.setDivisao(Boolean.valueOf(campos[1]));
							time.setConfederacao(confederacao);
							
						}else {
						
							switch (campos[0]) {
							case "J":
								Jogador jogador = new Jogador(
											campos[1],
											Integer.valueOf(campos[2]),
											Boolean.valueOf(campos[4]),
											Float.valueOf(campos[3])
									);
								
								try {
									
									jogador.setPosicao(campos[5]);
									jogador.setIdade(Integer.valueOf(campos[5]));
									jogador.setRegistrado(Boolean.valueOf(campos[6]));
									jogador.setValorPasse(Float.valueOf(campos[7]));
									
									integrante.add(jogador);
								}catch(NumberFormatException | PosicaoNullException e) {
									System.out.println(e.getMessage());
								}
								
								break;
	
							case "C":
								ComissaoTecnica comissaoTecnica = new ComissaoTecnica(
										
										campos[1],
										Integer.valueOf(campos[2]),
										Boolean.valueOf(campos[4]),
										Float.valueOf(campos[3])
										
										);
								
								try {
									comissaoTecnica.setFuncao(campos[5]);
									comissaoTecnica.setQtdeTitulos(Integer.valueOf(campos[6]));
									comissaoTecnica.setTecnico(Boolean.valueOf(campos[7]));
									
									integrante.add(comissaoTecnica);
								}catch(NumberFormatException | FuncaoNullException e) {
									System.out.println(e.getMessage());	
									}
								break;
	
							case "G":
								Gestor gestor = new Gestor(
										
										campos[1],
										Integer.valueOf(campos[2]),
										Boolean.valueOf(campos[4]),
										Float.valueOf(campos[3])
										); 
								
								try {
									gestor.setCargo(campos[5]);
									gestor.setCargoConfianca(Boolean.valueOf(campos[6]));
									gestor.setAdicional(Float.valueOf(campos[7]));
									
									integrante.add(gestor);
								}catch(NumberFormatException | CargoNullException e) {
									System.out.println(e.getMessage());		
								}
								break;
								
							default:
								System.out.println("Pedido sem tipo!!!");
								break;
							}
						}					
	
						linha = leitura.readLine();
					}	
					
					time.setIntegrantes(integrante);
					for(Integrante integ : time.getIntegrantes()) {
						escrita.write(
	
								time.getNome()+";"+
								time.getConfederacao().getNome()+";"+
								integ.getNome()+";"+
								integ.calcularBonus()
								
								);
						
					}
					
					leitura.close();
					file.close();
					
					escrita.close();
					fileW.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
				
			} finally {
				System.out.println("Processamento realizado!!!");
			}
		}
	}
