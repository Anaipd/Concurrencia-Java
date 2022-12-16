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
class ProductorDePatas extends Thread { 
     /****** Lo que habia en la orden *****/
    
//    public void producirUnaPata ( Taller t){ 
//            t.agregarPata(); 
//    } 
  
    /****** segundo inciso *****/
//campo privado de la clase ya que se necesitan argumentos
    private Taller taller;
    
//constructor que lo inicializa
    public ProductorDePatas(Taller t){
        taller = t;  
    }
    
 //metodo run que se ejecutara de forma concurrente
    @Override
    public void run(){
         while(true) producirUnaPata(taller); 
    }
// igual    
    public void producirUnaPata( Taller t){
       t.agregarPata();  
    }
   
} 
