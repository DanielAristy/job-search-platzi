package com.platzi.jobsearch.api;

import com.platzi.jobsearch.JobPosition;
import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;

import java.awt.*;
import java.util.List;
import java.util.Map;

/**Base de las peticiones que vamos hacer con feign*/
/**Cabeceras que se van a mandar en nuestras peticiones
 * y acepta este tipo de dato json que nos va a devolver el API*/

@Headers("Accept: application/json")
public interface APIJobs {


    /**Como debe hacer la peticion web*/
    @RequestLine("GET /positions.json")
    List<JobPosition> jobs(@QueryMap Map<String, Object> queryMap);
    /**Mapa de los objetos que iran dentro nuestra peticion*/

}
