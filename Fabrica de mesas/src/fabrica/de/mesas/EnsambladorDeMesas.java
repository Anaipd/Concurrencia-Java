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
public class EnsambladorDeMesas extends Thread {
    
    /****** Lo que habia en la orden *****/
//    public void producirUnaMesa( Taller t){ 
// t.ensamblarMesa(); 
// } 
    
     /****** segundo inciso *****/
    
//campo privado de la clase ya que se necesitan argumentos
    private Taller taller;
    
//constructor que lo inicializa
    public EnsambladorDeMesas(Taller t){
        taller=t;
    }
    
//metodo run que se ejecutara de forma concurrente
    @Override
    public void run(){
        while(true) producirUnaMesa(taller);
    }
    
//igual    
    public void producirUnaMesa(Taller t){
        t.ensamblarMesa();
    }
    
    
    
}
