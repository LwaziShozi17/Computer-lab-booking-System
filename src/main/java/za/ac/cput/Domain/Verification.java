package za.ac.cput.Domain;

import java.util.*;

// Placeholder interfaces/classes (replace with your actual implementations)
interface Rule {
    boolean apply(User user);
}

interface Requirements {
    boolean meets(User user);
}

class Session {
    public boolean isAvailableFor(Booking booking) {
        // dummy logic
        return true;
    }
}

class User {
    private String faculty;
    public String getFaculty() {
        return faculty;
    }
}

class Booking {
    // Booking details
}

public class Verification {

    private final String verificationId;
    private final Map<String, Rule> verificationRules;
    private final Map<String, Requirements> facultyRequirements;
    private final List<Session> activeSessions;

    private Verification(Builder builder) {
        this.verificationId = builder.verificationId;
        this.verificationRules = builder.verificationRules;
        this.facultyRequirements = builder.facultyRequirements;
        this.activeSessions = builder.activeSessions;
    }

    public static class Builder {
        private String verificationId;
        private Map<String, Rule> verificationRules = new HashMap<>();
        private Map<String, Requirements> facultyRequirements = new HashMap<>();
        private List<Session> activeSessions = new ArrayList<>();

        public Builder verificationId(String id) {
            this.verificationId = id;
            return this;
        }

        public Builder verificationRules(Map<String, Rule> rules) {
            this.verificationRules = rules;
            return this;
        }

        public Builder facultyRequirements(Map<String, Requirements> requirements) {
            this.facultyRequirements = requirements;
            return this;
        }

        public Builder activeSessions(List<Session> sessions) {
            this.activeSessions = sessions;
            return this;
        }

        public Verification build() {
            return new Verification(this);
        }
    }

    public boolean verifyUser(User user) {
        for (Rule rule : verificationRules.values()) {
            if (!rule.apply(user)) {
                return false;
            }
        }
        return true;
    }

    public boolean validateBooking(Booking booking) {
        for (Session session : activeSessions) {
            if (session.isAvailableFor(booking)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkFacultyRequirements(User user) {
        String faculty = user.getFaculty();
        Requirements req = facultyRequirements.get(faculty);
        return req != null && req.meets(user);
    }

    public String getVerificationId() {
        return verificationId;
    }

    public Map<String, Rule> getVerificationRules() {
        return verificationRules;
    }

    public Map<String, Requirements> getFacultyRequirements() {
        return facultyRequirements;
    }

    public List<Session> getActiveSessions() {
        return activeSessions;
    }
}
