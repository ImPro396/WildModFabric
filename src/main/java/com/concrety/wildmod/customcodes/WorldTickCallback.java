package com.concrety.wildmod.customcodes;


import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.world.World;

@Deprecated
public interface WorldTickCallback {
    @Deprecated
    Event<WorldTickCallback> EVENT = EventFactory.createArrayBacked(WorldTickCallback.class,
            (listeners) -> {
                if (EventFactory.isProfilingEnabled()) {
                    return (world) -> {
                        world.getProfiler().push("fabricWorldTick");

                        for (WorldTickCallback event : listeners) {
                            world.getProfiler().push(EventFactory.getHandlerName(event));
                            event.tick(world);
                            world.getProfiler().pop();
                        }

                        world.getProfiler().pop();
                    };
                } else {
                    return (world) -> {
                        for (WorldTickCallback event : listeners) {
                            event.tick(world);
                        }
                    };
                }
            }
    );

    void tick(World world);
}