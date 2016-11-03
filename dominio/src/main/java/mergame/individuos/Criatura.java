package main.java.mergame.individuos;

import java.util.HashMap;
import java.util.Map;

import main.java.mergame.individuos.personajes.Personaje;
import main.java.mergame.individuos.personajes.impl.PersonajeImpl;
import main.java.mergame.items_con_decorator.PersonajeDecorator;
import main.java.mergame.items_con_decorator.impl.ConEspadaSkofnung;
import main.java.mergame.skill.Habilidad;
import main.java.mergame.skill.hechizo.Hechizo;
import main.java.mergame.skill.hechizo.HechizoFuego;

public class Criatura implements Individuo {
	private Map <String, Hechizo> libro;
	protected int salud;
	protected int estamina;	
	protected int nivel;
	protected int experiencia;
	protected int defensa;
	protected int poderMagico;
	protected int poderFisico;
	protected boolean congelado;
	
	public Criatura(){
		this.libro = new HashMap<String, Hechizo>();
		libro.put("Fuego", new HechizoFuego());
		//VER VALORES
		this.poderFisico = 2;
		this.poderMagico = 3;
	}
	
	public Criatura(int salud){
		this.libro = new HashMap<String, Hechizo>();
		libro.put("Fuego", new HechizoFuego());
		//VER VALORES
		this.poderFisico = 2;
		this.poderMagico = 3;
	}
	
	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	public void lanzarSkill(Individuo atacado, String nombreSkill){
		Habilidad skill = this.libro.get(nombreSkill);
		
		skill.realizarHabilidad(this, atacado);
	}

	@Override
	public void serHechizado(int vidaCurada, int vidaQuitada, int turnosCongelado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void serAtacado(int danio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atacar(Individuo victima) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean estaVivo() {
		return this.salud > 0 ? true : false;
	}

	public PersonajeDecorator droppeo(Personaje asesino) {
		//como prueba solo devuelve un tipo de arma
		return new ConEspadaSkofnung(asesino);
	}

	@Override
	public int getPuntosDeAtaqueFisico() {
		return this.poderFisico;
	}

	@Override
	public int getPuntosDeAtaqueMagico() {
		return this.poderMagico;
	}

	@Override
	public int getPuntosDeDefensa() {
		return 0;
	}

}
