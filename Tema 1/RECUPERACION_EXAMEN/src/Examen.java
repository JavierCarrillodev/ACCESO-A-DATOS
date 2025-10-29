import java.beans.Introspector;
import java.io.*;
import java.util.Scanner;

public class Examen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("1 Anadir productos");
            System.out.println("2 Cargar pedido");
            System.out.println("3 Borrar cliente");
            System.out.println("4 Calcular ingreso");
            System.out.println("5 Salir");

            System.out.println("Indica la opcion:");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion){
                case 1:
                    anadirProductos(sc);
                    break;
                case 2:
                    anadirPedidos(sc);
                    break;
                case 3:
                    borrarCliente(sc);
                    break;
            }

        }while (opcion != 5);

    }

    private static void anadirProductos(Scanner sc){
        try {
                System.out.println("Indica el id del producto");
                int id = Integer.parseInt(sc.nextLine());
                System.out.println("Nombre del producto");
                String nombre = sc.nextLine();
                System.out.println("Precio del producto");
                double precio = Double.parseDouble(sc.nextLine());
                System.out.println("Stock del producto");
                int stock = Integer.parseInt(sc.nextLine());



                    BufferedWriter bw = new BufferedWriter(new FileWriter("productos.txt",true));

                    bw.write(id + "|" + nombre + "|" + precio + "|" + stock + ";" + "\n");

                    BufferedReader br = new BufferedReader(new FileReader("productos.txt"));

                    String linea;
                    while ((linea = br.readLine()) !=null){
                        String[] separarLinea = linea.split("\\|");

                        if (id == Integer.parseInt(separarLinea[0])){
                            throw new StockCOllitionException("La id ya existe");
                        }
//                        Lo he estado practicando pero no tengo bien ubicado el id //y me salta todo el rato
                    }
                    br.close();
                    bw.close();



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void anadirPedidos(Scanner sc){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("pedidos.txt",true));
            System.out.println("Introduce IDpedido");
            int idPedido = Integer.parseInt(sc.nextLine());
            System.out.println(" Introduce Idproducto");
            int idProducto = Integer.parseInt(sc.nextLine());
            System.out.println("Introduce cantidad");
            int cantidad = Integer.parseInt(sc.nextLine());
            System.out.println("Fecha(DD-MM-AAAA)");
            String fecha = sc.nextLine();

            bw.write(idPedido + "|" + idProducto + "|" + cantidad + "|" + fecha + ";" + "\n");
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void borrarCliente(Scanner sc){
        try {
            System.out.println("Introduce el id que quieras borrar sus producto");
            int id = Integer.parseInt(sc.nextLine());
            BufferedReader br = new BufferedReader(new FileReader("productos.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("NuevoProducto.txt"));

            String linea;
            while ((linea = br.readLine()) !=null) {
                String[] separarLinea = linea.split("\\|");
                if (id != Integer.parseInt(separarLinea[0])){
                    bw.write(separarLinea[0] + "|" + separarLinea[1] + "|" + separarLinea[2] + "|" + separarLinea[3] + "\n" );
                }
            }
            br.close();
            bw.close();

            System.out.println("Introduce el id que quieras borrar sus pedidos");
            int idPedido = Integer.parseInt(sc.nextLine());
            BufferedReader br1 = new BufferedReader(new FileReader("pedidos.txt"));
            BufferedWriter bw2 = new BufferedWriter(new FileWriter("NuevoPedidos.txt"));

            String lineas;
            while ((lineas = br1.readLine()) !=null) {
                String[] separarLinea = lineas.split("\\|");
                if (idPedido != Integer.parseInt(separarLinea[1])){
                    bw2.write(separarLinea[0] + "|" + separarLinea[1] + "|" + separarLinea[2] + "|" + separarLinea[3] + "\n");
                }
            }
            br1.close();
            bw2.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private static void calcularIngresos(Scanner sc){
        int pedidos = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("pedidos.txt"));

            String linea;
            while ((linea = br.readLine()) !=null) {
                String[] separarLinea = linea.split("\\|");
                pedidos = Integer.parseInt(separarLinea[2]);
               return;

            }
            br.close();

            BufferedReader br2 = new BufferedReader(new FileReader("productos.txt"));
            int productos = 0;

            String lineas;
            while ((lineas = br2.readLine()) !=null) {
                String[] separarLinea = lineas.split("\\|");
                 productos = Integer.parseInt(separarLinea[2]);
                return;
                // No me da tiempo Amin. Me quiero matar
                // Se que tengo que recorrer el dichero de pedidos y apuntar la cantidad de los que coincidad con el id producto y multiplarlo por el precio.

            }
            br2.close();







        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
