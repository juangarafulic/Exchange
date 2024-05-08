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

        CurrencyBaseCode currencyBaseCode = new CurrencyBaseCode(currencyCodeExchangeRateApi);
//            Pruebas utilizando DTO con la clase intermedia CurrencyCodeExchangeApi
//            Transformando datos de la clase intermedia a nuestra clase CurrencyBaseCode

//            System.out.println(currencyBaseCode); // CurrencyBaseCode{baseCode='USD', conversionRates={"USD":1,"AED":3.6725, ...
//            System.out.println(currencyBaseCode.getClass()); // class Modelos.CurrencyBaseCode
//            System.out.println(currencyBaseCode.getBaseCode()); // USD
//            System.out.println(currencyBaseCode.getBaseCode().getClass()); // class java.lang.String
//            System.out.println(currencyBaseCode.getConversionRates()); // {"USD":1,"AED":3.6725, ...
//            System.out.println(currencyBaseCode.getConversionRates().isJsonObject()); // true
//            System.out.println(currencyBaseCode.getConversionRates().getClass()); // class com.google.gson.JsonObject
//            Con eso respondemos ¿Qué es un JsonObject?

//            System.out.println(currencyBaseCode.getConversionRates().get("USD")); // 1
//            System.out.println(currencyBaseCode.getConversionRates().get("CLP")); // 960.7531
//            System.out.println(currencyBaseCode.getConversionRates().get("CLP").getClass()); // class com.google.gson.JsonPrimitive
//            System.out.println(currencyBaseCode.getConversionRates().get("CLP").getAsDouble()); // 939.3104

        Scanner sc = new Scanner(System.in);
        String baseCode;
        String targetCode;
        String patternOne = "La tasa de cambio es: %.4f [%s]/[%s]";
        String patternTwo = "Ingrese el monto a convertir";
        Double amount = 0.0;
        String patternThree = "\n\n%.2f [%s] = %.2f [%s]\n\n";
        int option = 0;

        while (option != 7) {
            Menu menu = new Menu();
            System.out.println(menu.getMenu());
            option = Integer.parseInt(sc.next());
            switch (option) {
                case 1: {
                    baseCode = "USD";
                    targetCode = "ARS";
                    Double baseCodeValue = currencyBaseCode.getConversionRates().get(baseCode).getAsDouble();
                    Double targetCodeValue = currencyBaseCode.getConversionRates().get(targetCode).getAsDouble();
                    Double conversionRate = targetCodeValue / baseCodeValue;
                    String resultOne = String.format(patternOne, conversionRate, targetCode, baseCode);
                    System.out.println(resultOne);
                    System.out.println(patternTwo);
                    amount = Double.valueOf(sc.next());
                    Double conversionResult = amount * conversionRate;
                    String resultThree = String.format(patternThree, amount, baseCode, conversionResult, targetCode);
                    System.out.println(resultThree);
                    break;
                }
                case 2: {
                    baseCode = "ARS";
                    targetCode = "USD";
                    Double baseCodeValue = currencyBaseCode.getConversionRates().get(baseCode).getAsDouble();
                    Double targetCodeValue = currencyBaseCode.getConversionRates().get(targetCode).getAsDouble();
                    Double conversionRate = targetCodeValue / baseCodeValue;
                    String resultOne = String.format(patternOne, conversionRate, targetCode, baseCode);
                    System.out.println(resultOne);
                    System.out.println(patternTwo);
                    amount = Double.valueOf(sc.next());
                    Double conversionResult = amount * conversionRate;
                    String resultThree = String.format(patternThree, amount, baseCode, conversionResult, targetCode);
                    System.out.println(resultThree);
                    break;
                }
                case 3: {
                    baseCode = "USD";
                    targetCode = "BRL";
                    Double baseCodeValue = currencyBaseCode.getConversionRates().get(baseCode).getAsDouble();
                    Double targetCodeValue = currencyBaseCode.getConversionRates().get(targetCode).getAsDouble();
                    Double conversionRate = targetCodeValue / baseCodeValue;
                    String resultOne = String.format(patternOne, conversionRate, targetCode, baseCode);
                    System.out.println(resultOne);
                    System.out.println(patternTwo);
                    amount = Double.valueOf(sc.next());
                    Double conversionResult = amount * conversionRate;
                    String resultThree = String.format(patternThree, amount, baseCode, conversionResult, targetCode);
                    System.out.println(resultThree);
                    break;
                }
                case 4: {
                    baseCode = "BRL";
                    targetCode = "USD";
                    Double baseCodeValue = currencyBaseCode.getConversionRates().get(baseCode).getAsDouble();
                    Double targetCodeValue = currencyBaseCode.getConversionRates().get(targetCode).getAsDouble();
                    Double conversionRate = targetCodeValue / baseCodeValue;
                    String resultOne = String.format(patternOne, conversionRate, targetCode, baseCode);
                    System.out.println(resultOne);
                    System.out.println(patternTwo);
                    amount = Double.valueOf(sc.next());
                    Double conversionResult = amount * conversionRate;
                    String resultThree = String.format(patternThree, amount, baseCode, conversionResult, targetCode);
                    System.out.println(resultThree);
                    break;
                }
                case 5: {
                    baseCode = "USD";
                    targetCode = "COP";
                    Double baseCodeValue = currencyBaseCode.getConversionRates().get(baseCode).getAsDouble();
                    Double targetCodeValue = currencyBaseCode.getConversionRates().get(targetCode).getAsDouble();
                    Double conversionRate = targetCodeValue / baseCodeValue;
                    String resultOne = String.format(patternOne, conversionRate, targetCode, baseCode);
                    System.out.println(resultOne);
                    System.out.println(patternTwo);
                    amount = Double.valueOf(sc.next());
                    Double conversionResult = amount * conversionRate;
                    String resultThree = String.format(patternThree, amount, baseCode, conversionResult, targetCode);
                    System.out.println(resultThree);
                    break;
                }
                case 6: {
                    baseCode = "COP";
                    targetCode = "USD";
                    Double baseCodeValue = currencyBaseCode.getConversionRates().get(baseCode).getAsDouble();
                    Double targetCodeValue = currencyBaseCode.getConversionRates().get(targetCode).getAsDouble();
                    Double conversionRate = targetCodeValue / baseCodeValue;
                    String resultOne = String.format(patternOne, conversionRate, targetCode, baseCode);
                    System.out.println(resultOne);
                    System.out.println(patternTwo);
                    amount = Double.valueOf(sc.next());
                    Double conversionResult = amount * conversionRate;
                    String resultThree = String.format(patternThree, amount, baseCode, conversionResult, targetCode);
                    System.out.println(resultThree);
                    break;
                }
                case 7: {
                    System.out.println("Programa finalizado con éxito");
                    break;
                }
                default: {
                    System.out.println("Ingrese una opción válida, del 1 al 7");
                    break;
                }
            }
        }
    }
}
//     https://v6.exchangerate-api.com/v6/283064626eb183fdd08d956b/latest/USD
//     https://v6.exchangerate-api.com/v6/283064626eb183fdd08d956b/pair/USD/CLP/1000