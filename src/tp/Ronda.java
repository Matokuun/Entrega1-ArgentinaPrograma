package tp;

import java.util.ArrayList;

public class Ronda {
	private ArrayList<Partido> partidos;
	private String nro;
	
	public Ronda(ArrayList<Partido> p, String n) {
		setPartidos(p);
		setNro(n);
	}

	public ArrayList<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(ArrayList<Partido> partidos) {
		this.partidos = partidos;
	}

	public String getNro() {
		return nro;
	}

	public void setNro(String nro) {
		this.nro = nro;
	}
	public int puntos() {
		return 20;//ver puntos
	}
	public String toString() {
		String str= "\nRonda "+ nro;
		for(Partido p: this.partidos) {
			str= str + "\n" + p.getEquipo1().getNombre() + " " + p.getGolesEquipo1() + " - " + p.getGolesEquipo2() + " "+ p.getEquipo2().getNombre();
		}
		return str;
	}
}
