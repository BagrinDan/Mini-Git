package org.example.core;

import org.example.commands.GitCommand;

public sealed interface ValidationResult {
    record Success(GitCommand commandName, String[] args) implements ValidationResult {}
    record Error(String message) implements ValidationResult {}
}
