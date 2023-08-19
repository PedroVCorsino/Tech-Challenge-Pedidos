package br.com.grupo27.techchallenge02.external.infrastructure.repositories.JPA;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.grupo27.techchallenge02.external.infrastructure.dataBaseEntities.SobremesaEntity;

public interface SobremesaJPA extends JpaRepository<SobremesaEntity, Long> {}
