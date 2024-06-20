package top.spco.spongefactory;

import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import top.spco.spongefactory.client.gui.MachineMagnetizerScreen;
import top.spco.spongefactory.infrastructure.data.SFDataGen;
import top.spco.spongefactory.infrastructure.init.CellModels;
import top.spco.spongefactory.infrastructure.init.CellUpgrades;
import top.spco.spongefactory.recipe.manager.SFRecipeManagers;
import top.spco.spongefactory.registries.*;

@Mod(SpongeFactory.MOD_ID)
public class SpongeFactory {
    public static final String MOD_ID = "spongefactory";
    public static final Logger LOGGER = LogUtils.getLogger();

    static {
        SFRecipeManagers.register();
    }

    public SpongeFactory() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        SFItems.register(modEventBus);
        SFBlocks.register(modEventBus);
        SFFluids.register(modEventBus);
        SFFluidTypes.register(modEventBus);
        SFGases.register(modEventBus);
        SFInfuseTypes.register(modEventBus);
        SFContainerTypes.register(modEventBus);
        SFMekContainerTypes.register(modEventBus);
        SFMekTileEntityTypes.register(modEventBus);
        SFMekRecipeType.register(modEventBus);
        SFBlockEntities.register(modEventBus);
        SFRecipeTypes.register(modEventBus);
        SFRecipeSerializers.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(EventPriority.LOWEST, SFDataGen::gatherData);

        MinecraftForge.EVENT_BUS.register(this);
    }

    public void postRegistrationInitialization() {
        CellUpgrades.init();
        CellModels.init();

        MenuScreens.register(SFContainerTypes.MAGNETIZER.get(), MachineMagnetizerScreen::new);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(this::postRegistrationInitialization).whenComplete((res, err) -> {
            if (err != null) {
                LOGGER.error(err.getLocalizedMessage());
            }
        });
    }

    public static ResourceLocation makeId(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
