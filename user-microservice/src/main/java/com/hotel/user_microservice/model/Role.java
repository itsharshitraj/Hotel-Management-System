package com.hotel.user_microservice.model;

/*  enum (short for “enumeration”), which defines a fixed set of values: OWNER, MANAGER, and RECEPTIONIST.

We use this instead of a free-form string so roles are strictly controlled, not typo-prone, and easy to restrict access in Spring Security.*/
public enum Role {
    OWNER,
    MANAGER,
    RECEPTIONIST
}
