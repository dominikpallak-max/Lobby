package pl.askalki;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;

public class AskalkiClient implements ClientModInitializer {

    private static final KeyBinding.Category CATEGORY =
            KeyBinding.Category.create(Identifier.of("askalki", "general"));

    private static KeyBinding openScreenKey;

    @Override
    public void onInitializeClient() {
        openScreenKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.askalki.open",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_R,
                CATEGORY
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (openScreenKey.wasPressed()) {
                if (client.player != null) {
                    client.player.sendMessage(Text.literal("Askalki: wciśnięto R"), false);
                }
            }
        });
    }
}
