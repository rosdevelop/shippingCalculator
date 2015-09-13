
import java.util.Scanner;

public class CalculadoraDeFletes{
	private static Scanner scanner;

	public static double obtenerPrecioDePesosEnKilos(double pesoKilo) {
		double tarifaDolares = 0.0;
		if(pesoKilo >= 0.01 && pesoKilo <= 0.99){
			tarifaDolares = 9.30;
		} else if(pesoKilo >= 1.00 && pesoKilo <= 4.99){
			tarifaDolares = 9.30;
		} else if(pesoKilo >=5 && pesoKilo <= 9.99 ){
			tarifaDolares = 25.85;		
		} else if(pesoKilo >=10 && pesoKilo <= 14.99){
			tarifaDolares = 50.15;
		} else if(pesoKilo >=15.00 ){
			tarifaDolares = 100.00;		
		}
		return tarifaDolares;
	}

	public static double obtenerImpuestosDelProducto(char tipoProducto){
		double impuestoProducto = 0.0;
		switch (tipoProducto) {
		case 'a':
			impuestoProducto = 0.13;
			break;
		case 'r':
			impuestoProducto = 0.29;
			break;
		case 'l':
			impuestoProducto = 0.01;
			break;
		default:
			break;
		}
		return impuestoProducto;
	}
	
	public static double calcularFlete(char tipoProducto, double pesoProducto, double valorProducto){
		double flete = valorProducto + obtenerPrecioDePesosEnKilos(pesoProducto) + (valorProducto + (pesoProducto * 0.10)) *
				obtenerImpuestosDelProducto(tipoProducto);
		return flete;
	}

	public static void main( String args[] ){
		scanner = new Scanner(System.in);
		System.out.print("Bienvenidos a calculo de Fletes.");
		System.out.println("Introduzca el peso ");
		double pesoProducto = scanner.nextDouble();
		System.out.println("Introduzca el tipo del producto ");
		String tipoProducto = scanner.next();
		System.out.println("Introduzca el valor del producto ");
		double valorProducto = scanner.nextDouble();
		double precioTotal = calcularFlete(tipoProducto.toLowerCase().charAt(0), pesoProducto, valorProducto);
		System.out.println("El monto total del flete es " + precioTotal);
	}
}
