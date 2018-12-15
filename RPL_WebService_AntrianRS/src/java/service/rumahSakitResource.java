/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import helper.rumahSakitHelper;
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
import pojos.RumahSakit;

/**
 * REST Web Service
 *
 * @author Bernadette Chrestella - bernadettechrestella@gmail.com
 */
@Path("rumahSakit")
public class rumahSakitResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of rumahSakitResource
     */
    public rumahSakitResource() {
    }

    /**
     * Retrieves representation of an instance of service.rumahSakitResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        rumahSakitHelper helper = new rumahSakitHelper();
        Gson g = new Gson();

        return Response.status(Response.Status.OK)
                .entity(g.toJson(helper.getAllRumahSakit()))
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
     * PUT method for updating or creating an instance of rumahSakitResource
     * @param data
     * @return 
     */
//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void putJson(String content) {
//    }
    
    @POST
    @Path("addRS")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewRumahSakit(String data) {
        Gson gson = new Gson();
        RumahSakit rs = gson.fromJson(data, RumahSakit.class);
        rumahSakitHelper helper = new rumahSakitHelper();
        helper.addNewRumahSakit(
                rs.getUserNameRs(),
                rs.getPasswordRs(),
                rs.getNamaRs(),
                rs.getAlamatRs(),
                rs.getTelpRs(),
                rs.getEmailRs());
        return Response
                .status(200)
                .entity(rs)
                .build();
}
    
    @GET
    @Path("login1")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@QueryParam("userNameRs") String userNameRs, @QueryParam("passwordRs") String passwordRs) {
        return new Gson().toJson(new rumahSakitHelper().login1(userNameRs, passwordRs));
}
}
