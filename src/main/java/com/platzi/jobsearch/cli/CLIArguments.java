package com.platzi.jobsearch.cli;

import com.beust.jcommander.Parameter;

public class CLIArguments {

    CLIArguments(){

    }

    @Parameter(
            required = true,
            descriptionKey = "KEYWORD",
            validateWith = CLIKeyWordValidator.class,
            description = "KEYWORD"
    )

    private String keyWord;

    @Parameter(
            names = {"--location", "-l"},
            description = "Cada busqueda puede incluir una ubicacion"

    )
    private String location;

    @Parameter(
            names = {"--page","-p"},
            description = "La API devuelve 50 resultados, usa un numero para la pagina"
    )
    private int page = 0;

    @Parameter(
            names = {"--full-time"},
            description = "Agregar si queremos trabajos de tiempo completo"
    )
    private boolean isFullTime = false;

    @Parameter(
            names = {"--markdown"},
            description = "Obtener los resultado en markdown"
    )
    private boolean isMarkDown = false;

    @Parameter(
            names = {"--help"},
            help = true,
            validateWith = CLIHelpValidator.class,
            description = "Mostrar esta ayuda"
    )
    private boolean isHelp;

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public boolean isFullTime() {
        return isFullTime;
    }

    public void setFullTime(boolean fullTime) {
        isFullTime = fullTime;
    }

    public boolean isMarkDown() {
        return isMarkDown;
    }

    public void setMarkDown(boolean markDown) {
        isMarkDown = markDown;
    }

    public boolean isHelp() {
        return isHelp;
    }

    public void setHelp(boolean help) {
        isHelp = help;
    }

    @Override
    public String toString() {
        return "CLIArguments{" +
                "keyWord='" + keyWord + '\'' +
                ", location='" + location + '\'' +
                ", page=" + page +
                ", isFullTime=" + isFullTime +
                ", isMarkDown=" + isMarkDown +
                ", isHelp=" + isHelp +
                '}';
    }

    public static CLIArguments newInstance(){
        return new CLIArguments();
    }
}
