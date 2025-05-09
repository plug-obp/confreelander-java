package obp3.fx.cfl;

import javafx.scene.Node;
import javafx.scene.control.Label;
import obp3.cfl.model.Language;
import obp3.fx.objectbrowser.api.ObjectView;
import obp3.fx.objectbrowser.api.ObjectViewFor;

@ObjectViewFor(Language.class)
public class LanguageView implements ObjectView {
    Label label = new Label();
    @Override
    public String getName() {
        return "Language view";
    }

    @Override
    public Node getView() {
        return label;
    }

    @Override
    public void setObject(Object object) {
        if (object instanceof Language language) {
            label.setText(language.toString());
        }
    }
}
