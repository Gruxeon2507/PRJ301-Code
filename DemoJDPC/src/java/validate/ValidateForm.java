package validate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nguyen Hoang Minh
 */
public class ValidateForm {
    public static boolean isValidName(String name) {
    // check if name is null or empty
    if (name == null || name.isEmpty()) {
        return false;
    }
    // check if name length is between 10 and 32 characters
    if (name.length() < 10 || name.length() > 32) {
        return false;
    }
    // check if name contains only alphabets a to z
    if (!name.matches("^[a-zA-Z ]+$")) {
        return false;
    }
    return true;
}
}
