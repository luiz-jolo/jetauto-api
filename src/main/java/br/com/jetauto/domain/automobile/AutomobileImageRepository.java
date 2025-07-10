package br.com.jetauto.domain.automobile;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AutomobileImageRepository extends JpaRepository<AutomobileImage, UUID> {
}
