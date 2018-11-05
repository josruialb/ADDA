package Ejercicios;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;
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

	public static List<Integer> ordenada(List<Integer> l1, List<Integer> l2) {
		List<Integer> res = new ArrayList<>();
		Integer i = 0;
		Integer i2 = 0;

		Integer d = (l1.size() + l2.size()) - 1;

		while (res.size() <= d) {
			if (i == l1.size() || l1.get(i) > l2.get(i2)) {
				res.add(l2.get(i2));

				i2++;

			} else if (i2 == l2.size() || l1.get(i) < l2.get(i2)) {
				res.add(l1.get(i));

				i++;

			} else {
				res.add(l1.get(i));
				res.add(l2.get(i2));
				i++;
				i2++;

			}

		}
		return res;

	}

	public static List<Integer> ordenadaJAVA10(List<Integer> a, List<Integer> b) {

		List<Integer> res = Stream.concat(a.stream(), b.stream()).sorted().collect(Collectors.toList());
		return res;

	}

	public static void main(String[] args) {
		List<Integer> a = new ArrayList<>();
		List<Integer> b = new ArrayList<>();
		a.add(1);
		a.add(4);
		a.add(6);

		b.add(2);
		b.add(4);
		b.add(16);

		System.out.println(ordenada(a, b));
		// System.out.println(ordenadaJAVA10(a, b));
	}

}
