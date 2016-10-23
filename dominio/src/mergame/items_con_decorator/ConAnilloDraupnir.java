package mergame.items_con_decorator;

import mergame.individuos.personajes.Personaje;

public class ConAnilloDraupnir extends PersonajeEquipado {

	public ConAnilloDraupnir(Personaje pj) {
		super(pj);
	}

	@Override
	public int obtenerPuntosDeAtaque() {
		return personajeEquipado.obtenerPuntosDeAtaque() * 2;
	}

	@Override
	public int obtenerPuntosDeDefensa() {
		return personajeEquipado.obtenerPuntosDeDefensa() * 2;
	}

	@Override
	public void consumoElixir(int puntos) {
		// TODO Auto-generated method stub
		personajeEquipado.consumoElixir(puntos);
	}


	@Override
	public void serHechizado(int vidaCurada, int vidaQuitada, int turnosCongelado) {
		// TODO Auto-generated method stub
		
	}

	
	
}
