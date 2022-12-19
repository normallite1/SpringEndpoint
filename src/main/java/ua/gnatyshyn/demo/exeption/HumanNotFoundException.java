package ua.gnatyshyn.demo.exeption;

import org.springframework.data.crossstore.ChangeSetPersister;

public class HumanNotFoundException extends RuntimeException {

    public HumanNotFoundException(Long id) {
            super("Could not find human " + id);
        }
    }

