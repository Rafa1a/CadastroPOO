/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Windows 10
 */
import java.io.*;
import java.util.ArrayList;
 
public class PessoaFisicaRepo implements Serializable {
    private ArrayList<PessoaFisica> pessoasFisicas;
    
     public PessoaFisicaRepo() {
        pessoasFisicas = new ArrayList<>();
    }
     
    //metodos inserir
    public void inserir(PessoaFisica pessoaFisica) {
        pessoasFisicas.add(pessoaFisica);
    }
    
    //alterar, menos o ID que precisa permanecer 
    public void alterar (PessoaFisica pessoaFisica){
    int index = obterIndicePessoaFisica(pessoaFisica.getId());
    if(index != -1) {
        pessoasFisicas.set(index, pessoaFisica);
        }   
    }
    
    public void excluir(int id) {
        int index = obterIndicePessoaFisica(id);
        if (index != -1) {
            pessoasFisicas.remove(index);
        }
    }

    public PessoaFisica obter(int id) {
        for (PessoaFisica pessoaFisica : pessoasFisicas) {
            if (pessoaFisica.getId() == id) {
                return pessoaFisica;
            }
        }
        return null;
    }
    public ArrayList<PessoaFisica> obterTodos() {
        return pessoasFisicas;
    }
    private int obterIndicePessoaFisica(int id){
        for (int i = 0; i < pessoasFisicas.size(); i++){
            if (pessoasFisicas.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
    //persistência
    public void persistir(String arquivo) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            outputStream.writeObject(pessoasFisicas);
        }
    }
    public void recuperar(String arquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(arquivo))) {
            pessoasFisicas = (ArrayList<PessoaFisica>) inputStream.readObject();
        }
    }
    
}