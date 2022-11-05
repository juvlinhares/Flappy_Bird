
public class Passaro {

	//coordenadas
	public double x, y;
	
	//velocidade
	public double velocidadeY;
	
	//constantes:
	
	public static double GRAVIDADE = 500;
	public static double FLAP = - 300;
	
	
	
	public Passaro(double x, double y) {
		this.x = x;
		this.y = y;
	}



	//desenhar o pássaro:
	public void desenhar(Tela t) {
		t.imagem("flappy.png", 528, 128, 34, 24, 0, x, y);
	}

}
