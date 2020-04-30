package com.platzi.jobsearch;

import com.beust.jcommander.JCommander;

import java.util.function.Supplier;

public class CommanderFunction {

    static <T> JCommander buildCommanderWithName(
            String cliName, Supplier<T> argumentsSupplier
    ){
        JCommander jCommander = JCommander.newBuilder()
                .addCommand(argumentsSupplier.get())
                .build();

        jCommander.setProgramName(cliName);

        return jCommander;
    }
}
