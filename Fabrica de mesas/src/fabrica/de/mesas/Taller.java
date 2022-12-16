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
public class Taller {
    
    private int capacidadDePatas; 
    private int capacidadDeTableros; 
    private int nPatas = 0; 
    private int nTableros = 0; 
    private int nMesas=0;
            
    // se agregan estos objetos para trabajar con los synchronized
    private Object patasCond = new Object(); 
    private Object tablasCond = new Object(); 
    private Object mesasCond = new Object(); 
    private Object mutex = new Object(); 
 
    public Taller(int patas, int tableros){
        capacidadDePatas=patas; 
        capacidadDeTableros = tableros; 
        
    }
    
    /*
     Debido a que la 
llamada al método wait() impone algunas restricciones (se debe adquirir el candado 
correspondiente a la variable de condición y capturar la excepción 
InterruptedException) y en aras de mantener la legibilidad de código, en esta solución 
se agregarán tres métodos privados para encerrar esta funcionalidad y tres campos 
también privado
    */
    private void esperarPatas(){
        synchronized(patasCond){
            try{
                patasCond.wait();
            } catch(InterruptedException ex) {}
        }
    }
    
     private void esperarTablas(){
        synchronized(tablasCond){
            try{
                tablasCond.wait();
            } catch(InterruptedException ex) {}
        }
    }
     
     
      private void esperarMesas(){
        synchronized(mesasCond){
            try{
                mesasCond.wait();
            } catch(InterruptedException ex) {}
        }
    }
      
      // Metodos originales ya correctos agregarPata, agregarTablero, ensamblarMesa
     
     public void agregarPata(){ 
         while (nPatas >= capacidadDePatas) esperarPatas(); 
         synchronized(mutex){
             nPatas++;
         } 
         synchronized(mesasCond){
             mesasCond.notify();    //se podra armar una mesa?
         }
          System.out.println("Pata agregada!. Ahora hay: "+nPatas); 
     }

     
     
     public void agregarTablero(){ 
         while (nTableros >= capacidadDeTableros) esperarTablas(); 
         synchronized(mutex){
             nTableros++;
         } 
         synchronized(mesasCond){
             mesasCond.notify(); //se podra armar una mesa?
         }
         
         System.out.println("Tablero agregado!. Ahora hay: "+nTableros); 
     }
     
     public void ensamblarMesa(){ 
         while (nPatas < 4 || nTableros<1) esperarMesas();
         
         synchronized(mutex){
             nPatas-=4;
             nTableros-=1;  nMesas ++;
         }
     
         
         synchronized(patasCond){
             patasCond.notifyAll(); // ya hay espacio para las patas
         } 
         
         synchronized(tablasCond){
             tablasCond.notifyAll(); // ya hay espacio para las tablas
         } 
     System.out.println("Mesa ensamblada!. Ahora hay: "+nMesas); 
     
   
}
     
     
}
