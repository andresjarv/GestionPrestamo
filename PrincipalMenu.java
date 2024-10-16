import java.util.LinkedList;
import java.util.Scanner;
public class PrincipalMenu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Metodos m = new Metodos();
        LinkedList<Estudiante> lista = new LinkedList<>();

        int opt = 0;
        int opt1 = 0;
        int opt2 = 0;

        while(opt != 4){
            System.out.println("------- \tIngrese la opcion que desea ejecutar\t ------ \n"+
                        "1. Estudiante de Ingenieria. \n"+
                        "2. Estudiante de Diseño. \n"+
                        "3. Imprimir inventario total. \n"+
                        "4. Salir del prgrama.");
            opt = sc.nextInt();

            switch (opt) {
                case 1:
                    //Estudiante ingenieria
                    while(opt1 != 5){
                        System.out.println("\n\t Que desea hacer \t\n"+
                                    "1 Registrar préstamo de equipo.\n"+
                                    "2 Modificar prestamo del equipo (Serial o Cedula).\n"+
                                    "3 Devolucion del equipo (Serial o Cedula).\n"+
                                    "4 Buscar equipo (Serial o Cedula).\n"+
                                    "5 volver al menú principal.");
                        opt1 = sc.nextInt();
                        
                        switch (opt1) {
                            case 1:
                                lista = m.LlenarListaEstudiante(lista);
                                //Registrar equipo

                                break;

                            case 2:
                                //mostrar
                                m.MostrarListaEstudiante(lista);
                                //Modificar equipo
                                break;
                            
                            case 3:
                                //Devolucion de equipo
                                break;

                            case 4:
                                //Buscar equipo
                                break;

                            case 5:
                                //Salir del menú 2
                                System.out.println("volviendo al menú principal");
                                break; 
                        
                            default:
                                System.out.println("Seleccionó una opcion incorrecta, intente de nuevo");
                                break;
                        }
                    }
                    break;

                case 2:
                    //Estudiante Diseño
                    while(opt2 != 5){
                        System.out.println("\n\t Que desea hacer \t\n"+
                                    "1 Registrar préstamo de equipo.\n"+
                                    "2 Modificar prestamo del equipo (Serial o Cedula).\n"+
                                    "3 Devolucion del equipo (Serial o Cedula).\n"+
                                    "4 Buscar equipo (Serial o Cedula).\n"+
                                    "5 volver al menú principal.");
                        opt2 = sc.nextInt();
                        
                        switch (opt2) {
                            case 1:
                                //Registrar equipo
                                break;

                            case 2:
                                //Modificar equipo
                                break;
                            
                            case 3:
                                //Devolucion de equipo
                                break;

                            case 4:
                                //Buscar equipo
                                break;

                            case 5:
                                //Salir del menú 2
                                System.out.println("volviendo al menú principal");
                                break; 
                        
                            default:
                                System.out.println("Seleccionó una opcion incorrecta, intente de nuevo");
                                break;
                        }
                    }            
                    break;
                
                case 3:
                    //Imprimir el inventario TOTAL
                    break;
                    
                case 4:
                    System.out.println("\n------\tSaliendo del programa, Gracias por usar nuestro servicio.\t------\n");
                    break;
            
                default:
                    System.out.println("Seleccionó una opcion incorrecta, intente de nuevo");
                    break;
            }
        }

    }
}