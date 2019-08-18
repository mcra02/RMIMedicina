/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Interface.Interface;
import Servidor.Medicina;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Maicol
 */
public class Cliente {
    private static final String IP = "localhost"; // localhost
	private static final int PUERTO = 1100; //Puerto
	
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(IP, PUERTO);
        Interface interfaz = (Interface) registry.lookup("Farmacia"); //Buscar en el registro...
        Scanner sc = new Scanner(System.in);
        int id, stock;
        double precio;
        String nombre;
        Medicina resultado = new Medicina();
        Medicina med = new Medicina();
        int op=0;
        System.out.println("Agrega MEDICINAS");
        System.out.println("*******************");
        while(op==0){
            System.out.print("\nIngresa el ID del producto : ");
            id = sc.nextInt();
            System.out.print("Ingresa el Nombre del producto : ");
            nombre = sc.next();

            System.out.print("Ingresa el Precio del producto : ");
            precio = sc.nextDouble();

            System.out.print("Ingresa el Stock del producto : ");
            stock = sc.nextInt();           
           
            med.setId(id);
            med.setNombre(nombre);
            med.setPrecio(precio);
            med.setStock(stock);
            interfaz.agregar(med);
            //interfaz.agregar(id, nombre, precio, stock);
            System.out.println("-------------------");
            System.out.print("¿Desea seguir agregando? 0/si - 1/no :");
            op = sc.nextInt();
        }
        
        System.out.println("\n\nBusca MEDICINAS");
        System.out.println("**********************");
        System.out.print("\nIngresa el ID del producto : ");        
        id = sc.nextInt();
        resultado = interfaz.buscar(id);  
        System.out.print("\n\n");
        //System.out.println("Medicina => " + String.valueOf(resultado.getNombre()));
        System.out.println("Medicina => " + String.valueOf(resultado.getId()+" -- "+resultado.getNombre()+" -- "+resultado.getPrecio()+" -- "+resultado.getStock()));
        
    }
}
