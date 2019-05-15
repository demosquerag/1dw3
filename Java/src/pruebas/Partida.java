package pruebas;

public class Partida {

	// Necesidades previas
	private String equipolocal;
	private String equipovisitante;
	private Integer resultadoequipolocal;
	private Integer resultadoequipovisitante;
	
	// Metodo personalizado
	public Partida(String l, String v, int rl, int rv) {
		this.equipolocal = l;
		this.equipovisitante = v;
		this.resultadoequipolocal = rl;
		this.resultadoequipovisitante = rv;
	}

	@Override
	public String toString() {
		return (this.equipolocal + "  " + this.resultadoequipolocal + " = " + this.resultadoequipovisitante + "  " + this.equipovisitante);
	}
	
	

}
