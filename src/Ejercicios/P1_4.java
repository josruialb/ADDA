package Ejercicios;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class P1_4 {

//PI1.4- Dadas dos listas ordenadas obtener otra cadena ordenada que contenga los elementos de las dos 
	// anteriores (fusión de listas).
	// a) Implementar una solución iterativa (C y JAVA).
	// b) Implementar una solución con stream en JAVA 10.
	// c) Implementar una solución recursiva lineal final (C y JAVA).
	// d) Definir los tamaños y calcular los T(n) para las distintas funciones
	// implementadas considerando los casos mejor y peor.

	// List<String> lineas =
	// Files.lines(Paths.get("//.txt")).collect(Collectors.toList());
	// Iterator<String> it= lineas.iterator();
	// while(it.hasNext()) {
	// string linea = it.next(); }

	public static List<Integer> ordenada(List<Integer> a, List<Integer> b) {
		List<Integer> res = new ArrayList<>();
		Integer i = 0;
		Integer i2 = 0;
		while (i <= a.size() - 1 && i2 <= b.size() - 1) {
			if (a.get(i) < b.get(i2)) {
				res.add(a.get(i));
				if(i>a.size()-1) {
					res.add(b.get(i));
				}
					
					i++;

		}			else if (a.get(i) > b.get(i2)) {
				res.add(b.get(i2));
			if(i2>b.size()-1) {
					res.add(a.get(i2));
				}
					i2++;

		}

				
		}
		return res;
	
		}
	
	
	public static List<Integer> ordenadaJAVA10(List<Integer> a, List<Integer> b) {
			
		List<Integer> res = Stream.concat(a.stream(), b.stream())
				.sorted()
				.collect(Collectors.toList());
		return res;

	}

	public static void main(String[] args) {
		List<Integer> a = new ArrayList<>();
		List<Integer> b = new ArrayList<>();
		a.add(1);
		a.add(3);
		a.add(6);
	
		b.add(2);
		b.add(4);
		b.add(16);
		
		System.out.println(ordenada(a, b));
		//System.out.println(ordenadaJAVA10(a, b));
	}

}
