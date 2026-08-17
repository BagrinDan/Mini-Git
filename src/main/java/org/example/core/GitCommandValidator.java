package org.example.core;

import java.util.Map;

public interface GitCommandValidator {
    ValidationResult validateCommand(String userInput);
}
