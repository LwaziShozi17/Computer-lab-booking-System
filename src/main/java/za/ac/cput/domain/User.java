package za.ac.cput.domain;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected String userId;

    protected String firstName;
    protected String lastName;
    protected String email;
    protected String password;

    public User() {}

    public User(Builder<?> builder) {
        this.userId = builder.userId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.password = builder.password;
    }

    // Getters...

    public static abstract class Builder<T extends Builder<T>> {
        protected String userId;
        protected String firstName;
        protected String lastName;
        protected String email;
        protected String password;

        public T setUserId(String userId) {
            this.userId = userId;
            return self();
        }

        public T setFirstName(String firstName) {
            this.firstName = firstName;
            return self();
        }

        public T setLastName(String lastName) {
            this.lastName = lastName;
            return self();
        }

        public T setEmail(String email) {
            this.email = email;
            return self();
        }

        public T setPassword(String password) {
            this.password = password;
            return self();
        }

        protected abstract T self();
    }
}
