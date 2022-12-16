/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabrica.de.mesas;

/**
 *
 * @author jportal
 */
public class FabricaDeMesas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Taller taller = new Taller(100,10); 
        
        ProductorDePatas patas = new ProductorDePatas(taller); 
        ProductorDeTableros tablas = new ProductorDeTableros(taller); 
        EnsambladorDeMesas mesas = new EnsambladorDeMesas(taller); 
        
        patas.start();
        tablas.start();
        mesas.start(); 
        
        try { 
            patas.join();
            tablas.join();
            mesas.join();  
            
        } catch (InterruptedException ex) { } 
        
        
    }
    
}
