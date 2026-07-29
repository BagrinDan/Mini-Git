package org.example.commands;

public class Commit implements GitCommand{
    @Override
    public void execute(String[] args) {
        System.out.println(args[0]);
    }
}
