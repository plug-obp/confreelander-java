import obp3.fx.cfl.EpsilonView;
import obp3.fx.cfl.ProductView;
import obp3.fx.cfl.ProductViewDetailed;
import obp3.fx.cfl.LanguageView;

module obp3.fx.cfl {
    requires javafx.controls;
    requires obp3.fx.objectbrowser.api;
    requires obp3.fx.objectbrowser;
    requires obp3.cfl.core;
    requires java.desktop;
    provides obp3.fx.objectbrowser.api.ObjectView with
            EpsilonView, ProductView, ProductViewDetailed, LanguageView;
    exports obp3.fx.cfl;
}