package eu.vortexdev.crafting_stick;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.CraftingScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import eu.vortexdev.crafting_stick.MainCraftingStick;

public class CraftingStick extends Item {
    private static final Text TITLE = new TranslatableText("item.craftingstick.crafting_stick");
    public CraftingStick(Settings settings) {
        super(settings);
    };

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        if (!world.isClient()) {
            playerEntity.openHandledScreen(new SimpleNamedScreenHandlerFactory(
                    (syncId, inventory, player)
                            -> new CraftingScreenHandler(syncId, inventory,
                            ScreenHandlerContext.EMPTY),
                    TITLE
            ));
            playerEntity.incrementStat(Stats.INTERACT_WITH_CRAFTING_TABLE);
            return TypedActionResult.consume(playerEntity.getStackInHand(hand));
        }
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}
