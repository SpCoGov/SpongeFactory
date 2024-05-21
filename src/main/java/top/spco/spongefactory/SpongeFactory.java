package top.spco.spongefactory;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import top.spco.spongefactory.infrastructure.data.SpongeFactoryDatagen;
import top.spco.spongefactory.registries.SpongeFactoryRecipeType;
import top.spco.spongefactory.registries.*;

@Mod(SpongeFactory.MOD_ID)
public class SpongeFactory {
    public static final String MOD_ID = "spongefactory";
    private static final Logger LOGGER = LogUtils.getLogger();

    public SpongeFactory() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        SpongeFactoryItems.register(modEventBus);
        SpongeFactoryBlocks.register(modEventBus);
        SpongeFactoryGases.register(modEventBus);
        SpongeFactoryContainerTypes.register(modEventBus);
        SpongeFactoryTileEntityTypes.register(modEventBus);
        SpongeFactoryRecipeType.register(modEventBus);
        SpongeFactoryRecipeSerializers.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(EventPriority.LOWEST, SpongeFactoryDatagen::gatherData);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }
}
