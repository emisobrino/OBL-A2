package ABBProductor;

import Modelo.Productor;

public class NodoProductor {
	//Atributos
	private Productor productor ;
	private NodoProductor der ;
	private NodoProductor izq ;

	   //Constructores
	   public NodoProductor(Productor p){
	       productor = p;
	       izq = null;
	       der = null;
	    }

	   public NodoProductor(Productor p, NodoProductor i, NodoProductor d){
	       productor =p;
	       izq = i;
	       der = d;
	    }

	   //Dato
	   Productor getDato(){
	       return productor;
	   }
	   void setDato(Productor p){
	       productor=p;
	   }
	   
	   //Derecho
	   NodoProductor getDer(){
	       return der;
	   }
	   void setDer(NodoProductor d){
	      der = d;
	   }
	   
	   //Izquierdo
	   NodoProductor getIzq(){
	       return izq;
	   }
	   void setIzq(NodoProductor i){
	       izq = i;
	   }

	}
