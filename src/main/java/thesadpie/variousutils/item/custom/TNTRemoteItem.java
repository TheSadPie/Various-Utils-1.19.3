package thesadpie.variousutils.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TNTRemoteItem extends Item {

    public TNTRemoteItem(Settings settings) {
        super(settings);
    }


    private boolean mode = true;

    private boolean remoteMode(PlayerEntity user, Hand hand){
        if((hand == Hand.MAIN_HAND) && Screen.hasShiftDown() && mode){
            mode = false;
            user.sendMessage(Text.literal("Detonate Mode").formatted(Formatting.RED));
        } else if ((hand == Hand.MAIN_HAND) && Screen.hasShiftDown() && !mode) {
            mode = true;
            user.sendMessage(Text.literal("Prime Mode").formatted(Formatting.DARK_GREEN));
        }
        return mode;
    }

    //Item Functions

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.literal("Right Click on TNT to prime it (max 16).").formatted(Formatting.AQUA));
        } else {
            tooltip.add(Text.literal("Press Shift for more info!").formatted(Formatting.YELLOW));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }


}
