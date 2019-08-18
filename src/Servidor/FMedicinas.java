/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Maicol
 */
public class FMedicinas {
    
    ArrayList<Medicina> list = new ArrayList<Medicina>();
    Medicina med = new Medicina();
    
    public void agregar(Medicina medicina){
        list.add(medicina);
    }
    public Medicina buscar(int id){
        
        for(int x=0;x<list.size();x++) {
            System.out.println(list.get(x).getId());
            if(list.get(x).getId() == id){                
                return list.get(x);                
            }
        }
        return med;
    }
}
