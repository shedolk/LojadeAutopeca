package br.unitins.topicos1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.Version;

@Entity
public class Category extends DefaultEntity{

    @Column(length = 20)
    private String category;

    private String compatibilidade;

    private String tipoMola;

    private String tipoAmortecedor;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCompatibilidade() {
        return compatibilidade;
    }

    public void setCompatibilidade(String compatibilidade) {
        this.compatibilidade = compatibilidade;
    }

    public String getTipoMola() {
        return tipoMola;
    }

    public void setTipoMola(String tipoMola) {
        this.tipoMola = tipoMola;
    }

    public String getTipoAmortecedor() {
        return tipoAmortecedor;
    }

    public void setTipoAmortecedor(String tipoAmortecedor) {
        this.tipoAmortecedor = tipoAmortecedor;
    }

    

    // public String getMaterial() {
    //     return material;
    // }

    // public void setMaterial(String material) {
    //     this.material = material;
    // }

    

    
    
    
}