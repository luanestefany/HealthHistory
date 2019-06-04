package com.example.healthhistory.activity.model;

import com.example.healthhistory.activity.config.ConfiguracaoFirebase;
import com.google.firebase.database.DatabaseReference;

public class Consultas {
    private String id;
    private String data;
    private String hora;
    private String endereco;
    private String telefone;
    private String convenio;
    private String tipoConsulta;



    public Consultas(){

    }

    public void salvarConsultas(){
        DatabaseReference referenciaFirebase = ConfiguracaoFirebase.getFirebase();
        referenciaFirebase.child("Consultas").child(getId()).setValue(this); //cria consultas no banco de dados
    }

    public String getId() {
        return id;
    }

    public void setId(String cod) {
        this.id = cod;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }
}

