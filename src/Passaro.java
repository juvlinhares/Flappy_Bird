
public class Passaro {

	//coordenadas
	public double x, y;
	
	//velocidade
	public double velocidadey = 0;
	
	//constantes:
	
	public static double GRAVIDADE = 800;
	public static double FLAP = - 300;
	
	
	
	public Passaro(double x, double y) {
		this.x = x;
		this.y = y;
	}

	//movimento do passaro no eixo y
	public void atualiza(double dt) {
		velocidadey += GRAVIDADE * dt;
		y += velocidadey * dt;

	}

	//função que anula a queda quando chamada/ativada, faz o passaro subir  
	public void flap() {
	
		velocidadey = FLAP;
	}
	

	//desenhar o pássaro/ rotação do pássaro( Math.atan):
	public void desenhar(Tela t) {
		t.imagem("flappy.png", 528, 128, 34, 24, Math.atan(velocidadey / 300), x, y);
	}

}
