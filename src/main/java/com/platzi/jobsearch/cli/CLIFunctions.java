package com.platzi.jobsearch.cli;

import java.util.HashMap;
import java.util.Map;

public class CLIFunctions {

    /**Esta funcion nos devuelve un mapa de
     * string a objeto
     */
    public static Map<String, Object> toMap(CLIArguments cliArguments){

        Map<String, Object> params = new HashMap<>();

        params.put("description", cliArguments.getKeyWord());
        params.put("location", cliArguments.getLocation());
        params.put("full-time", cliArguments.isFullTime());
        params.put("page", cliArguments.getPage());

        if (cliArguments.isMarkDown()){
            params.put("markdown", true);
        }

        return params;
    }
}
