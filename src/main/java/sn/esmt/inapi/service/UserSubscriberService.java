package sn.esmt.inapi.service;

import org.springframework.http.ResponseEntity;
import sn.esmt.inapi.dto.RechargingDto;
import sn.esmt.inapi.entites.SubscriberUser;

import java.util.UUID;

public interface UserSubscriberService {
    ResponseEntity<?> newConnection(SubscriberUser subscriberUser);

    ResponseEntity<?> termination(String number);

    ResponseEntity<?> query(String number);

    ResponseEntity<?> recharging(String phoneNumber, RechargingDto rechargingDto);
}
