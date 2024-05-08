package Modelos;

public class Menu {

    private String menu = """
                    *****************************************************
                    ++++++++        Conversor de monedas        +++++++++
                    -----------------------------------------------------
                      Opción      De:                    A:
                       (1)    [USD]-Dólar           [ARS]-Peso argentino
                       (2)    [ARS]-Peso argentino  [USD]-Dólar
                       (3)    [USD]-Dólar           [BRL]-Real brasileño
                       (4)    [BRL]-Real brasileño  [USD]-Dólar
                       (5)    [USD]-Dólar           [COP]-Peso colombiano
                       (6)    [COP]-Peso colombiano [USD]-Dólar
                       (7)    ---SALIR---
                    -----------------------------------------------------
                    >>>>>>>>>>>>>>>>> Elija una opción <<<<<<<<<<<<<<<<<<
                    *****************************************************
                    """;

    public String getMenu() {
        return menu;
    }
}
