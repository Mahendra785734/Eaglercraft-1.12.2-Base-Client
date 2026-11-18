package baseclient.gg.dhyeybg.baseclient.module.misc;

import baseclient.gg.dhyeybg.baseclient.module.Category;
import baseclient.gg.dhyeybg.baseclient.module.Module;

public class Direction extends Module {
    public Direction() {
        super("Direction", "Displays the direction you are facing", Category.MISC);
        this.visible = false;
    }

    @Override
    public void onRender2D() {
        if (mc.player == null) return;
        float yaw = mc.player.rotationYaw;
        String direction;
        if (yaw >= -45.0F && yaw < 45.0F) direction = "S";
        else if (yaw >= 45.0F && yaw < 135.0F) direction = "W";
        else if (yaw >= -135.0F && yaw < -45.0F) direction = "E";
        else direction = "N";
        mc.fontRendererObj.drawStringWithShadow("Facing: " + direction, 4, 36, 0xFFFFFFFF);
    }
}
