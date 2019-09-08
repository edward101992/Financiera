/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.financiera;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author SuperUs
 */
public class Tipo implements Serializable{
    Scanner sc = new Scanner(System.in);
    private String descripcion;
    private String nomcaracteristico;

    public Tipo(String descripcion, String nomcaracteristico) {
        this.descripcion = descripcion;
        this.nomcaracteristico = nomcaracteristico;
    }

    public Tipo() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNomcaracteristico() {
        return nomcaracteristico;
    }

    public void setNomcaracteristico(String nomcaracteristico) {
        this.nomcaracteristico = nomcaracteristico;
    }

    public void menu(){
        System.out.println("**********   Tipo Antecedentes   *********");
        System.out.println("Digite codigo Antecedente");
        System.out.println("Digite Descripcion Tipo antecedente: ");
        descripcion = sc.nextLine();
        System.out.println("Digite nombre Caracteristico Tipo antecedente: ");
        nomcaracteristico=sc.nextLine();

    }
    
}
