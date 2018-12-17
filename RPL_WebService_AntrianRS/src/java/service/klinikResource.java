/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import helper.klinikHelper;
import java.text.ParseException;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pojos.Klinik;

/**
 * REST Web Service
 *
 * @author Bernadette Chrestella - bernadettechrestella@gmail.com
 */
@Path("klinik")
public class klinikResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of klinikResource
     */
    public klinikResource() {
    }

    /**
     * Retrieves representation of an instance of service.klinikResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        klinikHelper helper = new klinikHelper();
        Gson g = new Gson();

        return Response.status(Response.Status.OK)
                .entity(g.toJson(helper.getAllKlinik()))
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
     * PUT method for updating or creating an instance of klinikResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

    @POST
    @Path("addKlinik")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewKlinik(String data) {
        Gson gson = new Gson();
        Klinik klinik = gson.fromJson(data, Klinik.class);
        klinikHelper helper = new klinikHelper();
        helper.addNewKlinik(
                klinik.getIdKlinik(),
                klinik.getNamaKlinik(),
                klinik.getNamaRs(),
                klinik.getLimitAntrian());
        return Response
                .status(200)
                .entity(klinik)
                .build();
    }
    
    @GET
    @Path("cariKlinik")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson(@QueryParam("namaKlinik") String namaKlinik, @QueryParam("namaRs") String namaRs) throws ParseException {
        klinikHelper helper = new klinikHelper();
        List<Klinik> list = helper.searchKlinik(namaKlinik, namaRs);
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return Response.status(200)
                .entity(json)
                .build();
    }
    
    @GET
    @Path("cariDaftarKlinik")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson(@QueryParam("namaRs") String namaRs) throws ParseException {
        klinikHelper helper = new klinikHelper();
        List<Klinik> list = helper.searchKlinik2(namaRs);
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return Response.status(200)
                .entity(json)
                .build();
    }
}
