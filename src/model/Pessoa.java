/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Windows 10
 */
import java.io.Serializable;

public class Pessoa implements Serializable {
    private int id;
    private String nome;
    
    //construtor nulo
    public Pessoa(){

    }
    //construtor com argumentos/parametros
    public Pessoa (int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
        public void exibir () {
            System.out.println ("ID: "+ id);
            System.out.println("Nome: " + nome);
        }

        //gets e seters

        public int getId() {
            return id;
        }
        public void setId(int id){
            this.id = id;
        }
        public String getNome(){
            return nome;
        }
        public void setNome(String nome){
            this.nome = nome;
        }

} 