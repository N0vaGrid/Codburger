package com.n0vagrid.codburger.item;

import com.n0vagrid.codburger.CodBurger;
// Item：Minecraft 中“物品”的基础类
import net.minecraft.core.registries.Registries;
// Item：Minecraft 中“物品”的基础类
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

// IEventBus：事件总线，用来把注册动作“挂”到正确的时机
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
// DeferredRegister：NeoForge 提供的“延迟注册工具”
import net.neoforged.neoforge.registries.DeferredRegister;

/*
 * 这是一个“物品注册器”
 *
 * 它现在不会立刻创建任何物品
 * 只是告诉 NeoForge：
 * “等到合适的时候，我要往 ITEM 注册表里加东西”
 */
public class ModItems {

    public static final DeferredRegister.Items ITEMS =      // 我要注册的是【物品】
            DeferredRegister.createItems(CodBurger.MOD_ID);  // 使用你的模组ID作为命名空间

    //注册物品
    public static final DeferredItem<Item> COD_BURGER =
            ITEMS.register("codburger",
                    ()->new Item(
                            new Item.Properties()
                                    .food(
                                            new FoodProperties.Builder()
                                                    .nutrition(8)
                                                    .saturationModifier(1.0f)
                                                    .build()
                                    )
                    )
            );
    public static final DeferredItem<Item> LETTUCE_LEAF =
            ITEMS.register("lettuce_leaf",
                    ()->new Item(new Item.Properties())
            );

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
