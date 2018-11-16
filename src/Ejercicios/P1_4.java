package Ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

//	 A) -------------------------------ITERATIVA----------------------------------------

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
	// B)
	// -------------------------------------------JAVA10----------------------------------------------------

	public static Integer pos1 = 0, pos2 = 0;

	public static List<Integer> ordenadaJAVA10(List<Integer> l1, List<Integer> l2) {

		return IntStream.range(0, l1.size() + l2.size()).boxed().map(c -> compara(l1, l2)).collect(Collectors.toList());

	}

	private static Integer compara(List<Integer> l1, List<Integer> l2) {
		Integer res = 0;
		if (l1.size() == pos1) {
			res = l2.get(pos2);
			pos2++;
		} else if (l2.size() == pos2) {
			res = l1.get(pos1);
			pos1++;
		} else if (l1.get(pos1) < l2.get(pos2)) {
			res = l1.get(pos1);
			pos1++;
		} else if (l2.get(pos2) < l1.get(pos1)) {
			res = l2.get(pos2);
			pos2++;
		} else if (l1.get(pos1) == l2.get(pos2)) {
			res = l1.get(pos1);
			pos1++;

		}
		return res;
	}
	// C)-----------------------------------------RECURSIVO---------------------------------------------------
//Tdo lo que esta encima del while se pone en la cabecera, y se llama al metdo para incrementar

	public static List<Integer> ordenadaRecursivo(List<Integer> l1, List<Integer> l2, List<Integer> res, Integer a,
			Integer b) {

		Integer d = (l1.size() + l2.size()) - 1;
		if (res.size() > d) {
			return res;
		} else if (a == l1.size() || l1.get(a) > l2.get(b)) {
			res.add(l2.get(b));
			return ordenadaRecursivo(l1, l2, res, a, b + 1);
		} else if (b == l2.size() || l1.get(a) < l2.get(b)) {
			res.add(l1.get(a));
			return ordenadaRecursivo(l1, l2, res, a + 1, b);

		} else {
			res.add(l1.get(a));
			res.add(l2.get(b));
			return ordenadaRecursivo(l1, l2, res, a + 1, b + 1);

		}
	}

	// -------------------------------------------TESTS----------------------------------------------------

	public static void main(String[] args) {
		List<Integer> a = new ArrayList<>();
		List<Integer> b = new ArrayList<>();
		List<Integer> res = new ArrayList<>();

		a.add(1);
		a.add(4);
		a.add(6);

		b.add(2);
		b.add(4);
		b.add(16);

		System.out.println("Iterativo: " + ordenada(a, b));
		System.out.println("JAVA 10:   " + ordenadaJAVA10(a, b));
		System.out.println("Recursivo: " + ordenadaRecursivo(a, b, res, 0, 0));
	}

}
