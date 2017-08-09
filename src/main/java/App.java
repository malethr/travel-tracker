import com.sun.org.apache.xpath.internal.operations.Mod;
import models.Travel;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

/**
 * Created by Guest on 8/9/17.
 */
public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        //get: show new post form
        get("/travels/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "newtravel-form.hbs");
        }, new HandlebarsTemplateEngine());

        //post: process new post form
        post("/travels/new",(req,res)->{
            Map<String, Object> model = new HashMap<String, Object>();
            String location = req.queryParams("location");
            Travel newTravel = new Travel(location);
            model.put("travel", newTravel);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show all posts
        get("/", (req,res) -> {
           Map<String, Object> model = new HashMap<>();
            ArrayList<Travel> travels = Travel.getAll();
            model.put("travels", travels);
           return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show an individual post
        get("/travels/:id", (req,res)->{
           Map<String, Object> model = new HashMap<>();
           int idOfTravelToFind = Integer.parseInt(req.params("id"));
           Travel foundTravel = Travel.findById(idOfTravelToFind);
           model.put("travel",foundTravel);
           return new ModelAndView(model, "travel-detail.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show a form to update a post

        //post: process a form to update a post

        //get: delete an individual post

        //get: delete all posts

    }
}
