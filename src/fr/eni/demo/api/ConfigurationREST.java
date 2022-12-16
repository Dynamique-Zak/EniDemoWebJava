package fr.eni.demo.api;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;

import fr.eni.demo.bll.ManagerFactory;
import fr.eni.demo.bo.Article;

@ApplicationPath("/api/rest")
public class ConfigurationREST extends Application {

}
