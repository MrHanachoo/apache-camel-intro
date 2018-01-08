package sample.camel;

import org.apache.camel.builder.RouteBuilder;

public class MyRouterBuilder extends RouteBuilder  {

    public void configure() throws Exception {
        from("file:/tmp/input?move=./done")
                .process(new MyLogProcessor())
                .bean(new MyTransformer(), "TransformContent")
                .process(new MyLogProcessor())
                .to("file:/tmp/output");
    }
}
