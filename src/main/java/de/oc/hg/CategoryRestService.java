package de.oc.hg;

import com.google.gson.Gson;
import jdk.nashorn.internal.parser.JSONParser;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Named
@RequestScoped
@Path("/api")
public class CategoryRestService {

    @Inject
    private CategoryDemo categoryDemo;

    @GET
    @Consumes("text/plain")
    @Produces("text/plain")
    @Path("categories")
    public String getCategories() {
        return "Gefundene Kategorien: " + categoryDemo.getCategoriesSize();
    }

    @GET
    @Consumes("text/plain")
    @Produces("application/json")
    @Path("categoriesjson")
    public Response getCategoriesJson() {

        JsonBeispiel ex = new JsonBeispiel();
        ex.kategorien = categoryDemo.getCategoriesSize().toString();
        ex.lagermeister = "Thomas Behrendt";

        Gson gson = new Gson();
        String result = gson.toJson(ex);
        return Response.status(201).entity(result).build();
    }

    private class JsonBeispiel {
        public String kategorien;
        public String lagermeister;
    }
}
