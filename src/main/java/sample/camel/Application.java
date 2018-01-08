package sample.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class Application {

    public static void main(String[] args) {
        MyRouterBuilder routerBuilder = new MyRouterBuilder();
        CamelContext camelContext = new DefaultCamelContext();
        try {
            camelContext.addRoutes(routerBuilder);
            camelContext.start();
            System.out.println(">>> START CAMEL CONTEXT");
            Thread.sleep(5 * 60 * 1000);
            camelContext.stop();
            System.out.println(">>> END CAMEL CONTEXT");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
