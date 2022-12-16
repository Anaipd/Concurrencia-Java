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
public class ProductorDeTableros extends Thread {
    
    
    /****** Lo que habia en la orden *****/
    
//    public void producirUnTablero( Taller t){ 
// t.agregarTablero(); 
// } 
    
    /****** segundo inciso *****/
    
// parametros privados creados debido a los argumentos necesarios
    private Taller taller;
    
// constructor que lo inicializa
    public ProductorDeTableros(Taller t){
        taller=t;
    }
            
 // sobrescribir el metodo run de, ejecutandolo de forma concurrente           
    @Override
    public void run(){
       while(true) producirUnTablero(taller); 
    }
    
 // igual           
    public void producirUnTablero( Taller t){
      t.agregarTablero();  
    }

    
    
}
