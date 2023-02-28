package org.example;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ProgrammingDetails {
    String programmerType();

    String programmerName();

    String dateOfWriting();

    String durationOfWriting();

    String[] reviewers();
}

