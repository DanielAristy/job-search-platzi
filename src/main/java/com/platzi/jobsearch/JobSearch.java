package com.platzi.jobsearch;

import com.beust.jcommander.JCommander;
import com.platzi.jobsearch.api.APIJobs;
import com.platzi.jobsearch.cli.CLIArguments;
import com.platzi.jobsearch.cli.CLIFunctions;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static com.platzi.jobsearch.CommanderFunction.buildCommanderWithName;
import static com.platzi.jobsearch.CommanderFunction.parseArguments;
import static com.platzi.jobsearch.api.APIFunction.buildAPI;

public class JobSearch {
    public static void main(String[] args) {

        JCommander jCommander = buildCommanderWithName(
                "job-search", CLIArguments::newInstance);

        /**Recibir los argumentos de JCommander
         * que se nos dieron por terminal*/
        Stream<CLIArguments> streamOfCLI =
                parseArguments(jCommander, args, JCommander::usage)
                .orElse(Collections.emptyList())
                .stream()
                .map( obj -> (CLIArguments) obj);

        /**Obtener los argumentos que no sean el caso de ayuda
         * y obtener los argumentos que si se hayan puesto
         * una palabra clave para la busqueda*/
        Optional<CLIArguments> cliArgumentsOptional =
                streamOfCLI.filter( cli -> !cli.isHelp())
                .filter( cli -> cli.getKeyWord() != null)
                .findFirst();

        /**Convertir el Optional para mandarlo por la url*/

        cliArgumentsOptional.map(CLIFunctions::toMap)
                .map(JobSearch::executeRequest)
                .orElse(Stream.empty())
                .forEach(System.out::println);
    }

    private static Stream<JobPosition> executeRequest(Map<String, Object> params){
        APIJobs api = buildAPI(APIJobs.class, "https://jobs.github.com");

        return Stream.of(params)
                .map(api::jobs)
                .flatMap(Collection::stream);
    }
}
