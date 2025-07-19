import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        ConsultaConversion consulta = new ConsultaConversion();
        System.out.println("*******************************************");
        System.out.println("Ingrese la opción a la cual desea realizar la conversión: ");
        System.out.println("1. ARS (Peso Argentino) ");
        System.out.println("2. VES (Peso Venezolano) ");
        System.out.println("3. BRL (Real Brasileño) ");
        System.out.println("4. BOB (Peso Boliviano) ");
        System.out.println("5. CLP (Peso Chileno) ");
        System.out.println("*******************************************");
        try{
            var opcion = Integer.valueOf(lectura.nextLine());
            String moneda = null;
            switch (opcion)
            {
                case 1: moneda = "ARS"; break;
                case 2: moneda = "VES"; break;
                case 3: moneda = "BRL"; break;
                case 4: moneda = "BOB"; break;
                case 5: moneda = "CLP"; break;
                default:
                    System.out.println("Opcion no valida.");
                    return;
            }
            //pedimos la cantidad a convertir
            System.out.println("Ingrese la cantidad en dólares que desea convertir: ");
            double cantidad = Double.parseDouble(lectura.nextLine());

            Cambio resultado = consulta.hacerConsulta();
            if (resultado != null && resultado.getConversion_rates().containsKey(moneda)) {
                double tasa = resultado.getConversion_rates().get(moneda);
                double conversion = cantidad * tasa;
                System.out.println("Moneda base: " + resultado.getBase_code());
                System.out.println("Tasa de cambio a " + moneda + ": " + tasa);
                System.out.println(cantidad + " USD equivale a " + conversion + " " + moneda);
            } else {
                System.out.println("No se pudo obtener la tasa de cambio para " + moneda);
            }

        }
        catch (NumberFormatException e) {
            System.out.println("Por favor ingrese un número válido.");
        } catch (Exception e) {
            System.out.println("Ocurrió un error al realizar la consulta: " + e.getMessage());
        }

    }
}