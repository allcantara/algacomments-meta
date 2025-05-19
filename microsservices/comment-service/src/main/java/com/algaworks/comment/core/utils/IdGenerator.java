package com.algaworks.comment.core.utils;

import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedEpochRandomGenerator;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class IdGenerator {

    private static final TimeBasedEpochRandomGenerator timeBasedEpochRandomGenerator =
            Generators.timeBasedEpochRandomGenerator();

    public static UUID generateUUID() {
        return timeBasedEpochRandomGenerator.generate();
    }

}
