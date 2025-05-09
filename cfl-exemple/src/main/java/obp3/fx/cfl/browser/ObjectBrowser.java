package obp3.fx.cfl.browser;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import obp3.cfl.model.Epsilon;
import obp3.cfl.model.Product;
import obp3.fx.objectbrowser.ObjectViewContainer;
import obp3.fx.objectbrowser.ObjectViewFactory;
import obp3.fx.objectbrowser.api.ObjectView;

public class ObjectBrowser extends Application {
    private BorderPane root = new BorderPane();

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Object Browser");

        Object sample = new Product(new Product(new Epsilon(), new Epsilon()), new Epsilon());
//        ObjectViewFactory.register(Person.class, PersonView.class);
        ObjectView view = ObjectViewFactory.instance.createView(sample);
        root.setCenter(new ObjectViewContainer( sample ).getView());
//        root.setBottom(new ObjectViewContainer( new Point(2, 3)).getView());

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}