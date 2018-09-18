package com.giroux.kevin.dofustuff.network;

import com.netflix.discovery.shared.Application;
import com.netflix.eureka.EurekaServerContextHolder;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for listing all applications.
 *
 * @author Kévin Girou
 */
@RestController
@RequestMapping("/applications")
@CrossOrigin("*")
public class EurekaWebService {

  /**
   * Retrieve all application id that are connected to registry.
   *
   * @return list of application.
   */
  @GetMapping(name = "Get all application",
              produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Application> getApplication() {
    return EurekaServerContextHolder.getInstance().getServerContext().getRegistry().getSortedApplications();

  }
}
