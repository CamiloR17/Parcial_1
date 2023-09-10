package src.singleton;

import src.factory.Juguete;
import src.strategy.Accion;
import src.strategy.AccionHandler;
import src.utils.KeyBoard;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;

public final class Menu {

    private static Menu instance;
    private static final List<Juguete> juguetes = new ArrayList<>();
    private static final Map<Integer, Accion> strategy = AccionHandler.getStrategy();
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
            do {
                try {
                    op = KeyBoard.Int("Ingrese su opción");
                }catch (InputMismatchException e) {
                    System.out.println("\n\t\t * ERROR - Digite un numero *\n");
                    continue;
                }
                break;
            }while (true);

            Accion accion = strategy.get(op);
            if (op == exit_option) { continue; }
            if (accion == null) {
                System.out.println("\n\t\t * Opción desconocida *");
            }else {
                accion.aplicar();
            }
        } while (op != exit_option);
    }
    public static List<Juguete> getJugetes() {
        return juguetes;
    }
}
