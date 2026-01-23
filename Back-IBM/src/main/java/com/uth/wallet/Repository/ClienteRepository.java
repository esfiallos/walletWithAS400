package com.uth.wallet.Repository;

import com.uth.wallet.Entity.ClienteLegacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteLegacy, Integer> {
}