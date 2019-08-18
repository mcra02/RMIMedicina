/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Interface.Interface;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Maicol
 */
public class Servidor {
    private static final int PUERTO = 1100; //Pueerto
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        FMedicinas fmedicina = new FMedicinas(); 
        Medicina med = new Medicina();
        Remote remote = UnicastRemoteObject.exportObject(new Interface() {
            @Override
            public void agregar(Medicina med) throws RemoteException {
                /*med.setId(id);
                med.setNombre(nombre);
                med.setPrecio(precio);
                med.setStock(stock);*/
                fmedicina.agregar(med);
            }

            @Override
            public Medicina buscar(int id) throws RemoteException {
                Medicina resultado = fmedicina.buscar(id);
                return resultado;
            }
            
        }, 0);
        Registry registry = LocateRegistry.createRegistry(PUERTO);
       	System.out.println("Servidor escuchando en el puerto " + String.valueOf(PUERTO));
        registry.bind("Farmacia", remote); // Registrar 
    }
}
