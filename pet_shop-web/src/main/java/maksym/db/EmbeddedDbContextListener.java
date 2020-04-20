package maksym.db;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class EmbeddedDbContextListener implements ServletContextListener {

    private PetShopEmbeddedDBManager embeddedDBManager = PetShopEmbeddedDBManager.getInstance();

    public void contextInitialized(ServletContextEvent event) {
        embeddedDBManager.start();
        embeddedDBManager.init();
    }

    public void contextDestroyed(ServletContextEvent event) {
        embeddedDBManager.stop();
    }
}
