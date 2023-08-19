package br.com.grupo27.techchallenge02.external.infrastructure.repositories.JPA;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.grupo27.techchallenge02.external.infrastructure.dataBaseEntities.LancheEntity;

public interface LancheJPA extends JpaRepository<LancheEntity, Long> {}
