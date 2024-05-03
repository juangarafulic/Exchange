package Principal;
import Funciones.Conexion;
import Modelos.Menu;
import java.io.IOException;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) throws IOException, InterruptedException {



            Menu menu = new Menu();

            Scanner sc = new Scanner(System.in);

            int option = sc.nextInt();

            switch (option){

                case 1:
                    // Conexion
                    Conexion option1 = new Conexion();
                    // Monto a convertir
                    System.out.println("Ingrese el monto a convertir");
                    double amount = sc.nextDouble();
                    System.out.println(menu.getMenu());
                break;

                case 2:
                    // Monto a convertir
                    System.out.println("Ingrese el monto a convertir");
                    double amount = sc.nextDouble();
                    System.out.println(menu.getMenu());
                break;

                case 3:
                    // Monto a convertir
                    System.out.println("Ingrese el monto a convertir");
                    double amount = sc.nextDouble();
                    System.out.println(menu.getMenu());
                break;

                case 4:
                    // Monto a convertir
                    System.out.println("Ingrese el monto a convertir");
                    double amount = sc.nextDouble();
                    System.out.println(menu.getMenu());
                break;

                case 5:
                    // Monto a convertir
                    System.out.println("Ingrese el monto a convertir");
                    double amount = sc.nextDouble();
                    System.out.println(menu.getMenu());
                break;

                case 6:
                    // Monto a convertir
                    System.out.println("Ingrese el monto a convertir");
                    double amount = sc.nextDouble();
                    System.out.println(menu.getMenu());
                break;

                case 7:
                    System.out.println("Programa finalizado");
                break;

                default:
                    System.out.println(menu.getMenu());
            }

                // Transformando datos, realiza el mapeo de JSON a objetos Java,
                // Permite la extracción y manipulación de la información necesaria.
                Gson gson = new Gson();
                // Moneda moneda = gson.fromJson(json, Moneda.class);
                // Una mejor forma de mostrar datos
                //System.out.println("Ticker: "+moneda.getTicker());
                ExchangeRateApi exchangeRateApi = gson.fromJson(json, ExchangeRateApi.class);
                System.out.println(exchangeRateApi);
                CurrencyCode code = new CurrencyCode(exchangeRateApi);
                System.out.println("Ticker: "+code.getTicker());
            }
        }
//     https://v6.exchangerate-api.com/v6/283064626eb183fdd08d956b/latest/USD
//     https://v6.exchangerate-api.com/v6/283064626eb183fdd08d956b/pair/USD/CLP/1000