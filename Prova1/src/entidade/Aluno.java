package entidade;

import java.util.ArrayList;

import robo.Robo;
import tabuleiro.*;

public final class Aluno extends Entidade implements SairSeEncontrado {
	
	private boolean encontrado;
	private ArrayList<String> nomesRobosEncontrou;
	
	public boolean isEncontrado() {
		return encontrado;
	}
	
	public ArrayList<String> getNomesRobosEncontrou() {
		return nomesRobosEncontrou;
	}
	
	public char getSimbolo() {
		if (this.encontrado) {
			return super.getSimbolo();
		} else {
			return '?';
		}
	}

	// construtores 
	public Aluno(Celula celula) throws Exception {
		super(celula, 'A');
		this.encontrado = false;
		this.nomesRobosEncontrou = new ArrayList<String>();
	}

	public Aluno(Coordenada posicao, Plano plano) throws Exception {
		this(plano.getCelula(posicao));
	}

	public Aluno(int x, int y, Plano plano) throws Exception {
		this(new Coordenada(x, y), plano);
	}
	
	public void encontrar(Robo robo) {
		this.encontrado = true;
		this.nomesRobosEncontrou.add(robo.getNome());
	}

}
