package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Verification;
import za.ac.cput.service.VerificationService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/verifications")
public class VerificationController {

    private final VerificationService verificationService;

    @Autowired
    public VerificationController(VerificationService verificationService) {
        this.verificationService = verificationService;
    }

    @PostMapping
    public ResponseEntity<Verification> createVerification(@RequestBody Verification verification) {
        if (verification == null || verification.getUserId() == null) {
            return ResponseEntity.badRequest().build();
        }
        
        Verification createdVerification = verificationService.create(verification);
        return new ResponseEntity<>(createdVerification, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Verification> getVerificationById(@PathVariable String id) {
        Optional<Verification> verification = verificationService.read(id);
        return verification.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Verification> getVerificationByUserId(@PathVariable String userId) {
        if (userId == null || userId.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        
        // This would need to be implemented in VerificationService
        // For now, returning 404 as placeholder
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Verification>> getAllVerifications() {
        List<Verification> verifications = verificationService.getAll();
        return ResponseEntity.ok(verifications);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Verification> updateVerification(@PathVariable String id, @RequestBody Verification verification) {
        if (verification == null || verification.getVerificationId() == null || !verification.getVerificationId().equals(id)) {
            return ResponseEntity.badRequest().build();
        }
        
        Verification updatedVerification = verificationService.update(verification);
        return ResponseEntity.ok(updatedVerification);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVerification(@PathVariable String id) {
        if (id == null || id.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        
        verificationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
