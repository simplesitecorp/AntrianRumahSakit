/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import helper.pasienHelper;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pojos.Pasien;

/**
 * REST Web Service
 *
 * @author Bernadette Chrestella - bernadettechrestella@gmail.com
 */
@Path("pasien")
public class pasienResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of pasienResource
     */
    public pasienResource() {
    }

    /**
     * Retrieves representation of an instance of service.pasienResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public Response getJson() {
        pasienHelper helper = new pasienHelper();
        Gson g = new Gson();

        return Response.status(Response.Status.OK)
                .entity(g.toJson(helper.getAllPasien()))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods",
                        "GET,POST,HEAD,OPTIONS,PUT")
                .header("Access-Control-Allow-Headers",
                        "Content-Type,X-Requested-With,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers")
                .header("Access-Exposed-Headers",
                        "Access-Control-Allow-Origin,Access-Control-Allow-Credentials")
                .header("Access-Support-Credentials",
                        "true")
                .header("Access-Control-Max-Age", "20")
                .header("Access-Preflight-Maxage", "20")
                .build();
    }

    /**
     * PUT method for updating or creating an instance of pasienResource
     *
     * @param data
     * @return 
     */
//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void putJson(String content) {
//    }

    @POST
    @Path("addPasien")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewPasien(String data) {
        Gson gson = new Gson();
        Pasien pasien = gson.fromJson(data, Pasien.class);
        pasienHelper helper = new pasienHelper();
        helper.addNewPasien(
                pasien.getUserNamePsn(),
                pasien.getPasswordPsn(),
                pasien.getNikPsn(),
                pasien.getNamaPsn(),
                pasien.getAlamatPsn(),
                pasien.getTelpPsn(),
                pasien.getEmailPsn());
        return Response
                .status(200)
                .entity(pasien)
                .build();
    }

    @GET
    @Path("login1")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@QueryParam("userNamePsn") String userNamePsn, @QueryParam("passwordPsn") String passwordPsn) {
        return new Gson().toJson(new pasienHelper().login1(userNamePsn, passwordPsn));
    }
}
