package com.mrbysco.enhancedfarming.init;

import com.google.common.collect.Sets;
import net.minecraftforge.common.ToolAction;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FarmingActions {
	public static final ToolAction RAKE_GATHER = ToolAction.get("rake_gather");
	public static final Set<ToolAction> DEFAULT_RAKE_ACTIONS = Stream.of(RAKE_GATHER).collect(Collectors.toCollection(Sets::newIdentityHashSet));
}
