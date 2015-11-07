package all.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class HibernateListener
 *
 */
@WebListener
public class HibernateListener implements ServletContextListener {

   
    public void contextDestroyed(ServletContextEvent sce)  { 
    	HibernateUtil.getSessionFactory().close();
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	HibernateUtil.getSessionFactory();
    }
	
}
