import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Capture two numeric values ​​by keyboard in variables and print the sum and the multiplication.
 * 
 * @author manuel
 *
 */
public class PLA1_Exercises {

	public static void main(String[] args) {
		DecimalFormat decFmt = new DecimalFormat("0");
		decFmt.setMaximumFractionDigits(340);
		short age = 0, height = 0;
		int sum = 0, idx = 0, cnt = 0;
		double a = 0, b = 0;
		char chr = 0;
		Short numShort = 0;
		Double numDouble = 0d;
		String str = "", str1= "", str2 = "", prompt = "";
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		exerciseHeader("Variables, tipos de datos, operadores.");

		System.out.println("INTRODUZCA DOS NÚMEROS CON LOS QUE OPERAR.\n");
		
		a = KeyboardInput.getDouble("Introduzca el primer número");
		b = KeyboardInput.getDouble("Introduzca el segundo número");
		
		System.out.println("\nLa suma de " + decFmt.format(a) + " y " + decFmt.format(b) + " es " + decFmt.format(a + b) + ".");
		System.out.println("La multiplicación " + decFmt.format(a * b) + ".");
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		exerciseHeader("Estructuras condicionales.");
		
		System.out.println("INTRODUZCA LOS DATOS DEL NIÑO. PASARÁ CON MÁS DE: 16 AÑOS o 140cm.\n");

		age = KeyboardInput.getShort("Edad (años)");
		height = 0;
		
		if(age <=16)
			height = KeyboardInput.getShort("Altura (centímetros)");
		
		if(age > 16 || height > 140) // If the age is ok the height is not evaluated 
			System.out.println("\nEl niño puede entrar en la atracción.");
		else
			System.out.println("\nEl niño no puede entrar en la atracción. Es menor de 17 años y mide menos de 141 centímetros.");
	
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		exerciseHeader("Bucles. Ejercicio 1.");

		numDouble = null;
		prompt = "Introduzca un número entre el 1 y el 10";
		
		do 
			if( numDouble != null)
				System.out.println("\nNÚMERO MENOR QUE UNO O MAYOR QUE 10.");
		while((numDouble = Double.valueOf(KeyboardInput.getDouble(prompt))) < 1 || numDouble > 10); // First execute the content of the 
				//internal parenthesis and evaluate it as the final value of numDouble
		System.out.println("\nSe ha introducido el número " + decFmt.format(numDouble) + ".");
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		exerciseHeader("Bucles. Ejercicio 2.");

		str = KeyboardInput.getString("Introduzca una cadena no vacía").toUpperCase();
		idx = 0;
		cnt = 0;
		
		while((idx = str.indexOf("A", idx) + 1) > 0) // First execute the content of the 
			//internal parenthesis and evaluate it as the final value of idx
			cnt++;
		if(cnt == 0)
			System.out.println("\nLa letra \"a/A\" no aparece en el texto.");
		else if(cnt == 1)
			System.out.println("\nLa letra \"a/A\" solo aparece una vez en el texto.");
		else
			System.out.println("\nLa letra \"a/A\" se repite " + cnt + " veces.");

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		exerciseHeader("Bucles. Ejercicio 3.");

		numShort = null;
		prompt = "Introduzca un entero corto mayor que uno";
		
		do 
			if(numShort != null)
				System.out.print("¡¡NÚMERO MENOR QUE DOS!!");
		while((numShort = Short.valueOf(KeyboardInput.getShort(prompt))) <= 1); // First execute the content of the 
				//internal parenthesis and evaluate it as the final value of numShort
		System.out.println("\nLa suma de los " + numShort + " primeros enteros es " + decFmt.format(numShort * ++numShort / 2) + ".");
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		exerciseHeader("Métodos en Java. Ejercicio 1.");

		System.out.println("INTRODUZCA DOS CADENAS NO VACÍAS.\n");

		str1 = KeyboardInput.getString("Primera cadena no vacía");
		str2 = KeyboardInput.getString("Segunda cadena no vacía");
		str = masLarga(str1, str2);
		
		if(str != null)
			System.out.println("\nLa cadena más larga es: \"" + str + "\".");
		else
			System.out.println("\nAmbas cadenas son igual de largas.");

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		exerciseHeader("Métodos en Java. Ejercicio 2.");
		
		System.out.println("BUSCAR UN CARACTER DENTRO DE UNA CADENA.\n");

		chr = KeyboardInput.getChar("Introduzca el carácter a buscar");
		str = KeyboardInput.getString("Introduzca la cadena donde buscar");
		cnt = 0;
		
		if((cnt = veces(chr, str)) == 0)
			System.out.println("\nEl carácter \"" + chr + "\" no aparece en el texto.");
		else if(cnt == 1)
			System.out.println("\nEl carácter \"" + chr + "\" solo aparece una vez en el texto.");
		else
			System.out.println("\nEl carácter \"" + chr + "\" se repite " + cnt + " veces.");
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		exerciseHeader("Arrays. Ejercicios 1 y 2.");

		System.out.println("INTRODUZCA 10 NÚMEROS ENTEROS ENTRE EL UNO Y EL DIEZ PARA INTRODUCIR EN UN ARRAY.\n");

		prompt = "Valor número ";
		numShort = null;
		sum = 0;
		short[] arrShort = new short[10];
		
		for(short i = 0; i<10; i++) {
			do 
				if(numShort != null)
					System.out.print("NÚMERO MENOR QUE UNO O MAYOR QUE 10. ");
			while( ( numShort = Short.valueOf( (arrShort[i] = KeyboardInput.getShort(prompt + (i+1)) ) ) ) < 1 || arrShort[i] > 10); // First execute the content of the 
					//internal parenthesis and evaluate it as the final value of numShort
			numShort = null;
		}
		Arrays.sort(arrShort);
		for(short i = 0; i < arrShort.length/2; i++) {
			numShort =  arrShort[i];
			arrShort[i] = arrShort[arrShort.length - 1 - i];
			arrShort[arrShort.length - 1 - i] = numShort;
		}
		for(short s : arrShort)
			sum += s;
		System.out.println("\nLa suma de los valores introducidos es " + decFmt.format(sum) + ".");
		System.out.print("\nEl array ordenado descendentemente es " );
		str = "[";
		for(short s: arrShort)
			str += s + ", ";
		str = str.substring(0, str.length() - 2) + "]";
		System.out.println(str);

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		exerciseHeader("Arrays. Ejercicio 3.");
		
		System.out.println("INTRODUZCA 5 NOMBRES DE PRODUCTOS NO REPETIDOS PARA INTRODUCIR EN UN ARRAY.\n");

		String[] arrString = new String[5]; 
		prompt = "Introduzca el producto número ";

		//
		// Case sensitive 
		//for(short i = 0; i<5; i++) {
		//	str = KeyboardInput.getString(prompt + (i+1));
		//	if(Arrays.asList(arrString).contains(str)) {
		//		System.out.print("PRODUCTO REPETIDO. ");
		//		i--;
		//		continue;
		//	}
		//	arrString[i] = str;
		//}
		//
		for(short i = 0; i<5; i++) {
			str = KeyboardInput.getString(prompt + (i+1));
			cnt = 0;
			for (short j = 0; j < i; j++)
				if(arrString[j].toUpperCase().equals(str.toUpperCase()))
					cnt++;
			if(cnt > 0) {
				System.out.print("PRODUCTO REPETIDO. ");
				i--;
				continue;
			}
			arrString[i] = str;
		}
		System.out.print("\nEl array con los productos es " );
		str = "[";
		for(String s: arrString)
			str += "\"" + s + "\", ";
		str = str.substring(0, str.length() - 2) + "]";
		System.out.println(str);

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		exerciseHeader("ArrayList. Ejercicio 1.");
		
		System.out.println("INTRODUZCA NÚMEROS ENTEROS ENTRE 1 Y 10 PARA INTRODUCIR EN UN ARRAYLIST Y TRATARLOS.\n");

		ArrayList<Short> alsShort=new ArrayList<Short>();
		prompt = "Valor entero entre uno y diez. Cero para terminar";
		sum = 0;
		
		do {
			numShort = null;
			do 
				if(numShort != null)
					System.out.print("NÚMERO MENOR QUE CERO O MAYOR QUE 10. ");
			while( (numShort = Short.valueOf(KeyboardInput.getShort(prompt) ) ) < 0 || numShort > 10); // First execute the content of the 
					//internal parenthesis and evaluate it as the final value of numShort
			if(numShort > 0)
				alsShort.add(numShort);
		}while(numShort > 0);
		System.out.println("\nEl número de valores introducidos es de " + alsShort.size());
		str = "[";
		for(short s: alsShort) {
			sum += s;
			if(s%2 == 0)
				str += s + ", ";
		}
		str = str.substring(0, str.length() - 2) + "]";
		System.out.println("Los valores pares son " + str + ".");
		System.out.println("La suma de todos los valores es " + sum + ".");

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		exerciseHeader("ArrayList. Ejercicio 2.");

		System.out.println("INTRODUZCA UNA FRASE PARA ANALIZAR.\n");

		ArrayList<String> alsString=new ArrayList<String>();
		str = KeyboardInput.getString("");
		str1 = "";
		cnt = 0;
		Scanner scn = new Scanner(str);
		// In addition to spaces I search for words separated by punctuation marks, quotes, etc.
		scn.useDelimiter("\\W+");
		
		while(scn.hasNext()) 
			alsString.add(scn.next());
		for(String s: alsString)
			if(s.length() > str1.length())
				str1 = s;
		System.out.println("\nIntroducidas " + alsString.size() + " palabras.");
		System.out.println("La palabra más larga es \"" + str1 + "\".");
		
		scn.close();
	}
		
	/**
	 * Prints a header for the exercise
	 * @param text Header forthe exxercise
	 */
	private static void exerciseHeader(String text) {
		System.out.println("\n" + new String(new char[79]).replace("\0", "*"));
		System.out.println("********");
		System.out.println("********        " + text);
		System.out.println("********");
		System.out.println();
	}
	
	/**
	 * Returns the longest string or null if they have the same length
	 * @param str1 First string to compare
	 * @param str2 Second string to compare
	 * @return The longest string or null
	 */
	private static String masLarga(String str1, String str2) {
		// Let's complicate it a bit 
		return (str1.length() > str2.length()) ? str1 : ((str2.length() > str1.length()) ? str2 : null);
	}
	
	/**
	 * Returns the number of times chr appears in str
	 * @param chr The char to look for
	 * @param str The string where to look
	 * @return The number of times chr appears in str
	 */
	private static int veces(char chr, String str) {
		int idx = 0, cnt = 0;
		while((idx = str.indexOf(chr, idx) + 1) > 0) // First execute the content of the 
			//internal parenthesis and evaluate it as the final value of idx
			cnt++;
		return cnt;
	}
}
