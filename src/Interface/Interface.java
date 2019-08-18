/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Servidor.Medicina;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Maicol
 */
public interface Interface extends Remote{
    //void agregar(int id, String nombre, double precio, int stock)throws RemoteException;
    void agregar(Medicina med)throws RemoteException;
    Medicina buscar(int id) throws RemoteException;
}
