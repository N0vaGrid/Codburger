package com.n0vagrid.codburger.item;

import com.n0vagrid.codburger.CodBurger;
import com.n0vagrid.codburger.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CodBurger.MOD_ID);

    public static final Supplier<CreativeModeTab> CODBURGER_TAB =
            CREATIVE_MODE_TABS.register("codburger_tab",() -> CreativeModeTab.builder()
            .icon(()-> new ItemStack(ModItems.COD_BURGER.get()))
            .title(Component.translatable("itemGroup.codburger_tab"))
            .displayItems((parameters, output) -> {
                output.accept(ModItems.COD_BURGER);
                output.accept(ModBlocks.CHEESE_BLOCK);
            })
            .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
