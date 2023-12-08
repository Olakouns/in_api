package sn.esmt.inapi.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.esmt.inapi.dto.RechargingDto;
import sn.esmt.inapi.entites.SubscriberUser;
import sn.esmt.inapi.service.UserSubscriberService;

import java.util.UUID;

@RestController
@RequestMapping("/api/in-api")
@RequiredArgsConstructor
public class SubscriberController {
    private final UserSubscriberService userSubscriberService;

    @PostMapping("/create")
    public ResponseEntity<?> newConnection(@RequestBody SubscriberUser subscriberUser) {
        return userSubscriberService.newConnection(subscriberUser);
    }

    @PutMapping("recharging/{phoneNumber}")
    public ResponseEntity<?> recharging(@PathVariable String phoneNumber, @RequestBody RechargingDto rechargingDto) {
        return userSubscriberService.recharging(phoneNumber, rechargingDto);
    }

    @GetMapping("/{phoneNumber}")
    public ResponseEntity<?> query(@PathVariable String phoneNumber) {
        return userSubscriberService.query(phoneNumber);
    }

    @DeleteMapping("/{phoneNumber}")
    public ResponseEntity<?> termination(@PathVariable String phoneNumber) {
        return userSubscriberService.termination(phoneNumber);
    }
}
