package obp3.fx.cfl;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import obp3.cfl.model.Product;
import obp3.fx.objectbrowser.api.ObjectView;
import obp3.fx.objectbrowser.api.ObjectViewFor;

@ObjectViewFor(Product.class)
public class ProductView implements ObjectView {
    HBox box = new HBox();
    Label lhs = new Label();
    Label rhs = new Label();

    public ProductView() {
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        box.getChildren().addAll(lhs, spacer, rhs);
    }

    @Override
    public String getName() {
        return " ∘ ";
    }

    @Override
    public Node getView() {
        return box;
    }

    @Override
    public void setObject(Object object) {
        if (object instanceof Product p) {
            lhs.setText(p.lhs.toString());
            rhs.setText(p.rhs.toString());
        }
    }
}
