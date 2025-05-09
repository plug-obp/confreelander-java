package obp3.fx.cfl;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import obp3.cfl.model.Product;
import obp3.fx.objectbrowser.ObjectViewContainer;
import obp3.fx.objectbrowser.api.ObjectView;
import obp3.fx.objectbrowser.api.ObjectViewFor;

@ObjectViewFor(Product.class)
public class ProductViewDetailed implements ObjectView {
    HBox box = new HBox();
    StackPane stackPane = new StackPane();

    public ProductViewDetailed() {


    }

    @Override
    public String getName() {
        return " Detailed concatenation ";
    }

    @Override
    public Node getView() {
        return stackPane;
    }

    @Override
    public void setObject(Object object) {
        if (object instanceof Product p) {
            Region spacer = new Region();
            HBox.setHgrow(spacer, Priority.ALWAYS);
            var lhs = new ObjectViewContainer(p.lhs).getView();
            var rhs = new ObjectViewContainer(p.rhs).getView();

            box.getChildren().addAll(lhs, spacer, rhs);
            stackPane.getChildren().add(box);

            Pane overlay = new Pane();
            Line line = new Line();
            line.setStroke(Color.BLUE);
            line.setStrokeWidth(2);

            // Arrowhead
            Polygon arrowHead = new Polygon();
            arrowHead.setFill(Color.BLUE);

            overlay.getChildren().addAll(line, arrowHead);
            overlay.setMouseTransparent(true);
            stackPane.getChildren().add(overlay);

            stackPane.layoutBoundsProperty().addListener((observable, oldValue, newValue) -> {
                double startX = lhs.localToScene(lhs.getBoundsInParent().getWidth(), lhs.getBoundsInParent().getHeight() / 2).getX() - stackPane.localToScene(0, 0).getX();
                double startY = lhs.localToScene(lhs.getBoundsInParent().getWidth(), lhs.getBoundsInParent().getHeight() / 2).getY() - stackPane.localToScene(0, 0).getY();

                double endX = rhs.localToScene(0, rhs.getBoundsInParent().getHeight() / 2).getX() - stackPane.localToScene(0, 0).getX();
                double endY = rhs.localToScene(0, rhs.getBoundsInParent().getHeight() / 2).getY() - stackPane.localToScene(0, 0).getY();
                System.out.println(startX + " " + startY + " " + endX + " " + endY);

                line.setStartX(startX);
                line.setStartY(startY);
                line.setEndX(endX);
                line.setEndY(endY);
                stackPane.layout();
            });
            box.setMaxWidth(400);
            stackPane.setMaxWidth(400);
        }
    }
}
