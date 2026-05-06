package cx.rain.mc.vanillacream.util;

import cx.rain.mc.vanillacream.VanillaCream;
import net.minecraft.resources.Identifier;

public class IdentifierHelper {
    public static Identifier mcLoc(String path) {
        return Identifier.withDefaultNamespace(path);
    }

    public static Identifier modLoc(String path) {
        return Identifier.fromNamespaceAndPath(VanillaCream.MOD_ID, path);
    }
}
