package br.unitins.topicos1.repository;

import br.unitins.topicos1.model.Perfil;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PerfilRepository {

    public Perfil[] findAll() {
        Perfil[] data = Perfil.values();
        return data;
    }
}