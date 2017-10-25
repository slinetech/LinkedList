package app;

import linkedlist.LinkedList;
import node.Node;

public class App {

	public static void main(String[] args) {
		LinkedList<String> names = new LinkedList<String>();
		LinkedList<String> lastnames = new LinkedList<String>();
		LinkedList<Integer> ages = new LinkedList<Integer>(19);

		names.addLast("Pedro");
		names.addBefore("kike");
		names.addLast2("Xavi");
		names.addBefore("ricardos");
		names.addBefore("ana");
		names.addLast("Juan");

		names.pronter();//Imprimiendo valor
		
		names.addBefore("ana", "Xavi");
		names.addAfter("kike", "Oscar");
		
		System.out.println();
		names.pronter();
		
		//names.remplace(4, "pepe");
		//names.remove("ana");
		//names.addFirst("Milton");
		
		//Buscando valor que si esta en la lista
		Node<String> name= names.serch("kike");
		if (name!=null) {
			System.out.println("Valor buscado :" +name.getValue()+"\n");
		}else {
			System.out.println("Valor no encontrado");
		}
		//Buscando valor que no esta en la lista
		Node<String> name2= names.serch("luis");
		if (name2!=null) {
			System.out.println("Valor buscado :" +name2.getValue()+"\n");
		}else {
			System.out.println("\nValor no encontrado\n");
		}
		//names.pronter();//Imorimiendo valor

		
		names.removeBefore("ricardos");
		System.out.println();
		names.pronter();
		
		
		names.removeAfter("Juan");
		System.out.println();
		names.pronter(); 
		
		System.out.println();
		names.list();
		
		names.clear();//Limpiamos la Lista
		//Verificamos si esta vacia
		if (names.isEmpty()) { 
			System.out.println("Esta vasia"); 
		}else {
			System.out.println("Tiene datos"); 
		}
		//Imprimimos la lista
		System.out.println();
		names.pronter();
		
		

		System.out.println("no hay error! no hay error!, el dinero es dinero!");
	}

}
