package sn.esmt.inapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sn.esmt.inapi.dto.RechargingDto;
import sn.esmt.inapi.entites.SubscriberUser;
import sn.esmt.inapi.entites.SubscriberUserRepository;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class UserSubscriberServiceImpl implements UserSubscriberService {

    private final SubscriberUserRepository subscriberUserRepository;

    @Override
    public ResponseEntity<?> newConnection(SubscriberUser subscriberUser) {
        subscriberUser.setCreatedAt(new Date());
        return ResponseEntity.ok(subscriberUserRepository.save(subscriberUser));
    }

    @Override
    public ResponseEntity<?> query(String number) {
        Optional<SubscriberUser> userOptional = subscriberUserRepository.findByPhoneNumberOrImsi(number, number);
        if (userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.get());
        }
        return new ResponseEntity<>("User with phone  = " + number + "not found", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> recharging(String phoneNumber, RechargingDto rechargingDto) {
        Optional<SubscriberUser> userOptional = subscriberUserRepository.findByPhoneNumberOrImsi(phoneNumber, phoneNumber);
        if (userOptional.isPresent()) {
            SubscriberUser subscriberUser = userOptional.get();
            subscriberUser.setCallBalance(500 + Math.random() * 500);
            subscriberUser.setSmsBalance(500 + Math.random() * 500);
            subscriberUser.setDataBalance(500 + Math.random() * 500);

            subscriberUserRepository.save(subscriberUser);

            return ResponseEntity.ok("User with phone  = " + phoneNumber + "recharged");
        }
        return new ResponseEntity<>("User with phone  = " + phoneNumber + "not found", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> termination(String number) {
        Optional<SubscriberUser> userOptional = subscriberUserRepository.findByPhoneNumberOrImsi(number, number);
        if (userOptional.isPresent()) {
            subscriberUserRepository.delete(userOptional.get());
            return ResponseEntity.ok("User with phone  = " + number + "deleted");
        }
        return new ResponseEntity<>("User with phone  = " + number + "not found", HttpStatus.NOT_FOUND);
    }
}
