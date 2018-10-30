package Ejercicios;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class P1_1 {

//P1.1-Dada una lista de String buscar la cadena que tiene un mayor número de caracteres en minúscula.
//a) Implementar una solución iterativa (C y JAVA).  X/2
//b) Implementar una solución con stream en JAVA 10.   X
//c) Implementar una solución recursiva lineal final (C y JAVA).  
//d) Definir los tamaños y calcular los T(n) para las distintas funciones implementadas considerando los casos mejor y peor.   

	
//	 A) -------------------------------ITERATIVA----------------------------------------
	
	public static Integer cuentaMinus(String minusculas) {
		Integer contMinus = 0;
		Integer contLetra = 0;
		while (contLetra < minusculas.length()) {
			if (!(Character.isUpperCase(minusculas.charAt(contLetra)))) {
				contMinus++;
				contLetra++;
			} else {
				contLetra++;
			}
		}
		return contMinus;
}

	public static String Iterativo1(List<String> ls) {
	    Integer i = 0;
		String palabra = null;
		Integer comp = 0;
		while (i < ls.size()-1 ) {
			if(cuentaMinus(ls.get(i))<cuentaMinus(ls.get(i+1))){
				if(cuentaMinus(ls.get(i+1))  > comp) {
					comp = cuentaMinus(ls.get(i+1));
					palabra = ls.get(i+1);
				}	
				
			}else {
				if(cuentaMinus(ls.get(i))  > comp) {
					comp = cuentaMinus(ls.get(i));
					palabra = ls.get(i);
				}	
			}
			i++;
		}
		return palabra;
		
	}
//B) -------------------------------------------JAVA10----------------------------------------------------

	
	public static Integer cuentaCaracteresJ10(String s) {
		return (int)Stream.iterate(0,x->x+1)
				.limit(s.length())
				.filter(x-> Character.isLowerCase(s.charAt(x)))
				.count();
				
	}
	
	
	
	public static String java10(List<String> ls) {
		return ls.stream()
				.max(Comparator.comparingInt(x->cuentaCaracteresJ10(x)))
				.get();
		
				
	}
//C)-----------------------------------------RECURSIVO---------------------------------------------------
	public static Integer cuentaMinRec(String n, Integer a, Integer i) {
		if (n.length() == i) {
			return a;
		}else if (!(Character.isUpperCase(n.charAt(i)))) {
			return cuentaMinRec(n, a + 1, i + 1);
		} else {
			return cuentaMinRec(n, a, i + 1);
		}
	}
	

	public static String Ej1RecFinal(List<String> ls, String g, Integer i) {
		if (ls.size() == 1) {
			return ls.get(i);
		}else if(ls.size()-1 == i) {
			return g;
		}else if (cuentaMinRec(ls.get(i), 0, 0) < cuentaMinRec(ls.get(i + 1), 0, 0)) {
			if(cuentaMinRec(ls.get(i+1), 0, 0) > cuentaMinRec(g, 0, 0)) {
				return Ej1RecFinal(ls, ls.get(i+1), i+1);
			}
			return Ej1RecFinal(ls, g, i+1);
		} else {
			return Ej1RecFinal(ls,ls.get(i), i+1);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> e1 = new ArrayList<>();
		e1.add("aaaaaaa");
		e1.add("eedf");
		e1.add("aaaaasvdsvsdvsab");
		e1.add("aaweFFFFsaaa");
		e1.add("DDsssDDDD");
		
		
	//	System.out.println(cuentaMinRecursivo("PpepPe", 0, 0));
		
		System.out.println(Ej1RecFinal(e1, "", 0));
		
	//System.out.println(java10(e1));

	//System.out.println(Iterativo1(e1));

		// String a = "pepe";
		// System.out.println(devuelveMinus(a));

	}

}
