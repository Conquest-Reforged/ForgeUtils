package org.enginehub.util.forge;

import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import java.io.File;

@Mod(modid = ForgeUtils.MODID, name = "Forge Utils", version = "%VERSION%", acceptableRemoteVersions = "*")
@SuppressWarnings("ALL")
public class ForgeUtils {
    public static final String MODID = "forgeutils";

    @EventHandler
    public void init(FMLPostInitializationEvent event) {
        FMLLog.info("ForgeUtils loading.");

        try {
            (new BlockRegistryDumper(new File("blocks.json"))).run();
        } catch (Exception e) {
            FMLLog.severe("Error running block registry dumper: " +  e);
            e.printStackTrace();
        }
    }
}
