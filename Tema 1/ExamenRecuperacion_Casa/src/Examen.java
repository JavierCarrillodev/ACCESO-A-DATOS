import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Examen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("======= Menú =======");
            System.out.println("1.- Crear productos");
            System.out.println("2.- Crear pedidos");
            System.out.println("3.- Borrar clientes");
            System.out.println("4.- Calcular ingresos");
            System.out.println("5.- Salir");

            System.out.println("Elige una opcion");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion){
                case 1:
                    anadirProductos(sc);
                    break;
                case 2:
                    anadirPedidos(sc);
                    break;
                case 3:
                    borrarProducto(sc);
                    break;
                case 4:
                    calcularIngreso(sc);
                    break;
                default:
                    System.out.println("Opcion invalida");
            }

        }while (opcion != 5);

        
    }
    private static void anadirProductos(Scanner sc){
        try{
            System.out.println("Indica el id");
            int idProducto = Integer.parseInt(sc.nextLine());
            System.out.println("Indica el nombre");
            String nombre = sc.nextLine();
            System.out.println("Indica precio");
            double precio = Double.parseDouble(sc.nextLine());
            System.out.println("Indica el stock");
            int stock = Integer.parseInt(sc.nextLine());

                File archivoProductos = new File("src/productos.txt");

                //Este es uno de los fallo que me pasaba en el examen, que no creaba el fichero antes y por eso no funcionaba el throw new StockCollitionException
                BufferedWriter bw = new BufferedWriter(new FileWriter(archivoProductos,true));
                BufferedReader br = new BufferedReader(new FileReader(archivoProductos));

                String linea;
                while ((linea = br.readLine()) !=null){
                    String[] separarLinea = linea.split("\\|");
                    //Si el id de producto coincide nos salta nuestra excepción de que ya existe una
                    if (idProducto == Integer.parseInt(separarLinea[0])){
                        throw new StockCollitionException("El id " + idProducto + " ya existe");
                    }
                }
                bw.write(idProducto + "|" +  nombre + "|" +  precio + "|" +  stock + ";" + "\n");

                br.close();
                bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void anadirPedidos(Scanner sc){
        try {
            System.out.println("Indica el idPedido");
            int idPedido = Integer.parseInt(sc.nextLine());
            System.out.println("Indica el idProducto");
            int idProducto = Integer.parseInt(sc.nextLine());
            System.out.println("Indica la cantidad");
            int cantidad = Integer.parseInt(sc.nextLine());
            System.out.println("Indica la Fecha(DD-MM-AAAA)");
            String fechaPedido = sc.nextLine();

            File archivoProductos = new File("src/productos.txt");
            File archivoPedidos = new File("src/pedidos.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivoPedidos,true));
            BufferedReader br = new BufferedReader(new FileReader(archivoProductos));

            //Creamos una variable boolean para verificar si encontramos al idProducto
            boolean idEncontrado = false;
            String linea;
            while ((linea = br.readLine()) !=null) {
                String[] separarLinea = linea.split("\\|");
                String[] stock = separarLinea[3].split(";");

                // Si el id de producto coincide con el id que se ubique en pedidos significa que existe y podemos crear el pedido
                if (idProducto == Integer.parseInt(separarLinea[0])) {
                    //Si coincide la ponemos a true
                    idEncontrado = true;
                }

                // Si la cantidad del pedido supera al stock hacemos que salte nuestra excepción
                if (cantidad > Integer.parseInt(stock[0])){
                    throw new StockCollitionException("No hay suficiente stock");
                }

            }
            bw.write(idPedido + "|" +  idProducto + "|" +  cantidad + "|" +  fechaPedido + ";" + "\n");
            br.close();
            bw.close();

            //Y si no se encuentra lanzamos nuestra excepción
            if (!idEncontrado){
                throw new StockCollitionException("Id no coincide con el producto ");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void borrarProducto(Scanner sc){
        //Aqui sinceramente no tengo ni idea y he estado probando pero nada,no he querido mirar nada en internet.

        try {
            System.out.println("Introduce el id que quieras borrar sus producto");
            int id = Integer.parseInt(sc.nextLine());
            BufferedReader br = new BufferedReader(new FileReader("src/productos.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/NuevoProducto.txt"));

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] separarLinea = linea.split("\\|");
                if (id != Integer.parseInt(separarLinea[0])) {
                    bw.write(separarLinea[0] + "|" + separarLinea[1] + "|" + separarLinea[2] + "|" + separarLinea[3] + "\n");
                }
            }
            br.close();
            bw.close();

            int idPedido = Integer.parseInt(sc.nextLine());
            BufferedReader br1 = new BufferedReader(new FileReader("src/pedidos.txt"));
            BufferedWriter bw2 = new BufferedWriter(new FileWriter("src/NuevoPedidos.txt"));

            String lineas;
            while ((lineas = br1.readLine()) != null) {
                String[] separarLinea = lineas.split("\\|");
                //Fallo que he cometido en el examen es poner la posicion 0 y para el id de producto en pedidos es la posicion 1
                if (idPedido != Integer.parseInt(separarLinea[1])) {
                    bw2.write(separarLinea[0] + "|" + separarLinea[1] + "|" + separarLinea[2] + "|" + separarLinea[3] + "\n");
                }
            }
            br1.close();
            bw2.close();

        } catch (Exception e) {
        e.printStackTrace();
    }

    }
    private static void calcularIngreso(Scanner sc){
        System.out.println("Indica la id de producto");
        int idProducto = Integer.parseInt(sc.nextLine());

        // Con esta variable guardamos el nombre del producto mas adelante
        String nombre= "";

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/productos.txt"));
            BufferedReader br2 = new BufferedReader(new FileReader("src/pedidos.txt"));
            double precioProducto = 0;
            String linea;
            while ((linea = br.readLine())!=null){
                String[] lineaSeparar = linea.split("\\|");

                // Comparamos si el id que hemos introducido es el mismo que el de producto
                if (idProducto == Integer.parseInt(lineaSeparar[0])){
                    // Si coincide guardamos el precio y el nombre del producto que hemos encontrado
                    precioProducto = Double.parseDouble(lineaSeparar[2]);
                    nombre = lineaSeparar[1];
                }
            }
            int sumaPedidos = 0;
            String lineasPedidos;
            while ((lineasPedidos = br2.readLine())!=null) {
                String[] lineaSeparar = lineasPedidos.split("\\|");
                //Buscamos todos los pedidos que tengan el mismo id que idProducto,y cuantas unidades se han pedido en total
                if (idProducto == Integer.parseInt(lineaSeparar[1])){
                    sumaPedidos += Integer.parseInt(lineaSeparar[2]);
                }
            }
            // Realizamos la cuenta para ver los ingresos totales del producto
            double ingresos = precioProducto * sumaPedidos;
            System.out.println("Ingresos");
            System.out.println(idProducto + " - " + nombre + ": " + ingresos + "€");

            br.close();
            br2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
