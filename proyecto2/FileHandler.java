// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.List;

// // Clase para manejar la exportación e importación de archivos planos
// public class FileHandler {

//     // Método para exportar datos a un archivo plano
//     public static void exportToFile(List<String> data, String filePath) {
//         try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
//             for (String line : data) {
//                 writer.write(line);
//                 writer.newLine(); // Añade una nueva línea
//             }
//             System.out.println("Datos exportados correctamente a " + filePath);
//         } catch (IOException e) {
//             System.err.println("Error al exportar datos: " + e.getMessage());
//         }
//     }

//     // Método para importar datos desde un archivo plano
//     public static List<String> importFromFile(String filePath) {
//         List<String> data = new ArrayList<>();
//         try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
//             String line;
//             while ((line = reader.readLine()) != null) {
//                 data.add(line);
//             }
//             System.out.println("Datos importados correctamente desde " + filePath);
//         } catch (IOException e) {
//             System.err.println("Error al importar datos: " + e.getMessage());
//         }
//         return data;
//     }

//     // Método principal para demostrar la funcionalidad
//     public static void main(String[] args) {
//         String filePath = "datos.txt";

//         // Crear ejemplos de objetos
//         Laptop laptop = new Laptop("LAP123", "MarcaA", 15.6f, 1200.00f, "Windows", "Intel");
//         EstudianteDiseno estudianteDiseno = new EstudianteDiseno("123456789", "Juan", "Perez", "5551234", "virtual", 5, laptop.getSerial());
//         EstudianteIngenieria estudianteIngenieria = new EstudianteIngenieria("987654321", "Ana", "Gomez", "5555678", 3, 4.0f, laptop.getSerial());
//         Tableta tableta = new Tableta("TAB456", "MarcaB", 10.5f, 300.00f, "64GB", 0.5f);
        
//         // Exportar datos a un archivo
//         List<String> datosParaExportar = List.of(
//                 laptop.toString(),
//                 estudianteDiseno.toString(),
//                 estudianteIngenieria.toString(),
//                 tableta.toString()
//         );
//         exportToFile(datosParaExportar, filePath);

//         // Importar datos desde el archivo y mostrar en consola
//         List<String> datosImportados = importFromFile(filePath);
//         for (String linea : datosImportados) {
//             System.out.println(linea);
//         }
//     }
// }