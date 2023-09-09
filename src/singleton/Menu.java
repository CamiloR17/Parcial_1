package src.singleton;

import src.factory.Juguete;
import src.strategy.Accion;
import src.strategy.AccionHandler;
import src.utils.KeyBoard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class Menu {

    private static Menu instance;
    private static List<Juguete> juguetes = new ArrayList<>();
    private static Map<Integer, Accion> strategy = AccionHandler.getStrategy();
    private static final int exit_option = 0;
    public Menu() {}

    public static Menu getInstance() {
        if(instance == null) {
            instance = new Menu();
        }
        return instance;
    }

    public void showMenu() {
        System.out.println("""
                                    
                    \t\t\tProject 1.03.25
                    \t\t----------------------
                    """);
        int op;
        do {
            System.out.print("""
                                    
                                        =================================================
                                        |                  == MENU ==                   |
                                        |        1º Crear juguete.                      |
                                        |        2º Clonar juguete.                     |
                                        |        3º Eliminar juguete.                   |
                                        |        4º Registro juguete.                   |
                                        |                                               |
                                        |        0º Finalizar...                        |
                                        =================================================
                            
                            """);

            op = KeyBoard.Int("Ingrese su opción");
            Accion accion = strategy.get(op);
            if (op == exit_option) { continue; }
            if (accion == null) {
                System.out.println("Esta opción no existe");
            }else {
                accion.aplicar();
            }
        } while (op != exit_option);

//        System.out.println(juguetes.get(0));

    }
    public static List<Juguete> getJugetes() {
        return juguetes;
    }
}
