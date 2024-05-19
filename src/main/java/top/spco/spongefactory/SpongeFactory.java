package top.spco.spongefactory;

import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import top.spco.spongefactory.infrastructure.data.Datagen;
import top.spco.spongefactory.registries.ModBlocks;
import top.spco.spongefactory.registries.ModGases;
import top.spco.spongefactory.registries.ModItems;
import top.spco.spongefactory.registries.ModTileEntityTypes;

@Mod(SpongeFactory.MOD_ID)
public class SpongeFactory {
    public static final String MOD_ID = "spongefactory";
    private static final Logger LOGGER = LogUtils.getLogger();

    public SpongeFactory() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModGases.register(modEventBus);
        ModTileEntityTypes.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(EventPriority.LOWEST, Datagen::gatherData);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}
