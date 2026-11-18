package baseclient.gg.dhyeybg.baseclient.module.misc;

import baseclient.gg.dhyeybg.baseclient.module.Category;
import baseclient.gg.dhyeybg.baseclient.module.Module;

public class Coordinates extends Module {
    public Coordinates() {
        super("Coordinates", "Displays your current position", Category.MISC);
        this.visible = false;
    }

    @Override
    public void onRender2D() {
        if (mc.player == null) return;
        String coords = String.format("XYZ: %.1f / %.1f / %.1f", mc.player.posX, mc.player.posY, mc.player.posZ);
        mc.fontRendererObj.drawStringWithShadow(coords, 4, 14, 0xFFFFFFFF);
    }
}
