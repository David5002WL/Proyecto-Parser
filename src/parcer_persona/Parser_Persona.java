package parcer_persona;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.transform.TransformerException;

public class Parser_Persona {

	public static void main(String[] args) {

		Parser parser = new Parser();
		int x = 1;
		while (x != 0) {
			Scanner sn = new Scanner(System.in);

			System.out.println("\n-------MENU-------");
			System.out.println("1.Parsear un fichero XML");
			System.out.println("2.Serializar un objeto");
			System.out.println("0.Salir");

			x = sn.nextInt();
			switch (x) {

			case 1:
				
				System.out.println("Introduce el fichero XML: ");
				String fichero = sn.next();
				parser.parseFicheroXml(fichero);
				break;
			
			case 2:
				
				System.out.println("Introduce el Titulo: ");
				String titulo = sn.next();
				System.out.println("Introduce el Autor: ");
				String autor = sn.next();
				System.out.println("Introduce el Año: ");
				String anyo = sn.next();
				System.out.println("Introduce el Editor: ");
				String editor = sn.next();
				System.out.println("Introduce las Paginas: ");
				String paginas = sn.next();
				
				Libro l = new Libro(titulo, titulo, autor, anyo, editor, paginas);
				
				ArrayList<Libro> libros = new ArrayList<Libro>();
				libros.add(l);
				
				
				Marshaller marshaller = new Marshaller(libros);
				
				marshaller.crearDocumento();
				marshaller.crearArbolDOM();
				
				File file = new File("biblioteca2.xml");
				
				try {
					marshaller.escribirDocumentAXml(file);
				} catch (TransformerException e) {			
					e.printStackTrace();
				}
				break;
			}

		}
		
	
	}

}
