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

    @Override
    public  TypedActionResult<ItemStack> use (World world, PlayerEntity player, Hand hand){

        if(Screen.hasShiftDown()) {
            remoteMode(player, hand);
        } else {
            //Item use function
        }

        return super.use(world, player, hand);
    }

    private boolean Mode = true;

    private void remoteMode(PlayerEntity player, Hand hand){
        if((hand == Hand.MAIN_HAND) && Screen.hasShiftDown() && Mode){
            Mode = false;
            player.sendMessage(Text.literal("Detonate Mode").formatted(Formatting.RED));
        } else if ((hand == Hand.MAIN_HAND) && Screen.hasShiftDown() && !Mode) {
            Mode = true;
            player.sendMessage(Text.literal("Prime Mode").formatted(Formatting.DARK_GREEN));
        }
    }

    private void remoteUse(PlayerEntity player, Hand hand, ){
        //use item
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {

        if(Mode){
            if(Screen.hasShiftDown()) {
                tooltip.add(Text.literal("Right Click on TNT to prime it (max 16).").formatted(Formatting.AQUA));
            } else {
                tooltip.add(Text.literal("Prime mode.Press Shift for more info!").formatted(Formatting.YELLOW));
            }
        } else {
            if(Screen.hasShiftDown()) {
                tooltip.add(Text.literal("Right Click to detonate all primed TNT.").formatted(Formatting.AQUA));
            } else {
                tooltip.add(Text.literal("Detonate mode.Press Shift for more info!").formatted(Formatting.YELLOW));
            }
        }

        super.appendTooltip(stack, world, tooltip, context);
    }


}
