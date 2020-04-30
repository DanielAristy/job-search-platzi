package com.platzi.jobsearch.cli;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

/**Para validar que cuando el usuario pida ayuda
 * considere la ayuda y no se lance como si fuera
 * una opcion mas */
public class CLIHelpValidator implements IParameterValidator {

    @Override
    public void validate(String name, String value) throws ParameterException {
        boolean actualValue = Boolean.parseBoolean(value);

        if (actualValue){
            throw new ParameterException("Ayuda solicitada");
        }
    }
}
