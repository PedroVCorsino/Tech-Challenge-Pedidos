package br.com.grupo27.techchallenge02.external.infrastructure.repositories.JPA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.grupo27.techchallenge02.core.enums.StatusPedido;
import br.com.grupo27.techchallenge02.external.infrastructure.dataBaseEntities.PedidoEntity;

public interface PedidoJPA extends JpaRepository<PedidoEntity, Long> {

    List<PedidoEntity> findByPago(boolean pago);

    List<PedidoEntity> findByStatus(StatusPedido status);

}
