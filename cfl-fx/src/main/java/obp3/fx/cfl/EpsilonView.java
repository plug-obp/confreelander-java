package obp3.fx.cfl;

import javafx.scene.Node;
import javafx.scene.control.Label;
import obp3.cfl.model.Epsilon;
import obp3.fx.objectbrowser.api.ObjectView;
import obp3.fx.objectbrowser.api.ObjectViewFor;

@ObjectViewFor(Epsilon.class)
public class EpsilonView implements ObjectView {
    Label nodeLabel = new Label();
    @Override
    public String getName() {
        return "Epsilon";
    }

    @Override
    public Node getView() {
        return nodeLabel;
    }

    @Override
    public void setObject(Object object) {
        if (object instanceof Epsilon) {
            nodeLabel.setText("ε");
            nodeLabel.setMaxWidth(50);
        }
    }
}
