package br.com.processadora.cardwebsocket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.processadora.cardwebsocket.domain.Card;

/**
 * @author ricardoc
 *
 */

@Repository
public interface CardRepository extends JpaRepository<Card, String> {

}
