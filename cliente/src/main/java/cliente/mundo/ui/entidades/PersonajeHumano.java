package cliente.mundo.ui.entidades;

import cliente.mundo.ui.IDibujable;
import cliente.mundo.ui.math.MathUtils;

import java.awt.*;


public class PersonajeHumano implements IDibujable {

	private AnimableIsometrico animable;
	private Point posicion;
	private String nombre;

	public PersonajeHumano(String nombre){
		this.nombre = nombre;
		this.posicion = new Point(1,1);

		AnimableIsometricoBuilder builder = new AnimableIsometricoBuilder();
		builder.puntoInicial = posicion;
		builder.rutaImagenStandBy1 = "/home/gparis/IdeaProjects/jrpg/cliente/src/main/resources/Texturas/HumanoStb1.png";
		builder.rutaImagenStandBy2 = "/home/gparis/IdeaProjects/jrpg/cliente/src/main/resources/Texturas/HumanoStb2.png";
		builder.rutaImagenDiagonalDerecha = "/home/gparis/IdeaProjects/jrpg/cliente/src/main/resources/Texturas/HumanoDiagDer.png";
		builder.rutaImagenDiagonalIzquierda = "/home/gparis/IdeaProjects/jrpg/cliente/src/main/resources/Texturas/HumanoDiagIzq.png";
		builder.rutaImagenBajaIzquierda ="/home/gparis/IdeaProjects/jrpg/cliente/src/main/resources/Texturas/HumanoBajaIzq.png";
		builder.rutaImagenBajaDerecha ="/home/gparis/IdeaProjects/jrpg/cliente/src/main/resources/Texturas/HumanoBajaDer.png";

		this.animable = new AnimableIsometrico(builder);

	}

	@Override
	public void paintComponent(Graphics g, Rectangle r) {


			double xRelativo =  this.posicion.getX() -r.getX();
			double yRelativo = this.posicion.getY() -r.getY();
			double tamRegionX = g.getClipBounds().getWidth()/r.getWidth();
			double tamRegionY = g.getClipBounds().getHeight()/r.getHeight();

			Graphics2D g2d = (Graphics2D) g.create();

			int posOgroX = (int) ( xRelativo * tamRegionX);
			int posOgroY = (int) ( yRelativo * tamRegionY);
			Point puntoTransformado = MathUtils.twoDToIso(new Point(posOgroX,posOgroY));

	        g2d.drawImage(animable.getFrame(),(int)puntoTransformado.getX(),(int)puntoTransformado.getY(),100,100,null);
	       	g2d.setColor(Color.WHITE);
	        g2d.drawString(this.nombre+"("+posicion.getX()+";"+posicion.getY()+")",(int)puntoTransformado.getX()+25,(int)puntoTransformado.getY()+20);
	        g2d.setColor(Color.RED);
	        g2d.fillRect((int)puntoTransformado.getX()+30,(int)puntoTransformado.getY()+25,50,2);
	        g2d.setColor(Color.green);
	        g2d.fillRect((int)puntoTransformado.getX()+30,(int)puntoTransformado.getY()+25,25,2);
	        g2d.dispose();


	}

	@Override
	public Point getPos() {
		return posicion;
	}



	@Override
	public void setPos(Point pt) {
		this.animable.actualizarPosicion(pt);
		this.posicion = pt;
	}
}
