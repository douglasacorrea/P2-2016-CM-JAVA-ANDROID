package com.aulas.controleaulas.entities;

import java.io.Serializable;

public class Cadastro implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME = "cadastro";

    int id;
    String nome;
    String matricula;
    String email;
    String contaGit;
    String curso;
    String senha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContaGit() {
        return contaGit;
    }

    public void setContaGit(String contaGit) {
        this.contaGit = contaGit;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + " Email: " + this.email + " Curso: " + this.getCurso();
    }
}