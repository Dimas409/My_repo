package ru.kuznetsov.springcource.FirstRestApp.util;

public class PersonNotCreatedException extends RuntimeException{
    public PersonNotCreatedException (String msg){
        super(msg);
    }
}
