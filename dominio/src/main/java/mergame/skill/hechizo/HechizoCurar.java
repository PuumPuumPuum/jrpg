package main.java.mergame.skill.hechizo;

import main.java.mergame.individuos.Individuo;


public class HechizoCurar extends Hechizo{

	public HechizoCurar(){
		this.valorBase = 50;
	}
	
	@Override
	public void hechizar(Individuo hechicero, Individuo hechizado){
		int danio = hechicero.getPuntosDeAtaqueMagico() * this.valorBase;
		
		hechizado.serHechizado(danio, 0, 0);
	}

}
