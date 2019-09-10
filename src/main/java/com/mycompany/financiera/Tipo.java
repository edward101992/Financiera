/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.financiera;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *  Clase Tipo implementa Serializable en la clase tipo 
 *  para serializar el archivo
 * @author Edward Ramos
 * @author Victor Preciado
 */
public class Tipo implements Serializable{
      /**
     * variable descripcion contiene la descripcion de la persona
     * variable nomcaracteristico guarda el nombre caracteristico del 
     * antecedente
     * variable codigoantecedente guarda el codigo del tipo 
     * de antecedente
     * variable codigotipo guarda el codigo de antecedente
     * variable estado guarda el estado de la persona
     * positivo o negativo
     */
    Scanner sc = new Scanner(System.in);
    private String descripcion;
    private String nomcaracteristico;
    private String codigoantecedente;
    private String codigotipo;
    private String estado;

     /**
     * get variable estado
     * @return estado
     */
    public String getEstado() {
        return estado;
    }
     /**
     * get variable codigotipo
     * @param codigotipo 
     */
    public String getCodigotipo() {
        return codigotipo;
    }
      /**
     * set variable codigotipo
     * @param codigotipo 
     */
    public void setCodigotipo(String codigotipo) {
        this.codigotipo = codigotipo;
    }
       /**
     * set variable estado
     * @param estado 
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
     /**
     * Constructor clase triangulo
     */
    public Tipo() {
    }
     /**
     * get variable codigoantecedente
     * @return codigoantecedente 
     */
    public String getCodigoantecedente() {
        return codigoantecedente;
    }
      /**
     * set variable codigoantecedente
     * @param codigoantecedente 
     */
    public void setCodigoantecedente(String codigoantecedente) {
        this.codigoantecedente = codigoantecedente;
    }

    public Tipo(String descripcion, String nomcaracteristico, String codigoantecedente) {
        this.descripcion = descripcion;
        this.nomcaracteristico = nomcaracteristico;
        this.nomcaracteristico = codigoantecedente;
    }

     /**
     * get variable descripcion
     * @return descripcion 
     */
    public String getDescripcion() {
        return descripcion;
    }
     /**
     * set variable descripcion
     * @param descripcion 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
     /**
     * get variable nomcaracteristico
     * @return nomcaracteristico 
     */
    public String getNomcaracteristico() {
        return nomcaracteristico;
    }
      /**
     * set variable nomcaracteristico
     * @param nomcaracteristico 
     */
    public void setNomcaracteristico(String nomcaracteristico) {
        this.nomcaracteristico = nomcaracteristico;
    }
      
      
    /**
     * Metodo subMenu sirve para agregar antecedentes 
     * y eliminar antecedentes del cliente
     */

    public void subMenu() throws IOException{
        ficheroleer();
        Principal princ = new Principal();
        String elije ="";
        System.out.println("1. Agregar Tipo Antecedente");
        System.out.println("2. Eliminar Tipo Antecedente");
        System.out.println("0. Atras");
        elije = sc.nextLine();
        switch(elije){
            case "1":
                menu();
                break;
            case "2":
                eliminarAntecedente();
                break;
            case "0":
                princ.menu();
                break;
            default:
                System.out.println("Opcion invalida");
                break;
        }
    }
     /**
     * Metodo menu sirve para agregar informacion de
     * antecedentes y estado de la persona
     */
    public void menu() throws IOException{       
        boolean registrado = false;
        System.out.println("**********   Tipo Antecedentes   *********");
        System.out.println("Digite codigo Antecedente");
        codigoantecedente = sc.nextLine();    
        System.out.println("Digite codigo Tipo Antecedente");
        codigotipo = sc.nextLine();
        System.out.println("Digite Descripcion Tipo antecedente: ");
        descripcion = sc.nextLine();
        System.out.println("Digite nombre Caracteristico Tipo antecedente: ");
        nomcaracteristico=sc.nextLine();
        System.out.println("Digite Estado P-N :");
        estado = sc.nextLine();     
        for (ArrayList<String> listatipo : Principal.listatipo) {
            if (listatipo.get(1).equals(codigotipo)) {
                registrado=true;
            }
        }
        if(registrado){
            System.out.println("El tipo de antecedente ya esta registrado");
            subMenu();
        }else{
            verificarAntecedente();
        }    
    }
      /**
     * Metodo agregarDatos agrega el tipo de antecedente a la lista
     * y estado de la persona
     */
    
    
    public void verificarAntecedente() throws IOException{  
        boolean repite = false;
        for (ArrayList<String> listaantecedente : Principal.listaantecedente) {
            if (listaantecedente.get(0).equals(codigoantecedente)) {
                repite = true;
            } 
        }
        if(repite){
            agregarDatos();
        }else{
            System.out.println("Antecedente no registrado");
            subMenu();
        }
    }
    
    public void agregarDatos() throws IOException{
            int contador= 0;
            if((estado.equalsIgnoreCase("p"))||((estado.equalsIgnoreCase("n")))){
            contador = (Principal.listatipo.size());
            ficherovaciar();
            Principal.listatipo.add(new ArrayList<String>());
            Principal.listatipo.get(contador).add(codigoantecedente);
            Principal.listatipo.get(contador).add(codigotipo);
            Principal.listatipo.get(contador).add(descripcion);
            Principal.listatipo.get(contador).add(nomcaracteristico);
            Principal.listatipo.get(contador).add(estado);
            System.out.println("Tipo de Antecedente agregado");
            ficheroescribir();
            subMenu();     
            }else{
            System.out.println("Debe Ingresar estado Positivo o Negativo");   
            subMenu();      
            }
    }
     /**
     * Metodo ficheroleer sirve para leer
     * el fichero creado 
     */
    public  void ficheroleer() {
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;
      int contador = 0;
      Principal.listatipo.clear();
      try {
         archivo = new File ("Tipo.txt");
         if(!archivo.exists()){
               archivo.createNewFile();
           }
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);
         String linea;
         while((linea=br.readLine())!=null){
             Principal.listatipo.add(new ArrayList<String>());
             for(int i=0;i<5; i++){
                Principal.listatipo.get(contador).add(linea);
                linea=br.readLine();
             }
             contador++;
         }
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
   }
     /**
     * Metodo eliminarAntecedente elimina informacion de la persona
     * del fichero, cualquier dato
     */
    public void eliminarAntecedente() throws IOException{
        boolean encontro = false;
        System.out.println("Digite codigo tipo de antecedente");
        codigotipo = sc.nextLine();
        ArrayList<String> listmod = new ArrayList<String>();
               for(int i=0;i<Principal.listatipo.size();i++){ 
                     if(Principal.listatipo.get(i).get(1).equals(codigotipo) &&  Principal.listatipo.get(i).get(4).equalsIgnoreCase("n")){                        
                        ficherovaciar();
                        listmod.add(""); 
                        listmod.add(""); 
                        listmod.add("");
                        listmod.add("");
                        listmod.add("");
                        Principal.listatipo.set(i, listmod);
                        encontro= true;
                        ficheroescribir();
                     }       
                }
        if(!encontro){
            System.out.println("Tipo de antecedente no Registrado o Antecedente Positivo"); 
        }else{
            System.out.println("Tipo de antecedente  " + codigotipo + "  eliminado");
        }            
        subMenu();
    }
      /**
     * Metodo ficheroescribir escribe informacion de la
     * persona en el fichero modificado
     */
    public void ficheroescribir(){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("Tipo.txt");
            pw = new PrintWriter(fichero);
            
            for(int i=0;i<Principal.listatipo.size();i++){
                pw.println(Principal.listatipo.get(i).get(0));
                pw.println(Principal.listatipo.get(i).get(1));
                pw.println(Principal.listatipo.get(i).get(2));
                pw.println(Principal.listatipo.get(i).get(3));
                pw.println(Principal.listatipo.get(i).get(4));
                pw.println("."); 
            } 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
     /**
     * Metodo ficherovaciar deja el archivo en
     * blanco del archivo.txt
     */
    public void ficherovaciar(){
        File fichero = null;
        fichero = new File("Tipo.txt");
        fichero.delete();
        try
        {
            fichero.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}
