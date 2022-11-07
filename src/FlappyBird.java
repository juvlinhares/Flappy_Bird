
public class FlappyBird implements Jogo {

	// velocidade de movimentação do chao(igual a dos canos)
	public double ground_offset = 0;
	public double gvx = 70;

	public double sky = 0;
	public double gvy = 70;

	// criar o pássaro:
	public Passaro passaro;

	// construtor da classe principal:

	public FlappyBird() {
		passaro = new Passaro(35, (getLargura() - 112) / 2 + 24 / 2);
	}

	public String getTitulo() {
		return "Flappy Bird";
	}

	public int getLargura() {
		return 384;
	}

	public int getAltura() {
		return 521;
	}

	public void tecla(String tecla) {
		if(tecla.equals(" ")) {
			passaro.flap();
		}
	}

	//tudo que depende do tempo, alteração de frames
	public void tique(java.util.Set<String> teclas, double dt) {
		ground_offset += dt * gvx;
		ground_offset = ground_offset % 308;
		sky += dt * gvy;
		sky = sky % 288;
		
		passaro.atualiza(dt);

	}

	//tudo que for relacionado a desenhos:
	public void desenhar(Tela t) {
		// background:
		t.imagem("flappy.png", 0, 0, 288, 512, 0, -sky, 0);// 0, 0, 288, 512=> recorte background, 0, 0, 0=> rotação,
															// eixos x e y
		t.imagem("flappy.png", 0, 0, 288, 512, 0, 288 - sky, 0);// complemento do background
		t.imagem("flappy.png", 0, 0, 288, 512, 0, 288 * 2 - sky, 0);

		// chao
		t.imagem("flappy.png", 292, 0, 308, 112, 0, -ground_offset, getAltura() - 112);
		t.imagem("flappy.png", 292, 0, 308, 112, 0, 308 - ground_offset, getAltura() - 112);
		t.imagem("flappy.png", 292, 0, 308, 112, 0, 308 * 2 - ground_offset, getAltura() - 112);

		passaro.desenhar(t);

	}

	public static void main(String[] args) {
		roda();
	}

	private static void roda() {
		new Motor(new FlappyBird());

	}
}
