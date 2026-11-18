package baseclient.gg.dhyeybg.baseclient.module.render;

import baseclient.gg.dhyeybg.baseclient.module.Category;
import baseclient.gg.dhyeybg.baseclient.module.Module;
import net.minecraft.client.Minecraft;

public class FPS extends Module {
    public FPS() {
        super("FPS", "Displays the current frame rate", Category.RENDER);
        this.visible = false;
    }

    @Override
    public void onRender2D() {
        String value = "FPS: " + Minecraft.getDebugFPS();
        mc.fontRendererObj.drawStringWithShadow(value, 4, 25, 0xFFFFFFFF);
    }
}
