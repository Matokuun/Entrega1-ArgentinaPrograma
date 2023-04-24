package tp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		String archivo ="a";
		String archivo2= "b";
		if (args.length > 2) { //si hay más de 1 parámetro
            System.out.println("Hay demasiados parámetros. Debe escribir: Main rutaResultados rutaPronostico");
        } else if (args.length == 0) { //si no hay parámetros      
            System.out.println("Faltan las rutas (resultados y pronostico)");                                                  
        } else {
        	archivo= args[0];
        	archivo2= args[1];
        }
		
		//rutaResultados "C:\\Users\\PC\\Documents\\mati studio\\ArgentinaPrograma\\src\\tp\\resultados.csv";
		//rutaPronostico "C:\\Users\\PC\\Documents\\mati studio\\ArgentinaPrograma\\src\\tp\\pronostico.csv";
		
		ArrayList<Partido> partidosRonda= new ArrayList<Partido>();
		Ronda r= new Ronda(partidosRonda,"1");
		Pronostico pronostico= new Pronostico();
		try {
			for (String linea : Files.readAllLines(Paths.get(archivo))){
				String [] lineaCortada= linea.split(",");
				Equipo e1= new Equipo(lineaCortada[0],"seleccion nacional");
				Equipo e2= new Equipo(lineaCortada[3],"seleccion nacional");
				Partido p= new Partido(e1,e2,Integer.parseInt(lineaCortada[1]),Integer.parseInt(lineaCortada[2]));
				partidosRonda.add(p);
			}
			r.setPartidos(partidosRonda);
			System.out.println(r.toString()+"\n");
			int i=0;
			for (String linea : Files.readAllLines(Paths.get(archivo2))){
				String [] lineaCortada= linea.split(",");
				System.out.println(lineaCortada[0] + " - "+ lineaCortada[4]);
				Equipo e1= new Equipo(lineaCortada[0],"seleccion nacional");
				Equipo e2= new Equipo(lineaCortada[4],"seleccion nacional");
				Partido partido=r.getPartidos().get(i);
				if(lineaCortada[1].equals("x")) {
					pronostico.setEquipo(e1);
					ResultadoEnum resReal = partido.resultado(e1);
					ResultadoEnum resPronosticado = ResultadoEnum.GANADOR;
					pronostico.setResultado(resPronosticado);
					if(resReal == resPronosticado) {
						pronostico.incrementarPunto();
					}
				}else {
					if(lineaCortada[2].equals("x")) {
						pronostico.setEquipo(e1);
						ResultadoEnum resReal = partido.resultado(e1);
						ResultadoEnum resPronosticado = ResultadoEnum.EMPATE;
						pronostico.setResultado(resPronosticado);
						if(resReal == resPronosticado) {
							pronostico.incrementarPunto();
						}
					}
					else {
						pronostico.setEquipo(e2);
						ResultadoEnum resReal = partido.resultado(e2);
						ResultadoEnum resPronosticado = ResultadoEnum.GANADOR;
						pronostico.setResultado(resPronosticado);
						if(resReal == resPronosticado) {
							pronostico.incrementarPunto();
						}
					}
				}
				System.out.println("Puntos actuales: "+ pronostico.getPuntos());
				pronostico.setPartido(r.getPartidos().get(i));
				i++;
			}
			
		}
		catch (Exception e){
			System.out.println("no se encontro ningun archivo: " + e);
		}
		finally{
			System.out.println("Finalizado. Puntaje: "+ pronostico.getPuntos());
		}
	}

}
