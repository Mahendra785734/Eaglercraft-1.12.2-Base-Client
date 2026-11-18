package baseclient.gg.dhyeybg.baseclient.Clickgui;

import java.io.IOException;
import java.util.ArrayList;

import baseclient.gg.dhyeybg.baseclient.Clickgui.component.Component;
import baseclient.gg.dhyeybg.baseclient.Clickgui.component.Frame;
import baseclient.gg.dhyeybg.baseclient.module.Category;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.Gui;

public class ClickGui extends GuiScreen {

	public static ArrayList<Frame> frames;
	public static int color = 0xCC171923;

	public ClickGui() {
		frames = new ArrayList<Frame>();
		int frameX = 5;
		for (Category category : Category.values()) {
			Frame frame = new Frame(category);
			frame.setX(frameX);
			frame.setY(30);
			frames.add(frame);
			frameX += frame.getWidth() + 1;
		}
	}

	@Override
	public void initGui() {
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		Gui.drawRect(0, 0, this.width, 24, 0xEE11131B);
		this.fontRendererObj.drawStringWithShadow("KYZXX", 9, 7, 0xFFBD62FF);
		this.fontRendererObj.drawStringWithShadow("CLIENT / MODULES", 55, 8, 0xFFFFFFFF);
		this.fontRendererObj.drawStringWithShadow("RIGHT SHIFT: CLOSE  |  LEFT CLICK: TOGGLE / DRAG  |  RIGHT CLICK: COLLAPSE", 9, this.height - 12, 0xFFB7B9C5);
		for (Frame frame : frames) {
			frame.renderFrame(this.fontRendererObj);
			frame.updatePosition(mouseX, mouseY);
			for (Component comp : frame.getComponents()) {
				comp.updateComponent(mouseX, mouseY);
			}
		}
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		for (Frame frame : frames) {
			if (frame.isWithinHeader(mouseX, mouseY) && mouseButton == 0) {
				frame.setDrag(true);
				frame.dragX = mouseX - frame.getX();
				frame.dragY = mouseY - frame.getY();
			}
			if (frame.isWithinHeader(mouseX, mouseY) && mouseButton == 1) {
				frame.setOpen(!frame.isOpen());
			}
			if (frame.isOpen()) {
				for (Component component : frame.getComponents()) {
					component.mouseClicked(mouseX, mouseY, mouseButton);
				}
			}
		}
	}

	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		for (Frame frame : frames) {
			if (frame.isOpen() && keyCode != 1) {
				for (Component component : frame.getComponents()) {
					component.keyTyped(typedChar, keyCode);
				}
			}
		}
		if (keyCode == 1 || keyCode == 54) {
			this.mc.displayGuiScreen(null);
		}
	}

	@Override
	protected void mouseReleased(int mouseX, int mouseY, int state) {
		for (Frame frame : frames) {
			frame.setDrag(false);
		}
		for (Frame frame : frames) {
			if (frame.isOpen()) {
				for (Component component : frame.getComponents()) {
					component.mouseReleased(mouseX, mouseY, state);
				}
			}
		}
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
}
