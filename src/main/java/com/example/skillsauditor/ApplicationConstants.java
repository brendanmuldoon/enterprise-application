package com.example.skillsauditor;

public class ApplicationConstants {

    // Error messages
    public static String POSTCODE_ERROR_MSG_EMPTY = "Postcode cannot be empty";
    public static String STREET_NAME_ERROR_MSG_EMPTY = "Street name cannot be empty";
    public static String HOUSE_NUMBER_ERROR_MSG_EMPTY = "House number cannot be empty";
    public static String FIRST_NAME_ERROR_MSG_EMPTY = "First name cannot be empty";
    public static String FIRST_NAME_ERROR_MSG_REGEX = "First name is not in a valid format";
    public static String SURNAME_ERROR_MSG_EMPTY = "Surname cannot be empty";
    public static String SURNAME_ERROR_MSG_REGEX = "Surname is not in a valid format";

    // Regex patterns
    public static String FULL_NAME_REGEX_PATTERN = "/^[a-z ,.'-]+$/i";

}
