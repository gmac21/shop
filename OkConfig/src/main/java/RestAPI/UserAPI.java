package RestAPI;

import dao.*;
import entity.*;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/api")
public class UserAPI {


  private UserDao userDao = new UserDao();



    @GET
    @Path(value="/hello")
    @Produces(value={"application/json"})
    public String Hello(){
        return "Hello World";
    }



    @GET
    @Path(value="/getAllUsers")
    @Produces(value={"application/json"})
    public List<User> getUsers() {

        List<User> resultList = userDao.findAll();
       return resultList;
    }

//    @GET
//    @Path(value="/getAllHorses")
//    @Produces(value={"application/json"})
//    public List<Horse> getAllHorses() {
//
//        List<Horse> horseList = horseDAO.findAll();
//        return horseList;
//    }
//
//    @GET
//    @Path(value="/getAllTrainers")
//    @Produces(value={"application/xml"})
//    public List<Trainer> getAllTrainers() {
//
//        List<Trainer> trainerList = trainerDAO.findAll();
//        return trainerList;
//    }
//
//    @GET
//    @Path(value="/getAllRaces")
//    @Produces(value={"application/json"})
//    public List<Race> getAllRaces() {
//
//        List<Race> raceList = raceDAO.findAll();
//        return raceList;
//    }
//
//    @GET
//    @Path(value="/getAllUsers")
//    @Produces(value={"application/json"})
//    public List<User> getAllUsers() {
//
//        List<User> userList = userDAO.findAll();
//        return userList;
//    }
//
//    @GET
//    @Path(value="/getAllForm")
//    @Produces(value={"application/json"})
//    public List<Form> getAllForm() {
//
//        List<Form> formList = formDao.findAll();
//        return formList;
//    }
//
//    @GET
//    @Path(value="/getAllProfile")
//    @Produces(value={"application/json"})
//    public List<RaceProfile> getAllProfile() {
//
//        List<RaceProfile> rp = raceProfileDAO.findAll();
//        return rp;
//    }
//
//
//
//
//
//    @GET
//    @Path(value="/hello")
//    @Produces(value={"application/json"})
//    public String Hello(){
//        return "Hello World";
//    }
//
//
//

}
