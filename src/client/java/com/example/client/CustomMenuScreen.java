package com.example.mod.client;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class CustomMenuScreen extends Screen {

    public CustomMenuScreen() {
        super(Text.literal("§6§lDONUT SMP §e§lQUICK ACTIONS")); 
    }

    @Override
    protected void init() {
        int btnWidth = 130;
        int btnHeight = 20;
        int spacingX = 8;
        int spacingY = 8;
        
        int totalRowWidth = (btnWidth * 3) + (spacingX * 2);
        int startX = (this.width - totalRowWidth) / 2;
        int startY = (this.height / 2) - 45;

        // ROW 1: Main Core Systems
        this.addDrawableChild(ButtonWidget.builder(Text.literal("§b🏡 Homes Menu"), b -> sendCmd("homes"))
            .dimensions(startX, startY, btnWidth, btnHeight).build());

        this.addDrawableChild(ButtonWidget.builder(Text.literal("§e⚖ Auction House (AH)"), b -> sendCmd("ah"))
            .dimensions(startX + btnWidth + spacingX, startY, btnWidth, btnHeight).build());

        this.addDrawableChild(ButtonWidget.builder(Text.literal("§a👥 Friends List"), b -> sendCmd("friends"))
            .dimensions(startX + (btnWidth * 2) + (spacingX * 2), startY, btnWidth, btnHeight).build());

        // ROW 2: Economy & Trading
        int row2Y = startY + btnHeight + spacingY;
        this.addDrawableChild(ButtonWidget.builder(Text.literal("§6📦 Market Orders"), b -> sendCmd("orders"))
            .dimensions(startX, row2Y, btnWidth, btnHeight).build());

        this.addDrawableChild(ButtonWidget.builder(Text.literal("§2💰 Sell Items"), b -> sendCmd("sell"))
            .dimensions(startX + btnWidth + spacingX, row2Y, btnWidth, btnHeight).build());

        this.addDrawableChild(ButtonWidget.builder(Text.literal("§d💸 Pay Player"), b -> sendCmd("pay"))
            .dimensions(startX + (btnWidth * 2) + (spacingX * 2), row2Y, btnWidth, btnHeight).build());

        // ROW 3: Navigation & Analytics
        int row3Y = row2Y + btnHeight + spacingY;
        this.addDrawableChild(ButtonWidget.builder(Text.literal("§c🚀 Random TP (RTP)"), b -> sendCmd("rtp"))
            .dimensions(startX, row3Y, btnWidth, btnHeight).build());

        this.addDrawableChild(ButtonWidget.builder(Text.literal("§9📊 Player Stats"), b -> sendCmd("stats"))
            .dimensions(startX + btnWidth + spacingX, row3Y, btnWidth, btnHeight).build());

        this.addDrawableChild(ButtonWidget.builder(Text.literal("§5🏆 Leaderboards"), b -> sendCmd("leaderboards"))
            .dimensions(startX + (btnWidth * 2) + (spacingX * 2), row3Y, btnWidth, btnHeight).build());

        // ROW 4: Settings
        int row4Y = row3Y + btnHeight + spacingY;
        int centerButtonX = (this.width - btnWidth) / 2;
        this.addDrawableChild(ButtonWidget.builder(Text.literal("§7⚙ Server Settings"), b -> sendCmd("settings"))
            .dimensions(centerButtonX, row4Y, btnWidth, btnHeight).build());
    }

    private void sendCmd(String command) {
        if (this.client.player != null) {
            this.client.player.networkHandler.sendCommand(command);
            this.client.setScreen(null); 
        }
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}