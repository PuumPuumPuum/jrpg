package testMergame;
 
import org.junit.Assert;
import org.junit.Test;

import mergame.casta.impl.Guerrero;
import mergame.casta.impl.Mago;
import mergame.individuos.Criatura;
import mergame.individuos.personajes.Personaje;
import mergame.individuos.personajes.Usuario;
import mergame.individuos.personajes.impl.Enano;
import mergame.individuos.personajes.impl.Humano;
import mergame.individuos.personajes.impl.Orco;
import mergame.items_con_decorator.ConAnilloDraupnir;
import mergame.items_con_decorator.ConEscudoSvalinn;
import mergame.items_con_decorator.ConEspadaSkofnung;
import mergame.skill.Habilidad;

public class TestMergame {
   
    /*
     * Especificacion de Items
     * ~~~~~~~~~~~~~~~~~~~~~~~
     * ConEspadaSkofnung: Esta espada aumenta en 5 pts el ataque
     * ConEscudoSvalinn: Este escudo otorga 10 pts de defensa
     * ConAnilloDraupnir: Este anillo multiplica el ataque x2
     */
   
   @Test
    public void quePuedoAgregarItemDeAtaque() {
 
        Personaje sigmund = new Humano();
        Assert.assertEquals(10, sigmund.getPuntosDeAtaqueFisico());
 
        // agrego item de ataque
        sigmund = new ConEspadaSkofnung(sigmund);
        Assert.assertEquals(10 * 2, sigmund.getPuntosDeAtaqueFisico());
    }
 
    /*---PRUEBAS DEL DECORATOR---*/
    
  /* @Test
    public void quePuedoAgregarAmbosItems() {
 
        Personaje sigmund = new Humano();
        Assert.assertEquals(1, sigmund.obtenerPuntosDeAtaque());
 
        // agrego item de ataque
        sigmund = new ConEspadaSkofnung(sigmund);
        Assert.assertEquals(5 + 1, sigmund.obtenerPuntosDeAtaque());
 
        Assert.assertEquals(0, sigmund.obtenerPuntosDeDefensa());
        sigmund = new ConEscudoSvalinn(sigmund);
        // agrego defensa
        Assert.assertEquals(10 + 0, sigmund.obtenerPuntosDeDefensa());
        // y no pierdo ataque
        Assert.assertEquals(5 + 1, sigmund.obtenerPuntosDeAtaque());
    }
    
    @Test
    public void quePuedoAgregarAmbosItemsInverso() {
 
        Personaje sigmund = new Humano();
        Assert.assertEquals(1, sigmund.obtenerPuntosDeAtaque());
 
        // agrego item de ataque
        Assert.assertEquals(0, sigmund.obtenerPuntosDeDefensa());
        sigmund = new ConEscudoSvalinn(sigmund);
        // agrego defensa
        Assert.assertEquals(10 + 0, sigmund.obtenerPuntosDeDefensa());
        
        sigmund = new ConEspadaSkofnung(sigmund);
        Assert.assertEquals(5 + 1, sigmund.obtenerPuntosDeAtaque());

        Assert.assertEquals(10 + 0, sigmund.obtenerPuntosDeDefensa());
    }
 
    
    @Test
    public void quePuedoAgregarDosTiposDeItem() {
        Personaje sigmund = new Humano();
        Assert.assertEquals(1, sigmund.obtenerPuntosDeAtaque());
 
        // agrego item de ataque
        sigmund = new ConEspadaSkofnung(sigmund);
        Assert.assertEquals(5 + 1, sigmund.obtenerPuntosDeAtaque());
 
        // agrego anillo multiplicador (x2)
        sigmund = new ConAnilloDraupnir(sigmund);
        Assert.assertEquals((5 + 1) * 2, sigmund.obtenerPuntosDeAtaque());
    }
    
    @Test
    public void quePuedoAgregarDosTiposDeItem2() {
        Personaje sigmund = new Humano();
        Assert.assertEquals(1, sigmund.obtenerPuntosDeAtaque());
 
        // agrego item de ataque
        sigmund = new ConEscudoSvalinn(sigmund);
        // agrego defensa
        Assert.assertEquals(10 + 0, sigmund.obtenerPuntosDeDefensa());
 
        // agrego anillo multiplicador (x2)
        sigmund = new ConAnilloDraupnir(sigmund);
        Assert.assertEquals((10 + 0) * 2, sigmund.obtenerPuntosDeDefensa());
    }
    
    /*---FIN PRUEBAS DEL DECORATOR---*/
    
 /*   @Test
    public void hechizo(){
    	Personaje elPibe = new Humano();
    	
    	Criatura criatura = new Criatura();
    	
    	criatura.lanzarSkill(elPibe, Habilidad.FUEGO);
    	
    	//elPibe curado con 50 de vitalidad
    	Assert.assertEquals((100 - 3), elPibe.getSalud());
    }
    
    //? Dado un usuario cuando este selecciona "crear personaje" entonces el personaje es creado.
    @Test
    public void creacionPersonaje(){
    	Usuario usuario = new Usuario("ferra", "pass1234");
    	Personaje elPibe = new Humano();
    	elPibe.setNombre("fede");
    	usuario.agregarPesonaje(elPibe);
    	
    	Assert.assertEquals(elPibe, usuario.getPersonaje("fede"));
    }
    
    //? Dado un usuario con 3 personajes creados cuando crea un cuarto personaje entonces este no se crea.
    @Test
    public void cantidadPersonajes(){
    	Usuario usuario = new Usuario("ferra", "pass1234");
    	Personaje elPibe = new Humano();
    	Personaje elPibe2 = new Orco();
    	Personaje elPibe3 = new Enano();
    	Personaje elPibe4 = new Humano();
    	elPibe.setNombre("ferra");
    	usuario.agregarPesonaje(elPibe);
    	elPibe2.setNombre("fede");
    	usuario.agregarPesonaje(elPibe2);
    	elPibe3.setNombre("doni");
    	usuario.agregarPesonaje(elPibe3);
    	elPibe4.setNombre("bri");
    	usuario.agregarPesonaje(elPibe4);
    	
    	Assert.assertNotEquals(elPibe4, usuario.getPersonaje("bri"));
    }
    
    @Test
    public void mago(){
    	Personaje elPibe = new Humano();
    	elPibe.setCasta(new Mago());
    	
    	Personaje ferra = new Orco();
    	System.out.println(ferra.getSalud());
    	
    	elPibe.lanzarSkill(ferra, Habilidad.CURAR);
    	System.out.println(ferra.getSalud());
    	
    	elPibe.lanzarSkill(ferra, Habilidad.FUEGO);
    	System.out.println(ferra.getSalud());
    	//Assert.assertEquals(elPibe, usuario.getPersonaje("fede"));
    }
    */
    @Test
    public void poderDobleOrco(){
    	Orco brian = new Orco();
    	brian.setCasta(new Mago());
    	
    	Enano maxi = new Enano();
    	maxi.setCasta(new Mago());
    	
    	System.out.println(brian.getPuntosDeAtaqueMagico());
    	
    	System.out.println(maxi.getSalud());
    	for (int i=0; i<10;i++){
    	brian.lanzarSkill(maxi, Habilidad.FUEGO);
    	maxi.lanzarSkill(brian, Habilidad.FUEGO);
    	System.out.println(maxi.getSalud());
    	}
    }
}
