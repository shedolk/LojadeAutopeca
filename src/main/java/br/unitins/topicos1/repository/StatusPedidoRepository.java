package br.unitins.topicos1.repository;

import br.unitins.topicos1.model.StatusPedido;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StatusPedidoRepository {

    public StatusPedido[] findAll() {
        StatusPedido[] data = StatusPedido.values();
        return data;
    }
}
