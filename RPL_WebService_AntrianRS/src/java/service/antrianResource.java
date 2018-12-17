/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import helper.antrianHelper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
import pojos.Antrian;

/**
 * REST Web Service
 *
 * @author Bernadette Chrestella - bernadettechrestella@gmail.com
 */
@Path("antrian")
public class antrianResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of antrianResource
     */
    public antrianResource() {
    }

    /**
     * Retrieves representation of an instance of service.antrianResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        antrianHelper helper = new antrianHelper();
        Gson g = new Gson();

        return Response.status(Response.Status.OK)
                .entity(g.toJson(helper.getAllAntrian()))
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
     * PUT method for updating or creating an instance of antrianResource
     * @param content representation for the resource
     */
//    @PUT
//    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
//    public void putJson(String content) {
//    }
    
    @POST
    @Path("addAntrian")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewAntrian(String data) {
        Gson gson = new Gson();
        Antrian antrian = gson.fromJson(data, Antrian.class);
        antrianHelper helper = new antrianHelper();
        helper.addNewAntrian(antrian.getNamaPsn(), antrian.getNamaRs(), antrian.getNamaKlinik(), antrian.getTanggal(), antrian.getNomorAntrian());
        return Response
                .status(200)
                .entity(antrian)
                .build();
    }
    
    @POST
    @Path("addNomorAntrian")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNomorAntrian(String data) {
        Gson gson = new Gson();
        Antrian antrian = gson.fromJson(data, Antrian.class);
        antrianHelper helper = new antrianHelper();
        helper.addNomorAntrian(antrian.getNamaRs(), antrian.getNamaKlinik(), antrian.getTanggal());
        return Response
                .status(200)
                .entity(antrian)
                .build();
    }
    
    @GET
    @Path("cariAntrian")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson(@QueryParam("namaRs") String namaRs,
            @QueryParam("namaKlinik") String namaKlinik, @QueryParam("tanggal") String tanggal) throws ParseException {
        antrianHelper helper = new antrianHelper();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Date date;
        date = format.parse(tanggal);
        List<Antrian> list = helper.searchAntrian(namaRs, namaKlinik, date);
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return Response.status(200)
                .entity(json)
                .build();
    }
    
    @GET
    @Path("cariDaftarAntrian")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson1(@QueryParam("namaRs") String namaRs) throws ParseException {
        antrianHelper helper = new antrianHelper();
        List<Antrian> list = helper.searchDaftarAntrian(namaRs);
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return Response.status(200)
                .entity(json)
                .build();
    }
    
    @GET
    @Path("cariDaftarAntrianSpesifik")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson2(@QueryParam("namaRs") String namaRs, @QueryParam("namaKlinik") String namaKlinik) throws ParseException {
        antrianHelper helper = new antrianHelper();
        List<Antrian> list = helper.searchDaftarAntrianSpesifik(namaRs, namaKlinik);
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return Response.status(200)
                .entity(json)
                .build();
    }
}
