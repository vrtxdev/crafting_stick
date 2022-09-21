package eu.vortexdev.crafting_stick;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainCraftingStick implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("craftingstick");
	public static final CraftingStick CRAFTING_STICK = new CraftingStick(new FabricItemSettings().maxCount(1));

	public static final ItemGroup CRAFTING_STICK_GROUP = FabricItemGroupBuilder.create(
			new Identifier("craftingstick", "general"))
			.icon(() -> new ItemStack(CRAFTING_STICK))
			.appendItems(stacks -> {
				stacks.add(new ItemStack(CRAFTING_STICK));
			})
			.build();

	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier("craftingstick", "crafting_stick"), CRAFTING_STICK);
	}
}
