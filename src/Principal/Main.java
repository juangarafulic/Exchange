package Principal;

import Funciones.Response;
import Modelos.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;

import java.io.IOException;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException, InterruptedException {
            // client, request, response, return json
            Response response = new Response();
            var json = response.getJson(); // class java.lang.String

            // Transformando datos, realiza el mapeo de JSON a objetos Java,
            // Permite la extracción y manipulación de la información necesaria.
            Gson gson = new Gson();
            CurrencyCodeExchangeRateApi currencyCodeExchangeRateApi = gson
                    .fromJson(json, CurrencyCodeExchangeRateApi.class);


//             Necesitamos crear un método para calcular las conversiones entre monedas,
//             utilizando variables para almacenar los valores ingresados por el usuario,
//             aplicar las tasas de conversión y mostrar los resultados finales.
//
//             Para el filtrado de monedas, será necesario utilizar el atributo "Currency Code" del JSON.
//             Elegir al menos tres "Currency Code" para incluir en la aplicación.
//             Sugeridas: USD CLP ARS BOB BRL COP, Disponibles:
// [USD, AED, AFN, ALL, AMD, ANG, AOA, ARS, AUD, AWG, AZN, BAM, BBD, BDT, BGN, BHD, BIF, BMD,
// BND, BOB, BRL, BSD, BTN, BWP, BYN, BZD, CAD, CDF, CHF, CLP, CNY, COP, CRC, CUP, CVE, CZK,
// DJF, DKK, DOP, DZD, EGP, ERN, ETB, EUR, FJD, FKP, FOK, GBP, GEL, GGP, GHS, GIP, GMD, GNF,
// GTQ, GYD, HKD, HNL, HRK, HTG, HUF, IDR, ILS, IMP, INR, IQD, IRR, ISK, JEP, JMD, JOD, JPY,
// KES, KGS, KHR, KID, KMF, KRW, KWD, KYD, KZT, LAK, LBP, LKR, LRD, LSL, LYD, MAD, MDL, MGA,
// MKD, MMK, MNT, MOP, MRU, MUR, MVR, MWK, MXN, MYR, MZN, NAD, NGN, NIO, NOK, NPR, NZD, OMR,
// PAB, PEN, PGK, PHP, PKR, PLN, PYG, QAR, RON, RSD, RUB, RWF, SAR, SBD, SCR, SDG, SEK, SGD,
// SHP, SLE, SLL, SOS, SRD, SSP, STN, SYP, SZL, THB, TJS, TMT, TND, TOP, TRY, TTD, TVD, TWD,
// TZS, UAH, UGX, UYU, UZS, VES, VND, VUV, WST, XAF, XCD, XDR, XOF, XPF, YER, ZAR, ZMW, ZWL]

//            Pruebas

//            Transformando datos de la clase intermedia a nuestra clase CurrencyCode
            CurrencyBaseCode currencyBaseCode = new CurrencyBaseCode(currencyCodeExchangeRateApi);
//            System.out.println(currencyBaseCode); // CurrencyBaseCode{baseCode='USD', conversionRates={"USD":1,"AED":3.6725, ...
//            System.out.println(currencyBaseCode.getClass()); // class Modelos.CurrencyBaseCode
//            System.out.println(currencyBaseCode.getBaseCode()); // USD
//            System.out.println(currencyBaseCode.getBaseCode().getClass()); // class java.lang.String
//            System.out.println(currencyBaseCode.getConversionRates()); // {"USD":1,"AED":3.6725, ...
//            System.out.println(currencyBaseCode.getConversionRates().isJsonObject()); // true
//            System.out.println(currencyBaseCode.getConversionRates().getClass()); // class com.google.gson.JsonObject
//            Con eso respondemos ¿Qué es un JsonObject?
//            System.out.println(currencyBaseCode.getConversionRates().asMap()); // {USD=1, AED=3.6725, AFN=72.2106,
//            System.out.println(currencyBaseCode.getConversionRates().asMap().getClass()); // class com.google.gson.internal.LinkedTreeMap
//            System.out.println(currencyBaseCode.getConversionRates().asMap().get("CLP").getClass()); // class com.google.gson.JsonPrimitive
//            System.out.println(currencyBaseCode.getConversionRates().keySet()); // [USD, AED, AFN, ALL,
//            System.out.println(currencyBaseCode.getConversionRates().keySet().getClass()); // class com.google.gson.internal.LinkedTreeMap$KeySet
//            System.out.println(currencyBaseCode.getConversionRates().get("USD")); // 1
//            System.out.println(currencyBaseCode.getConversionRates().get("CLP")); // 960.7531
//            System.out.println(currencyBaseCode.getConversionRates().get("CLP").getClass()); // class com.google.gson.JsonPrimitive
//       **** System.out.println(currencyBaseCode.getConversionRates().get("CLP").getAsDouble()); // 939.3104

            //Intentaré transformar la lista de conversiones a un nuevo Json
            // y luego lo pasaré a una clase intermedia DTO
            var conversionJson = gson.toJson(currencyBaseCode.getConversionRates());
//            System.out.println(conversiones2); // {"USD":1,"AED":3.6725,"AFN":72.2106,
//            System.out.println(conversiones2.getClass()); // class java.lang.String
            ConversionList conversionList = gson.fromJson(conversionJson, ConversionList.class); // No resulto
            System.out.println(conversionList);

//
//            Creamos una clase ConversionList para filtrar nuestras monedas de interés
//            ConversionList conversionList = gson.fromJson(currencyBaseCode.getConversionRates(), ConversionList.class);
//            System.out.println(conversionList); // ConversionList{USD=1.0, CLP=960.751, ARS=864.75}
//            System.out.println(conversionList.getCLP()+conversionList.getARS()); // 1825.501 it works!
//            ConversionList conversionList = gson.fromJson(currencyBaseCode.getConversionRates(), ConversionList.class);
//            System.out.println(conversionList); // ConversionList{USD=1.0, CLP=944.7498, ARS=864.75}//
//            No me convence, pero, puede ser la solución?

//            Prefiero pensar en otra forma de resolver el problema, intentaré con HashMap
//            Class HashMap<K,V> --> No se puede ordenar?
            HashMap conversionMap = gson.fromJson(currencyBaseCode.getConversionRates(), HashMap.class);
//            System.out.println(conversionMap); // {FJD=2.2538, MXN=16.9807, SCR=13.7889, TVD=1.5121, ...
//            Method entrySet() --> Returns a Set view of the mappings contained in this map.
//            System.out.println(conversionMap.entrySet()); // [FJD=2.2408, MXN=16.8896, SCR=13.8815,
//            Method get(Object key) --> Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
//            System.out.println(conversionMap.get(1)); // null
            System.out.println(conversionMap.get("CLP")); // 939.3104
//         ** System.out.println(conversionMap.get("CLP").getClass()); // class java.lang.Double
//            Method keySet() --> Returns a Set view of the keys contained in this map.
//            System.out.println(conversionMap.keySet()); // [FJD, MXN, SCR, TVD, CDF,
//            Method size() --> Returns the number of key-value mappings in this map.
//            System.out.println(conversionMap.size()); // 162
//            Method values() Returns a Collection view of the values contained in this map.
//            System.out.println(conversionMap.values()); // [2.2408, 16.8896, 13.8815,
//            System.out.println(conversionMap.values().getClass()); // class java.util.HashMap$Values


//            System.out.println(conversionMap);

//            CurrencyBaseCode currencyBaseCode = new CurrencyBaseCode(currencyCodeExchangeRateApi);
//            HashMap conversionMap = gson.fromJson(currencyBaseCode.getConversionRates(), HashMap.class);

//            ¿Que tal un ArrayList?
//            Class ArrayList<E>
//            ArrayList<JsonObject>


//            // Llamamos a la clase Scanner para leer los datos del usuario
//            Scanner sc = new Scanner(System.in);
//            // Solicitamos los pares de monedas y el monto a convertir
//            System.out.println("Ingresa tu moneda base, por ejemplo: USD, CLP, ARS, ...");
//            String baseCode = sc.nextLine().toUpperCase(); // en caso que el usuario utilice minusculas
//            // conversionMap.get(baseCode); // es el valor asociado a la key!!
//            // if (!conversionMap.containsKey(baseCode) || conversionMap.get(baseCode) == null) {
//            System.out.println("Seleccionaste " + baseCode + ", ahora ingresa la moneda de destino");
//            String targetCode = sc.nextLine().toUpperCase();
//            double valueTargetCode = (double) conversionMap.get(targetCode);
//            double valueBaseCode = (double) conversionMap.get(baseCode);
//            double conversionRate = valueTargetCode / valueBaseCode;
//            System.out.println("Vas a convertir " + baseCode + " en " + targetCode);
//            System.out.println("La tasa de conversión es " + conversionRate + " " + targetCode + " por cada " + baseCode);
//            System.out.println("Ingresa el monto de " + baseCode + " a convertir");
//            double amount = sc.nextDouble();
//            double conversionResult = conversionRate * amount;
//            System.out.println(amount + " " + baseCode + " equivalen a " + conversionResult + " " + targetCode);
//            System.out.println("¡Hasta pronto!");

            }





            // Utilizamos el método calcConversion de la clase ConversionList
            // y realizamos la conversión dependiendo de los datos ingresados
            // para eso creamos un nuevo objeto de la clase ConversionList
            // pero antes hay que crear un constructor específico con baseCode, targetCode y amount

            // a este objeto le asignaremos los datos ingresados y aplicaremos el metodo calcConversion






//
//            Menu menu = new Menu();
//            int option = sc.nextInt();


//            switch (option){
//
//                case 1:
//                    // Conexion
//                    Conexion option1 = new Conexion();
//                    // Monto a convertir
//                    System.out.println("Ingrese el monto a convertir");
//                    double amount = sc.nextDouble();
//                    System.out.println(menu.getMenu());
//                break;
//
//                case 2:
//                    // Monto a convertir
//                    System.out.println("Ingrese el monto a convertir");
//                    double amount = sc.nextDouble();
//                    System.out.println(menu.getMenu());
//                break;
//
//                case 3:
//                    // Monto a convertir
//                    System.out.println("Ingrese el monto a convertir");
//                    double amount = sc.nextDouble();
//                    System.out.println(menu.getMenu());
//                break;
//
//                case 4:
//                    // Monto a convertir
//                    System.out.println("Ingrese el monto a convertir");
//                    double amount = sc.nextDouble();
//                    System.out.println(menu.getMenu());
//                break;
//
//                case 5:
//                    // Monto a convertir
//                    System.out.println("Ingrese el monto a convertir");
//                    double amount = sc.nextDouble();
//                    System.out.println(menu.getMenu());
//                break;
//
//                case 6:
//                    // Monto a convertir
//                    System.out.println("Ingrese el monto a convertir");
//                    double amount = sc.nextDouble();
//                    System.out.println(menu.getMenu());
//                break;
//
//                case 7:
//                    System.out.println("Programa finalizado");
//                break;
//
//                default:
//                    System.out.println(menu.getMenu());
//      }

}

//     https://v6.exchangerate-api.com/v6/283064626eb183fdd08d956b/latest/USD
//     https://v6.exchangerate-api.com/v6/283064626eb183fdd08d956b/pair/USD/CLP/1000