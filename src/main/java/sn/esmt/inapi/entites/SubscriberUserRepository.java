package sn.esmt.inapi.entites;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SubscriberUserRepository extends JpaRepository<SubscriberUser, UUID>{
    Optional<SubscriberUser> findByPhoneNumberOrImsi(String phoneNumber, String imsi);
}
