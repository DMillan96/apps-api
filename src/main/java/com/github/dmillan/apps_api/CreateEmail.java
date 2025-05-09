package com.github.dmillan.apps_api;

import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import javax.validation.constraints.*;

@RestController
@RequestMapping("/api")
public class CreateEmail {

    @PostMapping("/create-email")
    public String createEmail(@Valid @RequestBody EmailRequest emailRequest) {
        return String.format("Email created successfully for %s %s at email: %s and phonenumber: %s with message: %s",
                emailRequest.getFirstname(),
                emailRequest.getLastname(),
                emailRequest.getEmail(),
                emailRequest.getPhone(),
                emailRequest.getMessage());
    }

    // DTO for request validation
    public static class EmailRequest {
        @NotBlank(message = "First name is required")
        private String firstname;

        @NotBlank(message = "Last name is required")
        private String lastname;

        @Email(message = "Invalid email address")
        @NotBlank(message = "Email is required")
        private String email;

        @Pattern(regexp = "^\\d{3}-\\d{3}-\\d{4}$", message = "Phone number must be in the format XXX-XXX-XXXX")
        private String phone;

        @NotBlank(message = "Message is required")
        private String message;

        // Getters and setters
        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}