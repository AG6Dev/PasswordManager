package dev.ag6.passwordmanager.view;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public abstract class View {
    public static void addDebugLines(Region region, Color color) {
        region.setBorder(new Border(new BorderStroke(color, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }

    public abstract Pane getRoot();
}
