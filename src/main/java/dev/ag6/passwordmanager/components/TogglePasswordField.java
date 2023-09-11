package dev.ag6.passwordmanager.components;

import io.github.palexdev.materialfx.font.FontResources;
import io.github.palexdev.materialfx.font.MFXFontIcon;
import javafx.beans.binding.DoubleBinding;
import javafx.geometry.Insets;
import javafx.scene.control.Skin;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.skin.TextFieldSkin;

public class TogglePasswordField extends TextField {
    @Override
    protected Skin<?> createDefaultSkin() {
        return new TogglePasswordFieldSkin(this);
    }

    private static class TogglePasswordFieldSkin extends TextFieldSkin {
        private static final char BULLET = '●';
        private final ToggleButton showButton;

        public TogglePasswordFieldSkin(TogglePasswordField control) {
            super(control);

            control.setPadding(new Insets(4, 25.0, 4, 7));

            this.showButton = new ToggleButton();
            this.showButton.setGraphic(new MFXFontIcon(FontResources.EYE_SLASH.getDescription()));
            this.showButton.setFocusTraversable(false);
            this.showButton.setMaxSize(15, 15);
            this.showButton.setMinSize(15, 15);
            this.showButton.setPadding(new Insets(0));
            this.showButton.selectedProperty().addListener((obs, old, newVal) -> {
                String txt = control.getText();
                int pos = control.getCaretPosition();
                control.setText(null);
                control.setText(txt);
                control.positionCaret(pos);
            });

            this.showButton.translateXProperty().bind(new DoubleBinding() {
                {
                    bind(control.widthProperty(), control.widthProperty());
                }

                @Override
                protected double computeValue() {
                    return (control.getWidth() - showButton.getWidth()) / 2;
                }
            });
            getChildren().add(showButton);
        }

        @Override
        protected String maskText(String txt) {
            if (showButton != null && !showButton.isSelected()) {
                int len = txt.length();
                return String.valueOf(BULLET).repeat(len);
            } else {
                return txt;
            }
        }
    }
}
