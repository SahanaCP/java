/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mythread;

/**
 *
 * @author Krishna
 */
public class Mythread extends Thread{

    //
    private volatile static int counter;
    
    
    private Mythread(String name){
        
        super(name);
        System.out.println("Thread obj created"+this);
        start();
    }
    
    public void run(){
        System.out.println("The thread is running");
        try{
            for(int i=0; i<10; i++){
                incrementCounter();
                int tcounter = this.counter;
                int temp = (tcounter)%2;
                   
                if(temp == 0){
                    printEven(tcounter);
                    Thread.sleep(1000);
                }
                else
                {
                    printOdd(tcounter);
                    Thread.sleep(100);
                }
        
            }
        }catch(InterruptedException e){
            System.out.println("Thread interrupted");
        }
    }    
    synchronized public void incrementCounter(){
        this.counter++;        
    }
    
    public synchronized void printEven(int tcounter){
        System.out.println("Thread1 running "+tcounter);
    }
    
    public synchronized void printOdd(int tcounter){
        System.out.println("Thread2 running "+tcounter);
    }
    
    
    /**
     * @param args the command line arguments
     */
        
    public static void main(String[] args) {
        // TODO code application logic here
        Mythread thread1 = new Mythread("thread1");
        Mythread thread2 = new Mythread("thread2");
        
        
    }
    
}
