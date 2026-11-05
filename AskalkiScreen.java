package pl.askalki;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class AskalkiScreen extends Screen {

    public AskalkiScreen(Text title) {
        super(title);
    }

    @Override
    protected void init() {
        super.init();

        this.addDrawableChild(ButtonWidget.builder(
                Text.literal("Stan: " + (AskalkiConfig.isEnabled() ? "Włączony" : "Wyłączony")),
                button -> {
                    AskalkiConfig.setEnabled(!AskalkiConfig.isEnabled());
                    button.setMessage(Text.literal("Stan: " + (AskalkiConfig.isEnabled() ? "Włączony" : "Wyłączony")));
                })
                .dimensions(this.width / 2 - 100, this.height / 2 - 20, 200, 20)
                .build());

        this.addDrawableChild(ButtonWidget.builder(
                Text.literal("Zamknij"),
                button -> this.close())
                .dimensions(this.width / 2 - 100, this.height / 2 + 10, 200, 20)
                .build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, this.height / 2 - 50, 0xFFFFFFFF);
        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
