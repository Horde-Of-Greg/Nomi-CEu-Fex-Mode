package post.main.mod.ae2

import static gregtech.api.GTValues.*

import com.cleanroommc.groovyscript.helper.ingredient.OreDictIngredient
import com.nomiceu.nomilabs.util.LabsModeHelper
import net.minecraft.item.ItemStack

/* Usable Blocks */
// Early Items
// Charger
crafting.shapedBuilder()
    .output(item('appliedenergistics2:charger'))
    .matrix(
        'DCD',
        'D  ',
        'DCD')
    .key('D', LabsModeHelper.expert ? ore('plateBlackSteel') : ore('plateDarkSteel'))
    .key('C', metaitem('plateCertusQuartz'))
    .replace().register()

// Energy Acceptor
crafting.shapedBuilder()
    .output(item('appliedenergistics2:energy_acceptor'))
    .matrix(
        'PFP',
        'FHF',
        'PFP')
    .key('P', metaitem('nomilabs:plateElectricalSteel'))
    .key('F', item('moreplates:fluix_plate'))
    .key('H', metaitem('hull.lv'))
    .replace().register()

// Crystal Growth Chamber
crafting.shapedBuilder()
    .output(item('ae2stuff:grower'))
    .matrix(
        'FCF',
        'CHC',
        'FCF')
    .key('F', LabsModeHelper.expert ? ore('frameGtBlackSteel') : ore('frameGtDarkSteel'))
    .key('C', item('appliedenergistics2:material', 1))
    .key('H', metaitem('hull.lv'))
    .replace().register()

// ME Chest, buffed
crafting.shapedBuilder()
    .output(item('appliedenergistics2:chest'))
    .matrix(
        'GPG',
        'CSC',
        'DYD')
    .key('G', item('appliedenergistics2:quartz_glass'))
    .key('P', item('appliedenergistics2:part', 180))
    .key('C', item('appliedenergistics2:material', 23))
    .key('S', item('actuallyadditions:block_giant_chest'))
    .key('D', ore('blockDarkSteel'))
    .key('Y', item('appliedenergistics2:spatial_pylon'))
    .replace().register()

// ME Drive, buffed
crafting.shapedBuilder()
    .output(item('appliedenergistics2:drive'))
    .matrix(
        'EEE',
        'LCL',
        'SHS')
    .key('H', metaitem('hull.mv'))
    .key('E', metaitem('emitter.mv'))
    .key('L', ore('circuitMv'))
    .key('C', item('appliedenergistics2:chest'))
    .key('S', metaitem('sensor.mv'))
    .replace().register()

// ME Inscriber
crafting.shapedBuilder()
    .output(item('appliedenergistics2:inscriber'))
    .matrix(
        'DPD',
        'FHD',
        'DPD')
    .key('D', metaitem('nomilabs:plateDarkSteel'))
    .key('P', metaitem('electric.piston.mv'))
    .key('F', item('appliedenergistics2:material', 7))
    .key('H', metaitem('hull.mv'))
    .replace().register()

// Crafting CPU
crafting.shapedBuilder()
    .output(item('appliedenergistics2:crafting_unit'))
    .matrix(
        'PCP',
        'FLF',
        'PCP')
    .key('P', metaitem('plateAluminium'))
    .key('C', item('appliedenergistics2:material', 23))
    .key('F', item('appliedenergistics2:part', 16))
    .key('L', item('appliedenergistics2:material', 22))
    .replace().register()

// Molecular Assembler, buffed
crafting.shapedBuilder()
    .output(item('appliedenergistics2:molecular_assembler'))
    .matrix(
        'RGR',
        'ACF',
        'PGP')
    .key('R', metaitem('robot.arm.mv'))
    .key('G', item('appliedenergistics2:quartz_glass'))
    .key('P', metaitem('gearAluminium'))
    .key('A', item('appliedenergistics2:material', 44))
    .key('C', item('appliedenergistics2:crafting_unit'))
    .key('F', item('appliedenergistics2:material', 43))
    .replace().register()

// Matter Condensor
crafting.shapedBuilder()
    .output(item('appliedenergistics2:condenser'))
    .matrix(
        'PPP',
        'PSP',
        'PPP')
    .key('P', metaitem('plateTitanium'))
    .key('S', metaitem('quantumstar'))
    .replace().register()

// Quantum Ring
crafting.shapedBuilder()
    .output(item('appliedenergistics2:quantum_ring'))
    .matrix(
        'PCP',
        'EQE',
        'PCP')
    .key('P', metaitem('plateStainlessSteel'))
    .key('C', item('appliedenergistics2:material', 23))
    .key('E', item('appliedenergistics2:material', 24))
    .key('Q', metaitem('quantumstar'))
    .replace().register()

// Interfaces, buffed
var makeInterface = { String recipeName,
                      OreDictIngredient plate,
                      ItemStack moving,
                      ItemStack interfaceStack,
                      ItemStack superChestTank ->
    crafting.remove(recipeName)
    crafting.shapedBuilder()
        .output(interfaceStack)
        .matrix(
            'PRP',
            'AMF',
            'PPP')
        .key('P', plate)
        .key('R', moving)
        .key('A', item('appliedenergistics2:material', 44))
        .key('M', superChestTank)
        .key('F', item('appliedenergistics2:material', 43))
        .register()
}

// Interface
makeInterface('appliedenergistics2:network/blocks/interfaces_interface',
    ore('plateDoubleAluminium'),
    metaitem('robot.arm.mv'),
    item('appliedenergistics2:interface'),
    metaitem('super_chest.mv'))

// Fluid Interface
makeInterface('appliedenergistics2:network/blocks/fluid_interfaces_interface',
    ore('plateLapis'),
    metaitem('electric.pump.mv'),
    item('appliedenergistics2:fluid_interface'),
    metaitem('super_tank.mv'))

/* Cables */
// Quartz Fiber
crafting.removeByOutput(item('appliedenergistics2:part', 140))
mods.gregtech.wiremill.recipeBuilder()
    .inputs(item('appliedenergistics2:material', 11))
    .outputs(item('appliedenergistics2:part', 140) * 2)
    .duration(100).EUt(VHA[LV])
    .buildAndRegister()

// Glass Cable
crafting.remove('appliedenergistics2:network/cables/glass_fluix')
mods.gregtech.alloy_smelter.recipeBuilder()
    .inputs(ore('dustFluix'), item('appliedenergistics2:part', 140))
    .outputs(item('appliedenergistics2:part', 16) * 2)
    .duration(50).EUt(VHA[LV])
    .buildAndRegister()

// Covered Cable
crafting.remove('appliedenergistics2:network/cables/covered_fluix')
for (var rubber in [fluid('rubber') * 144, fluid('styrene_butadiene_rubber') * 36, fluid('silicone_rubber') * 72]) {
    mods.gregtech.assembler.recipeBuilder()
        .inputs(item('appliedenergistics2:part', 16))
        .fluidInputs(rubber)
        .outputs(item('appliedenergistics2:part', 36))
        .duration(100).EUt(VA[ULV])
        .buildAndRegister()
}

/* Block Parts */
/* Planes */
var makePlane = { OreDictIngredient plate, ItemStack core, ItemStack plane ->
    crafting.shapedBuilder()
        .output(plane)
        .matrix(
            'FFF',
            'PAP')
        .key('F', item('moreplates:fluix_plate'))
        .key('P', plate)
        .key('A', core)
        .replace().register()
}

// Formation Plane
makePlane(ore('plateAluminium'), item('appliedenergistics2:material', 43), item('appliedenergistics2:part', 320))

// Annihilation Plane
makePlane(ore('plateAluminium'), item('appliedenergistics2:material', 44), item('appliedenergistics2:part', 300))

// Fluid Formation Plane
makePlane(ore('plateLapis'), item('appliedenergistics2:material', 43), item('appliedenergistics2:part', 321))

// Fluid Annihilation Plane
makePlane(ore('plateLapis'), item('appliedenergistics2:material', 44), item('appliedenergistics2:part', 302))

/* Level Emitters */
var makeEmitter = { OreDictIngredient plate, ItemStack emitter ->
    crafting.shapedBuilder()
        .output(emitter)
        .matrix(
            'TP',
            'CR')
        .key('T', item('minecraft:redstone_torch'))
        .key('P', plate)
        .key('C', item('appliedenergistics2:material', 23))
        .key('R', ore('stickStainlessSteel'))
        .replace().register()
}

// Item Emitter
makeEmitter(ore('plateAluminium'), item('appliedenergistics2:part', 280))

// Fluid Emitter
makeEmitter(ore('plateLapis'), item('appliedenergistics2:part', 281))

/* Terminals */
// ME Terminal
crafting.shapelessBuilder()
    .output(item('appliedenergistics2:part', 380))
    .input(ore('itemIlluminatedPanel'))
    .input(ore('circuitLv'))
    .replace().register()

// Pattern Terminal
crafting.shapelessBuilder()
    .output(item('appliedenergistics2:part', 340))
    .input(item('appliedenergistics2:material', 24))
    .input(item('appliedenergistics2:part', 380))
    .input(item('appliedenergistics2:material', 52))
    .replace().register()

// Fluid Terminal
crafting.shapelessBuilder()
    .output(item('appliedenergistics2:part', 520))
    .input(item('appliedenergistics2:part', 380))
    .input(metaitem('plateLapis'))
    .input(item('appliedenergistics2:material', 22))
    .replace().register()

// Extended Processing Pattern Terminal
crafting.shapedBuilder()
    .output(item('appliedenergistics2:part', 341))
    .matrix(
        'A',
        'B',
        'C')
    .key('A', item('appliedenergistics2:part', 340))
    .key('B', ore('circuitEv'))
    .key('C', item('packagedauto:encoder'))
    .replace().register()

// Configuration Fluid Interface Terminal
crafting.shapelessBuilder()
    .output(item('appliedenergistics2:part', 522))
    .input(item('appliedenergistics2:part', 520))
    .input(item('appliedenergistics2:material', 24))
    .input(item('appliedenergistics2:fluid_interface') | item('appliedenergistics2:part', 441))
    .replace().register()

/* Buses */
var makeImportBus = { OreDictIngredient plate, ItemStack bus ->
    crafting.shapedBuilder()
        .output(bus)
        .matrix(
            ' A ',
            'PEP')
        .key('A', item('appliedenergistics2:material', 44))
        .key('P', plate)
        .key('E', metaitem('electric.piston.mv'))
        .replace().register()
}

var makeExportBus = { OreDictIngredient plate, ItemStack bus ->
    crafting.shapedBuilder()
        .output(bus)
        .matrix(
            'PEP',
            ' A ')
        .key('P', plate)
        .key('E', item('appliedenergistics2:material', 43))
        .key('A', metaitem('electric.piston.mv'))
        .replace().register()
}

// Import Bus
makeImportBus(ore('plateAluminium'), item('appliedenergistics2:part', 240))

// Fluid Import Bus
makeImportBus(ore('plateLapis'), item('appliedenergistics2:part', 241))

// Export Bus
makeExportBus(ore('plateAluminium'), item('appliedenergistics2:part', 260))

// Fluid Export Bus
makeExportBus(ore('plateLapis'), item('appliedenergistics2:part', 261))

// Storage Bus, buffed
var makeStorageBus = { String recipeName, ItemStack busType, ItemStack ifaceType, ItemStack comp ->
    crafting.remove(recipeName)
    crafting.shapedBuilder()
        .output(busType)
        .matrix(
            'C  ',
            'CIV',
            'C  ')
        .key('C', comp)
        .key('I', ifaceType)
        .key('V', item('appliedenergistics2:view_cell'))
        .register()
}

//Storage bus
makeStorageBus('appliedenergistics2:network/parts/storage_bus', item('appliedenergistics2:part', 220),
    item('appliedenergistics2:interface'), metaitem('electric.piston.mv'))

// Fluid Storage Bus
makeStorageBus('appliedenergistics2:network/parts/storage_bus_fluid', item('appliedenergistics2:part', 221),
    item('appliedenergistics2:fluid_interface'), metaitem('electric.pump.mv'))

// Oredict Storage Bus
crafting.shapelessBuilder()
    .output(item('appliedenergistics2:part', 222))
    .input(item('appliedenergistics2:part', 220), metaitem('ore_dictionary_filter'))
    .replace().register()

/* Misc Block Parts */
// P2P Tunnel engineering processor -> 2³ spatial component
crafting.shapedBuilder()
    .output(item('appliedenergistics2:part', 460))
    .matrix(
        ' P ',
        'PSP',
        'FFF')
    .key('P', metaitem('plateStainlessSteel'))
    .key('S', item('appliedenergistics2:material', 32))
    .key('F', ore('plateFluix'))
    .replace().register()

// Illuminated Panel
crafting.remove('appliedenergistics2:network/parts/panels_semi_dark_monitor')
crafting.shapedBuilder()
    .output(item('appliedenergistics2:part', 180))
    .matrix(
        'GGG',
        'PPP')
    .key('G', item('appliedenergistics2:quartz_glass'))
    .key('P', item('moreplates:fluix_plate'))
    .register()

// Cable Anchor
crafting.replaceShapeless(item('appliedenergistics2:part', 120), [ore('boltSteel')])

/* Misc Blocks */
// Vibrant Quartz Glass
crafting.removeByOutput(item('appliedenergistics2:quartz_vibrant_glass'))
mods.gregtech.alloy_smelter.recipeBuilder()
    .inputs(item('appliedenergistics2:quartz_glass'), ore('ingotVibrantAlloy'))
    .outputs(item('appliedenergistics2:quartz_vibrant_glass'))
    .duration(80).EUt(VHA[LV])
    .buildAndRegister()
