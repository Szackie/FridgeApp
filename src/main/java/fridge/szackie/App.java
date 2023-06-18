package fridge.szackie;

import fridge.szackie.fridge.FridgeRepository;
import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.plus.webapp.EnvConfiguration;
import org.eclipse.jetty.plus.webapp.PlusConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.component.LifeCycle;
import org.eclipse.jetty.webapp.*;

public class App {

    private static FridgeRepository fridgeRepository = new FridgeRepository();

    public static void main(String[] args) throws Exception {

        fridgeRepository.deleteUnusedFridge();

        var webapp = new WebAppContext();
        webapp.setResourceBase("src/main/webapp");
        webapp.setContextPath("/");
        webapp.setInitParameter("org.eclipse.jetty.servlet.Default.maxCachedFiles", "0");
        webapp.setConfigurations(new Configuration[]
                {
                        new AnnotationConfiguration(),
                        new WebInfConfiguration(),
                        new WebXmlConfiguration(),
                        new MetaInfConfiguration(),
                        new FragmentConfiguration(),
                        new EnvConfiguration(),
                        new PlusConfiguration(),
                        new JettyWebXmlConfiguration()
                });
        webapp.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern", ".*/classes/.*");

//        webapp.addServlet(HelloServlet.class,"/api/*");
        var server = new Server(8080);
        server.setHandler(webapp);
        server.addLifeCycleListener(new LifeCycle.Listener() {
            @Override
            public void lifeCycleStopped(LifeCycle event) {
                HibernateUtil.close();
            }
        });

        server.start();

        server.join();


    }
}