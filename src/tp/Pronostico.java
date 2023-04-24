package tp;

public class Pronostico {
	private Partido partido;
	private Equipo equipo;
	private ResultadoEnum resultado;
	private int puntos= 0;
	
	public Pronostico() {
		
	}
	public Pronostico(Partido p, Equipo e, ResultadoEnum res, int pu) {
		this.setPartido(p);
		this.setEquipo(e);
		this.setResultado(res);
		this.setPuntos(pu);
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo e) {
		this.equipo = e;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public ResultadoEnum getResultado() {
		return resultado;
	}

	public void setResultado(ResultadoEnum resultado) {
		this.resultado = resultado;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public void incrementarPunto() {
		this.puntos = this.puntos + 1;
	}
	public String toString() {
		return "a";
	}
}
