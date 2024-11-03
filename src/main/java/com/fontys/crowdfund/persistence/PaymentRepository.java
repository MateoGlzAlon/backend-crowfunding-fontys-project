package com.fontys.crowdfund.persistence;

import com.fontys.crowdfund.persistence.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {

    // Check if a payment exists by ID
    @Query("SELECT COUNT(p) > 0 FROM PaymentEntity p WHERE p.id = :paymentId")
    boolean existsById(@Param("paymentId") long paymentId);

    // Find a payment by ID (JpaRepository already provides findById, but this is an example if custom logic is needed)
    @Query("SELECT p FROM PaymentEntity p WHERE p.id = :paymentId")
    PaymentEntity findPaymentById(@Param("paymentId") long paymentId);

    // Get payments by project ID, returning PaymentEntity directly
    @Query("SELECT p FROM PaymentEntity p WHERE p.project.id = :projectId ORDER BY p.paymentDate DESC")
    List<PaymentEntity> getPaymentsByProjectId(@Param("projectId") int projectId);
}
