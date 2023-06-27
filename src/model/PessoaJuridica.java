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
public class PessoaJuridica extends Pessoa implements Serializable{
    private String cnpj;
    
    public PessoaJuridica() {
     }

     public PessoaJuridica(int id, String nome, String cnpj) {
         super(id, nome);
         this.cnpj = cnpj;
     }
       @Override
        public void exibir() {
            super.exibir();
            System.out.println("CNPJ: " + cnpj);
        }

        // Getters e Setters
        public String getCnpj() {
            return cnpj;
        }

        public void setCnpj(String cnpj) {
            this.cnpj = cnpj;
        }
}
