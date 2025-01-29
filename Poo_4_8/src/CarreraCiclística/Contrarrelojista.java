package CarreraCiclística;

public class Contrarrelojista extends Ciclista{
	private double velocidadMaxima;
	
public Contrarrelojista(int identificador, String nombre, double velocidadMaxima) {
	super(identificador, nombre);
	this.velocidadMaxima = velocidadMaxima;
}
	
protected double getVelocidadMaxima() {
	return velocidadMaxima;
}
protected void setVelocidadMaxima(double velocidadMaxima) {
	this.velocidadMaxima = velocidadMaxima;
}
	
protected void imprimir() {
	super.imprimir();
	System.out.println("Aceleracion promedio: " + velocidadMaxima);
}

protected String imprimirTipo() {
	return "Es un contrarrelojista";
}

}
