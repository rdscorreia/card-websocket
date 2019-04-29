package br.com.processadora.cardwebsocket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.processadora.cardwebsocket.domain.Transaction;

/**
 * @author ricardoc
 *
 */

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
