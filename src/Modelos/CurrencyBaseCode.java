package Modelos;

import com.google.gson.JsonObject;

public class CurrencyBaseCode {
    // Para convertir la respuesta json a nuestro objeto Java
    // Necesitamos cambiar los nombres del json por los de nuestro CurrencyCode
    // Para esto, creamos la clase CurrencyCodeExchangeRateApi
    //    @SerializedName("base_code") es un método alternativo pero no flexible
    private String baseCode;
    private JsonObject conversionRates;

    public CurrencyBaseCode(CurrencyCodeExchangeRateApi code){
        this.baseCode = code.base_code();
        this.conversionRates = code.conversion_rates();

    }

    public CurrencyBaseCode(){
    }

    public String getBaseCode() {
        return baseCode;
    }

    public JsonObject getConversionRates() {
        return conversionRates;
    }

    @Override
    public String toString() {
        return "CurrencyBaseCode{" +
                "baseCode='" + baseCode + '\'' +
                ", conversionRates=" + conversionRates +
                '}';
    }
}